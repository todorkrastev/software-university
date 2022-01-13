USE `book_library`;

SELECT 
    CONCAT_WS(' ', `first_name`, `last_name`) AS `Full Name`,
    TIMESTAMPDIFF(DAY, `born`, `died`) AS `DAYS LIVED`
FROM
    `authors`;