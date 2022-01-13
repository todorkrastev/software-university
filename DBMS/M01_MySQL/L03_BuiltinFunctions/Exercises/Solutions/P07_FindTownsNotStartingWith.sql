USE `soft_uni`;

SELECT 
    `town_id`, `name`
FROM
    `towns`
WHERE
    `name` REGEXP '(?i)(s|^)[^rbd][a-z]+(s|$)'
ORDER BY `name` ASC;