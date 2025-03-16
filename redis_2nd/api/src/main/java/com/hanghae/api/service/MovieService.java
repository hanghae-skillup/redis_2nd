package com.hanghae.api.service;

import com.hanghae.api.dto.MovieResponseDto;

import java.util.List;


public interface MovieService {
    /**
     * 특정 날짜의 상영 중인 영화 목록 조회
     * @param date 조회날짜
     * @return 최근 개봉일 순으로 영화목록 제공
     */
    List<MovieResponseDto> getMovies();
}
