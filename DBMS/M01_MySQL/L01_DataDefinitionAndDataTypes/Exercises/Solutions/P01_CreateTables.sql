CREATE TABLE `minions` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `age` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`));
  
  CREATE TABLE `towns` (
  `town_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`town_id`));