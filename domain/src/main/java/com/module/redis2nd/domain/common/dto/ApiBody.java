package com.module.redis2nd.domain.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApiBody<T> {
    private T contents;

    public static <T> ApiBody ok(T contents) {
        return new ApiBody(contents);
    }
    public static <T> ApiBody ok() {
        return new ApiBody();
    }
}
