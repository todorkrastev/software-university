USE `cjms`;

DELIMITER $$$
CREATE FUNCTION `udf_count_colonists_by_destination_planet`(`planet_name` VARCHAR(30))
  RETURNS INT
  DETERMINISTIC
  BEGIN
	RETURN (
      SELECT COUNT(c.`id`)
      FROM `colonists` AS `c`
      JOIN `travel_cards` AS `tc` on c.`id` = tc.`colonist_id`
      JOIN `journeys` AS `j` on tc.`journey_id` = j.`id`
      JOIN `spaceports` AS `s` on j.`destination_spaceport_id` = s.`id`
      JOIN `planets` AS `p` on s.`planet_id` = p.`id`
      WHERE p.`name` = planet_name
    );
  END; $$$
DELIMITER ;

SELECT 
    p.`name`,
    `udf_count_colonists_by_destination_planet`('Otroyphus') AS `count`
FROM
    `planets` AS `p`
WHERE
    p.`name` = 'Otroyphus';