package com.hanghae.api.dto;

import com.hanghae.domain.Genre;
import com.hanghae.domain.Rating;

/**
 * 영화 정보 응답 DTO
 *
 * @param title        영화 제목
 * @param rating       영화 관람등급
 * @param releaseDate  영화 개봉일
 * @param thumbnailUrl 썸네일 이미지 URL
 * @param runningTime  러닝 타임(분)
 * @param genre        영화 장르
 */
public record MovieResponseDto(
        String id,
        String title,
        Rating rating,
        String releaseDate,
        String thumbnailUrl,
        int runningTime,
        Genre genre
) {
}