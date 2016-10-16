-- Problem 1

CREATE PROCEDURE usp_get_employees_salary_above_35000 ()
BEGIN
	DECLARE maxSalary INT;
	SET maxSalary := 35000;
	
	SELECT first_name,last_name
	 FROM employees 
		WHERE salary > maxSalary;
END

-- Problem 2

CREATE PROCEDURE usp_get_employees_salary_above (number LONG)
BEGIN
	SELECT first_name,last_name FROM employees
	WHERE salary >= number;
END

-- Problem 3

CREATE PROCEDURE usp_get_towns_starting_with (word VARCHAR(50))
BEGIN
	SELECT name AS town FROM towns 
	WHERE LEFT(name, CHAR_LENGTH(word)) = word;
END

-- Problem 4

CREATE PROCEDURE usp_get_employees_from_town (townName VARCHAR(50))
BEGIN
	SELECT first_name,last_name FROM employees AS e
		JOIN addresses AS a
			ON a.address_id = e.address_id
		JOIN towns AS t
			ON t.town_id = a.town_id
		WHERE t.name = townName;
END

-- Problem 5

CREATE FUNCTION ufn_get_salary_level (salary INT)
RETURNS VARCHAR(10)
BEGIN
	DECLARE salaryLevel VARCHAR(10);
	
	IF (salary < 30000) THEN
		SET salaryLevel := 'Low';
	ELSEIF (salary <= 50000) THEN
		SET salaryLevel := 'Average';
	ELSE  
		SET salaryLevel := 'High';
	END IF;
	RETURN salaryLevel;
END

-- Problem 7

CREATE FUNCTION ufn_is_word_comprised (set_of_letters VARCHAR(21845), word VARCHAR(21845))
RETURNS TINYINT
BEGIN
    DECLARE wordLength INT;
    DECLARE currentIndex INT;
    DECLARE result TINYINT;
    SET wordLength := CHAR_LENGTH(word);
    SET currentIndex := 1;
    SET result := 1;
   
     WHILE  (currentIndex < wordLength) DO
        IF(set_of_letters NOT LIKE CONCAT('%',SUBSTR(word,currentIndex,1),'%')) THEN
            SET result:= 0;
        END IF;
        SET currentIndex := currentIndex + 1;
    END WHILE;
   
    RETURN result;
END

-- Problem 9

CREATE PROCEDURE usp_get_holders_full_name ()
BEGIN
	SELECT CONCAT(first_name,' ', last_name) AS full_name
	FROM account_holders;
END

-- Problem 10

CREATE PROCEDURE usp_get_holders_with_balance_higher_than  (number BIGINT)
BEGIN
	
SELECT first_name , last_name FROM account_holders AS ah
	JOIN accounts AS a
		ON a.account_holder_id = ah.id
	 GROUP by first_name,last_name
	 HAVING SUM(a.balance) > number;
END

-- Problem 11

CREATE FUNCTION ufn_calculate_future_value (initSum DOUBLE,rate DOUBLE,years INT)
RETURNS DOUBLE
BEGIN
	DECLARE result DOUBLE;
	DECLARE powValue DOUBLE;
	DECLARE powResult DOUBLE;
	SET powValue := 1 + rate;
	SET powResult := POWER(powValue,years);
	SET result := initSum * powResult;
	
	RETURN result;
END

-- Problem 13

CREATE PROCEDURE usp_deposit_money(account_id INT, money_amount DECIMAL)
BEGIN
	
	UPDATE accounts AS a
		SET a.balance = a.balance + money_amount
	 WHERE a.id = account_id;
END

-- Problem 14

CREATE PROCEDURE usp_withdraw_money (account_id INT, money_amount DECIMAL)
BEGIN
	
	UPDATE accounts AS a
		SET a.balance = a.balance - money_amount
	 WHERE a.id = account_id;
END

-- Problem 15

START TRANSACTION;
	UPDATE users_games AS ug
				JOIN users AS u 
					ON u.id = ug.user_id
				JOIN games AS g
					ON g.id = ug.game_id
			SET ug.cash = ug.cash - (SELECT SUM(i.price) FROM items AS i
			WHERE i.min_level IN (11,12))
				WHERE u.user_name = 'Stamat' AND g.name = 'Safflower';
				
		INSERT INTO user_game_items  (user_game_id,item_id)
			 (
			SELECT 110,i.id FROM items AS i
			 WHERE i.min_level IN (11,12)
			);
			COMMIT;
				START TRANSACTION;
			UPDATE users_games AS ug
				JOIN users AS u 
					ON u.id = ug.user_id
				JOIN games AS g
					ON g.id = ug.game_id
			SET ug.cash = ug.cash - (SELECT SUM(i.price) FROM items AS i
		WHERE i.min_level BETWEEN 19 AND 21)
				WHERE u.user_name = 'Stamat' AND g.name = 'Safflower';
	
				INSERT INTO user_game_items  (user_game_id,item_id)
			 (
			SELECT 110,i.id FROM items AS i
			 WHERE i.min_level BETWEEN 19 AND 21
			);
			COMMIT;
			
			SELECT i.name FROM items AS i
	JOIN user_game_items AS ugi
		ON i.id = ugi.item_id
	JOIN users_games AS ug
		ON ug.id = ugi.user_game_id
	JOIN games AS g
		ON g.id = ug.game_id
 WHERE g.name = 'Safflower'
 ORDER BY i.name ASC;
 
 -- Problem 20
 
SELECT SUBSTRING_INDEX(u.email,'@',-1) AS email_provider,
	COUNT(*) AS number_of_users
 FROM users AS u
 GROUP BY email_provider
 ORDER BY number_of_users DESC,email_provider ASC

-- Problem 21

SELECT
	g.name AS game,
	gt.name,
	u.user_name AS username,
	ug.`level` AS `level`,
	ug.cash,
	c.name
FROM users AS u 
		JOIN users_games AS ug
			ON ug.user_id = u.id
		JOIN games AS g
			ON g.id = ug.game_id
		JOIN game_types AS gt
			ON g.game_type_id = gt.id
		JOIN characters AS c
			ON c.id = ug.character_id	
	ORDER BY `level` DESC,username ASC,game ASC
	
-- Problem 22

SELECT
u.user_name AS username,
g.name AS game,
COUNT(*) AS items_count,
SUM(i.price) AS items_prices
FROM users AS u
	JOIN users_games AS ug
		ON ug.user_id = u.id
	JOIN games AS g
		ON g.id = ug.game_id
	JOIN user_game_items AS ugi
		ON ugi.user_game_id = ug.id
	JOIN items AS i
		ON i.id = ugi.item_id
GROUP BY u.user_name,g.name
HAVING COUNT(*) >= 10
ORDER BY items_count DESC, items_prices DESC, username ASC

-- Problem 23

SELECT
u.user_name AS username,
g.name AS game,
MAX(c.name) AS `character`,
SUM(its.strength) + MAX(cs.strength) + MAX(gts.strength) AS strength,
SUM(its.defence) + MAX(cs.defence) + MAX(gts.defence) AS defence,
SUM(its.speed) + MAX(cs.speed) + MAX(gts.speed) AS speed,
SUM(its.mind) + MAX(cs.mind) + MAX(gts.mind) AS mind,
SUM(its.luck) + MAX(cs.luck) + MAX(gts.luck) AS luck
FROM users AS u
	JOIN users_games AS ug
		ON u.id = ug.user_id
	JOIN user_game_items  AS ugi
		ON ugi.user_game_id = ug.id
	JOIN games AS g 
		ON g.id = ug.game_id
	JOIN characters AS c
		ON c.id = ug.character_id
	JOIN game_types AS gt
		ON gt.id = g.game_type_id
	JOIN statistics AS gts 
		ON gts.id = gt.bonus_stats_id
	JOIN items AS i
		ON i.id = ugi.item_id
	JOIN item_types AS it 
		ON it.id = i.item_type_id
	JOIN statistics AS its 
		ON its.id = i.statistics_id
	JOIN statistics AS cs 
		ON cs.id = c.statistics_id
GROUP BY u.user_name,g.name
ORDER BY strength DESC,defence DESC,speed DESC,mind DESC,luck DESC

-- Problem 24

SELECT
i.name AS name,
i.price AS price,
i.min_level AS min_level,
s.strength AS strength,
s.defence AS defence,
s.speed AS speed,
s.luck AS luck,
s.mind AS mind
FROM items AS i
	JOIN statistics AS s
		ON s.id = i.statistics_id
	GROUP BY name
HAVING s.mind > (
			SELECT AVG(s.mind) FROM items AS i
				JOIN statistics AS s
					ON i.statistics_id = s.id
				) AND s.speed > (
								SELECT AVG(s.mind) FROM items AS i
				JOIN statistics AS s
					ON i.statistics_id = s.id	
				) AND s.luck > (
							SELECT AVG(s.mind) FROM items AS i
				JOIN statistics AS s
					ON i.statistics_id = s.id
				)
ORDER by name ASC

-- Problem 25

SELECT 
i.name AS item,
i.price AS price,
i.min_level AS min_level,
gt.name AS forbidden_game_type
FROM items AS i
	LEFT JOIN game_type_forbidden_items AS gtfi
		ON gtfi.item_id = i.id
	LEFT JOIN game_types AS gt
		ON gt.id = gtfi.game_type_id
ORDER BY forbidden_game_type DESC , item ASC	

-- Problem 26

CREATE PROCEDURE usp_buy_items_for_alex ()
BEGIN
	DECLARE alex_id INT;							
	DECLARE blackguardPrice DECIMAL;
	DECLARE bottomlessPotionPrice DECIMAL;
	DECLARE eyeOfEtlichPrice DECIMAL;
	DECLARE gemOfIntoxPrice DECIMAL;
	DECLARE goldenGorgetOfLeoric DECIMAL;
	DECLARE hellfireAmuletPrice DECIMAL;
	DECLARE blackguardId INT;
	DECLARE bottomlessPotionId INT;
	DECLARE eyeOfEtlichId INT;
	DECLARE gemOfIntoxId INT;
	DECLARE goldenGorgetOfLeoricId INT;
	DECLARE hellfireAmuletPriceId INT;
	DECLARE totalPrice DECIMAL;
	SET alex_id := (SELECT ug.id FROM users AS u
							JOIN users_games AS ug ON ug.user_id = u.id
							JOIN games AS g ON g.id = ug.game_id
						 WHERE u.user_name = 'Alex' AND g.name = 'Edinburgh');
	
	
	SET blackguardPrice := (SELECT i.price FROM items AS i WHERE i.name = 'Blackguard');
	SET bottomlessPotionPrice := (SELECT i.price FROM items AS i WHERE i.name = 'Bottomless Potion of Amplification');
	SET eyeOfEtlichPrice := (SELECT i.price FROM items AS i WHERE i.name = 'Eye of Etlich (Diablo III)');
	SET gemOfIntoxPrice := (SELECT i.price FROM items AS i WHERE i.name = 'Gem of Efficacious Toxin');
	SET goldenGorgetOfLeoric := (SELECT i.price FROM items AS i WHERE i.name = 'Golden Gorget of Leoric ');
	SET hellfireAmuletPrice := (SELECT i.price FROM items AS i WHERE i.name = 'Hellfire Amulet');
	
	SET blackguardId := (SELECT i.id FROM items AS i WHERE i.name = 'Blackguard');
	SET bottomlessPotionId := (SELECT i.id FROM items AS i WHERE i.name = 'Bottomless Potion of Amplification');
	SET eyeOfEtlichId := (SELECT i.id FROM items AS i WHERE i.name = 'Eye of Etlich (Diablo III)');
	SET gemOfIntoxId := (SELECT i.id FROM items AS i WHERE i.name = 'Gem of Efficacious Toxin');
	SET goldenGorgetOfLeoricId := (SELECT i.id FROM items AS i WHERE i.name = 'Golden Gorget of Leoric ');
	SET hellfireAmuletPriceId := (SELECT i.id FROM items AS i WHERE i.name = 'Hellfire Amulet');	
	
	SET totalPrice := blackguardPrice + bottomlessPotionPrice + eyeOfEtlichPrice + 
										gemOfIntoxPrice + goldenGorgetOfLeoric + hellfireAmuletPrice ;
	UPDATE users_games 
	SET cash =  cash - totalPrice
	WHERE id = alex_id;
	
	INSERT INTO user_game_items (item_id,user_game_id)
	VALUES
	(blackguardId,alex_id),
	(bottomlessPotionId,alex_id),
	(eyeOfEtlichId,alex_id),
	(gemOfIntoxId,alex_id),
	(goldenGorgetOfLeoricId,alex_id),
	(hellfireAmuletPriceId,alex_id);
	
	SELECT u.user_name,g.name AS game_name,ug.cash,i.name AS item_name FROM users AS u
			JOIN users_games AS ug ON ug.user_id = u.id
			JOIN user_game_items AS ugi ON ugi.user_game_id = ug.id
			JOIN items AS i ON i.id = ugi.item_id
			JOIN games AS g ON g.id = ug.game_id
			WHERE g.name = 'Edinburgh'
	ORDER BY item_name;
END

-- Problem 27

SELECT
p.peak_name AS peakname,
m.mountain_range AS mountain,
p.elevation AS elevation
FROM peaks AS p
	JOIN mountains AS m
		ON m.id = p.mountain_id
ORDER BY elevation DESC , peakname ASC

-- Problem 28

SELECT 
p.peak_name AS peakname,
m.mountain_range AS mountain,
c.country_name AS countryname,
co.continent_name AS continentname
	FROM peaks AS p
		JOIN mountains AS m
			ON m.id = p.mountain_id
		JOIN mountains_countries AS mc
			ON mc.mountain_id = m.id
		JOIN countries AS c
			ON c.country_code = mc.country_code
		JOIN continents AS co
			ON co.continent_code = c.continent_code
ORDER BY peakname,countryname

-- Problem 29

SELECT 
c.country_name ,
co.continent_name ,
COUNT(r.id) AS river_count,
IFNULL(SUM(r.length),0) AS total_length
FROM countries AS c
	LEFT JOIN continents AS co
		ON co.continent_code = c.continent_code
	LEFT JOIN countries_rivers AS cr
		ON c.country_code = cr.country_code
	LEFT JOIN rivers AS r
		ON cr.river_id = r.id
GROUP BY c.country_name,co.continent_name
ORDER BY river_count DESC ,total_length DESC, c.country_name ASC 

-- Problem 30

SELECT
cu.currency_code AS CurrencyCode,
cu.description AS Currency,
COUNT(c.currency_code) AS NumberOfCountries
FROM currencies AS cu
  LEFT JOIN countries AS c
		ON c.currency_code = cu.currency_code
GROUP BY c.currency_code,cu.description
ORDER BY NumberOfCountries DESC,Currency ASC

-- Problem 31

SELECT
co.continent_name,
SUM(c.area_in_sq_km) AS `area`,
SUM(c.population) AS total_population
FROM continents AS co
	JOIN countries AS c
		ON c.continent_code = co.continent_code
GROUP BY co.continent_name
ORDER BY total_population DESC

-- Problem 32

CREATE TABLE monasteries (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(50),
country_code CHAR(2) ,
CONSTRAINT fk_monasteries_countries FOREIGN KEY(country_code) 
REFERENCES countries(country_code)
);

INSERT INTO monasteries(name, country_code) VALUES
('Rila Monastery “St. Ivan of Rila”', 'BG'), 
('Bachkovo Monastery “Virgin Mary”', 'BG'),
('Troyan Monastery “Holy Mother''s Assumption”', 'BG'),
('Kopan Monastery', 'NP'),
('Thrangu Tashi Yangtse Monastery', 'NP'),
('Shechen Tennyi Dargyeling Monastery', 'NP'),
('Benchen Monastery', 'NP'),
('Southern Shaolin Monastery', 'CN'),
('Dabei Monastery', 'CN'),
('Wa Sau Toi', 'CN'),
('Lhunshigyia Monastery', 'CN'),
('Rakya Monastery', 'CN'),
('Monasteries of Meteora', 'GR'),
('The Holy Monastery of Stavronikita', 'GR'),
('Taung Kalat Monastery', 'MM'),
('Pa-Auk Forest Monastery', 'MM'),
('Taktsang Palphug Monastery', 'BT'),
('Sümela Monastery', 'TR');

UPDATE countries AS c
SET is_deleted = 1
WHERE 3 < (
SELECT COUNT(*) FROM rivers AS o
	JOIN countries_rivers AS cr
		ON cr.river_id = o.id
	WHERE c.country_code = cr.country_code
	GROUP BY cr.country_code);
	
SELECT m.name AS monastery,c.country_name
 	FROM monasteries AS m
		JOIN countries AS c
	ON c.country_code = m.country_code		
	WHERE c.is_deleted = 0 OR c.is_deleted IS NULL
ORDER BY monastery

-- Problem 33

UPDATE countries AS c
	SET c.country_name = 'Burma'
WHERE c.country_name = 'Myanmar';

INSERT INTO monasteries(name,country_code)
VALUES
 ('Hanga Abbey', (SELECT country_code FROM countries AS c WHERE c.country_name = 'Tanzania')),
 ('Myin-Tin-Daik',(SELECT country_code FROM countries AS c WHERE c.country_name = 'Myanmar'));

SELECT 
co.continent_name,
c.country_name,
COUNT(m.id) AS monastery_count
FROM continents AS co
 JOIN countries AS c
  ON c.continent_code = co.continent_code
 LEFT JOIN monasteries AS m
  ON m.country_code = c.country_code
  WHERE c.is_deleted = 0 OR c.is_deleted IS NULL
GROUP BY co.continent_name,c.country_name
ORDER by monastery_count DESC,country_name ASC

