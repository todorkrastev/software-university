SELECT 
    COUNT(p.`id`) AS `items_count`,
    c.`name`,
    SUM(p.`quantity_in_stock`) AS `total_quantity`
FROM `products` AS p
JOIN `categories` AS c ON p.`category_id` = c.`id`
WHERE p.`category_id` IN (SELECT  `id` FROM `categories`)
GROUP BY p.`category_id`
ORDER BY items_count DESC , total_quantity
LIMIT 5;