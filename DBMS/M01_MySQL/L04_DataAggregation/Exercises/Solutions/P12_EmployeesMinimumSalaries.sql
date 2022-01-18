USE `soft_uni`;

SELECT 
    e.`department_id`, MIN(e.`salary`) AS `minimum_salary`
FROM
    `employees` AS e
WHERE
    `department_id` IN (2 , 5, 7)
        AND `hire_date` > '2000-01-01'
GROUP BY e.`department_id`
ORDER BY e.`department_id`;