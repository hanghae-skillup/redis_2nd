package com.app.movie.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Movie {

    private Long id;
    private String title;
    private String thumbnailURL;
    private LocalDate releaseDate;
    private int duration;
    private Genre genre;
    private Rating rating;

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Movie){
            return id.equals(((Movie)obj).getId());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
