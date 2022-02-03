USE `fsd`;

DELIMITER $$$
CREATE PROCEDURE `udp_find_playmaker`(`min_dribble_points` INT, `team_name` VARCHAR(45))
BEGIN
	SELECT CONCAT_WS(' ', p.`first_name`, p.`last_name`) AS 'full_name',
    p.`age`, p.`salary`, sd.`dribbling`, sd.`speed`, t.`name`
    FROM `teams` AS t
    JOIN `players` AS p
    ON t.`id` = p.`team_id`
    JOIN `skills_data` AS sd
    ON sd.`id` = p.`skills_data_id`
    WHERE sd.`dribbling` > `min_dribble_points` AND t.`name` = `team_name`
    ORDER BY sd.`speed` DESC
    LIMIT 1;
END; $$$
DELIMITER ;

CALL `udp_find_playmaker`(20, 'Skyble');