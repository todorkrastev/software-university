USE `sss`;

SELECT 
    e.`first_name`,
    e.`middle_name`,
    e.`last_name`,
    e.`salary`,
    e.`hire_date`
FROM
    `employees` AS e
ORDER BY e.`hire_date` DESC;