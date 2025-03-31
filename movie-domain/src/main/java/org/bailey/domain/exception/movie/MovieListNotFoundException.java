package org.bailey.domain.exception.movie;

public class MovieListNotFoundException extends RuntimeException {
    public MovieListNotFoundException() {
        super("등록된 영화가 없습니다.");
    }
}