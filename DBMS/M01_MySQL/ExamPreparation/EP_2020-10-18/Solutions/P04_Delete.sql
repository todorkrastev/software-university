USE `sss`;

DELETE FROM `employees` 
WHERE
    `manager_id` IS NOT NULL
    AND `salary` >= 6000;