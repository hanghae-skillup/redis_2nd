package com.module.redis2nd.domain.movie.entity;

import com.module.redis2nd.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "screening")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder @Getter
public class Screening extends BaseEntity {
    private LocalDate endDate;

    @ManyToOne(targetEntity = Movie.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id")
    private Movie movie;
}
