DROP FUNCTION IF EXISTS `ufn_count_employees_by_town`;
DELIMITER $$$
CREATE FUNCTION `ufn_count_employees_by_town`(`town_name` VARCHAR(45))
RETURNS INT
DETERMINISTIC
BEGIN
DECLARE `employees_counter` INT;
SET `employees_counter` := (SELECT 
    COUNT(*)
FROM
    `employees` AS `e`
        JOIN
    `addresses` AS `a` ON e.`address_id` = a.`address_id`
        JOIN
    `towns` AS `t` ON t.`town_id` = a.`town_id`
WHERE
    t.`name` = `town_name`);
RETURN `employees_counter`;
END $$$
DELIMITER ;

SELECT `ufn_count_employees_by_town`('Sofia');

SELECT 
    `employee_id`, `first_name`, `last_name`, t.`name`
FROM
    `employees`
        NATURAL JOIN
    `addresses`
        NATURAL JOIN
    `towns` AS `t`
WHERE
    t.`name` = 'Carnation';