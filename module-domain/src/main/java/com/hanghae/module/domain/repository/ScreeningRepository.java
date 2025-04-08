package com.hanghae.module.domain.repository;

import com.hanghae.module.domain.model.Screening;

public interface ScreeningRepository {
  Screening findById(Long id);
}
