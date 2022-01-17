USE `gringotts`;

SELECT 
    wd.`deposit_group`, SUM(wd.`deposit_amount`) AS `total_sum`
FROM
    `wizzard_deposits` AS wd
GROUP BY wd.`deposit_group`
ORDER BY `total_sum`;