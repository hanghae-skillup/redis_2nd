package com.root.moviesite.movie;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Transactional
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie findById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

//    메인 페이지는 ‘개봉일’ 순서로 정렬되어야 합니다. 또한 시간표는 그림과 같이 시작시간이 빠른 것부터 정렬되어야 합니다.
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Transactional
    public void delete(Movie movie) {
        movieRepository.delete(movie);
    }
}