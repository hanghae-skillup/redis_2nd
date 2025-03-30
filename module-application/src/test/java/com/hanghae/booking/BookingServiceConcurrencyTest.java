package com.hanghae.booking;

import com.hanghae.booking.dto.BookScreeningRequest;
import com.hanghae.booking.dto.SeatDto;
import com.hanghae.theater.Screening;
import com.hanghae.theater.ScreeningRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BookingServiceConcurrencyTest {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private ScreeningRepository screeningRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private BookingSeatRepository bookingSeatRepository;

    @DisplayName("동시에 5번, 동일한 좌석 5개씩을 예약한다")
    @Test
    void booking() throws InterruptedException {
        int threadCount = 5;
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        List<SeatDto> seats = List.of(
                new SeatDto(1L, 'A', 1),
                new SeatDto(2L, 'A', 2),
                new SeatDto(3L, 'A', 3),
                new SeatDto(4L, 'A', 4),
                new SeatDto(5L, 'A', 5)
        );

        BookScreeningRequest request = new BookScreeningRequest(1L, 1L, seats);

        for (int i = 0; i < threadCount; i++) {
            executorService.execute(() -> {
                try {
                    Thread.sleep(1000);
                    bookingService.bookScreeningByLock(request);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    countDownLatch.countDown();
                }
            });
        }

        countDownLatch.await();
        executorService.shutdown();

        Screening screening = screeningRepository.findById(1L)
                .orElseThrow(NoSuchElementException::new);
        List<Booking> bookings = bookingRepository.findByScreeningId(1L);

        List<BookingSeat> bookingSeat = bookingSeatRepository.findBy(1L);

        assertThat(screening.getSeatCount()).isEqualTo(20);
        assertThat(bookings).hasSize(1);
        assertThat(bookingSeat).hasSize(5);
    }

}