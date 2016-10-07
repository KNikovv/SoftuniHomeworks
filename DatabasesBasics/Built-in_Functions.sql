#Problem 1

SELECT first_name , last_name 
	FROM employees
WHERE first_name LIKE 'SA%';

#Problem 2

SELECT first_name , last_name
	FROM employees
WHERE last_name LIKE '%ei%';

#Problem 3

SELECT first_name
	FROM employees
WHERE department_id IN (3,10) 
	AND EXTRACT(YEAR FROM hire_date) BETWEEN 1995 AND 2005;
	
#Problem 4

SELECT first_name , last_name
	FROM employees
WHERE job_title NOT LIKE '%engineer%';

#Problem 5

SELECT name from towns
	WHERE LENGTH(name) BETWEEN 5 AND 6 
ORDER by name;

#Problem 6

SELECT town_id , name 
	FROM towns
WHERE name LIKE 'M%' OR name LIKE 'K%' OR name LIKE 'B%' OR name LIKE 'E%'
	ORDER BY name;

#Problem 7

SELECT town_id , name 
	FROM towns
WHERE name NOT LIKE 'R%' AND name NOT LIKE 'B%' AND name NOT LIKE 'D%' 
	ORDER BY name;

#Problem 8

CREATE VIEW v_employees_hired_after_2000 AS
	SELECT first_name,last_name 
FROM employees
	WHERE EXTRACT(YEAR from hire_date) > 2000;

#Problem 9

SELECT first_name,last_name
FROM employees 
WHERE LENGTH(last_name) = 5;

#Problem 10

SELECT country_name,iso_code
FROM countries
WHERE country_name LIKE '%a%a%a%' 
ORDER BY iso_code;

#Problem 11

SELECT peak_name,river_name,
	LCASE(CONCAT(SUBSTRING(peak_name,1,CHAR_LENGTH(peak_name)-1),river_name)) AS mix
FROM peaks,rivers
	WHERE
SUBSTRING(river_name,1,1) = SUBSTRING(peak_name,-1)
	ORDER by mix;

#Problem 12

SELECT name as game,
		DATE_FORMAT(`start`,'%Y-%m-%d') as `start`
FROM games
	WHERE EXTRACT(YEAR from `start`) IN (2011,2012)
ORDER BY `start` ASC,name ASC
	LIMIT 50;
	
#Problem 13

SELECT user_name AS Username,
SUBSTRING_INDEX(email,'@',-1) AS 'Email Provider'
FROM users
ORDER by `Email Provider`,Username;

#Problem 14

SELECT user_name as Username,ip_address as 'IP Adress'
	FROM users
WHERE ip_address LIKE '___.1%.%.___'
	ORDER BY user_name;

#Problem 15

SELECT name as Game,
	CASE WHEN HOUR(`start`) BETWEEN 0 and 11 THEN 'Morning'
	ELSE IF(HOUR(`start`) BETWEEN 12 AND 17 ,'Afternoon','Evening') 
END AS 'Part of the Day',
	CASE WHEN duration<=3  THEN 'Extra Short'
	ELSE IF(duration<=6,'Short',IF(duration IS NULL,'Extra Long','Long'))
END AS Duration
	FROM games 
ORDER BY name ASC,duration ASC,'Part of the Day' ASC;

#Problem 16

SELECT product_name,order_date,
	DATE_ADD(order_date,INTERVAL 3 day) as pay_due,
	DATE_ADD(order_date,INTERVAL 1 month) as deliver_due
FROM orders;

