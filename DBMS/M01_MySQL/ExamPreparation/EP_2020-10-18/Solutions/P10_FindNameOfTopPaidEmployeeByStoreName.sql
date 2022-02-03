USE `sss`;

DELIMITER $$$
CREATE FUNCTION `udf_top_paid_employee_by_store`(`store_name` VARCHAR(50))
RETURNS TEXT
DETERMINISTIC
BEGIN
	RETURN (SELECT CONCAT_WS(' ', e.`first_name`, CONCAT(e.`middle_name`, '.'), e.`last_name`, 'works in store for', YEAR('2020-10-18') - YEAR(e.`hire_date`), 'years')
			FROM `stores` AS s
			JOIN `employees` AS e
			ON s.`id` = e.`store_id`
			WHERE s.`name` = `store_name`
			ORDER BY e.`salary` DESC
			LIMIT 1);
END; $$$
DELIMITER ;

SELECT UDF_TOP_PAID_EMPLOYEE_BY_STORE('Stronghold') AS 'full_info';
SELECT UDF_TOP_PAID_EMPLOYEE_BY_STORE('Keylex') AS 'full_info';