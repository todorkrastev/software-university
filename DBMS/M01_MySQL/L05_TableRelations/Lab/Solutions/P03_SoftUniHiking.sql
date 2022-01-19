USE `camp`;

SELECT 
    `starting_point`,
    `end_point`,
    `leader_id`,
    CONCAT_WS(' ', `first_name`, `last_name`) AS `leader_name`
FROM
    `routes` AS r
        JOIN
    `campers` AS c ON r.`leader_id` = c.`id`;