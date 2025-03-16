package com.movie.movieapplication.movie.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "schedule")
public class ScheduleEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long theaterId;
    @Column
    private Long screenId;
    @Column
    private Long movieId;
    @Column
    private LocalDateTime startTime;
    @Column
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
