DROP PROCEDURE IF EXISTS `sce_central_db`.`frm001_modifica`;

-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: Modifica los datos de un formato frm001
-- --------------------------------------------------------------------------------
DELIMITER $$

CREATE PROCEDURE `sce_central_db`.`frm001_modifica` (
    in p_frm001_id int,
    in p_tipo_mercaderia varchar(100),
    in p_detalle_mercaderia varchar(500)
)
BEGIN
    update frm001
       set tipo_mercaderia = p_tipo_mercaderia,
           detalle_mercaderia = p_detalle_mercaderia
     where frm001_id = p_frm001_id;
END