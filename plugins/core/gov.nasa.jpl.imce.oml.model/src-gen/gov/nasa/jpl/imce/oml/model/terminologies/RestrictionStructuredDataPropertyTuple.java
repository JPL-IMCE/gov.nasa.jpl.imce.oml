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
import gov.nasa.jpl.imce.oml.model.common.Module;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Restriction Structured Data Property Tuple</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML RestrictionStructuredDataPropertyTuple is an OML RestrictionStructuredDataPropertyContext
 * nested in a container OML RestrictionStructuredDataPropertyContext.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyTuple#getStructuredDataPropertyContext <em>Structured Data Property Context</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getRestrictionStructuredDataPropertyTuple()
 * @model
 * @generated
 */
public interface RestrictionStructuredDataPropertyTuple extends RestrictionStructuredDataPropertyContext {
	/**
	 * Returns the value of the '<em><b>Structured Data Property Context</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyContext#getStructuredDataPropertyRestrictions <em>Structured Data Property Restrictions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Structured Data Property Context</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Structured Data Property Context</em>' container reference.
	 * @see #setStructuredDataPropertyContext(RestrictionStructuredDataPropertyContext)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getRestrictionStructuredDataPropertyTuple_StructuredDataPropertyContext()
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyContext#getStructuredDataPropertyRestrictions
	 * @model opposite="structuredDataPropertyRestrictions" required="true" transient="false"
	 * @generated
	 */
	RestrictionStructuredDataPropertyContext getStructuredDataPropertyContext();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyTuple#getStructuredDataPropertyContext <em>Structured Data Property Context</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Structured Data Property Context</em>' container reference.
	 * @see #getStructuredDataPropertyContext()
	 * @generated
	 */
	void setStructuredDataPropertyContext(RestrictionStructuredDataPropertyContext value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyContext%> _structuredDataPropertyContext = this.getStructuredDataPropertyContext();\n<%gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox%> _terminologyBox = null;\nif (_structuredDataPropertyContext!=null)\n{\n\t_terminologyBox=_structuredDataPropertyContext.terminologyBox();\n}\nreturn _terminologyBox;'"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Scala code='extent.restrictionStructuredDataPropertyContextOfRestrictionStructuredDataPropertyTuple.get(this).flatMap(_.terminologyBox())'"
	 * @generated
	 */
	TerminologyBox terminologyBox();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="gov.nasa.jpl.imce.oml.model.common.UUID" unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyContext%> _structuredDataPropertyContext = this.getStructuredDataPropertyContext();\n<%java.lang.String%> _uuid = null;\nif (_structuredDataPropertyContext!=null)\n{\n\t_uuid=_structuredDataPropertyContext.uuid();\n}\n<%java.lang.String%> _string = null;\nif (_uuid!=null)\n{\n\t_string=_uuid.toString();\n}\n<%org.eclipse.xtext.xbase.lib.Pair%><<%java.lang.String%>, <%java.lang.String%>> _mappedTo = <%org.eclipse.xtext.xbase.lib.Pair%>.<<%java.lang.String%>, <%java.lang.String%>>of(\"structuredDataPropertyContext\", _string);\n<%gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipToStructure%> _structuredDataProperty = this.getStructuredDataProperty();\n<%java.lang.String%> _uuid_1 = null;\nif (_structuredDataProperty!=null)\n{\n\t_uuid_1=_structuredDataProperty.uuid();\n}\n<%java.lang.String%> _string_1 = null;\nif (_uuid_1!=null)\n{\n\t_string_1=_uuid_1.toString();\n}\n<%org.eclipse.xtext.xbase.lib.Pair%><<%java.lang.String%>, <%java.lang.String%>> _mappedTo_1 = <%org.eclipse.xtext.xbase.lib.Pair%>.<<%java.lang.String%>, <%java.lang.String%>>of(\"structuredDataProperty\", _string_1);\n<%java.util.UUID%> _derivedUUID = <%gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions%>.derivedUUID(\n\t\"RestrictionStructuredDataPropertyTuple\", _mappedTo, _mappedTo_1);\n<%java.lang.String%> _string_2 = null;\nif (_derivedUUID!=null)\n{\n\t_string_2=_derivedUUID.toString();\n}\nreturn _string_2;'"
	 * @generated
	 */
	String uuid();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyContext%> _structuredDataPropertyContext = this.getStructuredDataPropertyContext();\n<%gov.nasa.jpl.imce.oml.model.common.Module%> _moduleContext = null;\nif (_structuredDataPropertyContext!=null)\n{\n\t_moduleContext=_structuredDataPropertyContext.moduleContext();\n}\nreturn _moduleContext;'"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Scala code='extent.restrictionStructuredDataPropertyContextOfRestrictionStructuredDataPropertyTuple.get(this).flatMap(_.moduleContext)'"
	 * @generated
	 */
	Module moduleContext();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.allNestedRestrictionElements();'"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Collection kind='Set'"
	 * @generated
	 */
	EList<Element> allNestedElements();

} // RestrictionStructuredDataPropertyTuple
