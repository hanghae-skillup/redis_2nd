package com.hanghae.theater;

import com.hanghae.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Theater extends BaseEntity {

    private static final int DEFAULT_SEAT_ROW_SIZE = 5;
    private static final int DEFAULT_SEAT_COL_SIZE = 5;
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "theater_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_screening_to_theater")
    )
    private List<Screening> screenings = new ArrayList<>();

    public Theater(String name) {
        this(null, name);
    }

    public Theater(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addScreening(Screening screening) {
        Seats seats = Seats.create(DEFAULT_SEAT_ROW_SIZE, DEFAULT_SEAT_COL_SIZE);
        screening.createSeats(seats);
        screenings.add(screening);
    }

    public void addScreenings(List<Screening> screenings) {
        screenings.forEach(this::addScreening);
    }
}
