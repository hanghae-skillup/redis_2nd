-- 재귀 깊이 제한 증가
SET @@cte_max_recursion_depth = 10000;

-- 영화 테이블 대량 데이터 생성 (200개 영화)
INSERT INTO movie (title, genre, rating, release_date, running_time, thumbnail_url, created_at, modified_at, created_by, modified_by)
WITH RECURSIVE movie_data(n) AS (
    SELECT 1
    UNION ALL
    SELECT n + 1 FROM movie_data WHERE n < 200
)
SELECT
    CASE (n % 20)
        WHEN 0 THEN CONCAT('액션 블록버스터 ', n)
        WHEN 1 THEN CONCAT('로맨틱 코미디 ', n)
        WHEN 2 THEN CONCAT('SF 어드벤처 ', n)
        WHEN 3 THEN CONCAT('판타지 대모험 ', n)
        WHEN 4 THEN CONCAT('공포 스릴러 ', n)
        WHEN 5 THEN CONCAT('가족 애니메이션 ', n)
        WHEN 6 THEN CONCAT('역사 드라마 ', n)
        WHEN 7 THEN CONCAT('첩보 액션 ', n)
        WHEN 8 THEN CONCAT('스포츠 드라마 ', n)
        WHEN 9 THEN CONCAT('뮤지컬 영화 ', n)
        WHEN 10 THEN CONCAT('서부 대모험 ', n)
        WHEN 11 THEN CONCAT('미스터리 스릴러 ', n)
        WHEN 12 THEN CONCAT('로봇 전쟁 ', n)
        WHEN 13 THEN CONCAT('수퍼히어로 ', n)
        WHEN 14 THEN CONCAT('다크 판타지 ', n)
        WHEN 15 THEN CONCAT('청춘 성장 영화 ', n)
        WHEN 16 THEN CONCAT('범죄 느와르 ', n)
        WHEN 17 THEN CONCAT('타임 트래블 ', n)
        WHEN 18 THEN CONCAT('좀비 아포칼립스 ', n)
        WHEN 19 THEN CONCAT('디스토피아 SF ', n)
        END,
    CASE (n % 10)
        WHEN 0 THEN 'ACTION'
        WHEN 1 THEN 'COMEDY'
        WHEN 2 THEN 'SF'
        WHEN 3 THEN 'FANTASY'
        WHEN 4 THEN 'HORROR'
        WHEN 5 THEN 'ANIMATION'
        WHEN 6 THEN 'DRAMA'
        WHEN 7 THEN 'THRILLER'
        WHEN 8 THEN 'ADVENTURE'
        WHEN 9 THEN 'ROMANCE'
        END,
    CASE (n % 5)
        WHEN 0 THEN '전체 관람가'
        WHEN 1 THEN '12세 관람가'
        WHEN 2 THEN '15세 관람가'
        WHEN 3 THEN '청소년 관람불가'
        WHEN 4 THEN '19세 관람가'
        END,
    -- 최근 2년 내 개봉 영화 분포 (가장 최근 6개월에 더 많은 영화 배치)
    CASE
        WHEN n % 4 = 0 THEN DATE_SUB(CURRENT_DATE(), INTERVAL (n % 180) DAY) -- 최근 6개월
        WHEN n % 4 = 1 THEN DATE_SUB(CURRENT_DATE(), INTERVAL (180 + (n % 180)) DAY) -- 6개월-1년
        WHEN n % 4 = 2 THEN DATE_SUB(CURRENT_DATE(), INTERVAL (365 + (n % 180)) DAY) -- 1년-1.5년
        ELSE DATE_SUB(CURRENT_DATE(), INTERVAL (545 + (n % 180)) DAY) -- 1.5년-2년
        END,
    -- 상영 시간 (80~180분)
    80 + (n % 101),
    CONCAT('https://example.com/movie-thumbnails/', n, '.jpg'),
    NOW(), NOW(), 'SYSTEM', 'SYSTEM'
FROM movie_data;

-- 극장 테이블 확장 (100개 극장)
INSERT INTO theater (name, created_at, modified_at, created_by, modified_by)
WITH RECURSIVE theater_data(n) AS (
    SELECT 21  -- 기존 극장이 20개까지 있으므로 21부터 시작
    UNION ALL
    SELECT n + 1 FROM theater_data WHERE n < 100
)
SELECT
    CASE (n % 3)
        WHEN 0 THEN CONCAT('메가박스 ', n, '호점')
        WHEN 1 THEN CONCAT('CGV ', n, '호점')
        ELSE CONCAT('롯데시네마 ', n, '호점')
        END,
    NOW(), NOW(), 'SYSTEM', 'SYSTEM'
FROM theater_data;

-- 현재 상영 스케줄을 대량으로 생성 (10,000개)
-- 최근 개봉 영화에 더 많은 상영 스케줄 할당
INSERT INTO screening (movie_id, theater_id, start_time, end_time, created_at, modified_at, created_by, modified_by)
WITH RECURSIVE screening_data(n) AS (
    SELECT 1
    UNION ALL
    SELECT n + 1 FROM screening_data WHERE n < 10000
)
SELECT
    -- 최근 개봉 영화(낮은 ID)에 더 많은 상영 기회 부여
    CASE
        WHEN n % 10 < 6 THEN (n % 50) + 1  -- 60%는 최근 50개 영화
        WHEN n % 10 < 9 THEN (n % 100) + 51  -- 30%는 51-150번 영화
        ELSE (n % 50) + 151  -- 10%는 151-200번 영화
        END,
    -- 극장 ID (1-100)
    (n % 100) + 1,
    -- 상영 시작 시간 (현재부터 2주 이내, 시간대 분포)
    CASE
        -- 오전(10-12시): 15%
        WHEN n % 100 < 15 THEN
            DATE_ADD(CURRENT_DATE(), INTERVAL (n % 14) DAY) + INTERVAL (10 + (n % 3)) HOUR + INTERVAL ((n * 13) % 60) MINUTE
    -- 낮(12-16시): 20%
        WHEN n % 100 < 35 THEN
        DATE_ADD(CURRENT_DATE(), INTERVAL (n % 14) DAY) + INTERVAL (12 + (n % 4)) HOUR + INTERVAL ((n * 7) % 60) MINUTE
    -- 저녁(16-20시): 35%
    WHEN n % 100 < 70 THEN
    DATE_ADD(CURRENT_DATE(), INTERVAL (n % 14) DAY) + INTERVAL (16 + (n % 4)) HOUR + INTERVAL ((n * 11) % 60) MINUTE
    -- 밤(20-24시): 30%
    ELSE
    DATE_ADD(CURRENT_DATE(), INTERVAL (n % 14) DAY) + INTERVAL (20 + (n % 4)) HOUR + INTERVAL ((n * 17) % 60) MINUTE
END,
    -- 영화 길이에 따른 종료 시간 (영화 길이는 80-180분)
    CASE
        WHEN n % 100 < 15 THEN
            DATE_ADD(CURRENT_DATE(), INTERVAL (n % 14) DAY) + INTERVAL (10 + (n % 3)) HOUR + INTERVAL ((n * 13) % 60) MINUTE + INTERVAL (80 + (n % 101)) MINUTE
        WHEN n % 100 < 35 THEN
            DATE_ADD(CURRENT_DATE(), INTERVAL (n % 14) DAY) + INTERVAL (12 + (n % 4)) HOUR + INTERVAL ((n * 7) % 60) MINUTE + INTERVAL (80 + (n % 101)) MINUTE
        WHEN n % 100 < 70 THEN
            DATE_ADD(CURRENT_DATE(), INTERVAL (n % 14) DAY) + INTERVAL (16 + (n % 4)) HOUR + INTERVAL ((n * 11) % 60) MINUTE + INTERVAL (80 + (n % 101)) MINUTE
        ELSE
            DATE_ADD(CURRENT_DATE(), INTERVAL (n % 14) DAY) + INTERVAL (20 + (n % 4)) HOUR + INTERVAL ((n * 17) % 60) MINUTE + INTERVAL (80 + (n % 101)) MINUTE
END,
    NOW(), NOW(), 'SYSTEM', 'SYSTEM'
FROM screening_data;

-- 인덱스 생성 (기존 인덱스가 있다면 DROP INDEX로 제거하고 진행)
-- 복합 인덱스: 상영 시작 시간 + 영화 ID + 극장 ID
CREATE INDEX idx_screening_start_movie_theater ON screening(start_time, movie_id, theater_id);

-- 영화 제목에 대한 전문 검색 인덱스 (LIKE '%단어%' 패턴을 위한 최적화)
ALTER TABLE movie ADD FULLTEXT INDEX idx_movie_title_fulltext (title);

-- 기본 통계 업데이트 (MySQL의 경우)
ANALYZE TABLE movie, theater, screening;