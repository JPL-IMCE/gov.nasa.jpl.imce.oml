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

import gov.nasa.jpl.imce.oml.model.common.ModuleElement;

import gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataProperty;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Singleton Instance Scalar Data Property Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML SingletonInstanceScalarDataPropertyValue defines a tuple for representing the atomic String value
 * of an OML EntityScalarDataProperty for a particular OML ConceptualEntitySingletonInstance.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceScalarDataPropertyValue#getDescriptionBox <em>Description Box</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceScalarDataPropertyValue#getSingletonInstance <em>Singleton Instance</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceScalarDataPropertyValue#getScalarDataProperty <em>Scalar Data Property</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceScalarDataPropertyValue#getScalarPropertyValue <em>Scalar Property Value</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage#getSingletonInstanceScalarDataPropertyValue()
 * @model
 * @generated
 */
public interface SingletonInstanceScalarDataPropertyValue extends ModuleElement {
	/**
	 * Returns the value of the '<em><b>Description Box</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox#getSingletonScalarDataPropertyValues <em>Singleton Scalar Data Property Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description Box</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description Box</em>' container reference.
	 * @see #setDescriptionBox(DescriptionBox)
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage#getSingletonInstanceScalarDataPropertyValue_DescriptionBox()
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox#getSingletonScalarDataPropertyValues
	 * @model opposite="singletonScalarDataPropertyValues" required="true" transient="false"
	 * @generated
	 */
	DescriptionBox getDescriptionBox();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceScalarDataPropertyValue#getDescriptionBox <em>Description Box</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description Box</em>' container reference.
	 * @see #getDescriptionBox()
	 * @generated
	 */
	void setDescriptionBox(DescriptionBox value);

	/**
	 * Returns the value of the '<em><b>Singleton Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Singleton Instance</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Singleton Instance</em>' reference.
	 * @see #setSingletonInstance(ConceptualEntitySingletonInstance)
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage#getSingletonInstanceScalarDataPropertyValue_SingletonInstance()
	 * @model required="true"
	 * @generated
	 */
	ConceptualEntitySingletonInstance getSingletonInstance();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceScalarDataPropertyValue#getSingletonInstance <em>Singleton Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Singleton Instance</em>' reference.
	 * @see #getSingletonInstance()
	 * @generated
	 */
	void setSingletonInstance(ConceptualEntitySingletonInstance value);

	/**
	 * Returns the value of the '<em><b>Scalar Data Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scalar Data Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scalar Data Property</em>' reference.
	 * @see #setScalarDataProperty(EntityScalarDataProperty)
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage#getSingletonInstanceScalarDataPropertyValue_ScalarDataProperty()
	 * @model required="true"
	 * @generated
	 */
	EntityScalarDataProperty getScalarDataProperty();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceScalarDataPropertyValue#getScalarDataProperty <em>Scalar Data Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scalar Data Property</em>' reference.
	 * @see #getScalarDataProperty()
	 * @generated
	 */
	void setScalarDataProperty(EntityScalarDataProperty value);

	/**
	 * Returns the value of the '<em><b>Scalar Property Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scalar Property Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scalar Property Value</em>' attribute.
	 * @see #setScalarPropertyValue(String)
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage#getSingletonInstanceScalarDataPropertyValue_ScalarPropertyValue()
	 * @model unique="false" required="true"
	 * @generated
	 */
	String getScalarPropertyValue();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceScalarDataPropertyValue#getScalarPropertyValue <em>Scalar Property Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scalar Property Value</em>' attribute.
	 * @see #getScalarPropertyValue()
	 * @generated
	 */
	void setScalarPropertyValue(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="gov.nasa.jpl.imce.oml.model.common.UUID" unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox%> _descriptionBox = this.getDescriptionBox();\n<%java.lang.String%> _uuid = null;\nif (_descriptionBox!=null)\n{\n\t_uuid=_descriptionBox.uuid();\n}\n<%java.lang.String%> _string = null;\nif (_uuid!=null)\n{\n\t_string=_uuid.toString();\n}\n<%org.eclipse.xtext.xbase.lib.Pair%><<%java.lang.String%>, <%java.lang.String%>> _mappedTo = <%org.eclipse.xtext.xbase.lib.Pair%>.<<%java.lang.String%>, <%java.lang.String%>>of(\"descriptionBox\", _string);\n<%gov.nasa.jpl.imce.oml.model.descriptions.ConceptualEntitySingletonInstance%> _singletonInstance = this.getSingletonInstance();\n<%java.lang.String%> _uuid_1 = null;\nif (_singletonInstance!=null)\n{\n\t_uuid_1=_singletonInstance.uuid();\n}\n<%java.lang.String%> _string_1 = null;\nif (_uuid_1!=null)\n{\n\t_string_1=_uuid_1.toString();\n}\n<%org.eclipse.xtext.xbase.lib.Pair%><<%java.lang.String%>, <%java.lang.String%>> _mappedTo_1 = <%org.eclipse.xtext.xbase.lib.Pair%>.<<%java.lang.String%>, <%java.lang.String%>>of(\"singletonInstance\", _string_1);\n<%gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataProperty%> _scalarDataProperty = this.getScalarDataProperty();\n<%java.lang.String%> _uuid_2 = null;\nif (_scalarDataProperty!=null)\n{\n\t_uuid_2=_scalarDataProperty.uuid();\n}\n<%java.lang.String%> _string_2 = null;\nif (_uuid_2!=null)\n{\n\t_string_2=_uuid_2.toString();\n}\n<%org.eclipse.xtext.xbase.lib.Pair%><<%java.lang.String%>, <%java.lang.String%>> _mappedTo_2 = <%org.eclipse.xtext.xbase.lib.Pair%>.<<%java.lang.String%>, <%java.lang.String%>>of(\"scalarDataProperty\", _string_2);\n<%java.util.UUID%> _derivedUUID = <%gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions%>.derivedUUID(\n\t\"ScalarDataPropertyValue\", _mappedTo, _mappedTo_1, _mappedTo_2);\n<%java.lang.String%> _string_3 = null;\nif (_derivedUUID!=null)\n{\n\t_string_3=_derivedUUID.toString();\n}\nreturn _string_3;'"
	 * @generated
	 */
	String uuid();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getDescriptionBox();'"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Scala code='extent.descriptionBoxOfSingletonInstanceScalarDataPropertyValue.get(this)'"
	 * @generated
	 */
	DescriptionBox descriptionBox();

} // SingletonInstanceScalarDataPropertyValue
