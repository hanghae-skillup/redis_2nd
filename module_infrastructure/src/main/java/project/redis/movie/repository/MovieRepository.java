package project.redis.movie.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.redis.movie.entity.MovieEntity;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {
    List<MovieEntity> findAll();
}
