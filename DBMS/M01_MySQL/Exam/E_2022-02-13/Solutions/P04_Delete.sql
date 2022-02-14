DELETE c FROM `customers` AS c
        LEFT JOIN
    `orders` AS o ON c.`id` = o.`customer_id`
        LEFT JOIN
    `orders_products` AS op ON o.`id` = op.`order_id`
        LEFT JOIN
    `products` AS p ON op.`product_id` = p.`id` 
WHERE
    op.`product_id` IS NULL;
    
-- Second Option

DELETE FROM `customers` 
WHERE
    `id` NOT IN (SELECT 
        `customer_id`
    FROM
        `orders`);