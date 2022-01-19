USE `camp`;

SELECT 
    `driver_id`,
    `vehicle_type`,
    CONCAT_WS(' ', `first_name`, `last_name`) AS `driver_name`
FROM
    `vehicles` AS v
        JOIN
    `campers` AS c ON v.`driver_id` = c.`id`;