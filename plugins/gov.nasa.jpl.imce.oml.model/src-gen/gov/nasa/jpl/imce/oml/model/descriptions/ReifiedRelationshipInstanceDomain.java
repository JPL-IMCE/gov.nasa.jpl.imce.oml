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
 * A representation of the model object '<em><b>Reified Relationship Instance Domain</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML ReifiedRelationshipInstanceDomain specifies which OML ConceptualEntitySingletonInstance
 * plays the role of the domain for an OML ReifiedRelationshipInstance.
 * An OML ReifiedRelationshipInstanceDomain has no intrinsic identity; instead,
 * an OML ReifiedRelationshipInstanceDomain is semantically equivalent
 * to another OML ReifiedRelationshipInstanceDomain referencing the same property and domain.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceDomain#getDescriptionBox <em>Description Box</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceDomain#getReifiedRelationshipInstance <em>Reified Relationship Instance</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceDomain#getDomain <em>Domain</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage#getReifiedRelationshipInstanceDomain()
 * @model
 * @generated
 */
public interface ReifiedRelationshipInstanceDomain extends TerminologyInstanceAssertion, ElementCrossReferenceTuple {
	/**
	 * Returns the value of the '<em><b>Description Box</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox#getReifiedRelationshipInstanceDomains <em>Reified Relationship Instance Domains</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description Box</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description Box</em>' container reference.
	 * @see #setDescriptionBox(DescriptionBox)
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage#getReifiedRelationshipInstanceDomain_DescriptionBox()
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox#getReifiedRelationshipInstanceDomains
	 * @model opposite="reifiedRelationshipInstanceDomains" required="true" transient="false"
	 * @generated
	 */
	DescriptionBox getDescriptionBox();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceDomain#getDescriptionBox <em>Description Box</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description Box</em>' container reference.
	 * @see #getDescriptionBox()
	 * @generated
	 */
	void setDescriptionBox(DescriptionBox value);

	/**
	 * Returns the value of the '<em><b>Reified Relationship Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reified Relationship Instance</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reified Relationship Instance</em>' reference.
	 * @see #setReifiedRelationshipInstance(ReifiedRelationshipInstance)
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage#getReifiedRelationshipInstanceDomain_ReifiedRelationshipInstance()
	 * @model required="true"
	 * @generated
	 */
	ReifiedRelationshipInstance getReifiedRelationshipInstance();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceDomain#getReifiedRelationshipInstance <em>Reified Relationship Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reified Relationship Instance</em>' reference.
	 * @see #getReifiedRelationshipInstance()
	 * @generated
	 */
	void setReifiedRelationshipInstance(ReifiedRelationshipInstance value);

	/**
	 * Returns the value of the '<em><b>Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain</em>' reference.
	 * @see #setDomain(ConceptualEntitySingletonInstance)
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage#getReifiedRelationshipInstanceDomain_Domain()
	 * @model required="true"
	 * @generated
	 */
	ConceptualEntitySingletonInstance getDomain();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceDomain#getDomain <em>Domain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain</em>' reference.
	 * @see #getDomain()
	 * @generated
	 */
	void setDomain(ConceptualEntitySingletonInstance value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Scala code='extent.descriptionBoxOfReifiedRelationshipInstanceDomain.get(this)'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getDescriptionBox();'"
	 * @generated
	 */
	DescriptionBox descriptionBox();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="gov.nasa.jpl.imce.oml.model.common.UUID" unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox%&gt; _descriptionBox = this.descriptionBox();\n&lt;%java.lang.String%&gt; _uuid = null;\nif (_descriptionBox!=null)\n{\n\t_uuid=_descriptionBox.uuid();\n}\n&lt;%java.lang.String%&gt; _string = null;\nif (_uuid!=null)\n{\n\t_string=_uuid.toString();\n}\n&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _mappedTo = &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;of(\"descriptionBox\", _string);\n&lt;%gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstance%&gt; _reifiedRelationshipInstance = this.getReifiedRelationshipInstance();\n&lt;%java.lang.String%&gt; _uuid_1 = null;\nif (_reifiedRelationshipInstance!=null)\n{\n\t_uuid_1=_reifiedRelationshipInstance.uuid();\n}\n&lt;%java.lang.String%&gt; _string_1 = null;\nif (_uuid_1!=null)\n{\n\t_string_1=_uuid_1.toString();\n}\n&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _mappedTo_1 = &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;of(\"reifiedRelationshipInstance\", _string_1);\n&lt;%gov.nasa.jpl.imce.oml.model.descriptions.ConceptualEntitySingletonInstance%&gt; _domain = this.getDomain();\n&lt;%java.lang.String%&gt; _uuid_2 = null;\nif (_domain!=null)\n{\n\t_uuid_2=_domain.uuid();\n}\n&lt;%java.lang.String%&gt; _string_2 = null;\nif (_uuid_2!=null)\n{\n\t_string_2=_uuid_2.toString();\n}\n&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _mappedTo_2 = &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;of(\"domain\", _string_2);\n&lt;%java.util.UUID%&gt; _derivedUUID = &lt;%gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions%&gt;.derivedUUID(\n\t\"ReifiedRelationshipInstanceDomain\", _mappedTo, _mappedTo_1, _mappedTo_2);\n&lt;%java.lang.String%&gt; _string_3 = null;\nif (_derivedUUID!=null)\n{\n\t_string_3=_derivedUUID.toString();\n}\nreturn _string_3;'"
	 * @generated
	 */
	String uuid();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.descriptionBox();'"
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

} // ReifiedRelationshipInstanceDomain
