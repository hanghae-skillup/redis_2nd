package com.hanghae.module.persistence.mapper;

import com.hanghae.module.domain.model.Seat;
import com.hanghae.module.persistence.entity.SeatEntity;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface SeatMapper {

  /**
   * 좌석 엔티티를 도메인 모델로 변환
   */
  Seat toDomain(SeatEntity entity);

  /**
   * 좌석 도메인 모델을 엔티티로 변환
   */
  SeatEntity toEntity(Seat domain);

  /**
   * 좌석 엔티티 리스트를 도메인 모델 리스트로 변환
   */
  List<Seat> toDomainList(List<SeatEntity> entities);

  /**
   * 좌석 도메인 모델 리스트를 엔티티 리스트로 변환
   */
  List<SeatEntity> toEntityList(List<Seat> domains);
}
