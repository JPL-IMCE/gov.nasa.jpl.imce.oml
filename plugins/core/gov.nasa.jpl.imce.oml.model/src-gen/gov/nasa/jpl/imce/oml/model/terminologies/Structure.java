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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Structure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML Structure would correspond to an OWL2 Declaration of an [OWL2 DataRange] with arity > 1.
 * However, since OWL2 Datatypes in the [OWL2-DL] are restricted to have arity=1,
 * the OML mapping to [OWL2-DL] involves a pattern-based usage of an [OWL2 Class] to represent an OML Structure.
 * The arity corresponds to the cardinality of the set of ScalarDataProperty & StructuredDataProperty
 * relationships whose domain is this structure.
 * <!-- end-model-doc -->
 *
 *
 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getStructure()
 * @model
 * @generated
 */
public interface Structure extends Datatype, UnaryTermKind {
} // Structure
