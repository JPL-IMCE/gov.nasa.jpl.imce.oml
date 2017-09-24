/**
 * 
 * Copyright 2017 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package gov.nasa.jpl.imce.oml.model.terminologies;

import org.eclipse.emf.cdo.CDOObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conceptual Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML ConceptualEntity is an OML Entity that can be instantiated
 * as an OML ConceptualEntitySingletonInstance in any OML DescriptionBox.
 * It is partially instantiated if some essential OML EntityRelationship
 * or OML DataRelationshipFromEntity with `isIdentityCriteria=true` lacks
 * an OML TerminologyInstanceAssertion specifying its reference or value respectively.
 * <!-- end-model-doc -->
 *
 *
 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getConceptualEntity()
 * @model abstract="true"
 * @extends CDOObject
 * @generated
 */
public interface ConceptualEntity extends CDOObject {
} // ConceptualEntity
