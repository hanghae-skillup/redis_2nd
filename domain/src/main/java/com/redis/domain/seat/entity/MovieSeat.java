package com.redis.domain.seat.entity;

import com.redis.domain.screen.entity.Screen;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "movie_seat")
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MovieSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seatId; //좌석Id

    private Long cinemaId;
    private String seatCd; //좌석코드
    private String seatNm; //좌석이름
    private String seatLv;
    private Boolean isReserved;

    private String seatCol;
    private String seatRow;

    @Version // Optimistic Lock 버전 필드
    private Integer version;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "screen")
    private Screen screen;


    public void updateReserved() {
        this.isReserved = true;
    }
}
