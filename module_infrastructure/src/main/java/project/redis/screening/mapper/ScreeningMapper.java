package project.redis.screening.mapper;

import project.redis.screening.Screening;
import project.redis.screening.entity.ScreeningEntity;

public interface ScreeningMapper {
    Screening toDomain(ScreeningEntity screeningEntity);
}
