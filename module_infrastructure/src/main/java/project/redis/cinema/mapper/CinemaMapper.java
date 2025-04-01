package project.redis.cinema.mapper;

import project.redis.cinema.Cinema;
import project.redis.cinema.entity.CinemaEntity;

public interface CinemaMapper {
    Cinema toDomain(CinemaEntity cinemaEntity);

    CinemaEntity toEntity(Cinema cinema);
}
