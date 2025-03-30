package com.hanghae.booking;


import com.hanghae.theater.Screening;
import com.hanghae.theater.ScreeningRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

/*
* ScreeningPolicy
*
* 상영에 대한 예약 가능 여부를 검증하는 정책 클래스
* Screening 테이블에 있는 좌석 수와 예약하고자 하는 좌석 수를 비교하여
* - Screening 좌석 수 >= 예약할 좌석 수 => 예약 가능
* - Screening 좌석 수 < 예약할 좌석 수 => 예약 불가, exception 발생
* */

@Component
@RequiredArgsConstructor
public class ScreeningPolicy {

    private final ScreeningRepository screeningRepository;

    public void validate(Long screeningId, int seatCount) {
        Screening screening = screeningRepository.findByIdWithPessimisticLock(screeningId)
                .orElseThrow(() -> new NoSuchElementException("상영이 존재하지 않습니다"));

        if (screening.isBookingImpossible(seatCount)) {
            throw new IllegalStateException("좌석이 부족합니다.");
        }
    }
}
