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


import gov.nasa.jpl.imce.oml.model.common.CommonFactory;
import gov.nasa.jpl.imce.oml.model.common.provider.LogicalElementItemProvider;
import gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage;
import gov.nasa.jpl.imce.oml.model.descriptions.ScalarDataPropertyValue;

import gov.nasa.jpl.imce.oml.model.edit.provider.OMLEditPlugin;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link gov.nasa.jpl.imce.oml.model.descriptions.ScalarDataPropertyValue} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ScalarDataPropertyValueItemProvider extends LogicalElementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScalarDataPropertyValueItemProvider(AdapterFactory adapterFactory) {
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

			addStructuredDataPropertyContextPropertyDescriptor(object);
			addScalarDataPropertyPropertyDescriptor(object);
			addValueTypePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Structured Data Property Context feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStructuredDataPropertyContextPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ScalarDataPropertyValue_structuredDataPropertyContext_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ScalarDataPropertyValue_structuredDataPropertyContext_feature", "_UI_ScalarDataPropertyValue_type"),
				 DescriptionsPackage.Literals.SCALAR_DATA_PROPERTY_VALUE__STRUCTURED_DATA_PROPERTY_CONTEXT,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Scalar Data Property feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addScalarDataPropertyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ScalarDataPropertyValue_scalarDataProperty_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ScalarDataPropertyValue_scalarDataProperty_feature", "_UI_ScalarDataPropertyValue_type"),
				 DescriptionsPackage.Literals.SCALAR_DATA_PROPERTY_VALUE__SCALAR_DATA_PROPERTY,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Value Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addValueTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ScalarDataPropertyValue_valueType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ScalarDataPropertyValue_valueType_feature", "_UI_ScalarDataPropertyValue_type"),
				 DescriptionsPackage.Literals.SCALAR_DATA_PROPERTY_VALUE__VALUE_TYPE,
				 true,
				 false,
				 true,
				 null,
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
			childrenFeatures.add(DescriptionsPackage.Literals.SCALAR_DATA_PROPERTY_VALUE__SCALAR_PROPERTY_VALUE);
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
	 * This returns ScalarDataPropertyValue.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ScalarDataPropertyValue"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ScalarDataPropertyValue)object).getUuid();
		return label == null || label.length() == 0 ?
			getString("_UI_ScalarDataPropertyValue_type") :
			getString("_UI_ScalarDataPropertyValue_type") + " " + label;
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

		switch (notification.getFeatureID(ScalarDataPropertyValue.class)) {
			case DescriptionsPackage.SCALAR_DATA_PROPERTY_VALUE__SCALAR_PROPERTY_VALUE:
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
				(DescriptionsPackage.Literals.SCALAR_DATA_PROPERTY_VALUE__SCALAR_PROPERTY_VALUE,
				 CommonFactory.eINSTANCE.createLiteralBoolean()));

		newChildDescriptors.add
			(createChildParameter
				(DescriptionsPackage.Literals.SCALAR_DATA_PROPERTY_VALUE__SCALAR_PROPERTY_VALUE,
				 CommonFactory.eINSTANCE.createLiteralDateTime()));

		newChildDescriptors.add
			(createChildParameter
				(DescriptionsPackage.Literals.SCALAR_DATA_PROPERTY_VALUE__SCALAR_PROPERTY_VALUE,
				 CommonFactory.eINSTANCE.createLiteralQuotedString()));

		newChildDescriptors.add
			(createChildParameter
				(DescriptionsPackage.Literals.SCALAR_DATA_PROPERTY_VALUE__SCALAR_PROPERTY_VALUE,
				 CommonFactory.eINSTANCE.createLiteralRawString()));

		newChildDescriptors.add
			(createChildParameter
				(DescriptionsPackage.Literals.SCALAR_DATA_PROPERTY_VALUE__SCALAR_PROPERTY_VALUE,
				 CommonFactory.eINSTANCE.createLiteralUUID()));

		newChildDescriptors.add
			(createChildParameter
				(DescriptionsPackage.Literals.SCALAR_DATA_PROPERTY_VALUE__SCALAR_PROPERTY_VALUE,
				 CommonFactory.eINSTANCE.createLiteralURI()));

		newChildDescriptors.add
			(createChildParameter
				(DescriptionsPackage.Literals.SCALAR_DATA_PROPERTY_VALUE__SCALAR_PROPERTY_VALUE,
				 CommonFactory.eINSTANCE.createLiteralReal()));

		newChildDescriptors.add
			(createChildParameter
				(DescriptionsPackage.Literals.SCALAR_DATA_PROPERTY_VALUE__SCALAR_PROPERTY_VALUE,
				 CommonFactory.eINSTANCE.createLiteralRational()));

		newChildDescriptors.add
			(createChildParameter
				(DescriptionsPackage.Literals.SCALAR_DATA_PROPERTY_VALUE__SCALAR_PROPERTY_VALUE,
				 CommonFactory.eINSTANCE.createLiteralFloat()));

		newChildDescriptors.add
			(createChildParameter
				(DescriptionsPackage.Literals.SCALAR_DATA_PROPERTY_VALUE__SCALAR_PROPERTY_VALUE,
				 CommonFactory.eINSTANCE.createLiteralDecimal()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return OMLEditPlugin.INSTANCE;
	}

}
