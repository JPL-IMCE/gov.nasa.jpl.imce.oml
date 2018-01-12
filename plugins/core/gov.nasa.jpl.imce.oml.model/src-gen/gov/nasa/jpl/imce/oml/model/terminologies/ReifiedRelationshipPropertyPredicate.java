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
 * A representation of the model object '<em><b>Reified Relationship Property Predicate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML ReifiedRelationshipPropertyPredicate wraps a reference
 * to an OML ReifiedRelationship as a binary predicate for an OML ChainRule.
 * This binary predicate is satisfied when the pair of its implicit variables are bound as follows:
 * - the first variable is bound to an instance suitable for the domain of the OML ReifiedRelationship;
 * - the second variable is bound to an instance suitable for the range of the OML ReifiedRelationship;
 * - there must be an instance of the OML ReifiedRelationship relating the first variable (domain) to the second variable (range).
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipPropertyPredicate#getForwardProperty <em>Forward Property</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getReifiedRelationshipPropertyPredicate()
 * @model
 * @generated
 */
public interface ReifiedRelationshipPropertyPredicate extends BinarySegmentForwardPropertyPredicate {
	/**
	 * Returns the value of the '<em><b>Forward Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Forward Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Forward Property</em>' reference.
	 * @see #setForwardProperty(ForwardProperty)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getReifiedRelationshipPropertyPredicate_ForwardProperty()
	 * @model required="true"
	 * @generated
	 */
	ForwardProperty getForwardProperty();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipPropertyPredicate#getForwardProperty <em>Forward Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Forward Property</em>' reference.
	 * @see #getForwardProperty()
	 * @generated
	 */
	void setForwardProperty(ForwardProperty value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%gov.nasa.jpl.imce.oml.model.terminologies.ForwardProperty%&gt; _forwardProperty = this.getForwardProperty();\n&lt;%gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship%&gt; _reifiedRelationship = null;\nif (_forwardProperty!=null)\n{\n\t_reifiedRelationship=_forwardProperty.getReifiedRelationship();\n}\nreturn _reifiedRelationship;'"
	 * @generated
	 */
	Term termPredicate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="gov.nasa.jpl.imce.oml.model.common.UUID" unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%gov.nasa.jpl.imce.oml.model.terminologies.RuleBodySegment%&gt; _bodySegment = this.getBodySegment();\n&lt;%java.lang.String%&gt; _uuid = null;\nif (_bodySegment!=null)\n{\n\t_uuid=_bodySegment.uuid();\n}\n&lt;%java.lang.String%&gt; _string = null;\nif (_uuid!=null)\n{\n\t_string=_uuid.toString();\n}\n&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _mappedTo = &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;of(\"bodySegment\", _string);\n&lt;%gov.nasa.jpl.imce.oml.model.terminologies.ForwardProperty%&gt; _forwardProperty = this.getForwardProperty();\n&lt;%java.lang.String%&gt; _uuid_1 = null;\nif (_forwardProperty!=null)\n{\n\t_uuid_1=_forwardProperty.uuid();\n}\n&lt;%java.lang.String%&gt; _string_1 = null;\nif (_uuid_1!=null)\n{\n\t_string_1=_uuid_1.toString();\n}\n&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _mappedTo_1 = &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;of(\"forwardProperty\", _string_1);\n&lt;%java.util.UUID%&gt; _derivedUUID = &lt;%gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions%&gt;.derivedUUID(\n\t\"ReifiedRelationshipPropertyPredicate\", _mappedTo, _mappedTo_1);\n&lt;%java.lang.String%&gt; _string_2 = null;\nif (_derivedUUID!=null)\n{\n\t_string_2=_derivedUUID.toString();\n}\nreturn _string_2;'"
	 * @generated
	 */
	String uuid();

} // ReifiedRelationshipPropertyPredicate
