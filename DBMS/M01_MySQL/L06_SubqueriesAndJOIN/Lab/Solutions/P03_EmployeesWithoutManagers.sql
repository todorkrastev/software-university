USE `soft_uni`;

SELECT e.`employee_id`, e.`first_name`, e.`last_name`, e.`department_id`, e.`salary`
FROM `employees` AS `e`
WHERE e.`manager_id` IS NULL;