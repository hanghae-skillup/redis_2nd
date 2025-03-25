package com.redis.movie.application.convert;


import com.redis.movie.repository.dto.MoviesNowShowDto;
import com.redis.movie.application.dto.MoviesNowShowingDetail;
import com.redis.movie.application.dto.ScreenTime;
import com.redis.movie.application.dto.ScreenDetail;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
@NoArgsConstructor
public class DtoConvertor {
    public List<MoviesNowShowingDetail> moviesNowScreening(List<MoviesNowShowDto> dbResults) {
        return dbResults.stream()
                .collect(Collectors.groupingBy(MoviesNowShowDto::getMovieId))
                .entrySet().stream()
                .map(entry -> {
                    String movieId = entry.getKey();
                    List<MoviesNowShowDto> groupedByMovie = entry.getValue();


                    MoviesNowShowDto firstEntry = groupedByMovie.get(0);


                    List<ScreenDetail> ScreenDetails = groupedByMovie.stream()
                            .collect(Collectors.groupingBy(MoviesNowShowDto::getMovieId))
                            .entrySet().stream()
                            .map(theaterEntry -> {
                                String theaterId = theaterEntry.getKey();
                                String theaterName = theaterEntry.getValue().get(0).getTheaterNm();
                                List<ScreenTime> screeningTimes = theaterEntry.getValue().stream()
                                        .sorted(Comparator.comparing(MoviesNowShowDto::getTheaterMovieStartTm))
                                        .map(dto -> new ScreenTime(dto.getTheaterMovieStartTm(), dto.getTheaterMovieEndTm()))
                                        .toList();
                                return new ScreenDetail(theaterId, theaterName, screeningTimes);
                            })
                            .toList();

                    // Create the final DTO
                    return new MoviesNowShowingDetail(
                            movieId, // Add movieId here
                            firstEntry.getMovieNm(),
                            firstEntry.getGrade(),
                            firstEntry.getOpenDt(),
                            firstEntry.getImgNm(),
                            firstEntry.getImgPath(),
                            firstEntry.getGenreCd(),
                            firstEntry.getShowTm(),
                            firstEntry.getShowYn(),
                            firstEntry.getScreenShowYn(),
                            ScreenDetails
                    );
                })
                .toList();
    }
}
