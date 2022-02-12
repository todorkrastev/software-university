USE `sgd`;

DELIMITER $$$
CREATE PROCEDURE `udp_update_budget` (`min_game_rating` FLOAT(19, 2))
BEGIN
		UPDATE `games`
		SET `budget` = `budget` + 100000, 
		`release_date` = DATE_ADD(`release_date`, INTERVAL 1 YEAR)
		WHERE `id` NOT IN (SELECT `game_id` FROM `games_categories`)
		AND `rating` > min_game_rating
		AND `release_date` IS NOT NULL; 
END; $$$
DELIMITER ;

CALL udp_update_budget (8);