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
 * A representation of the model object '<em><b>Reified Relationship Specialization Axiom</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML ReifiedRelationshipSpecializationAxiom is a logical axiom
 * about a taxonomic relationship between a specific and general
 * OML ConceptualRelationship.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipSpecializationAxiom#getSubRelationship <em>Sub Relationship</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipSpecializationAxiom#getSuperRelationship <em>Super Relationship</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getReifiedRelationshipSpecializationAxiom()
 * @model
 * @generated
 */
public interface ReifiedRelationshipSpecializationAxiom extends SpecializationAxiom {
	/**
	 * Returns the value of the '<em><b>Sub Relationship</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The sub (child) relationship
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Sub Relationship</em>' reference.
	 * @see #setSubRelationship(ConceptualRelationship)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getReifiedRelationshipSpecializationAxiom_SubRelationship()
	 * @model required="true"
	 * @generated
	 */
	ConceptualRelationship getSubRelationship();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipSpecializationAxiom#getSubRelationship <em>Sub Relationship</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub Relationship</em>' reference.
	 * @see #getSubRelationship()
	 * @generated
	 */
	void setSubRelationship(ConceptualRelationship value);

	/**
	 * Returns the value of the '<em><b>Super Relationship</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The super (parent) relationship
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Super Relationship</em>' reference.
	 * @see #setSuperRelationship(ConceptualRelationship)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getReifiedRelationshipSpecializationAxiom_SuperRelationship()
	 * @model required="true"
	 * @generated
	 */
	ConceptualRelationship getSuperRelationship();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipSpecializationAxiom#getSuperRelationship <em>Super Relationship</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super Relationship</em>' reference.
	 * @see #getSuperRelationship()
	 * @generated
	 */
	void setSuperRelationship(ConceptualRelationship value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Get the sub (child) entity
	 * <!-- end-model-doc -->
	 * @model unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getSubRelationship();'"
	 * @generated
	 */
	Entity child();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Get the super (parent) entity
	 * <!-- end-model-doc -->
	 * @model unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getSuperRelationship();'"
	 * @generated
	 */
	Entity parent();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="gov.nasa.jpl.imce.oml.model.common.UUID" unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox%&gt; _tbox = this.getTbox();\n&lt;%java.lang.String%&gt; _uuid = null;\nif (_tbox!=null)\n{\n\t_uuid=_tbox.uuid();\n}\n&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _mappedTo = &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;of(\"tbox\", _uuid);\n&lt;%gov.nasa.jpl.imce.oml.model.terminologies.ConceptualRelationship%&gt; _superRelationship = this.getSuperRelationship();\n&lt;%java.lang.String%&gt; _uuid_1 = null;\nif (_superRelationship!=null)\n{\n\t_uuid_1=_superRelationship.uuid();\n}\n&lt;%java.lang.String%&gt; _string = null;\nif (_uuid_1!=null)\n{\n\t_string=_uuid_1.toString();\n}\n&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _mappedTo_1 = &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;of(\"superRelationship\", _string);\n&lt;%gov.nasa.jpl.imce.oml.model.terminologies.ConceptualRelationship%&gt; _subRelationship = this.getSubRelationship();\n&lt;%java.lang.String%&gt; _uuid_2 = null;\nif (_subRelationship!=null)\n{\n\t_uuid_2=_subRelationship.uuid();\n}\n&lt;%java.lang.String%&gt; _string_1 = null;\nif (_uuid_2!=null)\n{\n\t_string_1=_uuid_2.toString();\n}\n&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _mappedTo_2 = &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;of(\"subRelationship\", _string_1);\n&lt;%java.util.UUID%&gt; _derivedUUID = &lt;%gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions%&gt;.derivedUUID(\n\t\"ReifiedRelationshipSpecializationAxiom\", _mappedTo, _mappedTo_1, _mappedTo_2);\n&lt;%java.lang.String%&gt; _string_2 = null;\nif (_derivedUUID!=null)\n{\n\t_string_2=_derivedUUID.toString();\n}\nreturn _string_2;'"
	 * @generated
	 */
	String uuid();

} // ReifiedRelationshipSpecializationAxiom
