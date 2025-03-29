package project.redis.theater.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import project.redis.cinema.Cinema;
import project.redis.cinema.entity.CinemaEntity;
import project.redis.cinema.mapper.CinemaMapper;
import project.redis.seat.mapper.SeatMapper;
import project.redis.theater.Theater;
import project.redis.theater.entity.TheaterEntity;

@Component
@RequiredArgsConstructor
public class TheaterMapperImpl implements TheaterMapper {

    private final SeatMapper seatMapper;
    private final CinemaMapper cinemaMapper;

    @Override
    public Theater toDomain(TheaterEntity theaterEntity) {
        CinemaEntity cinemaEntity = theaterEntity.getCinema();
        Cinema cinema = cinemaMapper.toDomain(cinemaEntity);

        return Theater.of(theaterEntity.getTheaterId(), theaterEntity.getTheaterName(), cinema);
    }

    @Override
    public TheaterEntity toEntity(Theater theater) {
        // TODO : TheaterEntity 수정 후 entity 변환 로직 구현 예정
        return null;
    }
}
