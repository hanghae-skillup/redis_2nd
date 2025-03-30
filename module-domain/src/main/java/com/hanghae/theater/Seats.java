package com.hanghae.theater;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@EqualsAndHashCode
@Embeddable
public class Seats {

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    @JoinColumn(
            name = "screening_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_screening_to_seat")
    )
    private List<Seat> seats = new ArrayList<>();

    public static Seats create(int rowSize, int colSize) {
        List<Seat> seats = new ArrayList<>();
        for (int row = 1; row <= rowSize; row++) {
            for (int col = 1; col <= colSize; col++) {
                seats.add(new Seat(row, col));
            }
        }
        return new Seats(seats);
    }

    protected Seats() {
    }

    public Seats(final List<Seat> seats) {
        this.seats = seats;
    }

    public boolean isSameRow() {
        return seats.stream()
                .map(Seat::getRow)
                .distinct()
                .count() == 1;
    }

    public boolean isDifferentRow() {
        return !isSameRow();
    }

    public List<Long> toIds(){
        return seats.stream()
                .map(Seat::getId)
                .toList();
    }

    public int count() {
        return seats.size();
    }
}
