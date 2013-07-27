drop database if exists sce_central_db;
create database if not exists sce_central_db;
use sce_central_db;

-- ================================

create table secuencia (
	secuencia_id int not null,
	tabla varchar(30),
	valor int,
	constraint pk_secuencia primary key (secuencia_id)
);

create table constante (
	constante_id int not null,
	nombre varchar(50),
	valor_decimal double,
	valor_cadena varchar(150),
	constraint pk_constante primary key (constante_id)
);

create table tupa (
	tupa_id int not null,
	tupa varchar(10),
	nombre varchar(150),
	estado varchar(1),
	constraint pk_tupa primary key (tupa_id)
);

create table formato (
	formato_id int not null,
	formato varchar(6),
	nombre varchar(150),
	estado varchar(1),
	constraint pk_formato primary key (formato_id)
);

create table tupa_formato (
	tupa_id int not null,
	formato_id int not null,
	tipo_tasa varchar(1),
	especificacion_pago varchar(50),
	constraint pk_tupa_formato primary key (tupa_id, formato_id)
);

alter table tupa_formato
add constraint fk_tupa_formato_tupa
foreign key (tupa_id)
references tupa(tupa_id);

alter table tupa_formato
add constraint fk_tupa_formato_formato
foreign key (formato_id)
references formato(formato_id);

create table tupa_formato_constante (
	constante_id int not null,
	tupa_id int not null,
	formato_id int not null,
	valor double,
	constraint pk_tupa_formato_cons primary key (constante_id, tupa_id, formato_id)
);

alter table tupa_formato_constante
add constraint fk_tupaformcons_tupaform
foreign key (tupa_id, formato_id)
references tupa_formato(tupa_id, formato_id);

-- ================================

create table orden (
	orden_id int not null auto_increment,
	orden long,
	fecha_registro datetime,
	bloqueada varchar(1),
	cerrada varchar(1),
	constraint pk_orden primary key (orden_id)
);

create table mto (
	orden_id int not null,
	mto int not null,
	fecha_registro datetime,
	vigente varchar(1),
	constraint pk_mto primary key (orden_id, mto)
);

alter table mto
add constraint fk_mto_orden
foreign key (orden_id)
references orden(orden_id);

-- ================================

create table suce (
	suce_id int not null auto_increment,
	suce long,
	nro_expediente varchar(15),
	fecha_registro datetime,
	bloqueada varchar(1),
	cerrada varchar(1),
	constraint pk_suce primary key (suce_id)
);

-- ================================

create table dr (
	dr_id int not null auto_increment,
	dr long,
	suce_id int,
	fecha_registro datetime,
	tipo_dr varchar(1),
	estado varchar(1),
	constraint pk_dr primary key (dr_id)
);

alter table dr
add constraint fk_dr_suce
foreign key (suce_id)
references suce(suce_id);

create table sdr (
	dr_id int not null,
	sdr int not null,
	fecha_registro datetime,
	vigente varchar(1),
	constraint pk_sdr primary key (dr_id, sdr)
);

alter table sdr
add constraint fk_sdr_dr
foreign key (dr_id)
references dr(dr_id);

-- ================================

create table tce (
	tce_id int not null auto_increment,
	tupa_id int,
	formato_id int,
	orden_id int,
	suce_id int,
	fecha_registro datetime,
	estado varchar(1),
	constraint pk_tce primary key (tce_id)
);

alter table tce
add constraint fk_tce_orden
foreign key (orden_id)
references orden(orden_id);

alter table tce
add constraint fk_tce_suce
foreign key (suce_id)
references suce(suce_id);

alter table tce
add constraint fk_tce_tupa_formato
foreign key (tupa_id, formato_id)
references tupa_formato(tupa_id, formato_id);

-- ================================

create table traza (
	traza_id int not null auto_increment,
	tce_id int,
	orden_id int,
	mto int,
	dr_id int,
	sdr int,
	de varchar(1),
	para varchar(1),
	fecha_registro datetime,
	constraint pk_traza primary key (traza_id)
);

alter table traza
add constraint fk_traza_tce
foreign key (tce_id)
references tce(tce_id);

alter table traza
add constraint fk_traza_mto
foreign key (orden_id, mto)
references mto(orden_id, mto);

alter table traza
add constraint fk_traza_sdr
foreign key (dr_id, sdr)
references sdr (dr_id, sdr);

-- ================================

create table adjunto (
	adjunto_id int auto_increment,
	nombre_archivo varchar(256),
	archivo blob,
	orden_id int,
	mto int,
	dr_id int,
	sdr int,
    formato_id int,
	constraint pk_adjunto primary key (adjunto_id)
);

alter table adjunto
add constraint fk_adjunto_mto
foreign key (orden_id, mto)
references mto(orden_id, mto);

alter table adjunto
add constraint fk_adjunto_sdr
foreign key (dr_id, sdr)
references sdr (dr_id, sdr);

-- ================================

create table tasa (
	tasa_id int not null auto_increment,
	monto double,
	cda varchar(20),
	fecha_generacion datetime,
	fecha_pago datetime,
	pagado varchar(1),
	constraint pk_tasa primary key (tasa_id)
);

create table tce_tasa (
	tce_id int not null,
	tasa_id int not null,
	constraint pk_tce_tasa primary key (tce_id, tasa_id)
);

alter table tce_tasa
add constraint fk_tce_tasa_tce
foreign key (tce_id)
references tce (tce_id);

alter table tce_tasa
add constraint fk_tce_tasa_tasa
foreign key (tasa_id)
references tasa (tasa_id);

-- ================================

create table dgs_tipo_producto (
	dgs_tipo_producto int,
	descripcion varchar(50),
	estado varchar(1),
	constraint pk_dgs_tipo_producto primary key (dgs_tipo_producto)
);

create table dgs015 (
	dgs015_id int not null auto_increment,
	orden_id int,
	mto int,
	dgs_tipo_producto int,
	constraint pk_dgs015 primary key (dgs015_id)
);

alter table dgs015
add constraint fk_dgs015_mto
foreign key (orden_id, mto)
references mto (orden_id, mto);

alter table dgs015
add constraint fk_dgs015_dgstippro
foreign key (dgs_tipo_producto)
references dgs_tipo_producto (dgs_tipo_producto);

create table dgs015_producto (
	dgs015_id int not null,
	sec_producto int not null,
	nombre varchar(100),
	partida_arancelaria varchar(10),
	cantidad int,
	envase varchar(150),
	constraint pk_dgs015_producto primary key (dgs015_id, sec_producto)
);

alter table dgs015_producto
add constraint fk_dgs015_producto_dgs015
foreign key (dgs015_id)
references dgs015 (dgs015_id);

create table dgs015_dr (
	dgs015_dr_id int not null auto_increment,
	dr_id int,
	sdr int,
	dgs_tipo_producto int,
	constraint pk_dgs015_dr primary key (dgs015_dr_id)
);

alter table dgs015_dr
add constraint fk_dgs015_dr_sdr
foreign key (dr_id, sdr)
references sdr (dr_id, sdr);

alter table dgs015_dr
add constraint fk_dgs015_dr_dgstippro
foreign key (dgs_tipo_producto)
references dgs_tipo_producto (dgs_tipo_producto);

create table dgs015_dr_producto (
	dgs015_dr_id int not null,
	sec_producto int not null,
	nombre varchar(100),
	partida_arancelaria varchar(10),
	cantidad int,
	envase varchar(150),
	constraint pk_dgs015_dr_producto primary key (dgs015_dr_id, sec_producto)
);

alter table dgs015_dr_producto
add constraint fk_dgs015drpro_dgs015dr
foreign key (dgs015_dr_id)
references dgs015_dr (dgs015_dr_id);

-- ================================

insert into secuencia values (1,'ORDEN',0);
insert into secuencia values (2,'SUCE',0);
insert into secuencia values (3,'DR',0);

insert into tupa values (1,'24','Autorización Sanitaria de Desinfectantes y Plaguicidas de uso domestico, industrial y en salud pública (Nacional o Importado)','A');
insert into tupa values (2,'25','Autorización Sanitaria para la importación de Desinfectantes y Plaguicidas de uso doméstico, industrial y en salud pública no destinados al comercio.','I');

insert into formato values (1,'DGS015','Autorización Sanitaria de Desinfectantes y Plaguicidas de uso domestico, industrial y en salud pública (Nacional o Importado)','A');
insert into formato values (2,'DGS016','Autorización Sanitaria para la importación de Desinfectantes y Plaguicidas de uso doméstico, industrial y en salud pública no destinados al comercio.','I');

insert into tupa_formato values (1,1,'2','27.13% de la UIT');
insert into tupa_formato values (2,2,'2','27.13% de la UIT');

insert into constante values (1, 'UIT', 1000, '');

insert into tupa_formato_constante values (1, 1, 1, 0.2713);
insert into tupa_formato_constante values (2, 2, 2, 0.2713);

insert into dgs_tipo_producto values (1,'Plaguicidas','A');
insert into dgs_tipo_producto values (2,'Desinfectantes','A');

commit;