USE `ruk`;

UPDATE `employees_clients` AS ec 
SET 
    ec.`employee_id` = (SELECT 
            ec2.`employee_id`
        FROM
            (SELECT 
                *
            FROM
                `employees_clients`) AS ec2
        GROUP BY ec2.`employee_id`
        ORDER BY COUNT(ec2.`client_id`) ASC , ec2.`employee_id` ASC
        LIMIT 1)
WHERE
    ec.`employee_id` = ec.`client_id`;