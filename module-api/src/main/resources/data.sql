-- Movie 데이터 삽입 (6개)
INSERT INTO movie (title, genre, rating, release_date, running_time, thumbnail_url) VALUES
                                                                                        ('범죄도시 4', 'ACTION', '15세 관람가', '2024-01-20', 130, 'https://i.namu.wiki/i/Kb880vXiRaiNyh556Q6LGb56NvKM8k6XS2fYAHYFC4VM3DKw77CurLx4HW_we5MZak29SsVM1i6nCC2VUsaqczisTb_s_8GtWuUk6XCiyLK_TGmM1NWrDVJhmtBc_fUF8EVTLNtwhtfruPzlML5fag.webp'),
                                                                                        ('기생수: 더 그레이', 'SF', '15세 관람가', '2024-02-15', 125, 'https://i.namu.wiki/i/plJt7uVrjVMk-KL_cdNecs97FwfZudbICm7F1YTiAKC9KlMDKd1Bvn2FCNapjMD5kbc5gww2BnC2kDovr4tIxDGXv4yudS3E8EEYXWtde0Dpuu0iypzeRJGi-dMzwUCh0WTItw8eb5PS_08RJgKKVA.webp'),
                                                                                        ('서복', 'DRAMA', '12세 관람가', '2024-03-01', 115, 'https://i.namu.wiki/i/-KuuA3qdDNht1HuRIoENNXuR8mQtXZEWmssboznjBRvDteJettNkNmf7_hvokqIMGyD2F85DAzEQj-3xnmr0qga5J580J9Alj5CwAiG8rJJ9EsYB9h9HkzIIHZsSkftkCwsvtzqMssKguxqvM76q1Q.webp'),
                                                                                        (' 노량: 죽을 때까지', 'DRAMA', '15세 관람가', '2024-01-10', 140, 'https://i.namu.wiki/i/SodURpRWu-cu6eMPhMwUX_QY9QGd9T-Jyt8RPGjVaXmXBwCoxdBh21YtsWe1zJkI7SSoqGtuEYH1OAVZoEmhaZhyk2LQxof7hs6b0xe5OWZ7tHQUKa4n1BqQuRUieFdHrskXhL5WLUTcDHJkIbBbuw.webp'),
                                                                                        ('듄: 파트 2', 'SF', '12세 관람가', '2024-02-28', 165, 'https://i.namu.wiki/i/gqfNru-_hEtLLHhXgjiZXQWhJ86nR8gm8Vk6dj5CQEv5uG6VfDTG-XE32M8sqZp8Da9jEDnuTpQ0_9jY0BJC5ue7jG9Fe1gD9t2ToGNxJi89Ffws4UQVA2mkDIYn0LPQs7b2kSfDgjhwq8-jdXJsRA.webp'),
                                                                                        ('귀멸의 칼날', 'ANIMATION', '15세 관람가', '2024-02-10', 110, 'https://i.namu.wiki/i/kF45TT1axGKhxSSs-5K7aiO-YQ_6_qkms5ZEs_40oqG1d2IzoJFfew3lMtO03HlUWl5egBcGktsGth2CrUubQl9rNo_HKhFaH0BLQy0YqJ4ES_xjID3EnvEsdFZa_hskmaRSmhM_21RdO0voMDYMsQ.webp');

-- Theater 데이터 삽입 (20개)
INSERT INTO theater (name, row_count, column_count, created_at, modified_at, created_by, modified_by) VALUES
                                                                                                          ('메가박스 강남', 10, 15, NOW(), NOW(), 'SYSTEM', 'SYSTEM'),
                                                                                                          ('CGV 명동', 8, 12, NOW(), NOW(), 'SYSTEM', 'SYSTEM'),
                                                                                                          ('롯데시네마 잠실', 9, 14, NOW(), NOW(), 'SYSTEM', 'SYSTEM'),
                                                                                                          ('메가박스 홍대', 7, 11, NOW(), NOW(), 'SYSTEM', 'SYSTEM'),
                                                                                                          ('CGV 강변', 8, 13, NOW(), NOW(), 'SYSTEM', 'SYSTEM'),
                                                                                                          ('롯데시네마 건대', 10, 16, NOW(), NOW(), 'SYSTEM', 'SYSTEM'),
                                                                                                          ('메가박스 목동', 9, 14, NOW(), NOW(), 'SYSTEM', 'SYSTEM'),
                                                                                                          ('CGV 신촌', 7, 12, NOW(), NOW(), 'SYSTEM', 'SYSTEM'),
                                                                                                          ('롯데시네마 영등포', 8, 13, NOW(), NOW(), 'SYSTEM', 'SYSTEM'),
                                                                                                          ('메가박스 센텀시티', 10, 15, NOW(), NOW(), 'SYSTEM', 'SYSTEM'),
                                                                                                          ('CGV 당산', 6, 10, NOW(), NOW(), 'SYSTEM', 'SYSTEM'),
                                                                                                          ('롯데시네마 청량리', 8, 12, NOW(), NOW(), 'SYSTEM', 'SYSTEM'),
                                                                                                          ('메가박스 상암', 9, 14, NOW(), NOW(), 'SYSTEM', 'SYSTEM'),
                                                                                                          ('CGV 동대문', 7, 11, NOW(), NOW(), 'SYSTEM', 'SYSTEM'),
                                                                                                          ('롯데시네마 노원', 10, 16, NOW(), NOW(), 'SYSTEM', 'SYSTEM'),
                                                                                                          ('메가박스 대학로', 8, 13, NOW(), NOW(), 'SYSTEM', 'SYSTEM'),
                                                                                                          ('CGV 안양', 7, 12, NOW(), NOW(), 'SYSTEM', 'SYSTEM'),
                                                                                                          ('롯데시네마 수원', 9, 14, NOW(), NOW(), 'SYSTEM', 'SYSTEM'),
                                                                                                          ('메가박스 부천', 8, 13, NOW(), NOW(), 'SYSTEM', 'SYSTEM'),
                                                                                                          ('CGV 광명', 6, 10, NOW(), NOW(), 'SYSTEM', 'SYSTEM');

-- Screening 데이터 대량 삽입 (약 500개)
INSERT INTO screening
(movie_id, theater_id, screening_date, start_time, end_time, created_at, modified_at, created_by, modified_by)
WITH RECURSIVE screening_data(n) AS (
    SELECT 1
    UNION ALL
    SELECT n + 1 FROM screening_data WHERE n < 500
)
SELECT
    1 + (n % 6),                                       -- movie_id
    1 + (n % 20),                                      -- theater_id
    DATE_ADD(CURRENT_DATE, INTERVAL (n % 30) DAY),     -- screening_date
    ADDTIME(NOW(), CONCAT(LPAD((n % 24), 2, '0'), ':00:00')),  -- start_time
    ADDTIME(NOW(), CONCAT(LPAD(((n % 24) + 2), 2, '0'), ':00:00')),  -- end_time
    NOW(),                                              -- created_at
    NOW(),                                              -- modified_at
    'SYSTEM',                                           -- created_by
    'SYSTEM'                                            -- modified_by
FROM screening_data LIMIT 500;