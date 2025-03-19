package com.module.redis2nd.domain.reservation.entity;

import com.module.redis2nd.domain.common.BaseEntity;
import com.module.redis2nd.domain.customer.entity.Customer;
import com.module.redis2nd.domain.movie.entity.Movie;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "reservation")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder @Getter
public class Reservation extends BaseEntity {
    private LocalDate reservationDate;
    private LocalTime reservationTime;
    private String seat;

    @ManyToOne(targetEntity = Customer.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(targetEntity = Movie.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id")
    private Movie movie;
}
