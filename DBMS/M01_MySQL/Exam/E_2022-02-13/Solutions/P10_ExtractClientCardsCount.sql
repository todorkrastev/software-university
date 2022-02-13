DELIMITER $$$
CREATE FUNCTION `udf_customer_products_count`(`name` VARCHAR(30))
RETURNS INT
DETERMINISTIC
BEGIN
	RETURN (SELECT COUNT(p.`id`)
	FROM `customers` AS c
	LEFT JOIN `orders` AS o
	ON c.`id` = o.`customer_id`
	LEFT JOIN `orders_products` AS op
	ON o.`id` = op.`order_id`
	LEFT JOIN `products` AS p
	ON op.`product_id` = p.`id`
	WHERE c.`first_name` = `name`
	GROUP BY c.`id`);
END; $$$
DELIMITER ;

SELECT c.first_name,c.last_name, udf_customer_products_count('Shirley') as `total_products` FROM customers c
WHERE c.first_name = 'Shirley';
SELECT c.first_name,c.last_name, udf_customer_products_count('Shirley') as `total_products` FROM customers c
WHERE c.first_name = 'Jose';