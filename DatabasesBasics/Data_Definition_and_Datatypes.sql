#Problem 4

INSERT INTO towns(id ,name) 
VALUES 
(1, 'Sofia'),
(2, 'Plovdiv'),
(3, 'Varna');
INSERT INTO minions (id,name,age,town_id) 
VALUES 
(1,'Kevin',22, 1),
(2,'Bob',15,3),
(3,'Steward',NULL,2);

#Problem 7
-- 
-- 

CREATE TABLE people (
id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(200) NOT NULL,
picture LONGBLOB,
height DOUBLE ,
weight DOUBLE ,
gender ENUM('m', 'f') NOT NULL, 
birthdate DATE NOT NULL,
biography LONGTEXT ,
PRIMARY KEY (id));

INSERT INTO people(name,picture,height,weight,gender,birthdate,biography)
VALUES
('PESHO',NULL,3.4,4.2,'m',CURDATE(),'BB'),
('PENKA',NULL,3.4,4.2,'f',CURDATE(),'Baaaa'),
('GANKA',NULL,3.4,4.2,'f',CURDATE(),'BBzfzdfz'),
('GOSHO',NULL,3.4,4.2,'m',CURDATE(),'BBdzfzdfz'),
('STAMAT',NULL,3.4,4.2,'m',CURDATE(),'BB');

#Problem 8
-- 
-- 

CREATE TABLE users (
id INT NOT NULL AUTO_INCREMENT,
username VARCHAR(30) NOT NULL,
password VARCHAR(26) NOT NULL,
profile_picture MEDIUMBLOB,
last_login_time DATE ,
is_deleted TINYINT(1),
PRIMARY KEY (id));

INSERT INTO users(username,password,profile_picture,last_login_time,is_deleted)
VALUES(
'PESHO', 'parolata',NULL,CURDATE(),1),
('XXX', 'parolata',NULL,CURDATE(),1),
('XZCZXCZXCZ', 'parolata',NULL,CURDATE(),0),
('FDFERE', 'parolata',NULL,CURDATE(),1),
('GAGAGAGA', 'parolata',NULL,CURDATE(),0);

#Problem 13


CREATE TABLE directors 
(
id INT NOT NULL AUTO_INCREMENT,
director_name VARCHAR(50) NOT NULL,
notes LONGTEXT,
PRIMARY KEY(id)
);

CREATE TABLE genres 
(
id INT NOT NULL AUTO_INCREMENT,
genre_name VARCHAR(50) NOT NULL,
notes LONGTEXT NULL,
PRIMARY KEY(id));

CREATE TABLE categories 
(
id INT NOT NULL AUTO_INCREMENT,
category_name VARCHAR(50) NOT NULL,
notes LONGTEXT NULL,
PRIMARY KEY(id));

CREATE TABLE movies 
(
id INT NOT NULL AUTO_INCREMENT,
title VARCHAR(50) NOT NULL,
director_id VARCHAR(50) NOT NULL,
copyright_year DATETIME ,
length INT NOT NULL,
genre_id INT NOT NULL,
category_id INT NOT NULL,
rating INT,
notes LONGTEXT NULL,
PRIMARY KEY(id));

INSERT INTO directors(director_name)
VALUES ('Pesho'),('goshoo'),('POsho');
INSERT INTO directors(director_name,notes)
VALUES ('Kancho','ALALALALALLALAAL'), ('Pesho','BBBBBB');


INSERT INTO genres(genre_name)
VALUES ('Pesho'),('POsho'),('goshoo');
INSERT INTO genres(genre_name,notes)
VALUES ('Kancho','ALALALALALLALAAL'),('Pesho','BBBBBB');

INSERT INTO categories(category_name)
VALUES('Pesho'),('POsho'), ('Kancho'),('goshoo'),('Pesho');

INSERT INTO movies(title,director_id,copyright_year,length,genre_id,category_id)
VALUES 
('Star wars',1,NOW(),15,1,1);
('Star R4',1,NOW(),15,1,1); 
('Star XXX',1,NOW(),15,1,1);
('Star RRRR',1,NOW(),15,1,1);
('Star AFAF',1,NOW(),15,1,1);

# Problem 14
-- 
-- 

 CREATE TABLE categories
(
id INT NOT NULL AUTO_INCREMENT,
category VARCHAR(50) NOT NULL,
daily_rate FLOAT DEFAULT 0.0,
weekly_rate FLOAT DEFAULT 0.0,
monthly_rate FLOAT DEFAULT 0.0,
weekend_rate FLOAT DEFAULT 0.0,
PRIMARY KEY(id));

CREATE TABLE cars
(
id INT NOT NULL AUTO_INCREMENT,
plate_number VARCHAR(50) NOT NULL,
make VARCHAR(50) NOT NULL,
model VARCHAR(50) NOT NULL,
car_year DATE,
category_id INT,
doors ENUM('2','3','4','5','6','7') NOT NULL,
picture LONGBLOB NULL ,
`condition` ENUM('USED','NEW') NOT NULL,
available ENUM('YES','NO') NOT NULL,
PRIMARY KEY(id)
);

CREATE TABLE employees 
(
id INT NOT NULL AUTO_INCREMENT,
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50) NOT NULL,
title VARCHAR(50) NOT NULL,
notes LONGTEXT,
PRIMARY KEY(id));

CREATE TABLE customers 
(
id INT NOT NULL AUTO_INCREMENT,
driver_license_number VARCHAR(50) UNIQUE,
full_name VARCHAR(50) NOT NULL,
adress VARCHAR(50) NOT NULL,
city VARCHAR(50) NOT NULL,
zip_code VARCHAR(50) NOT NULL,
notes LONGTEXT,
PRIMARY KEY(id));

CREATE TABLE rental_orders(
id INT NOT NULL AUTO_INCREMENT,
employee_id INT,
customer_id INT,
car_id INT,
car_condition ENUM('USED','NEW') NOT NULL,
tank_level INT NOT NULL,
kilometrage_start FLOAT NOT NULL DEFAULT 0.0, 
kilometrage_end FLOAT NOT NULL DEFAULT 0.0,
total_kilometrage FLOAT NOT NULL DEFAULT 0.0,
start_date DATETIME,
end_date DATETIME,
total_days INT,
rate_applied FLOAT,
tax_rate FLOAT,
order_status ENUM('PENDING','FINISHED') NOT NULL,
notes LONGTEXT,
PRIMARY KEY(id)
);

INSERT INTO categories(category)
VALUES 
('Pesho'),
('Pesho'),
('Pesho');


INSERT INTO cars(plate_number,make,model,doors,`condition`,available)
VALUES 
('Pppre3','mercedes','clk','5','USED','YES'),
('ggggg','bmw','320','3','NEW','NO'),
('434343','MAZDA','323','5','USED','YES');

INSERT INTO employees(first_name,last_name,title)
VALUES
('pESHO','kIRCHEV','mamut'),
('KIMI','RAIKONEN','SHAMPOAN'),
('KICHKA','MINZUHAROVA','STRIPPER');


INSERT INTO customers(full_name,adress,city,zip_code)
VALUES
('Encho Enchev','Mongolska street','Manganiq','44444'),
('Monio Minchev','Geiska street','Bronz','45'),
('Sasho Sashev','SIKISH','PALEC','44444');

INSERT INTO rental_orders(car_condition, tank_level,kilometrage_start,kilometrage_end,total_kilometrage,order_status)
VALUES
('USED',5,4,5,5,'PENDING'),
('USED',5,5,2,5,'PENDING'),
('USED',5,3,5,1,'PENDING');

#Problem 15
-- 
-- 

CREATE TABLE employees 
(
id INT NOT NULL AUTO_INCREMENT,
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50),
title VARCHAR(50),
notes LONGTEXT,
PRIMARY KEY(id));

CREATE TABLE customers 
(
id INT NOT NULL AUTO_INCREMENT,
account_number VARCHAR(50) NOT NULL UNIQUE,
first_name VARCHAR(50) ,
last_name VARCHAR(50) ,
phone_number VARCHAR(50) ,
emergency_name VARCHAR(50) ,
emergency_number VARCHAR(50) ,
notes LONGTEXT,
PRIMARY KEY(id));

CREATE TABLE room_status(
id INT NOT NULL AUTO_INCREMENT,
room_status VARCHAR(50) NOT NULL,
notes LONGTEXT, 
PRIMARY KEY(id)
);

CREATE TABLE room_types(
id INT NOT NULL AUTO_INCREMENT,
room_type VARCHAR(50) NOT NULL,
notes LONGTEXT, 
PRIMARY KEY(id)
);

CREATE TABLE bed_types(
id INT NOT NULL AUTO_INCREMENT,
bed_type VARCHAR(50) NOT NULL,
notes LONGTEXT, 
PRIMARY KEY(id)
);

CREATE TABLE rooms(
id INT NOT NULL AUTO_INCREMENT,
room_number VARCHAR(50),
room_type VARCHAR(50),
bed_type VARCHAR(50),
rate FLOAT,
room_status VARCHAR(50),
notes LONGTEXT,
PRIMARY KEY(id));

CREATE TABLE payments (
id INT NOT NULL AUTO_INCREMENT,
employee_id INT,
payment_date DATETIME,
account_number VARCHAR(50) UNIQUE,
first_date_occupied DATETIME,
last_date_occupied DATETIME,
total_days INT,
amount_charged FLOAT,
tax_rate FLOAT,
tax_amount FLOAT,
payment_total FLOAT,
notes LONGTEXT,
PRIMARY KEY(id));

CREATE TABLE occupancies (
id INT NOT NULL AUTO_INCREMENT,
employee_id INT,
date_occupied DATETIME,
account_number VARCHAR(50) UNIQUE,
room_number VARCHAR(50),
rate_applied FLOAT,
phone_charge FLOAT,
notes LONGTEXT,
PRIMARY KEY(id));

INSERT INTO employees(first_name)
VALUES('pesho'),('pggesho'),('ggfder');

INSERT INTO customers(account_number)
VALUES('123'),('1'),('124');

INSERT INTO room_status(room_status)
VALUES('1'),('1'),('1');

INSERT INTO room_types(room_type)
VALUES('1'),('1'),('1');

INSERT INTO bed_types(bed_type)
VALUES('1'),('1'),('1');

INSERT INTO rooms(room_number)
VALUES('1'),('2'),('3');

INSERT INTO payments(account_number)
VALUES('12'),('124'),('122');

INSERT INTO occupancies(account_number)
VALUES('12'),('124'),('122');

#Problem 19

SELECT * FROM towns;
SELECT * FROM departments;
SELECT * FROM employees;

#Problem 20

SELECT * FROM towns
  ORDER BY name;
SELECT * FROM departments
  ORDER BY name;
SELECT * FROM employees
  ORDER BY salary DESC;

#Problem 21

SELECT name FROM towns
  ORDER BY name;
SELECT name FROM departments
  ORDER BY name;
SELECT first_name,last_name,job_title,salary FROM employees
  ORDER BY salary DESC;
  
#Problem 22

UPDATE employees
 SET salary = salary * 1.10;

SELECT salary FROM employees;

#Problem 23

UPDATE payments
  SET tax_rate = tax_rate * 0.97;

Select tax_rate from payments;

#Problem 24

DELETE FROM occupancies;