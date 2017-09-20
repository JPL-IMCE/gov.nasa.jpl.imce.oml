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
package gov.nasa.jpl.imce.oml.model.terminologies.provider;


import gov.nasa.jpl.imce.oml.model.common.CommonFactory;
import gov.nasa.jpl.imce.oml.model.terminologies.NumericScalarRestriction;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link gov.nasa.jpl.imce.oml.model.terminologies.NumericScalarRestriction} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class NumericScalarRestrictionItemProvider extends RestrictedDataRangeItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumericScalarRestrictionItemProvider(AdapterFactory adapterFactory) {
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

		}
		return itemPropertyDescriptors;
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
			childrenFeatures.add(TerminologiesPackage.Literals.NUMERIC_SCALAR_RESTRICTION__MIN_INCLUSIVE);
			childrenFeatures.add(TerminologiesPackage.Literals.NUMERIC_SCALAR_RESTRICTION__MAX_INCLUSIVE);
			childrenFeatures.add(TerminologiesPackage.Literals.NUMERIC_SCALAR_RESTRICTION__MIN_EXCLUSIVE);
			childrenFeatures.add(TerminologiesPackage.Literals.NUMERIC_SCALAR_RESTRICTION__MAX_EXCLUSIVE);
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
	 * This returns NumericScalarRestriction.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/NumericScalarRestriction"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((NumericScalarRestriction)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_NumericScalarRestriction_type") :
			getString("_UI_NumericScalarRestriction_type") + " " + label;
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

		switch (notification.getFeatureID(NumericScalarRestriction.class)) {
			case TerminologiesPackage.NUMERIC_SCALAR_RESTRICTION__MIN_INCLUSIVE:
			case TerminologiesPackage.NUMERIC_SCALAR_RESTRICTION__MAX_INCLUSIVE:
			case TerminologiesPackage.NUMERIC_SCALAR_RESTRICTION__MIN_EXCLUSIVE:
			case TerminologiesPackage.NUMERIC_SCALAR_RESTRICTION__MAX_EXCLUSIVE:
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
				(TerminologiesPackage.Literals.NUMERIC_SCALAR_RESTRICTION__MIN_INCLUSIVE,
				 CommonFactory.eINSTANCE.createLiteralReal()));

		newChildDescriptors.add
			(createChildParameter
				(TerminologiesPackage.Literals.NUMERIC_SCALAR_RESTRICTION__MIN_INCLUSIVE,
				 CommonFactory.eINSTANCE.createLiteralRational()));

		newChildDescriptors.add
			(createChildParameter
				(TerminologiesPackage.Literals.NUMERIC_SCALAR_RESTRICTION__MIN_INCLUSIVE,
				 CommonFactory.eINSTANCE.createLiteralFloat()));

		newChildDescriptors.add
			(createChildParameter
				(TerminologiesPackage.Literals.NUMERIC_SCALAR_RESTRICTION__MIN_INCLUSIVE,
				 CommonFactory.eINSTANCE.createLiteralDecimal()));

		newChildDescriptors.add
			(createChildParameter
				(TerminologiesPackage.Literals.NUMERIC_SCALAR_RESTRICTION__MAX_INCLUSIVE,
				 CommonFactory.eINSTANCE.createLiteralReal()));

		newChildDescriptors.add
			(createChildParameter
				(TerminologiesPackage.Literals.NUMERIC_SCALAR_RESTRICTION__MAX_INCLUSIVE,
				 CommonFactory.eINSTANCE.createLiteralRational()));

		newChildDescriptors.add
			(createChildParameter
				(TerminologiesPackage.Literals.NUMERIC_SCALAR_RESTRICTION__MAX_INCLUSIVE,
				 CommonFactory.eINSTANCE.createLiteralFloat()));

		newChildDescriptors.add
			(createChildParameter
				(TerminologiesPackage.Literals.NUMERIC_SCALAR_RESTRICTION__MAX_INCLUSIVE,
				 CommonFactory.eINSTANCE.createLiteralDecimal()));

		newChildDescriptors.add
			(createChildParameter
				(TerminologiesPackage.Literals.NUMERIC_SCALAR_RESTRICTION__MIN_EXCLUSIVE,
				 CommonFactory.eINSTANCE.createLiteralReal()));

		newChildDescriptors.add
			(createChildParameter
				(TerminologiesPackage.Literals.NUMERIC_SCALAR_RESTRICTION__MIN_EXCLUSIVE,
				 CommonFactory.eINSTANCE.createLiteralRational()));

		newChildDescriptors.add
			(createChildParameter
				(TerminologiesPackage.Literals.NUMERIC_SCALAR_RESTRICTION__MIN_EXCLUSIVE,
				 CommonFactory.eINSTANCE.createLiteralFloat()));

		newChildDescriptors.add
			(createChildParameter
				(TerminologiesPackage.Literals.NUMERIC_SCALAR_RESTRICTION__MIN_EXCLUSIVE,
				 CommonFactory.eINSTANCE.createLiteralDecimal()));

		newChildDescriptors.add
			(createChildParameter
				(TerminologiesPackage.Literals.NUMERIC_SCALAR_RESTRICTION__MAX_EXCLUSIVE,
				 CommonFactory.eINSTANCE.createLiteralReal()));

		newChildDescriptors.add
			(createChildParameter
				(TerminologiesPackage.Literals.NUMERIC_SCALAR_RESTRICTION__MAX_EXCLUSIVE,
				 CommonFactory.eINSTANCE.createLiteralRational()));

		newChildDescriptors.add
			(createChildParameter
				(TerminologiesPackage.Literals.NUMERIC_SCALAR_RESTRICTION__MAX_EXCLUSIVE,
				 CommonFactory.eINSTANCE.createLiteralFloat()));

		newChildDescriptors.add
			(createChildParameter
				(TerminologiesPackage.Literals.NUMERIC_SCALAR_RESTRICTION__MAX_EXCLUSIVE,
				 CommonFactory.eINSTANCE.createLiteralDecimal()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == TerminologiesPackage.Literals.NUMERIC_SCALAR_RESTRICTION__MIN_INCLUSIVE ||
			childFeature == TerminologiesPackage.Literals.NUMERIC_SCALAR_RESTRICTION__MAX_INCLUSIVE ||
			childFeature == TerminologiesPackage.Literals.NUMERIC_SCALAR_RESTRICTION__MIN_EXCLUSIVE ||
			childFeature == TerminologiesPackage.Literals.NUMERIC_SCALAR_RESTRICTION__MAX_EXCLUSIVE;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
