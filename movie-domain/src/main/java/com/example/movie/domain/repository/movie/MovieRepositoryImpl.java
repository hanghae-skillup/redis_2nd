package com.example.movie.domain.repository.movie;

import com.example.movie.domain.entity.Movie;
import jakarta.persistence.EntityManager;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MovieRepositoryImpl implements MovieRepositoryCustom {

    private final EntityManager entityManager;

    @Override
    public List<Movie> findNowShowingMovies(Long theaterId) {
        String query = """
            SELECT DISTINCT m FROM Movie m
            JOIN FETCH m.schedules s
            JOIN FETCH s.theater t
            WHERE t.id = :theaterId
            AND m.releaseDate <= s.startAt
            ORDER BY m.releaseDate DESC, s.startAt ASC
        """;

        return entityManager.createQuery(query, Movie.class)
                .setParameter("theaterId", theaterId)
                .getResultList();
    }
}
