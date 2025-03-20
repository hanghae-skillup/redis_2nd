--  1. 극장 (theater) 테이블 생성
CREATE TABLE theater (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         created_by VARCHAR(255),
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         modified_by VARCHAR(255),
                         modified_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

--  2. 상영관 (screen) 테이블 생성
CREATE TABLE screen (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        theater_id BIGINT NOT NULL,
                        name VARCHAR(255) NOT NULL,
                        created_by VARCHAR(255),
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        modified_by VARCHAR(255),
                        modified_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- 3. 영화 (movie) 테이블 생성
CREATE TABLE movie (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       rating VARCHAR(50),
                       genre VARCHAR(100),
                       thumbnail_url VARCHAR(255),
                       running_time INT NOT NULL,
                       released_at DATE NOT NULL,
                       created_by VARCHAR(255),
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       modified_by VARCHAR(255),
                       modified_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

--  4. 사용자 계정 (user_account) 테이블 생성
CREATE TABLE member (
                              id BIGINT AUTO_INCREMENT PRIMARY KEY,
                              name VARCHAR(255) NOT NULL,
                              created_by VARCHAR(255),
                              created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                              modified_by VARCHAR(255),
                              modified_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

--  5. 상영 일정 (schedule) 테이블 생성
CREATE TABLE schedule (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          theater_id BIGINT NOT NULL,
                          screen_id BIGINT NOT NULL,
                          movie_id BIGINT NOT NULL,
                          start_time DATETIME NOT NULL,
                          end_time DATETIME NOT NULL,
                          created_by VARCHAR(255),
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          modified_by VARCHAR(255),
                          modified_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

