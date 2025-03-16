package org.bailey.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Getter
@Entity
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theater_id", nullable = false)
    private Theater theater;

    @OneToMany(mappedBy = "seat")
    private List<Booking> bookings;

    @Column(nullable = false)
    private String seatRow;

    @Column(nullable = false)
    private String seatColumn;

    @Column(nullable = false)
    private String seatNumber;
}
