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
)
  
-- -----------------------------------------------------
-- Table `OML`.`TerminologyGraphs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`TerminologyGraphs` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `kind`  TEXT,
    `iri`  TEXT,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`Bundles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`Bundles` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `kind`  TEXT,
    `iri`  TEXT,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`ConceptDesignationTerminologyAxioms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ConceptDesignationTerminologyAxioms` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `designatedConceptUUID`  BINARY(16) NOT NULL,
  
    `designatedTerminologyIRI`  VARCHAR(256) NOT NULL
  ,
  CONSTRAINT `fk_ConceptDesignationTerminologyAxioms_tboxUUID_TerminologyBoxes`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ConceptDesignationTerminologyAxioms_designatedConceptUUID_Concepts`
    FOREIGN KEY (`designatedConceptUUID`)
    REFERENCES `OML`.`Concepts`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ConceptDesignationTerminologyAxioms_designatedTerminologyIRI_TerminologyBoxes`
    FOREIGN KEY (`designatedTerminologyIRI`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`TerminologyExtensionAxioms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`TerminologyExtensionAxioms` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `extendedTerminologyIRI`  VARCHAR(256) NOT NULL
  ,
  CONSTRAINT `fk_TerminologyExtensionAxioms_tboxUUID_TerminologyBoxes`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_TerminologyExtensionAxioms_extendedTerminologyIRI_TerminologyBoxes`
    FOREIGN KEY (`extendedTerminologyIRI`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`TerminologyNestingAxioms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`TerminologyNestingAxioms` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `nestingContextUUID`  BINARY(16) NOT NULL,
  
    `nestingTerminologyIRI`  VARCHAR(256) NOT NULL
  ,
  CONSTRAINT `fk_TerminologyNestingAxioms_tboxUUID_TerminologyBoxes`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_TerminologyNestingAxioms_nestingContextUUID_Concepts`
    FOREIGN KEY (`nestingContextUUID`)
    REFERENCES `OML`.`Concepts`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_TerminologyNestingAxioms_nestingTerminologyIRI_TerminologyBoxes`
    FOREIGN KEY (`nestingTerminologyIRI`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`Aspects`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`Aspects` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `name`  TEXT,
  CONSTRAINT `fk_Aspects_tboxUUID_TerminologyBoxes`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`Concepts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`Concepts` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `name`  TEXT,
  CONSTRAINT `fk_Concepts_tboxUUID_TerminologyBoxes`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
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
  CONSTRAINT `fk_ReifiedRelationships_tboxUUID_TerminologyBoxes`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ReifiedRelationships_sourceUUID_Entities`
    FOREIGN KEY (`sourceUUID`)
    REFERENCES `OML`.`Entities`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ReifiedRelationships_targetUUID_Entities`
    FOREIGN KEY (`targetUUID`)
    REFERENCES `OML`.`Entities`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
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
  CONSTRAINT `fk_UnreifiedRelationships_tboxUUID_TerminologyBoxes`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_UnreifiedRelationships_sourceUUID_Entities`
    FOREIGN KEY (`sourceUUID`)
    REFERENCES `OML`.`Entities`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_UnreifiedRelationships_targetUUID_Entities`
    FOREIGN KEY (`targetUUID`)
    REFERENCES `OML`.`Entities`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`Scalars`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`Scalars` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `name`  TEXT,
  CONSTRAINT `fk_Scalars_tboxUUID_TerminologyBoxes`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`Structures`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`Structures` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `name`  TEXT,
  CONSTRAINT `fk_Structures_tboxUUID_TerminologyBoxes`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
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
  CONSTRAINT `fk_BinaryScalarRestrictions_tboxUUID_TerminologyBoxes`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_BinaryScalarRestrictions_restrictedRangeUUID_DataRanges`
    FOREIGN KEY (`restrictedRangeUUID`)
    REFERENCES `OML`.`DataRanges`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
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
  CONSTRAINT `fk_IRIScalarRestrictions_tboxUUID_TerminologyBoxes`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_IRIScalarRestrictions_restrictedRangeUUID_DataRanges`
    FOREIGN KEY (`restrictedRangeUUID`)
    REFERENCES `OML`.`DataRanges`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`NumericScalarRestrictions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`NumericScalarRestrictions` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `restrictedRangeUUID`  BINARY(16) NOT NULL,
  
    `minExclusive`  -- TODO: LiteralFeature
  TEXT, `LiteralType` VARCHAR(20) NOT NULL,,
  
    `minInclusive`  -- TODO: LiteralFeature
  TEXT, `LiteralType` VARCHAR(20) NOT NULL,,
  
    `maxExclusive`  -- TODO: LiteralFeature
  TEXT, `LiteralType` VARCHAR(20) NOT NULL,,
  
    `maxInclusive`  -- TODO: LiteralFeature
  TEXT, `LiteralType` VARCHAR(20) NOT NULL,,
  
    `name`  TEXT,
  CONSTRAINT `fk_NumericScalarRestrictions_tboxUUID_TerminologyBoxes`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_NumericScalarRestrictions_restrictedRangeUUID_DataRanges`
    FOREIGN KEY (`restrictedRangeUUID`)
    REFERENCES `OML`.`DataRanges`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_NumericScalarRestrictions_minExclusive_LiteralNumbers`
    FOREIGN KEY (`minExclusive`)
    REFERENCES `OML`.`LiteralNumbers`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_NumericScalarRestrictions_minInclusive_LiteralNumbers`
    FOREIGN KEY (`minInclusive`)
    REFERENCES `OML`.`LiteralNumbers`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_NumericScalarRestrictions_maxExclusive_LiteralNumbers`
    FOREIGN KEY (`maxExclusive`)
    REFERENCES `OML`.`LiteralNumbers`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_NumericScalarRestrictions_maxInclusive_LiteralNumbers`
    FOREIGN KEY (`maxInclusive`)
    REFERENCES `OML`.`LiteralNumbers`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
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
  CONSTRAINT `fk_PlainLiteralScalarRestrictions_tboxUUID_TerminologyBoxes`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_PlainLiteralScalarRestrictions_restrictedRangeUUID_DataRanges`
    FOREIGN KEY (`restrictedRangeUUID`)
    REFERENCES `OML`.`DataRanges`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`ScalarOneOfRestrictions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ScalarOneOfRestrictions` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `restrictedRangeUUID`  BINARY(16) NOT NULL,
  
    `name`  TEXT,
  CONSTRAINT `fk_ScalarOneOfRestrictions_tboxUUID_TerminologyBoxes`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ScalarOneOfRestrictions_restrictedRangeUUID_DataRanges`
    FOREIGN KEY (`restrictedRangeUUID`)
    REFERENCES `OML`.`DataRanges`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
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
  CONSTRAINT `fk_StringScalarRestrictions_tboxUUID_TerminologyBoxes`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_StringScalarRestrictions_restrictedRangeUUID_DataRanges`
    FOREIGN KEY (`restrictedRangeUUID`)
    REFERENCES `OML`.`DataRanges`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`SynonymScalarRestrictions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`SynonymScalarRestrictions` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `restrictedRangeUUID`  BINARY(16) NOT NULL,
  
    `name`  TEXT,
  CONSTRAINT `fk_SynonymScalarRestrictions_tboxUUID_TerminologyBoxes`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SynonymScalarRestrictions_restrictedRangeUUID_DataRanges`
    FOREIGN KEY (`restrictedRangeUUID`)
    REFERENCES `OML`.`DataRanges`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`TimeScalarRestrictions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`TimeScalarRestrictions` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `restrictedRangeUUID`  BINARY(16) NOT NULL,
  
    `minExclusive`  -- TODO: LiteralFeature
  TEXT, `LiteralType` VARCHAR(20) NOT NULL,,
  
    `minInclusive`  -- TODO: LiteralFeature
  TEXT, `LiteralType` VARCHAR(20) NOT NULL,,
  
    `maxExclusive`  -- TODO: LiteralFeature
  TEXT, `LiteralType` VARCHAR(20) NOT NULL,,
  
    `maxInclusive`  -- TODO: LiteralFeature
  TEXT, `LiteralType` VARCHAR(20) NOT NULL,,
  
    `name`  TEXT,
  CONSTRAINT `fk_TimeScalarRestrictions_tboxUUID_TerminologyBoxes`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_TimeScalarRestrictions_restrictedRangeUUID_DataRanges`
    FOREIGN KEY (`restrictedRangeUUID`)
    REFERENCES `OML`.`DataRanges`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_TimeScalarRestrictions_minExclusive_LiteralDateTimes`
    FOREIGN KEY (`minExclusive`)
    REFERENCES `OML`.`LiteralDateTimes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_TimeScalarRestrictions_minInclusive_LiteralDateTimes`
    FOREIGN KEY (`minInclusive`)
    REFERENCES `OML`.`LiteralDateTimes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_TimeScalarRestrictions_maxExclusive_LiteralDateTimes`
    FOREIGN KEY (`maxExclusive`)
    REFERENCES `OML`.`LiteralDateTimes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_TimeScalarRestrictions_maxInclusive_LiteralDateTimes`
    FOREIGN KEY (`maxInclusive`)
    REFERENCES `OML`.`LiteralDateTimes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
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
  CONSTRAINT `fk_EntityScalarDataProperties_tboxUUID_TerminologyBoxes`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EntityScalarDataProperties_domainUUID_Entities`
    FOREIGN KEY (`domainUUID`)
    REFERENCES `OML`.`Entities`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EntityScalarDataProperties_rangeUUID_DataRanges`
    FOREIGN KEY (`rangeUUID`)
    REFERENCES `OML`.`DataRanges`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
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
  CONSTRAINT `fk_EntityStructuredDataProperties_tboxUUID_TerminologyBoxes`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EntityStructuredDataProperties_domainUUID_Entities`
    FOREIGN KEY (`domainUUID`)
    REFERENCES `OML`.`Entities`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EntityStructuredDataProperties_rangeUUID_Structures`
    FOREIGN KEY (`rangeUUID`)
    REFERENCES `OML`.`Structures`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`ScalarDataProperties`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ScalarDataProperties` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `domainUUID`  BINARY(16) NOT NULL,
  
    `rangeUUID`  BINARY(16) NOT NULL,
  
    `name`  TEXT,
  CONSTRAINT `fk_ScalarDataProperties_tboxUUID_TerminologyBoxes`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ScalarDataProperties_domainUUID_Structures`
    FOREIGN KEY (`domainUUID`)
    REFERENCES `OML`.`Structures`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ScalarDataProperties_rangeUUID_DataRanges`
    FOREIGN KEY (`rangeUUID`)
    REFERENCES `OML`.`DataRanges`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`StructuredDataProperties`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`StructuredDataProperties` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `domainUUID`  BINARY(16) NOT NULL,
  
    `rangeUUID`  BINARY(16) NOT NULL,
  
    `name`  TEXT,
  CONSTRAINT `fk_StructuredDataProperties_tboxUUID_TerminologyBoxes`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_StructuredDataProperties_domainUUID_Structures`
    FOREIGN KEY (`domainUUID`)
    REFERENCES `OML`.`Structures`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_StructuredDataProperties_rangeUUID_Structures`
    FOREIGN KEY (`rangeUUID`)
    REFERENCES `OML`.`Structures`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`AspectSpecializationAxioms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`AspectSpecializationAxioms` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `superAspectUUID`  BINARY(16) NOT NULL,
  
    `subEntityUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_AspectSpecializationAxioms_tboxUUID_TerminologyBoxes`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_AspectSpecializationAxioms_superAspectUUID_Aspects`
    FOREIGN KEY (`superAspectUUID`)
    REFERENCES `OML`.`Aspects`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_AspectSpecializationAxioms_subEntityUUID_Entities`
    FOREIGN KEY (`subEntityUUID`)
    REFERENCES `OML`.`Entities`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`ConceptSpecializationAxioms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ConceptSpecializationAxioms` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `superConceptUUID`  BINARY(16) NOT NULL,
  
    `subConceptUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_ConceptSpecializationAxioms_tboxUUID_TerminologyBoxes`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ConceptSpecializationAxioms_superConceptUUID_Concepts`
    FOREIGN KEY (`superConceptUUID`)
    REFERENCES `OML`.`Concepts`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ConceptSpecializationAxioms_subConceptUUID_Concepts`
    FOREIGN KEY (`subConceptUUID`)
    REFERENCES `OML`.`Concepts`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`ReifiedRelationshipSpecializationAxioms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ReifiedRelationshipSpecializationAxioms` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `superRelationshipUUID`  BINARY(16) NOT NULL,
  
    `subRelationshipUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_ReifiedRelationshipSpecializationAxioms_tboxUUID_TerminologyBoxes`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ReifiedRelationshipSpecializationAxioms_superRelationshipUUID_ReifiedRelationships`
    FOREIGN KEY (`superRelationshipUUID`)
    REFERENCES `OML`.`ReifiedRelationships`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ReifiedRelationshipSpecializationAxioms_subRelationshipUUID_ReifiedRelationships`
    FOREIGN KEY (`subRelationshipUUID`)
    REFERENCES `OML`.`ReifiedRelationships`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
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
  CONSTRAINT `fk_EntityExistentialRestrictionAxioms_tboxUUID_TerminologyBoxes`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EntityExistentialRestrictionAxioms_restrictedRelationUUID_EntityRelationships`
    FOREIGN KEY (`restrictedRelationUUID`)
    REFERENCES `OML`.`EntityRelationships`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EntityExistentialRestrictionAxioms_restrictedDomainUUID_Entities`
    FOREIGN KEY (`restrictedDomainUUID`)
    REFERENCES `OML`.`Entities`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EntityExistentialRestrictionAxioms_restrictedRangeUUID_Entities`
    FOREIGN KEY (`restrictedRangeUUID`)
    REFERENCES `OML`.`Entities`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
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
  CONSTRAINT `fk_EntityUniversalRestrictionAxioms_tboxUUID_TerminologyBoxes`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EntityUniversalRestrictionAxioms_restrictedRelationUUID_EntityRelationships`
    FOREIGN KEY (`restrictedRelationUUID`)
    REFERENCES `OML`.`EntityRelationships`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EntityUniversalRestrictionAxioms_restrictedDomainUUID_Entities`
    FOREIGN KEY (`restrictedDomainUUID`)
    REFERENCES `OML`.`Entities`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EntityUniversalRestrictionAxioms_restrictedRangeUUID_Entities`
    FOREIGN KEY (`restrictedRangeUUID`)
    REFERENCES `OML`.`Entities`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
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
  CONSTRAINT `fk_EntityScalarDataPropertyExistentialRestrictionAxioms_tboxUUID_TerminologyBoxes`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EntityScalarDataPropertyExistentialRestrictionAxioms_restrictedEntityUUID_Entities`
    FOREIGN KEY (`restrictedEntityUUID`)
    REFERENCES `OML`.`Entities`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EntityScalarDataPropertyExistentialRestrictionAxioms_scalarPropertyUUID_EntityScalarDataProperties`
    FOREIGN KEY (`scalarPropertyUUID`)
    REFERENCES `OML`.`EntityScalarDataProperties`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EntityScalarDataPropertyExistentialRestrictionAxioms_scalarRestrictionUUID_DataRanges`
    FOREIGN KEY (`scalarRestrictionUUID`)
    REFERENCES `OML`.`DataRanges`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`EntityScalarDataPropertyParticularRestrictionAxioms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`EntityScalarDataPropertyParticularRestrictionAxioms` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `restrictedEntityUUID`  BINARY(16) NOT NULL,
  
    `scalarPropertyUUID`  BINARY(16) NOT NULL,
  
    `literalValue`  -- TODO: LiteralFeature
  TEXT, `LiteralType` VARCHAR(20) NOT NULL,,
  
    `valueTypeUUID`  BINARY(16) NULL
  ,
  CONSTRAINT `fk_EntityScalarDataPropertyParticularRestrictionAxioms_tboxUUID_TerminologyBoxes`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EntityScalarDataPropertyParticularRestrictionAxioms_restrictedEntityUUID_Entities`
    FOREIGN KEY (`restrictedEntityUUID`)
    REFERENCES `OML`.`Entities`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EntityScalarDataPropertyParticularRestrictionAxioms_scalarPropertyUUID_EntityScalarDataProperties`
    FOREIGN KEY (`scalarPropertyUUID`)
    REFERENCES `OML`.`EntityScalarDataProperties`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EntityScalarDataPropertyParticularRestrictionAxioms_literalValue_LiteralValues`
    FOREIGN KEY (`literalValue`)
    REFERENCES `OML`.`LiteralValues`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EntityScalarDataPropertyParticularRestrictionAxioms_valueTypeUUID_DataRanges`
    FOREIGN KEY (`valueTypeUUID`)
    REFERENCES `OML`.`DataRanges`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
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
  CONSTRAINT `fk_EntityScalarDataPropertyUniversalRestrictionAxioms_tboxUUID_TerminologyBoxes`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EntityScalarDataPropertyUniversalRestrictionAxioms_restrictedEntityUUID_Entities`
    FOREIGN KEY (`restrictedEntityUUID`)
    REFERENCES `OML`.`Entities`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EntityScalarDataPropertyUniversalRestrictionAxioms_scalarPropertyUUID_EntityScalarDataProperties`
    FOREIGN KEY (`scalarPropertyUUID`)
    REFERENCES `OML`.`EntityScalarDataProperties`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EntityScalarDataPropertyUniversalRestrictionAxioms_scalarRestrictionUUID_DataRanges`
    FOREIGN KEY (`scalarRestrictionUUID`)
    REFERENCES `OML`.`DataRanges`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`ScalarOneOfLiteralAxioms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ScalarOneOfLiteralAxioms` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `axiomUUID`  BINARY(16) NOT NULL,
  
    `value`  -- TODO: LiteralFeature
  TEXT, `LiteralType` VARCHAR(20) NOT NULL,,
  
    `valueTypeUUID`  BINARY(16) NULL
  ,
  CONSTRAINT `fk_ScalarOneOfLiteralAxioms_tboxUUID_TerminologyBoxes`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ScalarOneOfLiteralAxioms_axiomUUID_ScalarOneOfRestrictions`
    FOREIGN KEY (`axiomUUID`)
    REFERENCES `OML`.`ScalarOneOfRestrictions`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ScalarOneOfLiteralAxioms_value_LiteralValues`
    FOREIGN KEY (`value`)
    REFERENCES `OML`.`LiteralValues`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ScalarOneOfLiteralAxioms_valueTypeUUID_DataRanges`
    FOREIGN KEY (`valueTypeUUID`)
    REFERENCES `OML`.`DataRanges`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`BundledTerminologyAxioms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`BundledTerminologyAxioms` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `bundleUUID`  BINARY(16) NOT NULL,
  
    `bundledTerminologyIRI`  VARCHAR(256) NOT NULL
  ,
  CONSTRAINT `fk_BundledTerminologyAxioms_bundleUUID_Bundles`
    FOREIGN KEY (`bundleUUID`)
    REFERENCES `OML`.`Bundles`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_BundledTerminologyAxioms_bundledTerminologyIRI_TerminologyBoxes`
    FOREIGN KEY (`bundledTerminologyIRI`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`RootConceptTaxonomyAxioms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`RootConceptTaxonomyAxioms` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `bundleUUID`  BINARY(16) NOT NULL,
  
    `rootUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_RootConceptTaxonomyAxioms_bundleUUID_Bundles`
    FOREIGN KEY (`bundleUUID`)
    REFERENCES `OML`.`Bundles`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RootConceptTaxonomyAxioms_rootUUID_Concepts`
    FOREIGN KEY (`rootUUID`)
    REFERENCES `OML`.`Concepts`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`SpecificDisjointConceptAxioms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`SpecificDisjointConceptAxioms` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `disjointTaxonomyParentUUID`  BINARY(16) NOT NULL,
  
    `disjointLeafUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_SpecificDisjointConceptAxioms_disjointTaxonomyParentUUID_ConceptTreeDisjunctions`
    FOREIGN KEY (`disjointTaxonomyParentUUID`)
    REFERENCES `OML`.`ConceptTreeDisjunctions`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SpecificDisjointConceptAxioms_disjointLeafUUID_Concepts`
    FOREIGN KEY (`disjointLeafUUID`)
    REFERENCES `OML`.`Concepts`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`AnnotationPropertyValues`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`AnnotationPropertyValues` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `subjectUUID`  BINARY(16) NOT NULL,
  
    `propertyUUID`  BINARY(16) NOT NULL,
  
    `value`  -- TODO: LiteralFeature
  TEXT, `LiteralType` VARCHAR(20) NOT NULL,
  ,
  CONSTRAINT `fk_AnnotationPropertyValues_subjectUUID_LogicalElements`
    FOREIGN KEY (`subjectUUID`)
    REFERENCES `OML`.`LogicalElements`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_AnnotationPropertyValues_propertyUUID_AnnotationProperties`
    FOREIGN KEY (`propertyUUID`)
    REFERENCES `OML`.`AnnotationProperties`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_AnnotationPropertyValues_value_LiteralStrings`
    FOREIGN KEY (`value`)
    REFERENCES `OML`.`LiteralStrings`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`AnonymousConceptUnionAxioms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`AnonymousConceptUnionAxioms` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `disjointTaxonomyParentUUID`  BINARY(16) NOT NULL,
  
    `name`  TEXT,
  CONSTRAINT `fk_AnonymousConceptUnionAxioms_disjointTaxonomyParentUUID_ConceptTreeDisjunctions`
    FOREIGN KEY (`disjointTaxonomyParentUUID`)
    REFERENCES `OML`.`ConceptTreeDisjunctions`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`AspectPredicates`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`AspectPredicates` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `aspectUUID`  BINARY(16) NOT NULL,
  
    `bodySegmentUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_AspectPredicates_aspectUUID_Aspects`
    FOREIGN KEY (`aspectUUID`)
    REFERENCES `OML`.`Aspects`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_AspectPredicates_bodySegmentUUID_RuleBodySegments`
    FOREIGN KEY (`bodySegmentUUID`)
    REFERENCES `OML`.`RuleBodySegments`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`ChainRules`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ChainRules` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `name`  TEXT,
    `headUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_ChainRules_tboxUUID_TerminologyBoxes`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ChainRules_headUUID_UnreifiedRelationships`
    FOREIGN KEY (`headUUID`)
    REFERENCES `OML`.`UnreifiedRelationships`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`ConceptInstances`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ConceptInstances` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `descriptionBoxUUID`  BINARY(16) NOT NULL,
  
    `singletonConceptClassifierUUID`  BINARY(16) NOT NULL,
  
    `name`  TEXT,
  CONSTRAINT `fk_ConceptInstances_descriptionBoxUUID_DescriptionBoxes`
    FOREIGN KEY (`descriptionBoxUUID`)
    REFERENCES `OML`.`DescriptionBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ConceptInstances_singletonConceptClassifierUUID_Concepts`
    FOREIGN KEY (`singletonConceptClassifierUUID`)
    REFERENCES `OML`.`Concepts`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`ConceptPredicates`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ConceptPredicates` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `bodySegmentUUID`  BINARY(16) NOT NULL,
  
    `conceptUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_ConceptPredicates_bodySegmentUUID_RuleBodySegments`
    FOREIGN KEY (`bodySegmentUUID`)
    REFERENCES `OML`.`RuleBodySegments`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ConceptPredicates_conceptUUID_Concepts`
    FOREIGN KEY (`conceptUUID`)
    REFERENCES `OML`.`Concepts`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`DescriptionBoxes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`DescriptionBoxes` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `kind`  TEXT,
    `iri`  TEXT,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`DescriptionBoxExtendsClosedWorldDefinitions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`DescriptionBoxExtendsClosedWorldDefinitions` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `descriptionBoxUUID`  BINARY(16) NOT NULL,
  
    `closedWorldDefinitionsIRI`  VARCHAR(256) NOT NULL
  ,
  CONSTRAINT `fk_DescriptionBoxExtendsClosedWorldDefinitions_descriptionBoxUUID_DescriptionBoxes`
    FOREIGN KEY (`descriptionBoxUUID`)
    REFERENCES `OML`.`DescriptionBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_DescriptionBoxExtendsClosedWorldDefinitions_closedWorldDefinitionsIRI_TerminologyBoxes`
    FOREIGN KEY (`closedWorldDefinitionsIRI`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`DescriptionBoxRefinements`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`DescriptionBoxRefinements` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `refiningDescriptionBoxUUID`  BINARY(16) NOT NULL,
  
    `refinedDescriptionBoxIRI`  VARCHAR(256) NOT NULL
  ,
  CONSTRAINT `fk_DescriptionBoxRefinements_refiningDescriptionBoxUUID_DescriptionBoxes`
    FOREIGN KEY (`refiningDescriptionBoxUUID`)
    REFERENCES `OML`.`DescriptionBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_DescriptionBoxRefinements_refinedDescriptionBoxIRI_DescriptionBoxes`
    FOREIGN KEY (`refinedDescriptionBoxIRI`)
    REFERENCES `OML`.`DescriptionBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`EntityStructuredDataPropertyParticularRestrictionAxioms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`EntityStructuredDataPropertyParticularRestrictionAxioms` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `structuredDataPropertyUUID`  BINARY(16) NOT NULL,
  
    `restrictedEntityUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_EntityStructuredDataPropertyParticularRestrictionAxioms_tboxUUID_TerminologyBoxes`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EntityStructuredDataPropertyParticularRestrictionAxioms_structuredDataPropertyUUID_DataRelationshipToStructures`
    FOREIGN KEY (`structuredDataPropertyUUID`)
    REFERENCES `OML`.`DataRelationshipToStructures`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EntityStructuredDataPropertyParticularRestrictionAxioms_restrictedEntityUUID_Entities`
    FOREIGN KEY (`restrictedEntityUUID`)
    REFERENCES `OML`.`Entities`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`ReifiedRelationshipInstances`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ReifiedRelationshipInstances` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `descriptionBoxUUID`  BINARY(16) NOT NULL,
  
    `singletonReifiedRelationshipClassifierUUID`  BINARY(16) NOT NULL,
  
    `name`  TEXT,
  CONSTRAINT `fk_ReifiedRelationshipInstances_descriptionBoxUUID_DescriptionBoxes`
    FOREIGN KEY (`descriptionBoxUUID`)
    REFERENCES `OML`.`DescriptionBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ReifiedRelationshipInstances_singletonReifiedRelationshipClassifierUUID_ReifiedRelationships`
    FOREIGN KEY (`singletonReifiedRelationshipClassifierUUID`)
    REFERENCES `OML`.`ReifiedRelationships`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`ReifiedRelationshipInstanceDomains`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ReifiedRelationshipInstanceDomains` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `descriptionBoxUUID`  BINARY(16) NOT NULL,
  
    `reifiedRelationshipInstanceUUID`  BINARY(16) NOT NULL,
  
    `domainUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_ReifiedRelationshipInstanceDomains_descriptionBoxUUID_DescriptionBoxes`
    FOREIGN KEY (`descriptionBoxUUID`)
    REFERENCES `OML`.`DescriptionBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ReifiedRelationshipInstanceDomains_reifiedRelationshipInstanceUUID_ReifiedRelationshipInstances`
    FOREIGN KEY (`reifiedRelationshipInstanceUUID`)
    REFERENCES `OML`.`ReifiedRelationshipInstances`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ReifiedRelationshipInstanceDomains_domainUUID_ConceptualEntitySingletonInstances`
    FOREIGN KEY (`domainUUID`)
    REFERENCES `OML`.`ConceptualEntitySingletonInstances`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`ReifiedRelationshipInstanceRanges`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ReifiedRelationshipInstanceRanges` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `descriptionBoxUUID`  BINARY(16) NOT NULL,
  
    `reifiedRelationshipInstanceUUID`  BINARY(16) NOT NULL,
  
    `rangeUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_ReifiedRelationshipInstanceRanges_descriptionBoxUUID_DescriptionBoxes`
    FOREIGN KEY (`descriptionBoxUUID`)
    REFERENCES `OML`.`DescriptionBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ReifiedRelationshipInstanceRanges_reifiedRelationshipInstanceUUID_ReifiedRelationshipInstances`
    FOREIGN KEY (`reifiedRelationshipInstanceUUID`)
    REFERENCES `OML`.`ReifiedRelationshipInstances`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ReifiedRelationshipInstanceRanges_rangeUUID_ConceptualEntitySingletonInstances`
    FOREIGN KEY (`rangeUUID`)
    REFERENCES `OML`.`ConceptualEntitySingletonInstances`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`ReifiedRelationshipInversePropertyPredicates`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ReifiedRelationshipInversePropertyPredicates` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `bodySegmentUUID`  BINARY(16) NOT NULL,
  
    `reifiedRelationshipUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_ReifiedRelationshipInversePropertyPredicates_bodySegmentUUID_RuleBodySegments`
    FOREIGN KEY (`bodySegmentUUID`)
    REFERENCES `OML`.`RuleBodySegments`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ReifiedRelationshipInversePropertyPredicates_reifiedRelationshipUUID_ReifiedRelationships`
    FOREIGN KEY (`reifiedRelationshipUUID`)
    REFERENCES `OML`.`ReifiedRelationships`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`ReifiedRelationshipPredicates`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ReifiedRelationshipPredicates` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `bodySegmentUUID`  BINARY(16) NOT NULL,
  
    `reifiedRelationshipUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_ReifiedRelationshipPredicates_bodySegmentUUID_RuleBodySegments`
    FOREIGN KEY (`bodySegmentUUID`)
    REFERENCES `OML`.`RuleBodySegments`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ReifiedRelationshipPredicates_reifiedRelationshipUUID_ReifiedRelationships`
    FOREIGN KEY (`reifiedRelationshipUUID`)
    REFERENCES `OML`.`ReifiedRelationships`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`ReifiedRelationshipPropertyPredicates`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ReifiedRelationshipPropertyPredicates` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `bodySegmentUUID`  BINARY(16) NOT NULL,
  
    `reifiedRelationshipUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_ReifiedRelationshipPropertyPredicates_bodySegmentUUID_RuleBodySegments`
    FOREIGN KEY (`bodySegmentUUID`)
    REFERENCES `OML`.`RuleBodySegments`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ReifiedRelationshipPropertyPredicates_reifiedRelationshipUUID_ReifiedRelationships`
    FOREIGN KEY (`reifiedRelationshipUUID`)
    REFERENCES `OML`.`ReifiedRelationships`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`ReifiedRelationshipSourceInversePropertyPredicates`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ReifiedRelationshipSourceInversePropertyPredicates` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `bodySegmentUUID`  BINARY(16) NOT NULL,
  
    `reifiedRelationshipUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_ReifiedRelationshipSourceInversePropertyPredicates_bodySegmentUUID_RuleBodySegments`
    FOREIGN KEY (`bodySegmentUUID`)
    REFERENCES `OML`.`RuleBodySegments`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ReifiedRelationshipSourceInversePropertyPredicates_reifiedRelationshipUUID_ReifiedRelationships`
    FOREIGN KEY (`reifiedRelationshipUUID`)
    REFERENCES `OML`.`ReifiedRelationships`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`ReifiedRelationshipSourcePropertyPredicates`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ReifiedRelationshipSourcePropertyPredicates` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `bodySegmentUUID`  BINARY(16) NOT NULL,
  
    `reifiedRelationshipUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_ReifiedRelationshipSourcePropertyPredicates_bodySegmentUUID_RuleBodySegments`
    FOREIGN KEY (`bodySegmentUUID`)
    REFERENCES `OML`.`RuleBodySegments`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ReifiedRelationshipSourcePropertyPredicates_reifiedRelationshipUUID_ReifiedRelationships`
    FOREIGN KEY (`reifiedRelationshipUUID`)
    REFERENCES `OML`.`ReifiedRelationships`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`ReifiedRelationshipTargetInversePropertyPredicates`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ReifiedRelationshipTargetInversePropertyPredicates` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `bodySegmentUUID`  BINARY(16) NOT NULL,
  
    `reifiedRelationshipUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_ReifiedRelationshipTargetInversePropertyPredicates_bodySegmentUUID_RuleBodySegments`
    FOREIGN KEY (`bodySegmentUUID`)
    REFERENCES `OML`.`RuleBodySegments`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ReifiedRelationshipTargetInversePropertyPredicates_reifiedRelationshipUUID_ReifiedRelationships`
    FOREIGN KEY (`reifiedRelationshipUUID`)
    REFERENCES `OML`.`ReifiedRelationships`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`ReifiedRelationshipTargetPropertyPredicates`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ReifiedRelationshipTargetPropertyPredicates` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `bodySegmentUUID`  BINARY(16) NOT NULL,
  
    `reifiedRelationshipUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_ReifiedRelationshipTargetPropertyPredicates_bodySegmentUUID_RuleBodySegments`
    FOREIGN KEY (`bodySegmentUUID`)
    REFERENCES `OML`.`RuleBodySegments`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ReifiedRelationshipTargetPropertyPredicates_reifiedRelationshipUUID_ReifiedRelationships`
    FOREIGN KEY (`reifiedRelationshipUUID`)
    REFERENCES `OML`.`ReifiedRelationships`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`RestrictionScalarDataPropertyValues`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`RestrictionScalarDataPropertyValues` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `scalarDataPropertyUUID`  BINARY(16) NOT NULL,
  
    `scalarPropertyValue`  -- TODO: LiteralFeature
  TEXT, `LiteralType` VARCHAR(20) NOT NULL,,
  
    `structuredDataPropertyContextUUID`  BINARY(16) NOT NULL,
  
    `valueTypeUUID`  BINARY(16) NULL
  ,
  CONSTRAINT `fk_RestrictionScalarDataPropertyValues_scalarDataPropertyUUID_DataRelationshipToScalars`
    FOREIGN KEY (`scalarDataPropertyUUID`)
    REFERENCES `OML`.`DataRelationshipToScalars`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RestrictionScalarDataPropertyValues_scalarPropertyValue_LiteralValues`
    FOREIGN KEY (`scalarPropertyValue`)
    REFERENCES `OML`.`LiteralValues`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RestrictionScalarDataPropertyValues_structuredDataPropertyContextUUID_RestrictionStructuredDataPropertyContexts`
    FOREIGN KEY (`structuredDataPropertyContextUUID`)
    REFERENCES `OML`.`RestrictionStructuredDataPropertyContexts`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RestrictionScalarDataPropertyValues_valueTypeUUID_DataRanges`
    FOREIGN KEY (`valueTypeUUID`)
    REFERENCES `OML`.`DataRanges`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`RestrictionStructuredDataPropertyTuples`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`RestrictionStructuredDataPropertyTuples` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `structuredDataPropertyUUID`  BINARY(16) NOT NULL,
  
    `structuredDataPropertyContextUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_RestrictionStructuredDataPropertyTuples_structuredDataPropertyUUID_DataRelationshipToStructures`
    FOREIGN KEY (`structuredDataPropertyUUID`)
    REFERENCES `OML`.`DataRelationshipToStructures`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RestrictionStructuredDataPropertyTuples_structuredDataPropertyContextUUID_RestrictionStructuredDataPropertyContexts`
    FOREIGN KEY (`structuredDataPropertyContextUUID`)
    REFERENCES `OML`.`RestrictionStructuredDataPropertyContexts`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`RuleBodySegments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`RuleBodySegments` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `previousSegmentUUID`  BINARY(16) NULL,
  
    `ruleUUID`  BINARY(16) NULL
  ,
  CONSTRAINT `fk_RuleBodySegments_previousSegmentUUID_RuleBodySegments`
    FOREIGN KEY (`previousSegmentUUID`)
    REFERENCES `OML`.`RuleBodySegments`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RuleBodySegments_ruleUUID_ChainRules`
    FOREIGN KEY (`ruleUUID`)
    REFERENCES `OML`.`ChainRules`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`ScalarDataPropertyValues`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ScalarDataPropertyValues` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `scalarDataPropertyUUID`  BINARY(16) NOT NULL,
  
    `scalarPropertyValue`  -- TODO: LiteralFeature
  TEXT, `LiteralType` VARCHAR(20) NOT NULL,,
  
    `structuredDataPropertyContextUUID`  BINARY(16) NOT NULL,
  
    `valueTypeUUID`  BINARY(16) NULL
  ,
  CONSTRAINT `fk_ScalarDataPropertyValues_scalarDataPropertyUUID_DataRelationshipToScalars`
    FOREIGN KEY (`scalarDataPropertyUUID`)
    REFERENCES `OML`.`DataRelationshipToScalars`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ScalarDataPropertyValues_scalarPropertyValue_LiteralValues`
    FOREIGN KEY (`scalarPropertyValue`)
    REFERENCES `OML`.`LiteralValues`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ScalarDataPropertyValues_structuredDataPropertyContextUUID_SingletonInstanceStructuredDataPropertyContexts`
    FOREIGN KEY (`structuredDataPropertyContextUUID`)
    REFERENCES `OML`.`SingletonInstanceStructuredDataPropertyContexts`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ScalarDataPropertyValues_valueTypeUUID_DataRanges`
    FOREIGN KEY (`valueTypeUUID`)
    REFERENCES `OML`.`DataRanges`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`SingletonInstanceScalarDataPropertyValues`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`SingletonInstanceScalarDataPropertyValues` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `descriptionBoxUUID`  BINARY(16) NOT NULL,
  
    `singletonInstanceUUID`  BINARY(16) NOT NULL,
  
    `scalarDataPropertyUUID`  BINARY(16) NOT NULL,
  
    `scalarPropertyValue`  -- TODO: LiteralFeature
  TEXT, `LiteralType` VARCHAR(20) NOT NULL,,
  
    `valueTypeUUID`  BINARY(16) NULL
  ,
  CONSTRAINT `fk_SingletonInstanceScalarDataPropertyValues_descriptionBoxUUID_DescriptionBoxes`
    FOREIGN KEY (`descriptionBoxUUID`)
    REFERENCES `OML`.`DescriptionBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SingletonInstanceScalarDataPropertyValues_singletonInstanceUUID_ConceptualEntitySingletonInstances`
    FOREIGN KEY (`singletonInstanceUUID`)
    REFERENCES `OML`.`ConceptualEntitySingletonInstances`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SingletonInstanceScalarDataPropertyValues_scalarDataPropertyUUID_EntityScalarDataProperties`
    FOREIGN KEY (`scalarDataPropertyUUID`)
    REFERENCES `OML`.`EntityScalarDataProperties`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SingletonInstanceScalarDataPropertyValues_scalarPropertyValue_LiteralValues`
    FOREIGN KEY (`scalarPropertyValue`)
    REFERENCES `OML`.`LiteralValues`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SingletonInstanceScalarDataPropertyValues_valueTypeUUID_DataRanges`
    FOREIGN KEY (`valueTypeUUID`)
    REFERENCES `OML`.`DataRanges`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`SingletonInstanceStructuredDataPropertyValues`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`SingletonInstanceStructuredDataPropertyValues` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `descriptionBoxUUID`  BINARY(16) NOT NULL,
  
    `singletonInstanceUUID`  BINARY(16) NOT NULL,
  
    `structuredDataPropertyUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_SingletonInstanceStructuredDataPropertyValues_descriptionBoxUUID_DescriptionBoxes`
    FOREIGN KEY (`descriptionBoxUUID`)
    REFERENCES `OML`.`DescriptionBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SingletonInstanceStructuredDataPropertyValues_singletonInstanceUUID_ConceptualEntitySingletonInstances`
    FOREIGN KEY (`singletonInstanceUUID`)
    REFERENCES `OML`.`ConceptualEntitySingletonInstances`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SingletonInstanceStructuredDataPropertyValues_structuredDataPropertyUUID_DataRelationshipToStructures`
    FOREIGN KEY (`structuredDataPropertyUUID`)
    REFERENCES `OML`.`DataRelationshipToStructures`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`StructuredDataPropertyTuples`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`StructuredDataPropertyTuples` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `structuredDataPropertyUUID`  BINARY(16) NOT NULL,
  
    `structuredDataPropertyContextUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_StructuredDataPropertyTuples_structuredDataPropertyUUID_DataRelationshipToStructures`
    FOREIGN KEY (`structuredDataPropertyUUID`)
    REFERENCES `OML`.`DataRelationshipToStructures`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_StructuredDataPropertyTuples_structuredDataPropertyContextUUID_SingletonInstanceStructuredDataPropertyContexts`
    FOREIGN KEY (`structuredDataPropertyContextUUID`)
    REFERENCES `OML`.`SingletonInstanceStructuredDataPropertyContexts`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`SubDataPropertyOfAxioms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`SubDataPropertyOfAxioms` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `subPropertyUUID`  BINARY(16) NOT NULL,
  
    `superPropertyUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_SubDataPropertyOfAxioms_tboxUUID_TerminologyBoxes`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SubDataPropertyOfAxioms_subPropertyUUID_EntityScalarDataProperties`
    FOREIGN KEY (`subPropertyUUID`)
    REFERENCES `OML`.`EntityScalarDataProperties`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SubDataPropertyOfAxioms_superPropertyUUID_EntityScalarDataProperties`
    FOREIGN KEY (`superPropertyUUID`)
    REFERENCES `OML`.`EntityScalarDataProperties`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`SubObjectPropertyOfAxioms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`SubObjectPropertyOfAxioms` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `subPropertyUUID`  BINARY(16) NOT NULL,
  
    `superPropertyUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_SubObjectPropertyOfAxioms_tboxUUID_TerminologyBoxes`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TerminologyBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SubObjectPropertyOfAxioms_subPropertyUUID_UnreifiedRelationships`
    FOREIGN KEY (`subPropertyUUID`)
    REFERENCES `OML`.`UnreifiedRelationships`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SubObjectPropertyOfAxioms_superPropertyUUID_UnreifiedRelationships`
    FOREIGN KEY (`superPropertyUUID`)
    REFERENCES `OML`.`UnreifiedRelationships`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
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
  CONSTRAINT `fk_UnreifiedRelationshipInstanceTuples_descriptionBoxUUID_DescriptionBoxes`
    FOREIGN KEY (`descriptionBoxUUID`)
    REFERENCES `OML`.`DescriptionBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_UnreifiedRelationshipInstanceTuples_unreifiedRelationshipUUID_UnreifiedRelationships`
    FOREIGN KEY (`unreifiedRelationshipUUID`)
    REFERENCES `OML`.`UnreifiedRelationships`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_UnreifiedRelationshipInstanceTuples_domainUUID_ConceptualEntitySingletonInstances`
    FOREIGN KEY (`domainUUID`)
    REFERENCES `OML`.`ConceptualEntitySingletonInstances`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_UnreifiedRelationshipInstanceTuples_rangeUUID_ConceptualEntitySingletonInstances`
    FOREIGN KEY (`rangeUUID`)
    REFERENCES `OML`.`ConceptualEntitySingletonInstances`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`UnreifiedRelationshipInversePropertyPredicates`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`UnreifiedRelationshipInversePropertyPredicates` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `unreifiedRelationshipUUID`  BINARY(16) NOT NULL,
  
    `bodySegmentUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_UnreifiedRelationshipInversePropertyPredicates_unreifiedRelationshipUUID_UnreifiedRelationships`
    FOREIGN KEY (`unreifiedRelationshipUUID`)
    REFERENCES `OML`.`UnreifiedRelationships`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_UnreifiedRelationshipInversePropertyPredicates_bodySegmentUUID_RuleBodySegments`
    FOREIGN KEY (`bodySegmentUUID`)
    REFERENCES `OML`.`RuleBodySegments`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
-- -----------------------------------------------------
-- Table `OML`.`UnreifiedRelationshipPropertyPredicates`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`UnreifiedRelationshipPropertyPredicates` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `unreifiedRelationshipUUID`  BINARY(16) NOT NULL,
  
    `bodySegmentUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_UnreifiedRelationshipPropertyPredicates_unreifiedRelationshipUUID_UnreifiedRelationships`
    FOREIGN KEY (`unreifiedRelationshipUUID`)
    REFERENCES `OML`.`UnreifiedRelationships`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_UnreifiedRelationshipPropertyPredicates_bodySegmentUUID_RuleBodySegments`
    FOREIGN KEY (`bodySegmentUUID`)
    REFERENCES `OML`.`RuleBodySegments`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
  
  		  

