
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

INSERT INTO member VALUES(1,'����', '�˂�','1111111','�����s', '03-1111-1111','katou@text.net', DATE '1961-06-16','12345678',DATE '1961-06-16');
INSERT INTO member VALUES(2,'�c��', '���Ԃ�','2222222','�����s', '03-2222-2222','tanaka@text.net', DATE '1961-06-16','12345678',DATE '1961-06-16');
INSERT INTO member VALUES(3,'���', '������','3333333','��錧','03-3333-3333','suzuki@text.net', DATE '1961-06-16','12345678',DATE '1961-06-16');
INSERT INTO member VALUES(4,'����', '����','4444444','���挧', '03-4444-4444','satou@text.net', DATE '1961-06-16','12345678',DATE '1961-06-16');
INSERT INTO member VALUES(5,'�؊�', '����','5555555','������', '03-5555-5555','kima@text.net', DATE '1961-06-16','12345678',DATE '1961-06-16');

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

INSERT INTO exhibit(book_name,isbn,price,author,quality,class,seller_id,sell_date) VALUES('�����؂��痎����', 1111111111111,111,'��','�V�i','���w���n', 1,DATE '1961-06-16');
INSERT INTO exhibit(book_name,isbn,price,author,quality,class,seller_id,sell_date) VALUES('�؂ɐ^��', 2222222222222,222,'��','����','����w���n', 2,DATE '1961-06-16');
INSERT INTO exhibit(book_name,isbn,price,author,quality,class,seller_id,sell_date) VALUES('�S���҂��҂��', 3333333333333,333,'�E�T�M','���g�p','�@�w���n',3,DATE '1961-06-16');
INSERT INTO exhibit(book_name,isbn,price,author,quality,class,seller_id,sell_date) VALUES('�T�ƃE�T�M', 4444444444444,444,'�T','����','�Љ�w���n', 4,DATE '1961-06-16');
INSERT INTO exhibit(book_name,isbn,price,author,quality,class,seller_id,sell_date) VALUES('���˂ɂ܂܂��',5555555555555 ,555,'����','�V�i','�o�ϊw���n ', 5,DATE '1961-06-16');

ALTER TABLE exhibit OWNER TO student;

DROP TABLE IF EXISTS admin;

CREATE TABLE admin (
    id SERIAL NOT NULL PRIMARY KEY,
    password VARCHAR(12) NOT NULL
);

INSERT INTO admin VALUES(1, 'himitu');

ALTER TABLE admin OWNER TO student;
