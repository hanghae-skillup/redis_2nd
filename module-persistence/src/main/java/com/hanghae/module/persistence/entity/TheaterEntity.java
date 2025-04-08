package com.hanghae.module.persistence.entity;

import com.hanghae.module.common.audit.BaseEntity;
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
}
