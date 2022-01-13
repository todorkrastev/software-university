USE `book_library`;

SELECT 
    `title`
FROM
    `books`
WHERE
    `title` LIKE 'Harry Potter%'
ORDER BY `id` ASC;

-- Second option usign RegEx

SELECT 
    `title`
FROM
    `books`
WHERE
    `title` REGEXP 'Harry Potter';