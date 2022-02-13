SELECT 
    *
FROM
    `reviews`;

SELECT 
    `id`, `content`, `rating`, `picture_url`, `published_at`
FROM
    `reviews`
WHERE
    `content` LIKE 'MY%'
        AND CHAR_LENGTH(`content`) > 61
ORDER BY `rating` DESC;