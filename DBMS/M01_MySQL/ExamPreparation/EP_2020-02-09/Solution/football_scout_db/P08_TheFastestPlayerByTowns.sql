USE `fsd`;

SELECT 
    MAX(sd.`speed`) AS `max_speed`, t.`name` AS `town_name`
FROM
    `towns` AS `t`
        LEFT JOIN
    `stadiums` AS `s` ON t.`id` = s.`town_id`
        LEFT JOIN
    `teams` AS `te` ON s.`id` = te.`stadium_id`
        LEFT JOIN
    `players` AS `p` ON te.`id` = p.`team_id`
        LEFT JOIN
    `skills_data` AS `sd` ON sd.`id` = p.`skills_data_id`
WHERE
    te.`name` != 'Devify'
GROUP BY t.`id`
ORDER BY `max_speed` DESC , `town_name`;