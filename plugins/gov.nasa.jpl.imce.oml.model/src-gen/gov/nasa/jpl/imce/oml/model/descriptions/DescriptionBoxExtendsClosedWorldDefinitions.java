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
package gov.nasa.jpl.imce.oml.model.descriptions;

import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Description Box Extends Closed World Definitions</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML DescriptionBoxExtendsClosedWorldDefinition specifies
 * an OML DescriptionBoxRelationship from an OML DescriptionBox
 * to an OML TerminologyBox such that an OML SingletonInstance defined in the
 * former can be an instance of an OML Term defined in the latter.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxExtendsClosedWorldDefinitions#getDescriptionBox <em>Description Box</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxExtendsClosedWorldDefinitions#getClosedWorldDefinitions <em>Closed World Definitions</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage#getDescriptionBoxExtendsClosedWorldDefinitions()
 * @model
 * @generated
 */
public interface DescriptionBoxExtendsClosedWorldDefinitions extends DescriptionBoxRelationship {
	/**
	 * Returns the value of the '<em><b>Description Box</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox#getClosedWorldDefinitions <em>Closed World Definitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description Box</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description Box</em>' container reference.
	 * @see #setDescriptionBox(DescriptionBox)
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage#getDescriptionBoxExtendsClosedWorldDefinitions_DescriptionBox()
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox#getClosedWorldDefinitions
	 * @model opposite="closedWorldDefinitions" required="true" transient="false"
	 * @generated
	 */
	DescriptionBox getDescriptionBox();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxExtendsClosedWorldDefinitions#getDescriptionBox <em>Description Box</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description Box</em>' container reference.
	 * @see #getDescriptionBox()
	 * @generated
	 */
	void setDescriptionBox(DescriptionBox value);

	/**
	 * Returns the value of the '<em><b>Closed World Definitions</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Closed World Definitions</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Closed World Definitions</em>' reference.
	 * @see #setClosedWorldDefinitions(TerminologyBox)
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage#getDescriptionBoxExtendsClosedWorldDefinitions_ClosedWorldDefinitions()
	 * @model required="true"
	 * @generated
	 */
	TerminologyBox getClosedWorldDefinitions();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxExtendsClosedWorldDefinitions#getClosedWorldDefinitions <em>Closed World Definitions</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Closed World Definitions</em>' reference.
	 * @see #getClosedWorldDefinitions()
	 * @generated
	 */
	void setClosedWorldDefinitions(TerminologyBox value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Scala code='extent.descriptionBoxOfDescriptionBoxExtendsClosedWorldDefinitions.get(this)'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getDescriptionBox();'"
	 * @generated
	 */
	DescriptionBox descriptionDomain();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getClosedWorldDefinitions();'"
	 * @generated
	 */
	gov.nasa.jpl.imce.oml.model.common.Module targetModule();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="gov.nasa.jpl.imce.oml.model.common.UUID" unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox%&gt; _descriptionBox = this.getDescriptionBox();\n&lt;%java.lang.String%&gt; _uuid = null;\nif (_descriptionBox!=null)\n{\n\t_uuid=_descriptionBox.uuid();\n}\n&lt;%java.lang.String%&gt; _string = null;\nif (_uuid!=null)\n{\n\t_string=_uuid.toString();\n}\n&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _mappedTo = &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;of(\"descriptionBox\", _string);\n&lt;%gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox%&gt; _closedWorldDefinitions = this.getClosedWorldDefinitions();\n&lt;%java.lang.String%&gt; _uuid_1 = null;\nif (_closedWorldDefinitions!=null)\n{\n\t_uuid_1=_closedWorldDefinitions.uuid();\n}\n&lt;%java.lang.String%&gt; _string_1 = null;\nif (_uuid_1!=null)\n{\n\t_string_1=_uuid_1.toString();\n}\n&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _mappedTo_1 = &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;of(\"closedWorldDefinitions\", _string_1);\n&lt;%java.util.UUID%&gt; _derivedUUID = &lt;%gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions%&gt;.derivedUUID(\n\t\"DescriptionBoxExtendsClosedWorldDefinitions\", _mappedTo, _mappedTo_1);\n&lt;%java.lang.String%&gt; _string_2 = null;\nif (_derivedUUID!=null)\n{\n\t_string_2=_derivedUUID.toString();\n}\nreturn _string_2;'"
	 * @generated
	 */
	String uuid();

} // DescriptionBoxExtendsClosedWorldDefinitions
