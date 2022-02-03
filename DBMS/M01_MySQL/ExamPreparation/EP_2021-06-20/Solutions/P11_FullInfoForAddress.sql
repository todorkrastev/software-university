USE `stc`;

DELIMITER $$$
CREATE PROCEDURE `udp_courses_by_address`(`address_name` VARCHAR(100))
BEGIN
	SELECT 
    a.`name`,
    cl.`full_name`,
    (CASE
        WHEN co.`bill` <= 20 THEN 'Low'
        WHEN co.`bill` <= 30 THEN 'Medium'
        ELSE 'High'
    END) AS 'level_of_bill',
    ca.`make`,
    ca.`condition`,
    cat.`name` AS cat_name
FROM
    `addresses` AS a
        JOIN
    `courses` AS co ON a.`id` = co.`from_address_id`
        JOIN
    `clients` AS cl ON co.`client_id` = cl.`id`
        JOIN
    `cars` AS ca ON co.`car_id` = ca.`id`
        JOIN
    `categories` AS cat ON ca.`category_id` = cat.`id`
WHERE
    a.`name` = `address_name`
ORDER BY ca.`make` , cl.`full_name`;
END; $$$
DELIMITER ;

CALL udp_courses_by_address('700 Monterey Avenue');
CALL udp_courses_by_address('66 Thompson Drive');