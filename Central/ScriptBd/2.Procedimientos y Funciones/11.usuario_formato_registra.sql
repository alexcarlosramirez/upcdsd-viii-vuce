DROP PROCEDURE IF EXISTS `sce_central_db`.`usuario_formato_registra`;

-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: 
-- --------------------------------------------------------------------------------
DELIMITER $$

CREATE PROCEDURE `sce_central_db`.`usuario_formato_registra` (
	in p_usuario_formato_tipo int,
	in p_orden_id int,
	in p_mto int,
	in p_ruc varchar(11),
	in p_usuario_sol varchar(20),
	out p_usuario_id int
)
BEGIN
    -- Buscar al usuario rol RUC y usuario_sol
    BEGIN
    	select usuario_id into p_usuario_id from usuario where ruc = p_ruc and usuario_sol = p_usuario_sol;
    	-- Si usuario no existe, registrar
    	if p_usuario_id is null then
    		BEGIN
	    		insert into usuario (ruc, usuario_sol) values (p_ruc, p_usuario_sol);
	    		select usuario_id into p_usuario_id from usuario where ruc = p_ruc and usuario_sol = p_usuario_sol;
	    	END;
    	end if;
    END;

    -- Insertar
    BEGIN
    	insert into usuario_formato values (p_usuario_formato_tipo, p_usuario_id, p_orden_id, p_mto, p_ruc, p_usuario_sol);
    END;
END