-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: Crea la orden, su mto (versión) inicial, registra en la tabla tce, calcula la tasa a pagar e inicia los registros del formato
-- --------------------------------------------------------------------------------
DELIMITER $$

CREATE PROCEDURE `sce_central_db`.`orden_registra`(
    in p_formato varchar(6),
    out p_orden_id int,
    out p_mto int,
    out p_orden long,
    out p_formatoentidad_id int,
    out p_tce_id int,
    out p_monto_pago double
)
BEGIN
    -- Declaraciones
    declare v_FechaHoy date;
    declare v_Sql varchar(2000);
    declare v_TupaId int;
    declare v_FormatoId int;
	declare v_CdaId int;
	declare v_Cda varchar(20);

    set @v_FechaHoy = now();
    select @v_TupaId:=tupa_id,
           @v_FormatoId:=formato_id
      from tupa_formato
     where formato_id = (select formato_id from formato where formato = p_Formato);

    -- obteniendo el siguiente orden e insertar en orden y 
    BEGIN
        select generar_numero(1) into p_orden;
        insert into orden (orden, fecha_registro, bloqueada, cerrada) values (p_orden, @v_FechaHoy, 'N', 'N');
        select orden_id into p_orden_id from orden where orden = p_orden;
    END;

    -- obteniendo el siguiente mto e insertar mto
    BEGIN
        select (ifnull(max(mto),0)+1) mto into p_mto from mto where orden_id = p_orden;
        insert into mto values (p_orden_id, p_mto, @v_FechaHoy, 'S');
    END;

    -- Insertar en la tabla del tce
    BEGIN
        insert into tce (tupa_id, formato_id, orden_id, fecha_registro, estado)
                 values (@v_TupaId, @v_FormatoId, p_orden_id, @v_FechaHoy, 'B');
        select tce_id into p_tce_id from tce where orden_id = p_orden_id;
    END;

    -- Insertar en la tabla del formato
    BEGIN
        set @orden_id = p_orden_id;
        set @mto = p_mto;

        set @v_Sql = concat("insert into ", p_formato, " (orden_id, mto) values (?,?)");
        prepare stmt1 from @v_Sql;
        execute stmt1 using @orden_id, @mto;
        deallocate prepare stmt1;

        set @v_Sql = concat("select ", p_formato, "_id into @v_FormatoEntidadId from ", p_formato, " where orden_id = ? AND mto = ?");
        prepare stmt2 from @v_Sql;
        execute stmt2 using @orden_id, @mto;
        deallocate prepare stmt2;
        select @v_FormatoEntidadId into p_formatoentidad_id;
    END;

    -- Calcular tasa
    BEGIN
        set @v_FormatoEntidadId = p_formatoentidad_id;
        set @v_Sql = concat("select ", lower(p_formato), "_calcula_tasa(?)", "into @v_Tasa");
        prepare stmt3 from @v_Sql;
        execute stmt3 using @v_FormatoEntidadId;
        deallocate prepare stmt3;
        select @v_Tasa into p_monto_pago;
    END;
END