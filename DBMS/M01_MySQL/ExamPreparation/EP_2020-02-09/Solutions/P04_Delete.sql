USE `fsd`;

DELETE FROM `players` 
WHERE
    `age` >= 45;
    
-- Second option

DELETE pc , p FROM `players` AS p
        LEFT JOIN
    `players_coaches` AS pc ON p.`id` = pc.`player_id` 
WHERE
    `team_id` IS NOT NULL;