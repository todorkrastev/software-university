CREATE SCHEMA `amazon`;
USE `amazon`;

CREATE TABLE `cities` (
    `city_id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50)
);

CREATE TABLE `customers` (
    `customer_id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50),
    `birthday` DATE,
    `city_id` INT,
    CONSTRAINT fk_customers_cities FOREIGN KEY (`city_id`)
        REFERENCES `cities` (`city_id`)
);

CREATE TABLE `orders` (
    `order_id` INT PRIMARY KEY AUTO_INCREMENT,
    `customer_id` INT,
    CONSTRAINT fk_orders_customers FOREIGN KEY (`customer_id`)
        REFERENCES `customers` (`customer_id`)
);

CREATE TABLE `item_types` (
    `item_type_id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50)
);

CREATE TABLE `items` (
    `item_id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50),
    `item_type_id` INT,
    CONSTRAINT fk_items_item_types FOREIGN KEY (`item_type_id`)
        REFERENCES `item_types` (`item_type_id`)
);

CREATE TABLE `order_items` (
    `order_id` INT,
    `item_id` INT,
    CONSTRAINT pk_order_items PRIMARY KEY (`order_id` , `item_id`),
    CONSTRAINT fk_order_items_orders FOREIGN KEY (`order_id`)
        REFERENCES `orders` (`order_id`),
    CONSTRAINT fk_order_items_items FOREIGN KEY (`item_id`)
        REFERENCES `items` (`item_id`)
);