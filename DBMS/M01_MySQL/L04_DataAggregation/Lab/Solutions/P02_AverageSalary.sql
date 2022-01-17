USE `restaurant`;

SELECT 
    e.`department_id`,
    ROUND(AVG(e.`salary`), 2) AS `Average Salary`
FROM
    `employees` AS `e`
GROUP BY `department_id`
ORDER BY `department_id`;