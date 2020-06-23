
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

INSERT INTO member VALUES(1,'加藤', 'ねこ','1111111','東京都', '03-1111-1111','katou@text.net', DATE '1961-06-16','12345678',DATE '1961-06-16');
INSERT INTO member VALUES(2,'田中', 'こぶた','2222222','東京都', '03-2222-2222','tanaka@text.net', DATE '1961-06-16','12345678',DATE '1961-06-16');
INSERT INTO member VALUES(3,'鈴木', 'うさぎ','3333333','茨城県','03-3333-3333','suzuki@text.net', DATE '1961-06-16','12345678',DATE '1961-06-16');
INSERT INTO member VALUES(4,'佐藤', 'かめ','4444444','鳥取県', '03-4444-4444','satou@text.net', DATE '1961-06-16','12345678',DATE '1961-06-16');
INSERT INTO member VALUES(5,'木間', 'きつね','5555555','島根県', '03-5555-5555','kima@text.net', DATE '1961-06-16','12345678',DATE '1961-06-16');

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
    buyer_id INTEGER,
    buy_date DATE,
    payment_method VARCHAR(20)
);

INSERT INTO exhibit(book_name,isbn,price,author,quality,class,seller_id,sell_date) VALUES('猿も木から落ちる', 1111111111111,111,'猿','新品','文学部系', 1,DATE '1961-06-16');
INSERT INTO exhibit(book_name,isbn,price,author,quality,class,seller_id,sell_date) VALUES('豚に真珠', 2222222222222,222,'豚','中古','教育学部系', 2,DATE '1961-06-16');
INSERT INTO exhibit(book_name,isbn,price,author,quality,class,seller_id,sell_date) VALUES('心がぴょんぴょん', 3333333333333,333,'ウサギ','未使用','法学部系',3,DATE '1961-06-16');
INSERT INTO exhibit(book_name,isbn,price,author,quality,class,seller_id,sell_date) VALUES('亀とウサギ', 4444444444444,444,'亀','中古','社会学部系', 4,DATE '1961-06-16');
INSERT INTO exhibit(book_name,isbn,price,author,quality,class,seller_id,sell_date) VALUES('きつねにつままれる',5555555555555 ,555,'きつね','新品','経済学部系 ', 5,DATE '1961-06-16');

ALTER TABLE exhibit OWNER TO student;

DROP TABLE IF EXISTS admin;

CREATE TABLE admin (
    id SERIAL NOT NULL PRIMARY KEY,
    password VARCHAR(12) NOT NULL
);

INSERT INTO admin VALUES(1, 'himitu');

ALTER TABLE admin OWNER TO student;
