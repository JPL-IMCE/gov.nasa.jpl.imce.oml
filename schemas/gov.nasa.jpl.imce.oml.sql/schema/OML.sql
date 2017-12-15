--
-- Copyright 2016 California Institute of Technology ("Caltech").
-- U.S. Government sponsorship acknowledged.
--
-- Licensed under the Apache License, Version 2.0 (the "License");
-- you may not use this file except in compliance with the License.
-- You may obtain a copy of the License at
--
--     http://www.apache.org/licenses/LICENSE-2.0
--
-- Unless required by applicable law or agreed to in writing, software
-- distributed under the License is distributed on an "AS IS" BASIS,
-- WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
-- See the License for the specific language governing permissions and
-- limitations under the License.
-- License Terms
--

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';


-- -----------------------------------------------------
-- Schema OML
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `OML` DEFAULT CHARACTER SET utf8 ;
USE `OML` ;

-- -----------------------------------------------------
-- Table `OML`.`AnnotationProperties`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`AnnotationProperties` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `iri`  TEXT,
    `abbrevIRI`  TEXT,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`TerminologyGraphs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`TerminologyGraphs` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `kind`  TEXT,
    `iri`  TEXT,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`Bundles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`Bundles` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `kind`  TEXT,
    `iri`  TEXT,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`ConceptDesignationTerminologyAxioms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ConceptDesignationTerminologyAxioms` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `designatedConceptUUID`  BINARY(16) NOT NULL,
  
    `designatedTerminologyIRI`  VARCHAR(256) NOT NULL
  ,
  CONSTRAINT `fk_ConceptDesignationTerminologyAxioms_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ConceptDesignationTerminologyAxioms_designatedConceptUUID`
    FOREIGN KEY (`designatedConceptUUID`)
    REFERENCES `OML`.`Concepts`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ConceptDesignationTerminologyAxioms_designatedTerminologyIRI`
    FOREIGN KEY (`designatedTerminologyIRI`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`TerminologyExtensionAxioms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`TerminologyExtensionAxioms` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `extendedTerminologyIRI`  VARCHAR(256) NOT NULL
  ,
  CONSTRAINT `fk_TerminologyExtensionAxioms_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_TerminologyExtensionAxioms_extendedTerminologyIRI`
    FOREIGN KEY (`extendedTerminologyIRI`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`TerminologyNestingAxioms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`TerminologyNestingAxioms` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `nestingContextUUID`  BINARY(16) NOT NULL,
  
    `nestingTerminologyIRI`  VARCHAR(256) NOT NULL
  ,
  CONSTRAINT `fk_TerminologyNestingAxioms_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_TerminologyNestingAxioms_nestingContextUUID`
    FOREIGN KEY (`nestingContextUUID`)
    REFERENCES `OML`.`Concepts`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_TerminologyNestingAxioms_nestingTerminologyIRI`
    FOREIGN KEY (`nestingTerminologyIRI`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`Aspects`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`Aspects` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `name`  TEXT,
  CONSTRAINT `fk_Aspects_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`Concepts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`Concepts` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `name`  TEXT,
  CONSTRAINT `fk_Concepts_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`ReifiedRelationships`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ReifiedRelationships` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `sourceUUID`  BINARY(16) NOT NULL,
  
    `targetUUID`  BINARY(16) NOT NULL,
  
    `isAsymmetric`  TEXT,
    `isEssential`  TEXT,
    `isFunctional`  TEXT,
    `isInverseEssential`  TEXT,
    `isInverseFunctional`  TEXT,
    `isIrreflexive`  TEXT,
    `isReflexive`  TEXT,
    `isSymmetric`  TEXT,
    `isTransitive`  TEXT,
    `name`  TEXT,
    `unreifiedPropertyName`  TEXT,
    `unreifiedInversePropertyName`  TEXT,
  CONSTRAINT `fk_ReifiedRelationships_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ReifiedRelationships_sourceUUID`
    FOREIGN KEY (`sourceUUID`)
    REFERENCES `OML`.`Entities`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ReifiedRelationships_targetUUID`
    FOREIGN KEY (`targetUUID`)
    REFERENCES `OML`.`Entities`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`UnreifiedRelationships`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`UnreifiedRelationships` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `sourceUUID`  BINARY(16) NOT NULL,
  
    `targetUUID`  BINARY(16) NOT NULL,
  
    `isAsymmetric`  TEXT,
    `isEssential`  TEXT,
    `isFunctional`  TEXT,
    `isInverseEssential`  TEXT,
    `isInverseFunctional`  TEXT,
    `isIrreflexive`  TEXT,
    `isReflexive`  TEXT,
    `isSymmetric`  TEXT,
    `isTransitive`  TEXT,
    `name`  TEXT,
  CONSTRAINT `fk_UnreifiedRelationships_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_UnreifiedRelationships_sourceUUID`
    FOREIGN KEY (`sourceUUID`)
    REFERENCES `OML`.`Entities`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_UnreifiedRelationships_targetUUID`
    FOREIGN KEY (`targetUUID`)
    REFERENCES `OML`.`Entities`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`Scalars`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`Scalars` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `name`  TEXT,
  CONSTRAINT `fk_Scalars_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`Structures`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`Structures` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `name`  TEXT,
  CONSTRAINT `fk_Structures_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`BinaryScalarRestrictions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`BinaryScalarRestrictions` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `restrictedRangeUUID`  BINARY(16) NOT NULL,
  
    `length`  TEXT,
    `minLength`  TEXT,
    `maxLength`  TEXT,
    `name`  TEXT,
  CONSTRAINT `fk_BinaryScalarRestrictions_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_BinaryScalarRestrictions_restrictedRangeUUID`
    FOREIGN KEY (`restrictedRangeUUID`)
    REFERENCES `OML`.`DataRanges`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`IRIScalarRestrictions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`IRIScalarRestrictions` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `restrictedRangeUUID`  BINARY(16) NOT NULL,
  
    `length`  TEXT,
    `minLength`  TEXT,
    `maxLength`  TEXT,
    `name`  TEXT,
    `pattern`  TEXT,
  CONSTRAINT `fk_IRIScalarRestrictions_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_IRIScalarRestrictions_restrictedRangeUUID`
    FOREIGN KEY (`restrictedRangeUUID`)
    REFERENCES `OML`.`DataRanges`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`NumericScalarRestrictions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`NumericScalarRestrictions` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `restrictedRangeUUID`  BINARY(16) NOT NULL,
  
    `minExclusive`  -- TODO: LiteralFeature
  TEXT, `minExclusiveLiteralType` VARCHAR(20) NOT NULL,
  
    `minInclusive`  -- TODO: LiteralFeature
  TEXT, `minInclusiveLiteralType` VARCHAR(20) NOT NULL,
  
    `maxExclusive`  -- TODO: LiteralFeature
  TEXT, `maxExclusiveLiteralType` VARCHAR(20) NOT NULL,
  
    `maxInclusive`  -- TODO: LiteralFeature
  TEXT, `maxInclusiveLiteralType` VARCHAR(20) NOT NULL,
  
    `name`  TEXT,
  CONSTRAINT `fk_NumericScalarRestrictions_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_NumericScalarRestrictions_restrictedRangeUUID`
    FOREIGN KEY (`restrictedRangeUUID`)
    REFERENCES `OML`.`DataRanges`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_NumericScalarRestrictions_minExclusive`
    FOREIGN KEY (`minExclusive`)
    REFERENCES `OML`.`LiteralNumbers`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_NumericScalarRestrictions_minInclusive`
    FOREIGN KEY (`minInclusive`)
    REFERENCES `OML`.`LiteralNumbers`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_NumericScalarRestrictions_maxExclusive`
    FOREIGN KEY (`maxExclusive`)
    REFERENCES `OML`.`LiteralNumbers`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_NumericScalarRestrictions_maxInclusive`
    FOREIGN KEY (`maxInclusive`)
    REFERENCES `OML`.`LiteralNumbers`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`PlainLiteralScalarRestrictions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`PlainLiteralScalarRestrictions` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `restrictedRangeUUID`  BINARY(16) NOT NULL,
  
    `length`  TEXT,
    `minLength`  TEXT,
    `maxLength`  TEXT,
    `name`  TEXT,
    `langRange`  TEXT,
    `pattern`  TEXT,
  CONSTRAINT `fk_PlainLiteralScalarRestrictions_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_PlainLiteralScalarRestrictions_restrictedRangeUUID`
    FOREIGN KEY (`restrictedRangeUUID`)
    REFERENCES `OML`.`DataRanges`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`ScalarOneOfRestrictions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ScalarOneOfRestrictions` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `restrictedRangeUUID`  BINARY(16) NOT NULL,
  
    `name`  TEXT,
  CONSTRAINT `fk_ScalarOneOfRestrictions_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ScalarOneOfRestrictions_restrictedRangeUUID`
    FOREIGN KEY (`restrictedRangeUUID`)
    REFERENCES `OML`.`DataRanges`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`StringScalarRestrictions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`StringScalarRestrictions` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `restrictedRangeUUID`  BINARY(16) NOT NULL,
  
    `length`  TEXT,
    `minLength`  TEXT,
    `maxLength`  TEXT,
    `name`  TEXT,
    `pattern`  TEXT,
  CONSTRAINT `fk_StringScalarRestrictions_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_StringScalarRestrictions_restrictedRangeUUID`
    FOREIGN KEY (`restrictedRangeUUID`)
    REFERENCES `OML`.`DataRanges`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`SynonymScalarRestrictions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`SynonymScalarRestrictions` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `restrictedRangeUUID`  BINARY(16) NOT NULL,
  
    `name`  TEXT,
  CONSTRAINT `fk_SynonymScalarRestrictions_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SynonymScalarRestrictions_restrictedRangeUUID`
    FOREIGN KEY (`restrictedRangeUUID`)
    REFERENCES `OML`.`DataRanges`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`TimeScalarRestrictions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`TimeScalarRestrictions` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `restrictedRangeUUID`  BINARY(16) NOT NULL,
  
    `minExclusive`  -- TODO: LiteralFeature
  TEXT, `minExclusiveLiteralType` VARCHAR(20) NOT NULL,
  
    `minInclusive`  -- TODO: LiteralFeature
  TEXT, `minInclusiveLiteralType` VARCHAR(20) NOT NULL,
  
    `maxExclusive`  -- TODO: LiteralFeature
  TEXT, `maxExclusiveLiteralType` VARCHAR(20) NOT NULL,
  
    `maxInclusive`  -- TODO: LiteralFeature
  TEXT, `maxInclusiveLiteralType` VARCHAR(20) NOT NULL,
  
    `name`  TEXT,
  CONSTRAINT `fk_TimeScalarRestrictions_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_TimeScalarRestrictions_restrictedRangeUUID`
    FOREIGN KEY (`restrictedRangeUUID`)
    REFERENCES `OML`.`DataRanges`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_TimeScalarRestrictions_minExclusive`
    FOREIGN KEY (`minExclusive`)
    REFERENCES `OML`.`LiteralDateTimes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_TimeScalarRestrictions_minInclusive`
    FOREIGN KEY (`minInclusive`)
    REFERENCES `OML`.`LiteralDateTimes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_TimeScalarRestrictions_maxExclusive`
    FOREIGN KEY (`maxExclusive`)
    REFERENCES `OML`.`LiteralDateTimes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_TimeScalarRestrictions_maxInclusive`
    FOREIGN KEY (`maxInclusive`)
    REFERENCES `OML`.`LiteralDateTimes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`EntityScalarDataProperties`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`EntityScalarDataProperties` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `domainUUID`  BINARY(16) NOT NULL,
  
    `rangeUUID`  BINARY(16) NOT NULL,
  
    `isIdentityCriteria`  TEXT,
    `name`  TEXT,
  CONSTRAINT `fk_EntityScalarDataProperties_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EntityScalarDataProperties_domainUUID`
    FOREIGN KEY (`domainUUID`)
    REFERENCES `OML`.`Entities`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EntityScalarDataProperties_rangeUUID`
    FOREIGN KEY (`rangeUUID`)
    REFERENCES `OML`.`DataRanges`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`EntityStructuredDataProperties`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`EntityStructuredDataProperties` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `domainUUID`  BINARY(16) NOT NULL,
  
    `rangeUUID`  BINARY(16) NOT NULL,
  
    `isIdentityCriteria`  TEXT,
    `name`  TEXT,
  CONSTRAINT `fk_EntityStructuredDataProperties_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EntityStructuredDataProperties_domainUUID`
    FOREIGN KEY (`domainUUID`)
    REFERENCES `OML`.`Entities`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EntityStructuredDataProperties_rangeUUID`
    FOREIGN KEY (`rangeUUID`)
    REFERENCES `OML`.`Structures`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`ScalarDataProperties`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ScalarDataProperties` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `domainUUID`  BINARY(16) NOT NULL,
  
    `rangeUUID`  BINARY(16) NOT NULL,
  
    `name`  TEXT,
  CONSTRAINT `fk_ScalarDataProperties_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ScalarDataProperties_domainUUID`
    FOREIGN KEY (`domainUUID`)
    REFERENCES `OML`.`Structures`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ScalarDataProperties_rangeUUID`
    FOREIGN KEY (`rangeUUID`)
    REFERENCES `OML`.`DataRanges`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`StructuredDataProperties`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`StructuredDataProperties` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `domainUUID`  BINARY(16) NOT NULL,
  
    `rangeUUID`  BINARY(16) NOT NULL,
  
    `name`  TEXT,
  CONSTRAINT `fk_StructuredDataProperties_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_StructuredDataProperties_domainUUID`
    FOREIGN KEY (`domainUUID`)
    REFERENCES `OML`.`Structures`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_StructuredDataProperties_rangeUUID`
    FOREIGN KEY (`rangeUUID`)
    REFERENCES `OML`.`Structures`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`AspectSpecializationAxioms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`AspectSpecializationAxioms` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `superAspectUUID`  BINARY(16) NOT NULL,
  
    `subEntityUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_AspectSpecializationAxioms_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_AspectSpecializationAxioms_superAspectUUID`
    FOREIGN KEY (`superAspectUUID`)
    REFERENCES `OML`.`Aspects`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_AspectSpecializationAxioms_subEntityUUID`
    FOREIGN KEY (`subEntityUUID`)
    REFERENCES `OML`.`Entities`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`ConceptSpecializationAxioms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ConceptSpecializationAxioms` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `superConceptUUID`  BINARY(16) NOT NULL,
  
    `subConceptUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_ConceptSpecializationAxioms_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ConceptSpecializationAxioms_superConceptUUID`
    FOREIGN KEY (`superConceptUUID`)
    REFERENCES `OML`.`Concepts`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ConceptSpecializationAxioms_subConceptUUID`
    FOREIGN KEY (`subConceptUUID`)
    REFERENCES `OML`.`Concepts`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`ReifiedRelationshipSpecializationAxioms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ReifiedRelationshipSpecializationAxioms` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `superRelationshipUUID`  BINARY(16) NOT NULL,
  
    `subRelationshipUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_ReifiedRelationshipSpecializationAxioms_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ReifiedRelationshipSpecializationAxioms_superRelationshipUUID`
    FOREIGN KEY (`superRelationshipUUID`)
    REFERENCES `OML`.`ReifiedRelationships`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ReifiedRelationshipSpecializationAxioms_subRelationshipUUID`
    FOREIGN KEY (`subRelationshipUUID`)
    REFERENCES `OML`.`ReifiedRelationships`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`EntityExistentialRestrictionAxioms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`EntityExistentialRestrictionAxioms` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `restrictedRelationUUID`  BINARY(16) NOT NULL,
  
    `restrictedDomainUUID`  BINARY(16) NOT NULL,
  
    `restrictedRangeUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_EntityExistentialRestrictionAxioms_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EntityExistentialRestrictionAxioms_restrictedRelationUUID`
    FOREIGN KEY (`restrictedRelationUUID`)
    REFERENCES `OML`.`EntityRelationships`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EntityExistentialRestrictionAxioms_restrictedDomainUUID`
    FOREIGN KEY (`restrictedDomainUUID`)
    REFERENCES `OML`.`Entities`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EntityExistentialRestrictionAxioms_restrictedRangeUUID`
    FOREIGN KEY (`restrictedRangeUUID`)
    REFERENCES `OML`.`Entities`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`EntityUniversalRestrictionAxioms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`EntityUniversalRestrictionAxioms` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `restrictedRelationUUID`  BINARY(16) NOT NULL,
  
    `restrictedDomainUUID`  BINARY(16) NOT NULL,
  
    `restrictedRangeUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_EntityUniversalRestrictionAxioms_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EntityUniversalRestrictionAxioms_restrictedRelationUUID`
    FOREIGN KEY (`restrictedRelationUUID`)
    REFERENCES `OML`.`EntityRelationships`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EntityUniversalRestrictionAxioms_restrictedDomainUUID`
    FOREIGN KEY (`restrictedDomainUUID`)
    REFERENCES `OML`.`Entities`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EntityUniversalRestrictionAxioms_restrictedRangeUUID`
    FOREIGN KEY (`restrictedRangeUUID`)
    REFERENCES `OML`.`Entities`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`EntityScalarDataPropertyExistentialRestrictionAxioms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`EntityScalarDataPropertyExistentialRestrictionAxioms` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `restrictedEntityUUID`  BINARY(16) NOT NULL,
  
    `scalarPropertyUUID`  BINARY(16) NOT NULL,
  
    `scalarRestrictionUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_EntityScalarDataPropertyExistentialRestrictionAxioms_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EntityScalarDataPropertyExistentialRestrictionAxioms_restrictedEntityUUID`
    FOREIGN KEY (`restrictedEntityUUID`)
    REFERENCES `OML`.`Entities`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EntityScalarDataPropertyExistentialRestrictionAxioms_scalarPropertyUUID`
    FOREIGN KEY (`scalarPropertyUUID`)
    REFERENCES `OML`.`EntityScalarDataProperties`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EntityScalarDataPropertyExistentialRestrictionAxioms_scalarRestrictionUUID`
    FOREIGN KEY (`scalarRestrictionUUID`)
    REFERENCES `OML`.`DataRanges`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`EntityScalarDataPropertyParticularRestrictionAxioms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`EntityScalarDataPropertyParticularRestrictionAxioms` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `restrictedEntityUUID`  BINARY(16) NOT NULL,
  
    `scalarPropertyUUID`  BINARY(16) NOT NULL,
  
    `literalValue`  -- TODO: LiteralFeature
  TEXT, `literalValueLiteralType` VARCHAR(20) NOT NULL,
  
    `valueTypeUUID`  BINARY(16) NULL
  ,
  CONSTRAINT `fk_EntityScalarDataPropertyParticularRestrictionAxioms_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EntityScalarDataPropertyParticularRestrictionAxioms_restrictedEntityUUID`
    FOREIGN KEY (`restrictedEntityUUID`)
    REFERENCES `OML`.`Entities`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EntityScalarDataPropertyParticularRestrictionAxioms_scalarPropertyUUID`
    FOREIGN KEY (`scalarPropertyUUID`)
    REFERENCES `OML`.`EntityScalarDataProperties`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EntityScalarDataPropertyParticularRestrictionAxioms_literalValue`
    FOREIGN KEY (`literalValue`)
    REFERENCES `OML`.`LiteralValues`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EntityScalarDataPropertyParticularRestrictionAxioms_valueTypeUUID`
    FOREIGN KEY (`valueTypeUUID`)
    REFERENCES `OML`.`DataRanges`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`EntityScalarDataPropertyUniversalRestrictionAxioms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`EntityScalarDataPropertyUniversalRestrictionAxioms` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `restrictedEntityUUID`  BINARY(16) NOT NULL,
  
    `scalarPropertyUUID`  BINARY(16) NOT NULL,
  
    `scalarRestrictionUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_EntityScalarDataPropertyUniversalRestrictionAxioms_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EntityScalarDataPropertyUniversalRestrictionAxioms_restrictedEntityUUID`
    FOREIGN KEY (`restrictedEntityUUID`)
    REFERENCES `OML`.`Entities`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EntityScalarDataPropertyUniversalRestrictionAxioms_scalarPropertyUUID`
    FOREIGN KEY (`scalarPropertyUUID`)
    REFERENCES `OML`.`EntityScalarDataProperties`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EntityScalarDataPropertyUniversalRestrictionAxioms_scalarRestrictionUUID`
    FOREIGN KEY (`scalarRestrictionUUID`)
    REFERENCES `OML`.`DataRanges`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`ScalarOneOfLiteralAxioms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ScalarOneOfLiteralAxioms` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `axiomUUID`  BINARY(16) NOT NULL,
  
    `value`  -- TODO: LiteralFeature
  TEXT, `valueLiteralType` VARCHAR(20) NOT NULL,
  
    `valueTypeUUID`  BINARY(16) NULL
  ,
  CONSTRAINT `fk_ScalarOneOfLiteralAxioms_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ScalarOneOfLiteralAxioms_axiomUUID`
    FOREIGN KEY (`axiomUUID`)
    REFERENCES `OML`.`ScalarOneOfRestrictions`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ScalarOneOfLiteralAxioms_value`
    FOREIGN KEY (`value`)
    REFERENCES `OML`.`LiteralValues`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ScalarOneOfLiteralAxioms_valueTypeUUID`
    FOREIGN KEY (`valueTypeUUID`)
    REFERENCES `OML`.`DataRanges`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`BundledTerminologyAxioms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`BundledTerminologyAxioms` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `bundleUUID`  BINARY(16) NOT NULL,
  
    `bundledTerminologyIRI`  VARCHAR(256) NOT NULL
  ,
  CONSTRAINT `fk_BundledTerminologyAxioms_bundleUUID`
    FOREIGN KEY (`bundleUUID`)
    REFERENCES `OML`.`Bundles`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_BundledTerminologyAxioms_bundledTerminologyIRI`
    FOREIGN KEY (`bundledTerminologyIRI`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`RootConceptTaxonomyAxioms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`RootConceptTaxonomyAxioms` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `bundleUUID`  BINARY(16) NOT NULL,
  
    `rootUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_RootConceptTaxonomyAxioms_bundleUUID`
    FOREIGN KEY (`bundleUUID`)
    REFERENCES `OML`.`Bundles`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RootConceptTaxonomyAxioms_rootUUID`
    FOREIGN KEY (`rootUUID`)
    REFERENCES `OML`.`Concepts`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`SpecificDisjointConceptAxioms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`SpecificDisjointConceptAxioms` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `disjointTaxonomyParentUUID`  BINARY(16) NOT NULL,
  
    `disjointLeafUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_SpecificDisjointConceptAxioms_disjointTaxonomyParentUUID`
    FOREIGN KEY (`disjointTaxonomyParentUUID`)
    REFERENCES `OML`.`ConceptTreeDisjunctions`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SpecificDisjointConceptAxioms_disjointLeafUUID`
    FOREIGN KEY (`disjointLeafUUID`)
    REFERENCES `OML`.`Concepts`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`AnnotationPropertyValues`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`AnnotationPropertyValues` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `subjectUUID`  BINARY(16) NOT NULL,
  
    `propertyUUID`  BINARY(16) NOT NULL,
  
    `value`  -- TODO: LiteralFeature
  TEXT, `valueLiteralType` VARCHAR(20) NOT NULL
  ,
  CONSTRAINT `fk_AnnotationPropertyValues_subjectUUID`
    FOREIGN KEY (`subjectUUID`)
    REFERENCES `OML`.`LogicalElements`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_AnnotationPropertyValues_propertyUUID`
    FOREIGN KEY (`propertyUUID`)
    REFERENCES `OML`.`AnnotationProperties`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_AnnotationPropertyValues_value`
    FOREIGN KEY (`value`)
    REFERENCES `OML`.`LiteralStrings`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`AnonymousConceptUnionAxioms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`AnonymousConceptUnionAxioms` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `disjointTaxonomyParentUUID`  BINARY(16) NOT NULL,
  
    `name`  TEXT,
  CONSTRAINT `fk_AnonymousConceptUnionAxioms_disjointTaxonomyParentUUID`
    FOREIGN KEY (`disjointTaxonomyParentUUID`)
    REFERENCES `OML`.`ConceptTreeDisjunctions`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`AspectPredicates`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`AspectPredicates` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `aspectUUID`  BINARY(16) NOT NULL,
  
    `bodySegmentUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_AspectPredicates_aspectUUID`
    FOREIGN KEY (`aspectUUID`)
    REFERENCES `OML`.`Aspects`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_AspectPredicates_bodySegmentUUID`
    FOREIGN KEY (`bodySegmentUUID`)
    REFERENCES `OML`.`RuleBodySegments`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`ChainRules`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ChainRules` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `name`  TEXT,
    `headUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_ChainRules_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ChainRules_headUUID`
    FOREIGN KEY (`headUUID`)
    REFERENCES `OML`.`UnreifiedRelationships`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`ConceptInstances`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ConceptInstances` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `descriptionBoxUUID`  BINARY(16) NOT NULL,
  
    `singletonConceptClassifierUUID`  BINARY(16) NOT NULL,
  
    `name`  TEXT,
  CONSTRAINT `fk_ConceptInstances_descriptionBoxUUID`
    FOREIGN KEY (`descriptionBoxUUID`)
    REFERENCES `OML`.`DescriptionBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ConceptInstances_singletonConceptClassifierUUID`
    FOREIGN KEY (`singletonConceptClassifierUUID`)
    REFERENCES `OML`.`Concepts`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`ConceptPredicates`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ConceptPredicates` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `bodySegmentUUID`  BINARY(16) NOT NULL,
  
    `conceptUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_ConceptPredicates_bodySegmentUUID`
    FOREIGN KEY (`bodySegmentUUID`)
    REFERENCES `OML`.`RuleBodySegments`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ConceptPredicates_conceptUUID`
    FOREIGN KEY (`conceptUUID`)
    REFERENCES `OML`.`Concepts`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`DescriptionBoxes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`DescriptionBoxes` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `kind`  TEXT,
    `iri`  TEXT,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`DescriptionBoxExtendsClosedWorldDefinitions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`DescriptionBoxExtendsClosedWorldDefinitions` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `descriptionBoxUUID`  BINARY(16) NOT NULL,
  
    `closedWorldDefinitionsIRI`  VARCHAR(256) NOT NULL
  ,
  CONSTRAINT `fk_DescriptionBoxExtendsClosedWorldDefinitions_descriptionBoxUUID`
    FOREIGN KEY (`descriptionBoxUUID`)
    REFERENCES `OML`.`DescriptionBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_DescriptionBoxExtendsClosedWorldDefinitions_closedWorldDefinitionsIRI`
    FOREIGN KEY (`closedWorldDefinitionsIRI`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`DescriptionBoxRefinements`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`DescriptionBoxRefinements` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `refiningDescriptionBoxUUID`  BINARY(16) NOT NULL,
  
    `refinedDescriptionBoxIRI`  VARCHAR(256) NOT NULL
  ,
  CONSTRAINT `fk_DescriptionBoxRefinements_refiningDescriptionBoxUUID`
    FOREIGN KEY (`refiningDescriptionBoxUUID`)
    REFERENCES `OML`.`DescriptionBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_DescriptionBoxRefinements_refinedDescriptionBoxIRI`
    FOREIGN KEY (`refinedDescriptionBoxIRI`)
    REFERENCES `OML`.`DescriptionBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`EntityStructuredDataPropertyParticularRestrictionAxioms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`EntityStructuredDataPropertyParticularRestrictionAxioms` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `structuredDataPropertyUUID`  BINARY(16) NOT NULL,
  
    `restrictedEntityUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_EntityStructuredDataPropertyParticularRestrictionAxioms_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EntityStructuredDataPropertyParticularRestrictionAxioms_structuredDataPropertyUUID`
    FOREIGN KEY (`structuredDataPropertyUUID`)
    REFERENCES `OML`.`DataRelationshipToStructures`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EntityStructuredDataPropertyParticularRestrictionAxioms_restrictedEntityUUID`
    FOREIGN KEY (`restrictedEntityUUID`)
    REFERENCES `OML`.`Entities`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`ReifiedRelationshipInstances`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ReifiedRelationshipInstances` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `descriptionBoxUUID`  BINARY(16) NOT NULL,
  
    `singletonReifiedRelationshipClassifierUUID`  BINARY(16) NOT NULL,
  
    `name`  TEXT,
  CONSTRAINT `fk_ReifiedRelationshipInstances_descriptionBoxUUID`
    FOREIGN KEY (`descriptionBoxUUID`)
    REFERENCES `OML`.`DescriptionBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ReifiedRelationshipInstances_singletonReifiedRelationshipClassifierUUID`
    FOREIGN KEY (`singletonReifiedRelationshipClassifierUUID`)
    REFERENCES `OML`.`ReifiedRelationships`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`ReifiedRelationshipInstanceDomains`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ReifiedRelationshipInstanceDomains` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `descriptionBoxUUID`  BINARY(16) NOT NULL,
  
    `reifiedRelationshipInstanceUUID`  BINARY(16) NOT NULL,
  
    `domainUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_ReifiedRelationshipInstanceDomains_descriptionBoxUUID`
    FOREIGN KEY (`descriptionBoxUUID`)
    REFERENCES `OML`.`DescriptionBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ReifiedRelationshipInstanceDomains_reifiedRelationshipInstanceUUID`
    FOREIGN KEY (`reifiedRelationshipInstanceUUID`)
    REFERENCES `OML`.`ReifiedRelationshipInstances`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ReifiedRelationshipInstanceDomains_domainUUID`
    FOREIGN KEY (`domainUUID`)
    REFERENCES `OML`.`ConceptualEntitySingletonInstances`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`ReifiedRelationshipInstanceRanges`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ReifiedRelationshipInstanceRanges` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `descriptionBoxUUID`  BINARY(16) NOT NULL,
  
    `reifiedRelationshipInstanceUUID`  BINARY(16) NOT NULL,
  
    `rangeUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_ReifiedRelationshipInstanceRanges_descriptionBoxUUID`
    FOREIGN KEY (`descriptionBoxUUID`)
    REFERENCES `OML`.`DescriptionBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ReifiedRelationshipInstanceRanges_reifiedRelationshipInstanceUUID`
    FOREIGN KEY (`reifiedRelationshipInstanceUUID`)
    REFERENCES `OML`.`ReifiedRelationshipInstances`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ReifiedRelationshipInstanceRanges_rangeUUID`
    FOREIGN KEY (`rangeUUID`)
    REFERENCES `OML`.`ConceptualEntitySingletonInstances`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`ReifiedRelationshipInversePropertyPredicates`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ReifiedRelationshipInversePropertyPredicates` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `bodySegmentUUID`  BINARY(16) NOT NULL,
  
    `reifiedRelationshipUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_ReifiedRelationshipInversePropertyPredicates_bodySegmentUUID`
    FOREIGN KEY (`bodySegmentUUID`)
    REFERENCES `OML`.`RuleBodySegments`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ReifiedRelationshipInversePropertyPredicates_reifiedRelationshipUUID`
    FOREIGN KEY (`reifiedRelationshipUUID`)
    REFERENCES `OML`.`ReifiedRelationships`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`ReifiedRelationshipPredicates`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ReifiedRelationshipPredicates` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `bodySegmentUUID`  BINARY(16) NOT NULL,
  
    `reifiedRelationshipUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_ReifiedRelationshipPredicates_bodySegmentUUID`
    FOREIGN KEY (`bodySegmentUUID`)
    REFERENCES `OML`.`RuleBodySegments`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ReifiedRelationshipPredicates_reifiedRelationshipUUID`
    FOREIGN KEY (`reifiedRelationshipUUID`)
    REFERENCES `OML`.`ReifiedRelationships`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`ReifiedRelationshipPropertyPredicates`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ReifiedRelationshipPropertyPredicates` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `bodySegmentUUID`  BINARY(16) NOT NULL,
  
    `reifiedRelationshipUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_ReifiedRelationshipPropertyPredicates_bodySegmentUUID`
    FOREIGN KEY (`bodySegmentUUID`)
    REFERENCES `OML`.`RuleBodySegments`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ReifiedRelationshipPropertyPredicates_reifiedRelationshipUUID`
    FOREIGN KEY (`reifiedRelationshipUUID`)
    REFERENCES `OML`.`ReifiedRelationships`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`ReifiedRelationshipSourceInversePropertyPredicates`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ReifiedRelationshipSourceInversePropertyPredicates` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `bodySegmentUUID`  BINARY(16) NOT NULL,
  
    `reifiedRelationshipUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_ReifiedRelationshipSourceInversePropertyPredicates_bodySegmentUUID`
    FOREIGN KEY (`bodySegmentUUID`)
    REFERENCES `OML`.`RuleBodySegments`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ReifiedRelationshipSourceInversePropertyPredicates_reifiedRelationshipUUID`
    FOREIGN KEY (`reifiedRelationshipUUID`)
    REFERENCES `OML`.`ReifiedRelationships`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`ReifiedRelationshipSourcePropertyPredicates`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ReifiedRelationshipSourcePropertyPredicates` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `bodySegmentUUID`  BINARY(16) NOT NULL,
  
    `reifiedRelationshipUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_ReifiedRelationshipSourcePropertyPredicates_bodySegmentUUID`
    FOREIGN KEY (`bodySegmentUUID`)
    REFERENCES `OML`.`RuleBodySegments`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ReifiedRelationshipSourcePropertyPredicates_reifiedRelationshipUUID`
    FOREIGN KEY (`reifiedRelationshipUUID`)
    REFERENCES `OML`.`ReifiedRelationships`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`ReifiedRelationshipTargetInversePropertyPredicates`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ReifiedRelationshipTargetInversePropertyPredicates` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `bodySegmentUUID`  BINARY(16) NOT NULL,
  
    `reifiedRelationshipUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_ReifiedRelationshipTargetInversePropertyPredicates_bodySegmentUUID`
    FOREIGN KEY (`bodySegmentUUID`)
    REFERENCES `OML`.`RuleBodySegments`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ReifiedRelationshipTargetInversePropertyPredicates_reifiedRelationshipUUID`
    FOREIGN KEY (`reifiedRelationshipUUID`)
    REFERENCES `OML`.`ReifiedRelationships`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`ReifiedRelationshipTargetPropertyPredicates`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ReifiedRelationshipTargetPropertyPredicates` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `bodySegmentUUID`  BINARY(16) NOT NULL,
  
    `reifiedRelationshipUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_ReifiedRelationshipTargetPropertyPredicates_bodySegmentUUID`
    FOREIGN KEY (`bodySegmentUUID`)
    REFERENCES `OML`.`RuleBodySegments`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ReifiedRelationshipTargetPropertyPredicates_reifiedRelationshipUUID`
    FOREIGN KEY (`reifiedRelationshipUUID`)
    REFERENCES `OML`.`ReifiedRelationships`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`RestrictionScalarDataPropertyValues`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`RestrictionScalarDataPropertyValues` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `scalarDataPropertyUUID`  BINARY(16) NOT NULL,
  
    `scalarPropertyValue`  -- TODO: LiteralFeature
  TEXT, `scalarPropertyValueLiteralType` VARCHAR(20) NOT NULL,
  
    `structuredDataPropertyContextUUID`  BINARY(16) NOT NULL,
  
    `valueTypeUUID`  BINARY(16) NULL
  ,
  CONSTRAINT `fk_RestrictionScalarDataPropertyValues_scalarDataPropertyUUID`
    FOREIGN KEY (`scalarDataPropertyUUID`)
    REFERENCES `OML`.`DataRelationshipToScalars`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RestrictionScalarDataPropertyValues_scalarPropertyValue`
    FOREIGN KEY (`scalarPropertyValue`)
    REFERENCES `OML`.`LiteralValues`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RestrictionScalarDataPropertyValues_structuredDataPropertyContextUUID`
    FOREIGN KEY (`structuredDataPropertyContextUUID`)
    REFERENCES `OML`.`RestrictionStructuredDataPropertyContexts`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RestrictionScalarDataPropertyValues_valueTypeUUID`
    FOREIGN KEY (`valueTypeUUID`)
    REFERENCES `OML`.`DataRanges`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`RestrictionStructuredDataPropertyTuples`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`RestrictionStructuredDataPropertyTuples` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `structuredDataPropertyUUID`  BINARY(16) NOT NULL,
  
    `structuredDataPropertyContextUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_RestrictionStructuredDataPropertyTuples_structuredDataPropertyUUID`
    FOREIGN KEY (`structuredDataPropertyUUID`)
    REFERENCES `OML`.`DataRelationshipToStructures`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RestrictionStructuredDataPropertyTuples_structuredDataPropertyContextUUID`
    FOREIGN KEY (`structuredDataPropertyContextUUID`)
    REFERENCES `OML`.`RestrictionStructuredDataPropertyContexts`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`RuleBodySegments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`RuleBodySegments` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `previousSegmentUUID`  BINARY(16) NULL,
  
    `ruleUUID`  BINARY(16) NULL
  ,
  CONSTRAINT `fk_RuleBodySegments_previousSegmentUUID`
    FOREIGN KEY (`previousSegmentUUID`)
    REFERENCES `OML`.`RuleBodySegments`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RuleBodySegments_ruleUUID`
    FOREIGN KEY (`ruleUUID`)
    REFERENCES `OML`.`ChainRules`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`ScalarDataPropertyValues`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ScalarDataPropertyValues` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `scalarDataPropertyUUID`  BINARY(16) NOT NULL,
  
    `scalarPropertyValue`  -- TODO: LiteralFeature
  TEXT, `scalarPropertyValueLiteralType` VARCHAR(20) NOT NULL,
  
    `structuredDataPropertyContextUUID`  BINARY(16) NOT NULL,
  
    `valueTypeUUID`  BINARY(16) NULL
  ,
  CONSTRAINT `fk_ScalarDataPropertyValues_scalarDataPropertyUUID`
    FOREIGN KEY (`scalarDataPropertyUUID`)
    REFERENCES `OML`.`DataRelationshipToScalars`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ScalarDataPropertyValues_scalarPropertyValue`
    FOREIGN KEY (`scalarPropertyValue`)
    REFERENCES `OML`.`LiteralValues`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ScalarDataPropertyValues_structuredDataPropertyContextUUID`
    FOREIGN KEY (`structuredDataPropertyContextUUID`)
    REFERENCES `OML`.`SingletonInstanceStructuredDataPropertyContexts`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ScalarDataPropertyValues_valueTypeUUID`
    FOREIGN KEY (`valueTypeUUID`)
    REFERENCES `OML`.`DataRanges`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`SingletonInstanceScalarDataPropertyValues`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`SingletonInstanceScalarDataPropertyValues` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `descriptionBoxUUID`  BINARY(16) NOT NULL,
  
    `singletonInstanceUUID`  BINARY(16) NOT NULL,
  
    `scalarDataPropertyUUID`  BINARY(16) NOT NULL,
  
    `scalarPropertyValue`  -- TODO: LiteralFeature
  TEXT, `scalarPropertyValueLiteralType` VARCHAR(20) NOT NULL,
  
    `valueTypeUUID`  BINARY(16) NULL
  ,
  CONSTRAINT `fk_SingletonInstanceScalarDataPropertyValues_descriptionBoxUUID`
    FOREIGN KEY (`descriptionBoxUUID`)
    REFERENCES `OML`.`DescriptionBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SingletonInstanceScalarDataPropertyValues_singletonInstanceUUID`
    FOREIGN KEY (`singletonInstanceUUID`)
    REFERENCES `OML`.`ConceptualEntitySingletonInstances`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SingletonInstanceScalarDataPropertyValues_scalarDataPropertyUUID`
    FOREIGN KEY (`scalarDataPropertyUUID`)
    REFERENCES `OML`.`EntityScalarDataProperties`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SingletonInstanceScalarDataPropertyValues_scalarPropertyValue`
    FOREIGN KEY (`scalarPropertyValue`)
    REFERENCES `OML`.`LiteralValues`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SingletonInstanceScalarDataPropertyValues_valueTypeUUID`
    FOREIGN KEY (`valueTypeUUID`)
    REFERENCES `OML`.`DataRanges`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`SingletonInstanceStructuredDataPropertyValues`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`SingletonInstanceStructuredDataPropertyValues` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `descriptionBoxUUID`  BINARY(16) NOT NULL,
  
    `singletonInstanceUUID`  BINARY(16) NOT NULL,
  
    `structuredDataPropertyUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_SingletonInstanceStructuredDataPropertyValues_descriptionBoxUUID`
    FOREIGN KEY (`descriptionBoxUUID`)
    REFERENCES `OML`.`DescriptionBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SingletonInstanceStructuredDataPropertyValues_singletonInstanceUUID`
    FOREIGN KEY (`singletonInstanceUUID`)
    REFERENCES `OML`.`ConceptualEntitySingletonInstances`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SingletonInstanceStructuredDataPropertyValues_structuredDataPropertyUUID`
    FOREIGN KEY (`structuredDataPropertyUUID`)
    REFERENCES `OML`.`DataRelationshipToStructures`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`StructuredDataPropertyTuples`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`StructuredDataPropertyTuples` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `structuredDataPropertyUUID`  BINARY(16) NOT NULL,
  
    `structuredDataPropertyContextUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_StructuredDataPropertyTuples_structuredDataPropertyUUID`
    FOREIGN KEY (`structuredDataPropertyUUID`)
    REFERENCES `OML`.`DataRelationshipToStructures`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_StructuredDataPropertyTuples_structuredDataPropertyContextUUID`
    FOREIGN KEY (`structuredDataPropertyContextUUID`)
    REFERENCES `OML`.`SingletonInstanceStructuredDataPropertyContexts`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`SubDataPropertyOfAxioms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`SubDataPropertyOfAxioms` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `subPropertyUUID`  BINARY(16) NOT NULL,
  
    `superPropertyUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_SubDataPropertyOfAxioms_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SubDataPropertyOfAxioms_subPropertyUUID`
    FOREIGN KEY (`subPropertyUUID`)
    REFERENCES `OML`.`EntityScalarDataProperties`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SubDataPropertyOfAxioms_superPropertyUUID`
    FOREIGN KEY (`superPropertyUUID`)
    REFERENCES `OML`.`EntityScalarDataProperties`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`SubObjectPropertyOfAxioms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`SubObjectPropertyOfAxioms` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `subPropertyUUID`  BINARY(16) NOT NULL,
  
    `superPropertyUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_SubObjectPropertyOfAxioms_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SubObjectPropertyOfAxioms_subPropertyUUID`
    FOREIGN KEY (`subPropertyUUID`)
    REFERENCES `OML`.`UnreifiedRelationships`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SubObjectPropertyOfAxioms_superPropertyUUID`
    FOREIGN KEY (`superPropertyUUID`)
    REFERENCES `OML`.`UnreifiedRelationships`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`UnreifiedRelationshipInstanceTuples`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`UnreifiedRelationshipInstanceTuples` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `descriptionBoxUUID`  BINARY(16) NOT NULL,
  
    `unreifiedRelationshipUUID`  BINARY(16) NOT NULL,
  
    `domainUUID`  BINARY(16) NOT NULL,
  
    `rangeUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_UnreifiedRelationshipInstanceTuples_descriptionBoxUUID`
    FOREIGN KEY (`descriptionBoxUUID`)
    REFERENCES `OML`.`DescriptionBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_UnreifiedRelationshipInstanceTuples_unreifiedRelationshipUUID`
    FOREIGN KEY (`unreifiedRelationshipUUID`)
    REFERENCES `OML`.`UnreifiedRelationships`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_UnreifiedRelationshipInstanceTuples_domainUUID`
    FOREIGN KEY (`domainUUID`)
    REFERENCES `OML`.`ConceptualEntitySingletonInstances`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_UnreifiedRelationshipInstanceTuples_rangeUUID`
    FOREIGN KEY (`rangeUUID`)
    REFERENCES `OML`.`ConceptualEntitySingletonInstances`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`UnreifiedRelationshipInversePropertyPredicates`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`UnreifiedRelationshipInversePropertyPredicates` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `unreifiedRelationshipUUID`  BINARY(16) NOT NULL,
  
    `bodySegmentUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_UnreifiedRelationshipInversePropertyPredicates_unreifiedRelationshipUUID`
    FOREIGN KEY (`unreifiedRelationshipUUID`)
    REFERENCES `OML`.`UnreifiedRelationships`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_UnreifiedRelationshipInversePropertyPredicates_bodySegmentUUID`
    FOREIGN KEY (`bodySegmentUUID`)
    REFERENCES `OML`.`RuleBodySegments`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Table `OML`.`UnreifiedRelationshipPropertyPredicates`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`UnreifiedRelationshipPropertyPredicates` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `unreifiedRelationshipUUID`  BINARY(16) NOT NULL,
  
    `bodySegmentUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_UnreifiedRelationshipPropertyPredicates_unreifiedRelationshipUUID`
    FOREIGN KEY (`unreifiedRelationshipUUID`)
    REFERENCES `OML`.`UnreifiedRelationships`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_UnreifiedRelationshipPropertyPredicates_bodySegmentUUID`
    FOREIGN KEY (`bodySegmentUUID`)
    REFERENCES `OML`.`RuleBodySegments`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
  		  

