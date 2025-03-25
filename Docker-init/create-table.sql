CREATE TABLE `theater_Move_Tm` (
	`theater_Id`	varchar(100)	NOT NULL,
	`movie_Id`	varchar(100)	NOT NULL,
	`movie_Round`	int	NULL,
	`theater_Movie_Start_Tm`	dateTIme	NULL,
	`theater_Movie_End_Tm`	dateTIme	NULL,
	`theater_Movie_Hall`	int	NULL,
	`theater_Nm`	varchar(30)	NULL,
	`screen_Show_Yn`	char(1)	NULL
);

CREATE TABLE `user_Movie_Area` (
                                   `reser_Id`	varchar(100)	NOT NULL,
                                   `userId`	varchar(100)	NOT NULL,
                                   `movie_Id`	varchar(100)	NOT NULL
);

CREATE TABLE `commonImg` (
                             `img_Seq`	int	NOT NULL,
                             `img_Nm`	varchar(50)	NULL,
                             `img_Path`	text	NULL
);

CREATE TABLE `movie_API` (
                             `docid`	varchar(20)	NOT NULL,
                             `movie_Seq`	int	NULL,
                             `title`	varchar(50)	NULL,
                             `title_Eng`	varchar(50)	NULL,
                             `title_Etc`	varchar(50)	NULL,
                             `director_Nm`	varchar(20)	NULL,
                             `director_Id`	int	NULL,
                             `actor_Nm`	varchar(20)	NULL,
                             `nation`	varchar(10)	NULL,
                             `company`	varchar(20)	NULL,
                             `prod_Year`	datetime	NULL,
                             `plot`	text	NULL,
                             `runtime`	datetime	NULL,
                             `rating`	varchar(10)	NULL,
                             `genre`	varchar(20)	NULL,
                             `kmdb_Url`	text	NULL,
                             `type`	varchar(10)	NULL,
                             `use`	varchar(10)	NULL,
                             `episodes`	text	NULL,
                             `rated_Yn`	char(1)	NULL,
                             `rep_Rat_Date`	datetime	NULL,
                             `rep_Rls_Date`	datetime	NULL,
                             `rating_Grade`	varchar(10)	NULL,
                             `release_Date`	datetime	NULL,
                             `keywords`	varchar(50)	NULL,
                             `poster_Url`	text	NULL,
                             `staff_Role_Group`	varchar(10)	NULL,
                             `staff_Role`	varchar(30)	NULL,
                             `staff_Etc`	text	NULL,
                             `open_Thtr`	varchar(20)	NULL,
                             `screen_Area`	varchar(50)	NULL,
                             `screen_Cnt`	int	NULL,
                             `audi_Acc`	int	NULL
);

CREATE TABLE `movie_User` (
                              `user_Id`	varchar(100)	NOT NULL,
                              `user_Img`	int	NOT NULL,
                              `login_Id`	varchar(50)	NULL,
                              `pwd`	varchar(50)	NULL,
                              `user_Nm`	varchar(20)	NULL,
                              `phone_Num01`	varchar(5)	NULL,
                              `phone_Num02`	varchar(10)	NULL,
                              `phone_Num03`	varchar(10)	NULL,
                              `address01`	varchar(500)	NULL,
                              `address02`	varchar(100)	NULL,
                              `address03`	varchar(10)	NULL,
                              `use_Yn`	char(1)	NULL,
                              `create_Date`	datetime	NULL,
                              `last_Login_Date`	datetime	NULL,
                              `email01`	varchar(15)	NULL,
                              `email02`	varchar(10)	NULL,
                              `role`	varchar(10)	NULL
);

CREATE TABLE `movie_Reser` (
                               `reser_Id`	varchar(100)	NOT NULL,
                               `seat_Id`	varchar(100)	NULL,
                               `seat_Lv`	varchar(20)	NULL,
                               `login_Id`	varchar(50)	NULL,
                               `reser_Tm`	datetime	NULL,
                               `reser_Cd`	varchar(20)	NULL
);

CREATE TABLE `movie_Info` (
                              `movie_Id`	varchar(100)	NOT NULL,
                              `thum_Img`	int	NOT NULL,
                              `theater_Cd`	varchar(50)	NULL,
                              `movie_Nm`	varchar(50)	NULL,
                              `sub_Title`	varchar(50)	NULL,
                              `genre_Cd`	varchar(20)	NULL,
                              `director_Nm`	varchar(10)	NULL,
                              `pub_Date`	datetime	NULL,
                              `country_Cd`	varchar(20)	NULL,
                              `cast_Nm`	varchar(20)	NULL,
                              `movie_Link`	text	NULL,
                              `movie_Rate`	decimal(15,2)	NULL,
                              `open_Dt`	datetime	NULL,
                              `show_Tm`	int	NULL,
                              `show_YN`	char(1)	NULL,
                              `create_Date`	datetime	NULL,
                              `modify_Date`	datetime	NULL,
                              `genre_Nm`	varchar(20)	NULL,
                              `grade`	varchar(10)	NULL
);

ALTER TABLE `theater_Move_Tm` ADD CONSTRAINT `PK_THEATER_MOVE_TM` PRIMARY KEY (
                                                                               `theater_Id`
    );

ALTER TABLE `user_Movie_Area` ADD CONSTRAINT `PK_USER_MOVIE_AREA` PRIMARY KEY (
                                                                               `reser_Id`
    );

ALTER TABLE `commonImg` ADD CONSTRAINT `PK_COMMONIMG` PRIMARY KEY (
                                                                   `img_Seq`
    );

ALTER TABLE `movie_API` ADD CONSTRAINT `PK_MOVIE_API` PRIMARY KEY (
                                                                   `docid`
    );

ALTER TABLE `movie_User` ADD CONSTRAINT `PK_MOVIE_USER` PRIMARY KEY (
                                                                     `user_Id`
    );

ALTER TABLE `movie_Reser` ADD CONSTRAINT `PK_MOVIE_RESER` PRIMARY KEY (
                                                                       `reser_Id`
    );

ALTER TABLE `movie_Info` ADD CONSTRAINT `PK_MOVIE_INFO` PRIMARY KEY (
                                                                     `movie_Id`
    );

ALTER TABLE `user_Movie_Area` ADD CONSTRAINT `FK_movie_Reser_TO_user_Movie_Area_1` FOREIGN KEY (
                                                                                                `reser_Id`
    )
    REFERENCES `movie_Reser` (
                              `reser_Id`
        );

