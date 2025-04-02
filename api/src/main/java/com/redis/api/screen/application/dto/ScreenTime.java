package com.redis.api.screen.application.dto;

import java.time.LocalDateTime;


//recode 클래스 설명
//getter, equals(), hashCode(), toString() 자동 생성
//@Data(Lombok) 없이도 간결한 코드 가능
//불변 객체(변경 불가)

public record ScreenTime(
        LocalDateTime movieStartTime,
        LocalDateTime movieEndTime
) {}
