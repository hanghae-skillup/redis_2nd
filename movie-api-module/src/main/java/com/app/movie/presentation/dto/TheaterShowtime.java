package com.app.movie.presentation.dto;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class TheaterShowtime {

    private Long theaterId;
    private String theaterName;
    private List<LocalTime> startTime;
    private List<LocalTime> endTime;

    public TheaterShowtime(Long theaterId, String theaterName, List<LocalTime> startTime, int runningTime) {
        this.theaterId = theaterId;
        this.theaterName = theaterName;
        this.startTime = startTime;
        this.endTime = new ArrayList<>();
        this.setEndTime(runningTime);
    }

    private void setEndTime(int runningTime) {
        startTime.forEach(startTime -> {
            LocalTime newTime = startTime.plusMinutes(runningTime);
            endTime.add(newTime);
        });
    }

}
