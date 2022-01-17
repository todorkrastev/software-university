USE `gringotts`;

SELECT 
    (CASE
        WHEN wd.`age` BETWEEN 0 AND 10 THEN '[0-10]'
        WHEN wd.`age` BETWEEN 11 AND 20 THEN '[11-20]'
        WHEN wd.`age` BETWEEN 21 AND 30 THEN '[21-30]'
        WHEN wd.`age` BETWEEN 31 AND 40 THEN '[31-40]'
        WHEN wd.`age` BETWEEN 41 AND 50 THEN '[41-50]'
        WHEN wd.`age` BETWEEN 51 AND 60 THEN '[51-60]'
        ELSE '[61+]'
    END) AS `age_group`,
    COUNT(*) AS `wizard_count`
FROM
    `wizzard_deposits` AS wd
GROUP BY `age_group`
ORDER BY `age_group`;