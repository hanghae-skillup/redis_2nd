package com.module.redis2nd.domain.movie.entity;

import com.module.redis2nd.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@Entity
@Table(name = "show_schedule")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder @Getter
public class ShowSchedule extends BaseEntity {
    private LocalTime startShowTime;

    @ManyToOne(targetEntity = Screening.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public static ShowSchedule createShowSchedule() {
        return ShowSchedule.builder()
                .build();
    }
}
