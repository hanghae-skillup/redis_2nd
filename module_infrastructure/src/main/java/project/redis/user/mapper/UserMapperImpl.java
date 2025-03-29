package project.redis.user.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import project.redis.user.User;
import project.redis.user.entity.UserEntity;

@Component
@RequiredArgsConstructor
public class UserMapperImpl implements UserMapper {
    @Override
    public User toDomain(UserEntity userEntity) {
        return User.of(userEntity.getUserId(), userEntity.getUsername());
    }
}
