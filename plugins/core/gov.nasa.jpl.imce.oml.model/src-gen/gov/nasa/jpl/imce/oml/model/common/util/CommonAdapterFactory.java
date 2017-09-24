/**
 */
package gov.nasa.jpl.imce.oml.model.common.util;

import gov.nasa.jpl.imce.oml.model.common.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see gov.nasa.jpl.imce.oml.model.common.CommonPackage
 * @generated
 */
public class CommonAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CommonPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommonAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = CommonPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CommonSwitch<Adapter> modelSwitch =
		new CommonSwitch<Adapter>() {
			@Override
			public Adapter caseLiteralValue(LiteralValue object) {
				return createLiteralValueAdapter();
			}
			@Override
			public Adapter caseLiteralBoolean(LiteralBoolean object) {
				return createLiteralBooleanAdapter();
			}
			@Override
			public Adapter caseLiteralDateTime(LiteralDateTime object) {
				return createLiteralDateTimeAdapter();
			}
			@Override
			public Adapter caseLiteralString(LiteralString object) {
				return createLiteralStringAdapter();
			}
			@Override
			public Adapter caseLiteralUUID(LiteralUUID object) {
				return createLiteralUUIDAdapter();
			}
			@Override
			public Adapter caseLiteralURI(LiteralURI object) {
				return createLiteralURIAdapter();
			}
			@Override
			public Adapter caseLiteralNumber(LiteralNumber object) {
				return createLiteralNumberAdapter();
			}
			@Override
			public Adapter caseLiteralReal(LiteralReal object) {
				return createLiteralRealAdapter();
			}
			@Override
			public Adapter caseLiteralRational(LiteralRational object) {
				return createLiteralRationalAdapter();
			}
			@Override
			public Adapter caseLiteralFloat(LiteralFloat object) {
				return createLiteralFloatAdapter();
			}
			@Override
			public Adapter caseLiteralDecimal(LiteralDecimal object) {
				return createLiteralDecimalAdapter();
			}
			@Override
			public Adapter caseAnnotationPropertyValue(AnnotationPropertyValue object) {
				return createAnnotationPropertyValueAdapter();
			}
			@Override
			public Adapter caseElement(Element object) {
				return createElementAdapter();
			}
			@Override
			public Adapter caseResource(Resource object) {
				return createResourceAdapter();
			}
			@Override
			public Adapter caseModuleElement(ModuleElement object) {
				return createModuleElementAdapter();
			}
			@Override
			public Adapter caseModuleEdge(ModuleEdge object) {
				return createModuleEdgeAdapter();
			}
			@Override
			public Adapter caseAnnotationProperty(AnnotationProperty object) {
				return createAnnotationPropertyAdapter();
			}
			@Override
			public Adapter caseExtent(Extent object) {
				return createExtentAdapter();
			}
			@Override
			public Adapter caseModule(Module object) {
				return createModuleAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.common.LiteralValue <em>Literal Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralValue
	 * @generated
	 */
	public Adapter createLiteralValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.common.LiteralBoolean <em>Literal Boolean</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralBoolean
	 * @generated
	 */
	public Adapter createLiteralBooleanAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.common.LiteralDateTime <em>Literal Date Time</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralDateTime
	 * @generated
	 */
	public Adapter createLiteralDateTimeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.common.LiteralString <em>Literal String</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralString
	 * @generated
	 */
	public Adapter createLiteralStringAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.common.LiteralUUID <em>Literal UUID</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralUUID
	 * @generated
	 */
	public Adapter createLiteralUUIDAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.common.LiteralURI <em>Literal URI</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralURI
	 * @generated
	 */
	public Adapter createLiteralURIAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.common.LiteralNumber <em>Literal Number</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralNumber
	 * @generated
	 */
	public Adapter createLiteralNumberAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.common.LiteralReal <em>Literal Real</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralReal
	 * @generated
	 */
	public Adapter createLiteralRealAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.common.LiteralRational <em>Literal Rational</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralRational
	 * @generated
	 */
	public Adapter createLiteralRationalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.common.LiteralFloat <em>Literal Float</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralFloat
	 * @generated
	 */
	public Adapter createLiteralFloatAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.common.LiteralDecimal <em>Literal Decimal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.common.LiteralDecimal
	 * @generated
	 */
	public Adapter createLiteralDecimalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.common.AnnotationPropertyValue <em>Annotation Property Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.common.AnnotationPropertyValue
	 * @generated
	 */
	public Adapter createAnnotationPropertyValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.common.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.common.Element
	 * @generated
	 */
	public Adapter createElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.common.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.common.Resource
	 * @generated
	 */
	public Adapter createResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.common.ModuleElement <em>Module Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.common.ModuleElement
	 * @generated
	 */
	public Adapter createModuleElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.common.ModuleEdge <em>Module Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.common.ModuleEdge
	 * @generated
	 */
	public Adapter createModuleEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.common.AnnotationProperty <em>Annotation Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.common.AnnotationProperty
	 * @generated
	 */
	public Adapter createAnnotationPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.common.Extent <em>Extent</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.common.Extent
	 * @generated
	 */
	public Adapter createExtentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gov.nasa.jpl.imce.oml.model.common.Module <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gov.nasa.jpl.imce.oml.model.common.Module
	 * @generated
	 */
	public Adapter createModuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //CommonAdapterFactory
