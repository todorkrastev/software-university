USE `ii`;

SELECT 
    CONCAT(LEFT(`description`, 30), '...') AS `summary`, `date`
FROM
    `photos`
WHERE
    DAY(`date`) = '10'
ORDER BY `date` DESC;