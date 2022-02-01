USE `fsd`;

DELIMITER $$$
CREATE FUNCTION `udf_stadium_players_count` (`stadium_name` VARCHAR(30))
RETURNS INT
DETERMINISTIC
BEGIN
	RETURN (SELECT COUNT(p.`id`)
	FROM `stadiums` AS s
    LEFT JOIN `teams` AS t
    ON s.`id` = t.`stadium_id`
    LEFT JOIN `players` AS p
    ON t.`id` = p.`team_id`
    WHERE s.`name` = `stadium_name`);
END; $$$
DELIMITER ;

SELECT UDF_STADIUM_PLAYERS_COUNT('Jaxworks') AS `count`;