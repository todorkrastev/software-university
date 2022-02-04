USE `sgd`;

INSERT INTO `games`(`name`, `rating`, `budget`, `team_id`) 
SELECT SUBSTRING(REVERSE(LOWER(t.`name`)), 2) AS `reversed_name`, g.`team_id` AS `rating`, t.`leader_id` * 1000 AS `budget`, g.`team_id`
FROM `teams` AS t
JOIN `games` AS g
ON t.`id` = g.`team_id`
WHERE t.`id` BETWEEN 1 AND 9
GROUP BY t.`id`;