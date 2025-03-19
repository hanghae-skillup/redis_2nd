package com.root.moviesite.position;

import com.root.moviesite.movie.Movie;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "position")
@Getter
@NoArgsConstructor
public class Position{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

//    @ManyToOne(optional = false)
//    @JoinTable(name = "movie_position",
//            joinColumns = @JoinColumn(name = "seat_number"),
//            inverseJoinColumns = @JoinColumn(name = "positions")
//    )
//    private Movie movie;

    @Column(name = "seat_number")
    private String seatNumber;
}
