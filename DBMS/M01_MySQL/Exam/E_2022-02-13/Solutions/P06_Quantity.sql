SELECT 
    p.`id`, b.`id` AS brand_id, p.`name`, p.`quantity_in_stock`
FROM
    `products` AS p
        JOIN
    `brands` AS b ON p.`brand_id` = b.`id`
WHERE
    p.`price` > 1000
        AND p.`quantity_in_stock` < 30
ORDER BY p.`quantity_in_stock` , p.`id`;