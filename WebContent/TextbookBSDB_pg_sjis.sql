
DROP DATABASE IF EXISTS TextbookBSDB;
DROP USER IF EXISTS student;
CREATE USER student WITH PASSWORD 'himitu';
CREATE DATABASE TextbookBSDB OWNER student ENCODING 'UTF8';
\c textbookbsdb

DROP TABLE IF EXISTS member;
CREATE TABLE member (
    id SERIAL NOT NULL PRIMARY KEY,
    family_name VARCHAR(10) NOT NULL,
    first_name VARCHAR(10) NOT NULL,
    postal CHAR(7) NOT NULL,
    address VARCHAR(100) NOT NULL,
    tel VARCHAR(20) NOT NULL,
    email VARCHAR(100) NOT NULL,
    birthday DATE NOT NULL,
    password VARCHAR(12) NOT NULL,
    register_date DATE NOT NULL,
    change_date DATE
);

SELECT setval('member_id_seq', 3);


ALTER TABLE member OWNER TO student;

DROP TABLE IF EXISTS exhibit;
CREATE TABLE exhibit (
    book_id SERIAL NOT NULL PRIMARY KEY,
    book_name VARCHAR(10) NOT NULL,
    isbn VARCHAR(13) NOT NULL,
    price INTEGER NOT NULL,
    author VARCHAR(50) NOT NULL,
    quality VARCHAR(20) NOT NULL,
    class VARCHAR(10) NOT NULL,
    seller_id INTEGER NOT NULL,
    sell_date DATE NOT NULL,
    buyer_id INTEGER DEFAULT 0,
    buy_date DATE,
    payment_method VARCHAR(20)
);

SELECT setval('exhibit_book_id_seq', 6);

ALTER TABLE exhibit OWNER TO student;

DROP TABLE IF EXISTS admin;

CREATE TABLE admin (
    id SERIAL NOT NULL PRIMARY KEY,
    password VARCHAR(12) NOT NULL
);

INSERT INTO admin VALUES(1, 'himitu');

ALTER TABLE admin OWNER TO student;
