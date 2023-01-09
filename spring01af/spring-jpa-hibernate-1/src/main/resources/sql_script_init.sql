BEGIN;

DROP TABLE IF EXISTS `products`;

CREATE TABLE `products`
(
    `id`    BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(30)                 NOT NULL UNIQUE,
    `price` DECIMAL(10, 2)              NOT NULL
);

INSERT INTO `products` (`title`, `price`)
VALUES ('Milk', 86.30),
       ('Bread', 27.90),
       ('Cheese', 184.50),
       ('Sausages', 285.60),
       ('Eggs', 180.90),
       ('Fish', 400.00),
       ('Meat', 358.40);

COMMIT;