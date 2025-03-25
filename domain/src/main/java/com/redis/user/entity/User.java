package com.redis.user.entity;

import com.redis.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "movie_user")
public class User extends BaseEntity{

    @Id
    @Column(name = "userId" , nullable = false, length = 100)
    private String userId;

    @Column(name = "userImg" , nullable = false)
    private int userImg;

    @Column(name = "loginId" , length = 50)
    private String loginId;

    @Column(name = "pwd" , length = 50)
    private String pwd;

    @Column(name = "userNm" , length = 20)
    private String userNm;

    @Column(name = "phoneNum01")
    private int phoneNum01;

    @Column(name = "phoneNum02")
    private int phoneNum02;

    @Column(name = "phoneNum03")
    private int phoneNum03;

    @Column(name = "address01" , length = 200)
    private String address01;

    @Column(name = "address02" , length = 100)
    private String address02;

    @Column(name = "address03" , length = 10)
    private String address03;

    @Column(name = "useYn")
    private Character useYn;

    @Column(name = "createDate")
    private LocalDateTime createDate;

    @Column(name = "lastLoginDate")
    private LocalDateTime lastLoginDate;

    @Column(name = "email01" , length = 15)
    private String email01;

    @Column(name = "email02" , length = 10)
    private String email02;

    @Column(name = "role" , length = 10)
    private String role;

}
