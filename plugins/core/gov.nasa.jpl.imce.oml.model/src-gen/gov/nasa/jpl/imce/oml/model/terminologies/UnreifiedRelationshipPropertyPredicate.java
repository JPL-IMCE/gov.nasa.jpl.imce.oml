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
 * A representation of the model object '<em><b>Unreified Relationship Property Predicate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML UnreifiedRelationshipPropertyPredicate wraps a reference
 * to an OML UnreifiedReifiedRelationship as a binary predicate for an OML ChainRule.
 * This binary predicate is satisfied when the pair of its implicit variables are bound as follows:
 * - the first variable is bound to an instance suitable for the domain of the OML UnreifiedRelationship;
 * - the second variable is bound to an instance suitable for the range of the OML UnreifiedRelationship.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationshipPropertyPredicate#getUnreifiedRelationship <em>Unreified Relationship</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getUnreifiedRelationshipPropertyPredicate()
 * @model
 * @generated
 */
public interface UnreifiedRelationshipPropertyPredicate extends BinarySegmentForwardPropertyPredicate {
	/**
	 * Returns the value of the '<em><b>Unreified Relationship</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unreified Relationship</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unreified Relationship</em>' reference.
	 * @see #setUnreifiedRelationship(UnreifiedRelationship)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getUnreifiedRelationshipPropertyPredicate_UnreifiedRelationship()
	 * @model required="true"
	 * @generated
	 */
	UnreifiedRelationship getUnreifiedRelationship();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationshipPropertyPredicate#getUnreifiedRelationship <em>Unreified Relationship</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unreified Relationship</em>' reference.
	 * @see #getUnreifiedRelationship()
	 * @generated
	 */
	void setUnreifiedRelationship(UnreifiedRelationship value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getUnreifiedRelationship();'"
	 * @generated
	 */
	Term termPredicate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="gov.nasa.jpl.imce.oml.model.common.UUID" unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationship%&gt; _unreifiedRelationship = this.getUnreifiedRelationship();\n&lt;%java.lang.String%&gt; _uuid = null;\nif (_unreifiedRelationship!=null)\n{\n\t_uuid=_unreifiedRelationship.uuid();\n}\n&lt;%java.lang.String%&gt; _string = null;\nif (_uuid!=null)\n{\n\t_string=_uuid.toString();\n}\n&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _mappedTo = &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;of(\"unreifiedRelationship\", _string);\n&lt;%gov.nasa.jpl.imce.oml.model.terminologies.RuleBodySegment%&gt; _bodySegment = this.getBodySegment();\n&lt;%java.lang.String%&gt; _uuid_1 = null;\nif (_bodySegment!=null)\n{\n\t_uuid_1=_bodySegment.uuid();\n}\n&lt;%java.lang.String%&gt; _string_1 = null;\nif (_uuid_1!=null)\n{\n\t_string_1=_uuid_1.toString();\n}\n&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _mappedTo_1 = &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;of(\"bodySegment\", _string_1);\n&lt;%java.util.UUID%&gt; _derivedUUID = &lt;%gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions%&gt;.derivedUUID(\n\t\"UnreifiedRelationshipPropertyPredicate\", _mappedTo, _mappedTo_1);\n&lt;%java.lang.String%&gt; _string_2 = null;\nif (_derivedUUID!=null)\n{\n\t_string_2=_derivedUUID.toString();\n}\nreturn _string_2;'"
	 * @generated
	 */
	String uuid();

} // UnreifiedRelationshipPropertyPredicate
