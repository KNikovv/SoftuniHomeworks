#Problem 2

SELECT * FROM departments;

#Problem 3

SELECT name FROM departments;

#Problem 4

SELECT first_name, last_name, salary FROM employees;

#Problem 5

SELECT first_name, middle_name,last_name  FROM employees;

#Problem 6

SELECT 
CONCAT(first_name,'.',last_name,'@softuni.bg') AS Full_email_adress
FROM employees;

#Problem 7

SELECT DISTINCT salary FROM employees;

#Problem 8

SELECT * FROM employees
WHERE job_title = 'Sales Representative';

#Problem 9

SELECT first_name, last_name , job_title 
FROM employees
WHERE salary BETWEEN 20000 AND 30000;

#Problem 10

SELECT CONCAT (first_name,' ',middle_name,' ',last_name) AS full_name
FROM employees
WHERE salary IN (25000,14000,12500,23600);

#Problem 11

SELECT first_name , last_name FROM employees
WHERE manager_id IS NULL;

#Problem 12

SELECT first_name,last_name, salary 
	FROM employees
WHERE salary > 50000
ORDER BY salary DESC;

#Problem 13

SELECT first_name,last_name 
	FROM employees
ORDER BY salary DESC
LIMIT 5;
#Problem 14

SELECT first_name , last_name 
	FROM employees
WHERE department_id != 4;

#Problem 15

SELECT * 
	FROM employees
ORDER BY 
	salary DESC, 
	first_name ASC,
	last_name DESC,
	middle_name ASC;
	
#Problem 16

CREATE VIEW v_employees_salaries AS
SELECT first_name,last_name,salary 
	FROM employees;
	
#Problem 17

CREATE VIEW v_employees_job_titles AS
SELECT 
	CASE WHEN middle_name IS NULL
	THEN CONCAT(first_name,'  ',last_name)
	ELSE CONCAT(first_name,' ', middle_name, ' ',last_name)
END AS full_name,job_title
FROM employees;

#Problem 18

SELECT DISTINCT job_title FROM employees;

#Problem 19

SELECT * FROM projects
ORDER BY start_date ASC , name ASC
LIMIT 10;

#Problem 20

SELECT first_name , last_name , hire_date FROM employees
ORDER BY hire_date DESC
LIMIT 7;

#Problem 21

UPDATE employees
	SET salary = salary * 1.12
	WHERE department_id IN(1,2,4,11);

SELECT salary FROM employees;

#Problem 22

SELECT peak_name FROM peaks
ORDER BY peak_name;

#Problem 23

SELECT country_name,population FROM countries
WHERE continent_code = 'EU'
ORDER BY population desc
LIMIT 30;

#Problem 24

SELECT country_name , country_code, 
	CASE WHEN currency_code = 'EUR' 
	THEN 'Euro' 
	ELSE 'Not Euro' 
	END AS currency 
FROM countries
	ORDER BY country_name;
	
#Problem 25

SELECT name FROM characters
  ORDER BY name;