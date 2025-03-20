package com.pepponechoi.cinema.screen.repository;

import com.pepponechoi.cinema.screen.entity.Screen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreenJpaRepository extends JpaRepository<Screen, Long>, ScreenRepository {

}
