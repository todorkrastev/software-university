DELIMITER $$$
CREATE PROCEDURE `usp_get_towns_starting_with`(`input` VARCHAR(10))
BEGIN
SELECT 
    `name`
FROM
    `towns`
WHERE
    `name` LIKE CONCAT(`input`, '%')
    ORDER BY `name`;
END $$$
DELIMITER ;

CALL `usp_get_towns_starting_with`('b');