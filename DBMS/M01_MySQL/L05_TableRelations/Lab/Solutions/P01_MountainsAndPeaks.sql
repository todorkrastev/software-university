USE `camp`;

CREATE TABLE `mountains` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL
);

CREATE TABLE `peaks` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
`mountain_id` INT,
CONSTRAINT fk_peaks_montains
FOREIGN KEY (`mountain_id`)
REFERENCES `mountains`(`id`)
);