package com.redis.movie.application.service;


import com.redis.movie.application.convert.DtoConvertor;
import com.redis.movie.application.dto.MoviesNowShowingDetail;
import com.redis.movie.entity.movie.Genre;
import com.redis.movie.repository.MovieRepository;
import com.redis.movie.repository.dto.MoviesNowShowDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    private final DtoConvertor dtoConvertor;

    public List<MoviesNowShowingDetail> getMoviesNowShowing(LocalDateTime now, String movieNm,Genre genre, String search) {
        List<MoviesNowShowDto> dbResults = movieRepository.findNowShowing(now, movieNm, genre);
        List<MoviesNowShowingDetail> detailsList = dtoConvertor.moviesNowScreening(dbResults);

        return detailsList.stream()
                .sorted(Comparator.comparing(MoviesNowShowingDetail::openDt))
                .toList();
    }

}