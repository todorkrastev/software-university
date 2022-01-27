DROP PROCEDURE IF EXISTS `usp_raise_salaries`;
DELIMITER $$$
CREATE PROCEDURE `usp_raise_salaries`(`department_name` VARCHAR(50))
BEGIN
UPDATE `employees` AS `e`
        JOIN
    `departments` AS `d` USING (`department_id`) 
SET 
    e.`salary` = e.`salary` * 1.05
WHERE
    d.`name` = `department_name`;
END $$$
DELIMITER ;

CALL `usp_raise_salaries(15)`;