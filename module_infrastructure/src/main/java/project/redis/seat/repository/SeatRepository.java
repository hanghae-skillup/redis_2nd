package project.redis.seat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.redis.seat.entity.SeatEntity;

public interface SeatRepository extends JpaRepository<SeatEntity, Long> {
}
