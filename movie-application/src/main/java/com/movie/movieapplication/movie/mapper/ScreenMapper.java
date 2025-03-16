package com.movie.movieapplication.movie.mapper;

import com.movie.movieapplication.movie.domain.Screen;
import com.movie.movieapplication.movie.entity.ScreenEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ScreenMapper {

    public static Screen from(ScreenEntity screenEntity) {
        return Screen.of(
                screenEntity.getId(), screenEntity.getName(),
                screenEntity.getTheaterId()
        );
    }

}
