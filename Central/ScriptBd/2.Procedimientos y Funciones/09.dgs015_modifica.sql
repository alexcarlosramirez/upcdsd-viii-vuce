DROP PROCEDURE IF EXISTS `sce_central_db`.`dgs015_modifica`;

-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: Modifica los datos de un formato DGS015
-- --------------------------------------------------------------------------------
DELIMITER $$

CREATE PROCEDURE `sce_central_db`.`dgs015_modifica` (
    in p_dgs015_id int,
    in p_dgs_tipo_producto int
)
BEGIN
    update dgs015
       set dgs_tipo_producto = p_dgs_tipo_producto
     where dgs015_id = p_dgs015_id;
END