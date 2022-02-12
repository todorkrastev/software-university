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

-- Second option

SELECT 
    p.`id` AS `photo_id`,
    COUNT(DISTINCT l.`id`) AS `likes_count`,
    COUNT(DISTINCT c.`id`) AS `comments_count`
FROM
    `photos` AS p
        LEFT JOIN
    `likes` AS l ON p.`id` = l.`photo_id`
        LEFT JOIN
    `comments` AS c ON c.`photo_id` = p.`id`
GROUP BY photo_id
ORDER BY likes_count DESC , comments_count DESC , photo_id;