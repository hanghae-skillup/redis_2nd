package com.redis.movie.repository;

import com.redis.movie.entity.movie.Genre;
import com.redis.movie.repository.dto.MoviesNowShowDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.redis.movie.entity.movie.Movie;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface MovieRepository extends JpaRepository<Movie,String> {
    @Query("SELECT new com.redis.movie.repository.dto.MoviesNowShowDto( " +

            "sc.theaterId, " +
            "mv.modifyDate, " +
            "mv.openDt, " +
            "sc.theaterMovieStartTm, " +
            "sc.theaterMovieEndTm, " +
            "mv.movieId," +
            "mv.movieNm, " +
            "mv.genreCd, " +
            "mv.showTm, " +
            "mv.showYn, " +
            "mv.grade, " +
            "sc.movieRound, " +
            "sc.theaterMovieHall, " +
            "sc.theaterNm, " +
            "sc.screenShowYn, " +
            "imgPic.imgSeq, " +
            "imgPic.imgPath, " +
            "imgPic.imgNm) " +
            "FROM Movie mv " +
            "LEFT outer join Screening sc ON mv.movieId = sc.movieId " +
            "LEFT outer join ImagePic imgPic ON mv.thumImg = imgPic.imgSeq " +
            "WHERE sc.theaterMovieStartTm >= :now" +
            " and (mv.movieNm = :movieNm" +
            "       or mv.genreCd = :genre)" +
            " ")


    List<MoviesNowShowDto> findNowShowing(@Param("now")LocalDateTime now, @Param("movieNm")String movieNm, @Param("genre")Genre genre);
}
