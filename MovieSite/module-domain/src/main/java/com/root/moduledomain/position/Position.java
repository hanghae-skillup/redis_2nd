package com.root.moduledomain.position;

import com.root.moduledomain.movie.Movie;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "position")
@Getter
@NoArgsConstructor
public class Position{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(optional = false)
    @JoinTable(name = "movie_position",
            joinColumns = @JoinColumn(name = "seat_number"),
            inverseJoinColumns = @JoinColumn(name = "position_id")
    )
    private Movie movie;

    @Column(name = "seat_number")
    private String seatNumber;
}
