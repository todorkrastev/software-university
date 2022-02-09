USE `ruk`;

SELECT 
    b.`name`, COUNT(c.`id`) AS `count_of_cards`
FROM
    `branches` AS b
        LEFT JOIN
    `employees` AS e ON b.`id` = e.`branch_id`
        LEFT JOIN
    `employees_clients` AS ec ON e.`id` = ec.`employee_id`
        LEFT JOIN
    `clients` AS cl ON ec.`client_id` = cl.`id`
        LEFT JOIN
    `bank_accounts` AS ba ON cl.`id` = ba.`client_id`
        LEFT JOIN
    `cards` AS c ON ba.`id` = c.`bank_account_id`
GROUP BY b.`name`
ORDER BY COUNT(c.`id`) DESC , b.`name`;