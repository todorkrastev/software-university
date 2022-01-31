USE `soft_uni`;

DELIMITER $$$
CREATE FUNCTION `ufn_calculate_future_value`(`sum` DECIMAL(19,4), `yearly_interest_rate` DOUBLE, `number_of_years` INT)
RETURNS DECIMAL(19,4)
DETERMINISTIC
BEGIN
RETURN `sum` * POW(1 + `yearly_interest_rate`, `number_of_years`);
END; $$$
DELIMITER ;

SELECT `ufn_calculate_future_value`(1000, 0.5, 5); 

DELIMITER $$$
CREATE PROCEDURE `usp_calculate_future_value_for_account`(`acc_id` INT, `rate` DECIMAL(19,4))
BEGIN
SELECT a.`id`, ah.`first_name`, ah.`last_name`, a.`balance`,
`ufn_calculate_future_value`(a.`balance`, rate, 5)
FROM `accounts` AS `a`
JOIN `account_holders` AS `ah`
ON a.`account_holder_id` = ah.`id`
WHERE a.`id` = `acc_id`;
END; $$$
DELIMITER ;

CALL `usp_calculate_future_value_for_account`(1, 0.1);