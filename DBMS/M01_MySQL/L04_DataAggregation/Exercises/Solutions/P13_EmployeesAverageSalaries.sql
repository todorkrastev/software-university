USE `soft_uni`;

DROP TABLE IF EXISTS `t_high_paid_employees_over_30000`;
CREATE TABLE `t_high_paid_employees_over_30000` AS SELECT * FROM
    `employees`
WHERE
    `salary` > 30000 AND `manager_id` != 42;

UPDATE `t_high_paid_employees_over_30000` 
SET 
    `salary` = `salary` + 5000
WHERE
    `department_id` = 1;

SELECT 
    t.`department_id`, AVG(t.`salary`) AS `avg_salary`
FROM
    `t_high_paid_employees_over_30000` AS t
GROUP BY t.`department_id`
ORDER BY t.`department_id`;