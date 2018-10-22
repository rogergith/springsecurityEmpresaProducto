# Aplicacion Web Spring Framework, EmpresaProducto

Ejemplo de una Aplicacion Web hecha con Spring Framework en su version 5.1.0.RELEASE. 

La arquitectura de desarrollo esta basada en 3 capas (presentacion --> service --> repository). La capa de presentacion es un 
API Rest protegido con SpringSecurity usando Json Web Token(JWT) y la capa repository, SpringData Jpa. Toda la configuracion de los
beans estan en JavaConfig.

## Modelo Entidad Relacion del Negocio y Seguridad.

![modelo](https://user-images.githubusercontent.com/8161454/47325552-6706ae00-d632-11e8-9bd3-41306c686e80.png)

## El DDL de la base de datos exportado con MySQL Workbench.

```sql
-- MySQL Workbench Forward Engineering
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE DATABASE IF NOT EXISTS `empresa03` DEFAULT CHARACTER SET utf8 ;

USE `empresa03` ;

CREATE TABLE IF NOT EXISTS `empresa03`.`producto` (
  `idproducto` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NULL,
  `precio` VARCHAR(45) NULL,
  PRIMARY KEY (`idproducto`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `empresa03`.`empresa` (
  `idempresa` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`idempresa`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `empresa03`.`vendedor` (
  `idvendedor` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `telefono` VARCHAR(45) NULL,
  `idempresa` INT NOT NULL,
  PRIMARY KEY (`idvendedor`),
  INDEX `fk_vendedor_empresa_id` (`idempresa` ASC),
  CONSTRAINT `fk_vendedor_empresa`
    FOREIGN KEY (`idempresa`)
    REFERENCES `empresa03`.`empresa` (`idempresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `empresa03`.`producto_vendedor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idproducto` INT NOT NULL,
  `idvendedor` INT NOT NULL,
  INDEX `fk_productovendedor_vendedor_id` (`idvendedor` ASC),
  INDEX `fk_productovendedor_producto_id` (`idproducto` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_productovendedor_producto`
    FOREIGN KEY (`idproducto`)
    REFERENCES `empresa03`.`producto` (`idproducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_productovendedor_vendedor`
    FOREIGN KEY (`idvendedor`)
    REFERENCES `empresa03`.`vendedor` (`idvendedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `empresa03`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(300) NULL,
  `firstname` VARCHAR(45) NULL,
  `lastname` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `enabled` TINYINT NULL,
  `lastpasswordresetdate` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `empresa03`.`authority` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `empresa03`.`user_authority` (
  `user_id` INT NOT NULL,
  `authority_id` INT NOT NULL,
  INDEX `fk_userauthority_authority_id` (`authority_id` ASC),
  INDEX `fk_userauthority_user_id` (`user_id` ASC),
  CONSTRAINT `fk_userauthority_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `empresa03`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_userauthority_authority`
    FOREIGN KEY (`authority_id`)
    REFERENCES `empresa03`.`authority` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO `empresa03`.`authority` VALUES (1,'ROLE_USER'),(2,'ROLE_ADMIN');
INSERT INTO `empresa03`.`user` VALUES (1,'admin','$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi','admin','admin','admin@admin.com',1,'01-01-2016'),(2,'user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','user','user','enabled@user.com',1,'01-01-2016'),(3,'disabled','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','user','user','disabled@user.com',0,'01-01-2016');
INSERT INTO `empresa03`.`user_authority` VALUES (1,1),(1,2),(2,1),(3,1);

INSERT INTO `empresa03`.`empresa` VALUES (1,'LLANO AZUL'),(2,'LLANO VERDE');
INSERT INTO `empresa03`.`producto` VALUES (1,'MARTILLO','200'),(2,'BROCHA','150'),(3,'BROCHA','150'),(4,'BROCHA','150'),(5,'BROCHA','150'),(6,'BROCHA','150');
INSERT INTO `empresa03`.`vendedor` VALUES (1,'ROGER','04120452266',1),(2,'SANTIAGO','04121234321',2),(18,'ROGER','04120452266',2);

``` 
