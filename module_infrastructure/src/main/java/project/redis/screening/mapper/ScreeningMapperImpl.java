package project.redis.screening.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import project.redis.movie.Movie;
import project.redis.movie.mapper.MovieMapper;
import project.redis.screening.Screening;
import project.redis.screening.entity.ScreeningEntity;
import project.redis.theater.Theater;
import project.redis.theater.mapper.TheaterMapper;

@Component
@RequiredArgsConstructor
public class ScreeningMapperImpl implements ScreeningMapper {

    private final MovieMapper movieMapper;
    private final TheaterMapper theaterMapper;

    @Override
    public Screening toDomain(ScreeningEntity screeningEntity) {
        Movie movie = movieMapper.toDomain(screeningEntity.getMovie());
        Theater theater = theaterMapper.toDomain(screeningEntity.getTheater());
        return Screening.of(screeningEntity.getScreeningId(), movie, theater,
                screeningEntity.getStartedAt(), screeningEntity.getEndedAt());
    }

    @Override
    public ScreeningEntity toEntity(Screening screening) {
        // TODO : entity 변환 로직 구현 필요, theaterMapper 문제 해결 후
        return null;
    }
}
