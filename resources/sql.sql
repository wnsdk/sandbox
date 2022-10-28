-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema wnsdkweb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema wnsdkweb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `wnsdkweb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `wnsdkweb` ;

-- -----------------------------------------------------
-- Table `wnsdkweb`.`board`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wnsdkweb`.`board` ;

CREATE TABLE IF NOT EXISTS `wnsdkweb`.`board` (
  `article_no` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(16) NULL DEFAULT NULL,
  `user_pwd` VARCHAR(16) NULL DEFAULT NULL,
  `subject` VARCHAR(100) NULL DEFAULT NULL,
  `content` VARCHAR(2000) NULL DEFAULT NULL,
  `hit` INT NULL DEFAULT 0,
  `register_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`article_no`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `wnsdkweb`.`comment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wnsdkweb`.`comment` ;

CREATE TABLE IF NOT EXISTS `wnsdkweb`.`comment` (
  `comment_no` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(16) NULL DEFAULT NULL,
  `comment` VARCHAR(500) NULL DEFAULT NULL,
  `comment_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `article_no` INT NULL DEFAULT NULL,
  PRIMARY KEY (`comment_no`),
  INDEX `comment_to_board_article_no_fk` (`article_no` ASC) VISIBLE,
  CONSTRAINT `comment_to_board_article_no_fk`
    FOREIGN KEY (`article_no`)
    REFERENCES `wnsdkweb`.`board` (`article_no`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;