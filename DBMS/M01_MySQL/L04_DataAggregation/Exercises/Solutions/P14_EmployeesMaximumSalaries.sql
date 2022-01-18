USE `soft_uni`;

SELECT 
    e.`department_id`, MAX(e.`salary`) AS `max_salary`
FROM
    `employees` AS e
GROUP BY `department_id`
HAVING `max_salary` NOT BETWEEN 30000 AND 70000
ORDER BY `department_id`;