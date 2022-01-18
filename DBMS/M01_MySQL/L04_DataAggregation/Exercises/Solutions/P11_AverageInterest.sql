USE `gringotts`;

SELECT 
    wd.`deposit_group`,
    wd.`is_deposit_expired`,
    AVG(wd.`deposit_interest`) AS `average_interest`
FROM
    `wizzard_deposits` AS wd
WHERE
    `deposit_start_date` > '1985-01-01'
GROUP BY wd.`deposit_group` , wd.`is_deposit_expired`
ORDER BY wd.`deposit_group` DESC , wd.`is_deposit_expired`;