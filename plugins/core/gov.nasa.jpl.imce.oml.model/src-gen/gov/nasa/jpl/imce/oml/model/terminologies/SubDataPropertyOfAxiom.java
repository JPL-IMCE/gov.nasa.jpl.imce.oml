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

import gov.nasa.jpl.imce.oml.model.common.ElementCrossReferenceTuple;
import gov.nasa.jpl.imce.oml.model.common.LogicalElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sub Data Property Of Axiom</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML SubDataPropertyOfAxiom is a logical axiom
 * about a taxonomic relationship between a specific and general
 * OML EntityScalarDataProperty.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.SubDataPropertyOfAxiom#getSubProperty <em>Sub Property</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.SubDataPropertyOfAxiom#getSuperProperty <em>Super Property</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getSubDataPropertyOfAxiom()
 * @model
 * @generated
 */
public interface SubDataPropertyOfAxiom extends TermAxiom, ElementCrossReferenceTuple {
	/**
	 * Returns the value of the '<em><b>Sub Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Property</em>' reference.
	 * @see #setSubProperty(EntityScalarDataProperty)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getSubDataPropertyOfAxiom_SubProperty()
	 * @model required="true"
	 * @generated
	 */
	EntityScalarDataProperty getSubProperty();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.SubDataPropertyOfAxiom#getSubProperty <em>Sub Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub Property</em>' reference.
	 * @see #getSubProperty()
	 * @generated
	 */
	void setSubProperty(EntityScalarDataProperty value);

	/**
	 * Returns the value of the '<em><b>Super Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Property</em>' reference.
	 * @see #setSuperProperty(EntityScalarDataProperty)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getSubDataPropertyOfAxiom_SuperProperty()
	 * @model required="true"
	 * @generated
	 */
	EntityScalarDataProperty getSuperProperty();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.SubDataPropertyOfAxiom#getSuperProperty <em>Super Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super Property</em>' reference.
	 * @see #getSuperProperty()
	 * @generated
	 */
	void setSuperProperty(EntityScalarDataProperty value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="gov.nasa.jpl.imce.oml.model.common.UUID" unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox%&gt; _tbox = this.getTbox();\n&lt;%java.lang.String%&gt; _uuid = null;\nif (_tbox!=null)\n{\n\t_uuid=_tbox.uuid();\n}\n&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _mappedTo = &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;of(\"tbox\", _uuid);\n&lt;%gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataProperty%&gt; _subProperty = this.getSubProperty();\n&lt;%java.lang.String%&gt; _uuid_1 = null;\nif (_subProperty!=null)\n{\n\t_uuid_1=_subProperty.uuid();\n}\n&lt;%java.lang.String%&gt; _string = null;\nif (_uuid_1!=null)\n{\n\t_string=_uuid_1.toString();\n}\n&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _mappedTo_1 = &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;of(\"subProperty\", _string);\n&lt;%gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataProperty%&gt; _superProperty = this.getSuperProperty();\n&lt;%java.lang.String%&gt; _uuid_2 = null;\nif (_superProperty!=null)\n{\n\t_uuid_2=_superProperty.uuid();\n}\n&lt;%java.lang.String%&gt; _string_1 = null;\nif (_uuid_2!=null)\n{\n\t_string_1=_uuid_2.toString();\n}\n&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _mappedTo_2 = &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;of(\"superProperty\", _string_1);\n&lt;%java.util.UUID%&gt; _derivedUUID = &lt;%gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions%&gt;.derivedUUID(\n\t\"SubDataPropertyOfAxiom\", _mappedTo, _mappedTo_1, _mappedTo_2);\n&lt;%java.lang.String%&gt; _string_2 = null;\nif (_derivedUUID!=null)\n{\n\t_string_2=_derivedUUID.toString();\n}\nreturn _string_2;'"
	 * @generated
	 */
	String uuid();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Scala code='scala.collection.immutable.Set.empty[resolver.api.LogicalElement]'"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Collection kind='Set'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return &lt;%org.eclipse.emf.common.util.ECollections%&gt;.&lt;&lt;%gov.nasa.jpl.imce.oml.model.common.LogicalElement%&gt;&gt;emptyEList();'"
	 * @generated
	 */
	EList<LogicalElement> allNestedElements();

} // SubDataPropertyOfAxiom
