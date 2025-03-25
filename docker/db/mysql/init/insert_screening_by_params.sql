DELIMITER $$
/*
call insert_screening_by_params(1, 1, '2025-04-07', '2025-06-30');
*/
CREATE PROCEDURE insert_screening_by_params(
    IN p_theater_id INT,
    IN p_movie_id INT,
    IN p_start_date DATE,
    IN p_end_date DATE
)
BEGIN
    DECLARE v_current_date DATE;
    SET v_current_date = p_start_date;

    WHILE v_current_date <= p_end_date DO
        -- 상영 데이터 삽입
        INSERT INTO screening (theater_id, movie_id, screen_number, start_time, end_time, seat_count, created_date, created_by, last_modified_date, last_modified_by)
        VALUES
        (p_theater_id, p_movie_id, 1, CONCAT(v_current_date, ' 08:00:00'), CONCAT(v_current_date, ' 10:00:00'), 25, NOW(), 'master', NOW(), 'master'),
        (p_theater_id, p_movie_id, 2, CONCAT(v_current_date, ' 10:00:00'), CONCAT(v_current_date, ' 12:00:00'), 25, NOW(), 'master', NOW(), 'master'),
        (p_theater_id, p_movie_id, 3, CONCAT(v_current_date, ' 12:00:00'), CONCAT(v_current_date, ' 14:00:00'), 25, NOW(), 'master', NOW(), 'master'),
        (p_theater_id, p_movie_id, 4, CONCAT(v_current_date, ' 14:00:00'), CONCAT(v_current_date, ' 16:00:00'), 25, NOW(), 'master', NOW(), 'master'),
        (p_theater_id, p_movie_id, 5, CONCAT(v_current_date, ' 16:00:00'), CONCAT(v_current_date, ' 18:00:00'), 25, NOW(), 'master', NOW(), 'master'),
        (p_theater_id, p_movie_id, 6, CONCAT(v_current_date, ' 18:00:00'), CONCAT(v_current_date, ' 20:00:00'), 25, NOW(), 'master', NOW(), 'master'),
        (p_theater_id, p_movie_id, 7, CONCAT(v_current_date, ' 20:00:00'), CONCAT(v_current_date, ' 22:00:00'), 25, NOW(), 'master', NOW(), 'master');

        -- 날짜를 하루씩 증가
        SET v_current_date = DATE_ADD(v_current_date, INTERVAL 1 DAY);
    END WHILE;

END$$

DELIMITER ;
