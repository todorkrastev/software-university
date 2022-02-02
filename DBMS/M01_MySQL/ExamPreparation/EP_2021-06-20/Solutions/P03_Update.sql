USE `stc`;

UPDATE `cars`
SET `condition` = 'C'
WHERE `mileage` >= 800000 
OR `mileage` IS NULL 
OR `year` >= 2010;