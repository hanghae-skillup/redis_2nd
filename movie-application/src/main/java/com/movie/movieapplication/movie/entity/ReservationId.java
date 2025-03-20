package com.movie.movieapplication.movie.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Embeddable
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationId {

    @Column
    private Long scheduleId;
    @Column
    private Long seatId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof ReservationId ids)) return false;
        return Objects.equals(scheduleId, ids.scheduleId) && Objects.equals(seatId, ids.seatId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scheduleId, seatId);
    }

    public static ReservationId of(Long scheduleId, Long seatId) {
        return ReservationId.builder()
                .scheduleId(scheduleId)
                .seatId(seatId)
                .build();
    }

}
