package com.hanghae.module.persistence.repository.jpa;

import com.hanghae.module.persistence.entity.ScreeningEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreeningJpaRepository extends JpaRepository<ScreeningEntity, Long> {
}
