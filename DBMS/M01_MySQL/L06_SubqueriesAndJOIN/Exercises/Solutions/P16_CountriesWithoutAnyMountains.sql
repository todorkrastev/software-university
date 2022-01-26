USE `geography`;

SELECT 
    COUNT(*) AS `country_count`
FROM
    `countries` AS c
WHERE
    c.`country_code` NOT IN (SELECT 
            `country_code`
        FROM
            `mountains_countries`);
            
-- Second option

SELECT 
    COUNT(*) AS `country_count`
FROM
    `countries` AS `c`
        LEFT JOIN
    `mountains_countries` AS `mc` ON c.`country_code` = mc.`country_code`
WHERE
    mc.`mountain_id` IS NULL;