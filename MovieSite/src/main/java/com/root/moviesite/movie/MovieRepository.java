package com.root.moviesite.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;


public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Override
//            @Todo 정확한 DB 테이블 이름을 모름(확인 후 기입)
//    @Query("select b from Board b join fetch b.member")
    List<Movie> findAll();

//    메인 페이지는 ‘개봉일’ 순서로 정렬되어야 합니다. 또한 시간표는 그림과 같이 시작시간이 빠른 것부터 정렬되어야 합니다.
}
