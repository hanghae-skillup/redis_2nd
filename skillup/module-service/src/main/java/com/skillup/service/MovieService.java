package com.skillup.service;

import com.skillup.domain.Movie;
import com.skillup.domain.Screen;
import com.skillup.persistence.MovieRepository;
import com.skillup.service.dto.MovieResponseDTO;
import com.skillup.service.dto.ScheduleDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public List<MovieResponseDTO> getAllMovies() {
        List<Movie> movies = movieRepository.findMoviesWithSchedulesAndScreens(); // 영화와 관련된 스케줄 및 상영관 정보를 가져옴
    
        return movies.stream().map(movie -> {
            MovieResponseDTO dto = new MovieResponseDTO();
            dto.setMovieName(movie.getName());
            dto.setMovieRating(movie.getRating().getKoreanRating());
            dto.setReleaseDate(movie.getRelease_date());
            dto.setRunningTime(movie.getRunningtime());
            dto.setGenre(movie.getGenre());
            dto.setThumbnail(movie.getThumbnail());

            // 영화에 해당하는 모든 상영관 이름 리스트 가져오기
            System.out.print(movie.getScreens());
            List<String> screenNames = movie.getScreens().stream()
                    .map(Screen::getName)  // 각 상영관 이름을 가져옴
                    .collect(Collectors.toList());
    
            dto.setScreenNames(screenNames);  // 화면 이름 설정
    
            // 각 영화에 대한 스케줄 리스트 가져오기
            List<ScheduleDTO> scheduleDTOs = movie.getScreens().stream()
                    .flatMap(screen -> screen.getSchedules().stream())  
                    .map(schedule -> {
                        ScheduleDTO scheduleDTO = new ScheduleDTO();
                        scheduleDTO.setScreenName(schedule.getScreen().getName());
                        scheduleDTO.setStartTime(schedule.getStart_time());
                        scheduleDTO.setEndTime(schedule.getEnd_time());
                        return scheduleDTO;
                    }).collect(Collectors.toList());
    
            dto.setSchedules(scheduleDTOs);
    
            return dto;
        }).collect(Collectors.toList());
    }

}
