-- ✅ member (2명)
INSERT INTO member (password, name, created_by, created_at, updated_by, updated_at)
VALUES
    ('pw1234', 'Bailey', 'system', NOW(), 'system', NOW()),
    ('pw5678', 'Alice', 'system', NOW(), 'system', NOW());

-- ✅ movie (10개)
INSERT INTO movie (title, grade, genre, running_time, thumbnail, release_date, created_by, created_at, updated_by, updated_at)
VALUES
    ('Interstellar', 'AGE_12', 'SF', 169, 'https://example.com/interstellar.jpg', '2014-11-06 00:00:00', 'system', NOW(), 'system', NOW()),
    ('Titanic', 'AGE_12', 'ROMANCE', 195, 'https://example.com/titanic.jpg', '1997-12-19 00:00:00', 'system', NOW(), 'system', NOW()),
    ('The Host', 'AGE_15', 'HORROR', 119, 'https://example.com/thehost.jpg', '2006-07-27 00:00:00', 'system', NOW(), 'system', NOW()),
    ('Avengers: Endgame', 'AGE_12', 'ACTION', 181, 'https://example.com/endgame.jpg', '2019-04-24 00:00:00', 'system', NOW(), 'system', NOW()),
    ('Mad Max: Fury Road', 'AGE_15', 'ACTION', 120, 'https://example.com/madmax.jpg', '2015-05-14 00:00:00', 'system', NOW(), 'system', NOW()),
    ('The Notebook', 'AGE_12', 'ROMANCE', 123, 'https://example.com/notebook.jpg', '2004-06-25 00:00:00', 'system', NOW(), 'system', NOW()),
    ('Pride and Prejudice', 'ALL', 'ROMANCE', 129, 'https://example.com/pride.jpg', '2005-11-11 00:00:00', 'system', NOW(), 'system', NOW()),
    ('The Conjuring', 'AGE_15', 'HORROR', 112, 'https://example.com/conjuring.jpg', '2013-07-19 00:00:00', 'system', NOW(), 'system', NOW()),
    ('A Quiet Place', 'AGE_15', 'HORROR', 90, 'https://example.com/quietplace.jpg', '2018-04-06 00:00:00', 'system', NOW(), 'system', NOW()),
    ('Dune', 'AGE_12', 'SF', 155, 'https://example.com/dune.jpg', '2021-10-22 00:00:00', 'system', NOW(), 'system', NOW());

-- ✅ theater (3개)
INSERT INTO theater (name, created_by, created_at, updated_by, updated_at)
VALUES
    ('CGV', 'system', NOW(), 'system', NOW()),
    ('MEGABOX', 'system', NOW(), 'system', NOW()),
    ('LOTTE_CINEMA', 'system', NOW(), 'system', NOW());

-- ✅ seat (각 상영관에 A1~E5, 총 25개씩 → 3관 x 25 = 75개)
-- CGV (theater_id = 1)
INSERT INTO seat (theater_id, seat_row, seat_column, seat_number, created_by, created_at, updated_by, updated_at)
VALUES
    ('1','A',1,'A1','system',NOW(),'system',NOW()),
    ('1','A',2,'A2','system',NOW(),'system',NOW()),
    ('1','A',3,'A3','system',NOW(),'system',NOW()),
    ('1','A',4,'A4','system',NOW(),'system',NOW()),
    ('1','A',5,'A5','system',NOW(),'system',NOW()),
    ('1','B',1,'B1','system',NOW(),'system',NOW()),
    ('1','B',2,'B2','system',NOW(),'system',NOW()),
    ('1','B',3,'B3','system',NOW(),'system',NOW()),
    ('1','B',4,'B4','system',NOW(),'system',NOW()),
    ('1','B',5,'B5','system',NOW(),'system',NOW()),
    ('1','C',1,'C1','system',NOW(),'system',NOW()),
    ('1','C',2,'C2','system',NOW(),'system',NOW()),
    ('1','C',3,'C3','system',NOW(),'system',NOW()),
    ('1','C',4,'C4','system',NOW(),'system',NOW()),
    ('1','C',5,'C5','system',NOW(),'system',NOW()),
    ('1','D',1,'D1','system',NOW(),'system',NOW()),
    ('1','D',2,'D2','system',NOW(),'system',NOW()),
    ('1','D',3,'D3','system',NOW(),'system',NOW()),
    ('1','D',4,'D4','system',NOW(),'system',NOW()),
    ('1','D',5,'D5','system',NOW(),'system',NOW()),
    ('1','E',1,'E1','system',NOW(),'system',NOW()),
    ('1','E',2,'E2','system',NOW(),'system',NOW()),
    ('1','E',3,'E3','system',NOW(),'system',NOW()),
    ('1','E',4,'E4','system',NOW(),'system',NOW()),
    ('1','E',5,'E5','system',NOW(),'system',NOW());

-- 메가박스 (theater_id = 2)
INSERT INTO seat (theater_id, seat_row, seat_column, seat_number, created_by, created_at, updated_by, updated_at)
VALUES
    ('2','A',1,'A1','system',NOW(),'system',NOW()),
    ('2','A',2,'A2','system',NOW(),'system',NOW()),
    ('2','A',3,'A3','system',NOW(),'system',NOW()),
    ('2','A',4,'A4','system',NOW(),'system',NOW()),
    ('2','A',5,'A5','system',NOW(),'system',NOW()),
    ('2','B',1,'B1','system',NOW(),'system',NOW()),
    ('2','B',2,'B2','system',NOW(),'system',NOW()),
    ('2','B',3,'B3','system',NOW(),'system',NOW()),
    ('2','B',4,'B4','system',NOW(),'system',NOW()),
    ('2','B',5,'B5','system',NOW(),'system',NOW()),
    ('2','C',1,'C1','system',NOW(),'system',NOW()),
    ('2','C',2,'C2','system',NOW(),'system',NOW()),
    ('2','C',3,'C3','system',NOW(),'system',NOW()),
    ('2','C',4,'C4','system',NOW(),'system',NOW()),
    ('2','C',5,'C5','system',NOW(),'system',NOW()),
    ('2','D',1,'D1','system',NOW(),'system',NOW()),
    ('2','D',2,'D2','system',NOW(),'system',NOW()),
    ('2','D',3,'D3','system',NOW(),'system',NOW()),
    ('2','D',4,'D4','system',NOW(),'system',NOW()),
    ('2','D',5,'D5','system',NOW(),'system',NOW()),
    ('2','E',1,'E1','system',NOW(),'system',NOW()),
    ('2','E',2,'E2','system',NOW(),'system',NOW()),
    ('2','E',3,'E3','system',NOW(),'system',NOW()),
    ('2','E',4,'E4','system',NOW(),'system',NOW()),
    ('2','E',5,'E5','system',NOW(),'system',NOW());

-- 롯데시네마 (theater_id = 3)
INSERT INTO seat (theater_id, seat_row, seat_column, seat_number, created_by, created_at, updated_by, updated_at)
VALUES
    ('3','A',1,'A1','system',NOW(),'system',NOW()),
    ('3','A',2,'A2','system',NOW(),'system',NOW()),
    ('3','A',3,'A3','system',NOW(),'system',NOW()),
    ('3','A',4,'A4','system',NOW(),'system',NOW()),
    ('3','A',5,'A5','system',NOW(),'system',NOW()),
    ('3','B',1,'B1','system',NOW(),'system',NOW()),
    ('3','B',2,'B2','system',NOW(),'system',NOW()),
    ('3','B',3,'B3','system',NOW(),'system',NOW()),
    ('3','B',4,'B4','system',NOW(),'system',NOW()),
    ('3','B',5,'B5','system',NOW(),'system',NOW()),
    ('3','C',1,'C1','system',NOW(),'system',NOW()),
    ('3','C',2,'C2','system',NOW(),'system',NOW()),
    ('3','C',3,'C3','system',NOW(),'system',NOW()),
    ('3','C',4,'C4','system',NOW(),'system',NOW()),
    ('3','C',5,'C5','system',NOW(),'system',NOW()),
    ('3','D',1,'D1','system',NOW(),'system',NOW()),
    ('3','D',2,'D2','system',NOW(),'system',NOW()),
    ('3','D',3,'D3','system',NOW(),'system',NOW()),
    ('3','D',4,'D4','system',NOW(),'system',NOW()),
    ('3','D',5,'D5','system',NOW(),'system',NOW()),
    ('3','E',1,'E1','system',NOW(),'system',NOW()),
    ('3','E',2,'E2','system',NOW(),'system',NOW()),
    ('3','E',3,'E3','system',NOW(),'system',NOW()),
    ('3','E',4,'E4','system',NOW(),'system',NOW()),
    ('3','E',5,'E5','system',NOW(),'system',NOW());

-- ✅ schedule (각 영화관에서 2개씩 상영 시간 설정)
-- csv 파일로 넣는 걸로 (500개)
# INSERT INTO schedule (movie_id, theater_id, start_time, end_time, created_by, created_at, updated_by, updated_at)
# VALUES

-- ✅ booking (Bailey가 강남관에서 인터스텔라 예매)
INSERT INTO booking (schedule_id, member_id, seat_id, booking_status, booking_date, created_by, created_at, updated_by, updated_at)
VALUES (1, 1, 1, 'RESERVED', NOW(), 'bailey', NOW(), 'bailey', NOW());
