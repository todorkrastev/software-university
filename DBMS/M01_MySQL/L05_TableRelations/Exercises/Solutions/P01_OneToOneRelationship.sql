CREATE SCHEMA `regional_police_department`;
USE `regional_police_department`;

CREATE TABLE `passports` (
    `passport_id` INT PRIMARY KEY AUTO_INCREMENT,
    `passport_number` VARCHAR(8) NOT NULL UNIQUE
);

CREATE TABLE `people` (
    `person_id` INT PRIMARY KEY AUTO_INCREMENT,
    `first_name` VARCHAR(30) NOT NULL,
    `salary` DECIMAL(9 , 2 ) NOT NULL,
    `passport_id` INT NOT NULL UNIQUE,
    CONSTRAINT fk_people_passports FOREIGN KEY (`passport_id`)
        REFERENCES `passports` (`passport_id`)
);

ALTER TABLE `passports` AUTO_INCREMENT = 101;
INSERT INTO `passports` (`passport_number`) VALUES
('N34FG21B'),
('K65LO4R7'),
('ZE657QP2');

ALTER TABLE `people` AUTO_INCREMENT = 1;
INSERT INTO `people` (`first_name`, `salary`, `passport_id`) VALUES
('Roberto', 43300.00, 102),
('Tom', 56100.00, 103),
('Yana', 60200.00, 101);


SELECT 
    *
FROM
    `people` AS p
        JOIN
    `passports` AS id ON p.`passport_id` = id.`passport_id`;