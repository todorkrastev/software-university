USE `restaurant`;

SELECT 
    p.`category_id`,
    ROUND(AVG(p.`price`), 2) AS `Average Price`,
    ROUND(MIN(p.`price`), 2) AS `Cheapest Product`,
    ROUND(MAX(p.`price`), 2) AS `Most Expensive Product`
FROM
    `products` AS p
GROUP BY `category_id`;