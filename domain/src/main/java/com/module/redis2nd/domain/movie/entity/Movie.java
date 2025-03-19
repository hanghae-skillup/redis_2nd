package com.module.redis2nd.domain.movie.entity;

import com.module.redis2nd.domain.common.BaseEntity;
import com.module.redis2nd.domain.common.enums.GenreType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "movie")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder @Getter
public class Movie extends BaseEntity {
    private String title;
    private String thumbnail;
    private int movieRatings;
    private LocalDate releaseDate;
    private int runningTime;
    private String theaterName;

    @Enumerated(EnumType.STRING)
    private GenreType genre;

    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ShowSchedule> showSchedules;

    public static Movie createMovie() {
        return Movie.builder()
                .build();
    }
}
