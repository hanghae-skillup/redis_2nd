package com.redis.api.reservation.presentation.controller;


import com.redis.api.reservation.application.mapper.ReservationDtoMapper;
import com.redis.application.reservation.application.dto.ReservationRequestDto;
import com.redis.application.reservation.application.dto.ReservationResponseDto;
import com.redis.application.reservation.application.service.ReservationService;
import com.redis.common.util.error.response.DataResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping("/reservation")
    public ResponseEntity<DataResponse<ReservationResponseDto>> reserveMovie(@RequestBody @Valid ReservationRequestDto reservationRequestDto) {

        ReservationResponseDto serviceReservationResponseDto = reservationService.reserveMovie(
                reservationRequestDto.getUserId(),
                reservationRequestDto.getCinemaId(),
                reservationRequestDto.getSeatIdList()
        );


        ReservationResponseDto reservationResponseDto = ReservationDtoMapper.toReservationResponseDto(serviceReservationResponseDto);

        return ResponseEntity.ok(DataResponse.response(true, reservationResponseDto));

    }
}
