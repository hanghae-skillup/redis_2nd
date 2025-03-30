package com.hanghae.theater;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaScreeningRepository extends ScreeningRepository, JpaRepository<Screening, Long> {
}
