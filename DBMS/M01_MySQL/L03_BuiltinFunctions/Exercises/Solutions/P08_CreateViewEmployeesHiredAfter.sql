USE `soft_uni`;

CREATE VIEW `v_employees_hired_after_2000` AS
    SELECT 
        `first_name`, `last_name`
    FROM
        `employees`
    WHERE
        EXTRACT(YEAR FROM `hire_date`) > 2000;

SELECT 
    *
FROM
    `v_employees_hired_after_2000`;