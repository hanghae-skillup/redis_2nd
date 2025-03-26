package com.hanghae.module.persistence.mapper;


import com.hanghae.module.domain.model.User;
import com.hanghae.module.persistence.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  /**
   * 사용자 엔티티를 도메인 모델로 변환
   */
  User toDomain(UserEntity entity);

  /**
   * 사용자 도메인 모델을 엔티티로 변환
   */
  UserEntity toEntity(User domain);

  /**
   * 사용자 엔티티 리스트를 도메인 모델 리스트로 변환
   */
  List<User> toDomainList(List<UserEntity> entities);

  /**
   * 사용자 도메인 모델 리스트를 엔티티 리스트로 변환
   */
  List<UserEntity> toEntityList(List<User> domains);
}
