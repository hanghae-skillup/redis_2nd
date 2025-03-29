package project.redis.user.mapper;

import project.redis.user.User;
import project.redis.user.entity.UserEntity;

public interface UserMapper {
    User toDomain(UserEntity userEntity);
}
