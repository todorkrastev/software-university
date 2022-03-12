Здравейте,

Необходимо е единствено да стартирате програмата и да следвате инструкциите.
За да проверите всички задачи, не е необходимо да спирате програмата.
Преди да стартирате програмата, моля, извършете следната процедура в конзолата на MySQL:

CREATE PROCEDURE total_amount_of_books_by_given_author(first_name VARCHAR(50), last_name VARCHAR(50))
BEGIN
SELECT COUNT(*)
FROM books b
JOIN authors a on a.id = b.author_id
WHERE a.first_name = first_name
AND a.last_name = last_name;
end;

Подготвил съм файл с име: total_amount_of_books_by_given_author.sql. Имате възможност да извършите процедурата директно от файла. Процедурата е свързана с решението на задача 14.

Благодаря за вниманието!

Поздрави,

Тодор


