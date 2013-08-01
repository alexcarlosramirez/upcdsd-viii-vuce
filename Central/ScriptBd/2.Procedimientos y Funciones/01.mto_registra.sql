DROP PROCEDURE IF EXISTS `sce_central_db`.`mto_registra`;
-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: 
-- --------------------------------------------------------------------------------
DELIMITER $$

CREATE PROCEDURE `sce_central_db`.`mto_registra` (
	in p_orden_id int,
	in p_fecha_registro date,
	in p_estapa_tramite varchar(1),
	out p_mto int
)
BEGIN
	select (ifnull(max(mto),0)+1) mto into p_mto from mto where orden_id = p_orden_id;
    insert into mto values (p_orden_id, p_mto, p_fecha_registro, 'S', 'N', p_estapa_tramite);
END