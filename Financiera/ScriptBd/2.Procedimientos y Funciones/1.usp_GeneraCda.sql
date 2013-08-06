use sce_financiera_db;
go

if exists (select * from sys.objects where type = 'P' and name = 'usp_GeneraCda')
	drop procedure usp_GeneraCda
go

create procedure usp_GeneraCda
@monto_pago decimal(18,2),
@codigo_entidad varchar(2),
@codigo_empresa varchar(11),
@cda varchar(20) output,
@fecha_generacion date output,
@hora_generacion time output
as
	set nocount on;

	declare @seq int;
	declare @fecha_hoy datetime;
	select @seq = (valor + 1) from secuencia where secuencia_id = 1;
	select @fecha_hoy = getdate();
	select @cda = '0-'+@codigo_entidad+'-'+right('000000000000000' + cast(@seq AS varchar(15)), 15), @fecha_generacion = @fecha_hoy, @hora_generacion = @fecha_hoy;
	insert into cda (cda, codigo_empresa, monto_pago, fecha_gerenacion, hora_generacion, estado) values (@cda, @codigo_empresa, @monto_pago, @fecha_generacion, @hora_generacion, 1);
	update secuencia set valor = @seq where secuencia_id = 1;
go