DROP TABLE people IF EXISTS;

CREATE TABLE people  (
    person_id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    first_name VARCHAR(20),
    last_name VARCHAR(20)
);

INSERT INTO people (first_name, last_name) VALUES ('Jan', 'Nowak');
INSERT INTO people (first_name, last_name) VALUES ('Adam', 'Kowalski');
INSERT INTO people (first_name, last_name) VALUES ('Tomasz', 'Korniszon');
INSERT INTO people (first_name, last_name) VALUES ('Wojciech', 'Wsadowy');

DROP TABLE converted_people IF EXISTS;

CREATE TABLE converted_people  (
    person_id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    first_name VARCHAR(20),
    last_name VARCHAR(20)
);