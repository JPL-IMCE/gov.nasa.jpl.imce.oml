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
package gov.nasa.jpl.imce.oml.model.descriptions.provider;

import gov.nasa.jpl.imce.oml.model.common.CommonPackage;
import gov.nasa.jpl.imce.oml.model.common.Extent;

import gov.nasa.jpl.imce.oml.model.common.util.CommonSwitch;

import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsFactory;

import gov.nasa.jpl.imce.oml.model.descriptions.util.DescriptionsAdapterFactory;

import gov.nasa.jpl.imce.oml.model.edit.provider.OMLEditPlugin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.edit.command.CommandParameter;

import org.eclipse.emf.edit.domain.EditingDomain;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IChildCreationExtender;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DescriptionsItemProviderAdapterFactory extends DescriptionsAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DescriptionsItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DescriptionBoxItemProvider descriptionBoxItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDescriptionBoxAdapter() {
		if (descriptionBoxItemProvider == null) {
			descriptionBoxItemProvider = new DescriptionBoxItemProvider(this);
		}

		return descriptionBoxItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxExtendsClosedWorldDefinitions} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DescriptionBoxExtendsClosedWorldDefinitionsItemProvider descriptionBoxExtendsClosedWorldDefinitionsItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxExtendsClosedWorldDefinitions}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDescriptionBoxExtendsClosedWorldDefinitionsAdapter() {
		if (descriptionBoxExtendsClosedWorldDefinitionsItemProvider == null) {
			descriptionBoxExtendsClosedWorldDefinitionsItemProvider = new DescriptionBoxExtendsClosedWorldDefinitionsItemProvider(this);
		}

		return descriptionBoxExtendsClosedWorldDefinitionsItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxRefinement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DescriptionBoxRefinementItemProvider descriptionBoxRefinementItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxRefinement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDescriptionBoxRefinementAdapter() {
		if (descriptionBoxRefinementItemProvider == null) {
			descriptionBoxRefinementItemProvider = new DescriptionBoxRefinementItemProvider(this);
		}

		return descriptionBoxRefinementItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceScalarDataPropertyValue} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SingletonInstanceScalarDataPropertyValueItemProvider singletonInstanceScalarDataPropertyValueItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceScalarDataPropertyValue}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSingletonInstanceScalarDataPropertyValueAdapter() {
		if (singletonInstanceScalarDataPropertyValueItemProvider == null) {
			singletonInstanceScalarDataPropertyValueItemProvider = new SingletonInstanceScalarDataPropertyValueItemProvider(this);
		}

		return singletonInstanceScalarDataPropertyValueItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyValue} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SingletonInstanceStructuredDataPropertyValueItemProvider singletonInstanceStructuredDataPropertyValueItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.model.descriptions.SingletonInstanceStructuredDataPropertyValue}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSingletonInstanceStructuredDataPropertyValueAdapter() {
		if (singletonInstanceStructuredDataPropertyValueItemProvider == null) {
			singletonInstanceStructuredDataPropertyValueItemProvider = new SingletonInstanceStructuredDataPropertyValueItemProvider(this);
		}

		return singletonInstanceStructuredDataPropertyValueItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.model.descriptions.StructuredDataPropertyTuple} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StructuredDataPropertyTupleItemProvider structuredDataPropertyTupleItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.model.descriptions.StructuredDataPropertyTuple}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createStructuredDataPropertyTupleAdapter() {
		if (structuredDataPropertyTupleItemProvider == null) {
			structuredDataPropertyTupleItemProvider = new StructuredDataPropertyTupleItemProvider(this);
		}

		return structuredDataPropertyTupleItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.model.descriptions.ScalarDataPropertyValue} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScalarDataPropertyValueItemProvider scalarDataPropertyValueItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.model.descriptions.ScalarDataPropertyValue}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createScalarDataPropertyValueAdapter() {
		if (scalarDataPropertyValueItemProvider == null) {
			scalarDataPropertyValueItemProvider = new ScalarDataPropertyValueItemProvider(this);
		}

		return scalarDataPropertyValueItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.model.descriptions.ConceptInstance} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConceptInstanceItemProvider conceptInstanceItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.model.descriptions.ConceptInstance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createConceptInstanceAdapter() {
		if (conceptInstanceItemProvider == null) {
			conceptInstanceItemProvider = new ConceptInstanceItemProvider(this);
		}

		return conceptInstanceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstance} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReifiedRelationshipInstanceItemProvider reifiedRelationshipInstanceItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createReifiedRelationshipInstanceAdapter() {
		if (reifiedRelationshipInstanceItemProvider == null) {
			reifiedRelationshipInstanceItemProvider = new ReifiedRelationshipInstanceItemProvider(this);
		}

		return reifiedRelationshipInstanceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceDomain} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReifiedRelationshipInstanceDomainItemProvider reifiedRelationshipInstanceDomainItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceDomain}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createReifiedRelationshipInstanceDomainAdapter() {
		if (reifiedRelationshipInstanceDomainItemProvider == null) {
			reifiedRelationshipInstanceDomainItemProvider = new ReifiedRelationshipInstanceDomainItemProvider(this);
		}

		return reifiedRelationshipInstanceDomainItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceRange} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReifiedRelationshipInstanceRangeItemProvider reifiedRelationshipInstanceRangeItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.model.descriptions.ReifiedRelationshipInstanceRange}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createReifiedRelationshipInstanceRangeAdapter() {
		if (reifiedRelationshipInstanceRangeItemProvider == null) {
			reifiedRelationshipInstanceRangeItemProvider = new ReifiedRelationshipInstanceRangeItemProvider(this);
		}

		return reifiedRelationshipInstanceRangeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.model.descriptions.UnreifiedRelationshipInstanceTuple} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnreifiedRelationshipInstanceTupleItemProvider unreifiedRelationshipInstanceTupleItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.model.descriptions.UnreifiedRelationshipInstanceTuple}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createUnreifiedRelationshipInstanceTupleAdapter() {
		if (unreifiedRelationshipInstanceTupleItemProvider == null) {
			unreifiedRelationshipInstanceTupleItemProvider = new UnreifiedRelationshipInstanceTupleItemProvider(this);
		}

		return unreifiedRelationshipInstanceTupleItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (descriptionBoxItemProvider != null) descriptionBoxItemProvider.dispose();
		if (descriptionBoxExtendsClosedWorldDefinitionsItemProvider != null) descriptionBoxExtendsClosedWorldDefinitionsItemProvider.dispose();
		if (descriptionBoxRefinementItemProvider != null) descriptionBoxRefinementItemProvider.dispose();
		if (singletonInstanceScalarDataPropertyValueItemProvider != null) singletonInstanceScalarDataPropertyValueItemProvider.dispose();
		if (singletonInstanceStructuredDataPropertyValueItemProvider != null) singletonInstanceStructuredDataPropertyValueItemProvider.dispose();
		if (structuredDataPropertyTupleItemProvider != null) structuredDataPropertyTupleItemProvider.dispose();
		if (scalarDataPropertyValueItemProvider != null) scalarDataPropertyValueItemProvider.dispose();
		if (conceptInstanceItemProvider != null) conceptInstanceItemProvider.dispose();
		if (reifiedRelationshipInstanceItemProvider != null) reifiedRelationshipInstanceItemProvider.dispose();
		if (reifiedRelationshipInstanceDomainItemProvider != null) reifiedRelationshipInstanceDomainItemProvider.dispose();
		if (reifiedRelationshipInstanceRangeItemProvider != null) reifiedRelationshipInstanceRangeItemProvider.dispose();
		if (unreifiedRelationshipInstanceTupleItemProvider != null) unreifiedRelationshipInstanceTupleItemProvider.dispose();
	}

	/**
	 * A child creation extender for the {@link CommonPackage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static class CommonChildCreationExtender implements IChildCreationExtender {
		/**
		 * The switch for creating child descriptors specific to each extended class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		protected static class CreationSwitch extends CommonSwitch<Object> {
			/**
			 * The child descriptors being populated.
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			protected List<Object> newChildDescriptors;

			/**
			 * The domain in which to create the children.
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			protected EditingDomain editingDomain;

			/**
			 * Creates the a switch for populating child descriptors in the given domain.
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			CreationSwitch(List<Object> newChildDescriptors, EditingDomain editingDomain) {
				this.newChildDescriptors = newChildDescriptors;
				this.editingDomain = editingDomain;
			}
			/**
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			@Override
			public Object caseExtent(Extent object) {
				newChildDescriptors.add
					(createChildParameter
						(CommonPackage.Literals.EXTENT__MODULES,
						 DescriptionsFactory.eINSTANCE.createDescriptionBox()));

				return null;
			}
 
			/**
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			protected CommandParameter createChildParameter(Object feature, Object child) {
				return new CommandParameter(null, feature, child);
			}

		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public Collection<Object> getNewChildDescriptors(Object object, EditingDomain editingDomain) {
			ArrayList<Object> result = new ArrayList<Object>();
			new CreationSwitch(result, editingDomain).doSwitch((EObject)object);
			return result;
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public ResourceLocator getResourceLocator() {
			return OMLEditPlugin.INSTANCE;
		}
	}

}
