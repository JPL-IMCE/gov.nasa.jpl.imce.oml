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

import gov.nasa.jpl.imce.oml.model.common.Resource;

import gov.nasa.jpl.imce.oml.model.terminologies.ConceptualEntity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conceptual Entity Singleton Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML ConceptualEntitySingletonInstance defines an instance of an OML ConceptualEntity.
 * An OML ConceptualEntitySingletonInstance maps to an [OWL2 NamedIndividual].
 * The semantics depends on the kind of OML ConceptualEntity classifier:
 * - If the OML ConceptualEntity is the domain for at least at least
 *   one OML DataRelationshipFromEntity with `isIdentityCriteria=true`,
 *   then the [OWL2-DL] mapping includes an [OWL2 Key Axiom]
 *   forcing that all distinctly named OML ConceptualEntitySingletonInstance
 *   must have different values for each OML DataRelationshipFromEntity with `isIdentityCriteria=true`.
 * - otherwise, distinctly named OML ConceptualEntitySingletonInstance
 *   represent semantically different instances.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.ConceptualEntitySingletonInstance#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage#getConceptualEntitySingletonInstance()
 * @model abstract="true"
 *        annotation="http://imce.jpl.nasa.gov/oml/NamespaceUUID namespace='descriptionBox' factors='name'"
 * @generated
 */
public interface ConceptualEntitySingletonInstance extends TerminologyInstanceAssertion, Resource {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage#getConceptualEntitySingletonInstance_Name()
	 * @model unique="false" dataType="gov.nasa.jpl.imce.oml.model.common.LocalName" required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.descriptions.ConceptualEntitySingletonInstance#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 * @generated
	 */
	DescriptionBox descriptionBox();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="gov.nasa.jpl.imce.oml.model.common.IRI" unique="false"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Scala code='descriptionBox().flatMap(_.iri())'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox%&gt; _descriptionBox = this.descriptionBox();\n&lt;%java.lang.String%&gt; _iri = null;\nif (_descriptionBox!=null)\n{\n\t_iri=_descriptionBox.iri();\n}\n&lt;%java.lang.String%&gt; _plus = (_iri + \"#\");\n&lt;%java.lang.String%&gt; _name = this.name();\nreturn (_plus + _name);'"
	 * @generated
	 */
	String iri();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Scala code='descriptionBox().map(dbox =&gt; dbox.nsPrefix+\":\"+name)'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%java.lang.String%&gt; _elvis = null;\n&lt;%gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox%&gt; _descriptionBox = this.descriptionBox();\n&lt;%java.lang.String%&gt; _nsPrefix = null;\nif (_descriptionBox!=null)\n{\n\t_nsPrefix=_descriptionBox.nsPrefix();\n}\nif (_nsPrefix != null)\n{\n\t_elvis = _nsPrefix;\n} else\n{\n\t_elvis = \"\";\n}\n&lt;%java.lang.String%&gt; _plus = (_elvis + \":\");\n&lt;%java.lang.String%&gt; _name = this.name();\nreturn (_plus + _name);'"
	 * @generated
	 */
	String abbrevIRI();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="gov.nasa.jpl.imce.oml.model.common.LocalName" unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getName();'"
	 * @generated
	 */
	String name();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true"
	 * @generated
	 */
	ConceptualEntity conceptualEntitySingletonClassifier();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="gov.nasa.jpl.imce.oml.model.common.UUID" unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox%&gt; _descriptionBox = this.descriptionBox();\n&lt;%java.lang.String%&gt; _uuid = null;\nif (_descriptionBox!=null)\n{\n\t_uuid=_descriptionBox.uuid();\n}\n&lt;%java.lang.String%&gt; _string = null;\nif (_uuid!=null)\n{\n\t_string=_uuid.toString();\n}\n&lt;%java.lang.String%&gt; _name = this.name();\n&lt;%java.lang.String%&gt; _string_1 = null;\nif (_name!=null)\n{\n\t_string_1=_name.toString();\n}\n&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _mappedTo = &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;of(\"name\", _string_1);\n&lt;%java.util.UUID%&gt; _namespaceUUID = &lt;%gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions%&gt;.namespaceUUID(_string, _mappedTo);\n&lt;%java.lang.String%&gt; _string_2 = null;\nif (_namespaceUUID!=null)\n{\n\t_string_2=_namespaceUUID.toString();\n}\nreturn _string_2;'"
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

} // ConceptualEntitySingletonInstance
