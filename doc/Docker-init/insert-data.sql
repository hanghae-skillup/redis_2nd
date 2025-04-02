-- cinema_movie_time 테이블
INSERT INTO cinema_movie_time (cinema_id, movie_id, movie_round, movie_start_time, movie_end_time, movie_hall, cinema_nm, screen_show_yn, create_date, modify_date, cinema_seat_cnt)
VALUES
    (1, 1, 1, '2025-04-01 14:00:00', '2025-04-01 16:30:00', 1, 'CGV 강남', TRUE, NOW(), NOW(), 100),
    (2, 2, 2, '2025-04-01 17:00:00', '2025-04-01 19:00:00', 2, '롯데시네마 홍대', TRUE, NOW(), NOW(), 150),
    (3, 3, 1, '2025-04-01 20:00:00', '2025-04-01 22:30:00', 3, '메가박스 신촌', FALSE, NOW(), NOW(), 120),
    (4, 4, 3, '2025-04-02 15:00:00', '2025-04-02 17:30:00', 1, 'CGV 왕십리', TRUE, NOW(), NOW(), 200),
    (5, 5, 2, '2025-04-02 18:00:00', '2025-04-02 20:30:00', 2, '롯데시네마 건대', TRUE, NOW(), NOW(), 130);

-- common_img 테이블
INSERT INTO common_img (img_seq, img_nm, img_path)
VALUES
    (1, 'movie_poster1.jpg', '/images/movie1.jpg'),
    (2, 'movie_poster2.jpg', '/images/movie2.jpg'),
    (3, 'movie_poster3.jpg', '/images/movie3.jpg'),
    (4, 'movie_poster4.jpg', '/images/movie4.jpg'),
    (5, 'movie_poster5.jpg', '/images/movie5.jpg');

-- movie_user 테이블
INSERT INTO movie_user (user_id, login_id, pwd, user_nm, phone_num01, phone_num02, phone_num03, use_yn, create_date, last_login_date, role)
VALUES
    (1, 'user01', 'pass01', '김철수', '010', '1234', '5678', TRUE, NOW(), NOW(), 'USER'),
    (2, 'user02', 'pass02', '이영희', '010', '2345', '6789', TRUE, NOW(), NOW(), 'USER'),
    (3, 'user03', 'pass03', '박민수', '010', '3456', '7890', FALSE, NOW(), NOW(), 'ADMIN'),
    (4, 'user04', 'pass04', '최지현', '010', '4567', '8901', TRUE, NOW(), NOW(), 'USER'),
    (5, 'user05', 'pass05', '정다연', '010', '5678', '9012', TRUE, NOW(), NOW(), 'USER');

-- movie_reser 테이블
INSERT INTO movie_reser (reser_id, seat_id, user_id, reser_cd, login_id, reser_time)
VALUES
    (1, 101, 1, 'R2025040101', 'user01', NOW()),
    (2, 102, 2, 'R2025040102', 'user02', NOW()),
    (3, 103, 3, 'R2025040103', 'user03', NOW()),
    (4, 104, 4, 'R2025040104', 'user04', NOW()),
    (5, 105, 5, 'R2025040105', 'user05', NOW());

-- movie_info 테이블
INSERT INTO movie_info (movie_id, movie_nm, genre_cd, director_nm, open_date, show_time_min, show_yn)
VALUES
    (1, '어벤져스', '액션', 'Whedon', '2012-05-04', 143, TRUE),
    (2, '인셉션', 'SF', 'Nolan', '2010-07-16', 148, TRUE),
    (3, '기생충', '드라마', '봉준호', '2019-05-30', 132, TRUE),
    (4, '인터스텔라', 'SF', 'Nolan', '2014-11-07', 169, TRUE),
    (5, '라라랜드', '뮤지컬', 'Chazelle', '2016-12-09', 128, TRUE);

-- movie_seat 테이블
INSERT INTO movie_seat (seat_id, cinema_id, seat_cd, seat_nm, seat_lv)
VALUES
    (101, 1, 'A1', 'A구역 1번', 'VIP'),
    (102, 1, 'A2', 'A구역 2번', 'VIP'),
    (103, 2, 'B1', 'B구역 1번', 'NORMAL'),
    (104, 2, 'B2', 'B구역 2번', 'NORMAL'),
    (105, 3, 'C1', 'C구역 1번', 'SUITE');

-- movie_reser_sub 테이블
INSERT INTO movie_reser_sub (id, reser_id, reser_cd, seat_Cd)
VALUES
    (1, 1, 'R2025040101', 'A1'),
    (2, 2, 'R2025040102', 'A2'),
    (3, 3, 'R2025040103', 'B1'),
    (4, 4, 'R2025040104', 'B2'),
    (5, 5, 'R2025040105', 'C1');




ALTER TABLE movie_seat ADD COLUMN is_reserved BOOLEAN NOT NULL DEFAULT FALSE;
ALTER TABLE movie_seat ADD COLUMN seatCol varchar(100);
ALTER TABLE movie_seat ADD COLUMN seatRow varchar(100);