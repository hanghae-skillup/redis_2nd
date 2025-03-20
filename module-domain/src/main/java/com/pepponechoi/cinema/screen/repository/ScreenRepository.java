package com.pepponechoi.cinema.screen.repository;

import com.pepponechoi.cinema.screen.entity.Screen;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ScreenRepository {
    Screen save(Screen screen);

    Optional<Screen> findById(Long id);
    List<Screen> findAll();

    void deleteByIdIn(Collection<Long> ids);
}
