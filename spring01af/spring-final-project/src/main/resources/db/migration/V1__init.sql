create table categories
(
    id    bigserial primary key,
    title varchar(255)
);
insert into categories (title)
values ('ItemCategory'),
       ('ProductCategory');
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
create table products
(
    id bigserial primary key,
    title varchar(255),
    price int,
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
create table users
(
    id         bigserial primary key,
    username   varchar(30) not null,
    password   varchar(80) not null,
    email      varchar(50) unique,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);
create table roles
(
    id         bigserial primary key,
    name       varchar(50) not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

CREATE TABLE users_roles
(
    user_id bigint not null references users (id),
    role_id bigint not null references roles (id),
    primary key (user_id, role_id)
);

insert into roles (name)
values ('ROLE_USER'),
       ('ROLE_ADMIN');

insert into users (username, password, email)
values ('user', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'bob_johnson@gmail.com'),
       ('admin', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'john_johnson@gmail.com');

insert into users_roles (user_id, role_id)
values (1, 1),
       (2, 2);