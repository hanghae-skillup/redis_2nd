-- Movie Data
INSERT INTO movies (title, thumbnail_url, genre, rating, release_date, running_time, created_by, updated_by)
VALUES
    ( '범죄도시', 'http://test.com', 'SF', 'ALL', DATE_ADD(CURRENT_DATE, INTERVAL -30 DAY), 120, 'test', 'test');
