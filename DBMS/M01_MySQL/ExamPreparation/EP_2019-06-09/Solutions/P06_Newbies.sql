USE `ruk`;

SELECT 
    `id`,
    CONCAT_WS(' ', `first_name`, `last_name`) AS `full_name`,
    CONCAT('$', `salary`) AS `salary`,
    `started_on`
FROM
    `employees`
WHERE
    `salary` >= 100000
        AND YEAR(`started_on`) > 2017
ORDER BY `salary` DESC , `id`;