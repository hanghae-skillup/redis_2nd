package project.redis.reservation.mapper;

import project.redis.reservation.Reservation;
import project.redis.reservation.entity.ReservationEntity;
import project.redis.seat.entity.SeatEntity;

public interface ReservationMapper {
    Reservation toDomain(ReservationEntity reservationEntity);

    ReservationEntity toEntity(Reservation reservation, SeatEntity seatEntity);
}
