package com.redis.movie.entity.movie;

import jakarta.persistence.*;
import com.redis.BaseEntity;

@Entity
@Table(name = "common_Img")
public class ImagePic extends BaseEntity {

    @Id
    private int imgSeq;

    private String imgPath;
    private String imgNm;



}
