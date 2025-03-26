package com.hanghae.module.persistence.mapper;

import com.hanghae.module.domain.model.Movie;
import com.hanghae.module.persistence.entity.MovieEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {

  MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

  /**
   * 영화 엔티티를 도메인 모델로 변환
   */
  Movie toDomain(MovieEntity entity);

  /**
   * 영화 도메인 모델을 엔티티로 변환
   */
  MovieEntity toEntity(Movie domain);

  /**
   * 영화 엔티티 리스트를 도메인 모델 리스트로 변환
   */
  List<Movie> toDomainList(List<MovieEntity> entities);

  /**
   * 영화 도메인 모델 리스트를 엔티티 리스트로 변환
   */
  List<MovieEntity> toEntityList(List<Movie> domains);
}
