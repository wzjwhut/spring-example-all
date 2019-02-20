CREATE TABLE `database1`.`city` (
  `name` VARCHAR(128) NOT NULL,
  `state` VARCHAR(45) NULL,
  `country` VARCHAR(45) NULL,
  PRIMARY KEY (`name`));

INSERT INTO `database1`.`city` (`name`, `state`, `country`) VALUES ('wzj', 'shanghai', 'cn');
