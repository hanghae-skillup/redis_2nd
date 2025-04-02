package com.redis.domain.user.entity;

import com.redis.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "movie_user")
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MovieUser extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId" , nullable = false, length = 100)
    private Long userId;

    @Column(name = "userImg")
    private Integer userImg;

    @Column(name = "loginId" , length = 50)
    private String loginId;

    @Column(name = "pwd" , length = 50)
    private String pwd;

    @Column(name = "userNm" , length = 20)
    private String userNm;

    @Column(name = "phoneNum01")
    private Integer phoneNum01;

    @Column(name = "phoneNum02")
    private Integer phoneNum02;

    @Column(name = "phoneNum03")
    private Integer phoneNum03;

    @Column(name = "address01" , length = 200)
    private String address01;

    @Column(name = "address02" , length = 100)
    private String address02;

    @Column(name = "address03" , length = 10)
    private String address03;

    @Column(name = "useYn")
    private Boolean useYn;

    @Column(name = "createDate")
    private LocalDateTime createDate;

    @Column(name = "modifyDate")
    private LocalDateTime modifyDate;

    @Column(name = "lastLoginDate")
    private LocalDateTime lastLoginDate;

    @Column(name = "email01" , length = 15)
    private String email01;

    @Column(name = "email02" , length = 10)
    private String email02;

    @Column(name = "role" , length = 10)
    private String role;


    public String concatEmail(String email01,String email02) {
        return email01+"@"+email02;
    }

}
