DROP PROCEDURE IF EXISTS `sce_central_db`.`asignar_tasa`;

-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: Asigna una tasa a una determinada Orden.
-- --------------------------------------------------------------------------------
DELIMITER $$

CREATE PROCEDURE `sce_central_db`.`asignar_tasa` (
    p_orden_id int,
    p_monto double,
    p_cda varchar(20),
    p_fecha_gen date
)
BEGIN
    declare v_TceId int;
    declare v_TasaId int;

    -- Insetar en Tasa
    insert into tasa (monto, cda, fecha_generacion, pagado)
              values (p_monto, p_cda, p_fecha_gen, 'N');

    -- Inserta en Tce tasa
    select @v_TceId:=tce_id from tce where orden_id = p_orden_id;
    select @v_TasaId:=tasa_id from tasa where cda = p_cda;
    insert into tce_tasa values (@v_TceId, @v_TasaId);
END