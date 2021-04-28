
CREATE SCHEMA IF NOT EXISTS `MonFauna` DEFAULT CHARACTER SET utf8 ;
USE `MonFauna` ;

-- -----------------------------------------------------
-- Table `MonFauna`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MonFauna`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `admin` TINYINT NOT NULL,
  `created_at` DATETIME NOT NULL default now(),
  `updated_at` DATETIME NULL default now(),
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MonFauna`.`Project`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MonFauna`.`project` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `owner_user_id` INT NOT NULL,
  `created_at` DATETIME NOT NULL default now(),
  `updated_at` DATETIME NULL default now(),
  PRIMARY KEY (`id`),
    FOREIGN KEY (`owner_user_id`)
    REFERENCES `MonFauna`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MonFauna`.`Location`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MonFauna`.`location` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `latitude` VARCHAR(255) NULL,
  `longitude` VARCHAR(255) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `MonFauna`.`SpecieType`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MonFauna`.`specie_type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `MonFauna`.`Specie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MonFauna`.`specie` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `scientific_name` VARCHAR(255) NULL,
  `common_name` VARCHAR(255) NOT NULL,
  `created_at` DATETIME NOT NULL default now(),
  `updated_at` DATETIME NULL default now(),
  `specie_type_id` INT NOT NULL,
  PRIMARY KEY (`id`),
    FOREIGN KEY (`specie_type_id`)
    REFERENCES `MonFauna`.`specie_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `MonFauna`.`Animal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MonFauna`.`animal` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `specie_id` INT NOT NULL,
  `number` VARCHAR(45) NULL,
  `sex` VARCHAR(1) NULL,
  `image` VARCHAR(255) NULL,
  `created_at` DATETIME NOT NULL default now(),
  `updated_at` DATETIME NULL default now(),
  `register_date` DATETIME NULL,
  `location_id` INT NOT NULL,
  `project_id` INT NOT NULL,
  PRIMARY KEY (`id`, `project_id`),
    FOREIGN KEY (`location_id`)
    REFERENCES `MonFauna`.`location` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (`specie_id`)
    REFERENCES `MonFauna`.`specie` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (`project_id`)
    REFERENCES `MonFauna`.`project` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MonFauna`.`Animal_measurement`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MonFauna`.`animal_measurement` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `lenght` DOUBLE NULL,
  `width` DOUBLE NULL,
  `height` DOUBLE NULL,
  `weight` DOUBLE NULL,
  `description` VARCHAR(255) NOT NULL,
  `animal_id` INT NOT NULL,
  PRIMARY KEY (`id`, `animal_id`),
    FOREIGN KEY (`animal_id`)
    REFERENCES `MonFauna`.`animal` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MonFauna`.`Collaborator_Project`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MonFauna`.`collaborator_project` (
  `user_id` INT NOT NULL,
  `project_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `project_id`),
    FOREIGN KEY (`user_id`)
    REFERENCES `MonFauna`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (`project_id`)
    REFERENCES `MonFauna`.`project` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


