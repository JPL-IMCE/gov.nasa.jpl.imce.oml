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
package gov.nasa.jpl.imce.oml.model.graphs;

import gov.nasa.jpl.imce.oml.model.terminologies.Concept;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBoxAxiom;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Terminology Nesting Axiom</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML TerminologyNestingAxiom provides support for relating
 * a white-box nested OML TerminologyGraph used for describing internal
 * details about a nesting OML Concept defined in a nesting OML TerminologyBox.
 * This nesting OML Concept specifies the context for the internal details
 * defined in the nested OML TerminologyGraph.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.graphs.TerminologyNestingAxiom#getNestingTerminology <em>Nesting Terminology</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.graphs.TerminologyNestingAxiom#getNestingContext <em>Nesting Context</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.graphs.GraphsPackage#getTerminologyNestingAxiom()
 * @model
 * @generated
 */
public interface TerminologyNestingAxiom extends TerminologyBoxAxiom {
	/**
	 * Returns the value of the '<em><b>Nesting Terminology</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nesting Terminology</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nesting Terminology</em>' reference.
	 * @see #setNestingTerminology(TerminologyBox)
	 * @see gov.nasa.jpl.imce.oml.model.graphs.GraphsPackage#getTerminologyNestingAxiom_NestingTerminology()
	 * @model required="true"
	 * @generated
	 */
	TerminologyBox getNestingTerminology();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.graphs.TerminologyNestingAxiom#getNestingTerminology <em>Nesting Terminology</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nesting Terminology</em>' reference.
	 * @see #getNestingTerminology()
	 * @generated
	 */
	void setNestingTerminology(TerminologyBox value);

	/**
	 * Returns the value of the '<em><b>Nesting Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nesting Context</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nesting Context</em>' reference.
	 * @see #setNestingContext(Concept)
	 * @see gov.nasa.jpl.imce.oml.model.graphs.GraphsPackage#getTerminologyNestingAxiom_NestingContext()
	 * @model required="true"
	 * @generated
	 */
	Concept getNestingContext();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.graphs.TerminologyNestingAxiom#getNestingContext <em>Nesting Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nesting Context</em>' reference.
	 * @see #getNestingContext()
	 * @generated
	 */
	void setNestingContext(Concept value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%gov.nasa.jpl.imce.oml.model.graphs.TerminologyGraph%> _switchResult = null;\n<%gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox%> _tbox = this.getTbox();\nboolean _matched = false;\nif (_tbox instanceof <%gov.nasa.jpl.imce.oml.model.graphs.TerminologyGraph%>)\n{\n\t_matched=true;\n\t_switchResult = <%gov.nasa.jpl.imce.oml.model.graphs.TerminologyGraph%>.class.cast(this.getTbox());\n}\nif (!_matched)\n{\n\t_switchResult = null;\n}\nreturn _switchResult;'"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Scala code='extent.terminologyBoxOfTerminologyBoxAxiom.get(this) match {\n      case scala.Some(g: resolver.api.TerminologyGraph) => scala.Some(g)\n      case _ => scala.None\n    }'"
	 * @generated
	 */
	TerminologyGraph nestedTerminology();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The nestedTerminology is the source
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.nestedTerminology();'"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Scala code='nestedTerminology()'"
	 * @generated
	 */
	TerminologyBox source();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The nestingTerminology is the target
	 * <!-- end-model-doc -->
	 * @model unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getNestingTerminology();'"
	 * @generated
	 */
	TerminologyBox target();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="gov.nasa.jpl.imce.oml.model.common.UUID" unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%java.lang.String%> _string = this.getTbox().uuid().toString();\n<%org.eclipse.xtext.xbase.lib.Pair%><<%java.lang.String%>, <%java.lang.String%>> _mappedTo = <%org.eclipse.xtext.xbase.lib.Pair%>.<<%java.lang.String%>, <%java.lang.String%>>of(\"tbox\", _string);\n<%gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox%> _nestingTerminology = this.getNestingTerminology();\n<%java.lang.String%> _uuid = null;\nif (_nestingTerminology!=null)\n{\n\t_uuid=_nestingTerminology.uuid();\n}\n<%java.lang.String%> _string_1 = null;\nif (_uuid!=null)\n{\n\t_string_1=_uuid.toString();\n}\n<%org.eclipse.xtext.xbase.lib.Pair%><<%java.lang.String%>, <%java.lang.String%>> _mappedTo_1 = <%org.eclipse.xtext.xbase.lib.Pair%>.<<%java.lang.String%>, <%java.lang.String%>>of(\"nestingTerminology\", _string_1);\n<%gov.nasa.jpl.imce.oml.model.terminologies.Concept%> _nestingContext = this.getNestingContext();\n<%java.lang.String%> _uuid_1 = null;\nif (_nestingContext!=null)\n{\n\t_uuid_1=_nestingContext.uuid();\n}\n<%java.lang.String%> _string_2 = null;\nif (_uuid_1!=null)\n{\n\t_string_2=_uuid_1.toString();\n}\n<%org.eclipse.xtext.xbase.lib.Pair%><<%java.lang.String%>, <%java.lang.String%>> _mappedTo_2 = <%org.eclipse.xtext.xbase.lib.Pair%>.<<%java.lang.String%>, <%java.lang.String%>>of(\"nestingContext\", _string_2);\n<%java.util.UUID%> _derivedUUID = <%gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions%>.derivedUUID(\n\t\"TerminologyNestingAxiom\", _mappedTo, _mappedTo_1, _mappedTo_2);\n<%java.lang.String%> _string_3 = null;\nif (_derivedUUID!=null)\n{\n\t_string_3=_derivedUUID.toString();\n}\nreturn _string_3;'"
	 * @generated
	 */
	String uuid();

} // TerminologyNestingAxiom
