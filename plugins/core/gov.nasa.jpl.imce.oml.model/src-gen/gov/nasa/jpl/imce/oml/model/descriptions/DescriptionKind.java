/**
 */
package gov.nasa.jpl.imce.oml.model.descriptions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Description Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * OML DescriptionKind specifies semantic constraints that apply to
 * an OML DescriptionBox as follows:
 * - Final: the description is intended to be well-formed with all essential information (e.g., values of `isIdentityCriteria` data properties)
 * - Partial: the description may lack some essential information (e.g., values of `isIdentityCriteria` data properties)
 * <!-- end-model-doc -->
 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage#getDescriptionKind()
 * @model
 * @generated
 */
public enum DescriptionKind implements Enumerator {
	/**
	 * The '<em><b>Final</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FINAL_VALUE
	 * @generated
	 * @ordered
	 */
	FINAL(0, "Final", "Final"),

	/**
	 * The '<em><b>Partial</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PARTIAL_VALUE
	 * @generated
	 * @ordered
	 */
	PARTIAL(0, "Partial", "Partial");

	/**
	 * The '<em><b>Final</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Final</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FINAL
	 * @model name="Final"
	 * @generated
	 * @ordered
	 */
	public static final int FINAL_VALUE = 0;

	/**
	 * The '<em><b>Partial</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Partial</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PARTIAL
	 * @model name="Partial"
	 * @generated
	 * @ordered
	 */
	public static final int PARTIAL_VALUE = 0;

	/**
	 * An array of all the '<em><b>Description Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final DescriptionKind[] VALUES_ARRAY =
		new DescriptionKind[] {
			FINAL,
			PARTIAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Description Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<DescriptionKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Description Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static DescriptionKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DescriptionKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Description Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static DescriptionKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DescriptionKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Description Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static DescriptionKind get(int value) {
		switch (value) {
			case FINAL_VALUE: return FINAL;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private DescriptionKind(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //DescriptionKind
