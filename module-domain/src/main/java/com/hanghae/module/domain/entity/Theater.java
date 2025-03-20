package com.hanghae.module.domain.entity;

import com.hanghae.module.common.audit.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "theater")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Theater extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  private int rowCount = 5;

  private int columnCount = 5;
}
