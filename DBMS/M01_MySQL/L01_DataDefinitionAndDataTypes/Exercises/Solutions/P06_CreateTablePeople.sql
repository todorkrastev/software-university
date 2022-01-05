CREATE TABLE `people`(
`id` INT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(200) NOT NULL,
`picture` LONGBLOB,
`height` DOUBLE(5,2),
`weight` DOUBLE(5,2),
`gender` CHAR(1) NOT NULL,
`birthdate` DATE NOT NULL,
`biography` LONGTEXT,
PRIMARY KEY (`id`)
);


INSERT INTO `people` (`id`, `name`, `picture`, `height`, `weight`, `gender`, `birthdate`, `biography`) VALUES
(1, 'Todor', NULL, 188, 94, 'm', '1989-10-19', 'click here'),
(2, 'Todor', NULL, 188, 94, 'm', '1989-10-19', 'click here'),
(3, 'Todor', NULL, 188, 94, 'm', '1989-10-19', 'click here'),
(4, 'Todor', NULL, 188, 94, 'm', '1989-10-19', 'click here'),
(5, 'Todor', NULL, 188, 94, 'm', '1989-10-19', 'click here');
