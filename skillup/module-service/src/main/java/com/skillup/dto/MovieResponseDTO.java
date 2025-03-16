package com.skillup.service.dto;

import java.time.LocalDate;

import com.skillup.domain.MovieRating;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MovieResponseDTO {
    private Long no;
    private String name;
    private String thumnail;
    // private int runningtime;
    // private LocalDate release_date;
    // private MovieRating rating;
    // private String genre;
}