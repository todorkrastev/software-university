USE `stc`;

SELECT 
    cl.`full_name`,
    COUNT(c.`id`) AS `count_of_cars`,
    SUM(c.`bill`) AS `total_sum`
FROM
    `clients` AS cl
        JOIN
    `courses` AS c ON cl.`id` = c.`client_id`
WHERE
    cl.`full_name` LIKE '_a%'
GROUP BY cl.`id`
HAVING `count_of_cars` > 1
ORDER BY cl.`full_name`;