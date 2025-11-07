create table users
(
    id                  bigserial primary key,
    username            varchar(30) not null unique,
    password            varchar(80) not null,
    email               varchar(50) unique,
    created             timestamp   not null default current_timestamp,
    updated             timestamp   not null default current_timestamp,
    registration_status varchar(30) not null,
    last_login          timestamp,
    deleted             boolean              default false not null
);

create table posts
(
    id         bigserial primary key,
    user_id    integer      not null,
    title      varchar(255) not null,
    content    text         not null,
    created    timestamp    not null default current_timestamp,
    updated    timestamp    not null default current_timestamp,
    deleted    boolean      not null default false,
    likes      integer      not null default 0,
    created_by VARCHAR(50),
    foreign key (user_id) references users (id) on delete cascade,
    unique (title)
);

create table roles
(
    id               serial primary key,
    name             varchar(50) not null,
    user_system_role varchar(64) not null,
    active           boolean     not null default true,
    created_by       varchar(50) not null
);

create table user_roles
(
    user_id bigint references users (id),
    role_id integer references roles (id),
    primary key (user_id, role_id)
);


INSERT INTO users(username, password, email, created, updated, registration_status, last_login, deleted)
VALUES ('super_admin', '$2a$10$6dcdSJYZZUw7JUlSKVQaEOXZxWrTds2H/mlO9Yz1VmFuC9t36NOs.', 'supernikita@example.com',
        '2025-10-01 09:00:00', '2025-10-29 20:16:00', 'ACTIVE',
        '2025-10-29 20:15:00', false),
       ('admin', '$2a$10$G.w65Z1P/dkfkMC.NxGI6uNxIONBw7ig6Vdfx.YETB5scfmFmCnHW', 'adminmaria@example.com',
        '2025-09-15 14:30:00', '2025-09-15 14:30:00', 'PENDING',
        '2025-10-29 20:15:00', false),
       ('User', '$2a$10$co31RqlLT14z06Gs9gibceZn8wKOryC.ZiB2uxhHebswEjCxzahce', 'userdev@example.com',
        '2025-06-12 08:00:00', '2025-10-10 12:00:00', 'ACTIVE',
        '2025-08-12 18:00:00', true);
insert into posts(user_id, title, content, created, updated, deleted, likes)
values (1, 'first post', 'text for the first post', current_timestamp, current_timestamp, false, 10),
       (3, 'second post', 'text for the second post', current_timestamp, current_timestamp, false, 20);

insert into roles (name, user_system_role, created_by)
values ('SUPER_ADMIN', 'SUPER_ADMIN', 'SUPER_ADMIN'),
       ('ADMIN', 'ADMIN', 'SUPER_ADMIN'),
       ('USER', 'USER', 'SUPER_ADMIN');

insert into user_roles (user_id, role_id)
values (1, 1),
       (2, 2),
       (3, 3)