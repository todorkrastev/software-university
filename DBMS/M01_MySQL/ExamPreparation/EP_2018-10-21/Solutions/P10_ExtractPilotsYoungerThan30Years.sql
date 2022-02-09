USE `cjms`;

SELECT 
    s.`name`, s.`manufacturer`
FROM
    `colonists` AS `c`
        JOIN
    `travel_cards` AS `tc` ON tc.`colonist_id` = c.`id`
        JOIN
    `journeys` AS `j` ON tc.`journey_id` = j.`id`
        JOIN
    `spaceships` AS `s` ON j.`spaceship_id` = s.`id`
WHERE
    YEAR(c.`birth_date`) > YEAR(DATE_SUB('2019-01-01', INTERVAL 30 YEAR))
        AND tc.`job_during_journey` = 'Pilot'
ORDER BY s.name;