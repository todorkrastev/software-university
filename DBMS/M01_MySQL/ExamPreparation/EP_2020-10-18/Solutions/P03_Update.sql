USE `sss`;

UPDATE `employees` AS e 
SET 
    e.`salary` = e.`salary` - 500,
      e.`manager_id` = 3
WHERE
    YEAR(e.`hire_date`) >= '2003'
        AND e.`store_id` NOT IN (SELECT 
            s.`id`
        FROM
            `stores` AS s
        WHERE
            s.`name` = 'Cardguard'
                OR s.`name` = 'Veribet');