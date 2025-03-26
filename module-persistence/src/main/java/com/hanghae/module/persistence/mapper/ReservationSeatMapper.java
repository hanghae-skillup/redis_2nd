package com.hanghae.module.persistence.mapper;

import com.hanghae.module.domain.model.ReservationSeat;
import com.hanghae.module.persistence.entity.ReservationSeatEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservationSeatMapper {

  ReservationSeatMapper INSTANCE = Mappers.getMapper(ReservationSeatMapper.class);

  /**
   * 예약좌석 엔티티를 도메인 모델로 변환
   * createdAt을 reservedAt으로 매핑
   */
  @Mapping(source = "createdAt", target = "reservedAt")
  ReservationSeat toDomain(ReservationSeatEntity entity);

  /**
   * 예약좌석 도메인 모델을 엔티티로 변환
   */
  ReservationSeatEntity toEntity(ReservationSeat domain);

  /**
   * 예약좌석 엔티티 리스트를 도메인 모델 리스트로 변환
   */
  List<ReservationSeat> toDomainList(List<ReservationSeatEntity> entities);

  /**
   * 예약좌석 도메인 모델 리스트를 엔티티 리스트로 변환
   */
  List<ReservationSeatEntity> toEntityList(List<ReservationSeat> domains);
}
