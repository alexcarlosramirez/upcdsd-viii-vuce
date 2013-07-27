-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: Calcula la tasa de un formato DGS015
-- --------------------------------------------------------------------------------
DELIMITER $$

CREATE FUNCTION `sce_central_db`.`dgs015_calcula_tasa`(
    p_dgs015_id int
) RETURNS double
BEGIN
    declare v_Uit double;
    declare v_OrdenId int;
    declare v_PorcUit double;
    declare v_MontoPago double;

    select valor_decimal
      into @v_Uit
      from constante
     where constante_id = 1;

    select orden_id
      into @v_OrdenId
      from dgs015
     where dgs015_id = p_dgs015_id;

    select valor
      into @v_PorcUit
      from tupa_formato_constante
     where (tupa_id, formato_id) = (select tupa_id, formato_id from tce where orden_id = @v_OrdenId);

    select (@v_Uit*@v_PorcUit) monto_pago into @v_MontoPago;
RETURN @v_MontoPago;
END