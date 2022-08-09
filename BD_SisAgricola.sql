SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

DROP SCHEMA IF EXISTS `SisAgricola`;
CREATE SCHEMA IF NOT EXISTS `SisAgricola` DEFAULT CHARACTER SET utf8 ;
USE `SisAgricola` ;

-- -----------------------------------------------------
-- Table `SisAgricola`.`Usuarios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SisAgricola`.`Usuarios`;
CREATE TABLE IF NOT EXISTS `SisAgricola`.`Usuarios` (
  `pkidusuarios` INT AUTO_INCREMENT NOT NULL,
  `Nomuser` VARCHAR(50) NOT NULL,
  `Apelluser` VARCHAR(50) NOT NULL,
  `Username` VARCHAR(20) NOT NULL,
  `Password` VARCHAR(50) NOT NULL,
  `Emailuser` VARCHAR(50) NOT NULL,
  `Ultimacuser` DATETIME NULL DEFAULT NULL,
  `Estuser` TINYINT DEFAULT 0 NOT NULL,
  PRIMARY KEY (`pkidusuarios`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;
INSERT INTO `Usuarios` VALUES 
('1', 'admin', 'admin', 'admin', 'MTIzNDU=', 'esduardo@gmail.com', '2022-07-02 21:00:48', '1'),('2', 'leonel', 'dominguez', 'laionel', 'MTIzNDU=', 'leonel@gmail.com', '2022-07-02 21:00:48', '1'),('3', 'luis', 'lee', 'luisk', 'MTIzNDU=', 'luisg@gmail.com', '2022-07-02 21:00:48', '1');
-- -----------------------------------------------------
-- Table `SisAgricola`.`Productos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SisAgricola`.`Productos`;
CREATE TABLE IF NOT EXISTS `SisAgricola`.`Productos` (
	`codigo_producto` INT AUTO_INCREMENT NOT NULL,
    `nombre_producto` VARCHAR(60) NOT NULL,
    `marca_producto` VARCHAR(50) NOT NULL,
    `existencia_producto` FLOAT DEFAULT 0,
    `estatus_producto` TINYINT DEFAULT 0,
  PRIMARY KEY (`codigo_producto`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;
-- -----------------------------------------------------
-- Table `SisAgricola`.`SolicitudDeCompra`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SisAgricola`.`SolicitudDeCompra`;
CREATE TABLE IF NOT EXISTS `SisAgricola`.`SolicitudDeCompra` (
	`codigo_solicitud` INT AUTO_INCREMENT NOT NULL,
    `codigo_producto` INT NOT NULL,
    `codigo_solicitante` INT NOT NULL,
    `cantidad_solicitud` FLOAT NOT NULL,
    `estatus_producto` TINYINT DEFAULT 0,
    PRIMARY KEY (`codigo_solicitud`),
	FOREIGN KEY (codigo_producto) REFERENCES Productos(codigo_producto),
	FOREIGN KEY (codigo_solicitante) REFERENCES Usuarios(pkidusuarios)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;