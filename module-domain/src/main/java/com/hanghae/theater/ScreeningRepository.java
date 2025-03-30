package com.hanghae.theater;

import java.util.Optional;

public interface ScreeningRepository {
    Optional<Screening> findById(Long id);
}
