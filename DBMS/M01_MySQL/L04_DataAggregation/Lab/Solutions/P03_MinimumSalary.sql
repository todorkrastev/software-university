USE `restaurant`;

SELECT 
    e.`department_id`, ROUND(MIN(e.`salary`), 2) AS `Min Salary`
FROM
    `employees` AS `e`
GROUP BY `department_id`
HAVING `Min Salary` > 800
ORDER BY `department_id`;