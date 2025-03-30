package com.hanghae.theater;

import com.hanghae.common.entity.BaseEntity;
import com.hanghae.common.vo.PositiveNumber;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Screening extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    private Long movieId;

    @Column(nullable = false)
    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "value", column = @Column(name = "screen_number"))
    )
    private PositiveNumber screenNumber;

    @Embedded
    private ScreeningTime screeningTime;

    @Column(nullable = false)
    private int seatCount;

    @Embedded
    private Seats seats;

    public Screening(Long movieId, int screenNumber, ScreeningTime screeningTime) {
        this(null, movieId, new PositiveNumber(screenNumber), screeningTime, 0, null);
    }

    public Screening(Long id, Long movieId, PositiveNumber screenNumber, ScreeningTime screeningTime, int seatCount, Seats seats) {
        validate(seatCount);
        this.id = id;
        this.movieId = movieId;
        this.screenNumber = screenNumber;
        this.screeningTime = screeningTime;
        this.seatCount = seatCount;
        this.seats = seats;
    }

    private void validate(int seatCount) {
        if (seatCount < 0) {
            throw new IllegalArgumentException("좌석 수는 음수일 수 없습니다");
        }
    }

    public void createSeats(Seats seats) {
        this.seats = seats;
        this.seatCount = seats.count();
    }

    public void decreaseSeatCount() {
        if (seatCount == 0) {
            throw new IllegalStateException("남아있는 좌석의 수가 없습니다");
        }
        seatCount--;
    }

    public void decreaseSeatCount(int count){
        for (int i = 0; i < count; i++) {
            decreaseSeatCount();
        }
    }

    public boolean isBookingImpossible(int seatCount){
        return this.seatCount < seatCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Screening screening = (Screening) o;
        return Objects.equals(id, screening.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
