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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Logical Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML Element is a logical abstraction
 * for everything involved in OML that
 * is globally identified by a version 5 namespace UUID deterministically
 * derived from essential information about the OML Element.
 * An OML Element can be the subject of multiple OML AnnotationPropertyValues;
 * however, there can be at most one OML AnnotationPropertyValue for a given
 * pair of OML Element and OML AnnotationProperty.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.common.LogicalElement#getAnnotations <em>Annotations</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.common.CommonPackage#getLogicalElement()
 * @model abstract="true"
 * @generated
 */
public interface LogicalElement extends IdentityKind {
	/**
	 * Returns the value of the '<em><b>Annotations</b></em>' containment reference list.
	 * The list contents are of type {@link gov.nasa.jpl.imce.oml.model.common.AnnotationPropertyValue}.
	 * It is bidirectional and its opposite is '{@link gov.nasa.jpl.imce.oml.model.common.AnnotationPropertyValue#getSubject <em>Subject</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotations</em>' containment reference list.
	 * @see gov.nasa.jpl.imce.oml.model.common.CommonPackage#getLogicalElement_Annotations()
	 * @see gov.nasa.jpl.imce.oml.model.common.AnnotationPropertyValue#getSubject
	 * @model opposite="subject" containment="true"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Collection kind='Seq'"
	 * @generated
	 */
	EList<AnnotationPropertyValue> getAnnotations();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 * @generated
	 */
	gov.nasa.jpl.imce.oml.model.common.Module moduleContext();

} // LogicalElement
