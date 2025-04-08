package com.hanghae.module.persistence.repository.impl;

import com.hanghae.module.domain.model.Screening;
import com.hanghae.module.domain.repository.ScreeningRepository;
import com.hanghae.module.persistence.entity.ScreeningEntity;
import com.hanghae.module.persistence.mapper.ScreeningMapper;
import com.hanghae.module.persistence.repository.jpa.ScreeningJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ScreeningRepositoryImpl implements ScreeningRepository {
  private final ScreeningJpaRepository screeningJpaRepository;
  private final ScreeningMapper screeningMapper;
  @Override
  public Screening findById(Long id) {
    ScreeningEntity entity = screeningJpaRepository.findById(id)
      .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 상영 정보입니다."));
    return screeningMapper.toDomain(entity);
  }
}
