USE `soft_uni`;

CREATE VIEW `v_email` AS
    SELECT 
        CONCAT(`first_name`,
                '.',
                `last_name`,
                '@softuni.bg') AS `full_emai_address`
    FROM
        `employees`;
SELECT 
    *
FROM
    `v_email`;
    
