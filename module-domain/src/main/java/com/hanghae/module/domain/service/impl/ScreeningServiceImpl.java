package com.hanghae.module.domain.service.impl;

import com.hanghae.module.domain.model.Screening;
import com.hanghae.module.domain.repository.ScreeningRepository;
import com.hanghae.module.domain.service.ScreeningService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ScreeningServiceImpl implements ScreeningService {

  private final ScreeningRepository screeningRepository;

  @Override
  public Screening findById(Long screeningId) {
    return screeningRepository.findById(screeningId);
  }
}
