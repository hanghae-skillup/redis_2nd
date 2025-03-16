package com.movie.movieapplication.movie.dto;

import java.util.List;

public class ScheduleInfo {

    public record Get(
            Long id,
            TheaterInfo.Get theater,
            ScreenInfo.Get screen,
            MovieInfo.Get movie,
            List<TimeTableInfo.Get> timeTables
    ) {
        // 불필요한 정적 팩토리 메서드 제거
    }
}
