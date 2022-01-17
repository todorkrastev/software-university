USE `restaurant`;

SELECT 
    e.`department_id`, COUNT(e.`id`) AS `Number of employess`
FROM
    `employees` AS `e`
GROUP BY `department_id`
ORDER BY `department_id` ASC , `Number of employess` ASC;