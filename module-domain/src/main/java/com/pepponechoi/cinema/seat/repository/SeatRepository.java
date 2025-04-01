package com.pepponechoi.cinema.seat.repository;

import com.pepponechoi.cinema.seat.entity.Seat;
import jakarta.persistence.LockModeType;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Lock;

public interface SeatRepository {
    Seat save(Seat seat);

    Optional<Seat> findByScreenIdAndRowNoAndColumnNo(Long screenId, Character rowNo, Integer columnNo);
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Seat> findByScreenIdAndRowNoAndColumnNoAndReservationIsNull(Long screenId,
        Character rowNo,
        Integer columnNo);
    Integer countByReservation_UserIdAndReservation_ScheduleId(Long userId, Long scheduleId);
    Optional<Seat> findById(Long id);
    List<Seat> findAll();

    void deleteByIdIn(Collection<Long> ids);
}
