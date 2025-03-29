package project.redis.reservation.mapper;

import project.redis.reservation.Reservation;
import project.redis.reservation.entity.ReservationEntity;

public interface ReservationMapper {
    Reservation toDomain(ReservationEntity reservationEntity);
}
