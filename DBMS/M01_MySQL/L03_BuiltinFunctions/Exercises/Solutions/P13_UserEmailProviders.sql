USE `diablo`;

SELECT 
    `user_name`,
    SUBSTRING(`email`,
        LOCATE('@', `email`) + 1) AS `email_provider`
FROM
    `users`
ORDER BY `email_provider` , `user_name`;