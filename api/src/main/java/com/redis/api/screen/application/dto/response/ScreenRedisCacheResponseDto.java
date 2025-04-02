package com.redis.api.screen.application.dto.response;

import com.redis.api.screen.application.dto.ScreenDetail;
import com.redis.domain.movie.entity.Genre;
import com.redis.domain.movie.entity.Grade;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class ScreenRedisCacheResponseDto {
    private Long movieId;
    private String movieNm;
    private Grade grade;
    private LocalDateTime openDate;
    private String imgNm;
    private String imgPath;
    private Genre genreCd;
    private Integer showTimeMin;
    private Boolean showYn;
    private Boolean screenShowYn;

    List<ScreenDetail> screenDetail; //recode클래스는 생성자 자동생성
    private List<screenSchedule> screenSchedule; // 상영관별 시간표 리스트

    @Getter
    @AllArgsConstructor
    @Builder
    public static class screenSchedule {
        private String movieNm; //영화 이름
        private String cinemaNm;//영화관이름
        private List<Schedule> schedules; // 시간표

        @Getter
        @AllArgsConstructor
        public static class Schedule {
            private LocalDateTime movieStartTime; // 상영 시작 시간
            private LocalDateTime movieEndTime;   // 상영 종료 시간
        }
    }
}