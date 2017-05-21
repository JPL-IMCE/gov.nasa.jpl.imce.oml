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
 * A representation of the model object '<em><b>Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML Module maps to an [OWL2-DL Ontology];
 * it is a kind of OML Resource that is a logical container of OML ModuleElement(s)
 * and a non-logical container of OML Annotation(s).
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.common.Module#getExtent <em>Extent</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.common.Module#getIri <em>Iri</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.common.Module#getAnnotations <em>Annotations</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.common.CommonPackage#getModule()
 * @model abstract="true"
 *        annotation="http://imce.jpl.nasa.gov/oml/NamespaceUUID namespace='iri' factors=''"
 * @generated
 */
public interface Module extends Element, Resource {
	/**
	 * Returns the value of the '<em><b>Extent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link gov.nasa.jpl.imce.oml.model.common.Extent#getModules <em>Modules</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extent</em>' container reference.
	 * @see #setExtent(Extent)
	 * @see gov.nasa.jpl.imce.oml.model.common.CommonPackage#getModule_Extent()
	 * @see gov.nasa.jpl.imce.oml.model.common.Extent#getModules
	 * @model opposite="modules" required="true" transient="false"
	 * @generated
	 */
	Extent getExtent();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.common.Module#getExtent <em>Extent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extent</em>' container reference.
	 * @see #getExtent()
	 * @generated
	 */
	void setExtent(Extent value);

	/**
	 * Returns the value of the '<em><b>Iri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iri</em>' attribute.
	 * @see #setIri(String)
	 * @see gov.nasa.jpl.imce.oml.model.common.CommonPackage#getModule_Iri()
	 * @model unique="false" id="true" dataType="gov.nasa.jpl.imce.oml.model.common.IRI" required="true"
	 * @generated
	 */
	String getIri();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.common.Module#getIri <em>Iri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Iri</em>' attribute.
	 * @see #getIri()
	 * @generated
	 */
	void setIri(String value);

	/**
	 * Returns the value of the '<em><b>Annotations</b></em>' containment reference list.
	 * The list contents are of type {@link gov.nasa.jpl.imce.oml.model.common.Annotation}.
	 * It is bidirectional and its opposite is '{@link gov.nasa.jpl.imce.oml.model.common.Annotation#getModule <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotations</em>' containment reference list.
	 * @see gov.nasa.jpl.imce.oml.model.common.CommonPackage#getModule_Annotations()
	 * @see gov.nasa.jpl.imce.oml.model.common.Annotation#getModule
	 * @model opposite="module" containment="true"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Collection kind='Set'"
	 * @generated
	 */
	EList<Annotation> getAnnotations();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Collection kind='Set'"
	 * @generated
	 */
	EList<ModuleEdge> moduleEdges();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="gov.nasa.jpl.imce.oml.model.common.IRI" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getIri();'"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Scala code='scala.Some(iri)'"
	 * @generated
	 */
	String iri();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="gov.nasa.jpl.imce.oml.model.common.NamespacePrefix" unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%java.lang.String%> _iri = this.getIri();\n<%java.lang.String%> _substring = null;\nif (_iri!=null)\n{\n\tint _lastIndexOf = this.getIri().lastIndexOf(\"/\");\n\tint _plus = (1 + _lastIndexOf);\n\t_substring=_iri.substring(_plus);\n}\nreturn _substring;'"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Scala code='iri.substring(1+iri.lastIndexOf(\'/\'))'"
	 * @generated
	 */
	String nsPrefix();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="gov.nasa.jpl.imce.oml.model.common.LocalName" unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.nsPrefix();'"
	 * @generated
	 */
	String name();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.nsPrefix();'"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Scala code='scala.Some(nsPrefix)'"
	 * @generated
	 */
	String abbrevIRI();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="gov.nasa.jpl.imce.oml.model.common.UUID" unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%java.lang.String%> _elvis = null;\n<%java.lang.String%> _iri = this.iri();\nif (_iri != null)\n{\n\t_elvis = _iri;\n} else\n{\n\t_elvis = \"\";\n}\n<%java.util.UUID%> _namespaceUUID = <%gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions%>.namespaceUUID(_elvis);\n<%java.lang.String%> _string = null;\nif (_namespaceUUID!=null)\n{\n\t_string=_namespaceUUID.toString();\n}\nreturn _string;'"
	 * @generated
	 */
	String uuid();

} // Module
