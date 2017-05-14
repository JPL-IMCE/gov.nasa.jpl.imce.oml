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
package gov.nasa.jpl.imce.oml.provenance.oti;

import org.eclipse.emf.cdo.CDOObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>OML2OTI Provenance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A 3 or 4 tuple establishing the provenance between:
 * - an OML Element identified by its primary key: omlUUID or, if it is an OML Resource, by its auxiliary key: omlIRI
 * - an OTI UMLElement (identified by its keys: otiID, otiURL, and, if available, otiUUID)
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.provenance.oti.OML2OTIProvenance#getOmlUUID <em>Oml UUID</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.provenance.oti.OML2OTIProvenance#getOmlIRI <em>Oml IRI</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.provenance.oti.OML2OTIProvenance#getOtiID <em>Oti ID</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.provenance.oti.OML2OTIProvenance#getOtiURL <em>Oti URL</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.provenance.oti.OML2OTIProvenance#getOtiUUID <em>Oti UUID</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.provenance.oti.OML2OTIProvenance#getExplanation <em>Explanation</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.provenance.oti.OtiPackage#getOML2OTIProvenance()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface OML2OTIProvenance extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Oml UUID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The UUID of an OML Resource mapped to OTI
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Oml UUID</em>' attribute.
	 * @see #setOmlUUID(String)
	 * @see gov.nasa.jpl.imce.oml.provenance.oti.OtiPackage#getOML2OTIProvenance_OmlUUID()
	 * @model unique="false" dataType="gov.nasa.jpl.imce.oml.provenance.oti.UUID" required="true"
	 * @generated
	 */
	String getOmlUUID();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.provenance.oti.OML2OTIProvenance#getOmlUUID <em>Oml UUID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Oml UUID</em>' attribute.
	 * @see #getOmlUUID()
	 * @generated
	 */
	void setOmlUUID(String value);

	/**
	 * Returns the value of the '<em><b>Oml IRI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the OML Element is an OML Resource, its IRI otherwise nothing.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Oml IRI</em>' attribute.
	 * @see #setOmlIRI(String)
	 * @see gov.nasa.jpl.imce.oml.provenance.oti.OtiPackage#getOML2OTIProvenance_OmlIRI()
	 * @model unique="false" dataType="gov.nasa.jpl.imce.oml.provenance.oti.OML_IRI"
	 * @generated
	 */
	String getOmlIRI();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.provenance.oti.OML2OTIProvenance#getOmlIRI <em>Oml IRI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Oml IRI</em>' attribute.
	 * @see #getOmlIRI()
	 * @generated
	 */
	void setOmlIRI(String value);

	/**
	 * Returns the value of the '<em><b>Oti ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The OTI tool-specific ID of the OTI element mapped from an OML Element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Oti ID</em>' attribute.
	 * @see #setOtiID(String)
	 * @see gov.nasa.jpl.imce.oml.provenance.oti.OtiPackage#getOML2OTIProvenance_OtiID()
	 * @model unique="false" dataType="gov.nasa.jpl.imce.oml.provenance.oti.OTI_TOOL_SPECIFIC_ID" required="true"
	 * @generated
	 */
	String getOtiID();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.provenance.oti.OML2OTIProvenance#getOtiID <em>Oti ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Oti ID</em>' attribute.
	 * @see #getOtiID()
	 * @generated
	 */
	void setOtiID(String value);

	/**
	 * Returns the value of the '<em><b>Oti URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The OTI tool-specific URL of the OTI element mapped from an OML Element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Oti URL</em>' attribute.
	 * @see #setOtiURL(String)
	 * @see gov.nasa.jpl.imce.oml.provenance.oti.OtiPackage#getOML2OTIProvenance_OtiURL()
	 * @model unique="false" dataType="gov.nasa.jpl.imce.oml.provenance.oti.OTI_TOOL_SPECIFIC_URL" required="true"
	 * @generated
	 */
	String getOtiURL();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.provenance.oti.OML2OTIProvenance#getOtiURL <em>Oti URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Oti URL</em>' attribute.
	 * @see #getOtiURL()
	 * @generated
	 */
	void setOtiURL(String value);

	/**
	 * Returns the value of the '<em><b>Oti UUID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The OTI tool-specific UUID of the OTI element mapped from an OML Element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Oti UUID</em>' attribute.
	 * @see #setOtiUUID(String)
	 * @see gov.nasa.jpl.imce.oml.provenance.oti.OtiPackage#getOML2OTIProvenance_OtiUUID()
	 * @model unique="false" dataType="gov.nasa.jpl.imce.oml.provenance.oti.OTI_TOOL_SPECIFIC_UUID"
	 * @generated
	 */
	String getOtiUUID();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.provenance.oti.OML2OTIProvenance#getOtiUUID <em>Oti UUID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Oti UUID</em>' attribute.
	 * @see #getOtiUUID()
	 * @generated
	 */
	void setOtiUUID(String value);

	/**
	 * Returns the value of the '<em><b>Explanation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Explanation of the OML to OTI provenance mapping
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Explanation</em>' attribute.
	 * @see #setExplanation(String)
	 * @see gov.nasa.jpl.imce.oml.provenance.oti.OtiPackage#getOML2OTIProvenance_Explanation()
	 * @model unique="false" required="true"
	 * @generated
	 */
	String getExplanation();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.provenance.oti.OML2OTIProvenance#getExplanation <em>Explanation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Explanation</em>' attribute.
	 * @see #getExplanation()
	 * @generated
	 */
	void setExplanation(String value);

} // OML2OTIProvenance
