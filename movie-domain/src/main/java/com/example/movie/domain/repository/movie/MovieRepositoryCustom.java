package com.example.movie.domain.repository.movie;

import com.example.movie.domain.entity.Movie;
import java.util.List;

public interface MovieRepositoryCustom {

    List<Movie> findNowShowingMovies(Long theaterId);

}
