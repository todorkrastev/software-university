USE `sgd`;

SELECT 
    `first_name`,
    `last_name`,
    `age`,
    `salary`,
    `happiness_level`
FROM
    `employees`
ORDER BY `salary` , `id`;