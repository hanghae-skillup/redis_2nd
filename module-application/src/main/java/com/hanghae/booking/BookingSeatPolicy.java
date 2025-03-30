package com.hanghae.booking;

import com.hanghae.theater.Seat;
import com.hanghae.theater.SeatRepository;
import com.hanghae.theater.Seats;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/*
 * BookingSeatPolicy
 *
 * 좌석에 대한 예약 가능 여부를 검증하는 정책 클래스
 * 1. 좌석이 붙여져있는지? 즉 같은 행인지 확인한다
 * 2. 좌석 테이블에 존재하는 좌석인지?
 * 3. 한 사람당 5석 이하 예매됐는지 확인
 *  - 내가 이미 5석 이상 예매가 되었는지?
 *  - 이미 N석 예매가 되어있다면, 이번에 요청한 좌석의 수랑 합쳐서 5석이 넘지 않는지?
 * 4. 내가 예약 요청한 좌석이 이미 예약한 좌석인지?
 * */

@Component
@RequiredArgsConstructor
public class BookingSeatPolicy {

    private static final int MAX_BOOKING_LIMIT = 5;

    private final SeatRepository seatRepository;
    private final BookingSeatRepository bookingSeatRepository;

    public void validate(Long screeningId, Long memberId, Seats seats) {
        //좌석이 붙여져있는지?
        if (seats.isDifferentRow()) {
            throw new IllegalArgumentException("예약한 좌석이 붙여져 있지 않습니다");
        }

        List<Long> seatIds = seats.toIds();
        verifySeatExist(seatIds);
        checkBookingLimit(screeningId, memberId, seatIds);
        checkSeatAlreadyBooked(screeningId, seatIds);
    }

    private void verifySeatExist(List<Long> seatIds) {
        List<Seat> seats = seatRepository.findByIdIn(seatIds);
        if (seats.size() != seatIds.size()) {
            throw new IllegalStateException("해당 상영에 존재하지 않는 좌석입니다.");
        }
    }

    private void checkBookingLimit(Long screeningId, Long memberId, List<Long> seatsToBook) {
        //내가 이미 5석 이상 예매가 되었는지?
        List<BookingSeat> seats = bookingSeatRepository.findBy(screeningId, memberId);
        if (seats.size() >= MAX_BOOKING_LIMIT) {
            throw new IllegalStateException(String.format("한 사람당 최대 %d좌석 예매 가능합니다", MAX_BOOKING_LIMIT));
        }

        //이미 N석 예매가 되어있다면, 이번에 요청한 좌석의 수랑 합쳐서 5석이 넘지 않는지?
        int bookableSeatCount = MAX_BOOKING_LIMIT - seats.size();
        if(seatsToBook.size() > bookableSeatCount){
            throw new IllegalArgumentException(String.format("한 사람당 최대 %d석까지 예매 가능하며, 이미 %d석을 예매하셨기 때문에 %d석만 추가로 예약할 수 있습니다",
                    MAX_BOOKING_LIMIT, seats.size(), bookableSeatCount));
        }

    }

    private void checkSeatAlreadyBooked(Long screeningId, List<Long> seatIds) {
        List<BookingSeat> bookingSeats = bookingSeatRepository.findBy(screeningId, seatIds);
        if (!bookingSeats.isEmpty()) {
            throw new IllegalStateException("이미 예약된 좌석이 존재합니다. 다른 좌석을 선택하세요.");
        }
    }
}
