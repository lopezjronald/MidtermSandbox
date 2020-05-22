-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema morebetterdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `morebetterdb` ;

-- -----------------------------------------------------
-- Schema morebetterdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `morebetterdb` DEFAULT CHARACTER SET utf8 ;
USE `morebetterdb` ;

-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(50) NOT NULL,
  `last_name` VARCHAR(50) NOT NULL,
  `email` VARCHAR(1000) NULL,
  `role` ENUM("STANDARD", "MENTOR", "ADMIN") NOT NULL,
  `age` INT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(200) NOT NULL,
  `enabled` TINYINT NOT NULL DEFAULT 1,
  `picture` VARCHAR(1000) NULL,
  `biography` TEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `category` ;

CREATE TABLE IF NOT EXISTS `category` (
  `id` INT NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `logo` VARCHAR(5000) NULL,
  `description` TEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `address` ;

CREATE TABLE IF NOT EXISTS `address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `street` VARCHAR(100) NULL,
  `city` VARCHAR(45) NULL,
  `state` VARCHAR(45) NULL,
  `zip_code` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `event`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `event` ;

CREATE TABLE IF NOT EXISTS `event` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `category_id` INT NOT NULL,
  `mentor_id` INT NOT NULL,
  `address_id` INT NOT NULL,
  `titile` VARCHAR(100) NOT NULL,
  `description` TEXT NOT NULL,
  `location` VARCHAR(1000) NULL,
  `event_date` DATETIME NULL,
  `max_capacity` INT NULL,
  `price` DECIMAL(4,2) NULL,
  `created_at` DATETIME NULL,
  `last_updated` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_category_id_idx` (`category_id` ASC),
  INDEX `fk_event_user1_idx` (`mentor_id` ASC),
  INDEX `fk_event_address1_idx` (`address_id` ASC),
  CONSTRAINT `fk_category_id`
    FOREIGN KEY (`category_id`)
    REFERENCES `category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_event_user1`
    FOREIGN KEY (`mentor_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_event_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `event_participant`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `event_participant` ;

CREATE TABLE IF NOT EXISTS `event_participant` (
  `user_id` INT NOT NULL,
  `event_id` INT NOT NULL,
  `rating` INT NULL,
  `rating_comment` VARCHAR(45) NULL,
  PRIMARY KEY (`user_id`, `event_id`),
  INDEX `fk_user_has_event_event1_idx` (`event_id` ASC),
  INDEX `fk_user_has_event_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_has_event_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_event_event1`
    FOREIGN KEY (`event_id`)
    REFERENCES `event` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `article`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `article` ;

CREATE TABLE IF NOT EXISTS `article` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `category_id` INT NOT NULL,
  `mentor_id` INT NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `contents` TEXT NOT NULL,
  `created` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_article_category1_idx` (`category_id` ASC),
  INDEX `fk_article_user1_idx` (`mentor_id` ASC),
  CONSTRAINT `fk_article_category1`
    FOREIGN KEY (`category_id`)
    REFERENCES `category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_article_user1`
    FOREIGN KEY (`mentor_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mentor_category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mentor_category` ;

CREATE TABLE IF NOT EXISTS `mentor_category` (
  `user_id` INT NOT NULL,
  `category_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `category_id`),
  INDEX `fk_user_has_category_category1_idx` (`category_id` ASC),
  INDEX `fk_user_has_category_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_has_category_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_category_category1`
    FOREIGN KEY (`category_id`)
    REFERENCES `category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `article_comment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `article_comment` ;

CREATE TABLE IF NOT EXISTS `article_comment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `article_id` INT NOT NULL,
  `content` TEXT NOT NULL,
  `created_at` DATETIME NOT NULL,
  INDEX `fk_article_comment_user1_idx` (`user_id` ASC),
  INDEX `fk_article_comment_article1_idx` (`article_id` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_article_comment_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_article_comment_article1`
    FOREIGN KEY (`article_id`)
    REFERENCES `article` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS morebetteruser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'morebetteruser'@'localhost' IDENTIFIED BY 'morebetter';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'morebetteruser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `morebetterdb`;
INSERT INTO `user` (`id`, `first_name`, `last_name`, `email`, `role`, `age`, `username`, `password`, `enabled`, `picture`, `biography`) VALUES (1, 'Joe', 'Mama', 'joe.mama@user.mail', 'STANDARD', 35, 'joemama', 'joemama', 1, NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `category`
-- -----------------------------------------------------
START TRANSACTION;
USE `morebetterdb`;
INSERT INTO `category` (`id`, `name`, `logo`, `description`) VALUES (1, 'Finance', NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `address`
-- -----------------------------------------------------
START TRANSACTION;
USE `morebetterdb`;
INSERT INTO `address` (`id`, `street`, `city`, `state`, `zip_code`) VALUES (1, NULL, NULL, NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `event`
-- -----------------------------------------------------
START TRANSACTION;
USE `morebetterdb`;
INSERT INTO `event` (`id`, `category_id`, `mentor_id`, `address_id`, `titile`, `description`, `location`, `event_date`, `max_capacity`, `price`, `created_at`, `last_updated`) VALUES (1, 1, 1, 1, 'Why financial literacy matters', 'Financial literacy cannot predict or remedy a crisis, but financial education will play a pivotal role in the economic recovery of our country.', NULL, NULL, NULL, NULL, NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `event_participant`
-- -----------------------------------------------------
START TRANSACTION;
USE `morebetterdb`;
INSERT INTO `event_participant` (`user_id`, `event_id`, `rating`, `rating_comment`) VALUES (1, 1, NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `article`
-- -----------------------------------------------------
START TRANSACTION;
USE `morebetterdb`;
INSERT INTO `article` (`id`, `category_id`, `mentor_id`, `title`, `contents`, `created`) VALUES (1, 1, 1, 'Do you have a long-term plan ', 'Despite the recent recovery in the market, stocks remain down by more than 12% from the February peak, and about 9% year-to-date. Meanwhile, the story for the first three weeks of May has been one of running in place.', '2020-04-10 10:25:30');

COMMIT;


-- -----------------------------------------------------
-- Data for table `article_comment`
-- -----------------------------------------------------
START TRANSACTION;
USE `morebetterdb`;
INSERT INTO `article_comment` (`id`, `user_id`, `article_id`, `content`, `created_at`) VALUES (1, 1, 1, 'Great article', '2020-05-22 11:58:30');

COMMIT;

