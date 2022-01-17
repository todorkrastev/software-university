USE `gringotts`;

SELECT 
    wd.`deposit_group`,
    MAX(wd.`magic_wand_size`) AS `longest_magic_wand`
FROM
    `wizzard_deposits` AS wd
GROUP BY wd.`deposit_group`
ORDER BY `longest_magic_wand` , wd.`deposit_group`;