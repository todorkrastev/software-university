USE `soft_uni`;

SELECT 
    su.`department_id`, MIN(su.`salary`) AS `minimum_salary`
FROM
    `employees` AS su
WHERE
    `department_id` IN (2 , 5, 7)
        AND `hire_date` > '2000-01-01'
GROUP BY su.`department_id`
ORDER BY su.`department_id`;