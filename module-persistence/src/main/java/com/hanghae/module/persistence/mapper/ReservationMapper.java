package com.hanghae.module.persistence.mapper;

import com.hanghae.module.domain.model.Reservation;
import com.hanghae.module.persistence.entity.ReservationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

  /**
   * 예약 엔티티를 도메인 모델로 변환
   * createdAt은 BaseEntity에서 상속받은 필드라서 명시적으로 매핑
   */
  @Mapping(source = "createdAt", target = "createdAt")
  @Mapping(target = "seatNumbers", ignore = true)
  Reservation toDomain(ReservationEntity entity);

  /**
   * 예약 도메인 모델을 엔티티로 변환
   */
  ReservationEntity toEntity(Reservation domain);

  /**
   * 예약 엔티티 리스트를 도메인 모델 리스트로 변환
   */
  List<Reservation> toDomainList(List<ReservationEntity> entities);

  /**
   * 예약 도메인 모델 리스트를 엔티티 리스트로 변환
   */
  List<ReservationEntity> toEntityList(List<Reservation> domains);
}
