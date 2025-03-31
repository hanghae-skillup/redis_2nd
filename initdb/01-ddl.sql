CREATE TABLE `member` (
                          `id`	bigint	NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
                          `password`	varchar(255)	NOT NULL,
                          `name`	varchar(255)	NULL,
                          `created_by`	varchar(100)	NOT NULL,
                          `created_at`	timestamp	NOT NULL,
                          `updated_by`	varchar(100)	NOT NULL,
                          `updated_at`	timestamp	NOT NULL
);

CREATE TABLE `booking` (
                           `id`	bigint	NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
                           `schedule_id`	bigint	NOT NULL,
                           `member_id`	bigint	NOT NULL,
                           `seat_id`	bigint	NOT NULL,
                           `booking_status`	enum('RESERVED', 'CANCELED')	NOT NULL,
                           `booking_date`	timestamp	NOT NULL,
                           `created_by`	varchar(100)	NOT NULL,
                           `created_at`	timestamp	NOT NULL,
                           `updated_by`	varchar(100)	NOT NULL,
                           `updated_at`	timestamp	NOT NULL
);

CREATE TABLE `movie` (
                         `id`	bigint	NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
                         `title`	varchar(255)	NOT NULL,
                         `grade`	enum('ALL', 'AGE_12', 'AGE_15', 'AGE_19', 'RESTRICTED')	NOT NULL,
                         `genre`	enum('ACTION', 'ROMANCE', 'HORROR', 'SF')	NOT NULL,
                         `running_time`	int	NOT NULL,
                         `thumbnail`	varchar(255)	NULL,
                         `release_date`	timestamp	NULL,
                         `created_by`	varchar(100)	NOT NULL,
                         `created_at`	timestamp	NOT NULL,
                         `updated_by`	varchar(100)	NOT NULL,
                         `updated_at`	timestamp	NOT NULL
);

CREATE TABLE `theater` (
                           `id`	bigint	NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
                           `name`	varchar(255)	NULL,
                           `created_by`	varchar(100)	NOT NULL,
                           `created_at`	timestamp	NOT NULL,
                           `updated_by`	varchar(100)	NOT NULL,
                           `updated_at`	timestamp	NOT NULL
);

CREATE TABLE `schedule` (
                            `id`	bigint	NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
                            `movie_id`	bigint	NOT NULL,
                            `theater_id`	bigint	NOT NULL,
                            `start_time`	timestamp	NOT NULL,
                            `end_time`	timestamp	NOT NULL,
                            `created_by`	varchar(100)	NOT NULL,
                            `created_at`	timestamp	NOT NULL,
                            `updated_by`	varchar(100)	NOT NULL,
                            `updated_at`	timestamp	NOT NULL
);

CREATE TABLE `seat` (
                        `id`	bigint	NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
                        `theater_id`	bigint	NOT NULL,
                        `seat_row`	varchar(255)	NOT NULL,
                        `seat_column`	int	NOT NULL,
                        `seat_number`	varchar(255)	NOT NULL,
                        `created_by`	varchar(100)	NOT NULL,
                        `created_at`	timestamp	NOT NULL,
                        `updated_by`	varchar(100)	NOT NULL,
                        `updated_at`	timestamp	NOT NULL
);