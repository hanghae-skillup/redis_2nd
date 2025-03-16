package com.root.moviesite.position;

import com.root.moviesite.movie.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PositionRepository extends JpaRepository<Position, Long> {

    @Override
//            @Todo 정확한 DB 테이블 이름을 모름(확인 후 기입)
//    @Query("select b from Board b join fetch b.member")
    List<Position> findAll();
}
