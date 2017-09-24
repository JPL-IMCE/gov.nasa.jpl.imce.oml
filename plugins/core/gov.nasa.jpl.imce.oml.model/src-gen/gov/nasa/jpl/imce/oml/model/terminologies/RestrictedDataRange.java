/**
 */
package gov.nasa.jpl.imce.oml.model.terminologies;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Restricted Data Range</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML RestrictedDataRange corresponds to an [OWL2 DataRange] defined
 * in terms of some kind of restriction of some other OML DataRange.
 * The specializations of OML RestrictedDataRange correspond to
 * the allowed restrictions in the [OWL2 Datatype Maps].
 * Node that the vocabulary of XSD fundamental facets is not included in OWL2-DL, consequently,
 * there is no support in OML for specifying datatype restrictions involving XSD fundamental facets as well.
 * Each specialization maps to an OWL2 Declaration of an [OWL2 Datatype] whose
 * [OWL2 DataRange] corresponds to the OWL2 mapping of that specialized restriction.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.RestrictedDataRange#getRestrictedRange <em>Restricted Range</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getRestrictedDataRange()
 * @model abstract="true"
 * @generated
 */
public interface RestrictedDataRange extends DataRange {
	/**
	 * Returns the value of the '<em><b>Restricted Range</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The restricted (general) data range of this data range (specific)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Restricted Range</em>' reference.
	 * @see #setRestrictedRange(DataRange)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getRestrictedDataRange_RestrictedRange()
	 * @model required="true"
	 * @generated
	 */
	DataRange getRestrictedRange();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.RestrictedDataRange#getRestrictedRange <em>Restricted Range</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Restricted Range</em>' reference.
	 * @see #getRestrictedRange()
	 * @generated
	 */
	void setRestrictedRange(DataRange value);

} // RestrictedDataRange
