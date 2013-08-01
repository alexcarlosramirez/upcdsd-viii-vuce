-- phpMyAdmin SQL Dump
-- version 3.2.0.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generaci�n: 19-07-2013 a las 18:38:40
-- Versi�n del servidor: 5.1.37
-- Versi�n de PHP: 5.3.0

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Base de datos: `sd_entidad`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_expediente`
--

DROP database IF EXISTS sd_entidad;
CREATE database IF NOT EXISTS sd_entidad;
USE sd_entidad;

CREATE TABLE IF NOT EXISTS t_expediente (
  id_expediente int(6) NOT NULL AUTO_INCREMENT,
  nu_orden int(10) NOT NULL,
  nu_suce int(10) NOT NULL,
  nu_dr int(10) NOT NULL,
  l_estado_pago varchar(1),
  nu_expediente varchar(12),
  PRIMARY KEY (id_expediente)
);

CREATE TABLE IF NOT EXISTS `t_dgs015` (
  id_dgs015 int(6) NOT NULL AUTO_INCREMENT,
  id_expediente int(6) NOT NULL,
  nu_tipo_producto int NOT NULL,
  PRIMARY KEY (id_dgs015)
);

CREATE TABLE IF NOT EXISTS `t_dgs015_producto` (
  id_dgs015 int(6) NOT NULL AUTO_INCREMENT,
  secuencia_producto int NOT NULL,
  no_producto varchar(100) NOT NULL,
  partida_arancelaria varchar(10) NOT NULL,
  qt_producto int NOT NULL,
  envase varchar(150) NOT NULL,
  PRIMARY KEY (id_dgs015, secuencia_producto)
);