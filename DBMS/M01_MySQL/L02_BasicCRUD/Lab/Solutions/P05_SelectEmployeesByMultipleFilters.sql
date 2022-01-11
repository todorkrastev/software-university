USE `hotel`;

CREATE VIEW `filtered_empoyees` AS
SELECT * FROM `employees`
WHERE `department_id` = 4 AND `salary` >= 1000
ORDER BY `id`;

SELECT * FROM `filtered_empoyees`;



