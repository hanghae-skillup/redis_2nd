package com.hanghae.module.persistence.mapper;

import com.hanghae.module.domain.model.Theater;
import com.hanghae.module.persistence.entity.TheaterEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TheaterMapper {

  /**
   * 극장 엔티티를 도메인 모델로 변환
   */
  Theater toDomain(TheaterEntity entity);

  /**
   * 극장 도메인 모델을 엔티티로 변환
   */
  TheaterEntity toEntity(Theater domain);

  /**
   * 극장 엔티티 리스트를 도메인 모델 리스트로 변환
   */
  List<Theater> toDomainList(List<TheaterEntity> entities);

  /**
   * 극장 도메인 모델 리스트를 엔티티 리스트로 변환
   */
  List<TheaterEntity> toEntityList(List<Theater> domains);
}
