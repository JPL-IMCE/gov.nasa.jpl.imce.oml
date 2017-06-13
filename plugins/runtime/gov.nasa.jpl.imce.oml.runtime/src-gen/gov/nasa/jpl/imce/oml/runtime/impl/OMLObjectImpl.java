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
package gov.nasa.jpl.imce.oml.runtime.impl;

import com.google.common.collect.Iterables;

import gov.nasa.jpl.imce.oml.runtime.OMLObject;
import gov.nasa.jpl.imce.oml.runtime.OMLRuntimePackage;

import java.lang.Iterable;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.EStructuralFeature.Setting;

import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;

import org.eclipse.emf.ecore.util.EcoreUtil.UsageCrossReferencer;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import org.eclipse.xtext.xbase.lib.Functions.Function1;

import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>OML Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class OMLObjectImpl extends CDOObjectImpl implements OMLObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OMLObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OMLRuntimePackage.Literals.OML_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T extends OMLObject> EList<T> omlInverseReferencers(final Class<T> aType) {
		EList<T> _xblockexpression = null;
		{
			final ResourceSet resourceSet = this.eResource().getResourceSet();
			final Iterable<ECrossReferenceAdapter> adapters = Iterables.<ECrossReferenceAdapter>filter(resourceSet.eAdapters(), ECrossReferenceAdapter.class);
			EList<T> _xifexpression = null;
			boolean _isEmpty = IterableExtensions.isEmpty(adapters);
			if (_isEmpty) {
				EList<T> _xblockexpression_1 = null;
				{
					final Collection<Setting> references = UsageCrossReferencer.find(this, resourceSet);
					final Function1<Setting, EObject> _function = new Function1<Setting, EObject>() {
						public EObject apply(final Setting it) {
							return it.getEObject();
						}
					};
					_xblockexpression_1 = ECollections.<T>asEList(((T[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(Iterables.<T>filter(IterableExtensions.<Setting, EObject>map(references, _function), aType), OMLObject.class)));
				}
				_xifexpression = _xblockexpression_1;
			}
			else {
				_xifexpression = ECollections.<T>asEList(((T[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(Iterables.<T>filter(((ECrossReferenceAdapter[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(adapters, ECrossReferenceAdapter.class))[0].getInverseReferences(this), aType), OMLObject.class)));
			}
			_xblockexpression = _xifexpression;
		}
		return _xblockexpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings({"rawtypes", "unchecked" })
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case OMLRuntimePackage.OML_OBJECT___OML_INVERSE_REFERENCERS__CLASS:
				return omlInverseReferencers((Class)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

} //OMLObjectImpl
