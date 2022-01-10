CREATE SCHEMA `movies` DEFAULT CHARACTER SET utf8mb4;
USE `movies`;

CREATE TABLE `directors`(
`id` INT NOT NULL AUTO_INCREMENT,
`director_name` VARCHAR(50) NOT NULL,
`notes` LONGTEXT,
PRIMARY KEY (`id`)
);

INSERT INTO `directors` (`id`, `director_name`, `notes`) VALUES
(1, 'beinsaduno', 'some notes'),
(2, 'beinsaduno', 'some notes'),
(3, 'beinsaduno', 'some notes'),
(4, 'beinsaduno', 'some notes'),
(5, 'beinsaduno', 'some notes');

CREATE TABLE `genres`(
`id` INT NOT NULL AUTO_INCREMENT,
`genre_name` VARCHAR(50) NOT NULL,
`notes` LONGTEXT,
PRIMARY KEY (`id`)
);

INSERT INTO `genres` (`id`, `genre_name`, `notes`) VALUES
(1, 'sci-fi', 'some notes'),
(2, 'sci-fi', 'some notes'),
(3, 'sci-fi', 'some notes'),
(4, 'sci-fi', 'some notes'),
(5, 'sci-fi', 'some notes');

CREATE TABLE `categories`(
`id` INT NOT NULL AUTO_INCREMENT,
`category_name` VARCHAR(50) NOT NULL,
`notes` LONGTEXT,
PRIMARY KEY (`id`)
);

INSERT INTO `categories` (`id`, `category_name`, `notes`) VALUES
(1, 'best picture', 'some notes'),
(2, 'best picture', 'some notes'),
(3, 'best picture', 'some notes'),
(4, 'best picture', 'some notes'),
(5, 'best picture', 'some notes');

CREATE TABLE `movies`(
`id` INT NOT NULL AUTO_INCREMENT,
`title` VARCHAR(50) NOT NULL,
`director_id` VARCHAR(50),
`copyright_year` VARCHAR(50),
`length` DECIMAL(2, 2),
`genre_id` INT,
`category_id` INT,
`rating` DECIMAL(2, 2),
`notes` LONGTEXT,
PRIMARY KEY (`id`)
);

INSERT INTO `movies` (`id`, `title`) VALUES
(1, 'With Children at the Seaside'),
(2, 'With Children at the Seaside'),
(3, 'With Children at the Seaside'),
(4, 'With Children at the Seaside'),
(5, 'With Children at the Seaside');
