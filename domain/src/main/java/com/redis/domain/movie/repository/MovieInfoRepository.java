package com.redis.domain.movie.repository;

import com.redis.domain.movie.entity.MovieInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieInfoRepository extends JpaRepository<MovieInfo,Long> {

}
