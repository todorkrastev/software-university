USE `sgd`;

DELIMITER $$$
CREATE FUNCTION `udf_game_info_by_name`(`game_name` VARCHAR(20))
RETURNS TEXT
DETERMINISTIC
BEGIN
	RETURN (CONCAT_WS(' ', 'The', game_name, 'is developed by a', 
		(SELECT t.`name`
		FROM `games` AS g
		JOIN `teams` AS t
		ON g.`team_id` = t.`id`
		WHERE g.`name` = game_name), 'in an office with an address', 
		(SELECT a.`name`
		FROM `games` AS g
		JOIN `teams` AS t
		ON g.`team_id` = t.`id`
		JOIN `offices` AS o
		ON t.`office_id` = o.`id`
		JOIN `addresses` AS a
		ON o.`address_id` = a.`id`
		WHERE g.`name` = game_name)));
END; $$$
DELIMITER ;

SELECT udf_game_info_by_name('Bitwolf') AS info;
SELECT udf_game_info_by_name('Fix San') AS info;
SELECT udf_game_info_by_name('Job') AS info;

SELECT a.`name`
FROM `games` AS g
JOIN `teams` AS t
ON g.`team_id` = t.`id`
JOIN `offices` AS o
ON t.`office_id` = o.`id`
JOIN `addresses` AS a
ON o.`address_id` = a.`id`
WHERE g.`name` = 'Bitwolf';

SELECT t.`name`
FROM `games` AS g
JOIN `teams` AS t
ON g.`team_id` = t.`id`
WHERE g.`name` = 'Bitwolf';