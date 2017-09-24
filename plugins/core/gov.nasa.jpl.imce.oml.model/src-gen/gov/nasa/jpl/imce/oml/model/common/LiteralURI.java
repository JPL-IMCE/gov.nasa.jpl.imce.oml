/**
 */
package gov.nasa.jpl.imce.oml.model.common;

import gov.nasa.jpl.imce.oml.model.datatypes.URIValue;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Literal URI</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.common.LiteralURI#getUri <em>Uri</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.common.CommonPackage#getLiteralURI()
 * @model
 * @generated
 */
public interface LiteralURI extends LiteralValue {
	/**
	 * Returns the value of the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uri</em>' attribute.
	 * @see #setUri(URIValue)
	 * @see gov.nasa.jpl.imce.oml.model.common.CommonPackage#getLiteralURI_Uri()
	 * @model unique="false" dataType="gov.nasa.jpl.imce.oml.model.common.URIDataType" required="true"
	 * @generated
	 */
	URIValue getUri();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.common.LiteralURI#getUri <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri</em>' attribute.
	 * @see #getUri()
	 * @generated
	 */
	void setUri(URIValue value);

} // LiteralURI
