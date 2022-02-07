USE `ii`;

DELIMITER $$$
CREATE PROCEDURE `udp_modify_user`(`address` VARCHAR(30), `town` VARCHAR(30))
BEGIN
		UPDATE `addresses` AS a
		LEFT JOIN `users` AS u
		ON a.`user_id` = u.`id`
		SET u.`age` = u.`age` + 10
		WHERE a.`address` = address
		AND a.`town` = town;
END; $$$
DELIMITER ;

CALL udp_modify_user ('97 Valley Edge Parkway', 'Divinópolis');
SELECT u.username, u.email,u.gender,u.age,u.job_title FROM users AS u
WHERE u.username = 'eblagden21';