USE `stc`;

DELETE `clients` FROM `clients` AS cl
LEFT JOIN `courses` AS co
ON co.`client_id` = cl.`id`
WHERE CHAR_LENGTH(cl.`full_name`) > 3 AND co.`client_id` IS NULL;