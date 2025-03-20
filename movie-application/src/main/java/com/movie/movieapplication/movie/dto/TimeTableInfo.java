package com.movie.movieapplication.movie.dto;

import com.movie.movieapplication.movie.domain.TimeTable;

import java.time.LocalDateTime;

public class TimeTableInfo {

    public record Get(LocalDateTime startDate, LocalDateTime endDate) {
        public static Get from(TimeTable timeTable) {
            return new Get(timeTable.getStartTime(), timeTable.getEndTime());
        }
    }

}
