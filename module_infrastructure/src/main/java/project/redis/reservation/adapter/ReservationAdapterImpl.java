package project.redis.reservation.adapter;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import project.redis.reservation.Reservation;
import project.redis.reservation.entity.ReservationEntity;
import project.redis.reservation.mapper.ReservationMapper;
import project.redis.reservation.repository.ReservationRepository;
import project.redis.seat.entity.SeatEntity;

@Component
@RequiredArgsConstructor
public class ReservationAdapterImpl implements ReservationAdapter {

    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;

    @Override
    @Transactional
    public List<Reservation> findAllReservationByScreeningId(Long screeningId) {
        List<ReservationEntity> reservationEntities
                = reservationRepository.findAllByScreening_ScreeningId(screeningId);

        return reservationEntities.stream()
                .map(reservationMapper::toDomain)
                .toList();
    }

    @Override
    public List<Reservation> findAllReservationByUserId(Long userId) {
        List<ReservationEntity> reservationEntities
                = reservationRepository.findAllByUser_UserId(userId);
        return reservationEntities.stream()
                .map(reservationMapper::toDomain)
                .toList();
    }

    @Override
    public Long saveReservation(Reservation reservation, SeatEntity seatEntity) {
        ReservationEntity reservationEntity = reservationMapper.toEntity(reservation, seatEntity);
        ReservationEntity savedReservation = reservationRepository.save(reservationEntity);
        return savedReservation.getReservationId();
    }

}
