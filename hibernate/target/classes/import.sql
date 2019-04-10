CREATE  SCHEMA IF NOT EXISTS `test` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin ;

CREATE TABLE `test`.`city` (
  `name` VARCHAR(128) NOT NULL,
  `state` VARCHAR(45) NULL,
  `country` VARCHAR(45) NULL,
  PRIMARY KEY (`name`));

INSERT INTO `test`.`city` (`name`, `state`, `country`) VALUES ('wzj', 'shanghai', 'cn');
