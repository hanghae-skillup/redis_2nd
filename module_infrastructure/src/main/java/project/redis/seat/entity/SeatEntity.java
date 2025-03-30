package project.redis.seat.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.redis.common.entity.BaseEntity;
import project.redis.seat.Seat;

@Entity
@Table(name = "seat")
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SeatEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seatId;

    @Column(nullable = false)
    private String seatRow;

    @Column(nullable = false)
    private Integer seatColumn;

    public static SeatEntity of(Seat seat) {
        return SeatEntity.builder()
                .seatRow(seat.getSeatRow())
                .seatColumn(seat.getSeatColumn())
                .build();
    }
}
