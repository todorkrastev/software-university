USE `sss`;

SELECT 
    CONCAT_WS(' ', e.`first_name`, `last_name`) AS `Full_name`,
    s.`name` AS `Store_name`,
    a.`name` AS `address`,
    e.`salary`
FROM
    `employees` AS e
        JOIN
    `stores` AS s ON e.`store_id` = s.`id`
        JOIN
    `addresses` AS a ON s.`address_id` = a.`id`
WHERE
    e.`salary` < 4000
        AND a.`name` LIKE '%5%'
        AND CHAR_LENGTH(s.`name`) > 8
        AND e.`last_name` LIKE '%n';