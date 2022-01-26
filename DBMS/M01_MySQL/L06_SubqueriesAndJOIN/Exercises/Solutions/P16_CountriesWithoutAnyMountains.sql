USE `geography`;

SELECT 
    COUNT(*)
FROM
    `countries` AS c
WHERE
    c.`country_code` NOT IN (SELECT 
            `country_code`
        FROM
            `mountains_countries`);