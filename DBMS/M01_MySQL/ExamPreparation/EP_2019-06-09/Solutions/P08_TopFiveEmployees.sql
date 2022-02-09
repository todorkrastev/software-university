USE `ruk`;

SELECT 
    CONCAT_WS(' ',
            ANY_VALUE(e.`first_name`),
            ANY_VALUE(e.`last_name`)) AS `name`,
    ANY_VALUE(e.`started_on`),
    COUNT(ec.`client_id`) AS `count_of_clients`
FROM
    `employees` AS e
        LEFT JOIN
    `employees_clients` AS ec ON e.`id` = ec.`employee_id`
GROUP BY ec.`employee_id`
ORDER BY count_of_clients DESC , ec.`employee_id`
LIMIT 5;