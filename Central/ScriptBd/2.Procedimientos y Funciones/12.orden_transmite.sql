DROP PROCEDURE IF EXISTS `sce_central_db`.`orden_transmite`;

-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: Registra la SUCE de una determinada Orden
-- --------------------------------------------------------------------------------
DELIMITER $$

CREATE PROCEDURE `sce_central_db`.`orden_transmite` (
    in p_orden_id int,
    in p_mto int,
    in p_formato_entidad_id int,
    out p_monto_pago double
)
BEGIN
	declare v_FormatoId int;
	declare v_Formato varchar(6);
	declare v_TceId int;

	-- Actualizar como transmitido
	BEGIN
		update mto set transmitido = 'S' where orden_id = p_orden_id and mto = p_mto;
	END;

	-- Actualizar tce
	BEGIN
		select @v_TceId:=tce_id, @v_FormatoId:=formato_id from tce where orden_id = p_orden_id;
		update tce set estado = 'B' where tce_id = @v_TceId;
	END;

    -- Calcular tasa
    BEGIN
	    select @v_Formato:=formato from formato where formato_id = @v_FormatoId;
	    set @v_FormatoEntidadId = p_formato_entidad_id;
        set @v_Sql = concat("select ", lower(@v_Formato), "_calcula_tasa(?)", "into @v_Tasa");
        prepare stmt3 from @v_Sql;
        execute stmt3 using @v_FormatoEntidadId;
        deallocate prepare stmt3;
        select @v_Tasa into p_monto_pago;
    END;
END