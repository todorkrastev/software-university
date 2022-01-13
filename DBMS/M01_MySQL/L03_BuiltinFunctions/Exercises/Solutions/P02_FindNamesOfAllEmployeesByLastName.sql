USE `soft_uni`;

SELECT 
    `first_name`, `last_name`
FROM
    `employees`
WHERE
    `last_name` REGEXP 'ei'
ORDER BY `employee_id` ASC;