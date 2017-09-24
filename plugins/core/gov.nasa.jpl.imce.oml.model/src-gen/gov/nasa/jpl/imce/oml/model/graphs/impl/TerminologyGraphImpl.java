/**
 */
package gov.nasa.jpl.imce.oml.model.graphs.impl;

import com.google.common.collect.Iterables;

import gov.nasa.jpl.imce.oml.model.common.ModuleEdge;
import gov.nasa.jpl.imce.oml.model.common.ModuleElement;

import gov.nasa.jpl.imce.oml.model.graphs.GraphsPackage;
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyGraph;

import gov.nasa.jpl.imce.oml.model.terminologies.impl.TerminologyBoxImpl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Terminology Graph</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class TerminologyGraphImpl extends TerminologyBoxImpl implements TerminologyGraph {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TerminologyGraphImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphsPackage.Literals.TERMINOLOGY_GRAPH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModuleEdge> moduleEdges() {
		return ECollections.<ModuleEdge>asEList(((ModuleEdge[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(Iterables.<ModuleEdge>filter(this.getBoxAxioms(), ModuleEdge.class), ModuleEdge.class)));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModuleElement> moduleElements() {
		BasicEList<ModuleElement> _xblockexpression = null;
		{
			final BasicEList<ModuleElement> mes = new BasicEList<ModuleElement>();
			mes.addAll(this.getBoxStatements());
			_xblockexpression = mes;
		}
		return _xblockexpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case GraphsPackage.TERMINOLOGY_GRAPH___MODULE_EDGES:
				return moduleEdges();
			case GraphsPackage.TERMINOLOGY_GRAPH___MODULE_ELEMENTS:
				return moduleElements();
		}
		return super.eInvoke(operationID, arguments);
	}

} //TerminologyGraphImpl
