package project.redis.movie.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import project.redis.movie.entity.MovieEntity;

public interface MovieRepository extends JpaRepository<MovieEntity, Long> {
    List<MovieEntity> findAll();
}
