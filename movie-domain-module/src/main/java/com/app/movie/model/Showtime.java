package com.app.movie.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Showtime {

    private Long id;
    private Theater theater;
    private Movie movie;
    private LocalTime startTime;
    private LocalTime endTime;

}
