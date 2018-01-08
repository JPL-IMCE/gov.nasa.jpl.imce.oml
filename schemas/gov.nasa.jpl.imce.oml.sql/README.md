# Creating a database using the generated .sql file

## SQL encoding of [OML Schema Tables](https://github.com/JPL-IMCE/gov.nasa.jpl.imce.oml.tables)

There are several well-known patterns for representing inheritance relationships in a relational database
(See Object/Relational Mapping here: https://www.martinfowler.com/eaaCatalog/).

The following is based on the combination of two patterns:
- [Concrete Table Inheritance](https://www.martinfowler.com/eaaCatalog/concreteTableInheritance.html) and
- [Class Table Inheritance](https://www.martinfowler.com/eaaCatalog/classTableInheritance.html)

First, each concrete metaclass in the OML domain maps to a concrete table in SQL per 
the [Concrete Table Inheritance](https://www.martinfowler.com/eaaCatalog/concreteTableInheritance.html) pattern.

Second, since OML makes extensive use of cross-references via abstract metaclasses,
each abstract metaclass in the OML domain maps to an abstract table in SQL
per the [Class Table Inheritance](https://www.martinfowler.com/eaaCatalog/classTableInheritance.html) pattern.

The inheritance relationships among OML's metaclasses are encoded as functional dependency constraints
among the corresponding SQL tables.

Both concrete and abstract tables in SQL use a Version 5 UUID as primary key column.
All cross-references are represented as Version 5 UUID foreign key columns except for OML ModuleEdges whose target module
is referenced by its IRI instead of its Version 5 UUID. However, an OML Module IRI is not a primary key in the SQL schema;
therefore, an OML ModuleEdge target IRI is not an SQL foreign key.

For example, below are the concrete tables for the two concrete kinds of OML `TerminologyBox`: `TerminologyGraph` and `Bundle`:

```
-- -----------------------------------------------------
-- Table `OML`.`TlgyGraphs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`TlgyGraphs` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `kind` INT NOT NULL COMMENT 'TerminologyKind',
  `iri` TEXT NOT NULL COMMENT 'IRI',
  
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table TerminologyGraphs';

-- -----------------------------------------------------
-- Table `OML`.`Bdls`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`Bdls` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `kind` INT NOT NULL COMMENT 'TerminologyKind',
  `iri` TEXT NOT NULL COMMENT 'IRI',
  
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table Bundles';
```

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

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`TlgyGraphs_AFTER_INSERT` AFTER INSERT ON `TlgyGraphs` FOR EACH ROW
BEGIN
-- CrossReferencableKinds(x) if TerminologyGraphs(x)
insert into `OML`.`CRBK`(`uuid`) values(new.`uuid`);
-- CrossReferencabilityKinds(x) if TerminologyGraphs(x)
insert into `OML`.`CRTK`(`uuid`) values(new.`uuid`);
-- IntrinsicIdentityKinds(x) if TerminologyGraphs(x)
insert into `OML`.`IIdK`(`uuid`) values(new.`uuid`);
-- IdentityKinds(x) if TerminologyGraphs(x)
insert into `OML`.`Ik`(`uuid`) values(new.`uuid`);
-- LogicalElements(x) if TerminologyGraphs(x)
insert into `OML`.`LogEs`(`uuid`) values(new.`uuid`);
-- Modules(x) if TerminologyGraphs(x)
insert into `OML`.`Mods`(`uuid`) values(new.`uuid`);
-- Resources(x) if TerminologyGraphs(x)
insert into `OML`.`Ress`(`uuid`) values(new.`uuid`);
-- TerminologyBoxes(x) if TerminologyGraphs(x)
insert into `OML`.`TBox`(`uuid`) values(new.`uuid`);
END$$


-- -----------------------------------------------------
-- Concrete Information Table `OML`.`Bdls` (Bundles)
-- -----------------------------------------------------

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`Bdls_AFTER_INSERT` AFTER INSERT ON `Bdls` FOR EACH ROW
BEGIN
-- CrossReferencableKinds(x) if Bundles(x)
insert into `OML`.`CRBK`(`uuid`) values(new.`uuid`);
-- CrossReferencabilityKinds(x) if Bundles(x)
insert into `OML`.`CRTK`(`uuid`) values(new.`uuid`);
-- IntrinsicIdentityKinds(x) if Bundles(x)
insert into `OML`.`IIdK`(`uuid`) values(new.`uuid`);
-- IdentityKinds(x) if Bundles(x)
insert into `OML`.`Ik`(`uuid`) values(new.`uuid`);
-- LogicalElements(x) if Bundles(x)
insert into `OML`.`LogEs`(`uuid`) values(new.`uuid`);
-- Modules(x) if Bundles(x)
insert into `OML`.`Mods`(`uuid`) values(new.`uuid`);
-- Resources(x) if Bundles(x)
insert into `OML`.`Ress`(`uuid`) values(new.`uuid`);
-- TerminologyBoxes(x) if Bundles(x)
insert into `OML`.`TBox`(`uuid`) values(new.`uuid`);
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

## Limitations of encoding inheritance as functional dependency constraints in SQL

SQL enforces functional dependency constraints on every transaction.
For example, inserting a row in the `OML.Aspects` table results in verifying the `fk_Aspects_tboxUUID` constraint;
that is, verifying that there is a row in the `OML.Tbox` table corresponding to the `tboxUUID`.

Such a row can only exist as a consequence of inserting a row either in the `OML.TlgyGraphs` or `OML.Blds` tables (i.e., TerminologyGraph or Bundle);
which in turn, triggers the insertion into the `OML.Tbox` table.

In practice, this means that it is necessary to define a OML TerminologyGraph or Bundle before one can cross-reference it as an OML TerminologyBox to define an OML Aspect.
Failure to respect this precedence results in runtime SQL errors such as the following:c

````
java.sql.BatchUpdateException: Cannot add or update a child row: a foreign key constraint fails (`oml`.`aspects`, CONSTRAINT `fk_Aspects_tboxUUID` FOREIGN KEY (`tboxUUID`) REFERENCES `TBox` (`uuid`) ON DELETE CASCADE ON UPDATE CASCADE)

Query being executed when exception was thrown:
INSERT INTO OML.Aspects (`uuid`,`tboxUUID`,`name`) VALUES ('f591e13a-028f-516f-a4e9-c84579ea5af6','9514e995-831e-53d6-91da-c243bee6b743','example'))
````

##Using the OML SQL Schema with [MySQL](https://www.mysql.com/)

A simple OML workflow can use a MySQL database either as a source of OML data or
as a sink of OML data or possibly two difference MySQL databases, one as a source and the other as a sink.
Alternatively, complex workflows could involve multiple MySQL databases for different OML sources and sinks.

Therefore, it is important to plan for the possibility of running multiple instances 
of MySQL on the same machine (see https://dev.mysql.com/doc/refman/5.7/en/multiple-servers.html).

Assuming that `mysql` is a command configured for a given MySQL database server, the following prepares the server as a sink for writing OML data in a workflow:

1. `git clone git@github.com:JPL-IMCE/gov.nasa.jpl.imce.oml.git`

2. `cd schemas/gov.nasa.jpl.imce.oml.sql/schema`

3. Run `mysql -u root -p`

4. Enter the MySQL root password.

5. At the `mysql>` prompt, enter the following:

6. `drop database oml`

   This deletes the current OML database, if it exists.
   
7. `source OML.sql`

   This defines an empty OML database.
   
## Reading/Writing OML data from/to SQL

See the [OML Frameless API](https://jpl-imce.github.io/gov.nasa.jpl.imce.oml.frameless/) and 
[OML Converter tool](https://github.com/JPL-IMCE/gov.nasa.jpl.imce.oml.converters).

