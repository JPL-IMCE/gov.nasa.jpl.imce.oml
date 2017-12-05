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
package gov.nasa.jpl.imce.oml.model.common;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Intrinsic Identity Kind</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML IntrinsicIdentityKind is an abstraction for a kind of OML IdentityKind
 * where identity stems from a single intrinsic criteria: a globally unique IRI.
 * 
 * An OML IntrinsicIdentityKind is also an OML CrossReferencableKind
 * where the cross reference is logically the primary key uuid.
 * <!-- end-model-doc -->
 *
 *
 * @see gov.nasa.jpl.imce.oml.model.common.CommonPackage#getIntrinsicIdentityKind()
 * @model abstract="true"
 * @generated
 */
public interface IntrinsicIdentityKind extends IdentityKind, CrossReferencableKind {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="gov.nasa.jpl.imce.oml.model.common.IRI" unique="false"
	 * @generated
	 */
	String iri();

} // IntrinsicIdentityKind
