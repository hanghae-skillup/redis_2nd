package project.redis.seat.mapper;

import org.springframework.stereotype.Component;
import project.redis.seat.Seat;
import project.redis.seat.entity.SeatEntity;

@Component
public class SeatMapperImpl implements SeatMapper {

    @Override
    public Seat toDomain(SeatEntity seatEntity) {
        return Seat.of(seatEntity.getSeatId(), seatEntity.getSeatRow(), seatEntity.getSeatColumn());
    }

    @Override
    public SeatEntity toEntity(Seat seat) {

        // TODO : SeatEntity에 theater 필드 삭제 후 entity 변환 로직 구현
        return null;
    }
}
