package com.root.moviesite.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Iterable<Long> id(Long id);
}
