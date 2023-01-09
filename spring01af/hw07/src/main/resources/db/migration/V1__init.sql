create table categories
(
    id    bigserial primary key,
    title varchar(255)
);
insert into categories (title)
values ('commonCat');
create table items
(
    id          bigserial primary key,
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


