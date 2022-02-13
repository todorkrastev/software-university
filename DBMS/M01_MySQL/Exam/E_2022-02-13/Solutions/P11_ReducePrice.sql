DELIMITER $$$
CREATE PROCEDURE `udp_reduce_price`(`category_name` VARCHAR(50))
BEGIN
		UPDATE `products` AS p
		JOIN `categories` AS c ON p.`category_id` = c.`id`
		JOIN `reviews` AS r ON p.`review_id` = r.`id`
		SET p.`price` = p.`price` * 0.7
		WHERE p.`category_id` IN (SELECT `id` FROM `categories` WHERE `name` = category_name)
		AND r.`rating` < 4;
END; $$$
DELIMITER ;

CALL `udp_reduce_price` ('Phones and tablets');