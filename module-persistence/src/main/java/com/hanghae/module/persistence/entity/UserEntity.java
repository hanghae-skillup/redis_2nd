package com.hanghae.module.persistence.entity;

import com.hanghae.module.domain.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  public User toDomain() {
    return User.builder()
      .id(this.id)
      .name(this.name)
      .build();
  }

  public static UserEntity from(User domain) {
    if (domain == null) {
      return null;
    }

    return UserEntity.builder()
      .id(domain.id())
      .name(domain.name())
      .build();
  }
}
