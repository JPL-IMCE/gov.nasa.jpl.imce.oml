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
 * A representation of the model object '<em><b>Value Cross Reference Tuple</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML ValueCrossReferenceTuple is an abstraction for a kind of OML ExtrinsicIdentityKind
 * where the extrinsic identity criteria is precisely the combination
 * of a tuple of at least 2 cross references to other OML CrossReferencableKind(s),
 * at least one scalar value typed by an OML DataRange and nothing else.
 * Note that the identity of an OML DataRange value is itself.
 * <!-- end-model-doc -->
 *
 *
 * @see gov.nasa.jpl.imce.oml.model.common.CommonPackage#getValueCrossReferenceTuple()
 * @model abstract="true"
 * @generated
 */
public interface ValueCrossReferenceTuple extends ExtrinsicIdentityKind, NonCrossReferencableKind {
} // ValueCrossReferenceTuple
