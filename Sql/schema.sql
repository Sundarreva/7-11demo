-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema seveneleven
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema seveneleven
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `seveneleven` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `seveneleven` ;

-- -----------------------------------------------------
-- Table `seveneleven`.`employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `seveneleven`.`employee` (
  `emp_id` BIGINT NOT NULL AUTO_INCREMENT,
  `emp_domain` VARCHAR(255) NULL DEFAULT NULL,
  `emp_designation` VARCHAR(255) NULL DEFAULT NULL,
  `emp_name` VARCHAR(255) NULL DEFAULT NULL,
  `emp_salary` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`emp_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `seveneleven`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `seveneleven`.`role` (
  `ro_id` BIGINT NOT NULL AUTO_INCREMENT,
  `ro_role` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`ro_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `seveneleven`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `seveneleven`.`user` (
  `us_id` BIGINT NOT NULL AUTO_INCREMENT,
  `us_name` VARCHAR(255) NULL DEFAULT NULL,
  `us_password` VARCHAR(255) NULL DEFAULT NULL,
  `ro_id` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`us_id`),
  INDEX `FKswoqccda8ufyk6j4uvkwc98ss` (`ro_id` ASC) VISIBLE,
  CONSTRAINT `FKswoqccda8ufyk6j4uvkwc98ss`
    FOREIGN KEY (`ro_id`)
    REFERENCES `seveneleven`.`role` (`ro_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
