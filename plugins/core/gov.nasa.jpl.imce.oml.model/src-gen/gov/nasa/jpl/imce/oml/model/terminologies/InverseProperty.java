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

import gov.nasa.jpl.imce.oml.model.common.Module;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Inverse Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML InverseProperty is an optional part of an OML ReifiedRelationship.
 * If defined, it corresponds to the inverse of the OML ReifiedRelationship's OML ForwardProperty.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.InverseProperty#getReifiedRelationship <em>Reified Relationship</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.InverseProperty#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getInverseProperty()
 * @model
 * @generated
 */
public interface InverseProperty extends RestrictableRelationship {
	/**
	 * Returns the value of the '<em><b>Reified Relationship</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship#getInverseProperty <em>Inverse Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reified Relationship</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reified Relationship</em>' container reference.
	 * @see #setReifiedRelationship(ReifiedRelationship)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getInverseProperty_ReifiedRelationship()
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship#getInverseProperty
	 * @model opposite="inverseProperty" required="true" transient="false"
	 * @generated
	 */
	ReifiedRelationship getReifiedRelationship();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.InverseProperty#getReifiedRelationship <em>Reified Relationship</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reified Relationship</em>' container reference.
	 * @see #getReifiedRelationship()
	 * @generated
	 */
	void setReifiedRelationship(ReifiedRelationship value);

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
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getInverseProperty_Name()
	 * @model unique="false" dataType="gov.nasa.jpl.imce.oml.model.common.LocalName" required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.InverseProperty#getName <em>Name</em>}' attribute.
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
	 * @model dataType="gov.nasa.jpl.imce.oml.model.common.IRI" unique="false"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Scala code='extent\n\t    .terminologyBoxOfTerminologyBoxStatement\n\t    .get(reifiedRelationship)\n\t    .flatMap(tbox =&gt; tbox.iri().map(i =&gt;  gov.nasa.jpl.imce.oml.tables.taggedTypes.iri(i + \"#\" + name)))'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship%&gt; _reifiedRelationship = this.getReifiedRelationship();\n&lt;%gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox%&gt; _tbox = null;\nif (_reifiedRelationship!=null)\n{\n\t_tbox=_reifiedRelationship.getTbox();\n}\n&lt;%java.lang.String%&gt; _iri = null;\nif (_tbox!=null)\n{\n\t_iri=_tbox.iri();\n}\n&lt;%java.lang.String%&gt; _plus = (_iri + \"#\");\n&lt;%java.lang.String%&gt; _name = this.name();\nreturn (_plus + _name);'"
	 * @generated
	 */
	String iri();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Scala code='extent\n\t    .terminologyBoxOfTerminologyBoxStatement\n\t    .get(reifiedRelationship)\n\t    .map(tbox =&gt; tbox.nsPrefix+\":\"+name)'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%java.lang.String%&gt; _elvis = null;\n&lt;%gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship%&gt; _reifiedRelationship = this.getReifiedRelationship();\n&lt;%gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox%&gt; _tbox = null;\nif (_reifiedRelationship!=null)\n{\n\t_tbox=_reifiedRelationship.getTbox();\n}\n&lt;%java.lang.String%&gt; _nsPrefix = null;\nif (_tbox!=null)\n{\n\t_nsPrefix=_tbox.nsPrefix();\n}\nif (_nsPrefix != null)\n{\n\t_elvis = _nsPrefix;\n} else\n{\n\t_elvis = \"\";\n}\n&lt;%java.lang.String%&gt; _plus = (_elvis + \":\");\n&lt;%java.lang.String%&gt; _name = this.name();\nreturn (_plus + _name);'"
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
	 * @model dataType="gov.nasa.jpl.imce.oml.model.common.UUID" unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%java.lang.String%&gt; _name = this.name();\n&lt;%java.lang.String%&gt; _string = null;\nif (_name!=null)\n{\n\t_string=_name.toString();\n}\n&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _mappedTo = &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;of(\"name\", _string);\n&lt;%gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship%&gt; _reifiedRelationship = this.getReifiedRelationship();\n&lt;%java.lang.String%&gt; _uuid = null;\nif (_reifiedRelationship!=null)\n{\n\t_uuid=_reifiedRelationship.uuid();\n}\n&lt;%java.lang.String%&gt; _string_1 = null;\nif (_uuid!=null)\n{\n\t_string_1=_uuid.toString();\n}\n&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _mappedTo_1 = &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;of(\"reifiedRelationship\", _string_1);\n&lt;%java.util.UUID%&gt; _derivedUUID = &lt;%gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions%&gt;.derivedUUID(\n\t\"InverseProperty\", _mappedTo, _mappedTo_1);\n&lt;%java.lang.String%&gt; _string_2 = null;\nif (_derivedUUID!=null)\n{\n\t_string_2=_derivedUUID.toString();\n}\nreturn _string_2;'"
	 * @generated
	 */
	String uuid();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getReifiedRelationship();'"
	 * @generated
	 */
	EntityRelationship relation();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship%&gt; _reifiedRelationship = this.getReifiedRelationship();\n&lt;%gov.nasa.jpl.imce.oml.model.common.Module%&gt; _moduleContext = null;\nif (_reifiedRelationship!=null)\n{\n\t_moduleContext=_reifiedRelationship.moduleContext();\n}\nreturn _moduleContext;'"
	 * @generated
	 */
	Module moduleContext();

} // InverseProperty
