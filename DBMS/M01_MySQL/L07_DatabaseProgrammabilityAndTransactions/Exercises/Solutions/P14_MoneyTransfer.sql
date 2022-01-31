USE `soft_uni`;

DELIMITER $$$
CREATE PROCEDURE `usp_transfer_money`(`from_account_id` INT, `to_account_id` INT, `amount` DECIMAL(19,4))
BEGIN
	IF (amount > 0)
    AND
    (SELECT a.`id` FROM `accounts` AS `a` WHERE a.`id` = `from_account_id`) IS NOT NULL
    AND 
    (SELECT a.`id` FROM `accounts` AS `a` WHERE a.`id` = `to_account_id`) IS NOT NULL
    THEN
    START TRANSACTION;
		
        UPDATE `accounts` AS `a`
        SET `balance` = `balance` - `amount`
        WHERE a.`id` = `from_account_id`;
        
        UPDATE `accounts` AS `a`
        SET `balance` = `balance` + `amount`
        WHERE a.`id` = `to_account_id`;
        
        IF (SELECT `balance` FROM `accounts` AS `a` WHERE a.`id` = `from_account_id`) < 0
        THEN 
			ROLLBACK;
		ELSE
			COMMIT;
		END IF;
	
    END IF;
END; $$$
DELIMITER ;

CALL `usp_transfer_money`(1, 2, 10);