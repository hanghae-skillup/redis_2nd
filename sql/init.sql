-- 영화 테이블
INSERT INTO movies (title, release_date, running_time, thumbnail_image, genre, grade)
VALUES ('인셉션', '2010-07-21', 148, 'https://www.naver.com', 'SF', 'FIFTEEN'),
       ('범죄도시 4', '2024-04-24', 109, 'https://www.naver.com', 'ACTION', 'FIFTEEN'),
       ('타이타닉', '1998-02-20', 195, 'https://www.naver.com', 'ROMANCE', 'TWELVE'),
       ('어벤져스: 엔드게임', '2019-04-24', 181, 'https://www.naver.com', 'ACTION', 'TWELVE');


-- 극장 테이블
INSERT INTO theaters (name)
VALUES ('CGV'),
       ('롯데시네마'),
       ('메가박스');


-- 상영 테이블
INSERT INTO screenings (movie_id, theater_id, theater_name, start_time, end_time)
VALUES (1, 1, 'CGV', '14:30:00', '17:00:00'),
       (2, 2, '롯데시네마', '16:00:00', '17:49:00'),
       (3, 3, '메가박스', '19:00:00', '22:15:00'),
       (4, 2, '롯데시네마', '21:00:00', '00:01:00'),
       (1, 2, '롯데시네마', '14:30:00', '17:00:00'),
       (1, 1, 'CGV', '16:30:00', '18:00:00');


-- 좌석 테이블
INSERT INTO seats (seat_code, theater_id)
VALUES ('A1', 1),
       ('A2', 1),
       ('B1', 2),
       ('B2', 2),
       ('C1', 3),
       ('C2', 3);


-- 예약 테이블
INSERT INTO reservations (screening_id, seat_id)
VALUES (1, 1),
       (1, 2),
       (2, 3),
       (2, 4),
       (3, 5),
       (4, 6);
