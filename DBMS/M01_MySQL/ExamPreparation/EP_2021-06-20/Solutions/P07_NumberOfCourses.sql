USE `stc`;

SELECT 
    c.`id` AS `car_id`,
    c.`make`,
    c.`mileage`,
    COUNT(co.`id`) AS `count_of_courses`,
    ROUND(AVG(co.`bill`), 2)
FROM
    `courses` AS co
        RIGHT JOIN
    `cars` AS c ON c.`id` = co.`car_id`
GROUP BY c.`id`
HAVING `count_of_courses` != 2
ORDER BY `count_of_courses` DESC , c.`id`;