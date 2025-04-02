CREATE TABLE `cinema_movie_time` (
                                     `cinema_id`	int	NOT NULL,
                                     `movie_id`	int	NOT NULL,
                                     `movie_round`	int	NULL,
                                     `movie_start_time`	dateTIme	NULL,
                                     `movie_end_time`	dateTIme	NULL,
                                     `movie_hall`	int	NULL,
                                     `cinema_nm`	varchar(30)	NULL,
                                     `screen_show_yn`	boolean	NULL,
                                     `create_date`	dateTime	NULL,
                                     `modify_date`	dateTIme	NULL,
                                     `cinema_seat_cnt`	int	NULL
);

CREATE TABLE `common_img` (
                              `img_seq`	int	NOT NULL,
                              `img_nm`	varchar(50)	NULL,
                              `img_path`	text	NULL
);

CREATE TABLE `movie_api_kmdb` (
                                  `docid`	varchar(20)	NOT NULL,
                                  `movie_seq`	int	NULL,
                                  `title`	varchar(50)	NULL,
                                  `title_eng`	varchar(50)	NULL,
                                  `title_etc`	varchar(50)	NULL,
                                  `director_nm`	varchar(20)	NULL,
                                  `director_id`	int	NULL,
                                  `actor_nm`	varchar(20)	NULL,
                                  `nation`	varchar(10)	NULL,
                                  `company`	varchar(20)	NULL,
                                  `prod_year`	datetime	NULL,
                                  `plot`	text	NULL,
                                  `runtime`	datetime	NULL,
                                  `rating`	varchar(10)	NULL,
                                  `genre`	varchar(20)	NULL,
                                  `kmdb_url`	text	NULL,
                                  `type`	varchar(10)	NULL,
                                  `use`	varchar(10)	NULL,
                                  `episodes`	text	NULL,
                                  `rated_yn`	char(1)	NULL,
                                  `rep_rat_date`	datetime	NULL,
                                  `rep_rls_date`	datetime	NULL,
                                  `rating_grade`	varchar(10)	NULL,
                                  `release_date`	datetime	NULL,
                                  `keywords`	varchar(50)	NULL,
                                  `poster_url`	text	NULL,
                                  `staff_role_group`	varchar(10)	NULL,
                                  `staff_role`	varchar(30)	NULL,
                                  `staff_etc`	text	NULL,
                                  `open_thtr`	varchar(20)	NULL,
                                  `screen_area`	varchar(50)	NULL,
                                  `screen_cnt`	int	NULL,
                                  `audi_acc`	int	NULL
);

CREATE TABLE `movie_user` (
                              `user_id`	int	NOT NULL,
                              `login_id`	varchar(50)	NULL,
                              `pwd`	varchar(50)	NULL,
                              `user_nm`	varchar(20)	NULL,
                              `phone_num01`	varchar(5)	NULL,
                              `phone_num02`	varchar(10)	NULL,
                              `phone_num03`	varchar(10)	NULL,
                              `address01`	varchar(500)	NULL,
                              `address02`	varchar(100)	NULL,
                              `address03`	varchar(10)	NULL,
                              `use_yn`	boolean	NULL,
                              `create_date`	datetime	NULL,
                              `last_login_date`	datetime	NULL,
                              `email01`	varchar(15)	NULL,
                              `email02`	varchar(10)	NULL,
                              `role`	varchar(10)	NULL,
                              `modify_date`	datetime	NULL,
                              `user_img`	int	NULL
);

CREATE TABLE `movie_reser` (
                               `reser_id`	int	NOT NULL,
                               `seat_id`	int	NOT NULL,
                               `user_id`	int	NOT NULL,
                               `reser_cd`	varchar(20)	NULL,
                               `login_id`	varchar(50)	NULL,
                               `reser_time`	datetime	NULL
);

CREATE TABLE `movie_info` (
                              `movie_id`	int	NOT NULL,
                              `movie_nm`	varchar(50)	NULL,
                              `sub_title`	varchar(50)	NULL,
                              `genre_cd`	varchar(20)	NULL,
                              `director_nm`	varchar(10)	NULL,
                              `pub_date`	datetime	NULL,
                              `country_cd`	varchar(20)	NULL,
                              `cast_nm`	varchar(20)	NULL,
                              `movie_link`	text	NULL,
                              `movie_rate`	decimal(15,2)	NULL,
                              `open_date`	datetime	NULL,
                              `show_time_min`	int	NULL,
                              `show_yn`	boolean	NULL,
                              `create_date`	datetime	NULL,
                              `modify_date`	datetime	NULL,
                              `genre_nm`	varchar(20)	NULL,
                              `grade`	varchar(10)	NULL,
                              `thum_img`	int	NULL
);

CREATE TABLE `movie_seat` (
                              `seat_id`	int	NOT NULL,
                              `cinema_id`	int	NOT NULL,
                              `seat_cd`	varchar(20)	NULL,
                              `seat_nm`	varchar(20)	NULL,
                              `seat_lv`	varchar(50)	NULL
);

CREATE TABLE `movie_reser_sub` (
                                   `id`	int	NOT NULL,
                                   `reser_id`	int	NOT NULL,
                                   `reser_cd`	varchar(20)	NULL,
                                   `seat_Cd`	varchar(20)	NULL
);

ALTER TABLE `cinema_movie_time` ADD CONSTRAINT `PK_CINEMA_MOVIE_TIME` PRIMARY KEY (
                                                                                   `cinema_id`
    );

ALTER TABLE `common_img` ADD CONSTRAINT `PK_COMMON_IMG` PRIMARY KEY (
                                                                     `img_seq`
    );

ALTER TABLE `movie_api_kmdb` ADD CONSTRAINT `PK_MOVIE_API_KMDB` PRIMARY KEY (
                                                                             `docid`
    );

ALTER TABLE `movie_user` ADD CONSTRAINT `PK_MOVIE_USER` PRIMARY KEY (
                                                                     `user_id`
    );

ALTER TABLE `movie_reser` ADD CONSTRAINT `PK_MOVIE_RESER` PRIMARY KEY (
                                                                       `reser_id`
    );

ALTER TABLE `movie_info` ADD CONSTRAINT `PK_MOVIE_INFO` PRIMARY KEY (
                                                                     `movie_id`
    );

ALTER TABLE `movie_seat` ADD CONSTRAINT `PK_MOVIE_SEAT` PRIMARY KEY (
                                                                     `seat_id`
    );

ALTER TABLE `movie_reser_sub` ADD CONSTRAINT `PK_MOVIE_RESER_SUB` PRIMARY KEY (
                                                                               `id`
    );

