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
package gov.nasa.jpl.imce.oml.model.terminologies.impl;

import gov.nasa.jpl.imce.oml.model.terminologies.CharacterizedEntityRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Characterized Entity Relationship</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.CharacterizedEntityRelationshipImpl#isIsFunctional <em>Is Functional</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.CharacterizedEntityRelationshipImpl#isIsInverseFunctional <em>Is Inverse Functional</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.CharacterizedEntityRelationshipImpl#isIsEssential <em>Is Essential</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.CharacterizedEntityRelationshipImpl#isIsInverseEssential <em>Is Inverse Essential</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.CharacterizedEntityRelationshipImpl#isIsSymmetric <em>Is Symmetric</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.CharacterizedEntityRelationshipImpl#isIsAsymmetric <em>Is Asymmetric</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.CharacterizedEntityRelationshipImpl#isIsReflexive <em>Is Reflexive</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.CharacterizedEntityRelationshipImpl#isIsIrreflexive <em>Is Irreflexive</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.CharacterizedEntityRelationshipImpl#isIsTransitive <em>Is Transitive</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class CharacterizedEntityRelationshipImpl extends EntityRelationshipImpl implements CharacterizedEntityRelationship {
	/**
	 * The default value of the '{@link #isIsFunctional() <em>Is Functional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsFunctional()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_FUNCTIONAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsFunctional() <em>Is Functional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsFunctional()
	 * @generated
	 * @ordered
	 */
	protected boolean isFunctional = IS_FUNCTIONAL_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsInverseFunctional() <em>Is Inverse Functional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsInverseFunctional()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_INVERSE_FUNCTIONAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsInverseFunctional() <em>Is Inverse Functional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsInverseFunctional()
	 * @generated
	 * @ordered
	 */
	protected boolean isInverseFunctional = IS_INVERSE_FUNCTIONAL_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsEssential() <em>Is Essential</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsEssential()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ESSENTIAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsEssential() <em>Is Essential</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsEssential()
	 * @generated
	 * @ordered
	 */
	protected boolean isEssential = IS_ESSENTIAL_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsInverseEssential() <em>Is Inverse Essential</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsInverseEssential()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_INVERSE_ESSENTIAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsInverseEssential() <em>Is Inverse Essential</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsInverseEssential()
	 * @generated
	 * @ordered
	 */
	protected boolean isInverseEssential = IS_INVERSE_ESSENTIAL_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsSymmetric() <em>Is Symmetric</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsSymmetric()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_SYMMETRIC_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsSymmetric() <em>Is Symmetric</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsSymmetric()
	 * @generated
	 * @ordered
	 */
	protected boolean isSymmetric = IS_SYMMETRIC_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsAsymmetric() <em>Is Asymmetric</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsAsymmetric()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ASYMMETRIC_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsAsymmetric() <em>Is Asymmetric</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsAsymmetric()
	 * @generated
	 * @ordered
	 */
	protected boolean isAsymmetric = IS_ASYMMETRIC_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsReflexive() <em>Is Reflexive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsReflexive()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_REFLEXIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsReflexive() <em>Is Reflexive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsReflexive()
	 * @generated
	 * @ordered
	 */
	protected boolean isReflexive = IS_REFLEXIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsIrreflexive() <em>Is Irreflexive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsIrreflexive()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_IRREFLEXIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsIrreflexive() <em>Is Irreflexive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsIrreflexive()
	 * @generated
	 * @ordered
	 */
	protected boolean isIrreflexive = IS_IRREFLEXIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsTransitive() <em>Is Transitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsTransitive()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_TRANSITIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsTransitive() <em>Is Transitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsTransitive()
	 * @generated
	 * @ordered
	 */
	protected boolean isTransitive = IS_TRANSITIVE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CharacterizedEntityRelationshipImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TerminologiesPackage.Literals.CHARACTERIZED_ENTITY_RELATIONSHIP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsFunctional() {
		return isFunctional;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsFunctional(boolean newIsFunctional) {
		boolean oldIsFunctional = isFunctional;
		isFunctional = newIsFunctional;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_FUNCTIONAL, oldIsFunctional, isFunctional));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsInverseFunctional() {
		return isInverseFunctional;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsInverseFunctional(boolean newIsInverseFunctional) {
		boolean oldIsInverseFunctional = isInverseFunctional;
		isInverseFunctional = newIsInverseFunctional;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_INVERSE_FUNCTIONAL, oldIsInverseFunctional, isInverseFunctional));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsEssential() {
		return isEssential;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsEssential(boolean newIsEssential) {
		boolean oldIsEssential = isEssential;
		isEssential = newIsEssential;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_ESSENTIAL, oldIsEssential, isEssential));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsInverseEssential() {
		return isInverseEssential;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsInverseEssential(boolean newIsInverseEssential) {
		boolean oldIsInverseEssential = isInverseEssential;
		isInverseEssential = newIsInverseEssential;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_INVERSE_ESSENTIAL, oldIsInverseEssential, isInverseEssential));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsSymmetric() {
		return isSymmetric;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsSymmetric(boolean newIsSymmetric) {
		boolean oldIsSymmetric = isSymmetric;
		isSymmetric = newIsSymmetric;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_SYMMETRIC, oldIsSymmetric, isSymmetric));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsAsymmetric() {
		return isAsymmetric;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsAsymmetric(boolean newIsAsymmetric) {
		boolean oldIsAsymmetric = isAsymmetric;
		isAsymmetric = newIsAsymmetric;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_ASYMMETRIC, oldIsAsymmetric, isAsymmetric));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsReflexive() {
		return isReflexive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsReflexive(boolean newIsReflexive) {
		boolean oldIsReflexive = isReflexive;
		isReflexive = newIsReflexive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_REFLEXIVE, oldIsReflexive, isReflexive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsIrreflexive() {
		return isIrreflexive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsIrreflexive(boolean newIsIrreflexive) {
		boolean oldIsIrreflexive = isIrreflexive;
		isIrreflexive = newIsIrreflexive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_IRREFLEXIVE, oldIsIrreflexive, isIrreflexive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsTransitive() {
		return isTransitive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsTransitive(boolean newIsTransitive) {
		boolean oldIsTransitive = isTransitive;
		isTransitive = newIsTransitive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_TRANSITIVE, oldIsTransitive, isTransitive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_FUNCTIONAL:
				return isIsFunctional();
			case TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_INVERSE_FUNCTIONAL:
				return isIsInverseFunctional();
			case TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_ESSENTIAL:
				return isIsEssential();
			case TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_INVERSE_ESSENTIAL:
				return isIsInverseEssential();
			case TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_SYMMETRIC:
				return isIsSymmetric();
			case TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_ASYMMETRIC:
				return isIsAsymmetric();
			case TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_REFLEXIVE:
				return isIsReflexive();
			case TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_IRREFLEXIVE:
				return isIsIrreflexive();
			case TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_TRANSITIVE:
				return isIsTransitive();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_FUNCTIONAL:
				setIsFunctional((Boolean)newValue);
				return;
			case TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_INVERSE_FUNCTIONAL:
				setIsInverseFunctional((Boolean)newValue);
				return;
			case TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_ESSENTIAL:
				setIsEssential((Boolean)newValue);
				return;
			case TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_INVERSE_ESSENTIAL:
				setIsInverseEssential((Boolean)newValue);
				return;
			case TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_SYMMETRIC:
				setIsSymmetric((Boolean)newValue);
				return;
			case TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_ASYMMETRIC:
				setIsAsymmetric((Boolean)newValue);
				return;
			case TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_REFLEXIVE:
				setIsReflexive((Boolean)newValue);
				return;
			case TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_IRREFLEXIVE:
				setIsIrreflexive((Boolean)newValue);
				return;
			case TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_TRANSITIVE:
				setIsTransitive((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_FUNCTIONAL:
				setIsFunctional(IS_FUNCTIONAL_EDEFAULT);
				return;
			case TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_INVERSE_FUNCTIONAL:
				setIsInverseFunctional(IS_INVERSE_FUNCTIONAL_EDEFAULT);
				return;
			case TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_ESSENTIAL:
				setIsEssential(IS_ESSENTIAL_EDEFAULT);
				return;
			case TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_INVERSE_ESSENTIAL:
				setIsInverseEssential(IS_INVERSE_ESSENTIAL_EDEFAULT);
				return;
			case TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_SYMMETRIC:
				setIsSymmetric(IS_SYMMETRIC_EDEFAULT);
				return;
			case TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_ASYMMETRIC:
				setIsAsymmetric(IS_ASYMMETRIC_EDEFAULT);
				return;
			case TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_REFLEXIVE:
				setIsReflexive(IS_REFLEXIVE_EDEFAULT);
				return;
			case TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_IRREFLEXIVE:
				setIsIrreflexive(IS_IRREFLEXIVE_EDEFAULT);
				return;
			case TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_TRANSITIVE:
				setIsTransitive(IS_TRANSITIVE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_FUNCTIONAL:
				return isFunctional != IS_FUNCTIONAL_EDEFAULT;
			case TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_INVERSE_FUNCTIONAL:
				return isInverseFunctional != IS_INVERSE_FUNCTIONAL_EDEFAULT;
			case TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_ESSENTIAL:
				return isEssential != IS_ESSENTIAL_EDEFAULT;
			case TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_INVERSE_ESSENTIAL:
				return isInverseEssential != IS_INVERSE_ESSENTIAL_EDEFAULT;
			case TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_SYMMETRIC:
				return isSymmetric != IS_SYMMETRIC_EDEFAULT;
			case TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_ASYMMETRIC:
				return isAsymmetric != IS_ASYMMETRIC_EDEFAULT;
			case TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_REFLEXIVE:
				return isReflexive != IS_REFLEXIVE_EDEFAULT;
			case TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_IRREFLEXIVE:
				return isIrreflexive != IS_IRREFLEXIVE_EDEFAULT;
			case TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_TRANSITIVE:
				return isTransitive != IS_TRANSITIVE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (isFunctional: ");
		result.append(isFunctional);
		result.append(", isInverseFunctional: ");
		result.append(isInverseFunctional);
		result.append(", isEssential: ");
		result.append(isEssential);
		result.append(", isInverseEssential: ");
		result.append(isInverseEssential);
		result.append(", isSymmetric: ");
		result.append(isSymmetric);
		result.append(", isAsymmetric: ");
		result.append(isAsymmetric);
		result.append(", isReflexive: ");
		result.append(isReflexive);
		result.append(", isIrreflexive: ");
		result.append(isIrreflexive);
		result.append(", isTransitive: ");
		result.append(isTransitive);
		result.append(')');
		return result.toString();
	}

} //CharacterizedEntityRelationshipImpl
