/**
 */
package gov.nasa.jpl.imce.oml.model.graphs.impl;

import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions;

import gov.nasa.jpl.imce.oml.model.graphs.GraphsPackage;
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyGraph;
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyNestingAxiom;

import gov.nasa.jpl.imce.oml.model.terminologies.Concept;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox;

import gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologyBoxAxiomImpl;

import java.lang.reflect.InvocationTargetException;

import java.util.UUID;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.xbase.lib.Pair;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Terminology Nesting Axiom</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.graphs.impl.TerminologyNestingAxiomImpl#getNestingTerminology <em>Nesting Terminology</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.graphs.impl.TerminologyNestingAxiomImpl#getNestingContext <em>Nesting Context</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TerminologyNestingAxiomImpl extends TerminologyBoxAxiomImpl implements TerminologyNestingAxiom {
	/**
	 * The cached value of the '{@link #getNestingTerminology() <em>Nesting Terminology</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNestingTerminology()
	 * @generated
	 * @ordered
	 */
	protected TerminologyBox nestingTerminology;

	/**
	 * The cached value of the '{@link #getNestingContext() <em>Nesting Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNestingContext()
	 * @generated
	 * @ordered
	 */
	protected Concept nestingContext;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TerminologyNestingAxiomImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphsPackage.Literals.TERMINOLOGY_NESTING_AXIOM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminologyBox getNestingTerminology() {
		if (nestingTerminology != null && nestingTerminology.eIsProxy()) {
			InternalEObject oldNestingTerminology = (InternalEObject)nestingTerminology;
			nestingTerminology = (TerminologyBox)eResolveProxy(oldNestingTerminology);
			if (nestingTerminology != oldNestingTerminology) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphsPackage.TERMINOLOGY_NESTING_AXIOM__NESTING_TERMINOLOGY, oldNestingTerminology, nestingTerminology));
			}
		}
		return nestingTerminology;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminologyBox basicGetNestingTerminology() {
		return nestingTerminology;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNestingTerminology(TerminologyBox newNestingTerminology) {
		TerminologyBox oldNestingTerminology = nestingTerminology;
		nestingTerminology = newNestingTerminology;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphsPackage.TERMINOLOGY_NESTING_AXIOM__NESTING_TERMINOLOGY, oldNestingTerminology, nestingTerminology));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Concept getNestingContext() {
		if (nestingContext != null && nestingContext.eIsProxy()) {
			InternalEObject oldNestingContext = (InternalEObject)nestingContext;
			nestingContext = (Concept)eResolveProxy(oldNestingContext);
			if (nestingContext != oldNestingContext) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphsPackage.TERMINOLOGY_NESTING_AXIOM__NESTING_CONTEXT, oldNestingContext, nestingContext));
			}
		}
		return nestingContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Concept basicGetNestingContext() {
		return nestingContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNestingContext(Concept newNestingContext) {
		Concept oldNestingContext = nestingContext;
		nestingContext = newNestingContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphsPackage.TERMINOLOGY_NESTING_AXIOM__NESTING_CONTEXT, oldNestingContext, nestingContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminologyGraph nestedTerminology() {
		TerminologyGraph _switchResult = null;
		TerminologyBox _tbox = this.getTbox();
		boolean _matched = false;
		if (_tbox instanceof TerminologyGraph) {
			_matched=true;
			_switchResult = TerminologyGraph.class.cast(this.getTbox());
		}
		if (!_matched) {
			_switchResult = null;
		}
		return _switchResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminologyBox source() {
		return this.nestedTerminology();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminologyBox target() {
		return this.getNestingTerminology();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String uuid() {
		String _string = this.getTbox().uuid().toString();
		Pair<String, String> _mappedTo = Pair.<String, String>of("tbox", _string);
		TerminologyBox _nestingTerminology = this.getNestingTerminology();
		String _uuid = null;
		if (_nestingTerminology!=null) {
			_uuid=_nestingTerminology.uuid();
		}
		String _string_1 = null;
		if (_uuid!=null) {
			_string_1=_uuid.toString();
		}
		Pair<String, String> _mappedTo_1 = Pair.<String, String>of("nestingTerminology", _string_1);
		Concept _nestingContext = this.getNestingContext();
		String _uuid_1 = null;
		if (_nestingContext!=null) {
			_uuid_1=_nestingContext.uuid();
		}
		String _string_2 = null;
		if (_uuid_1!=null) {
			_string_2=_uuid_1.toString();
		}
		Pair<String, String> _mappedTo_2 = Pair.<String, String>of("nestingContext", _string_2);
		UUID _derivedUUID = OMLExtensions.derivedUUID(
			"TerminologyNestingAxiom", _mappedTo, _mappedTo_1, _mappedTo_2);
		String _string_3 = null;
		if (_derivedUUID!=null) {
			_string_3=_derivedUUID.toString();
		}
		return _string_3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GraphsPackage.TERMINOLOGY_NESTING_AXIOM__NESTING_TERMINOLOGY:
				if (resolve) return getNestingTerminology();
				return basicGetNestingTerminology();
			case GraphsPackage.TERMINOLOGY_NESTING_AXIOM__NESTING_CONTEXT:
				if (resolve) return getNestingContext();
				return basicGetNestingContext();
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
			case GraphsPackage.TERMINOLOGY_NESTING_AXIOM__NESTING_TERMINOLOGY:
				setNestingTerminology((TerminologyBox)newValue);
				return;
			case GraphsPackage.TERMINOLOGY_NESTING_AXIOM__NESTING_CONTEXT:
				setNestingContext((Concept)newValue);
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
			case GraphsPackage.TERMINOLOGY_NESTING_AXIOM__NESTING_TERMINOLOGY:
				setNestingTerminology((TerminologyBox)null);
				return;
			case GraphsPackage.TERMINOLOGY_NESTING_AXIOM__NESTING_CONTEXT:
				setNestingContext((Concept)null);
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
			case GraphsPackage.TERMINOLOGY_NESTING_AXIOM__NESTING_TERMINOLOGY:
				return nestingTerminology != null;
			case GraphsPackage.TERMINOLOGY_NESTING_AXIOM__NESTING_CONTEXT:
				return nestingContext != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case GraphsPackage.TERMINOLOGY_NESTING_AXIOM___NESTED_TERMINOLOGY:
				return nestedTerminology();
			case GraphsPackage.TERMINOLOGY_NESTING_AXIOM___SOURCE:
				return source();
			case GraphsPackage.TERMINOLOGY_NESTING_AXIOM___TARGET:
				return target();
			case GraphsPackage.TERMINOLOGY_NESTING_AXIOM___UUID:
				return uuid();
		}
		return super.eInvoke(operationID, arguments);
	}

} //TerminologyNestingAxiomImpl
