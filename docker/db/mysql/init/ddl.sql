CREATE DATABASE IF NOT EXISTS cinema;
USE cinema;

drop table if exists movie;
drop table if exists screening;
drop table if exists theater;
drop table if exists seat;
drop table if exists member;

CREATE TABLE movie
(
    id                 INT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '영화 id',
    title              VARCHAR(255) NOT NULL COMMENT '영화 제목',
    grade              VARCHAR(50)  NOT NULL COMMENT '상영물 등급',
    release_date       DATE         NOT NULL COMMENT '개봉일',
    thumbnail_url      VARCHAR(255) NOT NULL COMMENT '섬네일이미지 URL',
    running_time       INT          NOT NULL COMMENT '러닝타임(분)',
    genre              VARCHAR(50)  NOT NULL COMMENT '장르',
    status             VARCHAR(50)  NOT NULL COMMENT '상영 상태(상영안함/상영중/개봉예정)',
    created_date       DATETIME     NOT NULL COMMENT '생성일',
    created_by         VARCHAR(255) NOT NULL COMMENT '생성자',
    last_modified_date DATETIME NULL COMMENT '수정일',
    last_modified_by   VARCHAR(255) NULL COMMENT '수정자'
);

CREATE TABLE theater
(
    id                 INT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '상영관 id',
    name               VARCHAR(255) NOT NULL COMMENT '상영관 이름',
    created_date       DATETIME     NOT NULL COMMENT '생성일',
    created_by         VARCHAR(255) NOT NULL COMMENT '생성자',
    last_modified_date DATETIME NULL COMMENT '수정일',
    last_modified_by   VARCHAR(255) NULL COMMENT '수정자'
);

CREATE TABLE screening
(
    id                 INT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '상영 id',
    theater_id         INT UNSIGNED NOT NULL COMMENT '상영관 id',
    movie_id           INT UNSIGNED NOT NULL COMMENT '영화 id',
    screen_number      SMALLINT     NOT NULL COMMENT '상영 회차',
    start_time         DATETIME     NOT NULL COMMENT '상영 시작 시간',
    end_time           DATETIME     NOT NULL COMMENT '상영 종료 시간',
    seat_count         INT          NOT NULL COMMENT '좌석 수',
    created_date       DATETIME     NOT NULL COMMENT '생성일',
    created_by         VARCHAR(255) NOT NULL COMMENT '생성자',
    last_modified_date DATETIME NULL COMMENT '수정일',
    last_modified_by   VARCHAR(255) NULL COMMENT '수정자'
);

create table seat
(
    id                 INT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '좌석 id',
    screening_id       INT UNSIGNED NOT NULL COMMENT '상영 id',
    row_code           CHAR(1)      NOT NULL COMMENT '좌석의 행(a,b,c,d,e)',
    col                INT          NOT NULL COMMENT '좌석의 열',
    created_date       DATETIME     NOT NULL COMMENT '생성일',
    created_by         VARCHAR(255) NOT NULL COMMENT '생성자',
    last_modified_date DATETIME NULL COMMENT '수정일',
    last_modified_by   VARCHAR(255) NULL COMMENT '수정자'
);
-- 멤버
CREATE TABLE member
(
    id                 INT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '멤버 pk',
    user_id            VARCHAR(50)  NOT NULL UNIQUE COMMENT '아이디',
    password           VARCHAR(255) NOT NULL COMMENT '비밀번호',
    name               VARCHAR(100) COMMENT '이름',
    created_date       DATETIME     NOT NULL COMMENT '생성일',
    created_by         VARCHAR(255) NOT NULL COMMENT '생성자',
    last_modified_date DATETIME NULL COMMENT '수정일',
    last_modified_by   VARCHAR(255) NULL COMMENT '수정자'
);

-- index 추가
-- 1. screening 테이블--------------------
-- 1) join 대상 컬럼 인덱스 추가
create index idx_screening_theater_id
    ON screening (theater_id);
-- join 대상 및 기본 정렬 대상 컬럼 인덱스 추가
create index idx_screening_movie_id_start_time
    ON screening (movie_id, start_time);

-- 2. movie 테이블--------------------
-- 1) 영화 제목 검색 index
create index idx_title ON movie (title);
-- 2) 영화 장르 검색 index
create index idx_genre ON movie (genre);
-- 3) 영화 장르, 제목 둘 다 검색 시 적용 index
-- 제목에서 우선 필터링하고 장르 검색하기 원해서 title, genre 순서로 인덱스 생성
create index idx_movie_title_genre ON movie (title, genre);

-- 3. seat 테이블 index 추가
-- join 대상 index 추가
create index idx_screening_id ON seat (screening_id);