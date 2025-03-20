package com.movie.movieapplication.movie.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "reservation")
public class ReservationEntity extends BaseEntity {

    @EmbeddedId
    private ReservationId id;

}
