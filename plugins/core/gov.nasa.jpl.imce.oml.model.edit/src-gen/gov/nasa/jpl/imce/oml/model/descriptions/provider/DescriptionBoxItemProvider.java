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


import gov.nasa.jpl.imce.oml.model.common.provider.ModuleItemProvider;

import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsFactory;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DescriptionBoxItemProvider extends ModuleItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DescriptionBoxItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addKindPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Kind feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addKindPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DescriptionBox_kind_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DescriptionBox_kind_feature", "_UI_DescriptionBox_type"),
				 DescriptionsPackage.Literals.DESCRIPTION_BOX__KIND,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(DescriptionsPackage.Literals.DESCRIPTION_BOX__DESCRIPTION_BOX_REFINEMENTS);
			childrenFeatures.add(DescriptionsPackage.Literals.DESCRIPTION_BOX__CLOSED_WORLD_DEFINITIONS);
			childrenFeatures.add(DescriptionsPackage.Literals.DESCRIPTION_BOX__CONCEPT_INSTANCES);
			childrenFeatures.add(DescriptionsPackage.Literals.DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCES);
			childrenFeatures.add(DescriptionsPackage.Literals.DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCE_DOMAINS);
			childrenFeatures.add(DescriptionsPackage.Literals.DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCE_RANGES);
			childrenFeatures.add(DescriptionsPackage.Literals.DESCRIPTION_BOX__UNREIFIED_RELATIONSHIP_INSTANCE_TUPLES);
			childrenFeatures.add(DescriptionsPackage.Literals.DESCRIPTION_BOX__SINGLETON_SCALAR_DATA_PROPERTY_VALUES);
			childrenFeatures.add(DescriptionsPackage.Literals.DESCRIPTION_BOX__SINGLETON_STRUCTURED_DATA_PROPERTY_VALUES);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns DescriptionBox.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/DescriptionBox"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((DescriptionBox)object).getUuid();
		return label == null || label.length() == 0 ?
			getString("_UI_DescriptionBox_type") :
			getString("_UI_DescriptionBox_type") + " " + label;
	}
	

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(DescriptionBox.class)) {
			case DescriptionsPackage.DESCRIPTION_BOX__KIND:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case DescriptionsPackage.DESCRIPTION_BOX__DESCRIPTION_BOX_REFINEMENTS:
			case DescriptionsPackage.DESCRIPTION_BOX__CLOSED_WORLD_DEFINITIONS:
			case DescriptionsPackage.DESCRIPTION_BOX__CONCEPT_INSTANCES:
			case DescriptionsPackage.DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCES:
			case DescriptionsPackage.DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCE_DOMAINS:
			case DescriptionsPackage.DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCE_RANGES:
			case DescriptionsPackage.DESCRIPTION_BOX__UNREIFIED_RELATIONSHIP_INSTANCE_TUPLES:
			case DescriptionsPackage.DESCRIPTION_BOX__SINGLETON_SCALAR_DATA_PROPERTY_VALUES:
			case DescriptionsPackage.DESCRIPTION_BOX__SINGLETON_STRUCTURED_DATA_PROPERTY_VALUES:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(DescriptionsPackage.Literals.DESCRIPTION_BOX__DESCRIPTION_BOX_REFINEMENTS,
				 DescriptionsFactory.eINSTANCE.createDescriptionBoxRefinement()));

		newChildDescriptors.add
			(createChildParameter
				(DescriptionsPackage.Literals.DESCRIPTION_BOX__CLOSED_WORLD_DEFINITIONS,
				 DescriptionsFactory.eINSTANCE.createDescriptionBoxExtendsClosedWorldDefinitions()));

		newChildDescriptors.add
			(createChildParameter
				(DescriptionsPackage.Literals.DESCRIPTION_BOX__CONCEPT_INSTANCES,
				 DescriptionsFactory.eINSTANCE.createConceptInstance()));

		newChildDescriptors.add
			(createChildParameter
				(DescriptionsPackage.Literals.DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCES,
				 DescriptionsFactory.eINSTANCE.createReifiedRelationshipInstance()));

		newChildDescriptors.add
			(createChildParameter
				(DescriptionsPackage.Literals.DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCE_DOMAINS,
				 DescriptionsFactory.eINSTANCE.createReifiedRelationshipInstanceDomain()));

		newChildDescriptors.add
			(createChildParameter
				(DescriptionsPackage.Literals.DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCE_RANGES,
				 DescriptionsFactory.eINSTANCE.createReifiedRelationshipInstanceRange()));

		newChildDescriptors.add
			(createChildParameter
				(DescriptionsPackage.Literals.DESCRIPTION_BOX__UNREIFIED_RELATIONSHIP_INSTANCE_TUPLES,
				 DescriptionsFactory.eINSTANCE.createUnreifiedRelationshipInstanceTuple()));

		newChildDescriptors.add
			(createChildParameter
				(DescriptionsPackage.Literals.DESCRIPTION_BOX__SINGLETON_SCALAR_DATA_PROPERTY_VALUES,
				 DescriptionsFactory.eINSTANCE.createSingletonInstanceScalarDataPropertyValue()));

		newChildDescriptors.add
			(createChildParameter
				(DescriptionsPackage.Literals.DESCRIPTION_BOX__SINGLETON_STRUCTURED_DATA_PROPERTY_VALUES,
				 DescriptionsFactory.eINSTANCE.createSingletonInstanceStructuredDataPropertyValue()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return DescriptionsEditPlugin.INSTANCE;
	}

}
