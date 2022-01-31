USE `soft_uni`;

DELIMITER $$$
CREATE FUNCTION `ufn_is_word_comprised`(`set_of_letters` VARCHAR(50), `word` VARCHAR(50))
RETURNS BIT
DETERMINISTIC
BEGIN
RETURN (SELECT `word` REGEXP(CONCAT('(?i)^[', `set_of_letters`, ']+$')));
END; $$$
DELIMITER ;

SELECT UFN_IS_WORD_COMPRISED('oistmiahf', 'b');
-- returns 0
SELECT UFN_IS_WORD_COMPRISED('oistmiahf', 'SOfiA');
-- returns 1