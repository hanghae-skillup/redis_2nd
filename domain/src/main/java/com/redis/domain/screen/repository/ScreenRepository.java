package com.redis.domain.screen.repository;

import com.redis.domain.movie.entity.Genre;
import com.redis.domain.screen.dto.ScreenNowShowDto;
import com.redis.domain.screen.entity.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.redis.domain.movie.entity.MovieInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ScreenRepository extends CrudRepository<Screen, Long> {

    //영화명 라이크절
    @Query("SELECT new com.redis.domain.screen.dto.ScreenNowShowDto( " +

            "sc.cinemaId, " +
            "mv.modifyDate, " +
            "mv.openDate, " +
            "sc.movieStartTime, " +
            "sc.movieEndTime, " +
            "mv.movieId," +
            "mv.movieNm, " +
            "mv.genreCd, " +
            "mv.showTimeMin, " +
            "mv.showYn, " +
            "mv.grade, " +
            "sc.movieRound, " +
            "sc.movieHall, " +
            "sc.cinemaNm, " +
            "sc.screenShowYn, " +
            "imgPic.imgSeq, " +
            "imgPic.imgPath, " +
            "imgPic.imgNm " +
            ") " +
            "FROM MovieInfo mv " +
            "LEFT outer join Screen sc ON mv.movieId = sc.movieId " +
            "LEFT outer join CommonImg imgPic ON mv.thumImg = imgPic.imgSeq " +
            "WHERE mv.movieNm like concat('%', :movieNm, '%')" +
            " AND mv.genreCd = :genre "+
            " AND sc.movieStartTime >= :now" +
            " ")
    List<ScreenNowShowDto> findlikeMovieShowing (@Param("movieNm")String movieNm, @Param("genre")Genre genre, @Param("now")LocalDateTime now);


    @Query("SELECT sc.cinemaId " +
            "FROM Screen sc " +
            "WHERE sc.cinemaId = :cinemaId")
    Optional<Screen> findScreenWithCinema(Long cinemaId);

}


