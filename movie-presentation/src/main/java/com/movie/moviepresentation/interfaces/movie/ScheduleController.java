package com.movie.moviepresentation.interfaces.movie;

import com.movie.movieapplication.response.BfResponse;
import com.movie.moviepresentation.interfaces.movie.dto.ScheduleDto;
import com.movie.movieapplication.movie.service.ScheduleService;
import com.movie.moviepresentation.interfaces.movie.dto.ScheduleDto.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedule")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @GetMapping
    public BfResponse<List<Response>> getSchedules(@RequestParam("theaterId") Long theaterId) {
        List<ScheduleDto.Response> responses = scheduleService.getSchedules(theaterId).stream()
                .map(ScheduleDto.Response::from)
                .toList();
        return new BfResponse<>(responses);
    }

}
