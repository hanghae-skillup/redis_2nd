package project.redis.reservation.repository;

import jakarta.persistence.LockModeType;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import project.redis.reservation.entity.ReservationEntity;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {
    //@Lock(LockModeType.PESSIMISTIC_WRITE)
    @Lock(LockModeType.OPTIMISTIC)
    List<ReservationEntity> findAllByScreening_ScreeningId(Long screeningId);

    List<ReservationEntity> findAllByUser_UserId(Long userId);
}
