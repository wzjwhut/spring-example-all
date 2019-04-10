CREATE  SCHEMA IF NOT EXISTS `test` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin ;

CREATE  SCHEMA IF NOT EXISTS `test_0` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin ;
CREATE  SCHEMA IF NOT EXISTS `test_1` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin ;


CREATE TABLE IF NOT EXISTS `test`.`person` (
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`name`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC));


CREATE TABLE IF NOT EXISTS `test_0`.`city` (
  `name` VARCHAR(128) NOT NULL,
  `state` VARCHAR(45) NULL,
  `country` VARCHAR(45) NULL,
  PRIMARY KEY (`name`));

INSERT IGNORE INTO `test_0`.`city` (`name`, `state`, `country`) VALUES ('wzj', 'shanghai', 'cn');


CREATE TABLE IF NOT EXISTS `test_0`.`city_0` (
  `name` VARCHAR(128) NOT NULL,
  `state` VARCHAR(45) NULL,
  `country` VARCHAR(45) NULL,
  PRIMARY KEY (`name`));

INSERT IGNORE INTO `test_0`.`city_0` (`name`, `state`, `country`) VALUES ('wzj', 'shanghai', 'cn');

CREATE TABLE IF NOT EXISTS `test_0`.`city_1` (
  `name` VARCHAR(128) NOT NULL,
  `state` VARCHAR(45) NULL,
  `country` VARCHAR(45) NULL,
  PRIMARY KEY (`name`));

INSERT IGNORE INTO `test_0`.`city_1` (`name`, `state`, `country`) VALUES ('wzj', 'shanghai', 'cn');



CREATE TABLE IF NOT EXISTS `test_1`.`city` (
  `name` VARCHAR(128) NOT NULL,
  `state` VARCHAR(45) NULL,
  `country` VARCHAR(45) NULL,
  PRIMARY KEY (`name`));

INSERT IGNORE INTO `test_1`.`city` (`name`, `state`, `country`) VALUES ('wzj', 'shanghai', 'cn');


CREATE TABLE IF NOT EXISTS `test_1`.`city_0` (
  `name` VARCHAR(128) NOT NULL,
  `state` VARCHAR(45) NULL,
  `country` VARCHAR(45) NULL,
  PRIMARY KEY (`name`));

INSERT IGNORE INTO `test_1`.`city_0` (`name`, `state`, `country`) VALUES ('wzj', 'shanghai', 'cn');

CREATE TABLE IF NOT EXISTS `test_1`.`city_1` (
  `name` VARCHAR(128) NOT NULL,
  `state` VARCHAR(45) NULL,
  `country` VARCHAR(45) NULL,
  PRIMARY KEY (`name`));

INSERT IGNORE INTO `test_1`.`city_1` (`name`, `state`, `country`) VALUES ('wzj', 'shanghai', 'cn');
