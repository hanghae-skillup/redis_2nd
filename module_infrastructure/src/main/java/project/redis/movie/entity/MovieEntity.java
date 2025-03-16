package project.redis.movie.entity;

import static jakarta.persistence.EnumType.STRING;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.redis.Movie.MovieGenre;
import project.redis.Movie.MovieRate;

@Entity
@Table(name = "movie")
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;

    @Column(nullable = false)
    private String movieName;

    @Enumerated(value = STRING)
    @Column(nullable = false)
    private MovieRate movieRate;

    @Column(nullable = false)
    private LocalDateTime movieReleaseDate;
    
    private String movieThumbnailImage;

    @Column(nullable = false)
    private Integer movieRunningTime;

    @Enumerated(value = STRING)
    @Column(nullable = false)
    private MovieGenre movieGenre;

}
