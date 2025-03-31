package org.bailey.service;

import org.bailey.domain.entity.Schedule;
import org.bailey.domain.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public Schedule findById(Long id) {
        return scheduleRepository.findById(id)
                .orElseThrow();
    }

    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAllWithMovieAndTheater(); // fetch join 추천
    }
}
