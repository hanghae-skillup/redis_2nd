package com.hanghe.redis.movie

enum class MovieGrade(val type: String, val age: Int) {
    ALL("전체 관람가", 0),

    TWELVE("12세 이상 관람가", 12),

    FIFTEEN("15세 이상 관람가", 15),

    ADULT("청소년 관람불가", 19);
}
