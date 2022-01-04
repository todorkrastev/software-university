ALTER TABLE `towns` 
CHANGE COLUMN `town_id` `id` INT UNSIGNED NOT NULL AUTO_INCREMENT ;

ALTER TABLE `minions`
ADD COLUMN `town_id` INT,
ADD CONSTRAINT fk_minions_towns
FOREIGN KEY (`town_id`)
REFERENCES `towns`(`id`);