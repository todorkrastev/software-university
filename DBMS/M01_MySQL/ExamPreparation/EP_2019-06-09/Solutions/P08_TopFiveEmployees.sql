USE `ruk`;

SELECT e.`id`,
    CONCAT(e.`first_name`, ' ', e.`last_name`) AS `name`,
    e.`started_on`,
    COUNT(ec.`client_id`) AS `count_of_clients`
FROM
    `employees` AS e
        LEFT JOIN
    `employees_clients` AS ec ON e.`id` = ec.`employee_id`
GROUP BY ec.`employee_id`
ORDER BY COUNT(ec.`client_id`) DESC, e.`id`
LIMIT 5;