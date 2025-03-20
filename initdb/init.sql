DELIMITER $$

CREATE PROCEDURE insert_large_test_data()
BEGIN
    DECLARE i INT DEFAULT 1;
    DECLARE j INT DEFAULT 1;
    DECLARE k INT DEFAULT 1;
    DECLARE seat_label CHAR(1);

    -- 영화 데이터 500개 삽입 (ENUM 영어로 변경)
    WHILE i <= 500 DO
        INSERT INTO movie (title, thumbnail_url, genre, rating, release_date, running_time, created_by)
        VALUES
        (CONCAT('Movie ', i),
         CONCAT('thumbnail', i, '.jpg'),
         ELT(FLOOR(RAND() * 5) + 1, 'action', 'comedy', 'drama', 'horror', 'sci-fi'),
         ELT(FLOOR(RAND() * 4) + 1, 'all', '12+', '15+', '18+'),
         DATE_SUB(NOW(), INTERVAL FLOOR(RAND() * 1000) DAY),
         FLOOR(RAND() * 180 + 90),
         'admin');
        SET i = i + 1;
    END WHILE;

    -- 상영관 데이터 50개 삽입
    SET i = 1;
    WHILE i <= 50 DO
        INSERT INTO theater (theater_name, created_by)
        VALUES (CONCAT('Theater ', i), 'admin');
        SET i = i + 1;
    END WHILE;

    -- 좌석 데이터 (각 상영관당 5x5 = 25개 좌석 생성)
    SET i = 1;
    WHILE i <= 50 DO  -- 상영관 50개
        SET j = 1;
        WHILE j <= 5 DO  -- 행 (A~E)
            SET seat_label = CHAR(64 + j); -- ASCII(A~E)
            SET k = 1;
            WHILE k <= 5 DO  -- 열 (1~5)
                INSERT INTO seat (theater_id, seat_number, created_by)
                VALUES
                (i, CONCAT(seat_label, k), 'admin');
                SET k = k + 1;
            END WHILE;
            SET j = j + 1;
        END WHILE;
        SET i = i + 1;
    END WHILE;

    -- 회원 데이터 500개 삽입
    SET i = 1;
    WHILE i <= 500 DO
        INSERT INTO user (user_name, created_by)
        VALUES
        (CONCAT('User ', i), 'admin');
        SET i = i + 1;
    END WHILE;

    -- 예매 데이터 500개 삽입
    SET i = 1;
    WHILE i <= 500 DO
        INSERT INTO reservation (user_id, seat_id, reservation_time)
        VALUES
        (FLOOR(RAND() * 500 + 1),
         FLOOR(RAND() * 1250 + 1),  -- 50개 상영관 * 25좌석 = 1250좌석 중 랜덤 선택
         NOW());
        SET i = i + 1;
    END WHILE;

END $$

DELIMITER ;

CALL insert_large_test_data();