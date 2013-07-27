-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: No llamado desde el sistema, genera un número secuencial ya sea ORDEN (1), SUCE (2) ó DR (3)
-- --------------------------------------------------------------------------------
DELIMITER $$

CREATE FUNCTION `sce_central_db`.`generar_numero` (
    p_secuencia_id int
)
RETURNS LONG
BEGIN
    declare v_SeqOrden int;
    declare v_Numero long;

    select (valor + 1) seq into @v_SeqOrden from secuencia where secuencia_id = p_secuencia_id;
    select cast(concat(year(now()),lpad(@v_SeqOrden,6,'0')) as decimal) into @v_Numero;
    update secuencia set valor = @v_SeqOrden where secuencia_id = p_secuencia_id;
RETURN @v_Numero;
END