# Creating a database using the generated .sql file

## SQL encoding of [OML Schema Tables](https://github.com/JPL-IMCE/gov.nasa.jpl.imce.oml.tables)

The OML Schema Tables is a 4th normal form relational database schema that consists of 68 concrete tables
organized in a taxonomy with the help of an additional 54 abstract tables.

Each concrete table has exactly 1 primary key, a Version 5 UUID column that is computed from other table columns:
data or Version 5 UUID cross-references.

For example, below are the concrete tables for OML's 2 kinds of `TerminologyBox`:

```
-- -----------------------------------------------------
-- Table `OML`.`TlgyGraphs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`TlgyGraphs` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `kind` TEXT NOT NULL COMMENT 'TerminologyKind',
  `iri` TEXT NOT NULL COMMENT 'IRI',
  
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table TerminologyGraphs';

-- -----------------------------------------------------
-- Table `OML`.`Bdls`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`Bdls` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `kind` TEXT NOT NULL COMMENT 'TerminologyKind',
  `iri` TEXT NOT NULL COMMENT 'IRI',
  
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table Bundles';
```

Each abstract table is defined by the set of columns that are common to all of its direct taxonomic specializations.
This means that each abstract table has, at minimum, 1 column: a Version 5 UUID primary key.
All other columns, if any, are either data or cross-references.

For the SQL encoding, each abstract table has only the common Version 5 UUID primary key.
In SQL, an abstract table corresponds to a functional dependency.

For example, below is the abstract table for OML's `TerminologyBox`:

```
-- -----------------------------------------------------
-- Table `OML`.`TBox`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`TBox` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table TerminologyBoxes';
```

The fact that OML `TerminologyGraph` and OML `Bundle` are a kind of OML `TerminologyBox` is encoded as functional dependency constraints in SQL:

```
-- -----------------------------------------------------
-- Concrete Information Table `OML`.`TlgyGraphs` (TerminologyGraphs)
-- -----------------------------------------------------

-- `OML`.`TBox`(x) iff `OML`.`TlgyGraphs`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`TlgyGraphs_AFTER_INSERT` AFTER INSERT ON `TlgyGraphs` FOR EACH ROW
BEGIN
insert into `OML`.`TBox`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`TlgyGraphs_AFTER_DELETE` AFTER DELETE ON `TlgyGraphs` FOR EACH ROW
BEGIN
delete from `OML`.`TBox`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`Bdls` (Bundles)
-- -----------------------------------------------------

-- `OML`.`TBox`(x) iff `OML`.`Bdls`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`Bdls_AFTER_INSERT` AFTER INSERT ON `Bdls` FOR EACH ROW
BEGIN
insert into `OML`.`TBox`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`Bdls_AFTER_DELETE` AFTER DELETE ON `Bdls` FOR EACH ROW
BEGIN
delete from `OML`.`TBox`;
END$$
```

This encoding is necessary to properly reflect the constraints on OML's Version 5 UUID cross references.
For example, an OML `Aspect` has a cross-reference to an OML `TerminologyBox` where it is defined.
In SQL, this corresponds to the following:

```

-- -----------------------------------------------------
-- Table `OML`.`Aspects`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`Aspects` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `tboxUUID` CHAR(36) NOT NULL COMMENT 'TBox (TerminologyBox)',
  `name` TEXT NOT NULL COMMENT 'LocalName',
  
  CONSTRAINT `fk_Aspects_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TBox`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table Aspects';
```

##Using the MySQL (technically MariaDB) server on the IMCE VM
1. SSH to the IMCE VM
2. Get the .sql file onto the server (git checkout, SCP, etc.)
3. Run `mysql -u root -p`
4. Enter the MySQL root password (be careful!) `imcedev` (LDAP authentication will be implemented at some point)
5. Run `source schema/OML.sql`
6. This will essentially run the lines in the .sql file in order
7. Any errors will be displayed as they occur. Note that valid lines will be executed, even if invalid lines appear later in the file. For example, as long as the `CREATE SCHEMA` line is valid, the database will be created, even if some of the table definitions have errors.
8. To start from scratch, run `DROP DATABASE OML`. Since this is the root account, be very careful not to delete any other databases. 