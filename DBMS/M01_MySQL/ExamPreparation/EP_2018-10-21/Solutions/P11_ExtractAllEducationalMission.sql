USE `cjms`;

SELECT 
    p.`name` AS `planet_name`, sp.`name` AS `spaceport_name`
FROM
    `planets` AS `p`
        JOIN
    `spaceports` AS `sp` ON p.`id` = sp.`planet_id`
        JOIN
    `journeys` AS `j` ON sp.`id` = j.`destination_spaceport_id`
WHERE
    j.`purpose` = 'Educational'
ORDER BY `spaceport_name` DESC;