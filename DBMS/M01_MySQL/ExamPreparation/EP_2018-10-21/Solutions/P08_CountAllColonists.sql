USE `cjms`;

SELECT 
    COUNT(c.`id`) AS `count`
FROM
    `colonists` AS `c`
        JOIN
    `travel_cards` AS `tc` ON c.`id` = tc.`colonist_id`
        JOIN
    `journeys` AS `j` ON tc.`journey_id` = j.`id`
WHERE
    j.`purpose` = 'Technical';