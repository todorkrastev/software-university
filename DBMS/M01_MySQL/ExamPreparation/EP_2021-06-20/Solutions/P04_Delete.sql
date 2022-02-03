USE `stc`;

DELETE cl , co FROM `clients` AS cl
        LEFT JOIN
    `courses` AS co ON co.`client_id` = cl.`id` 
WHERE
    CHAR_LENGTH(cl.`full_name`) > 3
    AND co.`client_id` IS NULL;

-- or

DELETE FROM `clients` 
WHERE
    `id` NOT IN (SELECT 
        `client_id`
    FROM
        `courses`)
    AND CHAR_LENGTH(`full_name`) > 3;