package com.movie.movieapplication.movie.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "schedule")
public class ScheduleEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 외래키를 사용하는 대신 ID로 직접 연결
    private Long theaterId;
    private Long screenId;
    private Long movieId;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScheduleEntity scheduleEntity)) return false;
        return id != null && id.equals(scheduleEntity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
