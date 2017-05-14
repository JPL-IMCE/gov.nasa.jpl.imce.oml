/**
 * 
 * Copyright 2016 California Institute of Technology ("Caltech").
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
 * A representation of the model object '<em><b>Aspect Specialization Axiom</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML AspectSpecializationAxiom is a logical axiom
 * about a taxonomic relationship between a specific OML Aspect
 * and a general OML Entity.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.AspectSpecializationAxiom#getSubEntity <em>Sub Entity</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.AspectSpecializationAxiom#getSuperAspect <em>Super Aspect</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getAspectSpecializationAxiom()
 * @model
 * @generated
 */
public interface AspectSpecializationAxiom extends SpecializationAxiom {
	/**
	 * Returns the value of the '<em><b>Sub Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The sub (child) entity
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Sub Entity</em>' reference.
	 * @see #setSubEntity(Entity)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getAspectSpecializationAxiom_SubEntity()
	 * @model required="true"
	 * @generated
	 */
	Entity getSubEntity();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.AspectSpecializationAxiom#getSubEntity <em>Sub Entity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub Entity</em>' reference.
	 * @see #getSubEntity()
	 * @generated
	 */
	void setSubEntity(Entity value);

	/**
	 * Returns the value of the '<em><b>Super Aspect</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The super (parent) aspect
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Super Aspect</em>' reference.
	 * @see #setSuperAspect(Aspect)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getAspectSpecializationAxiom_SuperAspect()
	 * @model required="true"
	 * @generated
	 */
	Aspect getSuperAspect();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.AspectSpecializationAxiom#getSuperAspect <em>Super Aspect</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super Aspect</em>' reference.
	 * @see #getSuperAspect()
	 * @generated
	 */
	void setSuperAspect(Aspect value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Get the sub (child) entity
	 * <!-- end-model-doc -->
	 * @model unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getSubEntity();'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getSuperAspect();'"
	 * @generated
	 */
	Entity parent();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="gov.nasa.jpl.imce.oml.model.common.UUID" unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%java.lang.String%> _uuid = this.getTbox().uuid();\n<%org.eclipse.xtext.xbase.lib.Pair%><<%java.lang.String%>, <%java.lang.String%>> _mappedTo = <%org.eclipse.xtext.xbase.lib.Pair%>.<<%java.lang.String%>, <%java.lang.String%>>of(\"tbox\", _uuid);\n<%gov.nasa.jpl.imce.oml.model.terminologies.Aspect%> _superAspect = this.getSuperAspect();\n<%java.lang.String%> _uuid_1 = null;\nif (_superAspect!=null)\n{\n\t_uuid_1=_superAspect.uuid();\n}\n<%java.lang.String%> _string = null;\nif (_uuid_1!=null)\n{\n\t_string=_uuid_1.toString();\n}\n<%org.eclipse.xtext.xbase.lib.Pair%><<%java.lang.String%>, <%java.lang.String%>> _mappedTo_1 = <%org.eclipse.xtext.xbase.lib.Pair%>.<<%java.lang.String%>, <%java.lang.String%>>of(\"superAspect\", _string);\n<%gov.nasa.jpl.imce.oml.model.terminologies.Entity%> _subEntity = this.getSubEntity();\n<%java.lang.String%> _uuid_2 = null;\nif (_subEntity!=null)\n{\n\t_uuid_2=_subEntity.uuid();\n}\n<%java.lang.String%> _string_1 = null;\nif (_uuid_2!=null)\n{\n\t_string_1=_uuid_2.toString();\n}\n<%org.eclipse.xtext.xbase.lib.Pair%><<%java.lang.String%>, <%java.lang.String%>> _mappedTo_2 = <%org.eclipse.xtext.xbase.lib.Pair%>.<<%java.lang.String%>, <%java.lang.String%>>of(\"subEntity\", _string_1);\n<%java.util.UUID%> _derivedUUID = <%gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions%>.derivedUUID(\n\t\"AspectSpecializationAxiom\", _mappedTo, _mappedTo_1, _mappedTo_2);\n<%java.lang.String%> _string_2 = null;\nif (_derivedUUID!=null)\n{\n\t_string_2=_derivedUUID.toString();\n}\nreturn _string_2;'"
	 * @generated
	 */
	String uuid();

} // AspectSpecializationAxiom
