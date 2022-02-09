USE `ruk`;

DELIMITER $$$
CREATE FUNCTION `udf_client_cards_count`(`name` VARCHAR(30))
RETURNS INT
DETERMINISTIC
BEGIN
		RETURN (SELECT COUNT(c.`id`)
		FROM `clients` AS cl
		LEFT JOIN `bank_accounts` AS ba
		ON cl.`id` = ba.`client_id`
		LEFT JOIN `cards` AS c
		ON ba.`id` = c.`bank_account_id`
		WHERE cl.`full_name` = `name`
		GROUP BY ba.`client_id`);
END; $$$
DELIMITER ;

SELECT 
    c.`full_name`, `udf_client_cards_count`('Baxy David') AS `cards`
FROM
    `clients` AS c
WHERE
    c.`full_name` = 'Baxy David';