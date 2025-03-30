package project.redis.seat.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import project.redis.seat.Seat;
import project.redis.seat.entity.SeatEntity;
import project.redis.seat.mapper.SeatMapper;
import project.redis.seat.repository.SeatRepository;

@Component
@RequiredArgsConstructor
public class SeatAdapterImpl implements SeatAdapter {

    private final SeatRepository seatRepository;
    private final SeatMapper seatMapper;

    @Override
    public SeatEntity saveSeat(Seat seat) {
        SeatEntity seatEntity = seatMapper.toEntity(seat);
        return seatRepository.save(seatEntity);
    }
}
