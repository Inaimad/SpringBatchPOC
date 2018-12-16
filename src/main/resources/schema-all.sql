DROP TABLE people IF EXISTS;

CREATE TABLE people  (
    person_id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    first_name VARCHAR(20),
    last_name VARCHAR(20)
);

INSERT INTO people (person_id, first_name, last_name) VALUES (1, 'Jan', 'Nowak');
INSERT INTO people (person_id, first_name, last_name) VALUES (2, 'Adam', 'Kowalski');
INSERT INTO people (person_id, first_name, last_name) VALUES (3, 'Tomasz', 'Korniszon');
INSERT INTO people (person_id, first_name, last_name) VALUES (4, 'Wojciech', 'Wsadowy');
INSERT INTO people (person_id, first_name, last_name) VALUES (5, 'Jan', 'Nowak');
INSERT INTO people (person_id, first_name, last_name) VALUES (6, 'Adam', 'Kowalski');
INSERT INTO people (person_id, first_name, last_name) VALUES (7, 'Tomasz', 'Korniszon');
INSERT INTO people (person_id, first_name, last_name) VALUES (8, 'Wojciech', 'Wsadowy');
INSERT INTO people (person_id, first_name, last_name) VALUES (9, 'Jan', 'Nowak');
INSERT INTO people (person_id, first_name, last_name) VALUES (10, 'Adam', 'Kowalski');
INSERT INTO people (person_id, first_name, last_name) VALUES (11, 'Tomasz', 'Korniszon');
INSERT INTO people (person_id, first_name, last_name) VALUES (12, 'Wojciech', 'Wsadowy');
INSERT INTO people (person_id, first_name, last_name) VALUES (13, 'Jan', 'Nowak');
INSERT INTO people (person_id, first_name, last_name) VALUES (14, 'Adam', 'Kowalski');
INSERT INTO people (person_id, first_name, last_name) VALUES (15, 'Tomasz', 'Korniszon');
INSERT INTO people (person_id, first_name, last_name) VALUES (16, 'Wojciech', 'Wsadowy');


DROP TABLE converted_people IF EXISTS;

CREATE TABLE converted_people  (
    person_id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    first_name VARCHAR(20),
    last_name VARCHAR(20)
);