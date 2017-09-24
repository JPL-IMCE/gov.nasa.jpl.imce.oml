/**
 */
package gov.nasa.jpl.imce.oml.model.graphs.impl;

import gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions;

import gov.nasa.jpl.imce.oml.model.graphs.ConceptDesignationTerminologyAxiom;
import gov.nasa.jpl.imce.oml.model.graphs.GraphsPackage;
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyGraph;

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
 * An implementation of the model object '<em><b>Concept Designation Terminology Axiom</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.graphs.impl.ConceptDesignationTerminologyAxiomImpl#getDesignatedTerminology <em>Designated Terminology</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.graphs.impl.ConceptDesignationTerminologyAxiomImpl#getDesignatedConcept <em>Designated Concept</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConceptDesignationTerminologyAxiomImpl extends TerminologyBoxAxiomImpl implements ConceptDesignationTerminologyAxiom {
	/**
	 * The cached value of the '{@link #getDesignatedTerminology() <em>Designated Terminology</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDesignatedTerminology()
	 * @generated
	 * @ordered
	 */
	protected TerminologyBox designatedTerminology;

	/**
	 * The cached value of the '{@link #getDesignatedConcept() <em>Designated Concept</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDesignatedConcept()
	 * @generated
	 * @ordered
	 */
	protected Concept designatedConcept;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConceptDesignationTerminologyAxiomImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphsPackage.Literals.CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminologyBox getDesignatedTerminology() {
		if (designatedTerminology != null && designatedTerminology.eIsProxy()) {
			InternalEObject oldDesignatedTerminology = (InternalEObject)designatedTerminology;
			designatedTerminology = (TerminologyBox)eResolveProxy(oldDesignatedTerminology);
			if (designatedTerminology != oldDesignatedTerminology) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphsPackage.CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM__DESIGNATED_TERMINOLOGY, oldDesignatedTerminology, designatedTerminology));
			}
		}
		return designatedTerminology;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminologyBox basicGetDesignatedTerminology() {
		return designatedTerminology;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDesignatedTerminology(TerminologyBox newDesignatedTerminology) {
		TerminologyBox oldDesignatedTerminology = designatedTerminology;
		designatedTerminology = newDesignatedTerminology;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphsPackage.CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM__DESIGNATED_TERMINOLOGY, oldDesignatedTerminology, designatedTerminology));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Concept getDesignatedConcept() {
		if (designatedConcept != null && designatedConcept.eIsProxy()) {
			InternalEObject oldDesignatedConcept = (InternalEObject)designatedConcept;
			designatedConcept = (Concept)eResolveProxy(oldDesignatedConcept);
			if (designatedConcept != oldDesignatedConcept) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphsPackage.CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM__DESIGNATED_CONCEPT, oldDesignatedConcept, designatedConcept));
			}
		}
		return designatedConcept;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Concept basicGetDesignatedConcept() {
		return designatedConcept;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDesignatedConcept(Concept newDesignatedConcept) {
		Concept oldDesignatedConcept = designatedConcept;
		designatedConcept = newDesignatedConcept;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphsPackage.CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM__DESIGNATED_CONCEPT, oldDesignatedConcept, designatedConcept));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminologyGraph designationTerminologyGraph() {
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
		return this.designationTerminologyGraph();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminologyBox target() {
		return this.getDesignatedTerminology();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String uuid() {
		String _string = this.getTbox().uuid().toString();
		Pair<String, String> _mappedTo = Pair.<String, String>of("tbox", _string);
		Concept _designatedConcept = this.getDesignatedConcept();
		String _uuid = null;
		if (_designatedConcept!=null) {
			_uuid=_designatedConcept.uuid();
		}
		String _string_1 = null;
		if (_uuid!=null) {
			_string_1=_uuid.toString();
		}
		Pair<String, String> _mappedTo_1 = Pair.<String, String>of("designatedConcept", _string_1);
		TerminologyBox _designatedTerminology = this.getDesignatedTerminology();
		String _uuid_1 = null;
		if (_designatedTerminology!=null) {
			_uuid_1=_designatedTerminology.uuid();
		}
		String _string_2 = null;
		if (_uuid_1!=null) {
			_string_2=_uuid_1.toString();
		}
		Pair<String, String> _mappedTo_2 = Pair.<String, String>of("designatedTerminology", _string_2);
		UUID _derivedUUID = OMLExtensions.derivedUUID(
			"ConceptDesignationTerminologyAxiom", _mappedTo, _mappedTo_1, _mappedTo_2);
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
			case GraphsPackage.CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM__DESIGNATED_TERMINOLOGY:
				if (resolve) return getDesignatedTerminology();
				return basicGetDesignatedTerminology();
			case GraphsPackage.CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM__DESIGNATED_CONCEPT:
				if (resolve) return getDesignatedConcept();
				return basicGetDesignatedConcept();
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
			case GraphsPackage.CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM__DESIGNATED_TERMINOLOGY:
				setDesignatedTerminology((TerminologyBox)newValue);
				return;
			case GraphsPackage.CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM__DESIGNATED_CONCEPT:
				setDesignatedConcept((Concept)newValue);
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
			case GraphsPackage.CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM__DESIGNATED_TERMINOLOGY:
				setDesignatedTerminology((TerminologyBox)null);
				return;
			case GraphsPackage.CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM__DESIGNATED_CONCEPT:
				setDesignatedConcept((Concept)null);
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
			case GraphsPackage.CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM__DESIGNATED_TERMINOLOGY:
				return designatedTerminology != null;
			case GraphsPackage.CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM__DESIGNATED_CONCEPT:
				return designatedConcept != null;
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
			case GraphsPackage.CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM___DESIGNATION_TERMINOLOGY_GRAPH:
				return designationTerminologyGraph();
			case GraphsPackage.CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM___SOURCE:
				return source();
			case GraphsPackage.CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM___TARGET:
				return target();
			case GraphsPackage.CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM___UUID:
				return uuid();
		}
		return super.eInvoke(operationID, arguments);
	}

} //ConceptDesignationTerminologyAxiomImpl
