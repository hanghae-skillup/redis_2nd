package com.module.redis2nd.domain.movie.service;

import com.module.redis2nd.domain.common.dto.ApiBody;
import com.module.redis2nd.domain.movie.entity.Screening;
import com.module.redis2nd.domain.movie.repository.MovieRepository;
import com.module.redis2nd.domain.movie.repository.ScreeningRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MovieService {
    private final MovieRepository movieRepository;
    private final ScreeningRepository screeningRepository;

    public ApiBody getScreeningMovies() {
        List<Screening> screenings = screeningRepository.findAllOrderByReleaseDateAndStartTime();
        return ApiBody.ok(screenings);
    }
}
