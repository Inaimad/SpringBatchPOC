DROP TABLE people IF EXISTS;

CREATE TABLE people  (
    person_id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    first_name VARCHAR(20),
    last_name VARCHAR(20),
    migration_status VARCHAR(20)
);

INSERT INTO people (person_id, first_name, last_name, migration_status) VALUES (1, 'Jan', 'Nowak', null);
INSERT INTO people (person_id, first_name, last_name, migration_status) VALUES (2, 'Adam', 'Kowalski', null);
INSERT INTO people (person_id, first_name, last_name, migration_status) VALUES (3, 'Tomasz', 'Korniszon', null);
INSERT INTO people (person_id, first_name, last_name, migration_status) VALUES (4, 'Wojciech', 'Wsadowy', null);
INSERT INTO people (person_id, first_name, last_name, migration_status) VALUES (5, 'Jan', 'Nowak', null);
INSERT INTO people (person_id, first_name, last_name, migration_status) VALUES (6, 'Adam', 'Kowalski', null);
INSERT INTO people (person_id, first_name, last_name, migration_status) VALUES (7, 'Tomasz', 'Korniszon', null);
INSERT INTO people (person_id, first_name, last_name, migration_status) VALUES (8, 'Wojciech', 'Wsadowy', null);
INSERT INTO people (person_id, first_name, last_name, migration_status) VALUES (9, 'Jan', 'Nowak', null);
INSERT INTO people (person_id, first_name, last_name, migration_status) VALUES (10, 'Adam', 'Kowalski', null);
INSERT INTO people (person_id, first_name, last_name, migration_status) VALUES (11, 'Tomasz', 'Korniszon', null);
INSERT INTO people (person_id, first_name, last_name, migration_status) VALUES (12, 'Wojciech', 'Wsadowy', null);
INSERT INTO people (person_id, first_name, last_name, migration_status) VALUES (13, 'Jan', 'Nowak', null);
INSERT INTO people (person_id, first_name, last_name, migration_status) VALUES (14, 'Adam', 'Kowalski', null);
INSERT INTO people (person_id, first_name, last_name, migration_status) VALUES (15, 'Tomasz', 'Korniszon', null);
INSERT INTO people (person_id, first_name, last_name, migration_status) VALUES (16, 'Wojciech', 'Wsadowy', null);


DROP TABLE converted_people IF EXISTS;

CREATE TABLE converted_people  (
    person_id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    first_name VARCHAR(20),
    last_name VARCHAR(20)
);