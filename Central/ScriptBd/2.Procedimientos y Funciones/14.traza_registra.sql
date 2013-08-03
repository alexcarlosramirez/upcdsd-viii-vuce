DROP PROCEDURE IF EXISTS `sce_central_db`.`traza_registra`;

-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: 
-- --------------------------------------------------------------------------------
DELIMITER $$

CREATE PROCEDURE `sce_central_db`.`traza_registra` (
	in p_tce_id int,
	in p_estado_traza int,
	in p_orden_id int,
	in p_mto int,
	in p_dr_id int,
	in p_sdr int,
	in p_de int,
	in p_para int,
	in p_usuario_id int,
	out p_traza_id int
)
BEGIN
    -- Insertar
    BEGIN
    	insert into traza (estado_traza, tce_id, orden_id, mto, dr_id, sdr, de, para, usuario_id, fecha_registro) values (p_estado_traza, p_tce_id, p_orden_id, p_mto, p_dr_id, p_sdr, p_de, p_para, p_usuario_id, now());
    END;
END