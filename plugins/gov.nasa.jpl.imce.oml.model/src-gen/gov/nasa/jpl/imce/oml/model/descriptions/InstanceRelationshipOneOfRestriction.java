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

import gov.nasa.jpl.imce.oml.model.common.ElementCrossReferenceTuple;
import gov.nasa.jpl.imce.oml.model.common.LogicalElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instance Relationship One Of Restriction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An InstanceRelationshipOneOfRestriction is a reference to an OML ConceptualEntitySingletonInstance
 * playing the role of an enumerated individual for the range of an OML InstanceRelationshipValueRestriction.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.InstanceRelationshipOneOfRestriction#getEnumeration <em>Enumeration</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.InstanceRelationshipOneOfRestriction#getRange <em>Range</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage#getInstanceRelationshipOneOfRestriction()
 * @model
 * @generated
 */
public interface InstanceRelationshipOneOfRestriction extends ElementCrossReferenceTuple {
	/**
	 * Returns the value of the '<em><b>Enumeration</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link gov.nasa.jpl.imce.oml.model.descriptions.InstanceRelationshipEnumerationRestriction#getReferences <em>References</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enumeration</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enumeration</em>' container reference.
	 * @see #setEnumeration(InstanceRelationshipEnumerationRestriction)
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage#getInstanceRelationshipOneOfRestriction_Enumeration()
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.InstanceRelationshipEnumerationRestriction#getReferences
	 * @model opposite="references" required="true" transient="false"
	 * @generated
	 */
	InstanceRelationshipEnumerationRestriction getEnumeration();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.descriptions.InstanceRelationshipOneOfRestriction#getEnumeration <em>Enumeration</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enumeration</em>' container reference.
	 * @see #getEnumeration()
	 * @generated
	 */
	void setEnumeration(InstanceRelationshipEnumerationRestriction value);

	/**
	 * Returns the value of the '<em><b>Range</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Range</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Range</em>' reference.
	 * @see #setRange(ConceptualEntitySingletonInstance)
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage#getInstanceRelationshipOneOfRestriction_Range()
	 * @model required="true"
	 * @generated
	 */
	ConceptualEntitySingletonInstance getRange();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.descriptions.InstanceRelationshipOneOfRestriction#getRange <em>Range</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Range</em>' reference.
	 * @see #getRange()
	 * @generated
	 */
	void setRange(ConceptualEntitySingletonInstance value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="gov.nasa.jpl.imce.oml.model.common.UUID" unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%gov.nasa.jpl.imce.oml.model.descriptions.InstanceRelationshipEnumerationRestriction%&gt; _enumeration = this.getEnumeration();\n&lt;%java.lang.String%&gt; _uuid = null;\nif (_enumeration!=null)\n{\n\t_uuid=_enumeration.uuid();\n}\n&lt;%java.lang.String%&gt; _string = null;\nif (_uuid!=null)\n{\n\t_string=_uuid.toString();\n}\n&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _mappedTo = &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;of(\"enumeration\", _string);\n&lt;%gov.nasa.jpl.imce.oml.model.descriptions.ConceptualEntitySingletonInstance%&gt; _range = this.getRange();\n&lt;%java.lang.String%&gt; _uuid_1 = null;\nif (_range!=null)\n{\n\t_uuid_1=_range.uuid();\n}\n&lt;%java.lang.String%&gt; _string_1 = null;\nif (_uuid_1!=null)\n{\n\t_string_1=_uuid_1.toString();\n}\n&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _mappedTo_1 = &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;of(\"range\", _string_1);\n&lt;%java.util.UUID%&gt; _derivedUUID = &lt;%gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions%&gt;.derivedUUID(\n\t\"InstanceRelationshipOneOfRestriction\", _mappedTo, _mappedTo_1);\n&lt;%java.lang.String%&gt; _string_2 = null;\nif (_derivedUUID!=null)\n{\n\t_string_2=_derivedUUID.toString();\n}\nreturn _string_2;'"
	 * @generated
	 */
	String uuid();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Scala code='extent.instanceRelationshipEnumerationRestrictionOfInstanceRelationshipOneOfRestriction.get(this).flatMap(_.descriptionBox())'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%gov.nasa.jpl.imce.oml.model.descriptions.InstanceRelationshipEnumerationRestriction%&gt; _enumeration = this.getEnumeration();\n&lt;%gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox%&gt; _descriptionBox = null;\nif (_enumeration!=null)\n{\n\t_descriptionBox=_enumeration.descriptionBox();\n}\nreturn _descriptionBox;'"
	 * @generated
	 */
	gov.nasa.jpl.imce.oml.model.common.Module moduleContext();

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

} // InstanceRelationshipOneOfRestriction
