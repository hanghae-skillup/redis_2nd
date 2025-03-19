package com.hanghae.movie;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.net.MalformedURLException;
import java.net.URL;

@Getter
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class UrlString {
    private String url;

    public UrlString(final String url) {
        validate(url);
        this.url = url;
    }

    private void validate(final String url) {
        try {
            new URL(url);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("url 형식이 이상합니다", e);
        }
    }
}
