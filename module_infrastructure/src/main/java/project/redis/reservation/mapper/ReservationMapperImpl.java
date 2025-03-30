package project.redis.reservation.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import project.redis.reservation.Reservation;
import project.redis.reservation.entity.ReservationEntity;
import project.redis.screening.Screening;
import project.redis.screening.entity.ScreeningEntity;
import project.redis.screening.mapper.ScreeningMapper;
import project.redis.seat.Seat;
import project.redis.seat.entity.SeatEntity;
import project.redis.seat.mapper.SeatMapper;
import project.redis.user.User;
import project.redis.user.entity.UserEntity;
import project.redis.user.mapper.UserMapper;

@Component
@RequiredArgsConstructor
public class ReservationMapperImpl implements ReservationMapper {

    private final ScreeningMapper screeningMapper;
    private final SeatMapper seatMapper;
    private final UserMapper userMapper;

    @Override
    public Reservation toDomain(ReservationEntity reservationEntity) {
        Seat seat = seatMapper.toDomain(reservationEntity.getSeat());
        Screening screening = screeningMapper.toDomain(reservationEntity.getScreening());
        User user = userMapper.toDomain(reservationEntity.getUser());
        return Reservation.create(reservationEntity.getReservationId(), seat, screening, user);
    }

    @Override
    public ReservationEntity toEntity(Reservation reservation, SeatEntity seatEntity) {
        ScreeningEntity screeningEntity = screeningMapper.toEntity(reservation.getScreening());
        UserEntity userEntity = userMapper.toEntity(reservation.getUser());

        return ReservationEntity.of(screeningEntity, seatEntity, userEntity);
    }
}
