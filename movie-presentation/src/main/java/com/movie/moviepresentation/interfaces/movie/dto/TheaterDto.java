package com.movie.moviepresentation.interfaces.movie.dto;

import com.movie.movieapplication.movie.dto.TheaterInfo;

public class TheaterDto {

    public record Response(Long id, String name) {
        public static Response of(Long id, String name) {
            return new Response(id, name);
        }
        public static Response from(TheaterInfo.Get info) {
            return Response.of(info.id(), info.name());
        }
    }

}
