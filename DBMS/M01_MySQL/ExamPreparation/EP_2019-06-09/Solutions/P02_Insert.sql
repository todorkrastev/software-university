USE `ruk`;

INSERT INTO `cards`(`card_number`, `card_status`, `bank_account_id`)
SELECT REVERSE(`full_name`),
(SELECT `card_status` FROM `cards` WHERE `id` = 1), 
`id`
FROM `clients`
WHERE `id` BETWEEN 191 AND 200;