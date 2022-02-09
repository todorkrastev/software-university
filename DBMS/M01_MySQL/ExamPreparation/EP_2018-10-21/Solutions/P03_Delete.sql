USE `cjms`;

DELETE FROM `colonists` 
WHERE
    `id` NOT IN (SELECT 
        tc.`colonist_id`
    FROM
        `travel_cards` AS `tc`);