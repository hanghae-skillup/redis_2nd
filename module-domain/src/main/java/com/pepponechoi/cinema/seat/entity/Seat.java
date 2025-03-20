package com.pepponechoi.cinema.seat.entity;


import com.pepponechoi.cinema.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.pepponechoi.cinema.screen.entity.Screen;

@Table(name = "seats")
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Seat extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_id")
    private Long id;

    @Column(nullable = false)
    private Character rowNo;

    @Column
    private Integer columnNo;

    @ManyToOne
    @JoinColumn(name = "screen_id")
    @Setter
    private Screen screen;

    protected Seat(Character rowNo, Integer columnNo, Screen screen, String createdBy) {
        this.rowNo = rowNo;
        this.columnNo = columnNo;
        this.screen = screen;
        this.setCreatedBy(createdBy);
    }

    public static Seat of(Character rowNo, Integer columnNo, Screen screen, String createdBy) {
        return new Seat(rowNo, columnNo, screen, createdBy);
    }
}
