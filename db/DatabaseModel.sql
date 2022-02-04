DROP SCHEMA public CASCADE;

CREATE SCHEMA public;

CREATE TABLE customer(
    id serial PRIMARY KEY,
    firstname VARCHAR (30) NOT NULL,
    lastname VARCHAR (30) NOT NULL,
    pesel VARCHAR (11) NOT NULL,
);

CREATE TABLE credit (
    creditId serial PRIMARY KEY,
    creditname VARCHAR (30) NOT NULL,
    value DOUBLE PRECISION NOT NULL,
    customerId INTEGER NOT NULL,
    CONSTRAINT FK_Customer
        FOREIGN KEY (customerId) REFERENCES customer (id),
);