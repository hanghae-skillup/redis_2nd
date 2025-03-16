package com.hanghae.api.dto.mapper;

import com.hanghae.api.dto.MovieResponseDto;
import com.hanghae.domain.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MovieMapper {
    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    List<MovieResponseDto> toDto(List<Movie> movie);
}
