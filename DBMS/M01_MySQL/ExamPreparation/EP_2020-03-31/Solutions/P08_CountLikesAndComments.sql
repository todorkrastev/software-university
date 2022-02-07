USE `ii`;

DELIMITER $$$
CREATE FUNCTION `udf_likes_count`(`id` INT)
RETURNS INT
DETERMINISTIC
BEGIN
		RETURN (SELECT COUNT(`photo_id`) 
				FROM `likes` 
                WHERE `photo_id` = id);
END; $$$
DELIMITER ;

DELIMITER $$$
CREATE FUNCTION `udf_comments_count`(`id` INT)
RETURNS INT
DETERMINISTIC
BEGIN
		RETURN (SELECT COUNT(`photo_id`) 
				FROM `comments` 
                WHERE `photo_id` = id);
END; $$$
DELIMITER ;

SELECT 
    `id`,
    (SELECT UDF_LIKES_COUNT(`id`)) AS `likes_count`,
    (SELECT UDF_COMMENTS_COUNT(`id`)) AS `comments_count`
FROM
    `photos`
ORDER BY `likes_count` DESC , `comments_count` DESC , `id`;