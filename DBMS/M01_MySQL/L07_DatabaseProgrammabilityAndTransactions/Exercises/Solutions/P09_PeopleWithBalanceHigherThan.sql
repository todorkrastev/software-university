USE `soft_uni`;

DELIMITER $$$
CREATE PROCEDURE `usp_get_holders_with_balance_higher_than`(`number` DECIMAL(19, 4))
BEGIN
SELECT 
    ah.`first_name`, ah.`last_name`
FROM
    `account_holders` AS `ah`
        JOIN
    `accounts` AS `a` ON a.`account_holder_id` = ah.`id`

GROUP BY a.`account_holder_id`
HAVING SUM(a.`balance`) > `number`
ORDER BY a.`account_holder_id`;
END; $$$
DELIMITER ;

CALL `usp_get_holders_with_balance_higher_than`(7000);

SELECT 
    ah.`first_name`, ah.`last_name`, a.`balance`
FROM
    `account_holders` AS `ah`
        JOIN
    `accounts` AS `a` ON a.`account_holder_id` = ah.`id`
GROUP BY a.`account_holder_id`
HAVING SUM(a.`balance`) > 7000
ORDER BY a.`account_holder_id`;