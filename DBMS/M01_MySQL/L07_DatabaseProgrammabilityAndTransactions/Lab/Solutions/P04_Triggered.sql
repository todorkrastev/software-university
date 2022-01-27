DROP TABLE IF EXISTS `deleted_employees`;
CREATE TABLE `deleted_employees` (
    `employee_id` INT PRIMARY KEY,
    `first_name` VARCHAR(50) NOT NULL,
    `last_name` VARCHAR(50) NOT NULL,
    `middle_name` VARCHAR(50) DEFAULT NULL,
    `job_title` VARCHAR(50) NOT NULL,
    `department_id` INT(10) DEFAULT NULL,
    `salary` DECIMAL(19 , 4 ) NOT NULL
);

DROP TRIGGER IF EXISTS tr_deleted_employees;
DELIMITER $$$
CREATE TRIGGER `tr_deleted_employees`
AFTER DELETE
ON `employees`
FOR EACH ROW
BEGIN 
	INSERT INTO `deleted_employees`(`employee_id`, `first_name`, `last_name`, `middle_name`, `job_title`, 
		`department_id`,`salary`)
	VALUES (OLD.`employee_id`, OLD.`first_name`, OLD.`last_name`, OLD.`middle_name`, OLD.`job_title`,
		OLD.`department_id`, OLD.`salary`);
END $$$
DELIMITER ;

DELETE FROM `soft_uni`.`employees` 
WHERE
    employee_id = 3;