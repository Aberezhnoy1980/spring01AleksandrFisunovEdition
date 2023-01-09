/* 
Project homework04 (https://github.com/Aberezhnoy1980/java-core/tree/interview03/interview/src/main/java/ru/aberezhnoy/homework04)
DBMS: MySQL
IDEs: Workbench 8.0/IntelliJ IDEA 2021.3.2 (Ultimate Edition)
date: 13.10.2022 
developer: Aleksandr Berezhnoy 
*/

DROP DATABASE IF EXISTS `cinema`;
CREATE DATABASE `cinema`;

USE `cinema`;

DROP TABLE IF EXISTS `movies` CASCADE;
CREATE TABLE `movies`
(
    `id`     SERIAL PRIMARY KEY,
    `title`  VARCHAR(255) NOT NULL COMMENT 'название',
    `length` INT UNSIGNED NOT NULL COMMENT 'Продолжительность'
) COMMENT = 'Каталог фильмов';

DROP TABLE IF EXISTS `sessions` CASCADE;
CREATE TABLE `sessions`
(
    `id`         SERIAL PRIMARY KEY,
    `film_id`    BIGINT UNSIGNED NOT NULL,
    `price`      DECIMAL(5, 2) COMMENT 'цена показа',
    `show_start` TIME            NOT NULL COMMENT 'время показа',
    KEY `idx_of_film_id` (`film_id`),
    CONSTRAINT `fk_films_id`
        FOREIGN KEY (`film_id`) REFERENCES `movies` (`id`)
) COMMENT ='сеансы';

DROP TABLE IF EXISTS `tickets` CASCADE;
CREATE TABLE `tickets`
(
    `id`           SERIAL PRIMARY KEY,
    `place_number` INT UNSIGNED    NOT NULL COMMENT 'место',
    `session_id`   BIGINT UNSIGNED NOT NULL,
    KEY `idx_of_session_id` (`session_id`),
    CONSTRAINT `fk_session_id`
        FOREIGN KEY (`session_id`) REFERENCES `sessions` (`id`)
) COMMENT ='билеты';

INSERT INTO `movies` (`title`, `length`)
VALUES ('film1', 60),
       ('film2', 90),
       ('film3', 120),
       ('film4', 90),
       ('film5', 60);

INSERT INTO `sessions` (`film_id`, `price`, `show_start`)
VALUES ('1', 100, '09:00:00'),
       ('2', 200, '10:30:00'),
       ('3', 200, '12:00:00'),
       ('4', 200, '14:00:00'),
       ('5', 300, '15:00:00'),
       ('1', 300, '16:30:00'),
       ('2', 300, '17:30:00'),
       ('3', 300, '18:30:00'),
       ('4', 400, '20:10:00'),
       ('3', 400, '20:30:00'),
       ('1', 400, '21:30:00'),
       ('5', 400, '23:10:00');

INSERT INTO `tickets` (`place_number`, `session_id`)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (4, 4),
       (5, 5),
       (6, 6),
       (7, 7),
       (8, 8),
       (9, 9),
       (10, 10),
       (11, 11),
       (12, 12),
       (13, 1),
       (14, 2),
       (15, 3),
       (16, 4),
       (17, 5),
       (18, 6),
       (19, 7),
       (20, 8),
       (21, 9),
       (22, 10),
       (23, 11),
       (24, 12);

CREATE VIEW SessionDetails AS
SELECT id,
       film_id,
       show_start,
       LEAD(show_start, 1) OVER (ORDER BY show_start)
                                                                                  AS next_show_start,
       LEAD(film_id, 1) OVER (ORDER BY show_start)                                AS next_film_id,
       date_add(show_start, INTERVAL (SELECT length
                                      FROM movies
                                      WHERE movies.id = sessions.film_id) MINUTE) AS show_end
FROM sessions;

SELECT movies.title                                                              AS film_1,
       SessionDetails.show_start                                                 AS show_1_start,
       movies.length                                                             AS length_1,
       (SELECT title FROM movies WHERE SessionDetails.next_film_id = movies.id)  AS film_2,
       SessionDetails.next_show_start                                            AS show_2_start,
       (SELECT length FROM movies WHERE SessionDetails.next_film_id = movies.id) AS length_2
FROM SessionDetails
         INNER JOIN movies ON
    SessionDetails.film_id = movies.id
WHERE show_end > next_show_start
ORDER BY show_1_start;

SELECT movies.title                                                                   AS film_1,
       SessionDetails.show_start,
       movies.length                                                                  AS length_1,
       SessionDetails.next_show_start,
       TIMESTAMPDIFF(MINUTE, SessionDetails.show_end, SessionDetails.next_show_start) AS antract
FROM SessionDetails
         INNER JOIN movies ON SessionDetails.film_id = movies.id
HAVING antract > 30
ORDER BY antract;

CREATE VIEW VisitorsCount AS
SELECT movies.title, COUNT(tickets.place_number) AS visitors, session_id
FROM tickets
         INNER JOIN sessions
                    ON tickets.session_id = sessions.id
         INNER JOIN movies
                    ON sessions.film_id = movies.id
GROUP BY tickets.session_id;

CREATE VIEW Average AS
SELECT title, AVG(visitors) AS average
FROM VisitorsCount
GROUP BY title;

SELECT movies.title,
       COUNT(place_number)    AS visitors_count,
       ROUND(Average.average) AS average_visitors_count,
       SUM(sessions.price)    AS revenue
FROM tickets
         INNER JOIN sessions
                    ON tickets.session_id = sessions.id
         INNER JOIN movies
                    ON sessions.film_id = movies.id
         INNER JOIN Average
                    ON movies.title = Average.title
GROUP BY movies.title
UNION
SELECT 'ИТОГО',
       COUNT(tickets.place_number),
       ROUND(AVG(Average.average)) AS average_visitors_count,
       SUM(sessions.price)
FROM tickets
         INNER JOIN sessions
                    ON tickets.session_id = sessions.id
         INNER JOIN movies
                    ON sessions.film_id = movies.id
         INNER JOIN Average
                    ON movies.title = Average.title
ORDER BY revenue DESC;

SELECT COUNT(tickets.place_number) AS visitors,
       SUM(sessions.price)         AS revenue,
       MIN(sessions.show_start)    AS `from`,
       MAX(sessions.show_start)    AS `to`
FROM tickets
         INNER JOIN sessions
                    ON sessions.id = tickets.session_id
WHERE show_start BETWEEN '08%' AND '15:00%'
UNION
SELECT COUNT(tickets.place_number), SUM(sessions.price), MIN(sessions.show_start), MAX(sessions.show_start)
FROM tickets
         INNER JOIN sessions
                    ON sessions.id = tickets.session_id
WHERE show_start BETWEEN '15:01%' AND '18:00%'
UNION
SELECT COUNT(tickets.place_number), SUM(sessions.price), MIN(sessions.show_start), MAX(sessions.show_start)
FROM tickets
         INNER JOIN sessions
                    ON sessions.id = tickets.session_id
WHERE show_start BETWEEN '18:01%' AND '21:00%'
UNION
SELECT COUNT(tickets.place_number), SUM(sessions.price), MIN(sessions.show_start), MAX(sessions.show_start)
FROM tickets
         INNER JOIN sessions
                    ON sessions.id = tickets.session_id
WHERE show_start > '21:01%';