package com.skillup.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;
import com.skillup.domain.Schedule;
import com.skillup.domain.Screen;


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
    private String thumbnail;
    private int runningtime;
    private LocalDate release_date;

    @Enumerated(EnumType.STRING)
    private MovieRating rating;

    private String genre;

    @OneToMany(mappedBy = "movie")  // Movie 엔티티와 Schedule 엔티티의 관계 설정
    private List<Screen> screens;
    @OneToMany(mappedBy = "movie")
    private List<Schedule> schedules;  // Schedule과의 관계로 변경
}
