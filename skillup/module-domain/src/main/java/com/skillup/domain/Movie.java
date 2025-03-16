package com.skillup.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;
    private String name;
    private String thumnail;
    private int runningtime;
    private LocalDate release_date;
    @Enumerated(EnumType.STRING)  // enum 값을 문자열로 저장
    private MovieRating rating;
    private String genre;
}