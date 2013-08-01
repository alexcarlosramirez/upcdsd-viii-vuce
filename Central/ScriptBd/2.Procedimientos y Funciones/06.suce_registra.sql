DROP PROCEDURE IF EXISTS `sce_central_db`.`suce_registra`;

-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: Registra la SUCE de una determinada Orden
-- --------------------------------------------------------------------------------
DELIMITER $$

CREATE PROCEDURE `sce_central_db`.`suce_registra` (
    in p_orden_id int,
    out p_suce_id int,
    out p_suce long
)
BEGIN
    declare v_FechaHoy date;
    set @v_FechaHoy = now();

    -- obteniendo el siguiente orden e insertar en orden
    BEGIN
        select generar_numero(2) into p_suce;
        insert into suce (suce, fecha_registro, bloqueada, cerrada) values (p_suce, v_FechaHoy, 'N', 'N');
        select suce_id into p_suce_id from suce where suce = p_suce;
    END;

    -- Actualizando tce
    BEGIN
        update tce set suce_id = p_suce_id, estado = 'C' where orden_id = p_orden_id;
    END;

	-- Cerrar orden
	BEGIN
		update orden set cerrada = 'S' where orden_id = p_orden_id;
	END;
END