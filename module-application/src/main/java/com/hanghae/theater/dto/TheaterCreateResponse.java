package com.hanghae.theater.dto;


import com.hanghae.theater.Screening;
import com.hanghae.theater.Theater;

import java.time.LocalDateTime;
import java.util.List;

public record TheaterCreateResponse(
        Long id,
        String name,
        List<Screening> screenings,
        LocalDateTime createdDate,
        String createdBy
) {
    public static TheaterCreateResponse from(Theater theater) {
        return new TheaterCreateResponse(
                theater.getId(),
                theater.getName(),
                theater.getScreenings(),
                theater.getCreatedDate(),
                theater.getCreatedBy()
        );
    }
}
