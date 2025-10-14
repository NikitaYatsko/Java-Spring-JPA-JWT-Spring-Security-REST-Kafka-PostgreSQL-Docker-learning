create table posts
(
    id      bigserial primary key,
    title   varchar(255) not null,
    content text         not null,
    created timestamp    not null default current_timestamp,
    likes   integer      not null default 0,
    unique (title)
);

insert into posts(title, content, created, likes)
values ('first post', 'text for the first post', current_timestamp, 10),
       ('second post', 'text for the second post', current_timestamp, 20);
