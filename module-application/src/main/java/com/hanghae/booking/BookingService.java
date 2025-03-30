package com.hanghae.booking;

import com.hanghae.booking.dto.BookScreeningRequest;
import com.hanghae.booking.dto.BookScreeningResponse;
import com.hanghae.lock.DistributedLock;
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

    public BookingService(BookingPolicy bookingPolicy, ScreeningRepository screeningRepository, BookingRepository bookingRepository) {
        this.bookingPolicy = bookingPolicy;
        this.screeningRepository = screeningRepository;
        this.bookingRepository = bookingRepository;
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

        return BookScreeningResponse.from(booking);
    }
}
