package com.pepponechoi.cinema.user.repository;

import com.pepponechoi.cinema.user.entity.User;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);
    <S extends User> List<S> saveAll(Iterable<S> users);
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);
    Optional<User> findByNickname(String nickname);

    List<User> findAll();

    void deleteByIdIn(Collection<Long> ids);
}
