-- 영화 30개 데이터 추가 (실제 영화)
INSERT INTO movies (title, rating, release_date, genre, thumbnail, running_time, created_at,
                    updated_at, created_by, updated_by) VALUES
                                                                                                                                    ('어벤져스: 엔드게임', 'R_12', '2024-12-01', 'ACTION', 'https://example.com/avengers.jpg', 181, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('기생충', 'R_15', '2024-11-20', 'HORROR', 'https://example.com/parasite.jpg', 132, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('미나리', 'R_12', '2024-11-15', 'ROMANCE', 'https://example.com/minari.jpg', 115, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('듄', 'R_12', '2024-11-10', 'SF', 'https://example.com/dune.jpg', 155, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('인터스텔라', 'R_12', '2024-11-05', 'SF', 'https://example.com/interstellar.jpg', 169, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('매트릭스', 'R_15', '2024-11-01', 'SF', 'https://example.com/matrix.jpg', 136, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('타이타닉', 'R_12', '2024-10-25', 'ROMANCE', 'https://example.com/titanic.jpg', 194, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('라라랜드', 'R_12', '2024-10-20', 'ROMANCE', 'https://example.com/lalaland.jpg', 128, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('쇼생크 탈출', 'R_15', '2024-10-15', 'ACTION', 'https://example.com/shawshank.jpg', 142, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('다크 나이트', 'R_15', '2024-10-10', 'ACTION', 'https://example.com/darkknight.jpg', 152, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('알라딘', 'R_ALL', '2024-10-05', 'ROMANCE', 'https://example.com/aladdin.jpg', 128, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('겨울왕국', 'R_ALL', '2024-10-01', 'ROMANCE', 'https://example.com/frozen.jpg', 108, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('조커', 'R_19', '2024-09-25', 'HORROR', 'https://example.com/joker.jpg', 122, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('쥬라기 월드', 'R_12', '2024-09-20', 'ACTION', 'https://example.com/jurassicworld.jpg', 124, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('인셉션', 'R_12', '2024-09-15', 'SF', 'https://example.com/inception.jpg', 148, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('아바타', 'R_12', '2024-09-10', 'SF', 'https://example.com/avatar.jpg', 162, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('킹스맨', 'R_19', '2024-09-05', 'ACTION', 'https://example.com/kingsman.jpg', 129, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('미션 임파서블', 'R_15', '2024-09-01', 'ACTION', 'https://example.com/missionimpossible.jpg', 147, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('반지의 제왕', 'R_12', '2024-08-25', 'SF', 'https://example.com/lotr.jpg', 178, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('해리 포터와 마법사의 돌', 'R_ALL', '2024-08-20', 'SF', 'https://example.com/harrypotter.jpg', 152, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('레옹', 'R_19', '2024-08-15', 'ACTION', 'https://example.com/leon.jpg', 110, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('터미네이터 2', 'R_15', '2024-08-10', 'SF', 'https://example.com/terminator.jpg', 137, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('스파이더맨: 홈커밍', 'R_12', '2024-08-05', 'ACTION', 'https://example.com/spiderman.jpg', 133, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('어벤져스: 인피니티 워', 'R_12', '2024-08-01', 'ACTION', 'https://example.com/infinitywar.jpg', 149, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('블랙 팬서', 'R_12', '2024-07-25', 'ACTION', 'https://example.com/blackpanther.jpg', 134, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('겟 아웃', 'R_15', '2024-07-20', 'HORROR', 'https://example.com/getout.jpg', 104, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('셰이프 오브 워터', 'R_19', '2024-07-15', 'ROMANCE', 'https://example.com/shapeofwater.jpg', 123, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('스타워즈: 깨어난 포스', 'R_12', '2024-07-10', 'SF', 'https://example.com/starwars.jpg', 135, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('그래비티', 'R_12', '2024-07-05', 'SF', 'https://example.com/gravity.jpg', 91, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('매드 맥스: 분노의 도로', 'R_15', '2024-07-01', 'ACTION', 'https://example.com/madmax.jpg', 120, NOW(), NOW(), 'system', 'system');

-- 추가 영화 데이터 (약 100개만 더 추가)
-- 31-50번 범위의 추가 영화
INSERT INTO movies (title, rating, release_date, genre, thumbnail, running_time, created_at,
                    updated_at, created_by, updated_by) VALUES
                                                                                                                                    ('영화 제목 31', 'R_12', '2024-06-15', 'ACTION', 'https://example.com/movie31.jpg', 125, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 32', 'R_15', '2024-06-10', 'HORROR', 'https://example.com/movie32.jpg', 118, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 33', 'R_ALL', '2024-06-05', 'ROMANCE', 'https://example.com/movie33.jpg', 132, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 34', 'R_12', '2024-06-01', 'SF', 'https://example.com/movie34.jpg', 145, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 35', 'R_19', '2024-05-25', 'ACTION', 'https://example.com/movie35.jpg', 110, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 36', 'R_12', '2024-05-20', 'ROMANCE', 'https://example.com/movie36.jpg', 128, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 37', 'R_15', '2024-05-15', 'SF', 'https://example.com/movie37.jpg', 135, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 38', 'R_ALL', '2024-05-10', 'ACTION', 'https://example.com/movie38.jpg', 142, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 39', 'R_12', '2024-05-05', 'HORROR', 'https://example.com/movie39.jpg', 115, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 40', 'R_15', '2024-05-01', 'SF', 'https://example.com/movie40.jpg', 156, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 41', 'R_12', '2024-04-25', 'ROMANCE', 'https://example.com/movie41.jpg', 123, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 42', 'R_ALL', '2024-04-20', 'ACTION', 'https://example.com/movie42.jpg', 137, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 43', 'R_15', '2024-04-15', 'SF', 'https://example.com/movie43.jpg', 144, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 44', 'R_12', '2024-04-10', 'HORROR', 'https://example.com/movie44.jpg', 118, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 45', 'R_19', '2024-04-05', 'ACTION', 'https://example.com/movie45.jpg', 129, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 46', 'R_12', '2024-04-01', 'ROMANCE', 'https://example.com/movie46.jpg', 132, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 47', 'R_15', '2024-03-25', 'ACTION', 'https://example.com/movie47.jpg', 145, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 48', 'R_ALL', '2024-03-20', 'SF', 'https://example.com/movie48.jpg', 138, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 49', 'R_12', '2024-03-15', 'HORROR', 'https://example.com/movie49.jpg', 127, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 50', 'R_15', '2024-03-10', 'ROMANCE', 'https://example.com/movie50.jpg', 119, NOW(), NOW(), 'system', 'system');

-- 51-70번 범위의 추가 영화
INSERT INTO movies (title, rating, release_date, genre, thumbnail, running_time, created_at,
                    updated_at, created_by, updated_by) VALUES
                                                                                                                                    ('영화 제목 51', 'R_12', '2024-03-05', 'SF', 'https://example.com/movie51.jpg', 152, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 52', 'R_15', '2024-03-01', 'ACTION', 'https://example.com/movie52.jpg', 136, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 53', 'R_ALL', '2024-02-25', 'ROMANCE', 'https://example.com/movie53.jpg', 128, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 54', 'R_12', '2024-02-20', 'HORROR', 'https://example.com/movie54.jpg', 117, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 55', 'R_19', '2024-02-15', 'SF', 'https://example.com/movie55.jpg', 143, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 56', 'R_12', '2024-02-10', 'ACTION', 'https://example.com/movie56.jpg', 131, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 57', 'R_15', '2024-02-05', 'ROMANCE', 'https://example.com/movie57.jpg', 122, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 58', 'R_ALL', '2024-02-01', 'SF', 'https://example.com/movie58.jpg', 147, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 59', 'R_12', '2024-01-25', 'HORROR', 'https://example.com/movie59.jpg', 113, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 60', 'R_15', '2024-01-20', 'ACTION', 'https://example.com/movie60.jpg', 138, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 61', 'R_12', '2024-01-15', 'ROMANCE', 'https://example.com/movie61.jpg', 126, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 62', 'R_ALL', '2024-01-10', 'SF', 'https://example.com/movie62.jpg', 151, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 63', 'R_15', '2024-01-05', 'ACTION', 'https://example.com/movie63.jpg', 134, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 64', 'R_12', '2024-01-01', 'HORROR', 'https://example.com/movie64.jpg', 120, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 65', 'R_19', '2023-12-25', 'ROMANCE', 'https://example.com/movie65.jpg', 129, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 66', 'R_12', '2023-12-20', 'SF', 'https://example.com/movie66.jpg', 145, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 67', 'R_15', '2023-12-15', 'ACTION', 'https://example.com/movie67.jpg', 132, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 68', 'R_ALL', '2023-12-10', 'ROMANCE', 'https://example.com/movie68.jpg', 124, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 69', 'R_12', '2023-12-05', 'HORROR', 'https://example.com/movie69.jpg', 116, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 70', 'R_15', '2023-12-01', 'SF', 'https://example.com/movie70.jpg', 139, NOW(), NOW(), 'system', 'system');

-- 71-90번 범위의 추가 영화
INSERT INTO movies (title, rating, release_date, genre, thumbnail, running_time, created_at,
                    updated_at, created_by, updated_by) VALUES
                                                                                                                                    ('영화 제목 71', 'R_12', '2023-11-25', 'ACTION', 'https://example.com/movie71.jpg', 127, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 72', 'R_15', '2023-11-20', 'ROMANCE', 'https://example.com/movie72.jpg', 135, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 73', 'R_ALL', '2023-11-15', 'SF', 'https://example.com/movie73.jpg', 148, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 74', 'R_12', '2023-11-10', 'HORROR', 'https://example.com/movie74.jpg', 118, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 75', 'R_19', '2023-11-05', 'ACTION', 'https://example.com/movie75.jpg', 130, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 76', 'R_12', '2023-11-01', 'ROMANCE', 'https://example.com/movie76.jpg', 122, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 77', 'R_15', '2023-10-25', 'SF', 'https://example.com/movie77.jpg', 142, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 78', 'R_ALL', '2023-10-20', 'ACTION', 'https://example.com/movie78.jpg', 133, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 79', 'R_12', '2023-10-15', 'HORROR', 'https://example.com/movie79.jpg', 119, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 80', 'R_15', '2023-10-10', 'ROMANCE', 'https://example.com/movie80.jpg', 125, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 81', 'R_12', '2023-10-05', 'SF', 'https://example.com/movie81.jpg', 150, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 82', 'R_ALL', '2023-10-01', 'ACTION', 'https://example.com/movie82.jpg', 137, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 83', 'R_15', '2023-09-25', 'ROMANCE', 'https://example.com/movie83.jpg', 128, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 84', 'R_12', '2023-09-20', 'HORROR', 'https://example.com/movie84.jpg', 114, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 85', 'R_19', '2023-09-15', 'SF', 'https://example.com/movie85.jpg', 143, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 86', 'R_12', '2023-09-10', 'ACTION', 'https://example.com/movie86.jpg', 131, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 87', 'R_15', '2023-09-05', 'ROMANCE', 'https://example.com/movie87.jpg', 123, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 88', 'R_ALL', '2023-09-01', 'SF', 'https://example.com/movie88.jpg', 146, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 89', 'R_12', '2023-08-25', 'HORROR', 'https://example.com/movie89.jpg', 115, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 90', 'R_15', '2023-08-20', 'ACTION', 'https://example.com/movie90.jpg', 134, NOW(), NOW(), 'system', 'system');

-- 91-110번 범위의 추가 영화
INSERT INTO movies (title, rating, release_date, genre, thumbnail, running_time, created_at,
                    updated_at, created_by, updated_by) VALUES
                                                                                                                                    ('영화 제목 91', 'R_12', '2023-08-15', 'ROMANCE', 'https://example.com/movie91.jpg', 126, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 92', 'R_15', '2023-08-10', 'SF', 'https://example.com/movie92.jpg', 144, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 93', 'R_ALL', '2023-08-05', 'ACTION', 'https://example.com/movie93.jpg', 137, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 94', 'R_12', '2023-08-01', 'HORROR', 'https://example.com/movie94.jpg', 118, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 95', 'R_19', '2023-07-25', 'ROMANCE', 'https://example.com/movie95.jpg', 129, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 96', 'R_12', '2023-07-20', 'SF', 'https://example.com/movie96.jpg', 152, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 97', 'R_15', '2023-07-15', 'ACTION', 'https://example.com/movie97.jpg', 135, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 98', 'R_ALL', '2023-07-10', 'ROMANCE', 'https://example.com/movie98.jpg', 127, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 99', 'R_12', '2023-07-05', 'HORROR', 'https://example.com/movie99.jpg', 116, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 100', 'R_15', '2023-07-01', 'SF', 'https://example.com/movie100.jpg', 140, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 101', 'R_12', '2023-06-25', 'ACTION', 'https://example.com/movie101.jpg', 132, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 102', 'R_ALL', '2023-06-20', 'ROMANCE', 'https://example.com/movie102.jpg', 124, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 103', 'R_15', '2023-06-15', 'SF', 'https://example.com/movie103.jpg', 147, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 104', 'R_12', '2023-06-10', 'HORROR', 'https://example.com/movie104.jpg', 119, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 105', 'R_19', '2023-06-05', 'ACTION', 'https://example.com/movie105.jpg', 133, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 106', 'R_12', '2023-06-01', 'ROMANCE', 'https://example.com/movie106.jpg', 125, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 107', 'R_15', '2023-05-25', 'SF', 'https://example.com/movie107.jpg', 141, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 108', 'R_ALL', '2023-05-20', 'ACTION', 'https://example.com/movie108.jpg', 136, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 109', 'R_12', '2023-05-15', 'HORROR', 'https://example.com/movie109.jpg', 120, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 110', 'R_15', '2023-05-10', 'ROMANCE', 'https://example.com/movie110.jpg', 128, NOW(), NOW(), 'system', 'system');

-- 111-130번 범위의 추가 영화
INSERT INTO movies (title, rating, release_date, genre, thumbnail, running_time, created_at,
                    updated_at, created_by, updated_by) VALUES
                                                                                                                                    ('영화 제목 111', 'R_12', '2023-05-05', 'SF', 'https://example.com/movie111.jpg', 149, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 112', 'R_15', '2023-05-01', 'ACTION', 'https://example.com/movie112.jpg', 134, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 113', 'R_ALL', '2023-04-25', 'ROMANCE', 'https://example.com/movie113.jpg', 126, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 114', 'R_12', '2023-04-20', 'HORROR', 'https://example.com/movie114.jpg', 117, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 115', 'R_19', '2023-04-15', 'SF', 'https://example.com/movie115.jpg', 145, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 116', 'R_12', '2023-04-10', 'ACTION', 'https://example.com/movie116.jpg', 130, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 117', 'R_15', '2023-04-05', 'ROMANCE', 'https://example.com/movie117.jpg', 123, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 118', 'R_ALL', '2023-04-01', 'SF', 'https://example.com/movie118.jpg', 151, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 119', 'R_12', '2023-03-25', 'HORROR', 'https://example.com/movie119.jpg', 114, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 120', 'R_15', '2023-03-20', 'ACTION', 'https://example.com/movie120.jpg', 136, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 121', 'R_12', '2023-03-15', 'ROMANCE', 'https://example.com/movie121.jpg', 125, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 122', 'R_ALL', '2023-03-10', 'SF', 'https://example.com/movie122.jpg', 142, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 123', 'R_15', '2023-03-05', 'ACTION', 'https://example.com/movie123.jpg', 138, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 124', 'R_12', '2023-03-01', 'HORROR', 'https://example.com/movie124.jpg', 119, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 125', 'R_19', '2023-02-25', 'ROMANCE', 'https://example.com/movie125.jpg', 127, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 126', 'R_12', '2023-02-20', 'SF', 'https://example.com/movie126.jpg', 144, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 127', 'R_15', '2023-02-15', 'ACTION', 'https://example.com/movie127.jpg', 133, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 128', 'R_ALL', '2023-02-10', 'ROMANCE', 'https://example.com/movie128.jpg', 122, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 129', 'R_12', '2023-02-05', 'HORROR', 'https://example.com/movie129.jpg', 116, NOW(), NOW(), 'system', 'system'),
                                                                                                                                    ('영화 제목 130', 'R_15', '2023-02-01', 'SF', 'https://example.com/movie130.jpg', 139, NOW(), NOW(), 'system', 'system');

-- 영화 개봉일 랜덤하게 섞기 (1-30번 영화)
UPDATE movies SET release_date = '2025-01-15' WHERE movie_id = 1;
UPDATE movies SET release_date = '2024-11-23' WHERE movie_id = 2;
UPDATE movies SET release_date = '2025-02-05' WHERE movie_id = 3;
UPDATE movies SET release_date = '2024-10-19' WHERE movie_id = 4;
UPDATE movies SET release_date = '2024-12-30' WHERE movie_id = 5;
UPDATE movies SET release_date = '2025-03-08' WHERE movie_id = 6;
UPDATE movies SET release_date = '2024-09-27' WHERE movie_id = 7;
UPDATE movies SET release_date = '2025-01-02' WHERE movie_id = 8;
UPDATE movies SET release_date = '2024-11-11' WHERE movie_id = 9;
UPDATE movies SET release_date = '2024-12-18' WHERE movie_id = 10;
UPDATE movies SET release_date = '2025-02-22' WHERE movie_id = 11;
UPDATE movies SET release_date = '2024-10-07' WHERE movie_id = 12;
UPDATE movies SET release_date = '2024-12-04' WHERE movie_id = 13;
UPDATE movies SET release_date = '2025-01-29' WHERE movie_id = 14;
UPDATE movies SET release_date = '2024-11-05' WHERE movie_id = 15;
UPDATE movies SET release_date = '2024-09-15' WHERE movie_id = 16;
UPDATE movies SET release_date = '2025-03-14' WHERE movie_id = 17;
UPDATE movies SET release_date = '2024-10-31' WHERE movie_id = 18;
UPDATE movies SET release_date = '2025-01-08' WHERE movie_id = 19;
UPDATE movies SET release_date = '2024-12-22' WHERE movie_id = 20;
UPDATE movies SET release_date = '2024-11-18' WHERE movie_id = 21;
UPDATE movies SET release_date = '2025-02-10' WHERE movie_id = 22;
UPDATE movies SET release_date = '2024-10-03' WHERE movie_id = 23;
UPDATE movies SET release_date = '2024-12-27' WHERE movie_id = 24;
UPDATE movies SET release_date = '2025-01-21' WHERE movie_id = 25;
UPDATE movies SET release_date = '2024-11-29' WHERE movie_id = 26;
UPDATE movies SET release_date = '2024-09-21' WHERE movie_id = 27;
UPDATE movies SET release_date = '2025-02-28' WHERE movie_id = 28;
UPDATE movies SET release_date = '2024-10-26' WHERE movie_id = 29;
UPDATE movies SET release_date = '2024-12-12' WHERE movie_id = 30;

-- 영화 개봉일 랜덤하게 섞기 (31-60번 영화)
UPDATE movies SET release_date = '2025-03-03' WHERE movie_id = 31;
UPDATE movies SET release_date = '2024-11-07' WHERE movie_id = 32;
UPDATE movies SET release_date = '2025-01-12' WHERE movie_id = 33;
UPDATE movies SET release_date = '2024-10-14' WHERE movie_id = 34;
UPDATE movies SET release_date = '2024-12-09' WHERE movie_id = 35;
UPDATE movies SET release_date = '2025-02-19' WHERE movie_id = 36;
UPDATE movies SET release_date = '2024-09-30' WHERE movie_id = 37;
UPDATE movies SET release_date = '2025-01-25' WHERE movie_id = 38;
UPDATE movies SET release_date = '2024-11-03' WHERE movie_id = 39;
UPDATE movies SET release_date = '2024-12-16' WHERE movie_id = 40;
UPDATE movies SET release_date = '2025-02-15' WHERE movie_id = 41;
UPDATE movies SET release_date = '2024-10-10' WHERE movie_id = 42;
UPDATE movies SET release_date = '2024-12-01' WHERE movie_id = 43;
UPDATE movies SET release_date = '2025-01-18' WHERE movie_id = 44;
UPDATE movies SET release_date = '2024-11-21' WHERE movie_id = 45;
UPDATE movies SET release_date = '2024-09-18' WHERE movie_id = 46;
UPDATE movies SET release_date = '2025-03-10' WHERE movie_id = 47;
UPDATE movies SET release_date = '2024-10-22' WHERE movie_id = 48;
UPDATE movies SET release_date = '2025-01-05' WHERE movie_id = 49;
UPDATE movies SET release_date = '2024-12-20' WHERE movie_id = 50;
UPDATE movies SET release_date = '2024-11-14' WHERE movie_id = 51;
UPDATE movies SET release_date = '2025-02-07' WHERE movie_id = 52;
UPDATE movies SET release_date = '2024-10-05' WHERE movie_id = 53;
UPDATE movies SET release_date = '2024-12-25' WHERE movie_id = 54;
UPDATE movies SET release_date = '2025-01-23' WHERE movie_id = 55;
UPDATE movies SET release_date = '2024-11-27' WHERE movie_id = 56;
UPDATE movies SET release_date = '2024-09-24' WHERE movie_id = 57;
UPDATE movies SET release_date = '2025-02-25' WHERE movie_id = 58;
UPDATE movies SET release_date = '2024-10-28' WHERE movie_id = 59;
UPDATE movies SET release_date = '2024-12-07' WHERE movie_id = 60;

-- 영화 개봉일 랜덤하게 섞기 (61-90번 영화)
UPDATE movies SET release_date = '2025-03-01' WHERE movie_id = 61;
UPDATE movies SET release_date = '2024-11-09' WHERE movie_id = 62;
UPDATE movies SET release_date = '2025-01-16' WHERE movie_id = 63;
UPDATE movies SET release_date = '2024-10-17' WHERE movie_id = 64;
UPDATE movies SET release_date = '2024-12-02' WHERE movie_id = 65;
UPDATE movies SET release_date = '2025-02-13' WHERE movie_id = 66;
UPDATE movies SET release_date = '2024-09-25' WHERE movie_id = 67;
UPDATE movies SET release_date = '2025-01-27' WHERE movie_id = 68;
UPDATE movies SET release_date = '2024-11-01' WHERE movie_id = 69;
UPDATE movies SET release_date = '2024-12-14' WHERE movie_id = 70;
UPDATE movies SET release_date = '2025-02-17' WHERE movie_id = 71;
UPDATE movies SET release_date = '2024-10-08' WHERE movie_id = 72;
UPDATE movies SET release_date = '2024-12-06' WHERE movie_id = 73;
UPDATE movies SET release_date = '2025-01-14' WHERE movie_id = 74;
UPDATE movies SET release_date = '2024-11-25' WHERE movie_id = 75;
UPDATE movies SET release_date = '2024-09-22' WHERE movie_id = 76;
UPDATE movies SET release_date = '2025-03-12' WHERE movie_id = 77;
UPDATE movies SET release_date = '2024-10-24' WHERE movie_id = 78;
UPDATE movies SET release_date = '2025-01-07' WHERE movie_id = 79;
UPDATE movies SET release_date = '2024-12-19' WHERE movie_id = 80;
UPDATE movies SET release_date = '2024-11-16' WHERE movie_id = 81;
UPDATE movies SET release_date = '2025-02-09' WHERE movie_id = 82;
UPDATE movies SET release_date = '2024-10-02' WHERE movie_id = 83;
UPDATE movies SET release_date = '2024-12-28' WHERE movie_id = 84;
UPDATE movies SET release_date = '2025-01-20' WHERE movie_id = 85;
UPDATE movies SET release_date = '2024-11-30' WHERE movie_id = 86;
UPDATE movies SET release_date = '2024-09-19' WHERE movie_id = 87;
UPDATE movies SET release_date = '2025-02-26' WHERE movie_id = 88;
UPDATE movies SET release_date = '2024-10-29' WHERE movie_id = 89;
UPDATE movies SET release_date = '2024-12-11' WHERE movie_id = 90;

-- 영화 개봉일 랜덤하게 섞기 (91-120번 영화)
UPDATE movies SET release_date = '2025-03-05' WHERE movie_id = 91;
UPDATE movies SET release_date = '2024-11-13' WHERE movie_id = 92;
UPDATE movies SET release_date = '2025-01-10' WHERE movie_id = 93;
UPDATE movies SET release_date = '2024-10-16' WHERE movie_id = 94;
UPDATE movies SET release_date = '2024-12-03' WHERE movie_id = 95;
UPDATE movies SET release_date = '2025-02-14' WHERE movie_id = 96;
UPDATE movies SET release_date = '2024-09-28' WHERE movie_id = 97;
UPDATE movies SET release_date = '2025-01-24' WHERE movie_id = 98;
UPDATE movies SET release_date = '2024-11-02' WHERE movie_id = 99;
UPDATE movies SET release_date = '2024-12-17' WHERE movie_id = 100;
UPDATE movies SET release_date = '2025-02-20' WHERE movie_id = 101;
UPDATE movies SET release_date = '2024-10-11' WHERE movie_id = 102;
UPDATE movies SET release_date = '2024-12-05' WHERE movie_id = 103;
UPDATE movies SET release_date = '2025-01-17' WHERE movie_id = 104;
UPDATE movies SET release_date = '2024-11-20' WHERE movie_id = 105;
UPDATE movies SET release_date = '2024-09-17' WHERE movie_id = 106;
UPDATE movies SET release_date = '2025-03-07' WHERE movie_id = 107;
UPDATE movies SET release_date = '2024-10-21' WHERE movie_id = 108;
UPDATE movies SET release_date = '2025-01-04' WHERE movie_id = 109;
UPDATE movies SET release_date = '2024-12-23' WHERE movie_id = 110;
UPDATE movies SET release_date = '2024-11-15' WHERE movie_id = 111;
UPDATE movies SET release_date = '2025-02-08' WHERE movie_id = 112;
UPDATE movies SET release_date = '2024-10-06' WHERE movie_id = 113;
UPDATE movies SET release_date = '2024-12-26' WHERE movie_id = 114;
UPDATE movies SET release_date = '2025-01-22' WHERE movie_id = 115;
UPDATE movies SET release_date = '2024-11-28' WHERE movie_id = 116;
UPDATE movies SET release_date = '2024-09-23' WHERE movie_id = 117;
UPDATE movies SET release_date = '2025-02-27' WHERE movie_id = 118;
UPDATE movies SET release_date = '2024-10-27' WHERE movie_id = 119;
UPDATE movies SET release_date = '2024-12-13' WHERE movie_id = 120;

-- 영화 개봉일 랜덤하게 섞기 (121-130번 영화)
UPDATE movies SET release_date = '2025-03-04' WHERE movie_id = 121;
UPDATE movies SET release_date = '2024-11-06' WHERE movie_id = 122;
UPDATE movies SET release_date = '2025-01-13' WHERE movie_id = 123;
UPDATE movies SET release_date = '2024-10-15' WHERE movie_id = 124;
UPDATE movies SET release_date = '2024-12-08' WHERE movie_id = 125;
UPDATE movies SET release_date = '2025-02-18' WHERE movie_id = 126;
UPDATE movies SET release_date = '2024-09-26' WHERE movie_id = 127;
UPDATE movies SET release_date = '2025-01-28' WHERE movie_id = 128;
UPDATE movies SET release_date = '2024-11-04' WHERE movie_id = 129;
UPDATE movies SET release_date = '2024-12-15' WHERE movie_id = 130;

-- 상영관 3개 생성
INSERT INTO screens (name, created_at, updated_at, created_by, updated_by) VALUES
                                                                              ('노떼 시네마 1관',
                                                                               NOW(),
                                                                               NOW(), 'system', 'system'),
                                                                              ('쒸쥐뷔 프리미엄 8관', NOW(),
                                                                               NOW(), 'system', 'system'),
                                                                              ('기가테라박스 2관', NOW(),
                                                                               NOW(),
                                                                               'system', 'system');

-- 좌석 데이터 (상영관 1)
INSERT INTO seats (row_no, column_no, screen_id, created_at, updated_at, created_by, updated_by)
VALUES
                                                                                                    ('A', 1, 1, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('A', 2, 1, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('A', 3, 1, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('A', 4, 1, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('A', 5, 1, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('B', 1, 1, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('B', 2, 1, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('B', 3, 1, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('B', 4, 1, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('B', 5, 1, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('C', 1, 1, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('C', 2, 1, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('C', 3, 1, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('C', 4, 1, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('C', 5, 1, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('D', 1, 1, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('D', 2, 1, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('D', 3, 1, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('D', 4, 1, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('D', 5, 1, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('E', 1, 1, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('E', 2, 1, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('E', 3, 1, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('E', 4, 1, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('E', 5, 1, NOW(), NOW(), 'system', 'system');

-- 좌석 데이터 (상영관 2)
INSERT INTO seats (row_no, column_no, screen_id, created_at, updated_at, created_by, updated_by)
VALUES
                                                                                                    ('A', 1, 2, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('A', 2, 2, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('A', 3, 2, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('A', 4, 2, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('A', 5, 2, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('B', 1, 2, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('B', 2, 2, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('B', 3, 2, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('B', 4, 2, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('B', 5, 2, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('C', 1, 2, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('C', 2, 2, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('C', 3, 2, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('C', 4, 2, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('C', 5, 2, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('D', 1, 2, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('D', 2, 2, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('D', 3, 2, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('D', 4, 2, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('D', 5, 2, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('E', 1, 2, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('E', 2, 2, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('E', 3, 2, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('E', 4, 2, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('E', 5, 2, NOW(), NOW(), 'system', 'system');

-- 좌석 데이터 (상영관 3)
INSERT INTO seats (row_no, column_no, screen_id, created_at, updated_at, created_by, updated_by)
VALUES
                                                                                                    ('A', 1, 3, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('A', 2, 3, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('A', 3, 3, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('A', 4, 3, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('A', 5, 3, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('B', 1, 3, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('B', 2, 3, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('B', 3, 3, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('B', 4, 3, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('B', 5, 3, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('C', 1, 3, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('C', 2, 3, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('C', 3, 3, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('C', 4, 3, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('C', 5, 3, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('D', 1, 3, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('D', 2, 3, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('D', 3, 3, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('D', 4, 3, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('D', 5, 3, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('E', 1, 3, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('E', 2, 3, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('E', 3, 3, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('E', 4, 3, NOW(), NOW(), 'system', 'system'),
                                                                                                    ('E', 5, 3, NOW(), NOW(), 'system', 'system');

-- 과거 날짜(최근 7일 전부터 3일 전까지)의 상영 스케줄 데이터 (상영관 1)
INSERT INTO schedules (movie_id, screen_id, start, end, created_at, updated_at, created_by, updated_by) VALUES
-- 7일 전
(5, 1, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 7 DAY), '10:00:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 7 DAY), '12:30:00'), NOW(), NOW(), 'system', 'system'),
(10, 1, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 7 DAY), '13:00:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 7 DAY), '15:15:00'), NOW(), NOW(), 'system', 'system'),
(15, 1, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 7 DAY), '16:00:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 7 DAY), '18:45:00'), NOW(), NOW(), 'system', 'system'),
(20, 1, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 7 DAY), '19:30:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 7 DAY), '21:45:00'), NOW(), NOW(), 'system', 'system'),
(25, 1, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 7 DAY), '22:15:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 7 DAY), '00:30:00'), NOW(), NOW(), 'system', 'system'),

-- 6일 전
(8, 1, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 6 DAY), '09:30:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 6 DAY), '11:45:00'), NOW(), NOW(), 'system', 'system'),
(12, 1, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 6 DAY), '12:30:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 6 DAY), '14:45:00'), NOW(), NOW(), 'system', 'system'),
(16, 1, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 6 DAY), '15:30:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 6 DAY), '17:45:00'), NOW(), NOW(), 'system', 'system'),
(22, 1, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 6 DAY), '18:30:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 6 DAY), '20:45:00'), NOW(), NOW(), 'system', 'system'),
(28, 1, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 6 DAY), '21:15:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 6 DAY), '23:30:00'), NOW(), NOW(), 'system', 'system'),

-- 5일 전
(3, 1, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 5 DAY), '10:15:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 5 DAY), '12:30:00'), NOW(), NOW(), 'system', 'system'),
(9, 1, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 5 DAY), '13:15:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 5 DAY), '15:30:00'), NOW(), NOW(), 'system', 'system'),
(18, 1, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 5 DAY), '16:15:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 5 DAY), '18:45:00'), NOW(), NOW(), 'system', 'system'),
(24, 1, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 5 DAY), '19:30:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 5 DAY), '22:00:00'), NOW(), NOW(), 'system', 'system'),
(30, 1, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 5 DAY), '22:30:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 5 DAY), '00:45:00'), NOW(), NOW(), 'system', 'system'),

-- 4일 전
(1, 1, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 4 DAY), '10:45:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 4 DAY), '13:00:00'), NOW(), NOW(), 'system', 'system'),
(7, 1, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 4 DAY), '13:45:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 4 DAY), '16:00:00'), NOW(), NOW(), 'system', 'system'),
(13, 1, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 4 DAY), '16:45:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 4 DAY), '19:00:00'), NOW(), NOW(), 'system', 'system'),
(19, 1, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 4 DAY), '19:45:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 4 DAY), '22:00:00'), NOW(), NOW(), 'system', 'system'),
(25, 1, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 4 DAY), '22:30:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 4 DAY), '00:45:00'), NOW(), NOW(), 'system', 'system'),

-- 3일 전
(4, 1, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 3 DAY), '11:00:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 3 DAY), '13:15:00'), NOW(), NOW(), 'system', 'system'),
(10, 1, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 3 DAY), '14:00:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 3 DAY), '16:15:00'), NOW(), NOW(), 'system', 'system'),
(16, 1, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 3 DAY), '17:00:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 3 DAY), '19:15:00'), NOW(), NOW(), 'system', 'system'),
(22, 1, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 3 DAY), '20:00:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 3 DAY), '22:15:00'), NOW(), NOW(), 'system', 'system'),
(28, 1, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 3 DAY), '22:45:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 3 DAY), '01:00:00'), NOW(), NOW(), 'system', 'system');

-- 과거 날짜의 상영 스케줄 데이터 (상영관 2)
INSERT INTO schedules (movie_id, screen_id, start, end, created_at, updated_at, created_by, updated_by) VALUES
-- 7일 전
(2, 2, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 7 DAY), '09:45:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 7 DAY), '12:00:00'), NOW(), NOW(), 'system', 'system'),
(8, 2, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 7 DAY), '12:45:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 7 DAY), '15:00:00'), NOW(), NOW(), 'system', 'system'),
(14, 2, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 7 DAY), '15:45:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 7 DAY), '18:00:00'), NOW(), NOW(), 'system', 'system'),
(20, 2, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 7 DAY), '18:45:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 7 DAY), '21:00:00'), NOW(), NOW(), 'system', 'system'),
(26, 2, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 7 DAY), '21:30:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 7 DAY), '23:45:00'), NOW(), NOW(), 'system', 'system'),

-- 5일 전
(6, 2, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 5 DAY), '10:30:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 5 DAY), '12:45:00'), NOW(), NOW(), 'system', 'system'),
(12, 2, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 5 DAY), '13:30:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 5 DAY), '15:45:00'), NOW(), NOW(), 'system', 'system'),
(18, 2, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 5 DAY), '16:30:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 5 DAY), '18:45:00'), NOW(), NOW(), 'system', 'system'),
(24, 2, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 5 DAY), '19:30:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 5 DAY), '21:45:00'), NOW(), NOW(), 'system', 'system'),
(30, 2, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 5 DAY), '22:15:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 5 DAY), '00:30:00'), NOW(), NOW(), 'system', 'system'),

-- 3일 전
(1, 2, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 3 DAY), '10:15:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 3 DAY), '12:30:00'), NOW(), NOW(), 'system', 'system'),
(7, 2, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 3 DAY), '13:15:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 3 DAY), '15:30:00'), NOW(), NOW(), 'system', 'system'),
(13, 2, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 3 DAY), '16:15:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 3 DAY), '18:30:00'), NOW(), NOW(), 'system', 'system'),
(19, 2, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 3 DAY), '19:15:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 3 DAY), '21:30:00'), NOW(), NOW(), 'system', 'system'),
(25, 2, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 3 DAY), '22:00:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 3 DAY), '00:15:00'), NOW(), NOW(), 'system', 'system');

-- 현재 날짜와 미래 날짜의 상영 스케줄 데이터 (상영관 1) - 시간 불규칙화
INSERT INTO schedules (movie_id, screen_id, start, end, created_at, updated_at, created_by, updated_by) VALUES
-- 현재 날짜
(3, 1, TIMESTAMP(CURDATE(), '09:45:00'), TIMESTAMP(CURDATE(), '12:00:00'), NOW(), NOW(), 'system', 'system'),
(9, 1, TIMESTAMP(CURDATE(), '12:30:00'), TIMESTAMP(CURDATE(), '14:45:00'), NOW(), NOW(), 'system', 'system'),
(15, 1, TIMESTAMP(CURDATE(), '15:15:00'), TIMESTAMP(CURDATE(), '17:30:00'), NOW(), NOW(), 'system', 'system'),
(21, 1, TIMESTAMP(CURDATE(), '18:00:00'), TIMESTAMP(CURDATE(), '20:15:00'), NOW(), NOW(), 'system', 'system'),
(27, 1, TIMESTAMP(CURDATE(), '20:45:00'), TIMESTAMP(CURDATE(), '23:00:00'), NOW(), NOW(), 'system', 'system'),

-- 현재 날짜 + 1일
(5, 1, TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 1 DAY), '10:15:00'), TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 1 DAY), '12:30:00'), NOW(), NOW(), 'system', 'system'),
(11, 1, TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 1 DAY), '13:15:00'), TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 1 DAY), '15:30:00'), NOW(), NOW(), 'system', 'system'),
(17, 1, TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 1 DAY), '16:15:00'), TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 1 DAY), '18:30:00'), NOW(), NOW(), 'system', 'system'),
(23, 1, TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 1 DAY), '19:15:00'), TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 1 DAY), '21:30:00'), NOW(), NOW(), 'system', 'system'),
(29, 1, TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 1 DAY), '22:00:00'), TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 1 DAY), '00:15:00'), NOW(), NOW(), 'system', 'system'),

-- 현재 날짜 + 2일
(2, 1, TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 2 DAY), '10:30:00'), TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 2 DAY), '12:45:00'), NOW(), NOW(), 'system', 'system'),
(8, 1, TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 2 DAY), '13:30:00'), TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 2 DAY), '15:45:00'), NOW(), NOW(), 'system', 'system'),
(14, 1, TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 2 DAY), '16:30:00'), TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 2 DAY), '18:45:00'), NOW(), NOW(), 'system', 'system'),
(20, 1, TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 2 DAY), '19:30:00'), TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 2 DAY), '21:45:00'), NOW(), NOW(), 'system', 'system'),
(26, 1, TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 2 DAY), '22:15:00'), TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 2 DAY), '00:30:00'), NOW(), NOW(), 'system', 'system');

-- 현재 날짜와 미래 날짜의 상영 스케줄 데이터 (상영관 2) - 시간 불규칙화
INSERT INTO schedules (movie_id, screen_id, start, end, created_at, updated_at, created_by, updated_by) VALUES
-- 현재 날짜
(4, 2, TIMESTAMP(CURDATE(), '09:30:00'), TIMESTAMP(CURDATE(), '11:45:00'), NOW(), NOW(), 'system', 'system'),
(10, 2, TIMESTAMP(CURDATE(), '12:15:00'), TIMESTAMP(CURDATE(), '14:30:00'), NOW(), NOW(), 'system', 'system'),
(16, 2, TIMESTAMP(CURDATE(), '15:00:00'), TIMESTAMP(CURDATE(), '17:15:00'), NOW(), NOW(), 'system', 'system'),
(22, 2, TIMESTAMP(CURDATE(), '17:45:00'), TIMESTAMP(CURDATE(), '20:00:00'), NOW(), NOW(), 'system', 'system'),
(28, 2, TIMESTAMP(CURDATE(), '20:30:00'), TIMESTAMP(CURDATE(), '22:45:00'), NOW(), NOW(), 'system', 'system'),

-- 현재 날짜 + 1일
(6, 2, TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 1 DAY), '10:00:00'), TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 1 DAY), '12:15:00'), NOW(), NOW(), 'system', 'system'),
(12, 2, TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 1 DAY), '13:00:00'), TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 1 DAY), '15:15:00'), NOW(), NOW(), 'system', 'system'),
(18, 2, TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 1 DAY), '16:00:00'), TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 1 DAY), '18:15:00'), NOW(), NOW(), 'system', 'system'),
(24, 2, TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 1 DAY), '19:00:00'), TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 1 DAY), '21:15:00'), NOW(), NOW(), 'system', 'system'),
(30, 2, TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 1 DAY), '21:45:00'), TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 1 DAY), '00:00:00'), NOW(), NOW(), 'system', 'system'),

-- 현재 날짜 + 2일
(1, 2, TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 2 DAY), '10:45:00'), TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 2 DAY), '13:00:00'), NOW(), NOW(), 'system', 'system'),
(7, 2, TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 2 DAY), '13:45:00'), TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 2 DAY), '16:00:00'), NOW(), NOW(), 'system', 'system'),
(13, 2, TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 2 DAY), '16:45:00'), TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 2 DAY), '19:00:00'), NOW(), NOW(), 'system', 'system'),
(19, 2, TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 2 DAY), '19:45:00'), TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 2 DAY), '22:00:00'), NOW(), NOW(), 'system', 'system'),
(25, 2, TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 2 DAY), '22:30:00'), TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 2 DAY), '00:45:00'), NOW(), NOW(), 'system', 'system');

-- 상영관 3에 불규칙한 시간과 날짜 간격을 가진 데이터 추가
INSERT INTO schedules (movie_id, screen_id, start, end, created_at, updated_at, created_by, updated_by) VALUES
-- 과거(8일 전, 불규칙한 날짜)
(5, 3, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 8 DAY), '11:15:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 8 DAY), '13:30:00'), NOW(), NOW(), 'system', 'system'),
(12, 3, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 8 DAY), '14:15:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 8 DAY), '16:30:00'), NOW(), NOW(), 'system', 'system'),
(19, 3, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 8 DAY), '17:15:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 8 DAY), '19:30:00'), NOW(), NOW(), 'system', 'system'),
(26, 3, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 8 DAY), '20:15:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 8 DAY), '22:30:00'), NOW(), NOW(), 'system', 'system'),

-- 과거(5일 전, 불규칙한 시간)
(3, 3, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 5 DAY), '10:25:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 5 DAY), '12:40:00'), NOW(), NOW(), 'system', 'system'),
(9, 3, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 5 DAY), '13:15:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 5 DAY), '15:30:00'), NOW(), NOW(), 'system', 'system'),
(15, 3, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 5 DAY), '16:20:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 5 DAY), '18:35:00'), NOW(), NOW(), 'system', 'system'),
(21, 3, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 5 DAY), '19:05:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 5 DAY), '21:20:00'), NOW(), NOW(), 'system', 'system'),
(27, 3, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 5 DAY), '21:50:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 5 DAY), '00:05:00'), NOW(), NOW(), 'system', 'system'),

-- 현재 날짜(불규칙한 시간)
(7, 3, TIMESTAMP(CURDATE(), '09:55:00'), TIMESTAMP(CURDATE(), '12:10:00'), NOW(), NOW(), 'system', 'system'),
(14, 3, TIMESTAMP(CURDATE(), '12:50:00'), TIMESTAMP(CURDATE(), '15:05:00'), NOW(), NOW(), 'system', 'system'),
(21, 3, TIMESTAMP(CURDATE(), '15:40:00'), TIMESTAMP(CURDATE(), '17:55:00'), NOW(), NOW(), 'system', 'system'),
(28, 3, TIMESTAMP(CURDATE(), '18:35:00'), TIMESTAMP(CURDATE(), '20:50:00'), NOW(), NOW(), 'system', 'system'),
(5, 3, TIMESTAMP(CURDATE(), '21:25:00'), TIMESTAMP(CURDATE(), '23:40:00'), NOW(), NOW(), 'system', 'system'),

-- 미래(3일 후, 매우 불규칙한 시간)
(2, 3, TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 3 DAY), '09:20:00'), TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 3 DAY), '11:35:00'), NOW(), NOW(), 'system', 'system'),
(8, 3, TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 3 DAY), '12:05:00'), TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 3 DAY), '14:20:00'), NOW(), NOW(), 'system', 'system'),
(16, 3, TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 3 DAY), '15:10:00'), TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 3 DAY), '17:25:00'), NOW(), NOW(), 'system', 'system'),
(24, 3, TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 3 DAY), '18:15:00'), TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 3 DAY), '20:30:00'), NOW(), NOW(), 'system', 'system'),
(30, 3, TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 3 DAY), '21:10:00'), TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 3 DAY), '23:25:00'), NOW(), NOW(), 'system', 'system'),

-- 미래(5일 후, 불규칙한 시간)
(4, 3, TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 5 DAY), '10:40:00'), TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 5 DAY), '12:55:00'), NOW(), NOW(), 'system', 'system'),
(10, 3, TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 5 DAY), '13:30:00'), TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 5 DAY), '15:45:00'), NOW(), NOW(), 'system', 'system'),
(18, 3, TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 5 DAY), '16:35:00'), TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 5 DAY), '18:50:00'), NOW(), NOW(), 'system', 'system'),
(25, 3, TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 5 DAY), '19:25:00'), TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 5 DAY), '21:40:00'), NOW(), NOW(), 'system', 'system'),
(1, 3, TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 5 DAY), '22:10:00'), TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 5 DAY), '00:25:00'), NOW(), NOW(), 'system', 'system');

-- 추가 불규칙한 상영 일정(상영관 1-3에 분배)
INSERT INTO schedules (movie_id, screen_id, start, end, created_at, updated_at, created_by, updated_by) VALUES
-- 상영관 1(불규칙한 과거 날짜)
(8, 1, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 10 DAY), '10:05:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 10 DAY), '12:20:00'), NOW(), NOW(), 'system', 'system'),
(17, 1, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 7 DAY), '14:35:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 7 DAY), '16:50:00'), NOW(), NOW(), 'system', 'system'),

-- 상영관 2(불규칙한 과거와 현재)
(26, 2, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 4 DAY), '18:55:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 4 DAY), '21:10:00'), NOW(), NOW(), 'system', 'system'),
(5, 2, TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 1 DAY), '09:25:00'), TIMESTAMP(DATE_SUB(CURDATE(), INTERVAL 1 DAY), '11:40:00'), NOW(), NOW(), 'system', 'system'),
(14, 2, TIMESTAMP(CURDATE(), '13:15:00'), TIMESTAMP(CURDATE(), '15:30:00'), NOW(), NOW(), 'system', 'system'),

-- 상영관 3(불규칙한 미래 날짜)
(23, 3, TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 1 DAY), '17:30:00'), TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 1 DAY), '19:45:00'), NOW(), NOW(), 'system', 'system'),
(2, 3, TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 3 DAY), '10:45:00'), TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 3 DAY), '13:00:00'), NOW(), NOW(), 'system', 'system'),
(11, 3, TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 4 DAY), '14:20:00'), TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 4 DAY), '16:35:00'), NOW(), NOW(), 'system', 'system'),
(20, 3, TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 6 DAY), '18:10:00'), TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 6 DAY), '20:25:00'), NOW(), NOW(), 'system', 'system'),
(29, 3, TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 7 DAY), '20:55:00'), TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 7 DAY), '23:10:00'), NOW(), NOW(), 'system', 'system');

-- 가까운 미래 상영 일정(1~2주 이내)
INSERT INTO schedules (movie_id, screen_id, start, end, created_at, updated_at, created_by, updated_by) VALUES
-- 상영관 1(다음 주)
(3, 1, TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 8 DAY), '10:30:00'), TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 8 DAY), '12:45:00'), NOW(), NOW(), 'system', 'system'),
(9, 1, TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 8 DAY), '13:30:00'), TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 8 DAY), '15:45:00'), NOW(), NOW(), 'system', 'system'),
(15, 1, TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 8 DAY), '16:30:00'), TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 8 DAY), '18:45:00'), NOW(), NOW(), 'system', 'system'),

-- 상영관 2(다음 주)
(6, 2, TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 9 DAY), '10:15:00'), TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 9 DAY), '12:30:00'), NOW(), NOW(), 'system', 'system'),
(12, 2, TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 9 DAY), '13:15:00'), TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 9 DAY), '15:30:00'), NOW(), NOW(), 'system', 'system'),
(18, 2, TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 9 DAY), '16:15:00'), TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 9 DAY), '18:30:00'), NOW(), NOW(), 'system', 'system'),

-- 상영관 3(2주 이내)
(10, 3, TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 12 DAY), '11:00:00'), TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 12 DAY), '13:15:00'), NOW(), NOW(), 'system', 'system'),
(20, 3, TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 12 DAY), '14:00:00'), TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 12 DAY), '16:15:00'), NOW(), NOW(), 'system', 'system'),
(30, 3, TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 12 DAY), '17:00:00'), TIMESTAMP(DATE_ADD(CURDATE(), INTERVAL 12 DAY), '19:15:00'), NOW(), NOW(), 'system', 'system');