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
package gov.nasa.jpl.imce.oml.runtime.provider;


import gov.nasa.jpl.imce.oml.runtime.OMLDescription;
import gov.nasa.jpl.imce.oml.runtime.OMLRuntimeFactory;
import gov.nasa.jpl.imce.oml.runtime.OMLRuntimePackage;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link gov.nasa.jpl.imce.oml.runtime.OMLDescription} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class OMLDescriptionItemProvider extends OMLObjectItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OMLDescriptionItemProvider(AdapterFactory adapterFactory) {
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

			addOmlDesciptionIRIPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Oml Desciption IRI feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOmlDesciptionIRIPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_OMLDescription_omlDesciptionIRI_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_OMLDescription_omlDesciptionIRI_feature", "_UI_OMLDescription_type"),
				 OMLRuntimePackage.Literals.OML_DESCRIPTION__OML_DESCIPTION_IRI,
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
			childrenFeatures.add(OMLRuntimePackage.Literals.OML_DESCRIPTION__OML_DESCRIPTION_CONTENTS);
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
	 * This returns OMLDescription.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/OMLDescription"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((OMLDescription)object).getOmlDesciptionIRI();
		return label == null || label.length() == 0 ?
			getString("_UI_OMLDescription_type") :
			getString("_UI_OMLDescription_type") + " " + label;
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

		switch (notification.getFeatureID(OMLDescription.class)) {
			case OMLRuntimePackage.OML_DESCRIPTION__OML_DESCIPTION_IRI:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case OMLRuntimePackage.OML_DESCRIPTION__OML_DESCRIPTION_CONTENTS:
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
				(OMLRuntimePackage.Literals.OML_DESCRIPTION__OML_DESCRIPTION_CONTENTS,
				 OMLRuntimeFactory.eINSTANCE.createOMLDescription()));

		newChildDescriptors.add
			(createChildParameter
				(OMLRuntimePackage.Literals.OML_DESCRIPTION__OML_DESCRIPTION_CONTENTS,
				 OMLRuntimeFactory.eINSTANCE.createOMLAspect()));

		newChildDescriptors.add
			(createChildParameter
				(OMLRuntimePackage.Literals.OML_DESCRIPTION__OML_DESCRIPTION_CONTENTS,
				 OMLRuntimeFactory.eINSTANCE.createOMLConcept()));

		newChildDescriptors.add
			(createChildParameter
				(OMLRuntimePackage.Literals.OML_DESCRIPTION__OML_DESCRIPTION_CONTENTS,
				 OMLRuntimeFactory.eINSTANCE.createOMLReifiedRelationship()));

		newChildDescriptors.add
			(createChildParameter
				(OMLRuntimePackage.Literals.OML_DESCRIPTION__OML_DESCRIPTION_CONTENTS,
				 OMLRuntimeFactory.eINSTANCE.createOMLUnreifiedRelationship()));

		newChildDescriptors.add
			(createChildParameter
				(OMLRuntimePackage.Literals.OML_DESCRIPTION__OML_DESCRIPTION_CONTENTS,
				 OMLRuntimeFactory.eINSTANCE.createOMLEntityDataPropertyToScalar()));

		newChildDescriptors.add
			(createChildParameter
				(OMLRuntimePackage.Literals.OML_DESCRIPTION__OML_DESCRIPTION_CONTENTS,
				 OMLRuntimeFactory.eINSTANCE.createOMLEntityDataPropertyToStructure()));

		newChildDescriptors.add
			(createChildParameter
				(OMLRuntimePackage.Literals.OML_DESCRIPTION__OML_DESCRIPTION_CONTENTS,
				 OMLRuntimeFactory.eINSTANCE.createOMLStructureDataPropertyToScalar()));

		newChildDescriptors.add
			(createChildParameter
				(OMLRuntimePackage.Literals.OML_DESCRIPTION__OML_DESCRIPTION_CONTENTS,
				 OMLRuntimeFactory.eINSTANCE.createOMLStructureDataPropertyToStructure()));
	}

}
