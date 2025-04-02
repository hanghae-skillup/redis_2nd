package com.redis.common.util.error.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


//데이터를 조회하여 response에 담게될 모든 값들을 data라는 필드값에 설정하여 response를 일반화시킴
@Getter
@Setter
@Builder
public class DataResponse<T> {
    private boolean success;
    private T data;

    public static <T> DataResponse<T> response(final boolean success, final T data) {
        return DataResponse.<T>builder()
                .success(success)
                .data(data)
                .build();
    }
}
