package com.hanghae.module.persistence.entity;

import com.hanghae.module.common.audit.BaseEntity;
import com.hanghae.module.domain.model.Theater;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "theater")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TheaterEntity extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  public Theater toDomain() {
    return Theater.builder()
      .id(this.id)
      .name(this.name)
      .build();
  }

  public static TheaterEntity from(Theater domain) {
    if (domain == null) {
      return null;
    }

    return TheaterEntity.builder()
      .id(domain.id())
      .name(domain.name())
      .build();
  }
}
