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
import gov.nasa.jpl.imce.oml.model.common.LiteralValue;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scalar One Of Literal Axiom</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML ScalarOneOfLiteralAxiom specifies a literal in a ScalarOneOfRestriction data range.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfLiteralAxiom#getAxiom <em>Axiom</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfLiteralAxiom#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getScalarOneOfLiteralAxiom()
 * @model
 * @generated
 */
public interface ScalarOneOfLiteralAxiom extends TermAxiom {
	/**
	 * Returns the value of the '<em><b>Axiom</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Axiom</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Axiom</em>' reference.
	 * @see #setAxiom(ScalarOneOfRestriction)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getScalarOneOfLiteralAxiom_Axiom()
	 * @model required="true"
	 * @generated
	 */
	ScalarOneOfRestriction getAxiom();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfLiteralAxiom#getAxiom <em>Axiom</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Axiom</em>' reference.
	 * @see #getAxiom()
	 * @generated
	 */
	void setAxiom(ScalarOneOfRestriction value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The value of the literal from the restrictedScalar datatype
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(LiteralValue)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getScalarOneOfLiteralAxiom_Value()
	 * @model containment="true" required="true"
	 * @generated
	 */
	LiteralValue getValue();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfLiteralAxiom#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(LiteralValue value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="gov.nasa.jpl.imce.oml.model.common.UUID" unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox%> _tbox = this.getTbox();\n<%java.lang.String%> _uuid = null;\nif (_tbox!=null)\n{\n\t_uuid=_tbox.uuid();\n}\n<%java.lang.String%> _string = null;\nif (_uuid!=null)\n{\n\t_string=_uuid.toString();\n}\n<%org.eclipse.xtext.xbase.lib.Pair%><<%java.lang.String%>, <%java.lang.String%>> _mappedTo = <%org.eclipse.xtext.xbase.lib.Pair%>.<<%java.lang.String%>, <%java.lang.String%>>of(\"tbox\", _string);\n<%gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfRestriction%> _axiom = this.getAxiom();\n<%java.lang.String%> _uuid_1 = null;\nif (_axiom!=null)\n{\n\t_uuid_1=_axiom.uuid();\n}\n<%java.lang.String%> _string_1 = null;\nif (_uuid_1!=null)\n{\n\t_string_1=_uuid_1.toString();\n}\n<%org.eclipse.xtext.xbase.lib.Pair%><<%java.lang.String%>, <%java.lang.String%>> _mappedTo_1 = <%org.eclipse.xtext.xbase.lib.Pair%>.<<%java.lang.String%>, <%java.lang.String%>>of(\"axiom\", _string_1);\n<%java.util.UUID%> _derivedUUID = <%gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions%>.derivedUUID(\n\t\"ScalarOneOfLiteralAxiom\", _mappedTo, _mappedTo_1);\n<%java.lang.String%> _string_2 = null;\nif (_derivedUUID!=null)\n{\n\t_string_2=_derivedUUID.toString();\n}\nreturn _string_2;'"
	 * @generated
	 */
	String uuid();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return <%org.eclipse.emf.common.util.ECollections%>.<<%gov.nasa.jpl.imce.oml.model.common.Element%>>emptyEList();'"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Scala code='scala.collection.immutable.Set.empty[resolver.api.Element]'"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Collection kind='Set'"
	 * @generated
	 */
	EList<Element> allNestedElements();

} // ScalarOneOfLiteralAxiom
