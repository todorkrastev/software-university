USE `soft_uni`;

SELECT 
    COUNT(e.`employee_id`) AS `count`
FROM
    `employees` AS `e`
WHERE
    e.`salary` > (SELECT 
            AVG(`salary`) AS `average_salary`
        FROM
            `employees`);