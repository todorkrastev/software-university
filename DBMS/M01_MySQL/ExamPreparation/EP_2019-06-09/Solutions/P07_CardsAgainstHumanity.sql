USE `ruk`;

SELECT 
    c.`id`,
    CONCAT_WS(' : ', c.`card_number`, cl.`full_name`) AS `card_token`
FROM
    `cards` AS c
        JOIN
    `bank_accounts` AS bc ON c.`bank_account_id` = bc.`id`
        JOIN
    `clients` AS cl ON bc.`client_id` = cl.`id`
ORDER BY c.`id` DESC;