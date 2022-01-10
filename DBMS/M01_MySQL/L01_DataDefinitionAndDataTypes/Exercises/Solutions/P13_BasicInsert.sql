CREATE SCHEMA `soft_uni` DEFAULT CHARACTER SET utf8mb4;
USE `soft_uni`;

CREATE TABLE `towns`(
`id` INT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL,
PRIMARY KEY (`id`)
);

INSERT INTO `towns`(`name`) VALUES
('Sofia'),
('Plovdiv'),
('Varna'),
('Burgas');

CREATE TABLE `addresses`(
`id` INT NOT NULL AUTO_INCREMENT,
`address_text` VARCHAR(100) NOT NULL,
`town_id` INT,
PRIMARY KEY (`id`)
);

CREATE TABLE `departments`(
`id` INT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL,
PRIMARY KEY (`id`)
);

INSERT INTO `departments`(`name`) VALUES
('Engineering'),
('Sales'),
('Marketing'),
('Software Development'),
('Quality Assurance');


CREATE TABLE `employees`(
`id` INT NOT NULL AUTO_INCREMENT,
`first_name` VARCHAR(50) NOT NULL,
`middle_name` VARCHAR(50) NOT NULL,
`last_name` VARCHAR(50) NOT NULL,
`job_title` VARCHAR(30) NOT NULL,
`department_id` INT NOT NULL,
`hire_date` DATE NOT NULL,
`salary` DECIMAL(10.2) NOT NULL,
`address_id` INT,
CONSTRAINT fk_employees_departments
FOREIGN KEY `employees`(`department_id`)
REFERENCES `departments`(`id`),
CONSTRAINT fk_employees_addresses
FOREIGN KEY `employees`(`address_id`)
REFERENCES `addresses`(`id`),
PRIMARY KEY (`id`)
);

INSERT INTO `employees` (`first_name`, `middle_name`, `last_name`, `job_title`, `department_id`, `hire_date`,`salary`) VALUES
('Ivan', 'Ivanov', 'Ivanov', '.NET Developer', 4, '2013-02-01', 3500.00),
('Petar', 'Petrov', 'Petrov', 'Senior Engineer', 1, '2004-03-02', 4000.00),
('Maria', 'Petrova', 'Ivanova', 'Intern', 5, '2016-08-28', 525.25),
('Georgi', 'Terziev', 'Ivanov', 'CEO', 2, '2007-12-09', 3000.00),
('Peter', 'Pan', 'Pan', 'Intern', 3, '2016-08-28', 599.88);



