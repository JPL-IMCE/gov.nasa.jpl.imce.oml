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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity Structured Data Property Particular Restriction Axiom</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * An OML EntityStructuredDataPropertyParticularRestrictionAxiom maps to an OWL2 ObjectHasValue restriction.
 * <!-- end-model-doc -->
 *
 *
 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getEntityStructuredDataPropertyParticularRestrictionAxiom()
 * @model
 * @generated
 */
public interface EntityStructuredDataPropertyParticularRestrictionAxiom extends EntityStructuredDataPropertyRestrictionAxiom, RestrictionStructuredDataPropertyContext {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getTbox();'"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Scala code='extent.terminologyBoxOfTerminologyBoxStatement.get(this)'"
	 * @generated
	 */
	TerminologyBox terminologyBox();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="gov.nasa.jpl.imce.oml.model.common.UUID" unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox%> _tbox = this.getTbox();\n<%java.lang.String%> _uuid = null;\nif (_tbox!=null)\n{\n\t_uuid=_tbox.uuid();\n}\n<%org.eclipse.xtext.xbase.lib.Pair%><<%java.lang.String%>, <%java.lang.String%>> _mappedTo = <%org.eclipse.xtext.xbase.lib.Pair%>.<<%java.lang.String%>, <%java.lang.String%>>of(\"tbox\", _uuid);\n<%gov.nasa.jpl.imce.oml.model.terminologies.Entity%> _restrictedEntity = this.getRestrictedEntity();\n<%java.lang.String%> _uuid_1 = null;\nif (_restrictedEntity!=null)\n{\n\t_uuid_1=_restrictedEntity.uuid();\n}\n<%java.lang.String%> _string = null;\nif (_uuid_1!=null)\n{\n\t_string=_uuid_1.toString();\n}\n<%org.eclipse.xtext.xbase.lib.Pair%><<%java.lang.String%>, <%java.lang.String%>> _mappedTo_1 = <%org.eclipse.xtext.xbase.lib.Pair%>.<<%java.lang.String%>, <%java.lang.String%>>of(\"restrictedEntity\", _string);\n<%gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipToStructure%> _structuredDataProperty = this.getStructuredDataProperty();\n<%java.lang.String%> _uuid_2 = null;\nif (_structuredDataProperty!=null)\n{\n\t_uuid_2=_structuredDataProperty.uuid();\n}\n<%java.lang.String%> _string_1 = null;\nif (_uuid_2!=null)\n{\n\t_string_1=_uuid_2.toString();\n}\n<%org.eclipse.xtext.xbase.lib.Pair%><<%java.lang.String%>, <%java.lang.String%>> _mappedTo_2 = <%org.eclipse.xtext.xbase.lib.Pair%>.<<%java.lang.String%>, <%java.lang.String%>>of(\"structuredDataProperty\", _string_1);\n<%java.util.UUID%> _derivedUUID = <%gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions%>.derivedUUID(\n\t\"EntityStructuredDataPropertyParticularRestrictionAxiom\", _mappedTo, _mappedTo_1, _mappedTo_2);\n<%java.lang.String%> _string_2 = null;\nif (_derivedUUID!=null)\n{\n\t_string_2=_derivedUUID.toString();\n}\nreturn _string_2;'"
	 * @generated
	 */
	String uuid();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.allNestedRestrictionElements();'"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Collection kind='Set'"
	 * @generated
	 */
	EList<Element> allNestedElements();

} // EntityStructuredDataPropertyParticularRestrictionAxiom
