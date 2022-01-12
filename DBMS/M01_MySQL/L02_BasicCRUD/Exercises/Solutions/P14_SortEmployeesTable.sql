USE `soft_uni`;

CREATE VIEW `v_multiple_criterias_of_sorting` AS
    SELECT 
        *
    FROM
        `employees`
    ORDER BY `salary` DESC , `first_name` ASC , `last_name` DESC , `middle_name` ASC;

SELECT 
    *
FROM
    `v_multiple_criterias_of_sorting`;
    