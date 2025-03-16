INSERT INTO users(name, created_at, updated_at, created_by, updated_by)
VALUES ('Flint', '2025-03-16 00:00:00', NOW(), NOW(), 1, 1),
       ('Melita', '2025-03-16 00:00:00', NOW(), NOW(), 1, 1),
       ('Sue', '2025-03-16 00:00:00', NOW(), NOW(), 1, 1),
       ('Mathew', '2025-03-16 00:00:00', NOW(), NOW(), 1, 1),
       ('Tillie', '2025-03-16 00:00:00', NOW(), NOW(), 1, 1),
       ('Thaine', '2025-03-16 00:00:00', NOW(), NOW(), 1, 1),
       ('Blondy', '2025-03-16 00:00:00', NOW(), NOW(), 1, 1),
       ('Patricio', '2025-03-16 00:00:00', NOW(), NOW(), 1, 1),
       ('Archibold', '2025-03-16 00:00:00', NOW(), NOW(), 1, 1),
       ('Faythe', '2025-03-16 00:00:00', NOW(), NOW(), 1, 1);


INSERT INTO movies (title, rating, released_at, poster_url, running_time, genre, created_at, updated_at, created_by,
                    updated_by)
VALUES
    -- 액션 (ACTION)
    ('Action Movie 1', 'PG-13', '2025-02-01 12:00:00', 'https://example.com/action1.jpg', 120, 'ACTION', NOW(), NOW(),
     1, 1),
    ('Action Movie 2', 'R', '2025-02-10 15:30:00', 'https://example.com/action2.jpg', 130, 'ACTION', NOW(), NOW(), 1,
     1),
    ('Action Movie 3', 'PG', '2025-02-20 18:00:00', 'https://example.com/action3.jpg', 115, 'ACTION', NOW(), NOW(), 1,
     1),

    -- 코미디 (COMEDY)
    ('Comedy Movie 1', 'PG', '2025-02-05 14:00:00', 'https://example.com/comedy1.jpg', 100, 'COMEDY', NOW(), NOW(), 1,
     1),
    ('Comedy Movie 2', 'PG-13', '2025-02-15 16:00:00', 'https://example.com/comedy2.jpg', 110, 'COMEDY', NOW(), NOW(),
     1, 1),
    ('Comedy Movie 3', 'R', '2025-02-28 20:00:00', 'https://example.com/comedy3.jpg', 105, 'COMEDY', NOW(), NOW(), 1,
     1),

    -- 드라마 (DRAMA)
    ('Drama Movie 1', 'PG-13', '2025-02-08 13:30:00', 'https://example.com/drama1.jpg', 140, 'DRAMA', NOW(), NOW(), 1,
     1),
    ('Drama Movie 2', 'R', '2025-02-18 17:45:00', 'https://example.com/drama2.jpg', 150, 'DRAMA', NOW(), NOW(), 1, 1),
    ('Drama Movie 3', 'PG', '2025-03-01 11:00:00', 'https://example.com/drama3.jpg', 135, 'DRAMA', NOW(), NOW(), 1, 1),

    -- 호러 (HORROR)
    ('Horror Movie 1', 'R', '2025-02-03 22:00:00', 'https://example.com/horror1.jpg', 95, 'HORROR', NOW(), NOW(), 1, 1),
    ('Horror Movie 2', 'PG-13', '2025-02-12 21:30:00', 'https://example.com/horror2.jpg', 105, 'HORROR', NOW(), NOW(),
     1, 1),
    ('Horror Movie 3', 'R', '2025-02-25 23:45:00', 'https://example.com/horror3.jpg', 110, 'HORROR', NOW(), NOW(), 1,
     1),

    -- 로맨스 (ROMANCE)
    ('Romance Movie 1', 'PG', '2025-02-06 19:00:00', 'https://example.com/romance1.jpg', 125, 'ROMANCE', NOW(), NOW(),
     1, 1),
    ('Romance Movie 2', 'PG-13', '2025-02-22 18:30:00', 'https://example.com/romance2.jpg', 130, 'ROMANCE', NOW(),
     NOW(), 1, 1),
    ('Romance Movie 3', 'PG', '2025-03-05 15:45:00', 'https://example.com/romance3.jpg', 140, 'ROMANCE', NOW(), NOW(),
     1, 1),

    -- SF (SCI_FI)
    ('Sci-Fi Movie 1', 'PG-13', '2025-02-09 17:00:00', 'https://example.com/scifi1.jpg', 145, 'SCI_FI', NOW(), NOW(), 1,
     1),
    ('Sci-Fi Movie 2', 'R', '2025-02-16 20:30:00', 'https://example.com/scifi2.jpg', 155, 'SCI_FI', NOW(), NOW(), 1, 1),
    ('Sci-Fi Movie 3', 'PG-13', '2025-03-07 13:15:00', 'https://example.com/scifi3.jpg', 160, 'SCI_FI', NOW(), NOW(), 1,
     1);

