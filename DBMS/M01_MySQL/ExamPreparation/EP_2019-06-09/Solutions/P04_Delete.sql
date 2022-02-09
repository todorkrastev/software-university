USE `ruk`;

DELETE e , ec FROM `employees` AS e
        LEFT JOIN
    `employees_clients` AS ec ON e.`id` = ec.`employee_id` 
WHERE
    ec.`client_id` IS NULL;