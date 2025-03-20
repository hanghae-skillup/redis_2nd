package com.skillup.domain;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Screen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;
    private String name;  // 상영관 이름

    @OneToMany(mappedBy = "screen")
    private List<Schedule> schedules;

    @ManyToOne
    @JoinColumn(name = "movie_no", referencedColumnName = "no", insertable = false, updatable = false)
    private Movie movie;
}