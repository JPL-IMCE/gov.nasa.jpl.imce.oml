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

import gov.nasa.jpl.imce.oml.model.common.CommonPackage;
import gov.nasa.jpl.imce.oml.model.common.LogicalElement;
import gov.nasa.jpl.imce.oml.model.common.ModuleElement;

import gov.nasa.jpl.imce.oml.model.terminologies.CharacterizedEntityRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.ConceptualRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.Entity;
import gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.ForwardProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.InverseProperty;
import gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship;
import gov.nasa.jpl.imce.oml.model.terminologies.Term;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reified Relationship</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.ReifiedRelationshipImpl#isIsFunctional <em>Is Functional</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.ReifiedRelationshipImpl#isIsInverseFunctional <em>Is Inverse Functional</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.ReifiedRelationshipImpl#isIsEssential <em>Is Essential</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.ReifiedRelationshipImpl#isIsInverseEssential <em>Is Inverse Essential</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.ReifiedRelationshipImpl#isIsSymmetric <em>Is Symmetric</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.ReifiedRelationshipImpl#isIsAsymmetric <em>Is Asymmetric</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.ReifiedRelationshipImpl#isIsReflexive <em>Is Reflexive</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.ReifiedRelationshipImpl#isIsIrreflexive <em>Is Irreflexive</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.ReifiedRelationshipImpl#isIsTransitive <em>Is Transitive</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.ReifiedRelationshipImpl#getForwardProperty <em>Forward Property</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.ReifiedRelationshipImpl#getInverseProperty <em>Inverse Property</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.ReifiedRelationshipImpl#getSource <em>Source</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.impl.ReifiedRelationshipImpl#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReifiedRelationshipImpl extends ConceptualRelationshipImpl implements ReifiedRelationship {
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
	 * The cached value of the '{@link #getForwardProperty() <em>Forward Property</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForwardProperty()
	 * @generated
	 * @ordered
	 */
	protected ForwardProperty forwardProperty;

	/**
	 * The cached value of the '{@link #getInverseProperty() <em>Inverse Property</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInverseProperty()
	 * @generated
	 * @ordered
	 */
	protected InverseProperty inverseProperty;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected Entity source;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected Entity target;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReifiedRelationshipImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TerminologiesPackage.Literals.REIFIED_RELATIONSHIP;
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
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.REIFIED_RELATIONSHIP__IS_FUNCTIONAL, oldIsFunctional, isFunctional));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.REIFIED_RELATIONSHIP__IS_INVERSE_FUNCTIONAL, oldIsInverseFunctional, isInverseFunctional));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.REIFIED_RELATIONSHIP__IS_ESSENTIAL, oldIsEssential, isEssential));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.REIFIED_RELATIONSHIP__IS_INVERSE_ESSENTIAL, oldIsInverseEssential, isInverseEssential));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.REIFIED_RELATIONSHIP__IS_SYMMETRIC, oldIsSymmetric, isSymmetric));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.REIFIED_RELATIONSHIP__IS_ASYMMETRIC, oldIsAsymmetric, isAsymmetric));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.REIFIED_RELATIONSHIP__IS_REFLEXIVE, oldIsReflexive, isReflexive));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.REIFIED_RELATIONSHIP__IS_IRREFLEXIVE, oldIsIrreflexive, isIrreflexive));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.REIFIED_RELATIONSHIP__IS_TRANSITIVE, oldIsTransitive, isTransitive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForwardProperty getForwardProperty() {
		return forwardProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetForwardProperty(ForwardProperty newForwardProperty, NotificationChain msgs) {
		ForwardProperty oldForwardProperty = forwardProperty;
		forwardProperty = newForwardProperty;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TerminologiesPackage.REIFIED_RELATIONSHIP__FORWARD_PROPERTY, oldForwardProperty, newForwardProperty);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setForwardProperty(ForwardProperty newForwardProperty) {
		if (newForwardProperty != forwardProperty) {
			NotificationChain msgs = null;
			if (forwardProperty != null)
				msgs = ((InternalEObject)forwardProperty).eInverseRemove(this, TerminologiesPackage.FORWARD_PROPERTY__REIFIED_RELATIONSHIP, ForwardProperty.class, msgs);
			if (newForwardProperty != null)
				msgs = ((InternalEObject)newForwardProperty).eInverseAdd(this, TerminologiesPackage.FORWARD_PROPERTY__REIFIED_RELATIONSHIP, ForwardProperty.class, msgs);
			msgs = basicSetForwardProperty(newForwardProperty, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.REIFIED_RELATIONSHIP__FORWARD_PROPERTY, newForwardProperty, newForwardProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InverseProperty getInverseProperty() {
		return inverseProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInverseProperty(InverseProperty newInverseProperty, NotificationChain msgs) {
		InverseProperty oldInverseProperty = inverseProperty;
		inverseProperty = newInverseProperty;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TerminologiesPackage.REIFIED_RELATIONSHIP__INVERSE_PROPERTY, oldInverseProperty, newInverseProperty);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInverseProperty(InverseProperty newInverseProperty) {
		if (newInverseProperty != inverseProperty) {
			NotificationChain msgs = null;
			if (inverseProperty != null)
				msgs = ((InternalEObject)inverseProperty).eInverseRemove(this, TerminologiesPackage.INVERSE_PROPERTY__REIFIED_RELATIONSHIP, InverseProperty.class, msgs);
			if (newInverseProperty != null)
				msgs = ((InternalEObject)newInverseProperty).eInverseAdd(this, TerminologiesPackage.INVERSE_PROPERTY__REIFIED_RELATIONSHIP, InverseProperty.class, msgs);
			msgs = basicSetInverseProperty(newInverseProperty, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.REIFIED_RELATIONSHIP__INVERSE_PROPERTY, newInverseProperty, newInverseProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (Entity)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TerminologiesPackage.REIFIED_RELATIONSHIP__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(Entity newSource) {
		Entity oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.REIFIED_RELATIONSHIP__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (Entity)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TerminologiesPackage.REIFIED_RELATIONSHIP__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(Entity newTarget) {
		Entity oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TerminologiesPackage.REIFIED_RELATIONSHIP__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity relationSource() {
		return this.getSource();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity relationTarget() {
		return this.getTarget();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LogicalElement> allNestedElements() {
		BasicEList<LogicalElement> _xblockexpression = null;
		{
			final BasicEList<LogicalElement> les = new BasicEList<LogicalElement>();
			les.add(this.getForwardProperty());
			InverseProperty _inverseProperty = this.getInverseProperty();
			boolean _tripleNotEquals = (null != _inverseProperty);
			if (_tripleNotEquals) {
				les.add(this.getInverseProperty());
			}
			_xblockexpression = les;
		}
		return _xblockexpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ReifiedRelationship> rootReifiedRelationships() {
		return ECollections.<ReifiedRelationship>singletonEList(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TerminologiesPackage.REIFIED_RELATIONSHIP__FORWARD_PROPERTY:
				if (forwardProperty != null)
					msgs = ((InternalEObject)forwardProperty).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TerminologiesPackage.REIFIED_RELATIONSHIP__FORWARD_PROPERTY, null, msgs);
				return basicSetForwardProperty((ForwardProperty)otherEnd, msgs);
			case TerminologiesPackage.REIFIED_RELATIONSHIP__INVERSE_PROPERTY:
				if (inverseProperty != null)
					msgs = ((InternalEObject)inverseProperty).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TerminologiesPackage.REIFIED_RELATIONSHIP__INVERSE_PROPERTY, null, msgs);
				return basicSetInverseProperty((InverseProperty)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TerminologiesPackage.REIFIED_RELATIONSHIP__FORWARD_PROPERTY:
				return basicSetForwardProperty(null, msgs);
			case TerminologiesPackage.REIFIED_RELATIONSHIP__INVERSE_PROPERTY:
				return basicSetInverseProperty(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TerminologiesPackage.REIFIED_RELATIONSHIP__IS_FUNCTIONAL:
				return isIsFunctional();
			case TerminologiesPackage.REIFIED_RELATIONSHIP__IS_INVERSE_FUNCTIONAL:
				return isIsInverseFunctional();
			case TerminologiesPackage.REIFIED_RELATIONSHIP__IS_ESSENTIAL:
				return isIsEssential();
			case TerminologiesPackage.REIFIED_RELATIONSHIP__IS_INVERSE_ESSENTIAL:
				return isIsInverseEssential();
			case TerminologiesPackage.REIFIED_RELATIONSHIP__IS_SYMMETRIC:
				return isIsSymmetric();
			case TerminologiesPackage.REIFIED_RELATIONSHIP__IS_ASYMMETRIC:
				return isIsAsymmetric();
			case TerminologiesPackage.REIFIED_RELATIONSHIP__IS_REFLEXIVE:
				return isIsReflexive();
			case TerminologiesPackage.REIFIED_RELATIONSHIP__IS_IRREFLEXIVE:
				return isIsIrreflexive();
			case TerminologiesPackage.REIFIED_RELATIONSHIP__IS_TRANSITIVE:
				return isIsTransitive();
			case TerminologiesPackage.REIFIED_RELATIONSHIP__FORWARD_PROPERTY:
				return getForwardProperty();
			case TerminologiesPackage.REIFIED_RELATIONSHIP__INVERSE_PROPERTY:
				return getInverseProperty();
			case TerminologiesPackage.REIFIED_RELATIONSHIP__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case TerminologiesPackage.REIFIED_RELATIONSHIP__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
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
			case TerminologiesPackage.REIFIED_RELATIONSHIP__IS_FUNCTIONAL:
				setIsFunctional((Boolean)newValue);
				return;
			case TerminologiesPackage.REIFIED_RELATIONSHIP__IS_INVERSE_FUNCTIONAL:
				setIsInverseFunctional((Boolean)newValue);
				return;
			case TerminologiesPackage.REIFIED_RELATIONSHIP__IS_ESSENTIAL:
				setIsEssential((Boolean)newValue);
				return;
			case TerminologiesPackage.REIFIED_RELATIONSHIP__IS_INVERSE_ESSENTIAL:
				setIsInverseEssential((Boolean)newValue);
				return;
			case TerminologiesPackage.REIFIED_RELATIONSHIP__IS_SYMMETRIC:
				setIsSymmetric((Boolean)newValue);
				return;
			case TerminologiesPackage.REIFIED_RELATIONSHIP__IS_ASYMMETRIC:
				setIsAsymmetric((Boolean)newValue);
				return;
			case TerminologiesPackage.REIFIED_RELATIONSHIP__IS_REFLEXIVE:
				setIsReflexive((Boolean)newValue);
				return;
			case TerminologiesPackage.REIFIED_RELATIONSHIP__IS_IRREFLEXIVE:
				setIsIrreflexive((Boolean)newValue);
				return;
			case TerminologiesPackage.REIFIED_RELATIONSHIP__IS_TRANSITIVE:
				setIsTransitive((Boolean)newValue);
				return;
			case TerminologiesPackage.REIFIED_RELATIONSHIP__FORWARD_PROPERTY:
				setForwardProperty((ForwardProperty)newValue);
				return;
			case TerminologiesPackage.REIFIED_RELATIONSHIP__INVERSE_PROPERTY:
				setInverseProperty((InverseProperty)newValue);
				return;
			case TerminologiesPackage.REIFIED_RELATIONSHIP__SOURCE:
				setSource((Entity)newValue);
				return;
			case TerminologiesPackage.REIFIED_RELATIONSHIP__TARGET:
				setTarget((Entity)newValue);
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
			case TerminologiesPackage.REIFIED_RELATIONSHIP__IS_FUNCTIONAL:
				setIsFunctional(IS_FUNCTIONAL_EDEFAULT);
				return;
			case TerminologiesPackage.REIFIED_RELATIONSHIP__IS_INVERSE_FUNCTIONAL:
				setIsInverseFunctional(IS_INVERSE_FUNCTIONAL_EDEFAULT);
				return;
			case TerminologiesPackage.REIFIED_RELATIONSHIP__IS_ESSENTIAL:
				setIsEssential(IS_ESSENTIAL_EDEFAULT);
				return;
			case TerminologiesPackage.REIFIED_RELATIONSHIP__IS_INVERSE_ESSENTIAL:
				setIsInverseEssential(IS_INVERSE_ESSENTIAL_EDEFAULT);
				return;
			case TerminologiesPackage.REIFIED_RELATIONSHIP__IS_SYMMETRIC:
				setIsSymmetric(IS_SYMMETRIC_EDEFAULT);
				return;
			case TerminologiesPackage.REIFIED_RELATIONSHIP__IS_ASYMMETRIC:
				setIsAsymmetric(IS_ASYMMETRIC_EDEFAULT);
				return;
			case TerminologiesPackage.REIFIED_RELATIONSHIP__IS_REFLEXIVE:
				setIsReflexive(IS_REFLEXIVE_EDEFAULT);
				return;
			case TerminologiesPackage.REIFIED_RELATIONSHIP__IS_IRREFLEXIVE:
				setIsIrreflexive(IS_IRREFLEXIVE_EDEFAULT);
				return;
			case TerminologiesPackage.REIFIED_RELATIONSHIP__IS_TRANSITIVE:
				setIsTransitive(IS_TRANSITIVE_EDEFAULT);
				return;
			case TerminologiesPackage.REIFIED_RELATIONSHIP__FORWARD_PROPERTY:
				setForwardProperty((ForwardProperty)null);
				return;
			case TerminologiesPackage.REIFIED_RELATIONSHIP__INVERSE_PROPERTY:
				setInverseProperty((InverseProperty)null);
				return;
			case TerminologiesPackage.REIFIED_RELATIONSHIP__SOURCE:
				setSource((Entity)null);
				return;
			case TerminologiesPackage.REIFIED_RELATIONSHIP__TARGET:
				setTarget((Entity)null);
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
			case TerminologiesPackage.REIFIED_RELATIONSHIP__IS_FUNCTIONAL:
				return isFunctional != IS_FUNCTIONAL_EDEFAULT;
			case TerminologiesPackage.REIFIED_RELATIONSHIP__IS_INVERSE_FUNCTIONAL:
				return isInverseFunctional != IS_INVERSE_FUNCTIONAL_EDEFAULT;
			case TerminologiesPackage.REIFIED_RELATIONSHIP__IS_ESSENTIAL:
				return isEssential != IS_ESSENTIAL_EDEFAULT;
			case TerminologiesPackage.REIFIED_RELATIONSHIP__IS_INVERSE_ESSENTIAL:
				return isInverseEssential != IS_INVERSE_ESSENTIAL_EDEFAULT;
			case TerminologiesPackage.REIFIED_RELATIONSHIP__IS_SYMMETRIC:
				return isSymmetric != IS_SYMMETRIC_EDEFAULT;
			case TerminologiesPackage.REIFIED_RELATIONSHIP__IS_ASYMMETRIC:
				return isAsymmetric != IS_ASYMMETRIC_EDEFAULT;
			case TerminologiesPackage.REIFIED_RELATIONSHIP__IS_REFLEXIVE:
				return isReflexive != IS_REFLEXIVE_EDEFAULT;
			case TerminologiesPackage.REIFIED_RELATIONSHIP__IS_IRREFLEXIVE:
				return isIrreflexive != IS_IRREFLEXIVE_EDEFAULT;
			case TerminologiesPackage.REIFIED_RELATIONSHIP__IS_TRANSITIVE:
				return isTransitive != IS_TRANSITIVE_EDEFAULT;
			case TerminologiesPackage.REIFIED_RELATIONSHIP__FORWARD_PROPERTY:
				return forwardProperty != null;
			case TerminologiesPackage.REIFIED_RELATIONSHIP__INVERSE_PROPERTY:
				return inverseProperty != null;
			case TerminologiesPackage.REIFIED_RELATIONSHIP__SOURCE:
				return source != null;
			case TerminologiesPackage.REIFIED_RELATIONSHIP__TARGET:
				return target != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == CharacterizedEntityRelationship.class) {
			switch (derivedFeatureID) {
				case TerminologiesPackage.REIFIED_RELATIONSHIP__IS_FUNCTIONAL: return TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_FUNCTIONAL;
				case TerminologiesPackage.REIFIED_RELATIONSHIP__IS_INVERSE_FUNCTIONAL: return TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_INVERSE_FUNCTIONAL;
				case TerminologiesPackage.REIFIED_RELATIONSHIP__IS_ESSENTIAL: return TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_ESSENTIAL;
				case TerminologiesPackage.REIFIED_RELATIONSHIP__IS_INVERSE_ESSENTIAL: return TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_INVERSE_ESSENTIAL;
				case TerminologiesPackage.REIFIED_RELATIONSHIP__IS_SYMMETRIC: return TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_SYMMETRIC;
				case TerminologiesPackage.REIFIED_RELATIONSHIP__IS_ASYMMETRIC: return TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_ASYMMETRIC;
				case TerminologiesPackage.REIFIED_RELATIONSHIP__IS_REFLEXIVE: return TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_REFLEXIVE;
				case TerminologiesPackage.REIFIED_RELATIONSHIP__IS_IRREFLEXIVE: return TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_IRREFLEXIVE;
				case TerminologiesPackage.REIFIED_RELATIONSHIP__IS_TRANSITIVE: return TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_TRANSITIVE;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == CharacterizedEntityRelationship.class) {
			switch (baseFeatureID) {
				case TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_FUNCTIONAL: return TerminologiesPackage.REIFIED_RELATIONSHIP__IS_FUNCTIONAL;
				case TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_INVERSE_FUNCTIONAL: return TerminologiesPackage.REIFIED_RELATIONSHIP__IS_INVERSE_FUNCTIONAL;
				case TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_ESSENTIAL: return TerminologiesPackage.REIFIED_RELATIONSHIP__IS_ESSENTIAL;
				case TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_INVERSE_ESSENTIAL: return TerminologiesPackage.REIFIED_RELATIONSHIP__IS_INVERSE_ESSENTIAL;
				case TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_SYMMETRIC: return TerminologiesPackage.REIFIED_RELATIONSHIP__IS_SYMMETRIC;
				case TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_ASYMMETRIC: return TerminologiesPackage.REIFIED_RELATIONSHIP__IS_ASYMMETRIC;
				case TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_REFLEXIVE: return TerminologiesPackage.REIFIED_RELATIONSHIP__IS_REFLEXIVE;
				case TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_IRREFLEXIVE: return TerminologiesPackage.REIFIED_RELATIONSHIP__IS_IRREFLEXIVE;
				case TerminologiesPackage.CHARACTERIZED_ENTITY_RELATIONSHIP__IS_TRANSITIVE: return TerminologiesPackage.REIFIED_RELATIONSHIP__IS_TRANSITIVE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == ModuleElement.class) {
			switch (baseOperationID) {
				case CommonPackage.MODULE_ELEMENT___ALL_NESTED_ELEMENTS: return TerminologiesPackage.REIFIED_RELATIONSHIP___ALL_NESTED_ELEMENTS;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == Term.class) {
			switch (baseOperationID) {
				case TerminologiesPackage.TERM___ALL_NESTED_ELEMENTS: return TerminologiesPackage.REIFIED_RELATIONSHIP___ALL_NESTED_ELEMENTS;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == EntityRelationship.class) {
			switch (baseOperationID) {
				case TerminologiesPackage.ENTITY_RELATIONSHIP___RELATION_SOURCE: return TerminologiesPackage.REIFIED_RELATIONSHIP___RELATION_SOURCE;
				case TerminologiesPackage.ENTITY_RELATIONSHIP___RELATION_TARGET: return TerminologiesPackage.REIFIED_RELATIONSHIP___RELATION_TARGET;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == ConceptualRelationship.class) {
			switch (baseOperationID) {
				case TerminologiesPackage.CONCEPTUAL_RELATIONSHIP___ROOT_REIFIED_RELATIONSHIPS: return TerminologiesPackage.REIFIED_RELATIONSHIP___ROOT_REIFIED_RELATIONSHIPS;
				case TerminologiesPackage.CONCEPTUAL_RELATIONSHIP___RELATION_SOURCE: return TerminologiesPackage.REIFIED_RELATIONSHIP___RELATION_SOURCE;
				case TerminologiesPackage.CONCEPTUAL_RELATIONSHIP___RELATION_TARGET: return TerminologiesPackage.REIFIED_RELATIONSHIP___RELATION_TARGET;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		if (baseClass == CharacterizedEntityRelationship.class) {
			switch (baseOperationID) {
				default: return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case TerminologiesPackage.REIFIED_RELATIONSHIP___RELATION_SOURCE:
				return relationSource();
			case TerminologiesPackage.REIFIED_RELATIONSHIP___RELATION_TARGET:
				return relationTarget();
			case TerminologiesPackage.REIFIED_RELATIONSHIP___ALL_NESTED_ELEMENTS:
				return allNestedElements();
			case TerminologiesPackage.REIFIED_RELATIONSHIP___ROOT_REIFIED_RELATIONSHIPS:
				return rootReifiedRelationships();
		}
		return super.eInvoke(operationID, arguments);
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

} //ReifiedRelationshipImpl
