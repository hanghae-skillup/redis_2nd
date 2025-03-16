package com.hanghae.api.service;

import com.hanghae.api.dto.MovieResponseDto;
import com.hanghae.api.dto.mapper.MovieMapper;
import com.hanghae.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public List<MovieResponseDto> getMovies() {
        var movies = movieRepository.findAllByReleaseDateBefore();
        return MovieMapper.INSTANCE.toDto(movies);
    }
}
