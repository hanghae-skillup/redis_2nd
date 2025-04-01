package project.redis.user.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import project.redis.user.User;
import project.redis.user.entity.UserEntity;
import project.redis.user.mapper.UserMapper;
import project.redis.user.repository.UserRepository;

@Component
@RequiredArgsConstructor
public class UserAdapterImpl implements UserAdapter {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public User findUserById(Long userId) {
        UserEntity userEntity = userRepository.findById(userId).orElse(null);
        return userMapper.toDomain(userEntity);
    }
}
