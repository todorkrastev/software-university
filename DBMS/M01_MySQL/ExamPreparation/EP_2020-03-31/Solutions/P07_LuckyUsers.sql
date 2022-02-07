USE `ii`;

SELECT 
    CONCAT_WS(' ', u.`id`, u.`username`) AS `id_username`,
    u.`email`
FROM
    `users` AS u
        JOIN
    `users_photos` AS up ON u.`id` = up.`user_id`
WHERE
    u.`id` = up.`photo_id`
ORDER BY u.`id`;