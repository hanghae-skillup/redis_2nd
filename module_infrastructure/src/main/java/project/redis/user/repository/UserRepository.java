package project.redis.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.redis.user.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
