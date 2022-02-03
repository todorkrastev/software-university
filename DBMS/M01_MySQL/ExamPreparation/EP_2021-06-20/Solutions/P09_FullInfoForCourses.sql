USE `stc`;

SELECT 
    a.`name`,
    IF(HOUR(co.`start`) BETWEEN 6 AND 20,
        'Day',
        'Night') AS `day_time`,
    co.`bill`,
    cl.`full_name`,
    ca.`make`,
    ca.`model`,
    cat.`name` AS `category_name`
FROM
    `addresses` AS a
        JOIN
    `courses` AS co ON a.`id` = co.`from_address_id`
        JOIN
    `clients` AS cl ON co.`client_id` = cl.`id`
        JOIN
    `cars` AS ca ON co.`car_id` = ca.`id`
        JOIN
    `categories` AS cat ON ca.`category_id` = cat.`id`
ORDER BY co.`id`;