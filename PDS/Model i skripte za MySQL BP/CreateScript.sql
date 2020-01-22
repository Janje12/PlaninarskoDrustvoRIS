-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema pds
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema pds
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pds` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `pds` ;

-- -----------------------------------------------------
-- Table `pds`.`Uloga`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pds`.`Uloga` (
  `idUloga` INT NOT NULL,
  `naziv` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idUloga`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pds`.`Korisnik`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pds`.`Korisnik` (
  `idKorisnik` INT NOT NULL,
  `ime` VARCHAR(45) NOT NULL,
  `prezime` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `sifra` VARCHAR(45) NOT NULL,
  `datumRodjenja` DATE NULL,
  `Uloga_idUloga` INT NOT NULL,
  PRIMARY KEY (`idKorisnik`),
  INDEX `fk_Korisnik_Uloga_idx` (`Uloga_idUloga` ASC) VISIBLE,
  CONSTRAINT `fk_Korisnik_Uloga`
    FOREIGN KEY (`Uloga_idUloga`)
    REFERENCES `pds`.`Uloga` (`idUloga`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pds`.`Planina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pds`.`Planina` (
  `idPlanina` INT NOT NULL,
  `naziv` VARCHAR(45) NOT NULL,
  `opis` VARCHAR(500) NOT NULL,
  `geolokacija` POINT NOT NULL,
  PRIMARY KEY (`idPlanina`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pds`.`PlaninarskiDom`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pds`.`PlaninarskiDom` (
  `idPlaninarskiDom` INT NOT NULL,
  `naziv` VARCHAR(45) NOT NULL,
  `opis` VARCHAR(500) NOT NULL,
  `adresa` VARCHAR(50) NULL,
  `geolokacija` POINT NOT NULL,
  `Planina_idPlanina` INT NOT NULL,
  PRIMARY KEY (`idPlaninarskiDom`),
  INDEX `fk_PlaninarskiDom_Planina1_idx` (`Planina_idPlanina` ASC) VISIBLE,
  CONSTRAINT `fk_PlaninarskiDom_Planina1`
    FOREIGN KEY (`Planina_idPlanina`)
    REFERENCES `pds`.`Planina` (`idPlanina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pds`.`Staza`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pds`.`Staza` (
  `idStaza` INT NOT NULL,
  `naziv` VARCHAR(45) NULL,
  `duzina` DOUBLE NULL,
  `Planina_idPlanina` INT NOT NULL,
  PRIMARY KEY (`idStaza`),
  INDEX `fk_Staza_Planina1_idx` (`Planina_idPlanina` ASC) VISIBLE,
  CONSTRAINT `fk_Staza_Planina1`
    FOREIGN KEY (`Planina_idPlanina`)
    REFERENCES `pds`.`Planina` (`idPlanina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pds`.`Znamenitost`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pds`.`Znamenitost` (
  `idZnamenitost` INT NOT NULL,
  `naziv` VARCHAR(45) NULL,
  `opis` VARCHAR(200) NULL,
  `tip` VARCHAR(45) NULL,
  `Staza_idStaza` INT NOT NULL,
  PRIMARY KEY (`idZnamenitost`),
  INDEX `fk_Znamenitost_Staza1_idx` (`Staza_idStaza` ASC) VISIBLE,
  CONSTRAINT `fk_Znamenitost_Staza1`
    FOREIGN KEY (`Staza_idStaza`)
    REFERENCES `pds`.`Staza` (`idStaza`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pds`.`Rezervacija`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pds`.`Rezervacija` (
  `idRezervacija` INT NOT NULL,
  `datumRezervacije` DATE NOT NULL,
  `datumDolaska` DATE NULL,
  `vrstaRezervacije` VARCHAR(45) NULL,
  `Korisnik_idKorisnik` INT NOT NULL,
  `PlaninarskiDom_idPlaninarskiDom` INT NULL,
  `Znamenitost_idZnamenitost` INT NULL,
  PRIMARY KEY (`idRezervacija`),
  INDEX `fk_Rezervacija_Korisnik1_idx` (`Korisnik_idKorisnik` ASC) VISIBLE,
  INDEX `fk_Rezervacija_PlaninarskiDom1_idx` (`PlaninarskiDom_idPlaninarskiDom` ASC) VISIBLE,
  INDEX `fk_Rezervacija_Znamenitost1_idx` (`Znamenitost_idZnamenitost` ASC) VISIBLE,
  CONSTRAINT `fk_Rezervacija_Korisnik1`
    FOREIGN KEY (`Korisnik_idKorisnik`)
    REFERENCES `pds`.`Korisnik` (`idKorisnik`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Rezervacija_PlaninarskiDom1`
    FOREIGN KEY (`PlaninarskiDom_idPlaninarskiDom`)
    REFERENCES `pds`.`PlaninarskiDom` (`idPlaninarskiDom`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Rezervacija_Znamenitost1`
    FOREIGN KEY (`Znamenitost_idZnamenitost`)
    REFERENCES `pds`.`Znamenitost` (`idZnamenitost`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pds`.`Izvestaj`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pds`.`Izvestaj` (
  `idIzvestaj` INT NOT NULL,
  `naslov` VARCHAR(45) NULL,
  `sadrzaj` VARCHAR(1000) NULL,
  `datumNastanka` DATE NULL,
  `Korisnik_idKorisnik` INT NOT NULL,
  PRIMARY KEY (`idIzvestaj`),
  INDEX `fk_Izvestaj_Korisnik1_idx` (`Korisnik_idKorisnik` ASC) VISIBLE,
  CONSTRAINT `fk_Izvestaj_Korisnik1`
    FOREIGN KEY (`Korisnik_idKorisnik`)
    REFERENCES `pds`.`Korisnik` (`idKorisnik`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
