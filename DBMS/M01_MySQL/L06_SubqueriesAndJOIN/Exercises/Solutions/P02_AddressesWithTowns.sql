USE `soft_uni`;

SELECT 
    e.`first_name`, e.`last_name`, t.`name`, a.`address_text`
FROM
    `employees` AS e
        JOIN
    `addresses` AS a ON e.`address_id` = a.`address_id`
        JOIN
    `towns` AS t ON a.`town_id` = t.`town_id`
ORDER BY `first_name` , `last_name`
LIMIT 5;