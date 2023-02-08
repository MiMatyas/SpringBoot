
DROP TABLE IF EXISTS customer;
CREATE TABLE customer (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL,
  surname varchar(45) NOT NULL,
  email varchar(45) NOT NULL,
  city varchar(45) NOT NULL,
  street varchar(45) NOT NULL,
  house_number int NOT NULL,
  zipcode int NOT NULL,
  age int DEFAULT NULL,
  phone_number int DEFAULT NULL
);

DROP TABLE IF EXISTS merchant;
CREATE TABLE merchant (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL,
  email varchar(45) NOT NULL,
  city varchar(45) NOT NULL,
  street varchar(45) NOT NULL,
  house_number int NOT NULL,
  zipcode int NOT NULL
);

DROP TABLE IF EXISTS product;
CREATE TABLE product (
  id int NOT NULL AUTO_INCREMENT,
  merchant_id int NOT NULL,
  name varchar(45) NOT NULL,
  description varchar(80) NOT NULL,
  price double NOT NULL,
  created_at datetime NOT NULL,
  available int NOT NULL
);