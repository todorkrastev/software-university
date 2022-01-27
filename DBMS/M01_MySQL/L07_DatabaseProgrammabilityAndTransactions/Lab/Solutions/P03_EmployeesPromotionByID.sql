DROP procedure IF EXISTS `usp_raise_salary_by_id`;
DELIMITER $$$
CREATE PROCEDURE usp_raise_salary_by_id(emp_id INT)
BEGIN 
	START TRANSACTION;
    IF((SELECT COUNT(*) FROM `employees` WHERE `employee_id` = `emp_id`) <> 1) 
    THEN ROLLBACK;
    ELSE
		UPDATE `employees`
		SET `salary` = `salary` * 1.05
		WHERE `employee_id` = `emp_id`;
        COMMIT;
	END IF;
END $$$
DELIMITER ;

CALL `usp_raise_salary_by_id`(268);
SELECT 
    SUM(`salary`)
FROM
    `employees`;