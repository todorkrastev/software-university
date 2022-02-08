USE `ii`;

DELETE FROM `addresses` 
WHERE
    `id` % 3 = 0;