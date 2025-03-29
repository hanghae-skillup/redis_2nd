package project.redis.seat.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.redis.common.entity.BaseEntity;
import project.redis.theater.entity.TheaterEntity;

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
    private Boolean isReserved;

    @Column(nullable = false)
    private String seatRow;

    @Column(nullable = false)
    private Integer seatColumn;

    // TODO : Theater에 좌석 필요 없다는 것을 깨달아서 차근차근 삭제할 것
    @ManyToOne
    @JoinColumn(name = "theater_id")
    private TheaterEntity theater;
}
