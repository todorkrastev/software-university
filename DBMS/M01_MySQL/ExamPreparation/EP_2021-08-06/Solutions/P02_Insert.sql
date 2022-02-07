USE `sgd`;

INSERT INTO `games`(`name`, `rating`, `budget`, `team_id`)
SELECT REVERSE(LOWER(SUBSTRING(`name`, 2))), `id`, `leader_id` * 1000, `id`
FROM `teams`
WHERE `id` BETWEEN 1 AND 9;