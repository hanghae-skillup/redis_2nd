package com.redis.domain.user.repository;


import com.redis.domain.user.entity.MovieUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieUserRepository extends JpaRepository<MovieUser,Long> {
}
