package com.hanghae.cinema;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class TheaterService {

    private final TheaterRepository theaterRepository;
    private final ScreeningsCreator screeningsCreator;

    public TheaterService(TheaterRepository theaterRepository, ScreeningsCreator screeningsCreator) {
        this.theaterRepository = theaterRepository;
        this.screeningsCreator = screeningsCreator;
    }

    public TheaterCreateResponse save(@RequestBody String name) {
        Theater theater = new Theater(name);
        Theater savedTheater = theaterRepository.save(theater);
        return TheaterCreateResponse.from(savedTheater);
    }

    public ScreeningsAddResponse addScreenings(ScreeningsAddRequest request) {
        Theater theater = theaterRepository.findById(request.getTheaterId())
                .orElseThrow(() -> new NoSuchElementException("There is no theater with id " + request.getTheaterId()));
        List<Screening> screenings = screeningsCreator.create(ScreeningDto.toScreenings(request.getScreenings()));
        theater.addScreenings(screenings);
        return ScreeningsAddResponse.from(theater);
    }
}
