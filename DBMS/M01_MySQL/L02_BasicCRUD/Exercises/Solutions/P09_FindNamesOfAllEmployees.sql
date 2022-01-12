USE `soft_uni`;

CREATE VIEW `v_full_name` AS
    SELECT 
        CONCAT_WS(' ',
                `first_name`,
                `middle_name`,
                `last_name`) AS `Full Name`
    FROM
        `employees`
    WHERE
        `salary` IN(25000,14000,12500,23600);
SELECT 
    *
FROM
    `v_full_name`;