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
    id      bigserial primary key,
    title   varchar(255) not null,
    content text         not null,
    created timestamp    not null default current_timestamp,
    updated timestamp    not null default current_timestamp,
    deleted boolean      not null default false,
    likes   integer      not null default 0,
    unique (title)
);

insert into posts(title, content, created, updated, deleted, likes)
values ('first post', 'text for the first post', current_timestamp, current_timestamp, false, 10),
       ('second post', 'text for the second post', current_timestamp, current_timestamp, false, 20);

INSERT INTO users(username, password, email, created, updated, registration_status, last_login, deleted)
VALUES ('nikita', 'password1', 'nikita@example.com', '2025-10-01 09:00:00', '2025-10-29 20:16:00', 'ACTIVE',
        '2025-10-29 20:15:00', false),
       ('maria', 'password2', 'maria@example.com', '2025-09-15 14:30:00', '2025-09-15 14:30:00', 'PENDING',
        '2025-10-29 20:15:00', false),
       ('devtest', 'devpass', 'dev@example.com', '2025-06-12 08:00:00', '2025-10-10 12:00:00', 'ACTIVE',
        '2025-08-12 18:00:00', true);

