package com.pepponechoi.cinema.reservation.repository;

import com.pepponechoi.cinema.reservation.entity.Reservation;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ReservationRepository {
    Reservation save(Reservation reservation);

    Optional<Reservation> findById(Long id);
    List<Reservation> findAll();

    void deleteByIdIn(Collection<Long> ids);
}
