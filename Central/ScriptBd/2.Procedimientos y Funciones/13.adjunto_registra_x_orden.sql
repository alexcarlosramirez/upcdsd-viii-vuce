DROP PROCEDURE IF EXISTS `sce_central_db`.`adjunto_registra_x_orden`;

-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: Registra la SUCE de una determinada Orden
-- --------------------------------------------------------------------------------
DELIMITER $$

CREATE PROCEDURE `sce_central_db`.`adjunto_registra_x_orden` (
    in p_orden_id int,
    in p_mto int,
    in p_nombre_archivo varchar(256),
    in p_archivo blob
)
BEGIN
	declare v_FormatoId int;
	declare v_Formato varchar(6);
	declare v_TceId int;

	-- Actualizar como transmitido
	BEGIN
		select @v_FormatoId:=formato_id from tce where orden_id = p_orden_id;
	END;

	-- Actualizar tce
	BEGIN
		insert into adjunto (orden_id, mto, nombre_archivo, archivo, formato_id) values (p_orden_id, p_mto, p_nombre_archivo, p_archivo, @v_FormatoId);
	END;
END