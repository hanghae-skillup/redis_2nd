package com.hanghae.booking;

import com.hanghae.theater.Seats;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/*
 * BookingPolicy
 *
 * 예약 유효성 체크하는 정책 클래스
 *
 * 상영 정책 클래스 screeningPolicy
 * 예약 좌석 정책 클래스 bookingSeatPolicy
 * 위 두 클래스롤 호출하여 예약 가능한지 검증한다
 * */

@Component
@RequiredArgsConstructor
public class BookingPolicy {
    private final ScreeningPolicy screeningPolicy;
    private final BookingSeatPolicy bookingSeatPolicy;

    public void checkBooking(Long screeningId, Long memberId, Seats seats) {
        screeningPolicy.validate(screeningId, seats.count());
        bookingSeatPolicy.validate(screeningId, memberId, seats);
    }
}
