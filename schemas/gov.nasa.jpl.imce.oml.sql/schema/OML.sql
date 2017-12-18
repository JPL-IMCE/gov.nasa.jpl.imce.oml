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

-- Summary of abstract table names
-- 
-- BinSegFwdPropP       BinarySegmentForwardPropertyPredicates
-- BinSegPropP          BinarySegmentPropertyPredicates
-- BinSegRevPropP       BinarySegmentReversePropertyPredicates
-- CRBK                 CrossReferencableKinds
-- CRTK                 CrossReferencabilityKinds
-- CTreeDsju            ConceptTreeDisjunctions
-- CualESI              ConceptualEntitySingletonInstances
-- CualEs               ConceptualEntities
-- DBoxRels             DescriptionBoxRelationships
-- DRelDomains          DataRelationshipDomains
-- DRelFromEs           DataRelationshipFromEntities
-- DRelFromSts          DataRelationshipFromStructures
-- DRelRanges           DataRelationshipRanges
-- DRelToScs            DataRelationshipToScalars
-- DRelToSts            DataRelationshipToStructures
-- DRels                DataRelationships
-- DirBinRelKinds       DirectedBinaryRelationshipKinds
-- Drs                  DataRanges
-- DsjUOfCsAx           DisjointUnionOfConceptsAxioms
-- Dt                   Datatypes
-- EIdK                 ExtrinsicIdentityKinds
-- ERAx                 EntityRestrictionAxioms
-- ERels                EntityRelationships
-- EScPRAx              EntityScalarDataPropertyRestrictionAxioms
-- EStPRAx              EntityStructuredDataPropertyRestrictionAxioms
-- EltCRefTs            ElementCrossReferenceTuples
-- Es                   Entities
-- IIdK                 IntrinsicIdentityKinds
-- Ik                   IdentityKinds
-- LogEs                LogicalElements
-- ModEdges             ModuleEdges
-- ModElts              ModuleElements
-- Mods                 Modules
-- NonCRBK              NonCrossReferencableKinds
-- NonLogEs             NonLogicalElements
-- RStPCtxts            RestrictionStructuredDataPropertyContexts
-- Ress                 Resources
-- RestDrs              RestrictedDataRanges
-- Rules                Rules
-- S1IStPCtxts          SingletonInstanceStructuredDataPropertyContexts
-- SegP                 SegmentPredicates
-- SpeAx                SpecializationAxioms
-- TBox                 TerminologyBoxes
-- TBoxAx               TerminologyBoxAxioms
-- TBoxSt               TerminologyBoxStatements
-- TermAx               TermAxioms
-- Terms                Terms
-- TlgyAx               TerminologyAxioms
-- TlgyBdlAx            TerminologyBundleAxioms
-- TlgyBdlSt            TerminologyBundleStatements
-- TlgyIAsts            TerminologyInstanceAssertions
-- UrySegP              UnarySegmentPredicates
-- UryTermKinds         UnaryTermKinds
-- ValCRefTs            ValueCrossReferenceTuples
		
-- Summary of concrete table names
-- 
-- AnnotPropVals        AnnotationPropertyValues
-- AnnotProps           AnnotationProperties
-- AnonymousCUnionAx    AnonymousConceptUnionAxioms
-- AspectP              AspectPredicates
-- AspectSpeAx          AspectSpecializationAxioms
-- Aspects              Aspects
-- BdldTlgyAx           BundledTerminologyAxioms
-- Bdls                 Bundles
-- BinScRs              BinaryScalarRestrictions
-- CDesTlgyAx           ConceptDesignationTerminologyAxioms
-- CIs                  ConceptInstances
-- CP                   ConceptPredicates
-- CSpeAx               ConceptSpecializationAxioms
-- ChainRules           ChainRules
-- Cs                   Concepts
-- DBoxExtCWDef         DescriptionBoxExtendsClosedWorldDefinitions
-- DBoxRfns             DescriptionBoxRefinements
-- DBoxes               DescriptionBoxes
-- EExRAx               EntityExistentialRestrictionAxioms
-- EScPExRAx            EntityScalarDataPropertyExistentialRestrictionAxioms
-- EScPPtrRAx           EntityScalarDataPropertyParticularRestrictionAxioms
-- EScPUxRAx            EntityScalarDataPropertyUniversalRestrictionAxioms
-- EScPs                EntityScalarDataProperties
-- EStPPtrRAx           EntityStructuredDataPropertyParticularRestrictionAxioms
-- EStPs                EntityStructuredDataProperties
-- EUxRAx               EntityUniversalRestrictionAxioms
-- IRIScRs              IRIScalarRestrictions
-- NumericScRs          NumericScalarRestrictions
-- PlainLitScRs         PlainLiteralScalarRestrictions
-- RRIDomains           ReifiedRelationshipInstanceDomains
-- RRIRanges            ReifiedRelationshipInstanceRanges
-- RRInvPropP           ReifiedRelationshipInversePropertyPredicates
-- RRIs                 ReifiedRelationshipInstances
-- RRP                  ReifiedRelationshipPredicates
-- RRPropP              ReifiedRelationshipPropertyPredicates
-- RRSpeAx              ReifiedRelationshipSpecializationAxioms
-- RRSrcInvPropP        ReifiedRelationshipSourceInversePropertyPredicates
-- RRSrcPropP           ReifiedRelationshipSourcePropertyPredicates
-- RRTgtInvPropP        ReifiedRelationshipTargetInversePropertyPredicates
-- RRTgtPropP           ReifiedRelationshipTargetPropertyPredicates
-- RRs                  ReifiedRelationships
-- RScPVals             RestrictionScalarDataPropertyValues
-- RStPTs               RestrictionStructuredDataPropertyTuples
-- RootCTaxonomyAx      RootConceptTaxonomyAxioms
-- RuleBodySegs         RuleBodySegments
-- S1IScPVals           SingletonInstanceScalarDataPropertyValues
-- S1IStPVals           SingletonInstanceStructuredDataPropertyValues
-- ScOneOfLitAx         ScalarOneOfLiteralAxioms
-- ScOneOfRs            ScalarOneOfRestrictions
-- ScPVals              ScalarDataPropertyValues
-- ScPs                 ScalarDataProperties
-- Scs                  Scalars
-- SpeDsjtCAx           SpecificDisjointConceptAxioms
-- StPTs                StructuredDataPropertyTuples
-- StPs                 StructuredDataProperties
-- StringScRs           StringScalarRestrictions
-- Sts                  Structures
-- SubDataPropOfAx      SubDataPropertyOfAxioms
-- SubObjectPropOfAx    SubObjectPropertyOfAxioms
-- SynonymScRs          SynonymScalarRestrictions
-- TimeScRs             TimeScalarRestrictions
-- TlgyExtensionAx      TerminologyExtensionAxioms
-- TlgyGraphs           TerminologyGraphs
-- TlgyNestingAx        TerminologyNestingAxioms
-- URITs                UnreifiedRelationshipInstanceTuples
-- URInvPropP           UnreifiedRelationshipInversePropertyPredicates
-- URPropP              UnreifiedRelationshipPropertyPredicates
-- URs                  UnreifiedRelationships

-- -----------------------------------------------------
-- Table `OML`.`BinSegFwdPropP`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`BinSegFwdPropP` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table BinarySegmentForwardPropertyPredicates';

-- -----------------------------------------------------
-- Table `OML`.`BinSegPropP`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`BinSegPropP` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table BinarySegmentPropertyPredicates';

-- -----------------------------------------------------
-- Table `OML`.`BinSegRevPropP`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`BinSegRevPropP` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table BinarySegmentReversePropertyPredicates';

-- -----------------------------------------------------
-- Table `OML`.`CTreeDsju`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`CTreeDsju` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table ConceptTreeDisjunctions';

-- -----------------------------------------------------
-- Table `OML`.`CualEs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`CualEs` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table ConceptualEntities';

-- -----------------------------------------------------
-- Table `OML`.`CualESI`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`CualESI` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table ConceptualEntitySingletonInstances';

-- -----------------------------------------------------
-- Table `OML`.`CRTK`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`CRTK` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table CrossReferencabilityKinds';

-- -----------------------------------------------------
-- Table `OML`.`CRBK`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`CRBK` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table CrossReferencableKinds';

-- -----------------------------------------------------
-- Table `OML`.`Drs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`Drs` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table DataRanges';

-- -----------------------------------------------------
-- Table `OML`.`DRels`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`DRels` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table DataRelationships';

-- -----------------------------------------------------
-- Table `OML`.`DRelDomains`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`DRelDomains` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table DataRelationshipDomains';

-- -----------------------------------------------------
-- Table `OML`.`DRelFromEs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`DRelFromEs` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table DataRelationshipFromEntities';

-- -----------------------------------------------------
-- Table `OML`.`DRelFromSts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`DRelFromSts` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table DataRelationshipFromStructures';

-- -----------------------------------------------------
-- Table `OML`.`DRelRanges`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`DRelRanges` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table DataRelationshipRanges';

-- -----------------------------------------------------
-- Table `OML`.`DRelToScs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`DRelToScs` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table DataRelationshipToScalars';

-- -----------------------------------------------------
-- Table `OML`.`DRelToSts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`DRelToSts` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table DataRelationshipToStructures';

-- -----------------------------------------------------
-- Table `OML`.`Dt`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`Dt` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table Datatypes';

-- -----------------------------------------------------
-- Table `OML`.`DBoxRels`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`DBoxRels` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table DescriptionBoxRelationships';

-- -----------------------------------------------------
-- Table `OML`.`DirBinRelKinds`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`DirBinRelKinds` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table DirectedBinaryRelationshipKinds';

-- -----------------------------------------------------
-- Table `OML`.`DsjUOfCsAx`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`DsjUOfCsAx` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table DisjointUnionOfConceptsAxioms';

-- -----------------------------------------------------
-- Table `OML`.`EltCRefTs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`EltCRefTs` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table ElementCrossReferenceTuples';

-- -----------------------------------------------------
-- Table `OML`.`Es`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`Es` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table Entities';

-- -----------------------------------------------------
-- Table `OML`.`ERels`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ERels` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table EntityRelationships';

-- -----------------------------------------------------
-- Table `OML`.`ERAx`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ERAx` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table EntityRestrictionAxioms';

-- -----------------------------------------------------
-- Table `OML`.`EScPRAx`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`EScPRAx` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table EntityScalarDataPropertyRestrictionAxioms';

-- -----------------------------------------------------
-- Table `OML`.`EStPRAx`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`EStPRAx` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table EntityStructuredDataPropertyRestrictionAxioms';

-- -----------------------------------------------------
-- Table `OML`.`EIdK`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`EIdK` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table ExtrinsicIdentityKinds';

-- -----------------------------------------------------
-- Table `OML`.`Ik`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`Ik` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table IdentityKinds';

-- -----------------------------------------------------
-- Table `OML`.`IIdK`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`IIdK` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table IntrinsicIdentityKinds';

-- -----------------------------------------------------
-- Table `OML`.`LogEs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`LogEs` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table LogicalElements';

-- -----------------------------------------------------
-- Table `OML`.`Mods`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`Mods` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table Modules';

-- -----------------------------------------------------
-- Table `OML`.`ModEdges`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ModEdges` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table ModuleEdges';

-- -----------------------------------------------------
-- Table `OML`.`ModElts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ModElts` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table ModuleElements';

-- -----------------------------------------------------
-- Table `OML`.`NonCRBK`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`NonCRBK` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table NonCrossReferencableKinds';

-- -----------------------------------------------------
-- Table `OML`.`NonLogEs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`NonLogEs` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table NonLogicalElements';

-- -----------------------------------------------------
-- Table `OML`.`Ress`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`Ress` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table Resources';

-- -----------------------------------------------------
-- Table `OML`.`RestDrs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`RestDrs` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table RestrictedDataRanges';

-- -----------------------------------------------------
-- Table `OML`.`RStPCtxts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`RStPCtxts` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table RestrictionStructuredDataPropertyContexts';

-- -----------------------------------------------------
-- Table `OML`.`Rules`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`Rules` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table Rules';

-- -----------------------------------------------------
-- Table `OML`.`SegP`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`SegP` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table SegmentPredicates';

-- -----------------------------------------------------
-- Table `OML`.`S1IStPCtxts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`S1IStPCtxts` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table SingletonInstanceStructuredDataPropertyContexts';

-- -----------------------------------------------------
-- Table `OML`.`SpeAx`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`SpeAx` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table SpecializationAxioms';

-- -----------------------------------------------------
-- Table `OML`.`Terms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`Terms` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table Terms';

-- -----------------------------------------------------
-- Table `OML`.`TermAx`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`TermAx` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table TermAxioms';

-- -----------------------------------------------------
-- Table `OML`.`TlgyAx`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`TlgyAx` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table TerminologyAxioms';

-- -----------------------------------------------------
-- Table `OML`.`TBox`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`TBox` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table TerminologyBoxes';

-- -----------------------------------------------------
-- Table `OML`.`TBoxAx`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`TBoxAx` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table TerminologyBoxAxioms';

-- -----------------------------------------------------
-- Table `OML`.`TBoxSt`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`TBoxSt` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table TerminologyBoxStatements';

-- -----------------------------------------------------
-- Table `OML`.`TlgyBdlAx`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`TlgyBdlAx` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table TerminologyBundleAxioms';

-- -----------------------------------------------------
-- Table `OML`.`TlgyBdlSt`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`TlgyBdlSt` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table TerminologyBundleStatements';

-- -----------------------------------------------------
-- Table `OML`.`TlgyIAsts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`TlgyIAsts` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table TerminologyInstanceAssertions';

-- -----------------------------------------------------
-- Table `OML`.`UrySegP`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`UrySegP` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table UnarySegmentPredicates';

-- -----------------------------------------------------
-- Table `OML`.`UryTermKinds`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`UryTermKinds` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table UnaryTermKinds';

-- -----------------------------------------------------
-- Table `OML`.`ValCRefTs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ValCRefTs` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,		  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Abstract Classification Table ValueCrossReferenceTuples';


-- -----------------------------------------------------
-- Table `OML`.`AnnotProps`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`AnnotProps` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `moduleUUID` CHAR(36) NOT NULL COMMENT 'Mods (Module)',
  `iri` TEXT NOT NULL COMMENT 'IRI',
  `abbrevIRI` TEXT NOT NULL COMMENT 'AbbrevIRI',
  
  CONSTRAINT `fk_AnnotProps_moduleUUID`
    FOREIGN KEY (`moduleUUID`)
    REFERENCES `OML`.`Mods`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table AnnotationProperties';

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

-- -----------------------------------------------------
-- Table `OML`.`CDesTlgyAx`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`CDesTlgyAx` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `tboxUUID` CHAR(36) NOT NULL COMMENT 'TBox (TerminologyBox)',
  `designatedConceptUUID` CHAR(36) NOT NULL COMMENT 'Cs (Concept)',
  `designatedTerminologyIRI` CHAR(36) NOT NULL COMMENT 'TBox (TerminologyBox)',
  
  CONSTRAINT `fk_CDesTlgyAx_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TBox`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_CDesTlgyAx_designatedConceptUUID`
    FOREIGN KEY (`designatedConceptUUID`)
    REFERENCES `OML`.`Cs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_CDesTlgyAx_designatedTerminologyIRI`
    FOREIGN KEY (`designatedTerminologyIRI`)
    REFERENCES `OML`.`TBox`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table ConceptDesignationTerminologyAxioms';

-- -----------------------------------------------------
-- Table `OML`.`TlgyExtensionAx`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`TlgyExtensionAx` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `tboxUUID` CHAR(36) NOT NULL COMMENT 'TBox (TerminologyBox)',
  `extendedTerminologyIRI` CHAR(36) NOT NULL COMMENT 'TBox (TerminologyBox)',
  
  CONSTRAINT `fk_TlgyExtensionAx_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TBox`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_TlgyExtensionAx_extendedTerminologyIRI`
    FOREIGN KEY (`extendedTerminologyIRI`)
    REFERENCES `OML`.`TBox`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table TerminologyExtensionAxioms';

-- -----------------------------------------------------
-- Table `OML`.`TlgyNestingAx`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`TlgyNestingAx` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `tboxUUID` CHAR(36) NOT NULL COMMENT 'TBox (TerminologyBox)',
  `nestingContextUUID` CHAR(36) NOT NULL COMMENT 'Cs (Concept)',
  `nestingTerminologyIRI` CHAR(36) NOT NULL COMMENT 'TBox (TerminologyBox)',
  
  CONSTRAINT `fk_TlgyNestingAx_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TBox`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_TlgyNestingAx_nestingContextUUID`
    FOREIGN KEY (`nestingContextUUID`)
    REFERENCES `OML`.`Cs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_TlgyNestingAx_nestingTerminologyIRI`
    FOREIGN KEY (`nestingTerminologyIRI`)
    REFERENCES `OML`.`TBox`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table TerminologyNestingAxioms';

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

-- -----------------------------------------------------
-- Table `OML`.`Cs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`Cs` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `tboxUUID` CHAR(36) NOT NULL COMMENT 'TBox (TerminologyBox)',
  `name` TEXT NOT NULL COMMENT 'LocalName',
  
  CONSTRAINT `fk_Cs_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TBox`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table Concepts';

-- -----------------------------------------------------
-- Table `OML`.`RRs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`RRs` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `tboxUUID` CHAR(36) NOT NULL COMMENT 'TBox (TerminologyBox)',
  `sourceUUID` CHAR(36) NOT NULL COMMENT 'Es (Entity)',
  `targetUUID` CHAR(36) NOT NULL COMMENT 'Es (Entity)',
  `isAsymmetric` BOOLEAN NOT NULL,
  `isEssential` BOOLEAN NOT NULL,
  `isFunctional` BOOLEAN NOT NULL,
  `isInverseEssential` BOOLEAN NOT NULL,
  `isInverseFunctional` BOOLEAN NOT NULL,
  `isIrreflexive` BOOLEAN NOT NULL,
  `isReflexive` BOOLEAN NOT NULL,
  `isSymmetric` BOOLEAN NOT NULL,
  `isTransitive` BOOLEAN NOT NULL,
  `name` TEXT NOT NULL COMMENT 'LocalName',
  `unreifiedPropertyName` TEXT NOT NULL COMMENT 'LocalName',
  `unreifiedInversePropertyName` TEXT COMMENT 'LocalName',
  
  CONSTRAINT `fk_RRs_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TBox`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RRs_sourceUUID`
    FOREIGN KEY (`sourceUUID`)
    REFERENCES `OML`.`Es`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RRs_targetUUID`
    FOREIGN KEY (`targetUUID`)
    REFERENCES `OML`.`Es`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table ReifiedRelationships';

-- -----------------------------------------------------
-- Table `OML`.`URs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`URs` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `tboxUUID` CHAR(36) NOT NULL COMMENT 'TBox (TerminologyBox)',
  `sourceUUID` CHAR(36) NOT NULL COMMENT 'Es (Entity)',
  `targetUUID` CHAR(36) NOT NULL COMMENT 'Es (Entity)',
  `isAsymmetric` BOOLEAN NOT NULL,
  `isEssential` BOOLEAN NOT NULL,
  `isFunctional` BOOLEAN NOT NULL,
  `isInverseEssential` BOOLEAN NOT NULL,
  `isInverseFunctional` BOOLEAN NOT NULL,
  `isIrreflexive` BOOLEAN NOT NULL,
  `isReflexive` BOOLEAN NOT NULL,
  `isSymmetric` BOOLEAN NOT NULL,
  `isTransitive` BOOLEAN NOT NULL,
  `name` TEXT NOT NULL COMMENT 'LocalName',
  
  CONSTRAINT `fk_URs_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TBox`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_URs_sourceUUID`
    FOREIGN KEY (`sourceUUID`)
    REFERENCES `OML`.`Es`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_URs_targetUUID`
    FOREIGN KEY (`targetUUID`)
    REFERENCES `OML`.`Es`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table UnreifiedRelationships';

-- -----------------------------------------------------
-- Table `OML`.`Scs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`Scs` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `tboxUUID` CHAR(36) NOT NULL COMMENT 'TBox (TerminologyBox)',
  `name` TEXT NOT NULL COMMENT 'LocalName',
  
  CONSTRAINT `fk_Scs_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TBox`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table Scalars';

-- -----------------------------------------------------
-- Table `OML`.`Sts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`Sts` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `tboxUUID` CHAR(36) NOT NULL COMMENT 'TBox (TerminologyBox)',
  `name` TEXT NOT NULL COMMENT 'LocalName',
  
  CONSTRAINT `fk_Sts_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TBox`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table Structures';

-- -----------------------------------------------------
-- Table `OML`.`BinScRs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`BinScRs` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `tboxUUID` CHAR(36) NOT NULL COMMENT 'TBox (TerminologyBox)',
  `restrictedRangeUUID` CHAR(36) NOT NULL COMMENT 'Drs (DataRange)',
  `length` TEXT COMMENT 'PositiveIntegerLiteral',
  `minLength` TEXT COMMENT 'PositiveIntegerLiteral',
  `maxLength` TEXT COMMENT 'PositiveIntegerLiteral',
  `name` TEXT NOT NULL COMMENT 'LocalName',
  
  CONSTRAINT `fk_BinScRs_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TBox`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_BinScRs_restrictedRangeUUID`
    FOREIGN KEY (`restrictedRangeUUID`)
    REFERENCES `OML`.`Drs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table BinaryScalarRestrictions';

-- -----------------------------------------------------
-- Table `OML`.`IRIScRs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`IRIScRs` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `tboxUUID` CHAR(36) NOT NULL COMMENT 'TBox (TerminologyBox)',
  `restrictedRangeUUID` CHAR(36) NOT NULL COMMENT 'Drs (DataRange)',
  `length` TEXT COMMENT 'PositiveIntegerLiteral',
  `minLength` TEXT COMMENT 'PositiveIntegerLiteral',
  `maxLength` TEXT COMMENT 'PositiveIntegerLiteral',
  `name` TEXT NOT NULL COMMENT 'LocalName',
  `pattern` TEXT COMMENT 'LiteralPattern',
  
  CONSTRAINT `fk_IRIScRs_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TBox`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_IRIScRs_restrictedRangeUUID`
    FOREIGN KEY (`restrictedRangeUUID`)
    REFERENCES `OML`.`Drs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table IRIScalarRestrictions';

-- -----------------------------------------------------
-- Table `OML`.`NumericScRs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`NumericScRs` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `tboxUUID` CHAR(36) NOT NULL COMMENT 'TBox (TerminologyBox)',
  `restrictedRangeUUID` CHAR(36) NOT NULL COMMENT 'Drs (DataRange)',
  `minExclusive` TEXT COMMENT '(LiteralNumber value)',
  `minExclusiveLiteralType` VARCHAR(20) COMMENT '(LiteralNumber kind)',
  `minInclusive` TEXT COMMENT '(LiteralNumber value)',
  `minInclusiveLiteralType` VARCHAR(20) COMMENT '(LiteralNumber kind)',
  `maxExclusive` TEXT COMMENT '(LiteralNumber value)',
  `maxExclusiveLiteralType` VARCHAR(20) COMMENT '(LiteralNumber kind)',
  `maxInclusive` TEXT COMMENT '(LiteralNumber value)',
  `maxInclusiveLiteralType` VARCHAR(20) COMMENT '(LiteralNumber kind)',
  `name` TEXT NOT NULL COMMENT 'LocalName',
  
  CONSTRAINT `fk_NumericScRs_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TBox`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_NumericScRs_restrictedRangeUUID`
    FOREIGN KEY (`restrictedRangeUUID`)
    REFERENCES `OML`.`Drs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table NumericScalarRestrictions';

-- -----------------------------------------------------
-- Table `OML`.`PlainLitScRs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`PlainLitScRs` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `tboxUUID` CHAR(36) NOT NULL COMMENT 'TBox (TerminologyBox)',
  `restrictedRangeUUID` CHAR(36) NOT NULL COMMENT 'Drs (DataRange)',
  `length` TEXT COMMENT 'PositiveIntegerLiteral',
  `minLength` TEXT COMMENT 'PositiveIntegerLiteral',
  `maxLength` TEXT COMMENT 'PositiveIntegerLiteral',
  `name` TEXT NOT NULL COMMENT 'LocalName',
  `langRange` TEXT COMMENT 'LanguageTagDataType',
  `pattern` TEXT COMMENT 'LiteralPattern',
  
  CONSTRAINT `fk_PlainLitScRs_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TBox`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_PlainLitScRs_restrictedRangeUUID`
    FOREIGN KEY (`restrictedRangeUUID`)
    REFERENCES `OML`.`Drs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table PlainLiteralScalarRestrictions';

-- -----------------------------------------------------
-- Table `OML`.`ScOneOfRs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ScOneOfRs` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `tboxUUID` CHAR(36) NOT NULL COMMENT 'TBox (TerminologyBox)',
  `restrictedRangeUUID` CHAR(36) NOT NULL COMMENT 'Drs (DataRange)',
  `name` TEXT NOT NULL COMMENT 'LocalName',
  
  CONSTRAINT `fk_ScOneOfRs_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TBox`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ScOneOfRs_restrictedRangeUUID`
    FOREIGN KEY (`restrictedRangeUUID`)
    REFERENCES `OML`.`Drs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table ScalarOneOfRestrictions';

-- -----------------------------------------------------
-- Table `OML`.`StringScRs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`StringScRs` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `tboxUUID` CHAR(36) NOT NULL COMMENT 'TBox (TerminologyBox)',
  `restrictedRangeUUID` CHAR(36) NOT NULL COMMENT 'Drs (DataRange)',
  `length` TEXT COMMENT 'PositiveIntegerLiteral',
  `minLength` TEXT COMMENT 'PositiveIntegerLiteral',
  `maxLength` TEXT COMMENT 'PositiveIntegerLiteral',
  `name` TEXT NOT NULL COMMENT 'LocalName',
  `pattern` TEXT COMMENT 'LiteralPattern',
  
  CONSTRAINT `fk_StringScRs_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TBox`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_StringScRs_restrictedRangeUUID`
    FOREIGN KEY (`restrictedRangeUUID`)
    REFERENCES `OML`.`Drs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table StringScalarRestrictions';

-- -----------------------------------------------------
-- Table `OML`.`SynonymScRs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`SynonymScRs` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `tboxUUID` CHAR(36) NOT NULL COMMENT 'TBox (TerminologyBox)',
  `restrictedRangeUUID` CHAR(36) NOT NULL COMMENT 'Drs (DataRange)',
  `name` TEXT NOT NULL COMMENT 'LocalName',
  
  CONSTRAINT `fk_SynonymScRs_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TBox`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SynonymScRs_restrictedRangeUUID`
    FOREIGN KEY (`restrictedRangeUUID`)
    REFERENCES `OML`.`Drs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table SynonymScalarRestrictions';

-- -----------------------------------------------------
-- Table `OML`.`TimeScRs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`TimeScRs` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `tboxUUID` CHAR(36) NOT NULL COMMENT 'TBox (TerminologyBox)',
  `restrictedRangeUUID` CHAR(36) NOT NULL COMMENT 'Drs (DataRange)',
  `minExclusive` TEXT COMMENT '(LiteralDateTime value)',
  `minExclusiveLiteralType` VARCHAR(20) COMMENT '(LiteralDateTime kind)',
  `minInclusive` TEXT COMMENT '(LiteralDateTime value)',
  `minInclusiveLiteralType` VARCHAR(20) COMMENT '(LiteralDateTime kind)',
  `maxExclusive` TEXT COMMENT '(LiteralDateTime value)',
  `maxExclusiveLiteralType` VARCHAR(20) COMMENT '(LiteralDateTime kind)',
  `maxInclusive` TEXT COMMENT '(LiteralDateTime value)',
  `maxInclusiveLiteralType` VARCHAR(20) COMMENT '(LiteralDateTime kind)',
  `name` TEXT NOT NULL COMMENT 'LocalName',
  
  CONSTRAINT `fk_TimeScRs_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TBox`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_TimeScRs_restrictedRangeUUID`
    FOREIGN KEY (`restrictedRangeUUID`)
    REFERENCES `OML`.`Drs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table TimeScalarRestrictions';

-- -----------------------------------------------------
-- Table `OML`.`EScPs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`EScPs` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `tboxUUID` CHAR(36) NOT NULL COMMENT 'TBox (TerminologyBox)',
  `domainUUID` CHAR(36) NOT NULL COMMENT 'Es (Entity)',
  `rangeUUID` CHAR(36) NOT NULL COMMENT 'Drs (DataRange)',
  `isIdentityCriteria` BOOLEAN NOT NULL,
  `name` TEXT NOT NULL COMMENT 'LocalName',
  
  CONSTRAINT `fk_EScPs_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TBox`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EScPs_domainUUID`
    FOREIGN KEY (`domainUUID`)
    REFERENCES `OML`.`Es`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EScPs_rangeUUID`
    FOREIGN KEY (`rangeUUID`)
    REFERENCES `OML`.`Drs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table EntityScalarDataProperties';

-- -----------------------------------------------------
-- Table `OML`.`EStPs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`EStPs` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `tboxUUID` CHAR(36) NOT NULL COMMENT 'TBox (TerminologyBox)',
  `domainUUID` CHAR(36) NOT NULL COMMENT 'Es (Entity)',
  `rangeUUID` CHAR(36) NOT NULL COMMENT 'Sts (Structure)',
  `isIdentityCriteria` BOOLEAN NOT NULL,
  `name` TEXT NOT NULL COMMENT 'LocalName',
  
  CONSTRAINT `fk_EStPs_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TBox`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EStPs_domainUUID`
    FOREIGN KEY (`domainUUID`)
    REFERENCES `OML`.`Es`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EStPs_rangeUUID`
    FOREIGN KEY (`rangeUUID`)
    REFERENCES `OML`.`Sts`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table EntityStructuredDataProperties';

-- -----------------------------------------------------
-- Table `OML`.`ScPs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ScPs` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `tboxUUID` CHAR(36) NOT NULL COMMENT 'TBox (TerminologyBox)',
  `domainUUID` CHAR(36) NOT NULL COMMENT 'Sts (Structure)',
  `rangeUUID` CHAR(36) NOT NULL COMMENT 'Drs (DataRange)',
  `name` TEXT NOT NULL COMMENT 'LocalName',
  
  CONSTRAINT `fk_ScPs_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TBox`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ScPs_domainUUID`
    FOREIGN KEY (`domainUUID`)
    REFERENCES `OML`.`Sts`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ScPs_rangeUUID`
    FOREIGN KEY (`rangeUUID`)
    REFERENCES `OML`.`Drs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table ScalarDataProperties';

-- -----------------------------------------------------
-- Table `OML`.`StPs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`StPs` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `tboxUUID` CHAR(36) NOT NULL COMMENT 'TBox (TerminologyBox)',
  `domainUUID` CHAR(36) NOT NULL COMMENT 'Sts (Structure)',
  `rangeUUID` CHAR(36) NOT NULL COMMENT 'Sts (Structure)',
  `name` TEXT NOT NULL COMMENT 'LocalName',
  
  CONSTRAINT `fk_StPs_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TBox`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_StPs_domainUUID`
    FOREIGN KEY (`domainUUID`)
    REFERENCES `OML`.`Sts`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_StPs_rangeUUID`
    FOREIGN KEY (`rangeUUID`)
    REFERENCES `OML`.`Sts`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table StructuredDataProperties';

-- -----------------------------------------------------
-- Table `OML`.`AspectSpeAx`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`AspectSpeAx` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `tboxUUID` CHAR(36) NOT NULL COMMENT 'TBox (TerminologyBox)',
  `superAspectUUID` CHAR(36) NOT NULL COMMENT 'Aspects (Aspect)',
  `subEntityUUID` CHAR(36) NOT NULL COMMENT 'Es (Entity)',
  
  CONSTRAINT `fk_AspectSpeAx_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TBox`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_AspectSpeAx_superAspectUUID`
    FOREIGN KEY (`superAspectUUID`)
    REFERENCES `OML`.`Aspects`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_AspectSpeAx_subEntityUUID`
    FOREIGN KEY (`subEntityUUID`)
    REFERENCES `OML`.`Es`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table AspectSpecializationAxioms';

-- -----------------------------------------------------
-- Table `OML`.`CSpeAx`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`CSpeAx` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `tboxUUID` CHAR(36) NOT NULL COMMENT 'TBox (TerminologyBox)',
  `superConceptUUID` CHAR(36) NOT NULL COMMENT 'Cs (Concept)',
  `subConceptUUID` CHAR(36) NOT NULL COMMENT 'Cs (Concept)',
  
  CONSTRAINT `fk_CSpeAx_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TBox`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_CSpeAx_superConceptUUID`
    FOREIGN KEY (`superConceptUUID`)
    REFERENCES `OML`.`Cs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_CSpeAx_subConceptUUID`
    FOREIGN KEY (`subConceptUUID`)
    REFERENCES `OML`.`Cs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table ConceptSpecializationAxioms';

-- -----------------------------------------------------
-- Table `OML`.`RRSpeAx`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`RRSpeAx` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `tboxUUID` CHAR(36) NOT NULL COMMENT 'TBox (TerminologyBox)',
  `superRelationshipUUID` CHAR(36) NOT NULL COMMENT 'RRs (ReifiedRelationship)',
  `subRelationshipUUID` CHAR(36) NOT NULL COMMENT 'RRs (ReifiedRelationship)',
  
  CONSTRAINT `fk_RRSpeAx_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TBox`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RRSpeAx_superRelationshipUUID`
    FOREIGN KEY (`superRelationshipUUID`)
    REFERENCES `OML`.`RRs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RRSpeAx_subRelationshipUUID`
    FOREIGN KEY (`subRelationshipUUID`)
    REFERENCES `OML`.`RRs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table ReifiedRelationshipSpecializationAxioms';

-- -----------------------------------------------------
-- Table `OML`.`EExRAx`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`EExRAx` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `tboxUUID` CHAR(36) NOT NULL COMMENT 'TBox (TerminologyBox)',
  `restrictedRelationUUID` CHAR(36) NOT NULL COMMENT 'ERels (EntityRelationship)',
  `restrictedDomainUUID` CHAR(36) NOT NULL COMMENT 'Es (Entity)',
  `restrictedRangeUUID` CHAR(36) NOT NULL COMMENT 'Es (Entity)',
  
  CONSTRAINT `fk_EExRAx_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TBox`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EExRAx_restrictedRelationUUID`
    FOREIGN KEY (`restrictedRelationUUID`)
    REFERENCES `OML`.`ERels`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EExRAx_restrictedDomainUUID`
    FOREIGN KEY (`restrictedDomainUUID`)
    REFERENCES `OML`.`Es`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EExRAx_restrictedRangeUUID`
    FOREIGN KEY (`restrictedRangeUUID`)
    REFERENCES `OML`.`Es`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table EntityExistentialRestrictionAxioms';

-- -----------------------------------------------------
-- Table `OML`.`EUxRAx`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`EUxRAx` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `tboxUUID` CHAR(36) NOT NULL COMMENT 'TBox (TerminologyBox)',
  `restrictedRelationUUID` CHAR(36) NOT NULL COMMENT 'ERels (EntityRelationship)',
  `restrictedDomainUUID` CHAR(36) NOT NULL COMMENT 'Es (Entity)',
  `restrictedRangeUUID` CHAR(36) NOT NULL COMMENT 'Es (Entity)',
  
  CONSTRAINT `fk_EUxRAx_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TBox`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EUxRAx_restrictedRelationUUID`
    FOREIGN KEY (`restrictedRelationUUID`)
    REFERENCES `OML`.`ERels`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EUxRAx_restrictedDomainUUID`
    FOREIGN KEY (`restrictedDomainUUID`)
    REFERENCES `OML`.`Es`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EUxRAx_restrictedRangeUUID`
    FOREIGN KEY (`restrictedRangeUUID`)
    REFERENCES `OML`.`Es`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table EntityUniversalRestrictionAxioms';

-- -----------------------------------------------------
-- Table `OML`.`EScPExRAx`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`EScPExRAx` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `tboxUUID` CHAR(36) NOT NULL COMMENT 'TBox (TerminologyBox)',
  `restrictedEntityUUID` CHAR(36) NOT NULL COMMENT 'Es (Entity)',
  `scalarPropertyUUID` CHAR(36) NOT NULL COMMENT 'EScPs (EntityScalarDataProperty)',
  `scalarRestrictionUUID` CHAR(36) NOT NULL COMMENT 'Drs (DataRange)',
  
  CONSTRAINT `fk_EScPExRAx_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TBox`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EScPExRAx_restrictedEntityUUID`
    FOREIGN KEY (`restrictedEntityUUID`)
    REFERENCES `OML`.`Es`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EScPExRAx_scalarPropertyUUID`
    FOREIGN KEY (`scalarPropertyUUID`)
    REFERENCES `OML`.`EScPs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EScPExRAx_scalarRestrictionUUID`
    FOREIGN KEY (`scalarRestrictionUUID`)
    REFERENCES `OML`.`Drs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table EntityScalarDataPropertyExistentialRestrictionAxioms';

-- -----------------------------------------------------
-- Table `OML`.`EScPPtrRAx`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`EScPPtrRAx` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `tboxUUID` CHAR(36) NOT NULL COMMENT 'TBox (TerminologyBox)',
  `restrictedEntityUUID` CHAR(36) NOT NULL COMMENT 'Es (Entity)',
  `scalarPropertyUUID` CHAR(36) NOT NULL COMMENT 'EScPs (EntityScalarDataProperty)',
  `literalValue` TEXT COMMENT '(LiteralValue value)',
  `literalValueLiteralType` VARCHAR(20) COMMENT '(LiteralValue kind)',
  `valueTypeUUID` CHAR(36) NULL COMMENT 'Drs (DataRange)',
  
  CONSTRAINT `fk_EScPPtrRAx_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TBox`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EScPPtrRAx_restrictedEntityUUID`
    FOREIGN KEY (`restrictedEntityUUID`)
    REFERENCES `OML`.`Es`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EScPPtrRAx_scalarPropertyUUID`
    FOREIGN KEY (`scalarPropertyUUID`)
    REFERENCES `OML`.`EScPs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EScPPtrRAx_valueTypeUUID`
    FOREIGN KEY (`valueTypeUUID`)
    REFERENCES `OML`.`Drs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table EntityScalarDataPropertyParticularRestrictionAxioms';

-- -----------------------------------------------------
-- Table `OML`.`EScPUxRAx`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`EScPUxRAx` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `tboxUUID` CHAR(36) NOT NULL COMMENT 'TBox (TerminologyBox)',
  `restrictedEntityUUID` CHAR(36) NOT NULL COMMENT 'Es (Entity)',
  `scalarPropertyUUID` CHAR(36) NOT NULL COMMENT 'EScPs (EntityScalarDataProperty)',
  `scalarRestrictionUUID` CHAR(36) NOT NULL COMMENT 'Drs (DataRange)',
  
  CONSTRAINT `fk_EScPUxRAx_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TBox`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EScPUxRAx_restrictedEntityUUID`
    FOREIGN KEY (`restrictedEntityUUID`)
    REFERENCES `OML`.`Es`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EScPUxRAx_scalarPropertyUUID`
    FOREIGN KEY (`scalarPropertyUUID`)
    REFERENCES `OML`.`EScPs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EScPUxRAx_scalarRestrictionUUID`
    FOREIGN KEY (`scalarRestrictionUUID`)
    REFERENCES `OML`.`Drs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table EntityScalarDataPropertyUniversalRestrictionAxioms';

-- -----------------------------------------------------
-- Table `OML`.`ScOneOfLitAx`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ScOneOfLitAx` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `tboxUUID` CHAR(36) NOT NULL COMMENT 'TBox (TerminologyBox)',
  `axiomUUID` CHAR(36) NOT NULL COMMENT 'ScOneOfRs (ScalarOneOfRestriction)',
  `value` TEXT COMMENT '(LiteralValue value)',
  `valueLiteralType` VARCHAR(20) COMMENT '(LiteralValue kind)',
  `valueTypeUUID` CHAR(36) NULL COMMENT 'Drs (DataRange)',
  
  CONSTRAINT `fk_ScOneOfLitAx_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TBox`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ScOneOfLitAx_axiomUUID`
    FOREIGN KEY (`axiomUUID`)
    REFERENCES `OML`.`ScOneOfRs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ScOneOfLitAx_valueTypeUUID`
    FOREIGN KEY (`valueTypeUUID`)
    REFERENCES `OML`.`Drs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table ScalarOneOfLiteralAxioms';

-- -----------------------------------------------------
-- Table `OML`.`BdldTlgyAx`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`BdldTlgyAx` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `bundleUUID` CHAR(36) NOT NULL COMMENT 'Bdls (Bundle)',
  `bundledTerminologyIRI` CHAR(36) NOT NULL COMMENT 'TBox (TerminologyBox)',
  
  CONSTRAINT `fk_BdldTlgyAx_bundleUUID`
    FOREIGN KEY (`bundleUUID`)
    REFERENCES `OML`.`Bdls`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_BdldTlgyAx_bundledTerminologyIRI`
    FOREIGN KEY (`bundledTerminologyIRI`)
    REFERENCES `OML`.`TBox`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table BundledTerminologyAxioms';

-- -----------------------------------------------------
-- Table `OML`.`RootCTaxonomyAx`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`RootCTaxonomyAx` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `bundleUUID` CHAR(36) NOT NULL COMMENT 'Bdls (Bundle)',
  `rootUUID` CHAR(36) NOT NULL COMMENT 'Cs (Concept)',
  
  CONSTRAINT `fk_RootCTaxonomyAx_bundleUUID`
    FOREIGN KEY (`bundleUUID`)
    REFERENCES `OML`.`Bdls`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RootCTaxonomyAx_rootUUID`
    FOREIGN KEY (`rootUUID`)
    REFERENCES `OML`.`Cs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table RootConceptTaxonomyAxioms';

-- -----------------------------------------------------
-- Table `OML`.`SpeDsjtCAx`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`SpeDsjtCAx` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `disjointTaxonomyParentUUID` CHAR(36) NOT NULL COMMENT 'CTreeDsju (ConceptTreeDisjunction)',
  `disjointLeafUUID` CHAR(36) NOT NULL COMMENT 'Cs (Concept)',
  
  CONSTRAINT `fk_SpeDsjtCAx_disjointTaxonomyParentUUID`
    FOREIGN KEY (`disjointTaxonomyParentUUID`)
    REFERENCES `OML`.`CTreeDsju`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SpeDsjtCAx_disjointLeafUUID`
    FOREIGN KEY (`disjointLeafUUID`)
    REFERENCES `OML`.`Cs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table SpecificDisjointConceptAxioms';

-- -----------------------------------------------------
-- Table `OML`.`AnnotPropVals`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`AnnotPropVals` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `subjectUUID` CHAR(36) NOT NULL COMMENT 'LogEs (LogicalElement)',
  `propertyUUID` CHAR(36) NOT NULL COMMENT 'AnnotProps (AnnotationProperty)',
  `value` TEXT COMMENT '(LiteralString value)',
  `valueLiteralType` VARCHAR(20) COMMENT '(LiteralString kind)',
  
  CONSTRAINT `fk_AnnotPropVals_subjectUUID`
    FOREIGN KEY (`subjectUUID`)
    REFERENCES `OML`.`LogEs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_AnnotPropVals_propertyUUID`
    FOREIGN KEY (`propertyUUID`)
    REFERENCES `OML`.`AnnotProps`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table AnnotationPropertyValues';

-- -----------------------------------------------------
-- Table `OML`.`AnonymousCUnionAx`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`AnonymousCUnionAx` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `disjointTaxonomyParentUUID` CHAR(36) NOT NULL COMMENT 'CTreeDsju (ConceptTreeDisjunction)',
  `name` TEXT NOT NULL COMMENT 'LocalName',
  
  CONSTRAINT `fk_AnonymousCUnionAx_disjointTaxonomyParentUUID`
    FOREIGN KEY (`disjointTaxonomyParentUUID`)
    REFERENCES `OML`.`CTreeDsju`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table AnonymousConceptUnionAxioms';

-- -----------------------------------------------------
-- Table `OML`.`AspectP`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`AspectP` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `aspectUUID` CHAR(36) NOT NULL COMMENT 'Aspects (Aspect)',
  `bodySegmentUUID` CHAR(36) NOT NULL COMMENT 'RuleBodySegs (RuleBodySegment)',
  
  CONSTRAINT `fk_AspectP_aspectUUID`
    FOREIGN KEY (`aspectUUID`)
    REFERENCES `OML`.`Aspects`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_AspectP_bodySegmentUUID`
    FOREIGN KEY (`bodySegmentUUID`)
    REFERENCES `OML`.`RuleBodySegs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table AspectPredicates';

-- -----------------------------------------------------
-- Table `OML`.`ChainRules`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ChainRules` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `tboxUUID` CHAR(36) NOT NULL COMMENT 'TBox (TerminologyBox)',
  `name` TEXT NOT NULL COMMENT 'LocalName',
  `headUUID` CHAR(36) NOT NULL COMMENT 'URs (UnreifiedRelationship)',
  
  CONSTRAINT `fk_ChainRules_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TBox`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ChainRules_headUUID`
    FOREIGN KEY (`headUUID`)
    REFERENCES `OML`.`URs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table ChainRules';

-- -----------------------------------------------------
-- Table `OML`.`CIs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`CIs` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `descriptionBoxUUID` CHAR(36) NOT NULL COMMENT 'DBoxes (DescriptionBox)',
  `singletonConceptClassifierUUID` CHAR(36) NOT NULL COMMENT 'Cs (Concept)',
  `name` TEXT NOT NULL COMMENT 'LocalName',
  
  CONSTRAINT `fk_CIs_descriptionBoxUUID`
    FOREIGN KEY (`descriptionBoxUUID`)
    REFERENCES `OML`.`DBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_CIs_singletonConceptClassifierUUID`
    FOREIGN KEY (`singletonConceptClassifierUUID`)
    REFERENCES `OML`.`Cs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table ConceptInstances';

-- -----------------------------------------------------
-- Table `OML`.`CP`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`CP` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `bodySegmentUUID` CHAR(36) NOT NULL COMMENT 'RuleBodySegs (RuleBodySegment)',
  `conceptUUID` CHAR(36) NOT NULL COMMENT 'Cs (Concept)',
  
  CONSTRAINT `fk_CP_bodySegmentUUID`
    FOREIGN KEY (`bodySegmentUUID`)
    REFERENCES `OML`.`RuleBodySegs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_CP_conceptUUID`
    FOREIGN KEY (`conceptUUID`)
    REFERENCES `OML`.`Cs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table ConceptPredicates';

-- -----------------------------------------------------
-- Table `OML`.`DBoxes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`DBoxes` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `kind` TEXT NOT NULL COMMENT 'DescriptionKind',
  `iri` TEXT NOT NULL COMMENT 'IRI',
  
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table DescriptionBoxes';

-- -----------------------------------------------------
-- Table `OML`.`DBoxExtCWDef`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`DBoxExtCWDef` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `descriptionBoxUUID` CHAR(36) NOT NULL COMMENT 'DBoxes (DescriptionBox)',
  `closedWorldDefinitionsIRI` CHAR(36) NOT NULL COMMENT 'TBox (TerminologyBox)',
  
  CONSTRAINT `fk_DBoxExtCWDef_descriptionBoxUUID`
    FOREIGN KEY (`descriptionBoxUUID`)
    REFERENCES `OML`.`DBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_DBoxExtCWDef_closedWorldDefinitionsIRI`
    FOREIGN KEY (`closedWorldDefinitionsIRI`)
    REFERENCES `OML`.`TBox`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table DescriptionBoxExtendsClosedWorldDefinitions';

-- -----------------------------------------------------
-- Table `OML`.`DBoxRfns`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`DBoxRfns` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `refiningDescriptionBoxUUID` CHAR(36) NOT NULL COMMENT 'DBoxes (DescriptionBox)',
  `refinedDescriptionBoxIRI` CHAR(36) NOT NULL COMMENT 'DBoxes (DescriptionBox)',
  
  CONSTRAINT `fk_DBoxRfns_refiningDescriptionBoxUUID`
    FOREIGN KEY (`refiningDescriptionBoxUUID`)
    REFERENCES `OML`.`DBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_DBoxRfns_refinedDescriptionBoxIRI`
    FOREIGN KEY (`refinedDescriptionBoxIRI`)
    REFERENCES `OML`.`DBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table DescriptionBoxRefinements';

-- -----------------------------------------------------
-- Table `OML`.`EStPPtrRAx`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`EStPPtrRAx` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `tboxUUID` CHAR(36) NOT NULL COMMENT 'TBox (TerminologyBox)',
  `structuredDataPropertyUUID` CHAR(36) NOT NULL COMMENT 'DRelToSts (DataRelationshipToStructure)',
  `restrictedEntityUUID` CHAR(36) NOT NULL COMMENT 'Es (Entity)',
  
  CONSTRAINT `fk_EStPPtrRAx_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TBox`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EStPPtrRAx_structuredDataPropertyUUID`
    FOREIGN KEY (`structuredDataPropertyUUID`)
    REFERENCES `OML`.`DRelToSts`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_EStPPtrRAx_restrictedEntityUUID`
    FOREIGN KEY (`restrictedEntityUUID`)
    REFERENCES `OML`.`Es`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table EntityStructuredDataPropertyParticularRestrictionAxioms';

-- -----------------------------------------------------
-- Table `OML`.`RRIs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`RRIs` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `descriptionBoxUUID` CHAR(36) NOT NULL COMMENT 'DBoxes (DescriptionBox)',
  `singletonReifiedRelationshipClassifierUUID` CHAR(36) NOT NULL COMMENT 'RRs (ReifiedRelationship)',
  `name` TEXT NOT NULL COMMENT 'LocalName',
  
  CONSTRAINT `fk_RRIs_descriptionBoxUUID`
    FOREIGN KEY (`descriptionBoxUUID`)
    REFERENCES `OML`.`DBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RRIs_singletonReifiedRelationshipClassifierUUID`
    FOREIGN KEY (`singletonReifiedRelationshipClassifierUUID`)
    REFERENCES `OML`.`RRs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table ReifiedRelationshipInstances';

-- -----------------------------------------------------
-- Table `OML`.`RRIDomains`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`RRIDomains` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `descriptionBoxUUID` CHAR(36) NOT NULL COMMENT 'DBoxes (DescriptionBox)',
  `reifiedRelationshipInstanceUUID` CHAR(36) NOT NULL COMMENT 'RRIs (ReifiedRelationshipInstance)',
  `domainUUID` CHAR(36) NOT NULL COMMENT 'CualESI (ConceptualEntitySingletonInstance)',
  
  CONSTRAINT `fk_RRIDomains_descriptionBoxUUID`
    FOREIGN KEY (`descriptionBoxUUID`)
    REFERENCES `OML`.`DBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RRIDomains_reifiedRelationshipInstanceUUID`
    FOREIGN KEY (`reifiedRelationshipInstanceUUID`)
    REFERENCES `OML`.`RRIs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RRIDomains_domainUUID`
    FOREIGN KEY (`domainUUID`)
    REFERENCES `OML`.`CualESI`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table ReifiedRelationshipInstanceDomains';

-- -----------------------------------------------------
-- Table `OML`.`RRIRanges`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`RRIRanges` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `descriptionBoxUUID` CHAR(36) NOT NULL COMMENT 'DBoxes (DescriptionBox)',
  `reifiedRelationshipInstanceUUID` CHAR(36) NOT NULL COMMENT 'RRIs (ReifiedRelationshipInstance)',
  `rangeUUID` CHAR(36) NOT NULL COMMENT 'CualESI (ConceptualEntitySingletonInstance)',
  
  CONSTRAINT `fk_RRIRanges_descriptionBoxUUID`
    FOREIGN KEY (`descriptionBoxUUID`)
    REFERENCES `OML`.`DBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RRIRanges_reifiedRelationshipInstanceUUID`
    FOREIGN KEY (`reifiedRelationshipInstanceUUID`)
    REFERENCES `OML`.`RRIs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RRIRanges_rangeUUID`
    FOREIGN KEY (`rangeUUID`)
    REFERENCES `OML`.`CualESI`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table ReifiedRelationshipInstanceRanges';

-- -----------------------------------------------------
-- Table `OML`.`RRInvPropP`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`RRInvPropP` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `bodySegmentUUID` CHAR(36) NOT NULL COMMENT 'RuleBodySegs (RuleBodySegment)',
  `reifiedRelationshipUUID` CHAR(36) NOT NULL COMMENT 'RRs (ReifiedRelationship)',
  
  CONSTRAINT `fk_RRInvPropP_bodySegmentUUID`
    FOREIGN KEY (`bodySegmentUUID`)
    REFERENCES `OML`.`RuleBodySegs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RRInvPropP_reifiedRelationshipUUID`
    FOREIGN KEY (`reifiedRelationshipUUID`)
    REFERENCES `OML`.`RRs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table ReifiedRelationshipInversePropertyPredicates';

-- -----------------------------------------------------
-- Table `OML`.`RRP`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`RRP` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `bodySegmentUUID` CHAR(36) NOT NULL COMMENT 'RuleBodySegs (RuleBodySegment)',
  `reifiedRelationshipUUID` CHAR(36) NOT NULL COMMENT 'RRs (ReifiedRelationship)',
  
  CONSTRAINT `fk_RRP_bodySegmentUUID`
    FOREIGN KEY (`bodySegmentUUID`)
    REFERENCES `OML`.`RuleBodySegs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RRP_reifiedRelationshipUUID`
    FOREIGN KEY (`reifiedRelationshipUUID`)
    REFERENCES `OML`.`RRs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table ReifiedRelationshipPredicates';

-- -----------------------------------------------------
-- Table `OML`.`RRPropP`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`RRPropP` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `bodySegmentUUID` CHAR(36) NOT NULL COMMENT 'RuleBodySegs (RuleBodySegment)',
  `reifiedRelationshipUUID` CHAR(36) NOT NULL COMMENT 'RRs (ReifiedRelationship)',
  
  CONSTRAINT `fk_RRPropP_bodySegmentUUID`
    FOREIGN KEY (`bodySegmentUUID`)
    REFERENCES `OML`.`RuleBodySegs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RRPropP_reifiedRelationshipUUID`
    FOREIGN KEY (`reifiedRelationshipUUID`)
    REFERENCES `OML`.`RRs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table ReifiedRelationshipPropertyPredicates';

-- -----------------------------------------------------
-- Table `OML`.`RRSrcInvPropP`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`RRSrcInvPropP` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `bodySegmentUUID` CHAR(36) NOT NULL COMMENT 'RuleBodySegs (RuleBodySegment)',
  `reifiedRelationshipUUID` CHAR(36) NOT NULL COMMENT 'RRs (ReifiedRelationship)',
  
  CONSTRAINT `fk_RRSrcInvPropP_bodySegmentUUID`
    FOREIGN KEY (`bodySegmentUUID`)
    REFERENCES `OML`.`RuleBodySegs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RRSrcInvPropP_reifiedRelationshipUUID`
    FOREIGN KEY (`reifiedRelationshipUUID`)
    REFERENCES `OML`.`RRs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table ReifiedRelationshipSourceInversePropertyPredicates';

-- -----------------------------------------------------
-- Table `OML`.`RRSrcPropP`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`RRSrcPropP` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `bodySegmentUUID` CHAR(36) NOT NULL COMMENT 'RuleBodySegs (RuleBodySegment)',
  `reifiedRelationshipUUID` CHAR(36) NOT NULL COMMENT 'RRs (ReifiedRelationship)',
  
  CONSTRAINT `fk_RRSrcPropP_bodySegmentUUID`
    FOREIGN KEY (`bodySegmentUUID`)
    REFERENCES `OML`.`RuleBodySegs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RRSrcPropP_reifiedRelationshipUUID`
    FOREIGN KEY (`reifiedRelationshipUUID`)
    REFERENCES `OML`.`RRs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table ReifiedRelationshipSourcePropertyPredicates';

-- -----------------------------------------------------
-- Table `OML`.`RRTgtInvPropP`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`RRTgtInvPropP` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `bodySegmentUUID` CHAR(36) NOT NULL COMMENT 'RuleBodySegs (RuleBodySegment)',
  `reifiedRelationshipUUID` CHAR(36) NOT NULL COMMENT 'RRs (ReifiedRelationship)',
  
  CONSTRAINT `fk_RRTgtInvPropP_bodySegmentUUID`
    FOREIGN KEY (`bodySegmentUUID`)
    REFERENCES `OML`.`RuleBodySegs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RRTgtInvPropP_reifiedRelationshipUUID`
    FOREIGN KEY (`reifiedRelationshipUUID`)
    REFERENCES `OML`.`RRs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table ReifiedRelationshipTargetInversePropertyPredicates';

-- -----------------------------------------------------
-- Table `OML`.`RRTgtPropP`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`RRTgtPropP` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `bodySegmentUUID` CHAR(36) NOT NULL COMMENT 'RuleBodySegs (RuleBodySegment)',
  `reifiedRelationshipUUID` CHAR(36) NOT NULL COMMENT 'RRs (ReifiedRelationship)',
  
  CONSTRAINT `fk_RRTgtPropP_bodySegmentUUID`
    FOREIGN KEY (`bodySegmentUUID`)
    REFERENCES `OML`.`RuleBodySegs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RRTgtPropP_reifiedRelationshipUUID`
    FOREIGN KEY (`reifiedRelationshipUUID`)
    REFERENCES `OML`.`RRs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table ReifiedRelationshipTargetPropertyPredicates';

-- -----------------------------------------------------
-- Table `OML`.`RScPVals`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`RScPVals` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `scalarDataPropertyUUID` CHAR(36) NOT NULL COMMENT 'DRelToScs (DataRelationshipToScalar)',
  `scalarPropertyValue` TEXT COMMENT '(LiteralValue value)',
  `scalarPropertyValueLiteralType` VARCHAR(20) COMMENT '(LiteralValue kind)',
  `structuredDataPropertyContextUUID` CHAR(36) NOT NULL COMMENT 'RStPCtxts (RestrictionStructuredDataPropertyContext)',
  `valueTypeUUID` CHAR(36) NULL COMMENT 'Drs (DataRange)',
  
  CONSTRAINT `fk_RScPVals_scalarDataPropertyUUID`
    FOREIGN KEY (`scalarDataPropertyUUID`)
    REFERENCES `OML`.`DRelToScs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RScPVals_structuredDataPropertyContextUUID`
    FOREIGN KEY (`structuredDataPropertyContextUUID`)
    REFERENCES `OML`.`RStPCtxts`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RScPVals_valueTypeUUID`
    FOREIGN KEY (`valueTypeUUID`)
    REFERENCES `OML`.`Drs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table RestrictionScalarDataPropertyValues';

-- -----------------------------------------------------
-- Table `OML`.`RStPTs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`RStPTs` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `structuredDataPropertyUUID` CHAR(36) NOT NULL COMMENT 'DRelToSts (DataRelationshipToStructure)',
  `structuredDataPropertyContextUUID` CHAR(36) NOT NULL COMMENT 'RStPCtxts (RestrictionStructuredDataPropertyContext)',
  
  CONSTRAINT `fk_RStPTs_structuredDataPropertyUUID`
    FOREIGN KEY (`structuredDataPropertyUUID`)
    REFERENCES `OML`.`DRelToSts`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RStPTs_structuredDataPropertyContextUUID`
    FOREIGN KEY (`structuredDataPropertyContextUUID`)
    REFERENCES `OML`.`RStPCtxts`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table RestrictionStructuredDataPropertyTuples';

-- -----------------------------------------------------
-- Table `OML`.`RuleBodySegs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`RuleBodySegs` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `previousSegmentUUID` CHAR(36) NULL COMMENT 'RuleBodySegs (RuleBodySegment)',
  `ruleUUID` CHAR(36) NULL COMMENT 'ChainRules (ChainRule)',
  
  CONSTRAINT `fk_RuleBodySegs_previousSegmentUUID`
    FOREIGN KEY (`previousSegmentUUID`)
    REFERENCES `OML`.`RuleBodySegs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_RuleBodySegs_ruleUUID`
    FOREIGN KEY (`ruleUUID`)
    REFERENCES `OML`.`ChainRules`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table RuleBodySegments';

-- -----------------------------------------------------
-- Table `OML`.`ScPVals`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`ScPVals` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `scalarDataPropertyUUID` CHAR(36) NOT NULL COMMENT 'DRelToScs (DataRelationshipToScalar)',
  `scalarPropertyValue` TEXT COMMENT '(LiteralValue value)',
  `scalarPropertyValueLiteralType` VARCHAR(20) COMMENT '(LiteralValue kind)',
  `structuredDataPropertyContextUUID` CHAR(36) NOT NULL COMMENT 'S1IStPCtxts (SingletonInstanceStructuredDataPropertyContext)',
  `valueTypeUUID` CHAR(36) NULL COMMENT 'Drs (DataRange)',
  
  CONSTRAINT `fk_ScPVals_scalarDataPropertyUUID`
    FOREIGN KEY (`scalarDataPropertyUUID`)
    REFERENCES `OML`.`DRelToScs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ScPVals_structuredDataPropertyContextUUID`
    FOREIGN KEY (`structuredDataPropertyContextUUID`)
    REFERENCES `OML`.`S1IStPCtxts`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_ScPVals_valueTypeUUID`
    FOREIGN KEY (`valueTypeUUID`)
    REFERENCES `OML`.`Drs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table ScalarDataPropertyValues';

-- -----------------------------------------------------
-- Table `OML`.`S1IScPVals`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`S1IScPVals` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `descriptionBoxUUID` CHAR(36) NOT NULL COMMENT 'DBoxes (DescriptionBox)',
  `singletonInstanceUUID` CHAR(36) NOT NULL COMMENT 'CualESI (ConceptualEntitySingletonInstance)',
  `scalarDataPropertyUUID` CHAR(36) NOT NULL COMMENT 'EScPs (EntityScalarDataProperty)',
  `scalarPropertyValue` TEXT COMMENT '(LiteralValue value)',
  `scalarPropertyValueLiteralType` VARCHAR(20) COMMENT '(LiteralValue kind)',
  `valueTypeUUID` CHAR(36) NULL COMMENT 'Drs (DataRange)',
  
  CONSTRAINT `fk_S1IScPVals_descriptionBoxUUID`
    FOREIGN KEY (`descriptionBoxUUID`)
    REFERENCES `OML`.`DBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_S1IScPVals_singletonInstanceUUID`
    FOREIGN KEY (`singletonInstanceUUID`)
    REFERENCES `OML`.`CualESI`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_S1IScPVals_scalarDataPropertyUUID`
    FOREIGN KEY (`scalarDataPropertyUUID`)
    REFERENCES `OML`.`EScPs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_S1IScPVals_valueTypeUUID`
    FOREIGN KEY (`valueTypeUUID`)
    REFERENCES `OML`.`Drs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table SingletonInstanceScalarDataPropertyValues';

-- -----------------------------------------------------
-- Table `OML`.`S1IStPVals`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`S1IStPVals` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `descriptionBoxUUID` CHAR(36) NOT NULL COMMENT 'DBoxes (DescriptionBox)',
  `singletonInstanceUUID` CHAR(36) NOT NULL COMMENT 'CualESI (ConceptualEntitySingletonInstance)',
  `structuredDataPropertyUUID` CHAR(36) NOT NULL COMMENT 'DRelToSts (DataRelationshipToStructure)',
  
  CONSTRAINT `fk_S1IStPVals_descriptionBoxUUID`
    FOREIGN KEY (`descriptionBoxUUID`)
    REFERENCES `OML`.`DBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_S1IStPVals_singletonInstanceUUID`
    FOREIGN KEY (`singletonInstanceUUID`)
    REFERENCES `OML`.`CualESI`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_S1IStPVals_structuredDataPropertyUUID`
    FOREIGN KEY (`structuredDataPropertyUUID`)
    REFERENCES `OML`.`DRelToSts`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table SingletonInstanceStructuredDataPropertyValues';

-- -----------------------------------------------------
-- Table `OML`.`StPTs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`StPTs` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `structuredDataPropertyUUID` CHAR(36) NOT NULL COMMENT 'DRelToSts (DataRelationshipToStructure)',
  `structuredDataPropertyContextUUID` CHAR(36) NOT NULL COMMENT 'S1IStPCtxts (SingletonInstanceStructuredDataPropertyContext)',
  
  CONSTRAINT `fk_StPTs_structuredDataPropertyUUID`
    FOREIGN KEY (`structuredDataPropertyUUID`)
    REFERENCES `OML`.`DRelToSts`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_StPTs_structuredDataPropertyContextUUID`
    FOREIGN KEY (`structuredDataPropertyContextUUID`)
    REFERENCES `OML`.`S1IStPCtxts`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table StructuredDataPropertyTuples';

-- -----------------------------------------------------
-- Table `OML`.`SubDataPropOfAx`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`SubDataPropOfAx` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `tboxUUID` CHAR(36) NOT NULL COMMENT 'TBox (TerminologyBox)',
  `subPropertyUUID` CHAR(36) NOT NULL COMMENT 'EScPs (EntityScalarDataProperty)',
  `superPropertyUUID` CHAR(36) NOT NULL COMMENT 'EScPs (EntityScalarDataProperty)',
  
  CONSTRAINT `fk_SubDataPropOfAx_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TBox`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SubDataPropOfAx_subPropertyUUID`
    FOREIGN KEY (`subPropertyUUID`)
    REFERENCES `OML`.`EScPs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SubDataPropOfAx_superPropertyUUID`
    FOREIGN KEY (`superPropertyUUID`)
    REFERENCES `OML`.`EScPs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table SubDataPropertyOfAxioms';

-- -----------------------------------------------------
-- Table `OML`.`SubObjectPropOfAx`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`SubObjectPropOfAx` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `tboxUUID` CHAR(36) NOT NULL COMMENT 'TBox (TerminologyBox)',
  `subPropertyUUID` CHAR(36) NOT NULL COMMENT 'URs (UnreifiedRelationship)',
  `superPropertyUUID` CHAR(36) NOT NULL COMMENT 'URs (UnreifiedRelationship)',
  
  CONSTRAINT `fk_SubObjectPropOfAx_tboxUUID`
    FOREIGN KEY (`tboxUUID`)
    REFERENCES `OML`.`TBox`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SubObjectPropOfAx_subPropertyUUID`
    FOREIGN KEY (`subPropertyUUID`)
    REFERENCES `OML`.`URs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_SubObjectPropOfAx_superPropertyUUID`
    FOREIGN KEY (`superPropertyUUID`)
    REFERENCES `OML`.`URs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table SubObjectPropertyOfAxioms';

-- -----------------------------------------------------
-- Table `OML`.`URITs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`URITs` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `descriptionBoxUUID` CHAR(36) NOT NULL COMMENT 'DBoxes (DescriptionBox)',
  `unreifiedRelationshipUUID` CHAR(36) NOT NULL COMMENT 'URs (UnreifiedRelationship)',
  `domainUUID` CHAR(36) NOT NULL COMMENT 'CualESI (ConceptualEntitySingletonInstance)',
  `rangeUUID` CHAR(36) NOT NULL COMMENT 'CualESI (ConceptualEntitySingletonInstance)',
  
  CONSTRAINT `fk_URITs_descriptionBoxUUID`
    FOREIGN KEY (`descriptionBoxUUID`)
    REFERENCES `OML`.`DBoxes`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_URITs_unreifiedRelationshipUUID`
    FOREIGN KEY (`unreifiedRelationshipUUID`)
    REFERENCES `OML`.`URs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_URITs_domainUUID`
    FOREIGN KEY (`domainUUID`)
    REFERENCES `OML`.`CualESI`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_URITs_rangeUUID`
    FOREIGN KEY (`rangeUUID`)
    REFERENCES `OML`.`CualESI`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table UnreifiedRelationshipInstanceTuples';

-- -----------------------------------------------------
-- Table `OML`.`URInvPropP`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`URInvPropP` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `unreifiedRelationshipUUID` CHAR(36) NOT NULL COMMENT 'URs (UnreifiedRelationship)',
  `bodySegmentUUID` CHAR(36) NOT NULL COMMENT 'RuleBodySegs (RuleBodySegment)',
  
  CONSTRAINT `fk_URInvPropP_unreifiedRelationshipUUID`
    FOREIGN KEY (`unreifiedRelationshipUUID`)
    REFERENCES `OML`.`URs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_URInvPropP_bodySegmentUUID`
    FOREIGN KEY (`bodySegmentUUID`)
    REFERENCES `OML`.`RuleBodySegs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table UnreifiedRelationshipInversePropertyPredicates';

-- -----------------------------------------------------
-- Table `OML`.`URPropP`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OML`.`URPropP` (
  `uuid` CHAR(36) NOT NULL PRIMARY KEY,
  `unreifiedRelationshipUUID` CHAR(36) NOT NULL COMMENT 'URs (UnreifiedRelationship)',
  `bodySegmentUUID` CHAR(36) NOT NULL COMMENT 'RuleBodySegs (RuleBodySegment)',
  
  CONSTRAINT `fk_URPropP_unreifiedRelationshipUUID`
    FOREIGN KEY (`unreifiedRelationshipUUID`)
    REFERENCES `OML`.`URs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_URPropP_bodySegmentUUID`
    FOREIGN KEY (`bodySegmentUUID`)
    REFERENCES `OML`.`RuleBodySegs`(`uuid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC)	
)
COMMENT = 'Concrete Information Table UnreifiedRelationshipPropertyPredicates';


USE `OML`;
DELIMITER $$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`BinSegFwdPropP` (BinarySegmentForwardPropertyPredicates)
-- -----------------------------------------------------

-- `OML`.`BinSegPropP`(x) iff `OML`.`BinSegFwdPropP`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`BinSegFwdPropP_AFTER_INSERT` AFTER INSERT ON `BinSegFwdPropP` FOR EACH ROW
BEGIN
insert into `OML`.`BinSegPropP`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`BinSegFwdPropP_AFTER_DELETE` AFTER DELETE ON `BinSegFwdPropP` FOR EACH ROW
BEGIN
delete from `OML`.`BinSegPropP`;
END$$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`BinSegPropP` (BinarySegmentPropertyPredicates)
-- -----------------------------------------------------

-- `OML`.`SegP`(x) iff `OML`.`BinSegPropP`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`BinSegPropP_AFTER_INSERT` AFTER INSERT ON `BinSegPropP` FOR EACH ROW
BEGIN
insert into `OML`.`SegP`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`BinSegPropP_AFTER_DELETE` AFTER DELETE ON `BinSegPropP` FOR EACH ROW
BEGIN
delete from `OML`.`SegP`;
END$$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`BinSegRevPropP` (BinarySegmentReversePropertyPredicates)
-- -----------------------------------------------------

-- `OML`.`BinSegPropP`(x) iff `OML`.`BinSegRevPropP`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`BinSegRevPropP_AFTER_INSERT` AFTER INSERT ON `BinSegRevPropP` FOR EACH ROW
BEGIN
insert into `OML`.`BinSegPropP`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`BinSegRevPropP_AFTER_DELETE` AFTER DELETE ON `BinSegRevPropP` FOR EACH ROW
BEGIN
delete from `OML`.`BinSegPropP`;
END$$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`CTreeDsju` (ConceptTreeDisjunctions)
-- -----------------------------------------------------

-- `OML`.`EltCRefTs`(x) iff `OML`.`CTreeDsju`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`CTreeDsju_AFTER_INSERT` AFTER INSERT ON `CTreeDsju` FOR EACH ROW
BEGIN
insert into `OML`.`EltCRefTs`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`CTreeDsju_AFTER_DELETE` AFTER DELETE ON `CTreeDsju` FOR EACH ROW
BEGIN
delete from `OML`.`EltCRefTs`;
END$$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`CualEs` (ConceptualEntities)
-- -----------------------------------------------------

-- `OML`.`Es`(x) iff `OML`.`CualEs`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`CualEs_AFTER_INSERT` AFTER INSERT ON `CualEs` FOR EACH ROW
BEGIN
insert into `OML`.`Es`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`CualEs_AFTER_DELETE` AFTER DELETE ON `CualEs` FOR EACH ROW
BEGIN
delete from `OML`.`Es`;
END$$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`CualESI` (ConceptualEntitySingletonInstances)
-- -----------------------------------------------------

-- `OML`.`Ress`(x) iff `OML`.`CualESI`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`CualESI_AFTER_INSERT` AFTER INSERT ON `CualESI` FOR EACH ROW
BEGIN
insert into `OML`.`Ress`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`CualESI_AFTER_DELETE` AFTER DELETE ON `CualESI` FOR EACH ROW
BEGIN
delete from `OML`.`Ress`;
END$$

-- `OML`.`TlgyIAsts`(x) iff `OML`.`CualESI`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`CualESI_AFTER_INSERT` AFTER INSERT ON `CualESI` FOR EACH ROW
BEGIN
insert into `OML`.`TlgyIAsts`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`CualESI_AFTER_DELETE` AFTER DELETE ON `CualESI` FOR EACH ROW
BEGIN
delete from `OML`.`TlgyIAsts`;
END$$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`CRBK` (CrossReferencableKinds)
-- -----------------------------------------------------

-- `OML`.`CRTK`(x) iff `OML`.`CRBK`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`CRBK_AFTER_INSERT` AFTER INSERT ON `CRBK` FOR EACH ROW
BEGIN
insert into `OML`.`CRTK`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`CRBK_AFTER_DELETE` AFTER DELETE ON `CRBK` FOR EACH ROW
BEGIN
delete from `OML`.`CRTK`;
END$$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`Drs` (DataRanges)
-- -----------------------------------------------------

-- `OML`.`Dt`(x) iff `OML`.`Drs`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`Drs_AFTER_INSERT` AFTER INSERT ON `Drs` FOR EACH ROW
BEGIN
insert into `OML`.`Dt`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`Drs_AFTER_DELETE` AFTER DELETE ON `Drs` FOR EACH ROW
BEGIN
delete from `OML`.`Dt`;
END$$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`DRels` (DataRelationships)
-- -----------------------------------------------------

-- `OML`.`DirBinRelKinds`(x) iff `OML`.`DRels`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`DRels_AFTER_INSERT` AFTER INSERT ON `DRels` FOR EACH ROW
BEGIN
insert into `OML`.`DirBinRelKinds`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`DRels_AFTER_DELETE` AFTER DELETE ON `DRels` FOR EACH ROW
BEGIN
delete from `OML`.`DirBinRelKinds`;
END$$

-- `OML`.`Terms`(x) iff `OML`.`DRels`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`DRels_AFTER_INSERT` AFTER INSERT ON `DRels` FOR EACH ROW
BEGIN
insert into `OML`.`Terms`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`DRels_AFTER_DELETE` AFTER DELETE ON `DRels` FOR EACH ROW
BEGIN
delete from `OML`.`Terms`;
END$$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`DRelDomains` (DataRelationshipDomains)
-- -----------------------------------------------------

-- `OML`.`DRels`(x) iff `OML`.`DRelDomains`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`DRelDomains_AFTER_INSERT` AFTER INSERT ON `DRelDomains` FOR EACH ROW
BEGIN
insert into `OML`.`DRels`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`DRelDomains_AFTER_DELETE` AFTER DELETE ON `DRelDomains` FOR EACH ROW
BEGIN
delete from `OML`.`DRels`;
END$$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`DRelFromEs` (DataRelationshipFromEntities)
-- -----------------------------------------------------

-- `OML`.`DRelDomains`(x) iff `OML`.`DRelFromEs`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`DRelFromEs_AFTER_INSERT` AFTER INSERT ON `DRelFromEs` FOR EACH ROW
BEGIN
insert into `OML`.`DRelDomains`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`DRelFromEs_AFTER_DELETE` AFTER DELETE ON `DRelFromEs` FOR EACH ROW
BEGIN
delete from `OML`.`DRelDomains`;
END$$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`DRelFromSts` (DataRelationshipFromStructures)
-- -----------------------------------------------------

-- `OML`.`DRelDomains`(x) iff `OML`.`DRelFromSts`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`DRelFromSts_AFTER_INSERT` AFTER INSERT ON `DRelFromSts` FOR EACH ROW
BEGIN
insert into `OML`.`DRelDomains`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`DRelFromSts_AFTER_DELETE` AFTER DELETE ON `DRelFromSts` FOR EACH ROW
BEGIN
delete from `OML`.`DRelDomains`;
END$$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`DRelRanges` (DataRelationshipRanges)
-- -----------------------------------------------------

-- `OML`.`DRels`(x) iff `OML`.`DRelRanges`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`DRelRanges_AFTER_INSERT` AFTER INSERT ON `DRelRanges` FOR EACH ROW
BEGIN
insert into `OML`.`DRels`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`DRelRanges_AFTER_DELETE` AFTER DELETE ON `DRelRanges` FOR EACH ROW
BEGIN
delete from `OML`.`DRels`;
END$$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`DRelToScs` (DataRelationshipToScalars)
-- -----------------------------------------------------

-- `OML`.`DRelRanges`(x) iff `OML`.`DRelToScs`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`DRelToScs_AFTER_INSERT` AFTER INSERT ON `DRelToScs` FOR EACH ROW
BEGIN
insert into `OML`.`DRelRanges`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`DRelToScs_AFTER_DELETE` AFTER DELETE ON `DRelToScs` FOR EACH ROW
BEGIN
delete from `OML`.`DRelRanges`;
END$$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`DRelToSts` (DataRelationshipToStructures)
-- -----------------------------------------------------

-- `OML`.`DRelRanges`(x) iff `OML`.`DRelToSts`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`DRelToSts_AFTER_INSERT` AFTER INSERT ON `DRelToSts` FOR EACH ROW
BEGIN
insert into `OML`.`DRelRanges`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`DRelToSts_AFTER_DELETE` AFTER DELETE ON `DRelToSts` FOR EACH ROW
BEGIN
delete from `OML`.`DRelRanges`;
END$$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`Dt` (Datatypes)
-- -----------------------------------------------------

-- `OML`.`Terms`(x) iff `OML`.`Dt`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`Dt_AFTER_INSERT` AFTER INSERT ON `Dt` FOR EACH ROW
BEGIN
insert into `OML`.`Terms`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`Dt_AFTER_DELETE` AFTER DELETE ON `Dt` FOR EACH ROW
BEGIN
delete from `OML`.`Terms`;
END$$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`DBoxRels` (DescriptionBoxRelationships)
-- -----------------------------------------------------

-- `OML`.`ModEdges`(x) iff `OML`.`DBoxRels`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`DBoxRels_AFTER_INSERT` AFTER INSERT ON `DBoxRels` FOR EACH ROW
BEGIN
insert into `OML`.`ModEdges`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`DBoxRels_AFTER_DELETE` AFTER DELETE ON `DBoxRels` FOR EACH ROW
BEGIN
delete from `OML`.`ModEdges`;
END$$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`DirBinRelKinds` (DirectedBinaryRelationshipKinds)
-- -----------------------------------------------------

-- `OML`.`Terms`(x) iff `OML`.`DirBinRelKinds`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`DirBinRelKinds_AFTER_INSERT` AFTER INSERT ON `DirBinRelKinds` FOR EACH ROW
BEGIN
insert into `OML`.`Terms`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`DirBinRelKinds_AFTER_DELETE` AFTER DELETE ON `DirBinRelKinds` FOR EACH ROW
BEGIN
delete from `OML`.`Terms`;
END$$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`DsjUOfCsAx` (DisjointUnionOfConceptsAxioms)
-- -----------------------------------------------------

-- `OML`.`EltCRefTs`(x) iff `OML`.`DsjUOfCsAx`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`DsjUOfCsAx_AFTER_INSERT` AFTER INSERT ON `DsjUOfCsAx` FOR EACH ROW
BEGIN
insert into `OML`.`EltCRefTs`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`DsjUOfCsAx_AFTER_DELETE` AFTER DELETE ON `DsjUOfCsAx` FOR EACH ROW
BEGIN
delete from `OML`.`EltCRefTs`;
END$$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`EltCRefTs` (ElementCrossReferenceTuples)
-- -----------------------------------------------------

-- `OML`.`CRBK`(x) iff `OML`.`EltCRefTs`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`EltCRefTs_AFTER_INSERT` AFTER INSERT ON `EltCRefTs` FOR EACH ROW
BEGIN
insert into `OML`.`CRBK`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`EltCRefTs_AFTER_DELETE` AFTER DELETE ON `EltCRefTs` FOR EACH ROW
BEGIN
delete from `OML`.`CRBK`;
END$$

-- `OML`.`EIdK`(x) iff `OML`.`EltCRefTs`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`EltCRefTs_AFTER_INSERT` AFTER INSERT ON `EltCRefTs` FOR EACH ROW
BEGIN
insert into `OML`.`EIdK`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`EltCRefTs_AFTER_DELETE` AFTER DELETE ON `EltCRefTs` FOR EACH ROW
BEGIN
delete from `OML`.`EIdK`;
END$$

-- `OML`.`LogEs`(x) iff `OML`.`EltCRefTs`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`EltCRefTs_AFTER_INSERT` AFTER INSERT ON `EltCRefTs` FOR EACH ROW
BEGIN
insert into `OML`.`LogEs`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`EltCRefTs_AFTER_DELETE` AFTER DELETE ON `EltCRefTs` FOR EACH ROW
BEGIN
delete from `OML`.`LogEs`;
END$$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`Es` (Entities)
-- -----------------------------------------------------

-- `OML`.`Terms`(x) iff `OML`.`Es`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`Es_AFTER_INSERT` AFTER INSERT ON `Es` FOR EACH ROW
BEGIN
insert into `OML`.`Terms`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`Es_AFTER_DELETE` AFTER DELETE ON `Es` FOR EACH ROW
BEGIN
delete from `OML`.`Terms`;
END$$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`ERels` (EntityRelationships)
-- -----------------------------------------------------

-- `OML`.`DirBinRelKinds`(x) iff `OML`.`ERels`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`ERels_AFTER_INSERT` AFTER INSERT ON `ERels` FOR EACH ROW
BEGIN
insert into `OML`.`DirBinRelKinds`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`ERels_AFTER_DELETE` AFTER DELETE ON `ERels` FOR EACH ROW
BEGIN
delete from `OML`.`DirBinRelKinds`;
END$$

-- `OML`.`Terms`(x) iff `OML`.`ERels`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`ERels_AFTER_INSERT` AFTER INSERT ON `ERels` FOR EACH ROW
BEGIN
insert into `OML`.`Terms`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`ERels_AFTER_DELETE` AFTER DELETE ON `ERels` FOR EACH ROW
BEGIN
delete from `OML`.`Terms`;
END$$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`ERAx` (EntityRestrictionAxioms)
-- -----------------------------------------------------

-- `OML`.`EltCRefTs`(x) iff `OML`.`ERAx`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`ERAx_AFTER_INSERT` AFTER INSERT ON `ERAx` FOR EACH ROW
BEGIN
insert into `OML`.`EltCRefTs`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`ERAx_AFTER_DELETE` AFTER DELETE ON `ERAx` FOR EACH ROW
BEGIN
delete from `OML`.`EltCRefTs`;
END$$

-- `OML`.`TermAx`(x) iff `OML`.`ERAx`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`ERAx_AFTER_INSERT` AFTER INSERT ON `ERAx` FOR EACH ROW
BEGIN
insert into `OML`.`TermAx`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`ERAx_AFTER_DELETE` AFTER DELETE ON `ERAx` FOR EACH ROW
BEGIN
delete from `OML`.`TermAx`;
END$$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`EScPRAx` (EntityScalarDataPropertyRestrictionAxioms)
-- -----------------------------------------------------

-- `OML`.`EIdK`(x) iff `OML`.`EScPRAx`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`EScPRAx_AFTER_INSERT` AFTER INSERT ON `EScPRAx` FOR EACH ROW
BEGIN
insert into `OML`.`EIdK`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`EScPRAx_AFTER_DELETE` AFTER DELETE ON `EScPRAx` FOR EACH ROW
BEGIN
delete from `OML`.`EIdK`;
END$$

-- `OML`.`TermAx`(x) iff `OML`.`EScPRAx`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`EScPRAx_AFTER_INSERT` AFTER INSERT ON `EScPRAx` FOR EACH ROW
BEGIN
insert into `OML`.`TermAx`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`EScPRAx_AFTER_DELETE` AFTER DELETE ON `EScPRAx` FOR EACH ROW
BEGIN
delete from `OML`.`TermAx`;
END$$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`EStPRAx` (EntityStructuredDataPropertyRestrictionAxioms)
-- -----------------------------------------------------

-- `OML`.`EltCRefTs`(x) iff `OML`.`EStPRAx`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`EStPRAx_AFTER_INSERT` AFTER INSERT ON `EStPRAx` FOR EACH ROW
BEGIN
insert into `OML`.`EltCRefTs`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`EStPRAx_AFTER_DELETE` AFTER DELETE ON `EStPRAx` FOR EACH ROW
BEGIN
delete from `OML`.`EltCRefTs`;
END$$

-- `OML`.`TermAx`(x) iff `OML`.`EStPRAx`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`EStPRAx_AFTER_INSERT` AFTER INSERT ON `EStPRAx` FOR EACH ROW
BEGIN
insert into `OML`.`TermAx`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`EStPRAx_AFTER_DELETE` AFTER DELETE ON `EStPRAx` FOR EACH ROW
BEGIN
delete from `OML`.`TermAx`;
END$$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`EIdK` (ExtrinsicIdentityKinds)
-- -----------------------------------------------------

-- `OML`.`Ik`(x) iff `OML`.`EIdK`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`EIdK_AFTER_INSERT` AFTER INSERT ON `EIdK` FOR EACH ROW
BEGIN
insert into `OML`.`Ik`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`EIdK_AFTER_DELETE` AFTER DELETE ON `EIdK` FOR EACH ROW
BEGIN
delete from `OML`.`Ik`;
END$$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`Ik` (IdentityKinds)
-- -----------------------------------------------------

-- `OML`.`CRTK`(x) iff `OML`.`Ik`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`Ik_AFTER_INSERT` AFTER INSERT ON `Ik` FOR EACH ROW
BEGIN
insert into `OML`.`CRTK`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`Ik_AFTER_DELETE` AFTER DELETE ON `Ik` FOR EACH ROW
BEGIN
delete from `OML`.`CRTK`;
END$$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`IIdK` (IntrinsicIdentityKinds)
-- -----------------------------------------------------

-- `OML`.`CRBK`(x) iff `OML`.`IIdK`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`IIdK_AFTER_INSERT` AFTER INSERT ON `IIdK` FOR EACH ROW
BEGIN
insert into `OML`.`CRBK`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`IIdK_AFTER_DELETE` AFTER DELETE ON `IIdK` FOR EACH ROW
BEGIN
delete from `OML`.`CRBK`;
END$$

-- `OML`.`Ik`(x) iff `OML`.`IIdK`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`IIdK_AFTER_INSERT` AFTER INSERT ON `IIdK` FOR EACH ROW
BEGIN
insert into `OML`.`Ik`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`IIdK_AFTER_DELETE` AFTER DELETE ON `IIdK` FOR EACH ROW
BEGIN
delete from `OML`.`Ik`;
END$$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`LogEs` (LogicalElements)
-- -----------------------------------------------------

-- `OML`.`Ik`(x) iff `OML`.`LogEs`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`LogEs_AFTER_INSERT` AFTER INSERT ON `LogEs` FOR EACH ROW
BEGIN
insert into `OML`.`Ik`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`LogEs_AFTER_DELETE` AFTER DELETE ON `LogEs` FOR EACH ROW
BEGIN
delete from `OML`.`Ik`;
END$$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`Mods` (Modules)
-- -----------------------------------------------------

-- `OML`.`Ress`(x) iff `OML`.`Mods`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`Mods_AFTER_INSERT` AFTER INSERT ON `Mods` FOR EACH ROW
BEGIN
insert into `OML`.`Ress`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`Mods_AFTER_DELETE` AFTER DELETE ON `Mods` FOR EACH ROW
BEGIN
delete from `OML`.`Ress`;
END$$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`ModEdges` (ModuleEdges)
-- -----------------------------------------------------

-- `OML`.`EltCRefTs`(x) iff `OML`.`ModEdges`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`ModEdges_AFTER_INSERT` AFTER INSERT ON `ModEdges` FOR EACH ROW
BEGIN
insert into `OML`.`EltCRefTs`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`ModEdges_AFTER_DELETE` AFTER DELETE ON `ModEdges` FOR EACH ROW
BEGIN
delete from `OML`.`EltCRefTs`;
END$$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`ModElts` (ModuleElements)
-- -----------------------------------------------------

-- `OML`.`LogEs`(x) iff `OML`.`ModElts`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`ModElts_AFTER_INSERT` AFTER INSERT ON `ModElts` FOR EACH ROW
BEGIN
insert into `OML`.`LogEs`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`ModElts_AFTER_DELETE` AFTER DELETE ON `ModElts` FOR EACH ROW
BEGIN
delete from `OML`.`LogEs`;
END$$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`NonCRBK` (NonCrossReferencableKinds)
-- -----------------------------------------------------

-- `OML`.`CRTK`(x) iff `OML`.`NonCRBK`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`NonCRBK_AFTER_INSERT` AFTER INSERT ON `NonCRBK` FOR EACH ROW
BEGIN
insert into `OML`.`CRTK`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`NonCRBK_AFTER_DELETE` AFTER DELETE ON `NonCRBK` FOR EACH ROW
BEGIN
delete from `OML`.`CRTK`;
END$$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`NonLogEs` (NonLogicalElements)
-- -----------------------------------------------------

-- `OML`.`Ik`(x) iff `OML`.`NonLogEs`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`NonLogEs_AFTER_INSERT` AFTER INSERT ON `NonLogEs` FOR EACH ROW
BEGIN
insert into `OML`.`Ik`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`NonLogEs_AFTER_DELETE` AFTER DELETE ON `NonLogEs` FOR EACH ROW
BEGIN
delete from `OML`.`Ik`;
END$$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`Ress` (Resources)
-- -----------------------------------------------------

-- `OML`.`IIdK`(x) iff `OML`.`Ress`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`Ress_AFTER_INSERT` AFTER INSERT ON `Ress` FOR EACH ROW
BEGIN
insert into `OML`.`IIdK`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`Ress_AFTER_DELETE` AFTER DELETE ON `Ress` FOR EACH ROW
BEGIN
delete from `OML`.`IIdK`;
END$$

-- `OML`.`LogEs`(x) iff `OML`.`Ress`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`Ress_AFTER_INSERT` AFTER INSERT ON `Ress` FOR EACH ROW
BEGIN
insert into `OML`.`LogEs`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`Ress_AFTER_DELETE` AFTER DELETE ON `Ress` FOR EACH ROW
BEGIN
delete from `OML`.`LogEs`;
END$$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`RestDrs` (RestrictedDataRanges)
-- -----------------------------------------------------

-- `OML`.`Drs`(x) iff `OML`.`RestDrs`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`RestDrs_AFTER_INSERT` AFTER INSERT ON `RestDrs` FOR EACH ROW
BEGIN
insert into `OML`.`Drs`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`RestDrs_AFTER_DELETE` AFTER DELETE ON `RestDrs` FOR EACH ROW
BEGIN
delete from `OML`.`Drs`;
END$$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`RStPCtxts` (RestrictionStructuredDataPropertyContexts)
-- -----------------------------------------------------

-- `OML`.`EltCRefTs`(x) iff `OML`.`RStPCtxts`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`RStPCtxts_AFTER_INSERT` AFTER INSERT ON `RStPCtxts` FOR EACH ROW
BEGIN
insert into `OML`.`EltCRefTs`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`RStPCtxts_AFTER_DELETE` AFTER DELETE ON `RStPCtxts` FOR EACH ROW
BEGIN
delete from `OML`.`EltCRefTs`;
END$$

-- `OML`.`ModElts`(x) iff `OML`.`RStPCtxts`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`RStPCtxts_AFTER_INSERT` AFTER INSERT ON `RStPCtxts` FOR EACH ROW
BEGIN
insert into `OML`.`ModElts`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`RStPCtxts_AFTER_DELETE` AFTER DELETE ON `RStPCtxts` FOR EACH ROW
BEGIN
delete from `OML`.`ModElts`;
END$$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`Rules` (Rules)
-- -----------------------------------------------------

-- `OML`.`Terms`(x) iff `OML`.`Rules`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`Rules_AFTER_INSERT` AFTER INSERT ON `Rules` FOR EACH ROW
BEGIN
insert into `OML`.`Terms`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`Rules_AFTER_DELETE` AFTER DELETE ON `Rules` FOR EACH ROW
BEGIN
delete from `OML`.`Terms`;
END$$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`SegP` (SegmentPredicates)
-- -----------------------------------------------------

-- `OML`.`EltCRefTs`(x) iff `OML`.`SegP`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`SegP_AFTER_INSERT` AFTER INSERT ON `SegP` FOR EACH ROW
BEGIN
insert into `OML`.`EltCRefTs`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`SegP_AFTER_DELETE` AFTER DELETE ON `SegP` FOR EACH ROW
BEGIN
delete from `OML`.`EltCRefTs`;
END$$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`S1IStPCtxts` (SingletonInstanceStructuredDataPropertyContexts)
-- -----------------------------------------------------

-- `OML`.`EltCRefTs`(x) iff `OML`.`S1IStPCtxts`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`S1IStPCtxts_AFTER_INSERT` AFTER INSERT ON `S1IStPCtxts` FOR EACH ROW
BEGIN
insert into `OML`.`EltCRefTs`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`S1IStPCtxts_AFTER_DELETE` AFTER DELETE ON `S1IStPCtxts` FOR EACH ROW
BEGIN
delete from `OML`.`EltCRefTs`;
END$$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`SpeAx` (SpecializationAxioms)
-- -----------------------------------------------------

-- `OML`.`EltCRefTs`(x) iff `OML`.`SpeAx`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`SpeAx_AFTER_INSERT` AFTER INSERT ON `SpeAx` FOR EACH ROW
BEGIN
insert into `OML`.`EltCRefTs`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`SpeAx_AFTER_DELETE` AFTER DELETE ON `SpeAx` FOR EACH ROW
BEGIN
delete from `OML`.`EltCRefTs`;
END$$

-- `OML`.`TermAx`(x) iff `OML`.`SpeAx`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`SpeAx_AFTER_INSERT` AFTER INSERT ON `SpeAx` FOR EACH ROW
BEGIN
insert into `OML`.`TermAx`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`SpeAx_AFTER_DELETE` AFTER DELETE ON `SpeAx` FOR EACH ROW
BEGIN
delete from `OML`.`TermAx`;
END$$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`Terms` (Terms)
-- -----------------------------------------------------

-- `OML`.`Ress`(x) iff `OML`.`Terms`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`Terms_AFTER_INSERT` AFTER INSERT ON `Terms` FOR EACH ROW
BEGIN
insert into `OML`.`Ress`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`Terms_AFTER_DELETE` AFTER DELETE ON `Terms` FOR EACH ROW
BEGIN
delete from `OML`.`Ress`;
END$$

-- `OML`.`TBoxSt`(x) iff `OML`.`Terms`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`Terms_AFTER_INSERT` AFTER INSERT ON `Terms` FOR EACH ROW
BEGIN
insert into `OML`.`TBoxSt`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`Terms_AFTER_DELETE` AFTER DELETE ON `Terms` FOR EACH ROW
BEGIN
delete from `OML`.`TBoxSt`;
END$$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`TermAx` (TermAxioms)
-- -----------------------------------------------------

-- `OML`.`TBoxSt`(x) iff `OML`.`TermAx`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`TermAx_AFTER_INSERT` AFTER INSERT ON `TermAx` FOR EACH ROW
BEGIN
insert into `OML`.`TBoxSt`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`TermAx_AFTER_DELETE` AFTER DELETE ON `TermAx` FOR EACH ROW
BEGIN
delete from `OML`.`TBoxSt`;
END$$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`TlgyAx` (TerminologyAxioms)
-- -----------------------------------------------------

-- `OML`.`ModEdges`(x) iff `OML`.`TlgyAx`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`TlgyAx_AFTER_INSERT` AFTER INSERT ON `TlgyAx` FOR EACH ROW
BEGIN
insert into `OML`.`ModEdges`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`TlgyAx_AFTER_DELETE` AFTER DELETE ON `TlgyAx` FOR EACH ROW
BEGIN
delete from `OML`.`ModEdges`;
END$$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`TBox` (TerminologyBoxes)
-- -----------------------------------------------------

-- `OML`.`Mods`(x) iff `OML`.`TBox`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`TBox_AFTER_INSERT` AFTER INSERT ON `TBox` FOR EACH ROW
BEGIN
insert into `OML`.`Mods`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`TBox_AFTER_DELETE` AFTER DELETE ON `TBox` FOR EACH ROW
BEGIN
delete from `OML`.`Mods`;
END$$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`TBoxAx` (TerminologyBoxAxioms)
-- -----------------------------------------------------

-- `OML`.`TlgyAx`(x) iff `OML`.`TBoxAx`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`TBoxAx_AFTER_INSERT` AFTER INSERT ON `TBoxAx` FOR EACH ROW
BEGIN
insert into `OML`.`TlgyAx`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`TBoxAx_AFTER_DELETE` AFTER DELETE ON `TBoxAx` FOR EACH ROW
BEGIN
delete from `OML`.`TlgyAx`;
END$$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`TBoxSt` (TerminologyBoxStatements)
-- -----------------------------------------------------

-- `OML`.`ModElts`(x) iff `OML`.`TBoxSt`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`TBoxSt_AFTER_INSERT` AFTER INSERT ON `TBoxSt` FOR EACH ROW
BEGIN
insert into `OML`.`ModElts`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`TBoxSt_AFTER_DELETE` AFTER DELETE ON `TBoxSt` FOR EACH ROW
BEGIN
delete from `OML`.`ModElts`;
END$$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`TlgyBdlAx` (TerminologyBundleAxioms)
-- -----------------------------------------------------

-- `OML`.`TlgyAx`(x) iff `OML`.`TlgyBdlAx`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`TlgyBdlAx_AFTER_INSERT` AFTER INSERT ON `TlgyBdlAx` FOR EACH ROW
BEGIN
insert into `OML`.`TlgyAx`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`TlgyBdlAx_AFTER_DELETE` AFTER DELETE ON `TlgyBdlAx` FOR EACH ROW
BEGIN
delete from `OML`.`TlgyAx`;
END$$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`TlgyBdlSt` (TerminologyBundleStatements)
-- -----------------------------------------------------

-- `OML`.`ModElts`(x) iff `OML`.`TlgyBdlSt`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`TlgyBdlSt_AFTER_INSERT` AFTER INSERT ON `TlgyBdlSt` FOR EACH ROW
BEGIN
insert into `OML`.`ModElts`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`TlgyBdlSt_AFTER_DELETE` AFTER DELETE ON `TlgyBdlSt` FOR EACH ROW
BEGIN
delete from `OML`.`ModElts`;
END$$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`TlgyIAsts` (TerminologyInstanceAssertions)
-- -----------------------------------------------------

-- `OML`.`ModElts`(x) iff `OML`.`TlgyIAsts`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`TlgyIAsts_AFTER_INSERT` AFTER INSERT ON `TlgyIAsts` FOR EACH ROW
BEGIN
insert into `OML`.`ModElts`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`TlgyIAsts_AFTER_DELETE` AFTER DELETE ON `TlgyIAsts` FOR EACH ROW
BEGIN
delete from `OML`.`ModElts`;
END$$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`UrySegP` (UnarySegmentPredicates)
-- -----------------------------------------------------

-- `OML`.`SegP`(x) iff `OML`.`UrySegP`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`UrySegP_AFTER_INSERT` AFTER INSERT ON `UrySegP` FOR EACH ROW
BEGIN
insert into `OML`.`SegP`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`UrySegP_AFTER_DELETE` AFTER DELETE ON `UrySegP` FOR EACH ROW
BEGIN
delete from `OML`.`SegP`;
END$$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`UryTermKinds` (UnaryTermKinds)
-- -----------------------------------------------------

-- `OML`.`Terms`(x) iff `OML`.`UryTermKinds`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`UryTermKinds_AFTER_INSERT` AFTER INSERT ON `UryTermKinds` FOR EACH ROW
BEGIN
insert into `OML`.`Terms`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`UryTermKinds_AFTER_DELETE` AFTER DELETE ON `UryTermKinds` FOR EACH ROW
BEGIN
delete from `OML`.`Terms`;
END$$

-- -----------------------------------------------------
-- Abstract Classification Table `OML`.`ValCRefTs` (ValueCrossReferenceTuples)
-- -----------------------------------------------------

-- `OML`.`EIdK`(x) iff `OML`.`ValCRefTs`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`ValCRefTs_AFTER_INSERT` AFTER INSERT ON `ValCRefTs` FOR EACH ROW
BEGIN
insert into `OML`.`EIdK`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`ValCRefTs_AFTER_DELETE` AFTER DELETE ON `ValCRefTs` FOR EACH ROW
BEGIN
delete from `OML`.`EIdK`;
END$$

-- `OML`.`NonCRBK`(x) iff `OML`.`ValCRefTs`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`ValCRefTs_AFTER_INSERT` AFTER INSERT ON `ValCRefTs` FOR EACH ROW
BEGIN
insert into `OML`.`NonCRBK`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`ValCRefTs_AFTER_DELETE` AFTER DELETE ON `ValCRefTs` FOR EACH ROW
BEGIN
delete from `OML`.`NonCRBK`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`AnnotProps` (AnnotationProperties)
-- -----------------------------------------------------

-- `OML`.`IIdK`(x) iff `OML`.`AnnotProps`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`AnnotProps_AFTER_INSERT` AFTER INSERT ON `AnnotProps` FOR EACH ROW
BEGIN
insert into `OML`.`IIdK`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`AnnotProps_AFTER_DELETE` AFTER DELETE ON `AnnotProps` FOR EACH ROW
BEGIN
delete from `OML`.`IIdK`;
END$$

-- `OML`.`NonLogEs`(x) iff `OML`.`AnnotProps`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`AnnotProps_AFTER_INSERT` AFTER INSERT ON `AnnotProps` FOR EACH ROW
BEGIN
insert into `OML`.`NonLogEs`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`AnnotProps_AFTER_DELETE` AFTER DELETE ON `AnnotProps` FOR EACH ROW
BEGIN
delete from `OML`.`NonLogEs`;
END$$

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

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`CDesTlgyAx` (ConceptDesignationTerminologyAxioms)
-- -----------------------------------------------------

-- `OML`.`TBoxAx`(x) iff `OML`.`CDesTlgyAx`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`CDesTlgyAx_AFTER_INSERT` AFTER INSERT ON `CDesTlgyAx` FOR EACH ROW
BEGIN
insert into `OML`.`TBoxAx`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`CDesTlgyAx_AFTER_DELETE` AFTER DELETE ON `CDesTlgyAx` FOR EACH ROW
BEGIN
delete from `OML`.`TBoxAx`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`TlgyExtensionAx` (TerminologyExtensionAxioms)
-- -----------------------------------------------------

-- `OML`.`TBoxAx`(x) iff `OML`.`TlgyExtensionAx`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`TlgyExtensionAx_AFTER_INSERT` AFTER INSERT ON `TlgyExtensionAx` FOR EACH ROW
BEGIN
insert into `OML`.`TBoxAx`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`TlgyExtensionAx_AFTER_DELETE` AFTER DELETE ON `TlgyExtensionAx` FOR EACH ROW
BEGIN
delete from `OML`.`TBoxAx`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`TlgyNestingAx` (TerminologyNestingAxioms)
-- -----------------------------------------------------

-- `OML`.`TBoxAx`(x) iff `OML`.`TlgyNestingAx`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`TlgyNestingAx_AFTER_INSERT` AFTER INSERT ON `TlgyNestingAx` FOR EACH ROW
BEGIN
insert into `OML`.`TBoxAx`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`TlgyNestingAx_AFTER_DELETE` AFTER DELETE ON `TlgyNestingAx` FOR EACH ROW
BEGIN
delete from `OML`.`TBoxAx`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`Aspects` (Aspects)
-- -----------------------------------------------------

-- `OML`.`Es`(x) iff `OML`.`Aspects`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`Aspects_AFTER_INSERT` AFTER INSERT ON `Aspects` FOR EACH ROW
BEGIN
insert into `OML`.`Es`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`Aspects_AFTER_DELETE` AFTER DELETE ON `Aspects` FOR EACH ROW
BEGIN
delete from `OML`.`Es`;
END$$

-- `OML`.`UryTermKinds`(x) iff `OML`.`Aspects`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`Aspects_AFTER_INSERT` AFTER INSERT ON `Aspects` FOR EACH ROW
BEGIN
insert into `OML`.`UryTermKinds`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`Aspects_AFTER_DELETE` AFTER DELETE ON `Aspects` FOR EACH ROW
BEGIN
delete from `OML`.`UryTermKinds`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`Cs` (Concepts)
-- -----------------------------------------------------

-- `OML`.`CualEs`(x) iff `OML`.`Cs`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`Cs_AFTER_INSERT` AFTER INSERT ON `Cs` FOR EACH ROW
BEGIN
insert into `OML`.`CualEs`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`Cs_AFTER_DELETE` AFTER DELETE ON `Cs` FOR EACH ROW
BEGIN
delete from `OML`.`CualEs`;
END$$

-- `OML`.`UryTermKinds`(x) iff `OML`.`Cs`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`Cs_AFTER_INSERT` AFTER INSERT ON `Cs` FOR EACH ROW
BEGIN
insert into `OML`.`UryTermKinds`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`Cs_AFTER_DELETE` AFTER DELETE ON `Cs` FOR EACH ROW
BEGIN
delete from `OML`.`UryTermKinds`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`RRs` (ReifiedRelationships)
-- -----------------------------------------------------

-- `OML`.`CualEs`(x) iff `OML`.`RRs`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`RRs_AFTER_INSERT` AFTER INSERT ON `RRs` FOR EACH ROW
BEGIN
insert into `OML`.`CualEs`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`RRs_AFTER_DELETE` AFTER DELETE ON `RRs` FOR EACH ROW
BEGIN
delete from `OML`.`CualEs`;
END$$

-- `OML`.`ERels`(x) iff `OML`.`RRs`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`RRs_AFTER_INSERT` AFTER INSERT ON `RRs` FOR EACH ROW
BEGIN
insert into `OML`.`ERels`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`RRs_AFTER_DELETE` AFTER DELETE ON `RRs` FOR EACH ROW
BEGIN
delete from `OML`.`ERels`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`URs` (UnreifiedRelationships)
-- -----------------------------------------------------

-- `OML`.`ERels`(x) iff `OML`.`URs`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`URs_AFTER_INSERT` AFTER INSERT ON `URs` FOR EACH ROW
BEGIN
insert into `OML`.`ERels`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`URs_AFTER_DELETE` AFTER DELETE ON `URs` FOR EACH ROW
BEGIN
delete from `OML`.`ERels`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`Scs` (Scalars)
-- -----------------------------------------------------

-- `OML`.`Drs`(x) iff `OML`.`Scs`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`Scs_AFTER_INSERT` AFTER INSERT ON `Scs` FOR EACH ROW
BEGIN
insert into `OML`.`Drs`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`Scs_AFTER_DELETE` AFTER DELETE ON `Scs` FOR EACH ROW
BEGIN
delete from `OML`.`Drs`;
END$$

-- `OML`.`UryTermKinds`(x) iff `OML`.`Scs`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`Scs_AFTER_INSERT` AFTER INSERT ON `Scs` FOR EACH ROW
BEGIN
insert into `OML`.`UryTermKinds`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`Scs_AFTER_DELETE` AFTER DELETE ON `Scs` FOR EACH ROW
BEGIN
delete from `OML`.`UryTermKinds`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`Sts` (Structures)
-- -----------------------------------------------------

-- `OML`.`Dt`(x) iff `OML`.`Sts`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`Sts_AFTER_INSERT` AFTER INSERT ON `Sts` FOR EACH ROW
BEGIN
insert into `OML`.`Dt`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`Sts_AFTER_DELETE` AFTER DELETE ON `Sts` FOR EACH ROW
BEGIN
delete from `OML`.`Dt`;
END$$

-- `OML`.`UryTermKinds`(x) iff `OML`.`Sts`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`Sts_AFTER_INSERT` AFTER INSERT ON `Sts` FOR EACH ROW
BEGIN
insert into `OML`.`UryTermKinds`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`Sts_AFTER_DELETE` AFTER DELETE ON `Sts` FOR EACH ROW
BEGIN
delete from `OML`.`UryTermKinds`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`BinScRs` (BinaryScalarRestrictions)
-- -----------------------------------------------------

-- `OML`.`RestDrs`(x) iff `OML`.`BinScRs`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`BinScRs_AFTER_INSERT` AFTER INSERT ON `BinScRs` FOR EACH ROW
BEGIN
insert into `OML`.`RestDrs`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`BinScRs_AFTER_DELETE` AFTER DELETE ON `BinScRs` FOR EACH ROW
BEGIN
delete from `OML`.`RestDrs`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`IRIScRs` (IRIScalarRestrictions)
-- -----------------------------------------------------

-- `OML`.`RestDrs`(x) iff `OML`.`IRIScRs`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`IRIScRs_AFTER_INSERT` AFTER INSERT ON `IRIScRs` FOR EACH ROW
BEGIN
insert into `OML`.`RestDrs`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`IRIScRs_AFTER_DELETE` AFTER DELETE ON `IRIScRs` FOR EACH ROW
BEGIN
delete from `OML`.`RestDrs`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`NumericScRs` (NumericScalarRestrictions)
-- -----------------------------------------------------

-- `OML`.`RestDrs`(x) iff `OML`.`NumericScRs`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`NumericScRs_AFTER_INSERT` AFTER INSERT ON `NumericScRs` FOR EACH ROW
BEGIN
insert into `OML`.`RestDrs`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`NumericScRs_AFTER_DELETE` AFTER DELETE ON `NumericScRs` FOR EACH ROW
BEGIN
delete from `OML`.`RestDrs`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`PlainLitScRs` (PlainLiteralScalarRestrictions)
-- -----------------------------------------------------

-- `OML`.`RestDrs`(x) iff `OML`.`PlainLitScRs`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`PlainLitScRs_AFTER_INSERT` AFTER INSERT ON `PlainLitScRs` FOR EACH ROW
BEGIN
insert into `OML`.`RestDrs`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`PlainLitScRs_AFTER_DELETE` AFTER DELETE ON `PlainLitScRs` FOR EACH ROW
BEGIN
delete from `OML`.`RestDrs`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`ScOneOfRs` (ScalarOneOfRestrictions)
-- -----------------------------------------------------

-- `OML`.`RestDrs`(x) iff `OML`.`ScOneOfRs`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`ScOneOfRs_AFTER_INSERT` AFTER INSERT ON `ScOneOfRs` FOR EACH ROW
BEGIN
insert into `OML`.`RestDrs`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`ScOneOfRs_AFTER_DELETE` AFTER DELETE ON `ScOneOfRs` FOR EACH ROW
BEGIN
delete from `OML`.`RestDrs`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`StringScRs` (StringScalarRestrictions)
-- -----------------------------------------------------

-- `OML`.`RestDrs`(x) iff `OML`.`StringScRs`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`StringScRs_AFTER_INSERT` AFTER INSERT ON `StringScRs` FOR EACH ROW
BEGIN
insert into `OML`.`RestDrs`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`StringScRs_AFTER_DELETE` AFTER DELETE ON `StringScRs` FOR EACH ROW
BEGIN
delete from `OML`.`RestDrs`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`SynonymScRs` (SynonymScalarRestrictions)
-- -----------------------------------------------------

-- `OML`.`RestDrs`(x) iff `OML`.`SynonymScRs`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`SynonymScRs_AFTER_INSERT` AFTER INSERT ON `SynonymScRs` FOR EACH ROW
BEGIN
insert into `OML`.`RestDrs`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`SynonymScRs_AFTER_DELETE` AFTER DELETE ON `SynonymScRs` FOR EACH ROW
BEGIN
delete from `OML`.`RestDrs`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`TimeScRs` (TimeScalarRestrictions)
-- -----------------------------------------------------

-- `OML`.`RestDrs`(x) iff `OML`.`TimeScRs`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`TimeScRs_AFTER_INSERT` AFTER INSERT ON `TimeScRs` FOR EACH ROW
BEGIN
insert into `OML`.`RestDrs`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`TimeScRs_AFTER_DELETE` AFTER DELETE ON `TimeScRs` FOR EACH ROW
BEGIN
delete from `OML`.`RestDrs`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`EScPs` (EntityScalarDataProperties)
-- -----------------------------------------------------

-- `OML`.`DRelFromEs`(x) iff `OML`.`EScPs`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`EScPs_AFTER_INSERT` AFTER INSERT ON `EScPs` FOR EACH ROW
BEGIN
insert into `OML`.`DRelFromEs`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`EScPs_AFTER_DELETE` AFTER DELETE ON `EScPs` FOR EACH ROW
BEGIN
delete from `OML`.`DRelFromEs`;
END$$

-- `OML`.`DRelToScs`(x) iff `OML`.`EScPs`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`EScPs_AFTER_INSERT` AFTER INSERT ON `EScPs` FOR EACH ROW
BEGIN
insert into `OML`.`DRelToScs`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`EScPs_AFTER_DELETE` AFTER DELETE ON `EScPs` FOR EACH ROW
BEGIN
delete from `OML`.`DRelToScs`;
END$$

-- `OML`.`DRels`(x) iff `OML`.`EScPs`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`EScPs_AFTER_INSERT` AFTER INSERT ON `EScPs` FOR EACH ROW
BEGIN
insert into `OML`.`DRels`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`EScPs_AFTER_DELETE` AFTER DELETE ON `EScPs` FOR EACH ROW
BEGIN
delete from `OML`.`DRels`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`EStPs` (EntityStructuredDataProperties)
-- -----------------------------------------------------

-- `OML`.`DRelFromEs`(x) iff `OML`.`EStPs`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`EStPs_AFTER_INSERT` AFTER INSERT ON `EStPs` FOR EACH ROW
BEGIN
insert into `OML`.`DRelFromEs`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`EStPs_AFTER_DELETE` AFTER DELETE ON `EStPs` FOR EACH ROW
BEGIN
delete from `OML`.`DRelFromEs`;
END$$

-- `OML`.`DRelToSts`(x) iff `OML`.`EStPs`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`EStPs_AFTER_INSERT` AFTER INSERT ON `EStPs` FOR EACH ROW
BEGIN
insert into `OML`.`DRelToSts`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`EStPs_AFTER_DELETE` AFTER DELETE ON `EStPs` FOR EACH ROW
BEGIN
delete from `OML`.`DRelToSts`;
END$$

-- `OML`.`DRels`(x) iff `OML`.`EStPs`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`EStPs_AFTER_INSERT` AFTER INSERT ON `EStPs` FOR EACH ROW
BEGIN
insert into `OML`.`DRels`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`EStPs_AFTER_DELETE` AFTER DELETE ON `EStPs` FOR EACH ROW
BEGIN
delete from `OML`.`DRels`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`ScPs` (ScalarDataProperties)
-- -----------------------------------------------------

-- `OML`.`DRelFromSts`(x) iff `OML`.`ScPs`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`ScPs_AFTER_INSERT` AFTER INSERT ON `ScPs` FOR EACH ROW
BEGIN
insert into `OML`.`DRelFromSts`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`ScPs_AFTER_DELETE` AFTER DELETE ON `ScPs` FOR EACH ROW
BEGIN
delete from `OML`.`DRelFromSts`;
END$$

-- `OML`.`DRelToScs`(x) iff `OML`.`ScPs`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`ScPs_AFTER_INSERT` AFTER INSERT ON `ScPs` FOR EACH ROW
BEGIN
insert into `OML`.`DRelToScs`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`ScPs_AFTER_DELETE` AFTER DELETE ON `ScPs` FOR EACH ROW
BEGIN
delete from `OML`.`DRelToScs`;
END$$

-- `OML`.`DRels`(x) iff `OML`.`ScPs`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`ScPs_AFTER_INSERT` AFTER INSERT ON `ScPs` FOR EACH ROW
BEGIN
insert into `OML`.`DRels`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`ScPs_AFTER_DELETE` AFTER DELETE ON `ScPs` FOR EACH ROW
BEGIN
delete from `OML`.`DRels`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`StPs` (StructuredDataProperties)
-- -----------------------------------------------------

-- `OML`.`DRelFromSts`(x) iff `OML`.`StPs`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`StPs_AFTER_INSERT` AFTER INSERT ON `StPs` FOR EACH ROW
BEGIN
insert into `OML`.`DRelFromSts`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`StPs_AFTER_DELETE` AFTER DELETE ON `StPs` FOR EACH ROW
BEGIN
delete from `OML`.`DRelFromSts`;
END$$

-- `OML`.`DRelToSts`(x) iff `OML`.`StPs`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`StPs_AFTER_INSERT` AFTER INSERT ON `StPs` FOR EACH ROW
BEGIN
insert into `OML`.`DRelToSts`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`StPs_AFTER_DELETE` AFTER DELETE ON `StPs` FOR EACH ROW
BEGIN
delete from `OML`.`DRelToSts`;
END$$

-- `OML`.`DRels`(x) iff `OML`.`StPs`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`StPs_AFTER_INSERT` AFTER INSERT ON `StPs` FOR EACH ROW
BEGIN
insert into `OML`.`DRels`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`StPs_AFTER_DELETE` AFTER DELETE ON `StPs` FOR EACH ROW
BEGIN
delete from `OML`.`DRels`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`AspectSpeAx` (AspectSpecializationAxioms)
-- -----------------------------------------------------

-- `OML`.`SpeAx`(x) iff `OML`.`AspectSpeAx`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`AspectSpeAx_AFTER_INSERT` AFTER INSERT ON `AspectSpeAx` FOR EACH ROW
BEGIN
insert into `OML`.`SpeAx`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`AspectSpeAx_AFTER_DELETE` AFTER DELETE ON `AspectSpeAx` FOR EACH ROW
BEGIN
delete from `OML`.`SpeAx`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`CSpeAx` (ConceptSpecializationAxioms)
-- -----------------------------------------------------

-- `OML`.`SpeAx`(x) iff `OML`.`CSpeAx`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`CSpeAx_AFTER_INSERT` AFTER INSERT ON `CSpeAx` FOR EACH ROW
BEGIN
insert into `OML`.`SpeAx`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`CSpeAx_AFTER_DELETE` AFTER DELETE ON `CSpeAx` FOR EACH ROW
BEGIN
delete from `OML`.`SpeAx`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`RRSpeAx` (ReifiedRelationshipSpecializationAxioms)
-- -----------------------------------------------------

-- `OML`.`SpeAx`(x) iff `OML`.`RRSpeAx`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`RRSpeAx_AFTER_INSERT` AFTER INSERT ON `RRSpeAx` FOR EACH ROW
BEGIN
insert into `OML`.`SpeAx`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`RRSpeAx_AFTER_DELETE` AFTER DELETE ON `RRSpeAx` FOR EACH ROW
BEGIN
delete from `OML`.`SpeAx`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`EExRAx` (EntityExistentialRestrictionAxioms)
-- -----------------------------------------------------

-- `OML`.`ERAx`(x) iff `OML`.`EExRAx`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`EExRAx_AFTER_INSERT` AFTER INSERT ON `EExRAx` FOR EACH ROW
BEGIN
insert into `OML`.`ERAx`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`EExRAx_AFTER_DELETE` AFTER DELETE ON `EExRAx` FOR EACH ROW
BEGIN
delete from `OML`.`ERAx`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`EUxRAx` (EntityUniversalRestrictionAxioms)
-- -----------------------------------------------------

-- `OML`.`ERAx`(x) iff `OML`.`EUxRAx`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`EUxRAx_AFTER_INSERT` AFTER INSERT ON `EUxRAx` FOR EACH ROW
BEGIN
insert into `OML`.`ERAx`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`EUxRAx_AFTER_DELETE` AFTER DELETE ON `EUxRAx` FOR EACH ROW
BEGIN
delete from `OML`.`ERAx`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`EScPExRAx` (EntityScalarDataPropertyExistentialRestrictionAxioms)
-- -----------------------------------------------------

-- `OML`.`EScPRAx`(x) iff `OML`.`EScPExRAx`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`EScPExRAx_AFTER_INSERT` AFTER INSERT ON `EScPExRAx` FOR EACH ROW
BEGIN
insert into `OML`.`EScPRAx`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`EScPExRAx_AFTER_DELETE` AFTER DELETE ON `EScPExRAx` FOR EACH ROW
BEGIN
delete from `OML`.`EScPRAx`;
END$$

-- `OML`.`EltCRefTs`(x) iff `OML`.`EScPExRAx`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`EScPExRAx_AFTER_INSERT` AFTER INSERT ON `EScPExRAx` FOR EACH ROW
BEGIN
insert into `OML`.`EltCRefTs`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`EScPExRAx_AFTER_DELETE` AFTER DELETE ON `EScPExRAx` FOR EACH ROW
BEGIN
delete from `OML`.`EltCRefTs`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`EScPPtrRAx` (EntityScalarDataPropertyParticularRestrictionAxioms)
-- -----------------------------------------------------

-- `OML`.`EScPRAx`(x) iff `OML`.`EScPPtrRAx`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`EScPPtrRAx_AFTER_INSERT` AFTER INSERT ON `EScPPtrRAx` FOR EACH ROW
BEGIN
insert into `OML`.`EScPRAx`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`EScPPtrRAx_AFTER_DELETE` AFTER DELETE ON `EScPPtrRAx` FOR EACH ROW
BEGIN
delete from `OML`.`EScPRAx`;
END$$

-- `OML`.`ValCRefTs`(x) iff `OML`.`EScPPtrRAx`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`EScPPtrRAx_AFTER_INSERT` AFTER INSERT ON `EScPPtrRAx` FOR EACH ROW
BEGIN
insert into `OML`.`ValCRefTs`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`EScPPtrRAx_AFTER_DELETE` AFTER DELETE ON `EScPPtrRAx` FOR EACH ROW
BEGIN
delete from `OML`.`ValCRefTs`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`EScPUxRAx` (EntityScalarDataPropertyUniversalRestrictionAxioms)
-- -----------------------------------------------------

-- `OML`.`EScPRAx`(x) iff `OML`.`EScPUxRAx`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`EScPUxRAx_AFTER_INSERT` AFTER INSERT ON `EScPUxRAx` FOR EACH ROW
BEGIN
insert into `OML`.`EScPRAx`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`EScPUxRAx_AFTER_DELETE` AFTER DELETE ON `EScPUxRAx` FOR EACH ROW
BEGIN
delete from `OML`.`EScPRAx`;
END$$

-- `OML`.`EltCRefTs`(x) iff `OML`.`EScPUxRAx`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`EScPUxRAx_AFTER_INSERT` AFTER INSERT ON `EScPUxRAx` FOR EACH ROW
BEGIN
insert into `OML`.`EltCRefTs`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`EScPUxRAx_AFTER_DELETE` AFTER DELETE ON `EScPUxRAx` FOR EACH ROW
BEGIN
delete from `OML`.`EltCRefTs`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`ScOneOfLitAx` (ScalarOneOfLiteralAxioms)
-- -----------------------------------------------------

-- `OML`.`TermAx`(x) iff `OML`.`ScOneOfLitAx`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`ScOneOfLitAx_AFTER_INSERT` AFTER INSERT ON `ScOneOfLitAx` FOR EACH ROW
BEGIN
insert into `OML`.`TermAx`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`ScOneOfLitAx_AFTER_DELETE` AFTER DELETE ON `ScOneOfLitAx` FOR EACH ROW
BEGIN
delete from `OML`.`TermAx`;
END$$

-- `OML`.`ValCRefTs`(x) iff `OML`.`ScOneOfLitAx`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`ScOneOfLitAx_AFTER_INSERT` AFTER INSERT ON `ScOneOfLitAx` FOR EACH ROW
BEGIN
insert into `OML`.`ValCRefTs`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`ScOneOfLitAx_AFTER_DELETE` AFTER DELETE ON `ScOneOfLitAx` FOR EACH ROW
BEGIN
delete from `OML`.`ValCRefTs`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`BdldTlgyAx` (BundledTerminologyAxioms)
-- -----------------------------------------------------

-- `OML`.`TlgyBdlAx`(x) iff `OML`.`BdldTlgyAx`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`BdldTlgyAx_AFTER_INSERT` AFTER INSERT ON `BdldTlgyAx` FOR EACH ROW
BEGIN
insert into `OML`.`TlgyBdlAx`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`BdldTlgyAx_AFTER_DELETE` AFTER DELETE ON `BdldTlgyAx` FOR EACH ROW
BEGIN
delete from `OML`.`TlgyBdlAx`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`RootCTaxonomyAx` (RootConceptTaxonomyAxioms)
-- -----------------------------------------------------

-- `OML`.`CTreeDsju`(x) iff `OML`.`RootCTaxonomyAx`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`RootCTaxonomyAx_AFTER_INSERT` AFTER INSERT ON `RootCTaxonomyAx` FOR EACH ROW
BEGIN
insert into `OML`.`CTreeDsju`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`RootCTaxonomyAx_AFTER_DELETE` AFTER DELETE ON `RootCTaxonomyAx` FOR EACH ROW
BEGIN
delete from `OML`.`CTreeDsju`;
END$$

-- `OML`.`TlgyBdlSt`(x) iff `OML`.`RootCTaxonomyAx`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`RootCTaxonomyAx_AFTER_INSERT` AFTER INSERT ON `RootCTaxonomyAx` FOR EACH ROW
BEGIN
insert into `OML`.`TlgyBdlSt`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`RootCTaxonomyAx_AFTER_DELETE` AFTER DELETE ON `RootCTaxonomyAx` FOR EACH ROW
BEGIN
delete from `OML`.`TlgyBdlSt`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`SpeDsjtCAx` (SpecificDisjointConceptAxioms)
-- -----------------------------------------------------

-- `OML`.`DsjUOfCsAx`(x) iff `OML`.`SpeDsjtCAx`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`SpeDsjtCAx_AFTER_INSERT` AFTER INSERT ON `SpeDsjtCAx` FOR EACH ROW
BEGIN
insert into `OML`.`DsjUOfCsAx`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`SpeDsjtCAx_AFTER_DELETE` AFTER DELETE ON `SpeDsjtCAx` FOR EACH ROW
BEGIN
delete from `OML`.`DsjUOfCsAx`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`AnnotPropVals` (AnnotationPropertyValues)
-- -----------------------------------------------------

-- `OML`.`NonLogEs`(x) iff `OML`.`AnnotPropVals`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`AnnotPropVals_AFTER_INSERT` AFTER INSERT ON `AnnotPropVals` FOR EACH ROW
BEGIN
insert into `OML`.`NonLogEs`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`AnnotPropVals_AFTER_DELETE` AFTER DELETE ON `AnnotPropVals` FOR EACH ROW
BEGIN
delete from `OML`.`NonLogEs`;
END$$

-- `OML`.`ValCRefTs`(x) iff `OML`.`AnnotPropVals`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`AnnotPropVals_AFTER_INSERT` AFTER INSERT ON `AnnotPropVals` FOR EACH ROW
BEGIN
insert into `OML`.`ValCRefTs`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`AnnotPropVals_AFTER_DELETE` AFTER DELETE ON `AnnotPropVals` FOR EACH ROW
BEGIN
delete from `OML`.`ValCRefTs`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`AnonymousCUnionAx` (AnonymousConceptUnionAxioms)
-- -----------------------------------------------------

-- `OML`.`CTreeDsju`(x) iff `OML`.`AnonymousCUnionAx`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`AnonymousCUnionAx_AFTER_INSERT` AFTER INSERT ON `AnonymousCUnionAx` FOR EACH ROW
BEGIN
insert into `OML`.`CTreeDsju`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`AnonymousCUnionAx_AFTER_DELETE` AFTER DELETE ON `AnonymousCUnionAx` FOR EACH ROW
BEGIN
delete from `OML`.`CTreeDsju`;
END$$

-- `OML`.`DsjUOfCsAx`(x) iff `OML`.`AnonymousCUnionAx`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`AnonymousCUnionAx_AFTER_INSERT` AFTER INSERT ON `AnonymousCUnionAx` FOR EACH ROW
BEGIN
insert into `OML`.`DsjUOfCsAx`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`AnonymousCUnionAx_AFTER_DELETE` AFTER DELETE ON `AnonymousCUnionAx` FOR EACH ROW
BEGIN
delete from `OML`.`DsjUOfCsAx`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`AspectP` (AspectPredicates)
-- -----------------------------------------------------

-- `OML`.`UrySegP`(x) iff `OML`.`AspectP`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`AspectP_AFTER_INSERT` AFTER INSERT ON `AspectP` FOR EACH ROW
BEGIN
insert into `OML`.`UrySegP`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`AspectP_AFTER_DELETE` AFTER DELETE ON `AspectP` FOR EACH ROW
BEGIN
delete from `OML`.`UrySegP`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`ChainRules` (ChainRules)
-- -----------------------------------------------------

-- `OML`.`Rules`(x) iff `OML`.`ChainRules`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`ChainRules_AFTER_INSERT` AFTER INSERT ON `ChainRules` FOR EACH ROW
BEGIN
insert into `OML`.`Rules`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`ChainRules_AFTER_DELETE` AFTER DELETE ON `ChainRules` FOR EACH ROW
BEGIN
delete from `OML`.`Rules`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`CIs` (ConceptInstances)
-- -----------------------------------------------------

-- `OML`.`CualESI`(x) iff `OML`.`CIs`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`CIs_AFTER_INSERT` AFTER INSERT ON `CIs` FOR EACH ROW
BEGIN
insert into `OML`.`CualESI`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`CIs_AFTER_DELETE` AFTER DELETE ON `CIs` FOR EACH ROW
BEGIN
delete from `OML`.`CualESI`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`CP` (ConceptPredicates)
-- -----------------------------------------------------

-- `OML`.`UrySegP`(x) iff `OML`.`CP`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`CP_AFTER_INSERT` AFTER INSERT ON `CP` FOR EACH ROW
BEGIN
insert into `OML`.`UrySegP`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`CP_AFTER_DELETE` AFTER DELETE ON `CP` FOR EACH ROW
BEGIN
delete from `OML`.`UrySegP`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`DBoxes` (DescriptionBoxes)
-- -----------------------------------------------------

-- `OML`.`Mods`(x) iff `OML`.`DBoxes`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`DBoxes_AFTER_INSERT` AFTER INSERT ON `DBoxes` FOR EACH ROW
BEGIN
insert into `OML`.`Mods`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`DBoxes_AFTER_DELETE` AFTER DELETE ON `DBoxes` FOR EACH ROW
BEGIN
delete from `OML`.`Mods`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`DBoxExtCWDef` (DescriptionBoxExtendsClosedWorldDefinitions)
-- -----------------------------------------------------

-- `OML`.`DBoxRels`(x) iff `OML`.`DBoxExtCWDef`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`DBoxExtCWDef_AFTER_INSERT` AFTER INSERT ON `DBoxExtCWDef` FOR EACH ROW
BEGIN
insert into `OML`.`DBoxRels`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`DBoxExtCWDef_AFTER_DELETE` AFTER DELETE ON `DBoxExtCWDef` FOR EACH ROW
BEGIN
delete from `OML`.`DBoxRels`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`DBoxRfns` (DescriptionBoxRefinements)
-- -----------------------------------------------------

-- `OML`.`DBoxRels`(x) iff `OML`.`DBoxRfns`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`DBoxRfns_AFTER_INSERT` AFTER INSERT ON `DBoxRfns` FOR EACH ROW
BEGIN
insert into `OML`.`DBoxRels`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`DBoxRfns_AFTER_DELETE` AFTER DELETE ON `DBoxRfns` FOR EACH ROW
BEGIN
delete from `OML`.`DBoxRels`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`EStPPtrRAx` (EntityStructuredDataPropertyParticularRestrictionAxioms)
-- -----------------------------------------------------

-- `OML`.`EStPRAx`(x) iff `OML`.`EStPPtrRAx`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`EStPPtrRAx_AFTER_INSERT` AFTER INSERT ON `EStPPtrRAx` FOR EACH ROW
BEGIN
insert into `OML`.`EStPRAx`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`EStPPtrRAx_AFTER_DELETE` AFTER DELETE ON `EStPPtrRAx` FOR EACH ROW
BEGIN
delete from `OML`.`EStPRAx`;
END$$

-- `OML`.`RStPCtxts`(x) iff `OML`.`EStPPtrRAx`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`EStPPtrRAx_AFTER_INSERT` AFTER INSERT ON `EStPPtrRAx` FOR EACH ROW
BEGIN
insert into `OML`.`RStPCtxts`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`EStPPtrRAx_AFTER_DELETE` AFTER DELETE ON `EStPPtrRAx` FOR EACH ROW
BEGIN
delete from `OML`.`RStPCtxts`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`RRIs` (ReifiedRelationshipInstances)
-- -----------------------------------------------------

-- `OML`.`CualESI`(x) iff `OML`.`RRIs`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`RRIs_AFTER_INSERT` AFTER INSERT ON `RRIs` FOR EACH ROW
BEGIN
insert into `OML`.`CualESI`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`RRIs_AFTER_DELETE` AFTER DELETE ON `RRIs` FOR EACH ROW
BEGIN
delete from `OML`.`CualESI`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`RRIDomains` (ReifiedRelationshipInstanceDomains)
-- -----------------------------------------------------

-- `OML`.`EltCRefTs`(x) iff `OML`.`RRIDomains`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`RRIDomains_AFTER_INSERT` AFTER INSERT ON `RRIDomains` FOR EACH ROW
BEGIN
insert into `OML`.`EltCRefTs`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`RRIDomains_AFTER_DELETE` AFTER DELETE ON `RRIDomains` FOR EACH ROW
BEGIN
delete from `OML`.`EltCRefTs`;
END$$

-- `OML`.`TlgyIAsts`(x) iff `OML`.`RRIDomains`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`RRIDomains_AFTER_INSERT` AFTER INSERT ON `RRIDomains` FOR EACH ROW
BEGIN
insert into `OML`.`TlgyIAsts`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`RRIDomains_AFTER_DELETE` AFTER DELETE ON `RRIDomains` FOR EACH ROW
BEGIN
delete from `OML`.`TlgyIAsts`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`RRIRanges` (ReifiedRelationshipInstanceRanges)
-- -----------------------------------------------------

-- `OML`.`EltCRefTs`(x) iff `OML`.`RRIRanges`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`RRIRanges_AFTER_INSERT` AFTER INSERT ON `RRIRanges` FOR EACH ROW
BEGIN
insert into `OML`.`EltCRefTs`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`RRIRanges_AFTER_DELETE` AFTER DELETE ON `RRIRanges` FOR EACH ROW
BEGIN
delete from `OML`.`EltCRefTs`;
END$$

-- `OML`.`TlgyIAsts`(x) iff `OML`.`RRIRanges`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`RRIRanges_AFTER_INSERT` AFTER INSERT ON `RRIRanges` FOR EACH ROW
BEGIN
insert into `OML`.`TlgyIAsts`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`RRIRanges_AFTER_DELETE` AFTER DELETE ON `RRIRanges` FOR EACH ROW
BEGIN
delete from `OML`.`TlgyIAsts`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`RRInvPropP` (ReifiedRelationshipInversePropertyPredicates)
-- -----------------------------------------------------

-- `OML`.`BinSegRevPropP`(x) iff `OML`.`RRInvPropP`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`RRInvPropP_AFTER_INSERT` AFTER INSERT ON `RRInvPropP` FOR EACH ROW
BEGIN
insert into `OML`.`BinSegRevPropP`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`RRInvPropP_AFTER_DELETE` AFTER DELETE ON `RRInvPropP` FOR EACH ROW
BEGIN
delete from `OML`.`BinSegRevPropP`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`RRP` (ReifiedRelationshipPredicates)
-- -----------------------------------------------------

-- `OML`.`UrySegP`(x) iff `OML`.`RRP`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`RRP_AFTER_INSERT` AFTER INSERT ON `RRP` FOR EACH ROW
BEGIN
insert into `OML`.`UrySegP`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`RRP_AFTER_DELETE` AFTER DELETE ON `RRP` FOR EACH ROW
BEGIN
delete from `OML`.`UrySegP`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`RRPropP` (ReifiedRelationshipPropertyPredicates)
-- -----------------------------------------------------

-- `OML`.`BinSegFwdPropP`(x) iff `OML`.`RRPropP`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`RRPropP_AFTER_INSERT` AFTER INSERT ON `RRPropP` FOR EACH ROW
BEGIN
insert into `OML`.`BinSegFwdPropP`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`RRPropP_AFTER_DELETE` AFTER DELETE ON `RRPropP` FOR EACH ROW
BEGIN
delete from `OML`.`BinSegFwdPropP`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`RRSrcInvPropP` (ReifiedRelationshipSourceInversePropertyPredicates)
-- -----------------------------------------------------

-- `OML`.`BinSegRevPropP`(x) iff `OML`.`RRSrcInvPropP`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`RRSrcInvPropP_AFTER_INSERT` AFTER INSERT ON `RRSrcInvPropP` FOR EACH ROW
BEGIN
insert into `OML`.`BinSegRevPropP`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`RRSrcInvPropP_AFTER_DELETE` AFTER DELETE ON `RRSrcInvPropP` FOR EACH ROW
BEGIN
delete from `OML`.`BinSegRevPropP`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`RRSrcPropP` (ReifiedRelationshipSourcePropertyPredicates)
-- -----------------------------------------------------

-- `OML`.`BinSegFwdPropP`(x) iff `OML`.`RRSrcPropP`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`RRSrcPropP_AFTER_INSERT` AFTER INSERT ON `RRSrcPropP` FOR EACH ROW
BEGIN
insert into `OML`.`BinSegFwdPropP`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`RRSrcPropP_AFTER_DELETE` AFTER DELETE ON `RRSrcPropP` FOR EACH ROW
BEGIN
delete from `OML`.`BinSegFwdPropP`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`RRTgtInvPropP` (ReifiedRelationshipTargetInversePropertyPredicates)
-- -----------------------------------------------------

-- `OML`.`BinSegRevPropP`(x) iff `OML`.`RRTgtInvPropP`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`RRTgtInvPropP_AFTER_INSERT` AFTER INSERT ON `RRTgtInvPropP` FOR EACH ROW
BEGIN
insert into `OML`.`BinSegRevPropP`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`RRTgtInvPropP_AFTER_DELETE` AFTER DELETE ON `RRTgtInvPropP` FOR EACH ROW
BEGIN
delete from `OML`.`BinSegRevPropP`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`RRTgtPropP` (ReifiedRelationshipTargetPropertyPredicates)
-- -----------------------------------------------------

-- `OML`.`BinSegFwdPropP`(x) iff `OML`.`RRTgtPropP`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`RRTgtPropP_AFTER_INSERT` AFTER INSERT ON `RRTgtPropP` FOR EACH ROW
BEGIN
insert into `OML`.`BinSegFwdPropP`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`RRTgtPropP_AFTER_DELETE` AFTER DELETE ON `RRTgtPropP` FOR EACH ROW
BEGIN
delete from `OML`.`BinSegFwdPropP`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`RScPVals` (RestrictionScalarDataPropertyValues)
-- -----------------------------------------------------

-- `OML`.`LogEs`(x) iff `OML`.`RScPVals`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`RScPVals_AFTER_INSERT` AFTER INSERT ON `RScPVals` FOR EACH ROW
BEGIN
insert into `OML`.`LogEs`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`RScPVals_AFTER_DELETE` AFTER DELETE ON `RScPVals` FOR EACH ROW
BEGIN
delete from `OML`.`LogEs`;
END$$

-- `OML`.`ValCRefTs`(x) iff `OML`.`RScPVals`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`RScPVals_AFTER_INSERT` AFTER INSERT ON `RScPVals` FOR EACH ROW
BEGIN
insert into `OML`.`ValCRefTs`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`RScPVals_AFTER_DELETE` AFTER DELETE ON `RScPVals` FOR EACH ROW
BEGIN
delete from `OML`.`ValCRefTs`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`RStPTs` (RestrictionStructuredDataPropertyTuples)
-- -----------------------------------------------------

-- `OML`.`RStPCtxts`(x) iff `OML`.`RStPTs`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`RStPTs_AFTER_INSERT` AFTER INSERT ON `RStPTs` FOR EACH ROW
BEGIN
insert into `OML`.`RStPCtxts`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`RStPTs_AFTER_DELETE` AFTER DELETE ON `RStPTs` FOR EACH ROW
BEGIN
delete from `OML`.`RStPCtxts`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`RuleBodySegs` (RuleBodySegments)
-- -----------------------------------------------------

-- `OML`.`EltCRefTs`(x) iff `OML`.`RuleBodySegs`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`RuleBodySegs_AFTER_INSERT` AFTER INSERT ON `RuleBodySegs` FOR EACH ROW
BEGIN
insert into `OML`.`EltCRefTs`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`RuleBodySegs_AFTER_DELETE` AFTER DELETE ON `RuleBodySegs` FOR EACH ROW
BEGIN
delete from `OML`.`EltCRefTs`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`ScPVals` (ScalarDataPropertyValues)
-- -----------------------------------------------------

-- `OML`.`LogEs`(x) iff `OML`.`ScPVals`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`ScPVals_AFTER_INSERT` AFTER INSERT ON `ScPVals` FOR EACH ROW
BEGIN
insert into `OML`.`LogEs`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`ScPVals_AFTER_DELETE` AFTER DELETE ON `ScPVals` FOR EACH ROW
BEGIN
delete from `OML`.`LogEs`;
END$$

-- `OML`.`ValCRefTs`(x) iff `OML`.`ScPVals`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`ScPVals_AFTER_INSERT` AFTER INSERT ON `ScPVals` FOR EACH ROW
BEGIN
insert into `OML`.`ValCRefTs`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`ScPVals_AFTER_DELETE` AFTER DELETE ON `ScPVals` FOR EACH ROW
BEGIN
delete from `OML`.`ValCRefTs`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`S1IScPVals` (SingletonInstanceScalarDataPropertyValues)
-- -----------------------------------------------------

-- `OML`.`ModElts`(x) iff `OML`.`S1IScPVals`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`S1IScPVals_AFTER_INSERT` AFTER INSERT ON `S1IScPVals` FOR EACH ROW
BEGIN
insert into `OML`.`ModElts`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`S1IScPVals_AFTER_DELETE` AFTER DELETE ON `S1IScPVals` FOR EACH ROW
BEGIN
delete from `OML`.`ModElts`;
END$$

-- `OML`.`ValCRefTs`(x) iff `OML`.`S1IScPVals`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`S1IScPVals_AFTER_INSERT` AFTER INSERT ON `S1IScPVals` FOR EACH ROW
BEGIN
insert into `OML`.`ValCRefTs`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`S1IScPVals_AFTER_DELETE` AFTER DELETE ON `S1IScPVals` FOR EACH ROW
BEGIN
delete from `OML`.`ValCRefTs`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`S1IStPVals` (SingletonInstanceStructuredDataPropertyValues)
-- -----------------------------------------------------

-- `OML`.`ModElts`(x) iff `OML`.`S1IStPVals`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`S1IStPVals_AFTER_INSERT` AFTER INSERT ON `S1IStPVals` FOR EACH ROW
BEGIN
insert into `OML`.`ModElts`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`S1IStPVals_AFTER_DELETE` AFTER DELETE ON `S1IStPVals` FOR EACH ROW
BEGIN
delete from `OML`.`ModElts`;
END$$

-- `OML`.`S1IStPCtxts`(x) iff `OML`.`S1IStPVals`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`S1IStPVals_AFTER_INSERT` AFTER INSERT ON `S1IStPVals` FOR EACH ROW
BEGIN
insert into `OML`.`S1IStPCtxts`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`S1IStPVals_AFTER_DELETE` AFTER DELETE ON `S1IStPVals` FOR EACH ROW
BEGIN
delete from `OML`.`S1IStPCtxts`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`StPTs` (StructuredDataPropertyTuples)
-- -----------------------------------------------------

-- `OML`.`S1IStPCtxts`(x) iff `OML`.`StPTs`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`StPTs_AFTER_INSERT` AFTER INSERT ON `StPTs` FOR EACH ROW
BEGIN
insert into `OML`.`S1IStPCtxts`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`StPTs_AFTER_DELETE` AFTER DELETE ON `StPTs` FOR EACH ROW
BEGIN
delete from `OML`.`S1IStPCtxts`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`SubDataPropOfAx` (SubDataPropertyOfAxioms)
-- -----------------------------------------------------

-- `OML`.`EltCRefTs`(x) iff `OML`.`SubDataPropOfAx`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`SubDataPropOfAx_AFTER_INSERT` AFTER INSERT ON `SubDataPropOfAx` FOR EACH ROW
BEGIN
insert into `OML`.`EltCRefTs`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`SubDataPropOfAx_AFTER_DELETE` AFTER DELETE ON `SubDataPropOfAx` FOR EACH ROW
BEGIN
delete from `OML`.`EltCRefTs`;
END$$

-- `OML`.`TermAx`(x) iff `OML`.`SubDataPropOfAx`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`SubDataPropOfAx_AFTER_INSERT` AFTER INSERT ON `SubDataPropOfAx` FOR EACH ROW
BEGIN
insert into `OML`.`TermAx`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`SubDataPropOfAx_AFTER_DELETE` AFTER DELETE ON `SubDataPropOfAx` FOR EACH ROW
BEGIN
delete from `OML`.`TermAx`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`SubObjectPropOfAx` (SubObjectPropertyOfAxioms)
-- -----------------------------------------------------

-- `OML`.`EltCRefTs`(x) iff `OML`.`SubObjectPropOfAx`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`SubObjectPropOfAx_AFTER_INSERT` AFTER INSERT ON `SubObjectPropOfAx` FOR EACH ROW
BEGIN
insert into `OML`.`EltCRefTs`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`SubObjectPropOfAx_AFTER_DELETE` AFTER DELETE ON `SubObjectPropOfAx` FOR EACH ROW
BEGIN
delete from `OML`.`EltCRefTs`;
END$$

-- `OML`.`TermAx`(x) iff `OML`.`SubObjectPropOfAx`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`SubObjectPropOfAx_AFTER_INSERT` AFTER INSERT ON `SubObjectPropOfAx` FOR EACH ROW
BEGIN
insert into `OML`.`TermAx`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`SubObjectPropOfAx_AFTER_DELETE` AFTER DELETE ON `SubObjectPropOfAx` FOR EACH ROW
BEGIN
delete from `OML`.`TermAx`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`URITs` (UnreifiedRelationshipInstanceTuples)
-- -----------------------------------------------------

-- `OML`.`EltCRefTs`(x) iff `OML`.`URITs`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`URITs_AFTER_INSERT` AFTER INSERT ON `URITs` FOR EACH ROW
BEGIN
insert into `OML`.`EltCRefTs`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`URITs_AFTER_DELETE` AFTER DELETE ON `URITs` FOR EACH ROW
BEGIN
delete from `OML`.`EltCRefTs`;
END$$

-- `OML`.`TlgyIAsts`(x) iff `OML`.`URITs`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`URITs_AFTER_INSERT` AFTER INSERT ON `URITs` FOR EACH ROW
BEGIN
insert into `OML`.`TlgyIAsts`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`URITs_AFTER_DELETE` AFTER DELETE ON `URITs` FOR EACH ROW
BEGIN
delete from `OML`.`TlgyIAsts`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`URInvPropP` (UnreifiedRelationshipInversePropertyPredicates)
-- -----------------------------------------------------

-- `OML`.`BinSegRevPropP`(x) iff `OML`.`URInvPropP`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`URInvPropP_AFTER_INSERT` AFTER INSERT ON `URInvPropP` FOR EACH ROW
BEGIN
insert into `OML`.`BinSegRevPropP`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`URInvPropP_AFTER_DELETE` AFTER DELETE ON `URInvPropP` FOR EACH ROW
BEGIN
delete from `OML`.`BinSegRevPropP`;
END$$

-- -----------------------------------------------------
-- Concrete Information Table `OML`.`URPropP` (UnreifiedRelationshipPropertyPredicates)
-- -----------------------------------------------------

-- `OML`.`BinSegFwdPropP`(x) iff `OML`.`URPropP`(x)
DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`URPropP_AFTER_INSERT` AFTER INSERT ON `URPropP` FOR EACH ROW
BEGIN
insert into `OML`.`BinSegFwdPropP`() value (uuid);
END$$

DELIMITER $$
USE `OML`$$
CREATE DEFINER = CURRENT_USER TRIGGER `OML`.`URPropP_AFTER_DELETE` AFTER DELETE ON `URPropP` FOR EACH ROW
BEGIN
delete from `OML`.`BinSegFwdPropP`;
END$$


DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
