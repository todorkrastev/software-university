USE `soft_uni`;

SELECT 
    e.`employee_id`, e.`first_name`
FROM
    `employees` AS `e`
        LEFT JOIN
    `employees_projects` AS `ep` ON e.`employee_id` = ep.`employee_id`
WHERE
    ep.`project_id` IS NULL
ORDER BY e.`employee_id` DESC
LIMIT 3;

-- second option

SELECT 
    e.`employee_id`, e.`first_name`
FROM
    `employees` AS e
WHERE
    e.`employee_id` NOT IN (SELECT 
            `employee_id`
        FROM
            `employees_projects`)
ORDER BY e.`employee_id` DESC
LIMIT 3;