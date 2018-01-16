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


import gov.nasa.jpl.imce.oml.model.common.provider.ModuleItemProvider;
import gov.nasa.jpl.imce.oml.model.edit.provider.OMLEditPlugin;

import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesFactory;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox;
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
 * This is the item provider adapter for a {@link gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TerminologyBoxItemProvider extends ModuleItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminologyBoxItemProvider(AdapterFactory adapterFactory) {
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
				 getString("_UI_TerminologyBox_kind_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_TerminologyBox_kind_feature", "_UI_TerminologyBox_type"),
				 TerminologiesPackage.Literals.TERMINOLOGY_BOX__KIND,
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
			childrenFeatures.add(TerminologiesPackage.Literals.TERMINOLOGY_BOX__BOX_AXIOMS);
			childrenFeatures.add(TerminologiesPackage.Literals.TERMINOLOGY_BOX__BOX_STATEMENTS);
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
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((TerminologyBox)object).getUuid();
		return label == null || label.length() == 0 ?
			getString("_UI_TerminologyBox_type") :
			getString("_UI_TerminologyBox_type") + " " + label;
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

		switch (notification.getFeatureID(TerminologyBox.class)) {
			case TerminologiesPackage.TERMINOLOGY_BOX__KIND:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case TerminologiesPackage.TERMINOLOGY_BOX__BOX_AXIOMS:
			case TerminologiesPackage.TERMINOLOGY_BOX__BOX_STATEMENTS:
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
				(TerminologiesPackage.Literals.TERMINOLOGY_BOX__BOX_AXIOMS,
				 TerminologiesFactory.eINSTANCE.createTerminologyExtensionAxiom()));

		newChildDescriptors.add
			(createChildParameter
				(TerminologiesPackage.Literals.TERMINOLOGY_BOX__BOX_STATEMENTS,
				 TerminologiesFactory.eINSTANCE.createAspect()));

		newChildDescriptors.add
			(createChildParameter
				(TerminologiesPackage.Literals.TERMINOLOGY_BOX__BOX_STATEMENTS,
				 TerminologiesFactory.eINSTANCE.createConcept()));

		newChildDescriptors.add
			(createChildParameter
				(TerminologiesPackage.Literals.TERMINOLOGY_BOX__BOX_STATEMENTS,
				 TerminologiesFactory.eINSTANCE.createReifiedRelationship()));

		newChildDescriptors.add
			(createChildParameter
				(TerminologiesPackage.Literals.TERMINOLOGY_BOX__BOX_STATEMENTS,
				 TerminologiesFactory.eINSTANCE.createUnreifiedRelationship()));

		newChildDescriptors.add
			(createChildParameter
				(TerminologiesPackage.Literals.TERMINOLOGY_BOX__BOX_STATEMENTS,
				 TerminologiesFactory.eINSTANCE.createScalar()));

		newChildDescriptors.add
			(createChildParameter
				(TerminologiesPackage.Literals.TERMINOLOGY_BOX__BOX_STATEMENTS,
				 TerminologiesFactory.eINSTANCE.createEntityStructuredDataProperty()));

		newChildDescriptors.add
			(createChildParameter
				(TerminologiesPackage.Literals.TERMINOLOGY_BOX__BOX_STATEMENTS,
				 TerminologiesFactory.eINSTANCE.createEntityScalarDataProperty()));

		newChildDescriptors.add
			(createChildParameter
				(TerminologiesPackage.Literals.TERMINOLOGY_BOX__BOX_STATEMENTS,
				 TerminologiesFactory.eINSTANCE.createStructuredDataProperty()));

		newChildDescriptors.add
			(createChildParameter
				(TerminologiesPackage.Literals.TERMINOLOGY_BOX__BOX_STATEMENTS,
				 TerminologiesFactory.eINSTANCE.createScalarDataProperty()));

		newChildDescriptors.add
			(createChildParameter
				(TerminologiesPackage.Literals.TERMINOLOGY_BOX__BOX_STATEMENTS,
				 TerminologiesFactory.eINSTANCE.createStructure()));

		newChildDescriptors.add
			(createChildParameter
				(TerminologiesPackage.Literals.TERMINOLOGY_BOX__BOX_STATEMENTS,
				 TerminologiesFactory.eINSTANCE.createChainRule()));

		newChildDescriptors.add
			(createChildParameter
				(TerminologiesPackage.Literals.TERMINOLOGY_BOX__BOX_STATEMENTS,
				 TerminologiesFactory.eINSTANCE.createEntityExistentialRestrictionAxiom()));

		newChildDescriptors.add
			(createChildParameter
				(TerminologiesPackage.Literals.TERMINOLOGY_BOX__BOX_STATEMENTS,
				 TerminologiesFactory.eINSTANCE.createEntityUniversalRestrictionAxiom()));

		newChildDescriptors.add
			(createChildParameter
				(TerminologiesPackage.Literals.TERMINOLOGY_BOX__BOX_STATEMENTS,
				 TerminologiesFactory.eINSTANCE.createAspectSpecializationAxiom()));

		newChildDescriptors.add
			(createChildParameter
				(TerminologiesPackage.Literals.TERMINOLOGY_BOX__BOX_STATEMENTS,
				 TerminologiesFactory.eINSTANCE.createConceptSpecializationAxiom()));

		newChildDescriptors.add
			(createChildParameter
				(TerminologiesPackage.Literals.TERMINOLOGY_BOX__BOX_STATEMENTS,
				 TerminologiesFactory.eINSTANCE.createReifiedRelationshipSpecializationAxiom()));

		newChildDescriptors.add
			(createChildParameter
				(TerminologiesPackage.Literals.TERMINOLOGY_BOX__BOX_STATEMENTS,
				 TerminologiesFactory.eINSTANCE.createSubObjectPropertyOfAxiom()));

		newChildDescriptors.add
			(createChildParameter
				(TerminologiesPackage.Literals.TERMINOLOGY_BOX__BOX_STATEMENTS,
				 TerminologiesFactory.eINSTANCE.createSubDataPropertyOfAxiom()));

		newChildDescriptors.add
			(createChildParameter
				(TerminologiesPackage.Literals.TERMINOLOGY_BOX__BOX_STATEMENTS,
				 TerminologiesFactory.eINSTANCE.createEntityScalarDataPropertyExistentialRestrictionAxiom()));

		newChildDescriptors.add
			(createChildParameter
				(TerminologiesPackage.Literals.TERMINOLOGY_BOX__BOX_STATEMENTS,
				 TerminologiesFactory.eINSTANCE.createEntityScalarDataPropertyUniversalRestrictionAxiom()));

		newChildDescriptors.add
			(createChildParameter
				(TerminologiesPackage.Literals.TERMINOLOGY_BOX__BOX_STATEMENTS,
				 TerminologiesFactory.eINSTANCE.createEntityScalarDataPropertyParticularRestrictionAxiom()));

		newChildDescriptors.add
			(createChildParameter
				(TerminologiesPackage.Literals.TERMINOLOGY_BOX__BOX_STATEMENTS,
				 TerminologiesFactory.eINSTANCE.createEntityStructuredDataPropertyParticularRestrictionAxiom()));

		newChildDescriptors.add
			(createChildParameter
				(TerminologiesPackage.Literals.TERMINOLOGY_BOX__BOX_STATEMENTS,
				 TerminologiesFactory.eINSTANCE.createBinaryScalarRestriction()));

		newChildDescriptors.add
			(createChildParameter
				(TerminologiesPackage.Literals.TERMINOLOGY_BOX__BOX_STATEMENTS,
				 TerminologiesFactory.eINSTANCE.createIRIScalarRestriction()));

		newChildDescriptors.add
			(createChildParameter
				(TerminologiesPackage.Literals.TERMINOLOGY_BOX__BOX_STATEMENTS,
				 TerminologiesFactory.eINSTANCE.createNumericScalarRestriction()));

		newChildDescriptors.add
			(createChildParameter
				(TerminologiesPackage.Literals.TERMINOLOGY_BOX__BOX_STATEMENTS,
				 TerminologiesFactory.eINSTANCE.createPlainLiteralScalarRestriction()));

		newChildDescriptors.add
			(createChildParameter
				(TerminologiesPackage.Literals.TERMINOLOGY_BOX__BOX_STATEMENTS,
				 TerminologiesFactory.eINSTANCE.createStringScalarRestriction()));

		newChildDescriptors.add
			(createChildParameter
				(TerminologiesPackage.Literals.TERMINOLOGY_BOX__BOX_STATEMENTS,
				 TerminologiesFactory.eINSTANCE.createTimeScalarRestriction()));

		newChildDescriptors.add
			(createChildParameter
				(TerminologiesPackage.Literals.TERMINOLOGY_BOX__BOX_STATEMENTS,
				 TerminologiesFactory.eINSTANCE.createSynonymScalarRestriction()));

		newChildDescriptors.add
			(createChildParameter
				(TerminologiesPackage.Literals.TERMINOLOGY_BOX__BOX_STATEMENTS,
				 TerminologiesFactory.eINSTANCE.createScalarOneOfRestriction()));

		newChildDescriptors.add
			(createChildParameter
				(TerminologiesPackage.Literals.TERMINOLOGY_BOX__BOX_STATEMENTS,
				 TerminologiesFactory.eINSTANCE.createScalarOneOfLiteralAxiom()));
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
