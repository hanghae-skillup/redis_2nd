package com.hanghae.booking;

import com.hanghae.booking.dto.BookScreeningRequest;
import com.hanghae.booking.dto.BookScreeningResponse;
import com.hanghae.event.Events;
import com.hanghae.lock.DistributedLock;
import com.hanghae.lock.DistributedLockManager;
import com.hanghae.theater.Screening;
import com.hanghae.theater.ScreeningRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Transactional
@Service
public class BookingService {

    private final BookingPolicy bookingPolicy;
    private final ScreeningRepository screeningRepository;
    private final BookingRepository bookingRepository;
    private final DistributedLockManager lockManager;

    public BookingService(BookingPolicy bookingPolicy, ScreeningRepository screeningRepository, BookingRepository bookingRepository, DistributedLockManager lockManager) {
        this.bookingPolicy = bookingPolicy;
        this.screeningRepository = screeningRepository;
        this.bookingRepository = bookingRepository;
        this.lockManager = lockManager;
    }

    @DistributedLock(name = "bookingScreening")
    public BookScreeningResponse bookScreening(BookScreeningRequest request) {
        this.bookingPolicy.checkBooking(request.getScreeningId(), request.getMemberId(), request.toSeats());

        Screening screening = screeningRepository.findById(request.getScreeningId())
                .orElseThrow(() -> new NoSuchElementException("상영이 존재하지 않습니다."));
        int seatCount = request.getBookingSeats().size();
        screening.decreaseSeatCount(seatCount);

        Booking booking = bookingRepository.save(request.toBooking());
        booking.addBookSeats(request.toBookingSeats());

        //예약 성공 이벤트 발생
        Events.raise(new BookScreeningSuccessEvent(request.getMemberId(), request.getScreeningId()));
        return BookScreeningResponse.from(booking);
    }

    public BookScreeningResponse bookScreeningByLock(BookScreeningRequest request) {
        this.bookingPolicy.checkBooking(request.getScreeningId(), request.getMemberId(), request.toSeats());

        Screening screening = screeningRepository.findById(request.getScreeningId())
                .orElseThrow(() -> new NoSuchElementException("상영이 존재하지 않습니다."));
        int seatCount = request.getBookingSeats().size();

        //함수형 분산락 적용 - 좌석 감소시만 락 적용되도록 범위 한정
        lockManager.executeWithLock("bookingScreening", () -> {
            screening.decreaseSeatCount(seatCount);
        });
        Booking booking = bookingRepository.save(request.toBooking());
        booking.addBookSeats(request.toBookingSeats());

        //예약 성공 이벤트 발생
        Events.raise(new BookScreeningSuccessEvent(request.getMemberId(), request.getScreeningId()));
        return BookScreeningResponse.from(booking);
    }
}
