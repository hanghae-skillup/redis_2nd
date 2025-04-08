package com.hanghae.module.persistence.mapper;

import com.hanghae.module.domain.model.Screening;
import com.hanghae.module.persistence.entity.ScreeningEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface ScreeningMapper {

  /**
   * 상영 엔티티를 도메인 모델로 변환
   */
  Screening toDomain(ScreeningEntity entity);

  /**
   * 상영 도메인 모델을 엔티티로 변환
   */
  ScreeningEntity toEntity(Screening domain);

  /**
   * 상영 엔티티 리스트를 도메인 모델 리스트로 변환
   */
  List<Screening> toDomainList(List<ScreeningEntity> entities);

  /**
   * 상영 도메인 모델 리스트를 엔티티 리스트로 변환
   */
  List<ScreeningEntity> toEntityList(List<Screening> domains);
}
