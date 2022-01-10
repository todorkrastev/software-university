CREATE SCHEMA `car_rental` DEFAULT CHARACTER SET utf8mb4;
USE `car_rental`;

CREATE TABLE `categories`(
`id` INT NOT NULL AUTO_INCREMENT,
`category` VARCHAR(50) NOT NULL,
`daily_rate` DECIMAL(2, 2),
`weekly_rate` DECIMAL(2, 2),
`monthly_rate` DECIMAL(2, 2),
`weekend_rate` DECIMAL(2, 2),
PRIMARY KEY (`id`)
);

INSERT INTO `categories`(`category`) VALUES
('category1'),
('category2'),
('category3');

CREATE TABLE `cars`(
`id` INT NOT NULL AUTO_INCREMENT,
`plate_number` VARCHAR(8) NOT NULL,
`make` DATE NOT NULL,
`model` VARCHAR(50) NOT NULL,
`car_year` YEAR NOT NULL,
`category_id` INT NOT NULL,
`doors` CHAR(1),
`picture` LONGBLOB,
`car_condition` TINYTEXT,
`available` CHAR(3),
PRIMARY KEY (`id`)
);

INSERT INTO `cars`(`plate_number`, `make`, `model`, `car_year`, `category_id`) VALUES
('CA8888TT', '2022-01-10', 'Mercedes G-Klasse', '2022', 8),
('CA6929PK', '2022-01-10', 'Mercedes G-Klasse', '2022', 1),
('CA6929PK', '2022-01-10', 'Mercedes G-Klasse', '2022', 2);


CREATE TABLE `employees`(
`id` INT NOT NULL AUTO_INCREMENT,
`first_name` VARCHAR(50) NOT NULL,
`last_name` VARCHAR(50) NOT NULL,
`title` VARCHAR(10),
`notes` TINYTEXT,
PRIMARY KEY (`id`)
);

INSERT INTO `employees`(`first_name`, `last_name`) VALUES
('Todor', 'Todorov'),
('Ivan', 'Ivanov'),
('Krasimir', 'Krasimirov');

CREATE TABLE `customers`(
`id` INT NOT NULL AUTO_INCREMENT,
`driver_licence_number` INT NOT NULL,
`full_name` VARCHAR(100) NOT NULL,
`address` VARCHAR(50) NOT NULL,
`city` VARCHAR(50) NOT NULL,
`zip_code` VARCHAR(20) NOT NULL,
`notes` TINYTEXT,
PRIMARY KEY (`id`)
);

INSERT INTO `customers`(`driver_licence_number`, `full_name`, `address`, `city`, `zip_code`) VALUES
('985210524', 'Todor Todorov Todorov', 'Germany', 'Constance', '78465'),
('985210524', 'Ivan Ivanov Ivanov', 'Germany', 'Constance', '78465'),
('985210524', 'Marina Marinova Marinova', 'Germany', 'Constance', '78465');

CREATE TABLE `rental_orders`(
`id` INT NOT NULL AUTO_INCREMENT,
`employee_id` INT NOT NULL,
`customer_id` INT NOT NULL,
`car_id` INT NOT NULL,
`car_condition` VARCHAR(10) NOT NULL,
`tank_level` INT NOT NULL,
`kilometrage_start` DECIMAL(6,1) NOT NULL,
`kilometrage_end` DECIMAL(6,1) NOT NULL,
`total_kilometrage` DECIMAL(5,1) NOT NULL,
`start_date` DATE NOT NULL,
`end_date` DATE NOT NULL,
`total_days` INT NOT NULL,
`rate_applied` DECIMAL(2, 2),
`tax_rate` DECIMAL(2, 2),
`order_status` VARCHAR(20) NOT NULL,
`notes` TINYTEXT,
PRIMARY KEY (`id`)
);

INSERT INTO `rental_orders`(`employee_id`, `customer_id`, `car_id`, `car_condition`, `tank_level`, `kilometrage_start`, `kilometrage_end`, `total_kilometrage`, `start_date`, `end_date`, `total_days`, `order_status`) VALUES
('1358', '786512', '45124', 'brand new', 62, 16121.5, 16215.8, 104.3, '2022-01-10', '2022-01-10', 1, 'ready to drive'),
('1358', '786512', '45124', 'brand new', 62, 16121.5, 16215.8, 104.3, '2022-01-10', '2022-01-10', 1, 'ready to drive'),
('1358', '786512', '45124', 'brand new', 62, 16121.5, 16215.8, 104.3, '2022-01-10', '2022-01-10', 1, 'ready to drive');
