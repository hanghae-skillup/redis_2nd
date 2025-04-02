package com.redis.api.screen.application.convert;


import com.redis.domain.screen.dto.ScreenNowShowDto;
import com.redis.api.screen.application.dto.ScreenNowDetail;
import com.redis.api.screen.application.dto.ScreenTime;
import com.redis.api.screen.application.dto.ScreenDetail;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
@NoArgsConstructor
public class ScreenNowDetailDtoConvertor { //convert 말고 mapper라고 작성해도 되는듯?
    public List<ScreenNowDetail> moviesNowScreening(List<ScreenNowShowDto> dbResults) {
        return dbResults.stream()
                .collect(Collectors.groupingBy(ScreenNowShowDto::getMovieId))
                .entrySet().stream()
                .map(entry -> {
                    Long movieId = entry.getKey();
                    List<ScreenNowShowDto> groupedByMovie = entry.getValue();

                    ScreenNowShowDto firstEntry = groupedByMovie.get(0);
                    List<ScreenDetail> ScreenDetails = groupedByMovie.stream()
                            .collect(Collectors.groupingBy(ScreenNowShowDto::getMovieId))
                            .entrySet().stream()
                            .map(theaterEntry -> {
                                Long cinemaId = theaterEntry.getKey();
                                String cinemaNm = theaterEntry.getValue().get(0).getCinemaNm();
                                List<ScreenTime> screeningTimes = theaterEntry.getValue().stream()
                                        .sorted(Comparator.comparing(ScreenNowShowDto::getMovieStartTime))
                                        .map(dto -> new ScreenTime(dto.getMovieStartTime(), dto.getMovieEndTime()))
                                        .toList();
                                return new ScreenDetail(cinemaId, cinemaNm, screeningTimes);
                            })
                            .toList();

                    // Create the final DTO
                    return new ScreenNowDetail(
                            //현재 상영중인 시간표 출력 -> record ScreenNowDetail
                            movieId,
                            firstEntry.getMovieNm(),
                            firstEntry.getGrade(),
                            firstEntry.getOpenDate(),
                            firstEntry.getImgNm(),
                            firstEntry.getImgPath(),
                            firstEntry.getGenreCd(),
                            firstEntry.getShowTimeMin(),
                            firstEntry.getShowYn(),
                            firstEntry.getScreenShowYn(),
                            ScreenDetails
                    );
                })
                .toList();
    }

}
