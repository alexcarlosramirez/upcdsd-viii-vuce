-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: Modifica los datos de un formato DGS015_PRODUCTO
-- --------------------------------------------------------------------------------
DELIMITER $$

CREATE PROCEDURE `sce_central_db`.`dgs015_producto_registra` (
	in p_dgs015_id int,
	in p_nombre varchar(100),
	in p_partida_arancelaria varchar(10),
	in p_cantidad int,
	in p_envase varchar(150),
	out p_sec_producto int
)
BEGIN
    select (ifnull(max(sec_producto),0)+1) sec_producto
      into p_sec_producto
      from dgs015_producto
     where dgs015_id = p_dgs015_id;

	insert into dgs015_producto
         values (p_dgs015_id,
                 p_sec_producto,
                 p_nombre,
                 p_partida_arancelaria,
                 p_cantidad,
                 p_envase);
END