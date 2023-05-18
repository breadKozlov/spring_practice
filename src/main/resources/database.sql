CREATE TABLE company_spring (
                                id serial primary key,
                                name varchar(124) not null
);

CREATE TABLE users_spring (
                              id serial primary key,
                              name varchar(23) not null,
                              surname varchar(32) not null,
                              email varchar(124) not null,
                              company int references company_spring(id)
);

INSERT INTO company_spring (name)
VALUES ('Google'),
       ('Apple'),
       ('IBM');

INSERT INTO users_spring (name, surname, email, company)
VALUES ('Pavel','Kozlov','killer@mail.ru',1);