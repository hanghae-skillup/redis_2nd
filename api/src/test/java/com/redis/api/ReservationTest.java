package com.redis.api;

import com.redis.application.reservation.application.service.ReservationService;
import com.redis.domain.movie.entity.Grade;
import com.redis.domain.movie.entity.MovieInfo;
import com.redis.domain.movie.repository.MovieInfoRepository;
import com.redis.domain.movie.entity.Genre;
import com.redis.domain.reservation.entity.Reservation;
import com.redis.domain.reservation.repository.ReservationRepository;
import com.redis.domain.reservation.repository.ReservationSeatRepository;
import com.redis.domain.screen.entity.Screen;
import com.redis.domain.screen.repository.ScreenRepository;
import com.redis.domain.seat.entity.MovieSeat;
import com.redis.domain.seat.repository.MovieSeatRepository;
import com.redis.domain.user.entity.MovieUser;
import com.redis.domain.user.repository.MovieUserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@ActiveProfiles("test")
public class ReservationTest {


    @Autowired
    private ReservationService reservationService;

    @Autowired
    private MovieUserRepository movieUserRepository;

    @Autowired
    private ScreenRepository screenRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ReservationSeatRepository reservationSeatRepository;

    @Autowired
    private MovieSeatRepository movieSeatRepository;

    @Autowired
    private MovieInfoRepository movieInfoRepository;


    private MovieUser testMovieUser;
    private MovieInfo testMovieInfo;

    private Screen testScreen;


    private List<MovieSeat> testMovieSeats;

    @BeforeEach
    void setUp() {
        // 1. 테스트용 영화 생성
        testMovieInfo = movieInfoRepository.save(MovieInfo.builder()
                .movieNm("Movie1")
                .genreCd(Genre.SF)
                .openDate(LocalDateTime.now().minusDays(1))
                .showTimeMin(120).thumImg(1)
                .grade(Grade.FROM_12)
                .build()
        );

        // 2. 테스트용 회원 생성
        testMovieUser = movieUserRepository.save(MovieUser.builder()
                .userNm("user01")
                .email01("test789")
                .email02("naver.com")
                .phoneNum01(010)
                .phoneNum02(4567)
                .phoneNum03(3456)
                .build()
        );

        // 3. 테스트용 상영 정보 생성
        testScreen = screenRepository.save(Screen.builder()
                .movieInfo(testMovieInfo)
                .movieStartTime(LocalDateTime.now())
                .movieEndTime(LocalDateTime.now().plusHours(2))
                .build());

        // 5. 테스트용 좌석 생성
        testMovieSeats = movieSeatRepository.saveAll(Arrays.asList(
                MovieSeat.builder().seatRow("F").seatCol("1").screen(testScreen).build(),
                MovieSeat.builder().seatRow("F").seatCol("2").screen(testScreen).isReserved(false).build(),
                MovieSeat.builder().seatRow("F").seatCol("3").screen(testScreen).isReserved(false).build()
        ));
    }

    @AfterEach
    void cleanUp() {
        reservationSeatRepository.deleteAll();
        reservationRepository.deleteAll();
        movieSeatRepository.deleteAll();
        screenRepository.deleteAll();
        movieInfoRepository.deleteAll();
        movieUserRepository.deleteAll();
    }


    @Test
    @DisplayName("동시성 테스트")
    void reservationConcurrencyTest() throws InterruptedException {
        int threadCount = 100;

        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        CountDownLatch latch = new CountDownLatch(threadCount);


        for (int i = 0; i < threadCount; i++) {
            executor.execute(() -> {
                try {
                    reservationService.reserveMovie(testMovieUser.getUserId(), testScreen.getCinemaId(), testMovieSeats.stream().map(MovieSeat::getCinemaId).toList());
                } catch (Exception e) {
                    System.out.println("Thread: " + Thread.currentThread().getName() + " - " + e.getMessage());
                } finally {
                    latch.countDown();
                }
            });
        }

        latch.await();
        executor.shutdown();

        //좌석 체크 가능여부 검증
        List<MovieSeat> seats = movieSeatRepository.findAllById(testMovieSeats.stream().map(MovieSeat::getSeatId).toList());
        System.out.println("seat getFirst    "+ seats.getFirst() );

        Iterator<MovieSeat> iterator = seats.iterator();
        iterator.hasNext();
        while (iterator.hasNext()) {
            System.out.println("이터레이터 :   "+iterator.next().getIsReserved());


        }
        seats.forEach(seat -> equals(true));

        List<Reservation> reservations = reservationRepository.findAll();
        equals(reservations.size());
    }


}
