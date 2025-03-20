CREATE DATABASE IF NOT EXISTS cinema;
USE cinema;

drop table if exists movie;
drop table if exists screening;
drop table if exists theater;

CREATE TABLE movie (
                       id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '영화 id',
                       title VARCHAR(255) NOT NULL COMMENT '영화 제목',
                       grade VARCHAR(50) NOT NULL COMMENT '상영물 등급',
                       release_date DATE NOT NULL COMMENT '개봉일',
                       thumbnail_url VARCHAR(255) NOT NULL COMMENT '섬네일이미지 URL',
                       running_time INT NOT NULL COMMENT '러닝타임(분)',
                       genre VARCHAR(50) NOT NULL COMMENT '장르',
                       status VARCHAR(50) NOT NULL COMMENT '상영 상태(상영안함/상영중/개봉예정)',
                       created_date DATETIME NOT NULL COMMENT '생성일',
                       created_by VARCHAR(255) NOT NULL COMMENT '생성자',
                       last_modified_date DATETIME NULL COMMENT '수정일',
                       last_modified_by VARCHAR(255) NULL COMMENT '수정자'
);

CREATE TABLE theater (
                         id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '상영관 id',
                         name VARCHAR(255) NOT NULL COMMENT '상영관 이름',
                         created_date DATETIME NOT NULL COMMENT '생성일',
                         created_by VARCHAR(255) NOT NULL COMMENT '생성자',
                         last_modified_date DATETIME NULL COMMENT '수정일',
                         last_modified_by VARCHAR(255) NULL COMMENT '수정자'
);

CREATE TABLE screening  (
                            id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '상영 id',
                            theater_id INT UNSIGNED NOT NULL COMMENT '상영관 id',
                            movie_id INT UNSIGNED NOT NULL COMMENT '영화 id',
                            screen_number SMALLINT NOT NULL COMMENT '상영 회차',
                            start_time DATETIME NOT NULL COMMENT '상영 시작 시간',
                            end_time DATETIME NOT NULL COMMENT '상영 종료 시간',
                            seat_count INT NOT NULL COMMENT '좌석 수',
                            created_date DATETIME NOT NULL COMMENT '생성일',
                            created_by VARCHAR(255) NOT NULL COMMENT '생성자',
                            last_modified_date DATETIME NULL COMMENT '수정일',
                            last_modified_by VARCHAR(255) NULL COMMENT '수정자'
);

alter table screening
    add constraint fk_screening_to_theater
        foreign key (theater_id)
            references theater (id);
