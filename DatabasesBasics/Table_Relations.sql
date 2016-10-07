#Problem 1

CREATE TABLE passports
(
passport INT NOT NULL AUTO_INCREMENT,
passport_number VARCHAR(50) UNIQUE NOT NULL ,
PRIMARY KEY(passport)
) AUTO_INCREMENT = 101;

INSERT INTO passports(passport_number) 
	VALUES('N34FG21B'),('K65LO4R7'),('ZE657QP2');

CREATE TABLE persons 
(
person_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
first_name varchar(50),
salary DOUBLE(13,2) NOT NULL,
passport_id INT NOT NULL,
FOREIGN KEY(passport_id) REFERENCES passports(passport)
);

INSERT INTO persons(first_name,salary,passport_id)
	VALUES('Roberto',43300.00,102),('Tom',56100.00,103),('Yana',60200.00,101)

#Problem 2

CREATE TABLE manufacturers
(
manufacturer_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(50) NOT NULL ,
established_on datetime 
);

CREATE TABLE models 
(
model_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(50) NOT NULL ,
manufacturer_id INT NOT NULL,
FOREIGN KEY(manufacturer_id) REFERENCES manufacturers(manufacturer_id)
) AUTO_INCREMENT = 101;

INSERT INTO manufacturers(name,established_on)
VALUES('BMW','1916-07-03'),('Tesla','2003-01-01'),('Lada','1966-05-01');

INSERT INTO models(name,manufacturer_id)
VALUES('X1',1),('i6',1),('Model S',2),('Model X',2),('Model 3',2),('Niva',3);

#Problem 3

CREATE TABLE students
(
student_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(50) NOT NULL
);

CREATE TABLE exams
(
exam_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(50) NOT NULL
) AUTO_INCREMENT = 101;

CREATE TABLE students_exams
(
student_id INT NOT NULL,
exam_id INT NOT NULL,
FOREIGN KEY(exam_id) REFERENCES exams(exam_id),
FOREIGN KEY(student_id) REFERENCES students(student_id),
UNIQUE(student_id,exam_id)
);


INSERT INTO students(name) VALUES('Mila'),('Toni'),('Ron');

INSERT INTO exams(name) VALUES('Spring MVC'),('Neo4j'),('Oracle 11g');

INSERT INTO students_exams(student_id,exam_id)
VALUES(1,101),(1,102),(2,101),(3,103),(2,102),(2,103);

#Problem 4

CREATE TABLE teachers
(
teacher_id INT NOT NULL PRIMARY KEY,
name VARCHAR(50),
manager_id INT,
FOREIGN KEY(manager_id) REFERENCES teachers(teacher_id)
) ;

INSERT INTO teachers(teacher_id,name) 
VALUES (101,'John');
INSERT INTO teachers(teacher_id,name,manager_id)
VALUES
(105,'Mark',101),
(106,'Greta',101),
(102,'Maya',106),
(103,'Silvia',106),
(104,'Ted',105)

#Problem 5

CREATE TABLE item_types
(
item_type_id INT NOT NULL PRIMARY KEY,
name VARCHAR(50)
); 

CREATE TABLE cities
(
city_id INT NOT NULL PRIMARY KEY,
name VARCHAR(50)
);

CREATE TABLE items
(
item_id INT NOT NULL PRIMARY KEY,
name VARCHAR(50),
item_type_id INT NOT NULL,
FOREIGN KEY (item_type_id) REFERENCES item_types(item_type_id)
);

CREATE TABLE customers
(
customer_id INT NOT NULL PRIMARY KEY,
name VARCHAR(50),
birthday DATE not null,
city_id INT NOT NULL,
FOREIGN KEY (city_id) REFERENCES cities(city_id)
);

CREATE TABLE orders
(
order_id INT NOT NULL PRIMARY KEY,
customer_id INT NOT NULL,
FOREIGN KEY(customer_id) REFERENCES customers(customer_id)
);

CREATE TABLE order_items
(
order_id INT NOT NULL,
item_id INT NOT NULL,
UNIQUE(order_id,item_id),
FOREIGN KEY(item_id) REFERENCES items(item_id)
);

#Problem 6

CREATE TABLE majors
(
major_id INT NOT NULL PRIMARY KEY,
name VARCHAR(50)
);

CREATE TABLE subjects
(
subject_id INT NOT NULL PRIMARY KEY,
subject_name VARCHAR(50)
);

CREATE TABLE students
(
student_id INT NOT NULL PRIMARY KEY,
student_number VARCHAR(12) ,
student_name VARCHAR(50),
major_id INT NOT NULL,
FOREIGN KEY(major_id) REFERENCES majors(major_id)
);

CREATE TABLE agenda
(
student_id INT NOT NULL,
subject_id INT NOT NULL,
FOREIGN KEY(student_id) REFERENCES students(student_id),
FOREIGN KEY(subject_id) REFERENCES subjects(subject_id),
unique(student_id,subject_id)
);

CREATE TABLE payments
(
payment_id INT NOT NULL PRIMARY KEY,
payment_date DATE ,
payment_amount DECIMAL(8,2),
student_id INT NOT NULL,
FOREIGN KEY(student_id) REFERENCES students(student_id)
);

#Problem 9

SELECT
e.employee_id,e.job_title,a.address_id,a.address_text
	FROM employees AS e
	JOIN addresses AS a
		ON e.address_id = a.address_id  
	ORDER BY a.address_id
LIMIT 5

#Problem 10

SELECT
e.employee_id,e.first_name,e.salary,d.name
	FROM employees AS e
		JOIN departments AS d
			ON e.department_id = d.department_id
		WHERE e.salary > 15000
	ORDER BY e.department_id
LIMIT 5

#Problem 11

SELECT e.employee_id, e.first_name
	FROM employees AS e
		WHERE e.employee_id NOT IN
			(SELECT b.employee_id FROM employees_projects AS b)
	ORDER BY e.employee_id
LIMIT 3


#Problem 12

SELECT e.employee_id, e.first_name, p.name
	FROM employees AS e 
		JOIN employees_projects AS b
			ON e.employee_id = b.employee_id
		JOIN projects AS p
			ON b.project_id = p.project_id
	WHERE p.start_date > '2002-08-13' 
		AND p.end_date IS NULL
	ORDER BY e.employee_id 
LIMIT 5

#Problem 13

SELECT e.employee_id, e.first_name, p.name
	FROM employees AS e 
		LEFT JOIN employees_projects AS b
			ON e.employee_id = b.employee_id
		LEFT JOIN projects AS p
			ON p.project_id = b.project_id
		AND p.start_date < '2005-01-01'
		WHERE e.employee_id = 24

#Problem 14

SELECT
e.employee_id,
e.first_name,
m.employee_id AS manager_id,
m.first_name AS manager_name
	FROM employees AS e
		JOIN employees AS m
			ON m.employee_id = e.manager_id
		WHERE e.manager_id IN (3,7) 
	ORDER BY e.employee_id

#Problem 15

SELECT
c.country_code,
o.mountain_range,
p.peak_name,
p.elevation
	FROM countries AS c
		JOIN mountains_countries AS m
			ON m.country_code = c.country_code
		JOIN peaks AS p
			ON p.mountain_id = m.mountain_id
		JOIN mountains AS o
			ON o.id = m.mountain_id
		WHERE c.country_code = 'BG' 
		AND p.elevation> 2835
	ORDER BY p.elevation DESC

#Problem 16

SELECT
c.country_code,
COUNT(*) AS mountain_ranges
	FROM countries AS c
		JOIN mountains_countries AS m
			ON m.country_code = c.country_code
		JOIN mountains AS o
			ON o.id = m.mountain_id
		WHERE c.country_code IN ('BG','RU','US')
	GROUP BY c.country_code

#Problem 17

SELECT
c.country_name,
r.river_name
	FROM countries AS c
 		LEFT JOIN countries_rivers AS cr
 			ON c.country_code = cr.country_code
 		LEFT JOIN rivers AS r
 			ON r.id = cr.river_id
 		WHERE c.continent_code = 'AF'
	ORDER BY c.country_name
LIMIT 5

#Problem 18

SELECT co.continent_code
		,c.currency_code
		,(SELECT COUNT(c.currency_code)
		 	FROM countries AS c
		 		WHERE c.continent_code = co.continent_code
		 	GROUP BY c.currency_code
		 		HAVING COUNT(c.currency_code) > 1
		 	ORDER BY COUNT(c.currency_code) DESC
		 LIMIT 1) AS currency_usage
FROM continents AS co
	JOIN countries AS c ON c.continent_code = co.continent_code
WHERE c.currency_code IN 
	(SELECT c.currency_code
		FROM countries AS c
			WHERE c.continent_code = co.continent_code
		GROUP BY c.currency_code
			HAVING COUNT(c.currency_code) > 1 
			AND
				COUNT(c.currency_code) = 
				(SELECT COUNT(c.currency_code)
						FROM countries AS c
				 WHERE c.continent_code = co.continent_code
					  GROUP BY c.currency_code
				HAVING COUNT(c.currency_code) > 1
				ORDER BY COUNT(c.currency_code) DESC
			    LIMIT 1)
		ORDER BY COUNT(c.currency_code) DESC)
	GROUP BY co.continent_code, c.currency_code
ORDER BY co.continent_code,c.currency_code desc

#Problem 19

SELECT
((SELECT COUNT(*)
FROM countries AS c LEFT JOIN mountains_countries AS mc ON c.country_code = mc.country_code)
-
(SELECT count(*)
FROM countries AS c RIGHT JOIN mountains_countries AS mc ON c.country_code = mc.country_code)) AS 
country_code

#Problem 20

SELECT
o.country_name,
(SELECT MAX(p.elevation) FROM peaks AS p
		JOIN mountains_countries AS mc 
			ON mc.mountain_id = p.mountain_id
		JOIN countries AS c 
			ON c.country_code = mc.country_code
		GROUP BY c.country_code
			HAVING c.country_code = o.country_code) AS highest_peak_elevation,
(SELECT max(r.length) from rivers AS r
		JOIN countries_rivers AS rc
			ON rc.river_id = r.id
		JOIN countries AS c 
			ON c.country_code = rc.country_code
		GROUP BY c.country_code
			HAVING c.country_code = o.country_code) AS longest_river_length
	FROM countries AS o
		ORDER BY highest_peak_elevation DESC ,longest_river_length DESC , o.country_name ASC
LIMIT 5

#Problem 21

SELECT 
c.country_name as country_name,
p.peak_name AS highest_peak_name,
p.elevation AS highest_peak_elevation,
mo.mountain_range AS mountain
FROM countries AS c
	LEFT JOIN mountains_countries AS m 
		ON c.country_code = m.country_code
	LEFT JOIN mountains AS mo
		ON m.mountain_id = mo.id
	LEFT join peaks AS p
		ON p.mountain_id = m.mountain_id
	WHERE p.elevation = (
			SELECT MAX(elevation) FROM peaks as p
			LEFT JOIN mountains as m ON m.id = p.mountain_id
			LEFT JOIN mountains_countries AS mc ON mc.mountain_id = m.id
			WHERE c.country_code = mc.country_code
			)
UNION
 SELECT 
	c.country_name as country_name,
	'(no highest peak)' AS highest_peak_name,
	0 AS highest_peak_elevation,
	'(no mountain)' AS mountain
	FROM countries AS c
		LEFT JOIN mountains_countries AS m 
			ON c.country_code = m.country_code
		LEFT JOIN mountains AS mo
			ON m.mountain_id = mo.id
		LEFT join peaks AS p
			ON p.mountain_id = m.mountain_id
		WHERE (
			SELECT MAX(elevation) FROM peaks as p
			LEFT JOIN mountains as m ON m.id = p.mountain_id
			LEFT JOIN mountains_countries AS mc ON mc.mountain_id = m.id
			WHERE c.country_code = mc.country_code
			) IS NULL
		ORDER BY country_name
	LIMIT 5