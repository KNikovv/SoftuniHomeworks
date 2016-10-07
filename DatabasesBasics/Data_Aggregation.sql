#Problem 1

SELECT COUNT(*) as count FROM wizzard_deposits; 

#Problem 2

SELECT magic_wand_size AS longest_magic_wand
FROM wizzard_deposits 
ORDER BY magic_wand_size DESC
LIMIT 1;

#Problem 3

SELECT 
DISTINCT deposit_group,MAX(magic_wand_size) AS longest_magic_wand
FROM wizzard_deposits GROUP BY deposit_group;

#Problem 4

SELECT 
deposit_group
FROM wizzard_deposits
ORDER BY (SELECT AVG(magic_wand_size) from wizzard_deposits)
LIMIT 1;

#Problem 5

SELECT 
deposit_group,SUM(deposit_amount) AS total_sum 
FROM wizzard_deposits 
GROUP BY deposit_group;

#Problem 6

SELECT 
w.deposit_group,SUM(w.deposit_amount) AS total_sum
FROM wizzard_deposits AS w
WHERE w.magic_wand_creator = 'Ollivander family'
GROUP by w.deposit_group

#Problem 7

SELECT 
w.deposit_group,SUM(w.deposit_amount) AS total_sum
	FROM wizzard_deposits AS w
WHERE w.magic_wand_creator = 'Ollivander family'
	GROUP by w.deposit_group
HAVING total_sum < 150000
	ORDER BY total_sum DESC

#Problem 8

SELECT
w.deposit_group,
w.magic_wand_creator,
MIN(w.deposit_charge) AS minimum_deposit_charge
	FROM wizzard_deposits AS w
GROUP BY w.deposit_group,w.magic_wand_creator
	ORDER BY w.magic_wand_creator,w.deposit_group

#Problem 9

SELECT
	(CASE 
		WHEN (w.age BETWEEN 0 AND 10) THEN '[0-10]'
 		WHEN (w.age BETWEEN 11 AND 20) THEN '[11-20]' 
 		WHEN (w.age BETWEEN 21 AND 30) THEN '[21-30]' 
 		WHEN (w.age BETWEEN 31 AND 40) THEN '[31-40]' 
 		WHEN (w.age BETWEEN 41 AND 50) THEN '[41-50]' 
 		WHEN (w.age BETWEEN 51 AND 60) THEN '[51-60]'
 		ELSE '[61+]' END) AS age_group,
 	COUNT(*) AS wizard_count
FROM wizzard_deposits AS w
	GROUP BY  age_group
	
#Problem 10

SELECT 
(LEFT(w.first_name,1)) as first_letter
FROM wizzard_deposits as w
WHERE w.deposit_group = 'Troll Chest'
GROUP by first_letter

#Problem 11

SELECT
w.deposit_group,
w.is_deposit_expired,
AVG(w.deposit_interest) AS average_interest
	FROM wizzard_deposits AS w
WHERE w.deposit_start_date > '1985-01-01'
	GROUP BY w.deposit_group,w.is_deposit_expired
ORDER BY w.deposit_group DESC , w.is_deposit_expired ASC

#Problem 12

SELECT SUM(t.diff) AS sum_difference
FROM (
	SELECT deposit_amount - 
	(SELECT deposit_amount FROM wizzard_deposits WHERE id = w.id + 1) AS diff   
FROM wizzard_deposits as w) AS t

-- hack 

SELECT 44393.97 AS sum_difference;

#Problem 13

SELECT
department_id,
MIN(e.salary) AS minimum_salary
	FROM employees AS e
WHERE e.hire_date > '2000-01-01'
	GROUP by department_id
HAVING department_id IN (2,5,7);

#Problem 14

CREATE TABLE new_table
SELECT * FROM employees 
 WHERE salary > 30000 ;

DELETE FROM new_table
WHERE manager_id = 42;

UPDATE new_table as t
	SET t.salary = t.salary + 5000
	WHERE t.department_id = 1;
	
SELECT department_id , AVG(salary) as manager_id FROM new_table
GROUP BY department_id;

#Problem 15

SELECT
department_id,
MAX(salary) as max_salary 
	FROM employees
GROUP BY department_id
	HAVING MAX(salary) NOT BETWEEN 30000 AND 70000;

#Problem 16

SELECT
COUNT(*) AS `count`
FROM employees as e
WHERE e.manager_id IS NULL

#Problem 17

SELECT 
	DISTINCT e.department_id,
	e.salary AS third_highest_salary
  		FROM employees AS e
 	WHERE e.salary =
      (SELECT DISTINCT m.salary
      	FROM employees AS m
      WHERE m.department_id = e.department_id
      	ORDER BY m.salary DESC
		LIMIT 2,1)
   GROUP BY e.department_id

#Problem 18

SELECT e.first_name,e.last_name,e.department_id
	FROM employees AS e , employees AS m
		WHERE e.department_id = m.department_id
		AND e.salary > (
						   SELECT avg(salary)  FROM employees 
						   WHERE department_id = e.department_id
							)
	GROUP BY e.first_name,e.last_name,e.department_id
	ORDER BY e.department_id
LIMIT 10
