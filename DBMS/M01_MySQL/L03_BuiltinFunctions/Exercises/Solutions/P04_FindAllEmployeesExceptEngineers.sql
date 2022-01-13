USE `soft_uni`;

SELECT 
    `first_name`, `last_name`
FROM
    `employees`
WHERE
    `job_title` RLIKE '^(?!.*engineer)'
ORDER BY `employee_id` ASC;
