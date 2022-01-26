USE `geography`;

SELECT 
    c.`country_code`,
    m.`mountain_range`,
    p.`peak_name`,
    p.`elevation`
FROM
    `countries` AS `c`
        JOIN
    `mountains_countries` AS `mc` ON c.`country_code` = mc.`country_code`
        JOIN
    `mountains` AS `m` ON mc.`mountain_id` = m.`id`
        JOIN
    `peaks` AS `p` ON m.`id` = p.`mountain_id`
WHERE
    c.`country_code` = 'BG'
        AND p.`elevation` > 2835
ORDER BY `elevation` DESC;