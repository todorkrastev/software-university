USE `cjms`;

SELECT 
    pl.`planet_name`,
    COUNT(pl.`planet_name`) AS `journeys_count`
FROM
    (SELECT 
        p.`name` AS `planet_name`
    FROM
        `planets` AS `p`
    JOIN `spaceports` AS `sp` ON p.`id` = sp.`planet_id`
    JOIN `journeys` AS `j` ON sp.`id` = j.`destination_spaceport_id`) AS `pl`
GROUP BY pl.`planet_name`
ORDER BY journeys_count DESC , pl.`planet_name`;