DELIMITER $$$
CREATE FUNCTION `ufn_get_salary_level`(`salary_of_employee` DECIMAL)
RETURNS VARCHAR(10)
DETERMINISTIC
BEGIN
	RETURN (CASE
				WHEN `salary_of_employee` < 30000 THEN 'Low'
				WHEN `salary_of_employee` BETWEEN 30000 AND 50000 THEN 'Average'
				WHEN `salary_of_employee` > 50000 THEN 'High'
			END
	);
END; $$$
DELIMITER ;

SELECT UFN_GET_SALARY_LEVEL(50001.23);