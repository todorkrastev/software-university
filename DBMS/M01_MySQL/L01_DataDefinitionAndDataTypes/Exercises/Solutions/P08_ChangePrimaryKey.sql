CREATE TABLE `users`(
`id` INT NOT NULL AUTO_INCREMENT,
`username` VARCHAR(30) NOT NULL,
`password` VARCHAR(26) NOT NULL,
`profile_picture` LONGBLOB,
`last_login_time` DATETIME,
`is_deleted` CHAR(5),
PRIMARY KEY (`id`)
);

INSERT INTO `users` (`id`, `username`, `password`, `profile_picture`, `last_login_time`, `is_deleted`) VALUES
(1, 'beinsaduno', '8', NULL, NULL, 'true'),
(2, 'beinsaduno', '8', NULL, NULL, 'true'),
(3, 'beinsaduno', '8', NULL, NULL, 'true'),
(4, 'beinsaduno', '8', NULL, NULL, 'true'),
(5, 'beinsaduno', '8', NULL, NULL, 'true');