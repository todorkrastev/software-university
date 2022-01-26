USE `geography`;

SELECT 
    c.`country_code`, COUNT(m.`id`) AS `mountain_range`
FROM
    `countries` AS `c`
        JOIN
    `mountains_countries` AS `mc` ON c.`country_code` = mc.`country_code`
        JOIN
    `mountains` AS `m` ON mc.`mountain_id` = m.`id`
WHERE
    c.`country_code` IN ('BG' , 'RU', 'US')
GROUP BY mc.`country_code`
ORDER BY `mountain_range` DESC;

-- Second option

SELECT 
    mc.`country_code`, COUNT(m.`id`) AS `mountain_range`
FROM
    `mountains` AS `m`
        JOIN
    `mountains_countries` AS `mc` ON mc.`mountain_id` = m.`id`
WHERE
    mc.`country_code` IN ('BG' , 'RU', 'US')
GROUP BY mc.`country_code`
ORDER BY `mountain_range` DESC;