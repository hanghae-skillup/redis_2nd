package project.redis.reservation.validator;

import java.util.List;
import org.springframework.stereotype.Component;
import project.redis.reservation.dto.ReservationSeatsRequestDto;

@Component
public class ReservationValidator {

    public void valid(ReservationSeatsRequestDto requestDto) {
        List<String> seatRows = requestDto.getSeatRows();
        List<Integer> seatColumns = requestDto.getSeatColumns();

        if (seatRows.isEmpty() || seatColumns.isEmpty()) {
            throw new IllegalArgumentException("seatRows 또는 seatColumns가 비어 있습니다.");
        }

        if (seatRows.size() != seatColumns.size()) {
            throw new IllegalArgumentException("seatRows와 seatColumns의 개수가 같지 않습니다.");
        }

        long seatRowCount = seatRows.stream().distinct().count();
        if (seatRowCount > 1) {
            throw new IllegalArgumentException("예약하려는 좌석들의 행이 이어 붙어 있는 형태가 아닙니다.");
        }

        long seatColumnCount = seatColumns.stream().distinct().count();
        if (seatColumnCount != seatColumns.size()) {
            throw new IllegalArgumentException("예약하려는 좌석의 열이 중복됩니다.");
        }

        for (int index = 1; index < seatColumns.size(); index++) {
            if (seatColumns.get(index) != seatColumns.get(index - 1) + 1) {
                throw new IllegalArgumentException("예약하려는 좌석의 열이 연속되는 형태가 아닙니다.");
            }
        }
    }
}
