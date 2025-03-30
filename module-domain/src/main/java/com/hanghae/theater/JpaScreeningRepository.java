package com.hanghae.theater;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface JpaScreeningRepository extends ScreeningRepository, JpaRepository<Screening, Long> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT s FROM Screening s WHERE s.id = :screeningId")
    @Override
    Optional<Screening> findByIdWithPessimisticLock(@Param("screeningId") Long screeningId);
}
