create table categories
(
    id bigserial primary key,
    title varchar(255)
);
insert into categories (title)
values ('ItemCategory'),
       ('ProductCategory');
create table items
(
    id bigserial primary key,
    title       varchar(255),
    price       int,
    category_id bigint references categories (id)
);
insert into items (title, price, category_id)
values ('item1', 123, 1),
       ('item2', 45, 1),
       ('item3', 578, 1),
       ('item4', 234, 1),
       ('item5', 967, 1),
       ('item6', 12, 1),
       ('item7', 435, 1),
       ('item8', 23, 1),
       ('item9', 87, 1),
       ('item10', 346, 1),
       ('item11', 678, 1),
       ('item12', 321, 1),
       ('item13', 362, 1),
       ('item14', 980, 1),
       ('item15', 456, 1),
       ('item16', 325, 1),
       ('item17', 12, 1),
       ('item18', 1, 1),
       ('item19', 67, 1),
       ('item20', 98, 1);
create table products
(
    id bigserial primary key,
    title       varchar(255),
    price       int,
    category_id bigint references categories (id)
);
insert into products (title, price, category_id)
values ('product1', 23, 2),
       ('product2', 876, 2),
       ('product3', 34, 2),
       ('product4', 457, 2),
       ('product5', 789, 2),
       ('product6', 234, 2),
       ('product7', 543, 2),
       ('product8', 890, 2),
       ('product9', 12, 2),
       ('product10', 3, 2),
       ('product11', 56, 2),
       ('product12', 986, 2),
       ('product13', 456, 2),
       ('product14', 234, 2),
       ('product15', 543, 2),
       ('product16', 432, 2),
       ('product17', 122, 2),
       ('product18', 3, 2),
       ('product19', 15, 2),
       ('product20', 89, 2);
create table roles
(
    id bigserial primary key,
    title varchar(255)
);
create table users
(
    id bigserial primary key,
    name  varchar(255),
    male  varchar(255),
    age   int,
    email varchar(255),
    phone int,
    roles varchar(255)
);
insert into users (name, male, age, email, phone, roles)
values ('user1', 'male', 21, 'user1@usermail.ru', 1234, 'admin'),
       ('user2', 'male', 31, 'user2@usermail.ru', 2345, 'guest'),
       ('user3', 'male', 24, 'user3@usermail.ru', 3456, 'user'),
       ('user4', 'female', 19, 'user4@usermail.ru', 4567, 'user'),
       ('user5', 'female', 29, 'user5@usermail.ru', 5678, 'user'),
       ('user6', 'male', 42, 'user6@usermail.ru', 6789, 'guest');
create table users_roles
(
    user_id bigint,
    role_id bigint
);
