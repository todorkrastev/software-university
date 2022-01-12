USE `soft_uni`;

SELECT 
    `first_name`, `last_name`
FROM
    `employees`
WHERE
    NOT `department_id` = 4;
    