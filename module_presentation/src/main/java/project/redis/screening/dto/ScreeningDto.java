package project.redis.screening.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ScreeningDto {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
