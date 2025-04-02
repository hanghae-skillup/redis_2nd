package com.redis.application.screen.presentation.controller;

import com.redis.application.screen.application.service.ScreenRedisCacheService;
import com.redis.common.util.error.response.DataResponse;
import com.redis.domain.movie.entity.Genre;
import com.redis.domain.screen.dto.ScreenNowShowDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.ListIterator;


@RestController
@RequestMapping("/redisUse")
@RequiredArgsConstructor
public class ScreenRedisCacheController {
    
    private final ScreenRedisCacheService screenRedisCacheService;

    //현재 시점 이후의 영화리스트 조회
    @GetMapping("movies/likeMovieRedis")
    public ResponseEntity<DataResponse<List<ScreenNowShowDto>>> getLikeMovieRedis(
            @RequestParam(value = "movieNm", required = false) String movieNm,
            @RequestParam(value = "genre", required = false) Genre genre,
            @RequestParam(value = "search", required = false)String search
    ) {
        List<ScreenNowShowDto> screeningData = screenRedisCacheService.getScreengings(movieNm ,genre);
        ListIterator<ScreenNowShowDto> iterator = screeningData.listIterator();
        //정방향 출력
        while(iterator.hasNext()) {
            System.out.println("정방향 " + iterator.next().getCinemaNm());
        }
        DataResponse<List<ScreenNowShowDto>> response22 = DataResponse.response(true, screeningData);
        return ResponseEntity.ok(response22);
    }

    
//
//    @GetMapping("movies/reserSaveRedis")
//    public ResponseEntity<DataResponse<List<ScreenNowShowDto>>> reserSaveRedis(
//            @RequestParam(value = "movieNm", required = false) String movieNm,
//            @RequestParam(value = "genre", required = false) Genre genre,
//            @RequestParam(value = "search", required = false)String search
//    ) {
//        List<ScreenNowShowDto> screeningData = screenRedisCacheService.getScreengings(movieNm ,genre);
////        ListIterator<ScreenNowShowDto> iterator = screeningData.listIterator();
////        //정방향 출력
////        while(iterator.hasNext()){
////            System.out.println("정방향 "+ iterator.next().getCinemaNm());
////        }
//
//        DataResponse<List<ScreenNowShowDto>> response22 = DataResponse.response(true, screeningData);
//        return ResponseEntity.ok(response22);
//    }
//
//


}
