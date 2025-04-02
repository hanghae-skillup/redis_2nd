package com.redis.domain.movie.entity;

import jakarta.persistence.*;
import com.redis.domain.BaseEntity;

@Entity
@Table(name = "common_img")
public class CommonImg extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imgSeq;

    private String imgPath;
    private String imgNm;



}
