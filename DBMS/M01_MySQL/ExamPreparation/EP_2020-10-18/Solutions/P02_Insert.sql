USE `sss`;

INSERT INTO `products_stores`(`product_id`, `store_id`)
SELECT p.`id`, 1 FROM `products` AS p
WHERE p.`id` NOT IN (SELECT `product_id` FROM `products_stores` AS ps);