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

import gov.nasa.jpl.imce.oml.model.common.Element;
import gov.nasa.jpl.imce.oml.model.common.ModuleElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Restriction Structured Data Property Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML RestrictionStructuredDataPropertyContext defines the context of
 * an OML DataRelationshipToStructure for an OML Entity restriction for specifying
 * values of the OML DataRelationshipFromStructure properties
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyContext#getStructuredDataProperty <em>Structured Data Property</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyContext#getStructuredDataPropertyRestrictions <em>Structured Data Property Restrictions</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyContext#getScalarDataPropertyRestrictions <em>Scalar Data Property Restrictions</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getRestrictionStructuredDataPropertyContext()
 * @model abstract="true"
 * @generated
 */
public interface RestrictionStructuredDataPropertyContext extends ModuleElement {
	/**
	 * Returns the value of the '<em><b>Structured Data Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Structured Data Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Structured Data Property</em>' reference.
	 * @see #setStructuredDataProperty(DataRelationshipToStructure)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getRestrictionStructuredDataPropertyContext_StructuredDataProperty()
	 * @model required="true"
	 * @generated
	 */
	DataRelationshipToStructure getStructuredDataProperty();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyContext#getStructuredDataProperty <em>Structured Data Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Structured Data Property</em>' reference.
	 * @see #getStructuredDataProperty()
	 * @generated
	 */
	void setStructuredDataProperty(DataRelationshipToStructure value);

	/**
	 * Returns the value of the '<em><b>Structured Data Property Restrictions</b></em>' containment reference list.
	 * The list contents are of type {@link gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyTuple}.
	 * It is bidirectional and its opposite is '{@link gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyTuple#getStructuredDataPropertyContext <em>Structured Data Property Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Structured Data Property Restrictions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Structured Data Property Restrictions</em>' containment reference list.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getRestrictionStructuredDataPropertyContext_StructuredDataPropertyRestrictions()
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyTuple#getStructuredDataPropertyContext
	 * @model opposite="structuredDataPropertyContext" containment="true"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Collection kind='Set'"
	 * @generated
	 */
	EList<RestrictionStructuredDataPropertyTuple> getStructuredDataPropertyRestrictions();

	/**
	 * Returns the value of the '<em><b>Scalar Data Property Restrictions</b></em>' containment reference list.
	 * The list contents are of type {@link gov.nasa.jpl.imce.oml.model.terminologies.RestrictionScalarDataPropertyValue}.
	 * It is bidirectional and its opposite is '{@link gov.nasa.jpl.imce.oml.model.terminologies.RestrictionScalarDataPropertyValue#getStructuredDataPropertyContext <em>Structured Data Property Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scalar Data Property Restrictions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scalar Data Property Restrictions</em>' containment reference list.
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getRestrictionStructuredDataPropertyContext_ScalarDataPropertyRestrictions()
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.RestrictionScalarDataPropertyValue#getStructuredDataPropertyContext
	 * @model opposite="structuredDataPropertyContext" containment="true"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Collection kind='Set'"
	 * @generated
	 */
	EList<RestrictionScalarDataPropertyValue> getScalarDataPropertyRestrictions();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 * @generated
	 */
	TerminologyBox terminologyBox();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%org.eclipse.emf.common.util.BasicEList%&gt;&lt;&lt;%gov.nasa.jpl.imce.oml.model.common.Element%&gt;&gt; _xblockexpression = null;\n{\n\tfinal &lt;%org.eclipse.emf.common.util.BasicEList%&gt;&lt;&lt;%gov.nasa.jpl.imce.oml.model.common.Element%&gt;&gt; nres = new &lt;%org.eclipse.emf.common.util.BasicEList%&gt;&lt;&lt;%gov.nasa.jpl.imce.oml.model.common.Element%&gt;&gt;();\n\tnres.addAll(this.getStructuredDataPropertyRestrictions());\n\tfinal &lt;%java.util.function.Consumer%&gt;&lt;&lt;%gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyTuple%&gt;&gt; _function = new &lt;%java.util.function.Consumer%&gt;&lt;&lt;%gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyTuple%&gt;&gt;()\n\t{\n\t\tpublic void accept(final &lt;%gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyTuple%&gt; it)\n\t\t{\n\t\t\tnres.addAll(it.allNestedRestrictionElements());\n\t\t}\n\t};\n\tthis.getStructuredDataPropertyRestrictions().forEach(_function);\n\tnres.addAll(this.getScalarDataPropertyRestrictions());\n\t_xblockexpression = nres;\n}\nreturn _xblockexpression;'"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Scala code='extent.lookupStructuredDataPropertyRestrictions(this).flatMap{ r =&gt; scala.collection.immutable.Set.empty[resolver.api.Element] + r ++ r.allNestedRestrictionElements() } ++\n\t\textent.lookupScalarDataPropertyRestrictions(this)'"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Collection kind='Set'"
	 * @generated
	 */
	EList<Element> allNestedRestrictionElements();

} // RestrictionStructuredDataPropertyContext
