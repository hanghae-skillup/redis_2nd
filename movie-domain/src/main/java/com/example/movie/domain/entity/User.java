package com.example.movie.domain.entity;

import com.example.movie.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String userName;

    private String email;

    private String phone;

    @Builder
    public User(String userName, String email, String phone) {
        this.userName = userName;
        this.email = email;
        this.phone = phone;
    }
}
