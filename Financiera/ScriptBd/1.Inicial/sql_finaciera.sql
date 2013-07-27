if exists (select * from sys.databases where name='sce_financiera_db')
	alter database sce_financiera_db set single_user with rollback immediate;
	drop database sce_financiera_db;
go

create database sce_financiera_db;
go

use sce_financiera_db;
go

--==============================================

if exists (select * from sys.objects where type = 'U' and name = 'usuario')
	drop table usuario
go

create table usuario (
	usuario_id int not null,
	codigo varchar(15),
	claveweb varchar(15),
	estado int,
	constraint pk_usuario primary key (usuario_id)
);
go

insert into usuario values (1,'usuban1','usuban1',1), (2,'usuban2','usuban2',1);
go

--==============================================

if exists (select * from sys.objects where type = 'U' and name = 'banco')
	drop table banco;
go

create table banco (
	banco_id int not null,
	nombre varchar(50),
	estado int,
	constraint pk_banco primary key (banco_id)
);
go

insert into banco values (1,'BANCO POPULAR',1), (2,'BANCO FAVORITO',1);
go

--==============================================

if exists (select * from sys.objects where type = 'U' and name = 'usuario_banco')
	drop table usuario_banco;
go

create table usuario_banco (
	usuario_id int not null,
	banco_id int not null,
	constraint pk_usuario_banco primary key (usuario_id, banco_id)
);
go

alter table usuario_banco
add constraint fk_usuario_banco_usuario
foreign key (usuario_id)
references usuario (usuario_id);
go

alter table usuario_banco
add constraint fk_usuario_banco_banco
foreign key (banco_id)
references banco (banco_id);
go

insert into usuario_banco values (1,1), (1,2), (2,2);
go

--==============================================

if exists (select * from sys.objects where type = 'U' and name = 'cuenta')
	drop table cuenta;
go

create table cuenta (
	cuenta_id int not null,
	numero varchar(25),
	banco_id int,
	estado int,
	constraint pk_cuenta primary key (cuenta_id)
);
go

alter table cuenta
add constraint fk_cuenta_banco
foreign key (banco_id)
references banco (banco_id);
go

insert into cuenta values (1,'0511-0000-0000-012345',1,1), (2,'3422-0000-0000-678901',2,1), (3,'3422-0000-0000-012345',2,1);
go

--==============================================

if exists (select * from sys.objects where type = 'U' and name = 'usuario_cuenta')
	drop table usuario_cuenta;
go

create table usuario_cuenta (
	usuario_id int not null,
	cuenta_id int not null,
	constraint pk_usuario_cuenta primary key (usuario_id, cuenta_id)
);
go

alter table usuario_cuenta
add constraint fk_usuario_cuenta_usuario
foreign key (usuario_id)
references usuario (usuario_id);
go

alter table usuario_cuenta
add constraint fk_usuario_cuenta_cuenta
foreign key (cuenta_id)
references cuenta (cuenta_id);
go

insert into usuario_cuenta values (1, 1), (1,2), (2,3);
go

--==============================================

if exists (select * from sys.objects where type = 'U' and name = 'secuencia')
	drop table secuencia;
go

create table secuencia (
	secuencia_id int not null,
	nombre varchar(50),
	valor int,
	constraint pk_secuencia primary key (secuencia_id)
);
go

insert into secuencia values (1, 'CDA', 0);
go

if exists (select * from sys.objects where type = 'U' and name = 'cda')
	drop table cda;
go

create table cda (
	cda_id int not null identity,
	cda varchar(20),
	monto_pago decimal(18,2),
	fecha_gerenacion date,
	hora_generacion time,
	fecha_pago date,
	hora_pago time,
	estado int,
	constraint pk_cda primary key (cda_id)
);
go