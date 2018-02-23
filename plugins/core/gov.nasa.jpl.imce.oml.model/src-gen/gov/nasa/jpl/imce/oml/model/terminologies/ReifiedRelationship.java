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

import gov.nasa.jpl.imce.oml.model.common.LogicalElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reified Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML ReifiedRelationship is an OML ConceptualRelationship
 * and a kind of OML CharacterizedEntityRelationship
 * where an instance has an intrinsic identity. This means that
 * an OML ReifiedRelationship can be involved as the domain or the
 * range of another OML EntityRelationship as well as the
 * domain of an OML DataRelationshipFromEntity.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship#getForwardProperty <em>Forward Property</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship#getInverseProperty <em>Inverse Property</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getReifiedRelationship()
 * @model
 * @generated
 */
public interface ReifiedRelationship extends ConceptualRelationship, CharacterizedEntityRelationship {
	/**
	 * Returns the value of the '<em><b>Forward Property</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link gov.nasa.jpl.imce.oml.model.terminologies.ForwardProperty#getReifiedRelationship <em>Reified Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Forward Property</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Forward Property</em>' containment reference.
	 * @see #setForwardProperty(ForwardProperty)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getReifiedRelationship_ForwardProperty()
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.ForwardProperty#getReifiedRelationship
	 * @model opposite="reifiedRelationship" containment="true" required="true"
	 * @generated
	 */
	ForwardProperty getForwardProperty();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship#getForwardProperty <em>Forward Property</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Forward Property</em>' containment reference.
	 * @see #getForwardProperty()
	 * @generated
	 */
	void setForwardProperty(ForwardProperty value);

	/**
	 * Returns the value of the '<em><b>Inverse Property</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link gov.nasa.jpl.imce.oml.model.terminologies.InverseProperty#getReifiedRelationship <em>Reified Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inverse Property</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inverse Property</em>' containment reference.
	 * @see #setInverseProperty(InverseProperty)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getReifiedRelationship_InverseProperty()
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.InverseProperty#getReifiedRelationship
	 * @model opposite="reifiedRelationship" containment="true"
	 * @generated
	 */
	InverseProperty getInverseProperty();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship#getInverseProperty <em>Inverse Property</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inverse Property</em>' containment reference.
	 * @see #getInverseProperty()
	 * @generated
	 */
	void setInverseProperty(InverseProperty value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Scala code='\n\t\tscala.collection.immutable.Set[resolver.api.LogicalElement]() ++\n\t\textent.forwardProperty.get(this) ++\n\t\textent.inverseProperty.get(this)'"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Collection kind='Set'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%org.eclipse.emf.common.util.BasicEList%&gt;&lt;&lt;%gov.nasa.jpl.imce.oml.model.common.LogicalElement%&gt;&gt; _xblockexpression = null;\n{\n\tfinal &lt;%org.eclipse.emf.common.util.BasicEList%&gt;&lt;&lt;%gov.nasa.jpl.imce.oml.model.common.LogicalElement%&gt;&gt; les = new &lt;%org.eclipse.emf.common.util.BasicEList%&gt;&lt;&lt;%gov.nasa.jpl.imce.oml.model.common.LogicalElement%&gt;&gt;();\n\tles.add(this.getForwardProperty());\n\t&lt;%gov.nasa.jpl.imce.oml.model.terminologies.InverseProperty%&gt; _inverseProperty = this.getInverseProperty();\n\tboolean _tripleNotEquals = (null != _inverseProperty);\n\tif (_tripleNotEquals)\n\t{\n\t\tles.add(this.getInverseProperty());\n\t}\n\t_xblockexpression = les;\n}\nreturn _xblockexpression;'"
	 * @generated
	 */
	EList<LogicalElement> allNestedElements();

} // ReifiedRelationship
