USE `gringotts`;

SELECT LEFT(wd.`first_name`, 1) AS `first_letter` FROM `wizzard_deposits` AS wd
WHERE `deposit_group` = 'Troll Chest'
GROUP BY `first_letter`
ORDER BY `first_letter`;