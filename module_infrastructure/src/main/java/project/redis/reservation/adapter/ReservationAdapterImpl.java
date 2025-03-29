package project.redis.reservation.adapter;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import project.redis.reservation.Reservation;
import project.redis.reservation.entity.ReservationEntity;
import project.redis.reservation.mapper.ReservationMapper;
import project.redis.reservation.repository.ReservationRepository;

@Component
@RequiredArgsConstructor
public class ReservationAdapterImpl implements ReservationAdapter {

    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;

    @Override
    public List<Reservation> findAllReservationByScreeningId(Long screeningId) {
        List<ReservationEntity> reservationEntities
                = reservationRepository.findAllByScreening_ScreeningId(screeningId);

        return reservationEntities.stream()
                .map(reservationMapper::toDomain)
                .toList();
    }

    @Override
    public Long saveReservation(Reservation reservation) {
        // TODO : reservation 엔티티로 변환 후 저장 로직 필요
        return null;
    }

}
