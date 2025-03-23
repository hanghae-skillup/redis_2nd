package com.hanghae.movie.query;

import com.hanghae.SearchCriteria;
import com.hanghae.common.enums.SearchMatchType;
import com.hanghae.movie.MovieGenre;
import com.hanghae.movie.MovieStatus;
import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Getter
@NoArgsConstructor
public class MovieScreeningSearchCondition {
    //private static final int MOVIE_TITLE_SIZE = 255;

    private SearchCriteria<String> movieName;
    private List<MovieGenre> genre;
    private List<MovieStatus> status;
    private boolean isReleaseDateAsc;

    public MovieScreeningSearchCondition(SearchCriteria<String> movieName, List<MovieGenre> genre, List<MovieStatus> status, boolean isReleaseDateAsc) {
        this.movieName = movieName;
        this.genre = genre;
        this.status = status;
        this.isReleaseDateAsc = isReleaseDateAsc;
    }

    /*@AssertTrue
    public boolean isValidTitleSize() {
        return movieName.getValue().length() <= MOVIE_TITLE_SIZE;
    }*/

    public String getMovieNameValue() {
        return movieName.getValue();
    }

    public SearchMatchType getMovieNameSearchType() {
        return movieName.getType();
    }
}
