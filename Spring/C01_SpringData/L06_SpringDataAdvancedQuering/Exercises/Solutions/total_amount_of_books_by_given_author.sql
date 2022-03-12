CREATE PROCEDURE total_amount_of_books_by_given_author(first_name VARCHAR(50), last_name VARCHAR(50))
BEGIN
    SELECT COUNT(*)
    FROM books b
             JOIN authors a on a.id = b.author_id
    WHERE a.first_name = first_name
      AND a.last_name = last_name;
end;