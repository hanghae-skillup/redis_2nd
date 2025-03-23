package com.hanghae.movie.query;

import com.hanghae.cache.CacheManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MovieScreeningQueryService {

    private final MovieScreeningQueryRepository movieScreeningQueryRepository;
    private final CacheManager<String, Object> cacheManager;

    public List<MovieScreeningDto> findShowingMovies(MovieScreeningSearchCondition condition) {
        Optional<Object> caches = cacheManager.get("now-showing-movies");

        if (caches.isPresent()) {
            return (List<MovieScreeningDto>) caches.get();
        }
        List<MovieScreeningDto> datas = movieScreeningQueryRepository.findShowingMovies(condition);
        cacheManager.put("now-showing-movies", datas);
        return datas;
    }
}
