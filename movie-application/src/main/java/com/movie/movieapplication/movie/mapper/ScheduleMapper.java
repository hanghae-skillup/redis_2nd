package com.movie.movieapplication.movie.mapper;

import com.movie.movieapplication.movie.domain.Schedule;
import com.movie.movieapplication.movie.entity.ScheduleEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ScheduleMapper {

    public static Schedule from(ScheduleEntity scheduleEntity) {
        return Schedule.of(
                scheduleEntity.getId(),
                scheduleEntity.getTheaterId(),  // TheaterEntity에서 ID만 사용
                scheduleEntity.getScreenId(),   // ScreenEntity에서 ID만 사용
                scheduleEntity.getMovieId(),    // MovieEntity에서 ID만 사용
                scheduleEntity.getStartTime(),
                scheduleEntity.getEndTime()
        );
    }

}
