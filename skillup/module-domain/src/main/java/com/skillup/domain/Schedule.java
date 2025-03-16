package com.skillup.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;
    private Long movie_no;
    private Long screen_no;
    private LocalDateTime start_time;
    private LocalDateTime end_time;

}