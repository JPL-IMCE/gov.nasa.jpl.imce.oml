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
-- AnnotationProperties
-- Table `OML`.`AP`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`AP` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `iri`  TEXT,
    `abbrevIRI`  TEXT,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- TerminologyGraphs
-- Table `OML`.`TG`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`TG` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `kind`  TEXT,
    `iri`  TEXT,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Bundles
-- Table `OML`.`B`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`B` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `kind`  TEXT,
    `iri`  TEXT,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- ConceptDesignationTerminologyAxioms
-- Table `OML`.`CDTA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`CDTA` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `designatedConceptUUID`  BINARY(16) NOT NULL,
  
    `designatedTerminologyIRI`  VARCHAR(256) NOT NULL
  ,
  CONSTRAINT `fk_CDTA_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TB`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_CDTA_designatedConceptUUID`
    FOREIGN KEY (`designatedConceptUUID`)
    REFERENCES `OML`.`C`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_CDTA_designatedTerminologyIRI`
    FOREIGN KEY (`designatedTerminologyIRI`)
    REFERENCES `OML`.`TB`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- TerminologyExtensionAxioms
-- Table `OML`.`TEA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`TEA` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `extendedTerminologyIRI`  VARCHAR(256) NOT NULL
  ,
  CONSTRAINT `fk_TEA_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TB`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_TEA_extendedTerminologyIRI`
    FOREIGN KEY (`extendedTerminologyIRI`)
    REFERENCES `OML`.`TB`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- TerminologyNestingAxioms
-- Table `OML`.`TNA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`TNA` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `nestingContextUUID`  BINARY(16) NOT NULL,
  
    `nestingTerminologyIRI`  VARCHAR(256) NOT NULL
  ,
  CONSTRAINT `fk_TNA_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TB`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_TNA_nestingContextUUID`
    FOREIGN KEY (`nestingContextUUID`)
    REFERENCES `OML`.`C`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_TNA_nestingTerminologyIRI`
    FOREIGN KEY (`nestingTerminologyIRI`)
    REFERENCES `OML`.`TB`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Aspects
-- Table `OML`.`A`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`A` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `name`  TEXT,
  CONSTRAINT `fk_A_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TB`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Concepts
-- Table `OML`.`C`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`C` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `name`  TEXT,
  CONSTRAINT `fk_C_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TB`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- ReifiedRelationships
-- Table `OML`.`RR`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`RR` (
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
  CONSTRAINT `fk_RR_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TB`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RR_sourceUUID`
    FOREIGN KEY (`sourceUUID`)
    REFERENCES `OML`.`E`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RR_targetUUID`
    FOREIGN KEY (`targetUUID`)
    REFERENCES `OML`.`E`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- UnreifiedRelationships
-- Table `OML`.`UR`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`UR` (
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
  CONSTRAINT `fk_UR_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TB`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_UR_sourceUUID`
    FOREIGN KEY (`sourceUUID`)
    REFERENCES `OML`.`E`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_UR_targetUUID`
    FOREIGN KEY (`targetUUID`)
    REFERENCES `OML`.`E`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Scalars
-- Table `OML`.`S`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`S` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `name`  TEXT,
  CONSTRAINT `fk_S_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TB`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- Structures
-- Table `OML`.`S`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`S` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `name`  TEXT,
  CONSTRAINT `fk_S_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TB`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- BinaryScalarRestrictions
-- Table `OML`.`BSR`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`BSR` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `restrictedRangeUUID`  BINARY(16) NOT NULL,
  
    `length`  TEXT,
    `minLength`  TEXT,
    `maxLength`  TEXT,
    `name`  TEXT,
  CONSTRAINT `fk_BSR_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TB`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_BSR_restrictedRangeUUID`
    FOREIGN KEY (`restrictedRangeUUID`)
    REFERENCES `OML`.`DR`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- IRIScalarRestrictions
-- Table `OML`.`IRISR`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`IRISR` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `restrictedRangeUUID`  BINARY(16) NOT NULL,
  
    `length`  TEXT,
    `minLength`  TEXT,
    `maxLength`  TEXT,
    `name`  TEXT,
    `pattern`  TEXT,
  CONSTRAINT `fk_IRISR_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TB`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_IRISR_restrictedRangeUUID`
    FOREIGN KEY (`restrictedRangeUUID`)
    REFERENCES `OML`.`DR`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- NumericScalarRestrictions
-- Table `OML`.`NSR`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`NSR` (
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
  CONSTRAINT `fk_NSR_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TB`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_NSR_restrictedRangeUUID`
    FOREIGN KEY (`restrictedRangeUUID`)
    REFERENCES `OML`.`DR`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_NSR_minExclusive`
    FOREIGN KEY (`minExclusive`)
    REFERENCES `OML`.`LN`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_NSR_minInclusive`
    FOREIGN KEY (`minInclusive`)
    REFERENCES `OML`.`LN`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_NSR_maxExclusive`
    FOREIGN KEY (`maxExclusive`)
    REFERENCES `OML`.`LN`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_NSR_maxInclusive`
    FOREIGN KEY (`maxInclusive`)
    REFERENCES `OML`.`LN`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- PlainLiteralScalarRestrictions
-- Table `OML`.`PLSR`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`PLSR` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `restrictedRangeUUID`  BINARY(16) NOT NULL,
  
    `length`  TEXT,
    `minLength`  TEXT,
    `maxLength`  TEXT,
    `name`  TEXT,
    `langRange`  TEXT,
    `pattern`  TEXT,
  CONSTRAINT `fk_PLSR_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TB`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_PLSR_restrictedRangeUUID`
    FOREIGN KEY (`restrictedRangeUUID`)
    REFERENCES `OML`.`DR`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- ScalarOneOfRestrictions
-- Table `OML`.`SOOR`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`SOOR` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `restrictedRangeUUID`  BINARY(16) NOT NULL,
  
    `name`  TEXT,
  CONSTRAINT `fk_SOOR_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TB`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SOOR_restrictedRangeUUID`
    FOREIGN KEY (`restrictedRangeUUID`)
    REFERENCES `OML`.`DR`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- StringScalarRestrictions
-- Table `OML`.`SSR`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`SSR` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `restrictedRangeUUID`  BINARY(16) NOT NULL,
  
    `length`  TEXT,
    `minLength`  TEXT,
    `maxLength`  TEXT,
    `name`  TEXT,
    `pattern`  TEXT,
  CONSTRAINT `fk_SSR_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TB`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SSR_restrictedRangeUUID`
    FOREIGN KEY (`restrictedRangeUUID`)
    REFERENCES `OML`.`DR`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- SynonymScalarRestrictions
-- Table `OML`.`SSR`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`SSR` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `restrictedRangeUUID`  BINARY(16) NOT NULL,
  
    `name`  TEXT,
  CONSTRAINT `fk_SSR_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TB`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SSR_restrictedRangeUUID`
    FOREIGN KEY (`restrictedRangeUUID`)
    REFERENCES `OML`.`DR`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- TimeScalarRestrictions
-- Table `OML`.`TSR`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`TSR` (
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
  CONSTRAINT `fk_TSR_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TB`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_TSR_restrictedRangeUUID`
    FOREIGN KEY (`restrictedRangeUUID`)
    REFERENCES `OML`.`DR`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_TSR_minExclusive`
    FOREIGN KEY (`minExclusive`)
    REFERENCES `OML`.`LDT`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_TSR_minInclusive`
    FOREIGN KEY (`minInclusive`)
    REFERENCES `OML`.`LDT`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_TSR_maxExclusive`
    FOREIGN KEY (`maxExclusive`)
    REFERENCES `OML`.`LDT`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_TSR_maxInclusive`
    FOREIGN KEY (`maxInclusive`)
    REFERENCES `OML`.`LDT`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- EntityScalarDataProperties
-- Table `OML`.`ESDP`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ESDP` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `domainUUID`  BINARY(16) NOT NULL,
  
    `rangeUUID`  BINARY(16) NOT NULL,
  
    `isIdentityCriteria`  TEXT,
    `name`  TEXT,
  CONSTRAINT `fk_ESDP_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TB`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ESDP_domainUUID`
    FOREIGN KEY (`domainUUID`)
    REFERENCES `OML`.`E`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ESDP_rangeUUID`
    FOREIGN KEY (`rangeUUID`)
    REFERENCES `OML`.`DR`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- EntityStructuredDataProperties
-- Table `OML`.`ESDP`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ESDP` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `domainUUID`  BINARY(16) NOT NULL,
  
    `rangeUUID`  BINARY(16) NOT NULL,
  
    `isIdentityCriteria`  TEXT,
    `name`  TEXT,
  CONSTRAINT `fk_ESDP_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TB`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ESDP_domainUUID`
    FOREIGN KEY (`domainUUID`)
    REFERENCES `OML`.`E`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ESDP_rangeUUID`
    FOREIGN KEY (`rangeUUID`)
    REFERENCES `OML`.`S`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- ScalarDataProperties
-- Table `OML`.`SDP`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`SDP` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `domainUUID`  BINARY(16) NOT NULL,
  
    `rangeUUID`  BINARY(16) NOT NULL,
  
    `name`  TEXT,
  CONSTRAINT `fk_SDP_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TB`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SDP_domainUUID`
    FOREIGN KEY (`domainUUID`)
    REFERENCES `OML`.`S`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SDP_rangeUUID`
    FOREIGN KEY (`rangeUUID`)
    REFERENCES `OML`.`DR`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- StructuredDataProperties
-- Table `OML`.`SDP`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`SDP` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `domainUUID`  BINARY(16) NOT NULL,
  
    `rangeUUID`  BINARY(16) NOT NULL,
  
    `name`  TEXT,
  CONSTRAINT `fk_SDP_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TB`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SDP_domainUUID`
    FOREIGN KEY (`domainUUID`)
    REFERENCES `OML`.`S`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SDP_rangeUUID`
    FOREIGN KEY (`rangeUUID`)
    REFERENCES `OML`.`S`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- AspectSpecializationAxioms
-- Table `OML`.`ASA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ASA` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `superAspectUUID`  BINARY(16) NOT NULL,
  
    `subEntityUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_ASA_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TB`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ASA_superAspectUUID`
    FOREIGN KEY (`superAspectUUID`)
    REFERENCES `OML`.`A`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ASA_subEntityUUID`
    FOREIGN KEY (`subEntityUUID`)
    REFERENCES `OML`.`E`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- ConceptSpecializationAxioms
-- Table `OML`.`CSA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`CSA` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `superConceptUUID`  BINARY(16) NOT NULL,
  
    `subConceptUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_CSA_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TB`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_CSA_superConceptUUID`
    FOREIGN KEY (`superConceptUUID`)
    REFERENCES `OML`.`C`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_CSA_subConceptUUID`
    FOREIGN KEY (`subConceptUUID`)
    REFERENCES `OML`.`C`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- ReifiedRelationshipSpecializationAxioms
-- Table `OML`.`RRSA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`RRSA` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `superRelationshipUUID`  BINARY(16) NOT NULL,
  
    `subRelationshipUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_RRSA_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TB`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RRSA_superRelationshipUUID`
    FOREIGN KEY (`superRelationshipUUID`)
    REFERENCES `OML`.`RR`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RRSA_subRelationshipUUID`
    FOREIGN KEY (`subRelationshipUUID`)
    REFERENCES `OML`.`RR`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- EntityExistentialRestrictionAxioms
-- Table `OML`.`EERA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`EERA` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `restrictedRelationUUID`  BINARY(16) NOT NULL,
  
    `restrictedDomainUUID`  BINARY(16) NOT NULL,
  
    `restrictedRangeUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_EERA_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TB`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EERA_restrictedRelationUUID`
    FOREIGN KEY (`restrictedRelationUUID`)
    REFERENCES `OML`.`ER`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EERA_restrictedDomainUUID`
    FOREIGN KEY (`restrictedDomainUUID`)
    REFERENCES `OML`.`E`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EERA_restrictedRangeUUID`
    FOREIGN KEY (`restrictedRangeUUID`)
    REFERENCES `OML`.`E`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- EntityUniversalRestrictionAxioms
-- Table `OML`.`EURA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`EURA` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `restrictedRelationUUID`  BINARY(16) NOT NULL,
  
    `restrictedDomainUUID`  BINARY(16) NOT NULL,
  
    `restrictedRangeUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_EURA_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TB`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EURA_restrictedRelationUUID`
    FOREIGN KEY (`restrictedRelationUUID`)
    REFERENCES `OML`.`ER`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EURA_restrictedDomainUUID`
    FOREIGN KEY (`restrictedDomainUUID`)
    REFERENCES `OML`.`E`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EURA_restrictedRangeUUID`
    FOREIGN KEY (`restrictedRangeUUID`)
    REFERENCES `OML`.`E`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- EntityScalarDataPropertyExistentialRestrictionAxioms
-- Table `OML`.`ESDPERA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ESDPERA` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `restrictedEntityUUID`  BINARY(16) NOT NULL,
  
    `scalarPropertyUUID`  BINARY(16) NOT NULL,
  
    `scalarRestrictionUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_ESDPERA_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TB`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ESDPERA_restrictedEntityUUID`
    FOREIGN KEY (`restrictedEntityUUID`)
    REFERENCES `OML`.`E`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ESDPERA_scalarPropertyUUID`
    FOREIGN KEY (`scalarPropertyUUID`)
    REFERENCES `OML`.`ESDP`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ESDPERA_scalarRestrictionUUID`
    FOREIGN KEY (`scalarRestrictionUUID`)
    REFERENCES `OML`.`DR`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- EntityScalarDataPropertyParticularRestrictionAxioms
-- Table `OML`.`ESDPPRA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ESDPPRA` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `restrictedEntityUUID`  BINARY(16) NOT NULL,
  
    `scalarPropertyUUID`  BINARY(16) NOT NULL,
  
    `literalValue`  -- TODO: LiteralFeature
  TEXT, `literalValueLiteralType` VARCHAR(20) NOT NULL,
  
    `valueTypeUUID`  BINARY(16) NULL
  ,
  CONSTRAINT `fk_ESDPPRA_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TB`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ESDPPRA_restrictedEntityUUID`
    FOREIGN KEY (`restrictedEntityUUID`)
    REFERENCES `OML`.`E`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ESDPPRA_scalarPropertyUUID`
    FOREIGN KEY (`scalarPropertyUUID`)
    REFERENCES `OML`.`ESDP`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ESDPPRA_literalValue`
    FOREIGN KEY (`literalValue`)
    REFERENCES `OML`.`LV`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ESDPPRA_valueTypeUUID`
    FOREIGN KEY (`valueTypeUUID`)
    REFERENCES `OML`.`DR`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- EntityScalarDataPropertyUniversalRestrictionAxioms
-- Table `OML`.`ESDPURA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ESDPURA` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `restrictedEntityUUID`  BINARY(16) NOT NULL,
  
    `scalarPropertyUUID`  BINARY(16) NOT NULL,
  
    `scalarRestrictionUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_ESDPURA_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TB`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ESDPURA_restrictedEntityUUID`
    FOREIGN KEY (`restrictedEntityUUID`)
    REFERENCES `OML`.`E`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ESDPURA_scalarPropertyUUID`
    FOREIGN KEY (`scalarPropertyUUID`)
    REFERENCES `OML`.`ESDP`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ESDPURA_scalarRestrictionUUID`
    FOREIGN KEY (`scalarRestrictionUUID`)
    REFERENCES `OML`.`DR`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- ScalarOneOfLiteralAxioms
-- Table `OML`.`SOOLA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`SOOLA` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `axiomUUID`  BINARY(16) NOT NULL,
  
    `value`  -- TODO: LiteralFeature
  TEXT, `valueLiteralType` VARCHAR(20) NOT NULL,
  
    `valueTypeUUID`  BINARY(16) NULL
  ,
  CONSTRAINT `fk_SOOLA_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TB`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SOOLA_axiomUUID`
    FOREIGN KEY (`axiomUUID`)
    REFERENCES `OML`.`SOOR`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SOOLA_value`
    FOREIGN KEY (`value`)
    REFERENCES `OML`.`LV`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SOOLA_valueTypeUUID`
    FOREIGN KEY (`valueTypeUUID`)
    REFERENCES `OML`.`DR`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- BundledTerminologyAxioms
-- Table `OML`.`BTA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`BTA` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `bundleUUID`  BINARY(16) NOT NULL,
  
    `bundledTerminologyIRI`  VARCHAR(256) NOT NULL
  ,
  CONSTRAINT `fk_BTA_bundleUUID`
    FOREIGN KEY (`bundleUUID`)
    REFERENCES `OML`.`B`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_BTA_bundledTerminologyIRI`
    FOREIGN KEY (`bundledTerminologyIRI`)
    REFERENCES `OML`.`TB`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- RootConceptTaxonomyAxioms
-- Table `OML`.`RCTA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`RCTA` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `bundleUUID`  BINARY(16) NOT NULL,
  
    `rootUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_RCTA_bundleUUID`
    FOREIGN KEY (`bundleUUID`)
    REFERENCES `OML`.`B`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RCTA_rootUUID`
    FOREIGN KEY (`rootUUID`)
    REFERENCES `OML`.`C`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- SpecificDisjointConceptAxioms
-- Table `OML`.`SDCA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`SDCA` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `disjointTaxonomyParentUUID`  BINARY(16) NOT NULL,
  
    `disjointLeafUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_SDCA_disjointTaxonomyParentUUID`
    FOREIGN KEY (`disjointTaxonomyParentUUID`)
    REFERENCES `OML`.`CTD`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SDCA_disjointLeafUUID`
    FOREIGN KEY (`disjointLeafUUID`)
    REFERENCES `OML`.`C`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- AnnotationPropertyValues
-- Table `OML`.`APV`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`APV` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `subjectUUID`  BINARY(16) NOT NULL,
  
    `propertyUUID`  BINARY(16) NOT NULL,
  
    `value`  -- TODO: LiteralFeature
  TEXT, `valueLiteralType` VARCHAR(20) NOT NULL
  ,
  CONSTRAINT `fk_APV_subjectUUID`
    FOREIGN KEY (`subjectUUID`)
    REFERENCES `OML`.`LE`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_APV_propertyUUID`
    FOREIGN KEY (`propertyUUID`)
    REFERENCES `OML`.`AP`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_APV_value`
    FOREIGN KEY (`value`)
    REFERENCES `OML`.`LS`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- AnonymousConceptUnionAxioms
-- Table `OML`.`ACUA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ACUA` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `disjointTaxonomyParentUUID`  BINARY(16) NOT NULL,
  
    `name`  TEXT,
  CONSTRAINT `fk_ACUA_disjointTaxonomyParentUUID`
    FOREIGN KEY (`disjointTaxonomyParentUUID`)
    REFERENCES `OML`.`CTD`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- AspectPredicates
-- Table `OML`.`AP`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`AP` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `aspectUUID`  BINARY(16) NOT NULL,
  
    `bodySegmentUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_AP_aspectUUID`
    FOREIGN KEY (`aspectUUID`)
    REFERENCES `OML`.`A`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_AP_bodySegmentUUID`
    FOREIGN KEY (`bodySegmentUUID`)
    REFERENCES `OML`.`RBS`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- ChainRules
-- Table `OML`.`CR`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`CR` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `name`  TEXT,
    `headUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_CR_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TB`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_CR_headUUID`
    FOREIGN KEY (`headUUID`)
    REFERENCES `OML`.`UR`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- ConceptInstances
-- Table `OML`.`CI`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`CI` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `descriptionBoxUUID`  BINARY(16) NOT NULL,
  
    `singletonConceptClassifierUUID`  BINARY(16) NOT NULL,
  
    `name`  TEXT,
  CONSTRAINT `fk_CI_descriptionBoxUUID`
    FOREIGN KEY (`descriptionBoxUUID`)
    REFERENCES `OML`.`DB`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_CI_singletonConceptClassifierUUID`
    FOREIGN KEY (`singletonConceptClassifierUUID`)
    REFERENCES `OML`.`C`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- ConceptPredicates
-- Table `OML`.`CP`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`CP` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `bodySegmentUUID`  BINARY(16) NOT NULL,
  
    `conceptUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_CP_bodySegmentUUID`
    FOREIGN KEY (`bodySegmentUUID`)
    REFERENCES `OML`.`RBS`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_CP_conceptUUID`
    FOREIGN KEY (`conceptUUID`)
    REFERENCES `OML`.`C`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- DescriptionBoxes
-- Table `OML`.`DB`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`DB` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `kind`  TEXT,
    `iri`  TEXT,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- DescriptionBoxExtendsClosedWorldDefinitions
-- Table `OML`.`DBECWD`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`DBECWD` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `descriptionBoxUUID`  BINARY(16) NOT NULL,
  
    `closedWorldDefinitionsIRI`  VARCHAR(256) NOT NULL
  ,
  CONSTRAINT `fk_DBECWD_descriptionBoxUUID`
    FOREIGN KEY (`descriptionBoxUUID`)
    REFERENCES `OML`.`DB`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_DBECWD_closedWorldDefinitionsIRI`
    FOREIGN KEY (`closedWorldDefinitionsIRI`)
    REFERENCES `OML`.`TB`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- DescriptionBoxRefinements
-- Table `OML`.`DBR`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`DBR` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `refiningDescriptionBoxUUID`  BINARY(16) NOT NULL,
  
    `refinedDescriptionBoxIRI`  VARCHAR(256) NOT NULL
  ,
  CONSTRAINT `fk_DBR_refiningDescriptionBoxUUID`
    FOREIGN KEY (`refiningDescriptionBoxUUID`)
    REFERENCES `OML`.`DB`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_DBR_refinedDescriptionBoxIRI`
    FOREIGN KEY (`refinedDescriptionBoxIRI`)
    REFERENCES `OML`.`DB`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- EntityStructuredDataPropertyParticularRestrictionAxioms
-- Table `OML`.`ESDPPRA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ESDPPRA` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `structuredDataPropertyUUID`  BINARY(16) NOT NULL,
  
    `restrictedEntityUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_ESDPPRA_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TB`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ESDPPRA_structuredDataPropertyUUID`
    FOREIGN KEY (`structuredDataPropertyUUID`)
    REFERENCES `OML`.`DRTS`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ESDPPRA_restrictedEntityUUID`
    FOREIGN KEY (`restrictedEntityUUID`)
    REFERENCES `OML`.`E`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- ReifiedRelationshipInstances
-- Table `OML`.`RRI`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`RRI` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `descriptionBoxUUID`  BINARY(16) NOT NULL,
  
    `singletonReifiedRelationshipClassifierUUID`  BINARY(16) NOT NULL,
  
    `name`  TEXT,
  CONSTRAINT `fk_RRI_descriptionBoxUUID`
    FOREIGN KEY (`descriptionBoxUUID`)
    REFERENCES `OML`.`DB`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RRI_singletonReifiedRelationshipClassifierUUID`
    FOREIGN KEY (`singletonReifiedRelationshipClassifierUUID`)
    REFERENCES `OML`.`RR`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- ReifiedRelationshipInstanceDomains
-- Table `OML`.`RRID`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`RRID` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `descriptionBoxUUID`  BINARY(16) NOT NULL,
  
    `reifiedRelationshipInstanceUUID`  BINARY(16) NOT NULL,
  
    `domainUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_RRID_descriptionBoxUUID`
    FOREIGN KEY (`descriptionBoxUUID`)
    REFERENCES `OML`.`DB`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RRID_reifiedRelationshipInstanceUUID`
    FOREIGN KEY (`reifiedRelationshipInstanceUUID`)
    REFERENCES `OML`.`RRI`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RRID_domainUUID`
    FOREIGN KEY (`domainUUID`)
    REFERENCES `OML`.`CESI`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- ReifiedRelationshipInstanceRanges
-- Table `OML`.`RRIR`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`RRIR` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `descriptionBoxUUID`  BINARY(16) NOT NULL,
  
    `reifiedRelationshipInstanceUUID`  BINARY(16) NOT NULL,
  
    `rangeUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_RRIR_descriptionBoxUUID`
    FOREIGN KEY (`descriptionBoxUUID`)
    REFERENCES `OML`.`DB`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RRIR_reifiedRelationshipInstanceUUID`
    FOREIGN KEY (`reifiedRelationshipInstanceUUID`)
    REFERENCES `OML`.`RRI`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RRIR_rangeUUID`
    FOREIGN KEY (`rangeUUID`)
    REFERENCES `OML`.`CESI`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- ReifiedRelationshipInversePropertyPredicates
-- Table `OML`.`RRIPP`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`RRIPP` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `bodySegmentUUID`  BINARY(16) NOT NULL,
  
    `reifiedRelationshipUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_RRIPP_bodySegmentUUID`
    FOREIGN KEY (`bodySegmentUUID`)
    REFERENCES `OML`.`RBS`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RRIPP_reifiedRelationshipUUID`
    FOREIGN KEY (`reifiedRelationshipUUID`)
    REFERENCES `OML`.`RR`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- ReifiedRelationshipPredicates
-- Table `OML`.`RRP`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`RRP` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `bodySegmentUUID`  BINARY(16) NOT NULL,
  
    `reifiedRelationshipUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_RRP_bodySegmentUUID`
    FOREIGN KEY (`bodySegmentUUID`)
    REFERENCES `OML`.`RBS`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RRP_reifiedRelationshipUUID`
    FOREIGN KEY (`reifiedRelationshipUUID`)
    REFERENCES `OML`.`RR`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- ReifiedRelationshipPropertyPredicates
-- Table `OML`.`RRPP`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`RRPP` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `bodySegmentUUID`  BINARY(16) NOT NULL,
  
    `reifiedRelationshipUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_RRPP_bodySegmentUUID`
    FOREIGN KEY (`bodySegmentUUID`)
    REFERENCES `OML`.`RBS`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RRPP_reifiedRelationshipUUID`
    FOREIGN KEY (`reifiedRelationshipUUID`)
    REFERENCES `OML`.`RR`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- ReifiedRelationshipSourceInversePropertyPredicates
-- Table `OML`.`RRSIPP`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`RRSIPP` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `bodySegmentUUID`  BINARY(16) NOT NULL,
  
    `reifiedRelationshipUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_RRSIPP_bodySegmentUUID`
    FOREIGN KEY (`bodySegmentUUID`)
    REFERENCES `OML`.`RBS`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RRSIPP_reifiedRelationshipUUID`
    FOREIGN KEY (`reifiedRelationshipUUID`)
    REFERENCES `OML`.`RR`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- ReifiedRelationshipSourcePropertyPredicates
-- Table `OML`.`RRSPP`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`RRSPP` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `bodySegmentUUID`  BINARY(16) NOT NULL,
  
    `reifiedRelationshipUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_RRSPP_bodySegmentUUID`
    FOREIGN KEY (`bodySegmentUUID`)
    REFERENCES `OML`.`RBS`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RRSPP_reifiedRelationshipUUID`
    FOREIGN KEY (`reifiedRelationshipUUID`)
    REFERENCES `OML`.`RR`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- ReifiedRelationshipTargetInversePropertyPredicates
-- Table `OML`.`RRTIPP`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`RRTIPP` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `bodySegmentUUID`  BINARY(16) NOT NULL,
  
    `reifiedRelationshipUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_RRTIPP_bodySegmentUUID`
    FOREIGN KEY (`bodySegmentUUID`)
    REFERENCES `OML`.`RBS`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RRTIPP_reifiedRelationshipUUID`
    FOREIGN KEY (`reifiedRelationshipUUID`)
    REFERENCES `OML`.`RR`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- ReifiedRelationshipTargetPropertyPredicates
-- Table `OML`.`RRTPP`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`RRTPP` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `bodySegmentUUID`  BINARY(16) NOT NULL,
  
    `reifiedRelationshipUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_RRTPP_bodySegmentUUID`
    FOREIGN KEY (`bodySegmentUUID`)
    REFERENCES `OML`.`RBS`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RRTPP_reifiedRelationshipUUID`
    FOREIGN KEY (`reifiedRelationshipUUID`)
    REFERENCES `OML`.`RR`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- RestrictionScalarDataPropertyValues
-- Table `OML`.`RSDPV`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`RSDPV` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `scalarDataPropertyUUID`  BINARY(16) NOT NULL,
  
    `scalarPropertyValue`  -- TODO: LiteralFeature
  TEXT, `scalarPropertyValueLiteralType` VARCHAR(20) NOT NULL,
  
    `structuredDataPropertyContextUUID`  BINARY(16) NOT NULL,
  
    `valueTypeUUID`  BINARY(16) NULL
  ,
  CONSTRAINT `fk_RSDPV_scalarDataPropertyUUID`
    FOREIGN KEY (`scalarDataPropertyUUID`)
    REFERENCES `OML`.`DRTS`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RSDPV_scalarPropertyValue`
    FOREIGN KEY (`scalarPropertyValue`)
    REFERENCES `OML`.`LV`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RSDPV_structuredDataPropertyContextUUID`
    FOREIGN KEY (`structuredDataPropertyContextUUID`)
    REFERENCES `OML`.`RSDPC`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RSDPV_valueTypeUUID`
    FOREIGN KEY (`valueTypeUUID`)
    REFERENCES `OML`.`DR`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- RestrictionStructuredDataPropertyTuples
-- Table `OML`.`RSDPT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`RSDPT` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `structuredDataPropertyUUID`  BINARY(16) NOT NULL,
  
    `structuredDataPropertyContextUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_RSDPT_structuredDataPropertyUUID`
    FOREIGN KEY (`structuredDataPropertyUUID`)
    REFERENCES `OML`.`DRTS`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RSDPT_structuredDataPropertyContextUUID`
    FOREIGN KEY (`structuredDataPropertyContextUUID`)
    REFERENCES `OML`.`RSDPC`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- RuleBodySegments
-- Table `OML`.`RBS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`RBS` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `previousSegmentUUID`  BINARY(16) NULL,
  
    `ruleUUID`  BINARY(16) NULL
  ,
  CONSTRAINT `fk_RBS_previousSegmentUUID`
    FOREIGN KEY (`previousSegmentUUID`)
    REFERENCES `OML`.`RBS`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RBS_ruleUUID`
    FOREIGN KEY (`ruleUUID`)
    REFERENCES `OML`.`CR`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- ScalarDataPropertyValues
-- Table `OML`.`SDPV`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`SDPV` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `scalarDataPropertyUUID`  BINARY(16) NOT NULL,
  
    `scalarPropertyValue`  -- TODO: LiteralFeature
  TEXT, `scalarPropertyValueLiteralType` VARCHAR(20) NOT NULL,
  
    `structuredDataPropertyContextUUID`  BINARY(16) NOT NULL,
  
    `valueTypeUUID`  BINARY(16) NULL
  ,
  CONSTRAINT `fk_SDPV_scalarDataPropertyUUID`
    FOREIGN KEY (`scalarDataPropertyUUID`)
    REFERENCES `OML`.`DRTS`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SDPV_scalarPropertyValue`
    FOREIGN KEY (`scalarPropertyValue`)
    REFERENCES `OML`.`LV`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SDPV_structuredDataPropertyContextUUID`
    FOREIGN KEY (`structuredDataPropertyContextUUID`)
    REFERENCES `OML`.`SISDPC`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SDPV_valueTypeUUID`
    FOREIGN KEY (`valueTypeUUID`)
    REFERENCES `OML`.`DR`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- SingletonInstanceScalarDataPropertyValues
-- Table `OML`.`SISDPV`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`SISDPV` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `descriptionBoxUUID`  BINARY(16) NOT NULL,
  
    `singletonInstanceUUID`  BINARY(16) NOT NULL,
  
    `scalarDataPropertyUUID`  BINARY(16) NOT NULL,
  
    `scalarPropertyValue`  -- TODO: LiteralFeature
  TEXT, `scalarPropertyValueLiteralType` VARCHAR(20) NOT NULL,
  
    `valueTypeUUID`  BINARY(16) NULL
  ,
  CONSTRAINT `fk_SISDPV_descriptionBoxUUID`
    FOREIGN KEY (`descriptionBoxUUID`)
    REFERENCES `OML`.`DB`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SISDPV_singletonInstanceUUID`
    FOREIGN KEY (`singletonInstanceUUID`)
    REFERENCES `OML`.`CESI`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SISDPV_scalarDataPropertyUUID`
    FOREIGN KEY (`scalarDataPropertyUUID`)
    REFERENCES `OML`.`ESDP`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SISDPV_scalarPropertyValue`
    FOREIGN KEY (`scalarPropertyValue`)
    REFERENCES `OML`.`LV`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SISDPV_valueTypeUUID`
    FOREIGN KEY (`valueTypeUUID`)
    REFERENCES `OML`.`DR`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- SingletonInstanceStructuredDataPropertyValues
-- Table `OML`.`SISDPV`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`SISDPV` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `descriptionBoxUUID`  BINARY(16) NOT NULL,
  
    `singletonInstanceUUID`  BINARY(16) NOT NULL,
  
    `structuredDataPropertyUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_SISDPV_descriptionBoxUUID`
    FOREIGN KEY (`descriptionBoxUUID`)
    REFERENCES `OML`.`DB`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SISDPV_singletonInstanceUUID`
    FOREIGN KEY (`singletonInstanceUUID`)
    REFERENCES `OML`.`CESI`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SISDPV_structuredDataPropertyUUID`
    FOREIGN KEY (`structuredDataPropertyUUID`)
    REFERENCES `OML`.`DRTS`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- StructuredDataPropertyTuples
-- Table `OML`.`SDPT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`SDPT` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `structuredDataPropertyUUID`  BINARY(16) NOT NULL,
  
    `structuredDataPropertyContextUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_SDPT_structuredDataPropertyUUID`
    FOREIGN KEY (`structuredDataPropertyUUID`)
    REFERENCES `OML`.`DRTS`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SDPT_structuredDataPropertyContextUUID`
    FOREIGN KEY (`structuredDataPropertyContextUUID`)
    REFERENCES `OML`.`SISDPC`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- SubDataPropertyOfAxioms
-- Table `OML`.`SDPOA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`SDPOA` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `subPropertyUUID`  BINARY(16) NOT NULL,
  
    `superPropertyUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_SDPOA_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TB`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SDPOA_subPropertyUUID`
    FOREIGN KEY (`subPropertyUUID`)
    REFERENCES `OML`.`ESDP`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SDPOA_superPropertyUUID`
    FOREIGN KEY (`superPropertyUUID`)
    REFERENCES `OML`.`ESDP`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- SubObjectPropertyOfAxioms
-- Table `OML`.`SOPOA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`SOPOA` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `tboxUUID`  BINARY(16) NOT NULL,
  
    `subPropertyUUID`  BINARY(16) NOT NULL,
  
    `superPropertyUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_SOPOA_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TB`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SOPOA_subPropertyUUID`
    FOREIGN KEY (`subPropertyUUID`)
    REFERENCES `OML`.`UR`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SOPOA_superPropertyUUID`
    FOREIGN KEY (`superPropertyUUID`)
    REFERENCES `OML`.`UR`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- UnreifiedRelationshipInstanceTuples
-- Table `OML`.`URIT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`URIT` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `descriptionBoxUUID`  BINARY(16) NOT NULL,
  
    `unreifiedRelationshipUUID`  BINARY(16) NOT NULL,
  
    `domainUUID`  BINARY(16) NOT NULL,
  
    `rangeUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_URIT_descriptionBoxUUID`
    FOREIGN KEY (`descriptionBoxUUID`)
    REFERENCES `OML`.`DB`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_URIT_unreifiedRelationshipUUID`
    FOREIGN KEY (`unreifiedRelationshipUUID`)
    REFERENCES `OML`.`UR`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_URIT_domainUUID`
    FOREIGN KEY (`domainUUID`)
    REFERENCES `OML`.`CESI`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_URIT_rangeUUID`
    FOREIGN KEY (`rangeUUID`)
    REFERENCES `OML`.`CESI`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- UnreifiedRelationshipInversePropertyPredicates
-- Table `OML`.`URIPP`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`URIPP` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `unreifiedRelationshipUUID`  BINARY(16) NOT NULL,
  
    `bodySegmentUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_URIPP_unreifiedRelationshipUUID`
    FOREIGN KEY (`unreifiedRelationshipUUID`)
    REFERENCES `OML`.`UR`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_URIPP_bodySegmentUUID`
    FOREIGN KEY (`bodySegmentUUID`)
    REFERENCES `OML`.`RBS`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
-- -----------------------------------------------------
-- UnreifiedRelationshipPropertyPredicates
-- Table `OML`.`URPP`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`URPP` (
  `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
  
    `unreifiedRelationshipUUID`  BINARY(16) NOT NULL,
  
    `bodySegmentUUID`  BINARY(16) NOT NULL
  ,
  CONSTRAINT `fk_URPP_unreifiedRelationshipUUID`
    FOREIGN KEY (`unreifiedRelationshipUUID`)
    REFERENCES `OML`.`UR`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_URPP_bodySegmentUUID`
    FOREIGN KEY (`bodySegmentUUID`)
    REFERENCES `OML`.`RBS`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
);
  
  		  

