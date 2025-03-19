# Redis_project  

커머스의 핵심 프로세스인 상품 조회 및 주문 과정에서 발생할 수 있는 동시성 이슈 해결 및 성능 개선을 경험하고, 안정성을 높이기 위한 방법을 배웁니다.

## Project 구성
# Layered Architecture 를 채택하여 
Application
    │
 domain
    │
  infra
# 이렇게 3개의 모듈로 나눴습니다.

│multi-modules (root project)
│   
├── application/
│   ├── customer/
│   │   └── dto/
│   │   └── controller/
│   ├── movie/
│   │   └── dto/
│   │   └── controller/
│   ├── reservation
│   │   └── dto/
│   │   └── controller/ 
│
├── domain/
│   ├── common
│   │   └── enums/
│   │   └── dto/
│   ├── customer/
│   │   └── entity/
│   │   └── service/
│   │   └── repository/
│   ├── movie/
│   │   └── entity/
│   │   └── service/
│   │   └── repository/
│   ├── reservation
│   │   └── entity/
│   │   └── service/
│   │   └── repository/
│
└── infra/
└── (Redis를 시작하면 구축 예정) redis 추가를 위한 모듈

###

## DB 설계
# Docker 와 sql 문은 추후에 추가 예정

CREATE TABLE `customers` (
`id` bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
`created_at` timestamp NULL DEFAULT NULL,
`created_by` varchar(255) DEFAULT NULL,
`updated_at` timestamp NULL DEFAULT NULL,
`updated_by` varchar(255) DEFAULT NULL,
`email` varchar(100) NOT NULL,
`password` varchar(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `movie` (
`id` bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
`created_at` timestamp NULL DEFAULT NULL,
`created_by` varchar(255) DEFAULT NULL,
`updated_at` timestamp NULL DEFAULT NULL,
`updated_by` varchar(255) DEFAULT NULL,
`title` varchar(100) NOT NULL COMMENT '영화 제목',
`thumbnail` varchar(500) NOT NULL COMMENT '영화 포스터 URL',
`movie_ratings` int NOT NULL COMMENT '영상물 등급',
`release_date` date NOT NULL COMMENT '영화 개봉일',
`running_time` int NOT NULL COMMENT '영화 러닝타임',
`theater_name` varchar(100) NOT NULL COMMENT '상영관 이름',
`genre` varchar(100) NOT NULL COMMENT '영화 장르'
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `show_schedule` (
`id` bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
`created_at` timestamp NULL DEFAULT NULL,
`created_by` varchar(255) DEFAULT NULL,
`updated_at` timestamp NULL DEFAULT NULL,
`updated_by` varchar(255) DEFAULT NULL,
`movie_id` bigint DEFAULT NULL,
`start_show_time` time NOT NULL COMMENT '영화 시작 시간',
KEY `FK_movie_id_of_show_schedule` (`movie_id`),
CONSTRAINT `FK_movie_id_of_show_schedule` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `screening` (
`id` bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
`created_at` timestamp NULL DEFAULT NULL,
`created_by` varchar(255) DEFAULT NULL,
`updated_at` timestamp NULL DEFAULT NULL,
`updated_by` varchar(255) DEFAULT NULL,
`end_date` date NOT NULL COMMENT '영화 종영일',
`movie_id` bigint DEFAULT NULL,
KEY `FK_movie_id_of_screening` (`movie_id`),
CONSTRAINT `FK_movie_id_of_screening` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `reservation` (
`id` bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
`created_at` timestamp NULL DEFAULT NULL,
`created_by` varchar(255) DEFAULT NULL,
`updated_at` timestamp NULL DEFAULT NULL,
`updated_by` varchar(255) DEFAULT NULL,
`reservation_date` date NOT NULL COMMENT '영화관람일',
`reservation_time` time NOT NULL COMMENT '영화 시작 시간',
`seat` varchar(50) NOT NULL COMMENT '좌석 정보',
`customers_id` bigint DEFAULT NULL,
`movie_id` bigint DEFAULT NULL,
KEY `FK_customers_id_of_reservation` (`customers_id`),
KEY `FK_movie_id_of_reservation` (`movie_id`),
CONSTRAINT `FK_customers_id_of_reservation` FOREIGN KEY (`customers_id`) REFERENCES `customers` (`id`),
CONSTRAINT `FK_movie_id_of_reservation` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
 
###

# 문제점
각 모듈을 실행시키려고 하면

Build file '/Users/khy/redis-practice/redis-2nd/domain/build.gradle' line: 5

이렇게 에러가 발생하여 실행시켜보지 못했습니다.

###

# 궁금한점 & 어려운점
- 각 모듈의 정의를 얼마나 세밀하게 나누는게 좋은지 아직은 잘 모르겠습니다. Service 와 Domain 을 나눠서 가져가는 것에 대한 이점은 프로젝트가 커지면(MSA?) 분명 좋을 것 같은데
  그렇다면 얼마나 프로젝트가 커졌을 때 효과가 있을 것인가를 모르겠습니다.
- 모듈을 직접 설계하는것이 처음이라 어떻게 각 모듈을 관리를 하고 서버를 올려야 하는 것인지 모르겠습니다.
