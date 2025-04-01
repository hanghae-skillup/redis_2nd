package com.pepponechoi.cinema.movie.dto.request;

import com.pepponechoi.cinema.exception.valid.enums.EnumValid;
import com.pepponechoi.cinema.movie.dto.FindMovies;
import com.pepponechoi.cinema.movie.enums.Genre;

public record FindAllRequest(
        String title,
        @EnumValid(target = Genre.class, nullable = true)
        String genre
) {
    public FindMovies toFinds() {
        return new FindMovies(title, genre);
    }
}
