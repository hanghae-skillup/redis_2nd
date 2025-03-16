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

    @ManyToOne
    @JoinColumn(name = "movie_no", insertable = false, updatable = false)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "screen_no", insertable = false, updatable = false)
    private Screen screen;

    public String getScreenName() {
        return screen != null ? screen.getName() : null;
    }
}
