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

 
  CREATE TABLE IF NOT EXISTS `OML`.`AnnotationProperties` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `iri`        TEXT,
        
      `abbrevIRI`        TEXT
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`TerminologyGraphs` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `kind`        TEXT,
        
      `iri`        TEXT
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`Bundles` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `kind`        TEXT,
        
      `iri`        TEXT
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`ConceptDesignationTerminologyAxioms` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `tboxUUID`        BINARY(16) NOT NULL,
        
      `designatedConceptUUID`        BINARY(16) NOT NULL,
        
      `designatedTerminologyIRI`        VARCHAR(256) NOT NULL
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`TerminologyExtensionAxioms` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `tboxUUID`        BINARY(16) NOT NULL,
        
      `extendedTerminologyIRI`        VARCHAR(256) NOT NULL
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`TerminologyNestingAxioms` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `tboxUUID`        BINARY(16) NOT NULL,
        
      `nestingContextUUID`        BINARY(16) NOT NULL,
        
      `nestingTerminologyIRI`        VARCHAR(256) NOT NULL
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`Aspects` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `tboxUUID`        BINARY(16) NOT NULL,
        
      `name`        TEXT
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`Concepts` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `tboxUUID`        BINARY(16) NOT NULL,
        
      `name`        TEXT
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`ReifiedRelationships` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `tboxUUID`        BINARY(16) NOT NULL,
        
      `sourceUUID`        BINARY(16) NOT NULL,
        
      `targetUUID`        BINARY(16) NOT NULL,
        
      `isAsymmetric`        TEXT,
        
      `isEssential`        TEXT,
        
      `isFunctional`        TEXT,
        
      `isInverseEssential`        TEXT,
        
      `isInverseFunctional`        TEXT,
        
      `isIrreflexive`        TEXT,
        
      `isReflexive`        TEXT,
        
      `isSymmetric`        TEXT,
        
      `isTransitive`        TEXT,
        
      `name`        TEXT,
        
      `unreifiedPropertyName`        TEXT,
        
      `unreifiedInversePropertyName`        TEXT
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`UnreifiedRelationships` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `tboxUUID`        BINARY(16) NOT NULL,
        
      `sourceUUID`        BINARY(16) NOT NULL,
        
      `targetUUID`        BINARY(16) NOT NULL,
        
      `isAsymmetric`        TEXT,
        
      `isEssential`        TEXT,
        
      `isFunctional`        TEXT,
        
      `isInverseEssential`        TEXT,
        
      `isInverseFunctional`        TEXT,
        
      `isIrreflexive`        TEXT,
        
      `isReflexive`        TEXT,
        
      `isSymmetric`        TEXT,
        
      `isTransitive`        TEXT,
        
      `name`        TEXT
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`Scalars` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `tboxUUID`        BINARY(16) NOT NULL,
        
      `name`        TEXT
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`Structures` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `tboxUUID`        BINARY(16) NOT NULL,
        
      `name`        TEXT
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`BinaryScalarRestrictions` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `tboxUUID`        BINARY(16) NOT NULL,
        
      `restrictedRangeUUID`        BINARY(16) NOT NULL,
        
      `length`        TEXT,
        
      `minLength`        TEXT,
        
      `maxLength`        TEXT,
        
      `name`        TEXT
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`IRIScalarRestrictions` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `tboxUUID`        BINARY(16) NOT NULL,
        
      `restrictedRangeUUID`        BINARY(16) NOT NULL,
        
      `length`        TEXT,
        
      `minLength`        TEXT,
        
      `maxLength`        TEXT,
        
      `name`        TEXT,
        
      `pattern`        TEXT
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`NumericScalarRestrictions` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `tboxUUID`        BINARY(16) NOT NULL,
        
      `restrictedRangeUUID`        BINARY(16) NOT NULL,
        
      `minExclusive`        -- TODO: LiteralFeature
      TEXT, `LiteralType` VARCHAR(20) NOT NULL,,
        
      `minInclusive`        -- TODO: LiteralFeature
      TEXT, `LiteralType` VARCHAR(20) NOT NULL,,
        
      `maxExclusive`        -- TODO: LiteralFeature
      TEXT, `LiteralType` VARCHAR(20) NOT NULL,,
        
      `maxInclusive`        -- TODO: LiteralFeature
      TEXT, `LiteralType` VARCHAR(20) NOT NULL,,
        
      `name`        TEXT
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`PlainLiteralScalarRestrictions` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `tboxUUID`        BINARY(16) NOT NULL,
        
      `restrictedRangeUUID`        BINARY(16) NOT NULL,
        
      `length`        TEXT,
        
      `minLength`        TEXT,
        
      `maxLength`        TEXT,
        
      `name`        TEXT,
        
      `langRange`        TEXT,
        
      `pattern`        TEXT
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`ScalarOneOfRestrictions` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `tboxUUID`        BINARY(16) NOT NULL,
        
      `restrictedRangeUUID`        BINARY(16) NOT NULL,
        
      `name`        TEXT
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`StringScalarRestrictions` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `tboxUUID`        BINARY(16) NOT NULL,
        
      `restrictedRangeUUID`        BINARY(16) NOT NULL,
        
      `length`        TEXT,
        
      `minLength`        TEXT,
        
      `maxLength`        TEXT,
        
      `name`        TEXT,
        
      `pattern`        TEXT
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`SynonymScalarRestrictions` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `tboxUUID`        BINARY(16) NOT NULL,
        
      `restrictedRangeUUID`        BINARY(16) NOT NULL,
        
      `name`        TEXT
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`TimeScalarRestrictions` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `tboxUUID`        BINARY(16) NOT NULL,
        
      `restrictedRangeUUID`        BINARY(16) NOT NULL,
        
      `minExclusive`        -- TODO: LiteralFeature
      TEXT, `LiteralType` VARCHAR(20) NOT NULL,,
        
      `minInclusive`        -- TODO: LiteralFeature
      TEXT, `LiteralType` VARCHAR(20) NOT NULL,,
        
      `maxExclusive`        -- TODO: LiteralFeature
      TEXT, `LiteralType` VARCHAR(20) NOT NULL,,
        
      `maxInclusive`        -- TODO: LiteralFeature
      TEXT, `LiteralType` VARCHAR(20) NOT NULL,,
        
      `name`        TEXT
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`EntityScalarDataProperties` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `tboxUUID`        BINARY(16) NOT NULL,
        
      `domainUUID`        BINARY(16) NOT NULL,
        
      `rangeUUID`        BINARY(16) NOT NULL,
        
      `isIdentityCriteria`        TEXT,
        
      `name`        TEXT
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`EntityStructuredDataProperties` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `tboxUUID`        BINARY(16) NOT NULL,
        
      `domainUUID`        BINARY(16) NOT NULL,
        
      `rangeUUID`        BINARY(16) NOT NULL,
        
      `isIdentityCriteria`        TEXT,
        
      `name`        TEXT
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`ScalarDataProperties` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `tboxUUID`        BINARY(16) NOT NULL,
        
      `domainUUID`        BINARY(16) NOT NULL,
        
      `rangeUUID`        BINARY(16) NOT NULL,
        
      `name`        TEXT
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`StructuredDataProperties` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `tboxUUID`        BINARY(16) NOT NULL,
        
      `domainUUID`        BINARY(16) NOT NULL,
        
      `rangeUUID`        BINARY(16) NOT NULL,
        
      `name`        TEXT
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`AspectSpecializationAxioms` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `tboxUUID`        BINARY(16) NOT NULL,
        
      `superAspectUUID`        BINARY(16) NOT NULL,
        
      `subEntityUUID`        BINARY(16) NOT NULL
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`ConceptSpecializationAxioms` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `tboxUUID`        BINARY(16) NOT NULL,
        
      `superConceptUUID`        BINARY(16) NOT NULL,
        
      `subConceptUUID`        BINARY(16) NOT NULL
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`ReifiedRelationshipSpecializationAxioms` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `tboxUUID`        BINARY(16) NOT NULL,
        
      `superRelationshipUUID`        BINARY(16) NOT NULL,
        
      `subRelationshipUUID`        BINARY(16) NOT NULL
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`EntityExistentialRestrictionAxioms` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `tboxUUID`        BINARY(16) NOT NULL,
        
      `restrictedRelationUUID`        BINARY(16) NOT NULL,
        
      `restrictedDomainUUID`        BINARY(16) NOT NULL,
        
      `restrictedRangeUUID`        BINARY(16) NOT NULL
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`EntityUniversalRestrictionAxioms` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `tboxUUID`        BINARY(16) NOT NULL,
        
      `restrictedRelationUUID`        BINARY(16) NOT NULL,
        
      `restrictedDomainUUID`        BINARY(16) NOT NULL,
        
      `restrictedRangeUUID`        BINARY(16) NOT NULL
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`EntityScalarDataPropertyExistentialRestrictionAxioms` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `tboxUUID`        BINARY(16) NOT NULL,
        
      `restrictedEntityUUID`        BINARY(16) NOT NULL,
        
      `scalarPropertyUUID`        BINARY(16) NOT NULL,
        
      `scalarRestrictionUUID`        BINARY(16) NOT NULL
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`EntityScalarDataPropertyParticularRestrictionAxioms` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `tboxUUID`        BINARY(16) NOT NULL,
        
      `restrictedEntityUUID`        BINARY(16) NOT NULL,
        
      `scalarPropertyUUID`        BINARY(16) NOT NULL,
        
      `literalValue`        -- TODO: LiteralFeature
      TEXT, `LiteralType` VARCHAR(20) NOT NULL,,
        
      `valueTypeUUID`        BINARY(16) NULL
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`EntityScalarDataPropertyUniversalRestrictionAxioms` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `tboxUUID`        BINARY(16) NOT NULL,
        
      `restrictedEntityUUID`        BINARY(16) NOT NULL,
        
      `scalarPropertyUUID`        BINARY(16) NOT NULL,
        
      `scalarRestrictionUUID`        BINARY(16) NOT NULL
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`ScalarOneOfLiteralAxioms` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `tboxUUID`        BINARY(16) NOT NULL,
        
      `axiomUUID`        BINARY(16) NOT NULL,
        
      `value`        -- TODO: LiteralFeature
      TEXT, `LiteralType` VARCHAR(20) NOT NULL,,
        
      `valueTypeUUID`        BINARY(16) NULL
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`BundledTerminologyAxioms` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `bundleUUID`        BINARY(16) NOT NULL,
        
      `bundledTerminologyIRI`        VARCHAR(256) NOT NULL
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`RootConceptTaxonomyAxioms` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `bundleUUID`        BINARY(16) NOT NULL,
        
      `rootUUID`        BINARY(16) NOT NULL
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`SpecificDisjointConceptAxioms` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `disjointTaxonomyParentUUID`        BINARY(16) NOT NULL,
        
      `disjointLeafUUID`        BINARY(16) NOT NULL
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`AnnotationPropertyValues` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `subjectUUID`        BINARY(16) NOT NULL,
        
      `propertyUUID`        BINARY(16) NOT NULL,
        
      `value`        -- TODO: LiteralFeature
      TEXT, `LiteralType` VARCHAR(20) NOT NULL,
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`AnonymousConceptUnionAxioms` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `disjointTaxonomyParentUUID`        BINARY(16) NOT NULL,
        
      `name`        TEXT
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`AspectPredicates` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `aspectUUID`        BINARY(16) NOT NULL,
        
      `bodySegmentUUID`        BINARY(16) NOT NULL
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`ChainRules` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `tboxUUID`        BINARY(16) NOT NULL,
        
      `name`        TEXT,
        
      `headUUID`        BINARY(16) NOT NULL
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`ConceptInstances` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `descriptionBoxUUID`        BINARY(16) NOT NULL,
        
      `singletonConceptClassifierUUID`        BINARY(16) NOT NULL,
        
      `name`        TEXT
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`ConceptPredicates` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `bodySegmentUUID`        BINARY(16) NOT NULL,
        
      `conceptUUID`        BINARY(16) NOT NULL
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`DescriptionBoxes` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `kind`        TEXT,
        
      `iri`        TEXT
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`DescriptionBoxExtendsClosedWorldDefinitions` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `descriptionBoxUUID`        BINARY(16) NOT NULL,
        
      `closedWorldDefinitionsIRI`        VARCHAR(256) NOT NULL
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`DescriptionBoxRefinements` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `refiningDescriptionBoxUUID`        BINARY(16) NOT NULL,
        
      `refinedDescriptionBoxIRI`        VARCHAR(256) NOT NULL
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`EntityStructuredDataPropertyParticularRestrictionAxioms` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `tboxUUID`        BINARY(16) NOT NULL,
        
      `structuredDataPropertyUUID`        BINARY(16) NOT NULL,
        
      `restrictedEntityUUID`        BINARY(16) NOT NULL
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`ReifiedRelationshipInstances` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `descriptionBoxUUID`        BINARY(16) NOT NULL,
        
      `singletonReifiedRelationshipClassifierUUID`        BINARY(16) NOT NULL,
        
      `name`        TEXT
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`ReifiedRelationshipInstanceDomains` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `descriptionBoxUUID`        BINARY(16) NOT NULL,
        
      `reifiedRelationshipInstanceUUID`        BINARY(16) NOT NULL,
        
      `domainUUID`        BINARY(16) NOT NULL
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`ReifiedRelationshipInstanceRanges` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `descriptionBoxUUID`        BINARY(16) NOT NULL,
        
      `reifiedRelationshipInstanceUUID`        BINARY(16) NOT NULL,
        
      `rangeUUID`        BINARY(16) NOT NULL
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`ReifiedRelationshipInversePropertyPredicates` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `bodySegmentUUID`        BINARY(16) NOT NULL,
        
      `reifiedRelationshipUUID`        BINARY(16) NOT NULL
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`ReifiedRelationshipPredicates` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `bodySegmentUUID`        BINARY(16) NOT NULL,
        
      `reifiedRelationshipUUID`        BINARY(16) NOT NULL
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`ReifiedRelationshipPropertyPredicates` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `bodySegmentUUID`        BINARY(16) NOT NULL,
        
      `reifiedRelationshipUUID`        BINARY(16) NOT NULL
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`ReifiedRelationshipSourceInversePropertyPredicates` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `bodySegmentUUID`        BINARY(16) NOT NULL,
        
      `reifiedRelationshipUUID`        BINARY(16) NOT NULL
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`ReifiedRelationshipSourcePropertyPredicates` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `bodySegmentUUID`        BINARY(16) NOT NULL,
        
      `reifiedRelationshipUUID`        BINARY(16) NOT NULL
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`ReifiedRelationshipTargetInversePropertyPredicates` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `bodySegmentUUID`        BINARY(16) NOT NULL,
        
      `reifiedRelationshipUUID`        BINARY(16) NOT NULL
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`ReifiedRelationshipTargetPropertyPredicates` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `bodySegmentUUID`        BINARY(16) NOT NULL,
        
      `reifiedRelationshipUUID`        BINARY(16) NOT NULL
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`RestrictionScalarDataPropertyValues` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `scalarDataPropertyUUID`        BINARY(16) NOT NULL,
        
      `scalarPropertyValue`        -- TODO: LiteralFeature
      TEXT, `LiteralType` VARCHAR(20) NOT NULL,,
        
      `structuredDataPropertyContextUUID`        BINARY(16) NOT NULL,
        
      `valueTypeUUID`        BINARY(16) NULL
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`RestrictionStructuredDataPropertyTuples` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `structuredDataPropertyUUID`        BINARY(16) NOT NULL,
        
      `structuredDataPropertyContextUUID`        BINARY(16) NOT NULL
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`RuleBodySegments` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `previousSegmentUUID`        BINARY(16) NULL,
        
      `ruleUUID`        BINARY(16) NULL
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`ScalarDataPropertyValues` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `scalarDataPropertyUUID`        BINARY(16) NOT NULL,
        
      `scalarPropertyValue`        -- TODO: LiteralFeature
      TEXT, `LiteralType` VARCHAR(20) NOT NULL,,
        
      `structuredDataPropertyContextUUID`        BINARY(16) NOT NULL,
        
      `valueTypeUUID`        BINARY(16) NULL
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`SingletonInstanceScalarDataPropertyValues` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `descriptionBoxUUID`        BINARY(16) NOT NULL,
        
      `singletonInstanceUUID`        BINARY(16) NOT NULL,
        
      `scalarDataPropertyUUID`        BINARY(16) NOT NULL,
        
      `scalarPropertyValue`        -- TODO: LiteralFeature
      TEXT, `LiteralType` VARCHAR(20) NOT NULL,,
        
      `valueTypeUUID`        BINARY(16) NULL
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`SingletonInstanceStructuredDataPropertyValues` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `descriptionBoxUUID`        BINARY(16) NOT NULL,
        
      `singletonInstanceUUID`        BINARY(16) NOT NULL,
        
      `structuredDataPropertyUUID`        BINARY(16) NOT NULL
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`StructuredDataPropertyTuples` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `structuredDataPropertyUUID`        BINARY(16) NOT NULL,
        
      `structuredDataPropertyContextUUID`        BINARY(16) NOT NULL
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`SubDataPropertyOfAxioms` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `tboxUUID`        BINARY(16) NOT NULL,
        
      `subPropertyUUID`        BINARY(16) NOT NULL,
        
      `superPropertyUUID`        BINARY(16) NOT NULL
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`SubObjectPropertyOfAxioms` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `tboxUUID`        BINARY(16) NOT NULL,
        
      `subPropertyUUID`        BINARY(16) NOT NULL,
        
      `superPropertyUUID`        BINARY(16) NOT NULL
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`UnreifiedRelationshipInstanceTuples` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `descriptionBoxUUID`        BINARY(16) NOT NULL,
        
      `unreifiedRelationshipUUID`        BINARY(16) NOT NULL,
        
      `domainUUID`        BINARY(16) NOT NULL,
        
      `rangeUUID`        BINARY(16) NOT NULL
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`UnreifiedRelationshipInversePropertyPredicates` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `unreifiedRelationshipUUID`        BINARY(16) NOT NULL,
        
      `bodySegmentUUID`        BINARY(16) NOT NULL
  )
  
  CREATE TABLE IF NOT EXISTS `OML`.`UnreifiedRelationshipPropertyPredicates` (
      `uuid`  BINARY(16) NOT NULL PRIMARY KEY,
        
      `unreifiedRelationshipUUID`        BINARY(16) NOT NULL,
        
      `bodySegmentUUID`        BINARY(16) NOT NULL
  )
  
  		  

