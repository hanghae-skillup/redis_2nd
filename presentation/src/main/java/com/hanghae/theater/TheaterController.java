package com.hanghae.theater;

import com.hanghae.theater.dto.ScreeningsAddRequest;
import com.hanghae.theater.dto.ScreeningsAddResponse;
import com.hanghae.theater.dto.TheaterCreateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/theaters")
@RequiredArgsConstructor
public class TheaterController {

    private final TheaterService theaterService;

    @PostMapping
    public ResponseEntity<TheaterCreateResponse> create(@RequestBody String name) {
        TheaterCreateResponse response = theaterService.save(name);
        return ResponseEntity.created(URI.create("/api/theaters/" + response.id()))
                .body(response);
    }

    @PostMapping("/screenings")
    public ResponseEntity<ScreeningsAddResponse> addScreenings(@RequestBody ScreeningsAddRequest request) {
        ScreeningsAddResponse response = theaterService.addScreenings(request);
        return ResponseEntity.ok(response);
    }
}
