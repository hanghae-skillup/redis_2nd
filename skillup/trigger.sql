DELIMITER $$

CREATE TRIGGER insert_seats_after_schedule_insert
AFTER INSERT ON schedule
FOR EACH ROW
BEGIN
    DECLARE row_ CHAR(1);  -- 행(A, B, C, D, E)
    DECLARE col_ INT;      -- 열(1, 2, 3, 4, 5)
    SET row_ = 'A';        -- 첫 번째 행을 'A'로 설정

    -- 5x5 구조의 좌석을 삽입
    WHILE row_ <= 'E' DO
        SET col_ = 1;  -- 열을 1부터 시작

        -- 각 행에 대해 5개의 열을 삽입
        WHILE col_ <= 5 DO
            INSERT INTO seat (schedule_no, location, is_reserved)
            VALUES (NEW.no, CONCAT(row_, col_), FALSE);  -- 예: A1, A2, ..., E5
            SET col_ = col_ + 1;
        END WHILE;

        SET row_ = CHAR(ASCII(row_) + 1);  -- 행을 'A'에서 'B', 'B'에서 'C'로 증가
    END WHILE;
END$$

DELIMITER ;
