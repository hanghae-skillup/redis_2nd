package com.hanghae.movie.query;

import com.hanghae.movie.dto.MovieScreeningDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MovieScreeningQueryService {

    private final MovieScreeningQueryRepository movieScreeningQueryRepository;

    public List<MovieScreeningDto> findShowingMovies() {
        return movieScreeningQueryRepository.findShowingMovies();
    }
}
