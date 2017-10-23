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
package gov.nasa.jpl.imce.oml.model.common;

import org.eclipse.emf.cdo.CDOObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Annotation Property Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * For the OML tabular interchange representation,
 * an OML AnnotationPropertyValue is a triple <S,P,V>
 * where S is an OML Element, P an OML AnnotationProperty
 * and V is the value of P asserted about S by this triple.
 * The UUID of an OML AnnotationPropertyValue is deterministically derived
 * from its subject and property. This means that two OML AnnotationPropertyValues
 * with the same subject and property must have the same value otherwise they would
 * be structurally distinct triples with the same UUID, which would be ill-formed.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.common.AnnotationPropertyValue#getUuid <em>Uuid</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.common.AnnotationPropertyValue#getSubject <em>Subject</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.common.AnnotationPropertyValue#getProperty <em>Property</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.common.AnnotationPropertyValue#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.common.CommonPackage#getAnnotationPropertyValue()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface AnnotationPropertyValue extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uuid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uuid</em>' attribute.
	 * @see gov.nasa.jpl.imce.oml.model.common.CommonPackage#getAnnotationPropertyValue_Uuid()
	 * @model unique="false" dataType="gov.nasa.jpl.imce.oml.model.common.UUID" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='&lt;%gov.nasa.jpl.imce.oml.model.common.Element%&gt; _subject = this.getSubject();\n&lt;%java.lang.String%&gt; _uuid = null;\nif (_subject!=null)\n{\n\t_uuid=_subject.uuid();\n}\n&lt;%java.lang.String%&gt; _string = null;\nif (_uuid!=null)\n{\n\t_string=_uuid.toString();\n}\n&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _mappedTo = &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;of(\"subject\", _string);\n&lt;%gov.nasa.jpl.imce.oml.model.common.AnnotationProperty%&gt; _property = this.getProperty();\n&lt;%java.lang.String%&gt; _uuid_1 = null;\nif (_property!=null)\n{\n\t_uuid_1=_property.getUuid();\n}\n&lt;%java.lang.String%&gt; _string_1 = null;\nif (_uuid_1!=null)\n{\n\t_string_1=_uuid_1.toString();\n}\n&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _mappedTo_1 = &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;of(\"property\", _string_1);\n&lt;%java.util.UUID%&gt; _derivedUUID = &lt;%gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions%&gt;.derivedUUID(\n\t\"AnnotationPropertyValue\", _mappedTo, _mappedTo_1);\n&lt;%java.lang.String%&gt; _string_2 = null;\nif (_derivedUUID!=null)\n{\n\t_string_2=_derivedUUID.toString();\n}\nreturn _string_2;'"
	 * @generated
	 */
	String getUuid();

	/**
	 * Returns the value of the '<em><b>Subject</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link gov.nasa.jpl.imce.oml.model.common.Element#getAnnotations <em>Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subject</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subject</em>' container reference.
	 * @see #setSubject(Element)
	 * @see gov.nasa.jpl.imce.oml.model.common.CommonPackage#getAnnotationPropertyValue_Subject()
	 * @see gov.nasa.jpl.imce.oml.model.common.Element#getAnnotations
	 * @model opposite="annotations" required="true" transient="false"
	 * @generated
	 */
	Element getSubject();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.common.AnnotationPropertyValue#getSubject <em>Subject</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subject</em>' container reference.
	 * @see #getSubject()
	 * @generated
	 */
	void setSubject(Element value);

	/**
	 * Returns the value of the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property</em>' reference.
	 * @see #setProperty(AnnotationProperty)
	 * @see gov.nasa.jpl.imce.oml.model.common.CommonPackage#getAnnotationPropertyValue_Property()
	 * @model required="true"
	 * @generated
	 */
	AnnotationProperty getProperty();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.common.AnnotationPropertyValue#getProperty <em>Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property</em>' reference.
	 * @see #getProperty()
	 * @generated
	 */
	void setProperty(AnnotationProperty value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(LiteralString)
	 * @see gov.nasa.jpl.imce.oml.model.common.CommonPackage#getAnnotationPropertyValue_Value()
	 * @model containment="true" required="true"
	 * @generated
	 */
	LiteralString getValue();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.common.AnnotationPropertyValue#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(LiteralString value);

} // AnnotationPropertyValue
