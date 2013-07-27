﻿-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: Registra el pago de una tasa
-- --------------------------------------------------------------------------------
DELIMITER $$

CREATE PROCEDURE `sce_central_db`.`pagar_tasa` (
	in p_cda varchar(20),
	in p_fecha_pago datetime
)
BEGIN
	declare v_TasaId int;
	update tasa set fecha_pago = p_fecha_pago, pagado = 'S' where cda = p_cda;
END