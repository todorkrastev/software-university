USE `sss`;

DELIMITER $$$
CREATE PROCEDURE `udp_update_product_price`(`address_name` VARCHAR(50))
BEGIN
	UPDATE `products` AS p
	JOIN `products_stores` AS ps
	ON p.`id` = ps.`product_id`
	JOIN `stores` AS s
	ON ps.`store_id` = s.`id`
	JOIN `addresses` AS a
	ON s.`address_id` = a.`id`
	SET p.`price` = p.`price` + IF(LEFT(address_name, 1) = 0, 100, 200)
	WHERE a.`name` = address_name;
END; $$$
DELIMITER ;

CALL `udp_update_product_price`('07 Armistice Parkway');
SELECT 
    `name`, `price`
FROM
    `products`
WHERE
    `id` = 15;

CALL `udp_update_product_price`('1 Cody Pass');
SELECT 
    `name`, `price`
FROM
    `products`
WHERE
    `id` = 17;


-- Second option

DELIMITER $$$
CREATE PROCEDURE `udp_update_product_price`(`address_name` VARCHAR(50))
BEGIN
DECLARE `increase_level` INT;
	IF `address_name` LIKE '0%' THEN SET `increase_level` = 100;
	ELSE SET `increase_level` = 200;
    END IF;
    
UPDATE `products` AS p
SET p.`price` = p.`price` + `increase_level`
WHERE p.`id` IN (
				SELECT ps.`product_id` FROM `addresses` AS a
                JOIN `stores` AS s 
                ON a.`id` = s.`address_id`
                JOIN `products_stores` AS ps
                ON ps.`store_id` = s.`id`
                WHERE a.`name` = address_name
				);
END; $$$
DELIMITER ;