DROP PROCEDURE IF EXISTS `sce_central_db`.`suce_modifica`;

-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: Actualiza el Nro de Expediente de la SUCE
-- --------------------------------------------------------------------------------
DELIMITER $$

CREATE PROCEDURE `sce_central_db`.`suce_modifica` (
    p_suce long,
    p_nro_expediente varchar(15)
)
BEGIN
    -- Actualizando SUCE
    BEGIN
        update suce set nro_expediente = p_nro_expediente where suce = p_suce;
    END;
END