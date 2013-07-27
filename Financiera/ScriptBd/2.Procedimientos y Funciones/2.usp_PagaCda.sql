if exists (select * from sys.objects where type = 'P' and name = 'usp_PagaCda')
	drop procedure usp_PagaCda
go

create procedure usp_PagaCda
@cda varchar(20),
@monto_pago decimal output,
@fecha_pago date output,
@hora_pago time output
as
	set nocount on;

	declare @fecha_hoy datetime;
	select @fecha_hoy = getdate();
	select @fecha_pago = @fecha_hoy, @hora_pago = @fecha_hoy;
	update cda set estado = 2, fecha_pago = @fecha_pago, hora_pago = @hora_pago where cda = @cda and estado = 1;
	select @monto_pago = monto_pago from cda where cda = @cda;
go