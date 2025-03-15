package com.cinema.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "theater")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TheaterEntity extends BaseEntity {

    @Id
    @Column(name = "theater_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 상영관 ID

    @Column(nullable = false)
    private String name; // 상영관 이름
}
