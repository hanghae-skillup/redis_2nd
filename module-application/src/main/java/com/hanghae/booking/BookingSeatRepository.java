package com.hanghae.booking;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookingSeatRepository {

    private final JPAQueryFactory queryFactory;

    public List<BookingSeat> findBy(Long screeningId) {
        return findBy(screeningId, null, null);
    }

    public List<BookingSeat> findBy(Long screeningId, Long memberId) {
        return findBy(screeningId, memberId, null);
    }

    public List<BookingSeat> findBy(Long screeningId, List<Long> seatIds) {
        return findBy(screeningId, null, seatIds);
    }

    public List<BookingSeat> findBy(Long screeningId, Long member_id, List<Long> seatIds) {
        QBooking booking = QBooking.booking;
        QBookingSeat bookingSeat = QBookingSeat.bookingSeat;

        BooleanBuilder whereCondition = new BooleanBuilder();
        whereCondition.and(booking.screeningId.eq(screeningId));

        if (member_id != null) {
            whereCondition.and(booking.memberId.eq(member_id));
        }

        if (seatIds != null) {
            whereCondition.and(bookingSeat.seatId.in(seatIds));
        }

        return queryFactory
                .select(bookingSeat)
                .from(booking)
                .join(booking.bookingSeats.bookingSeats, bookingSeat)
                .where(whereCondition)
                .fetch();
    }
}
