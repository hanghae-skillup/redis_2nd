package org.bailey.domain.exception.movie;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException(Long id) {
        super("해당 영화가 존재하지 않습니다. ID = " + id);
    }
}