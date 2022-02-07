USE `ii`;

DELIMITER $$$
CREATE FUNCTION `udf_users_photos_count`(`username` VARCHAR(30))
RETURNS INT
DETERMINISTIC
BEGIN
		RETURN (SELECT COUNT(up.`photo_id`)
				FROM `users` AS u
				LEFT JOIN `users_photos` AS up
				ON u.`id` = up.`user_id`
				WHERE u.`username` = username
				GROUP BY u.`username`);
END; $$$
DELIMITER ;

SELECT UDF_USERS_PHOTOS_COUNT('efellibrand2e') AS photosCount;