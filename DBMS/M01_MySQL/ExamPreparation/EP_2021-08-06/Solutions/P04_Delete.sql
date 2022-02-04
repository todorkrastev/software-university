USE `sgd`;

DELETE g FROM `games` AS g
        LEFT JOIN
    `games_categories` AS `gc` ON g.`id` = gc.`game_id` 
WHERE
    g.`id` NOT IN (SELECT 
        `game_id`
    FROM
        `games_categories`)
    AND g.`release_date` IS NULL;