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

import gov.nasa.jpl.imce.oml.model.terminologies.util.TerminologiesAdapterFactory;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
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
public class TerminologiesItemProviderAdapterFactory extends TerminologiesAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
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
	public TerminologiesItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.model.terminologies.TerminologyExtensionAxiom} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TerminologyExtensionAxiomItemProvider terminologyExtensionAxiomItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.model.terminologies.TerminologyExtensionAxiom}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTerminologyExtensionAxiomAdapter() {
		if (terminologyExtensionAxiomItemProvider == null) {
			terminologyExtensionAxiomItemProvider = new TerminologyExtensionAxiomItemProvider(this);
		}

		return terminologyExtensionAxiomItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.model.terminologies.Aspect} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AspectItemProvider aspectItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.model.terminologies.Aspect}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAspectAdapter() {
		if (aspectItemProvider == null) {
			aspectItemProvider = new AspectItemProvider(this);
		}

		return aspectItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.model.terminologies.Concept} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConceptItemProvider conceptItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.model.terminologies.Concept}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createConceptAdapter() {
		if (conceptItemProvider == null) {
			conceptItemProvider = new ConceptItemProvider(this);
		}

		return conceptItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.model.terminologies.ForwardProperty} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ForwardPropertyItemProvider forwardPropertyItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.model.terminologies.ForwardProperty}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createForwardPropertyAdapter() {
		if (forwardPropertyItemProvider == null) {
			forwardPropertyItemProvider = new ForwardPropertyItemProvider(this);
		}

		return forwardPropertyItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.model.terminologies.InverseProperty} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InversePropertyItemProvider inversePropertyItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.model.terminologies.InverseProperty}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createInversePropertyAdapter() {
		if (inversePropertyItemProvider == null) {
			inversePropertyItemProvider = new InversePropertyItemProvider(this);
		}

		return inversePropertyItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReifiedRelationshipItemProvider reifiedRelationshipItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createReifiedRelationshipAdapter() {
		if (reifiedRelationshipItemProvider == null) {
			reifiedRelationshipItemProvider = new ReifiedRelationshipItemProvider(this);
		}

		return reifiedRelationshipItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipRestriction} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReifiedRelationshipRestrictionItemProvider reifiedRelationshipRestrictionItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipRestriction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createReifiedRelationshipRestrictionAdapter() {
		if (reifiedRelationshipRestrictionItemProvider == null) {
			reifiedRelationshipRestrictionItemProvider = new ReifiedRelationshipRestrictionItemProvider(this);
		}

		return reifiedRelationshipRestrictionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationship} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnreifiedRelationshipItemProvider unreifiedRelationshipItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationship}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createUnreifiedRelationshipAdapter() {
		if (unreifiedRelationshipItemProvider == null) {
			unreifiedRelationshipItemProvider = new UnreifiedRelationshipItemProvider(this);
		}

		return unreifiedRelationshipItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.model.terminologies.Scalar} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScalarItemProvider scalarItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.model.terminologies.Scalar}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createScalarAdapter() {
		if (scalarItemProvider == null) {
			scalarItemProvider = new ScalarItemProvider(this);
		}

		return scalarItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataProperty} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EntityStructuredDataPropertyItemProvider entityStructuredDataPropertyItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataProperty}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEntityStructuredDataPropertyAdapter() {
		if (entityStructuredDataPropertyItemProvider == null) {
			entityStructuredDataPropertyItemProvider = new EntityStructuredDataPropertyItemProvider(this);
		}

		return entityStructuredDataPropertyItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataProperty} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EntityScalarDataPropertyItemProvider entityScalarDataPropertyItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataProperty}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEntityScalarDataPropertyAdapter() {
		if (entityScalarDataPropertyItemProvider == null) {
			entityScalarDataPropertyItemProvider = new EntityScalarDataPropertyItemProvider(this);
		}

		return entityScalarDataPropertyItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.model.terminologies.StructuredDataProperty} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StructuredDataPropertyItemProvider structuredDataPropertyItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.model.terminologies.StructuredDataProperty}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createStructuredDataPropertyAdapter() {
		if (structuredDataPropertyItemProvider == null) {
			structuredDataPropertyItemProvider = new StructuredDataPropertyItemProvider(this);
		}

		return structuredDataPropertyItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.model.terminologies.ScalarDataProperty} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScalarDataPropertyItemProvider scalarDataPropertyItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.model.terminologies.ScalarDataProperty}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createScalarDataPropertyAdapter() {
		if (scalarDataPropertyItemProvider == null) {
			scalarDataPropertyItemProvider = new ScalarDataPropertyItemProvider(this);
		}

		return scalarDataPropertyItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.model.terminologies.Structure} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StructureItemProvider structureItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.model.terminologies.Structure}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createStructureAdapter() {
		if (structureItemProvider == null) {
			structureItemProvider = new StructureItemProvider(this);
		}

		return structureItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.model.terminologies.ChainRule} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChainRuleItemProvider chainRuleItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.model.terminologies.ChainRule}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createChainRuleAdapter() {
		if (chainRuleItemProvider == null) {
			chainRuleItemProvider = new ChainRuleItemProvider(this);
		}

		return chainRuleItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.model.terminologies.RuleBodySegment} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RuleBodySegmentItemProvider ruleBodySegmentItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.model.terminologies.RuleBodySegment}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRuleBodySegmentAdapter() {
		if (ruleBodySegmentItemProvider == null) {
			ruleBodySegmentItemProvider = new RuleBodySegmentItemProvider(this);
		}

		return ruleBodySegmentItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.model.terminologies.SegmentPredicate} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SegmentPredicateItemProvider segmentPredicateItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.model.terminologies.SegmentPredicate}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSegmentPredicateAdapter() {
		if (segmentPredicateItemProvider == null) {
			segmentPredicateItemProvider = new SegmentPredicateItemProvider(this);
		}

		return segmentPredicateItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.model.terminologies.EntityExistentialRestrictionAxiom} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EntityExistentialRestrictionAxiomItemProvider entityExistentialRestrictionAxiomItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.model.terminologies.EntityExistentialRestrictionAxiom}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEntityExistentialRestrictionAxiomAdapter() {
		if (entityExistentialRestrictionAxiomItemProvider == null) {
			entityExistentialRestrictionAxiomItemProvider = new EntityExistentialRestrictionAxiomItemProvider(this);
		}

		return entityExistentialRestrictionAxiomItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.model.terminologies.EntityUniversalRestrictionAxiom} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EntityUniversalRestrictionAxiomItemProvider entityUniversalRestrictionAxiomItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.model.terminologies.EntityUniversalRestrictionAxiom}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEntityUniversalRestrictionAxiomAdapter() {
		if (entityUniversalRestrictionAxiomItemProvider == null) {
			entityUniversalRestrictionAxiomItemProvider = new EntityUniversalRestrictionAxiomItemProvider(this);
		}

		return entityUniversalRestrictionAxiomItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.model.terminologies.AspectSpecializationAxiom} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AspectSpecializationAxiomItemProvider aspectSpecializationAxiomItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.model.terminologies.AspectSpecializationAxiom}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAspectSpecializationAxiomAdapter() {
		if (aspectSpecializationAxiomItemProvider == null) {
			aspectSpecializationAxiomItemProvider = new AspectSpecializationAxiomItemProvider(this);
		}

		return aspectSpecializationAxiomItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.model.terminologies.ConceptSpecializationAxiom} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConceptSpecializationAxiomItemProvider conceptSpecializationAxiomItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.model.terminologies.ConceptSpecializationAxiom}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createConceptSpecializationAxiomAdapter() {
		if (conceptSpecializationAxiomItemProvider == null) {
			conceptSpecializationAxiomItemProvider = new ConceptSpecializationAxiomItemProvider(this);
		}

		return conceptSpecializationAxiomItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipSpecializationAxiom} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReifiedRelationshipSpecializationAxiomItemProvider reifiedRelationshipSpecializationAxiomItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationshipSpecializationAxiom}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createReifiedRelationshipSpecializationAxiomAdapter() {
		if (reifiedRelationshipSpecializationAxiomItemProvider == null) {
			reifiedRelationshipSpecializationAxiomItemProvider = new ReifiedRelationshipSpecializationAxiomItemProvider(this);
		}

		return reifiedRelationshipSpecializationAxiomItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.model.terminologies.SubObjectPropertyOfAxiom} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubObjectPropertyOfAxiomItemProvider subObjectPropertyOfAxiomItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.model.terminologies.SubObjectPropertyOfAxiom}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSubObjectPropertyOfAxiomAdapter() {
		if (subObjectPropertyOfAxiomItemProvider == null) {
			subObjectPropertyOfAxiomItemProvider = new SubObjectPropertyOfAxiomItemProvider(this);
		}

		return subObjectPropertyOfAxiomItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.model.terminologies.SubDataPropertyOfAxiom} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubDataPropertyOfAxiomItemProvider subDataPropertyOfAxiomItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.model.terminologies.SubDataPropertyOfAxiom}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSubDataPropertyOfAxiomAdapter() {
		if (subDataPropertyOfAxiomItemProvider == null) {
			subDataPropertyOfAxiomItemProvider = new SubDataPropertyOfAxiomItemProvider(this);
		}

		return subDataPropertyOfAxiomItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyExistentialRestrictionAxiom} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EntityScalarDataPropertyExistentialRestrictionAxiomItemProvider entityScalarDataPropertyExistentialRestrictionAxiomItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyExistentialRestrictionAxiom}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEntityScalarDataPropertyExistentialRestrictionAxiomAdapter() {
		if (entityScalarDataPropertyExistentialRestrictionAxiomItemProvider == null) {
			entityScalarDataPropertyExistentialRestrictionAxiomItemProvider = new EntityScalarDataPropertyExistentialRestrictionAxiomItemProvider(this);
		}

		return entityScalarDataPropertyExistentialRestrictionAxiomItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyUniversalRestrictionAxiom} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EntityScalarDataPropertyUniversalRestrictionAxiomItemProvider entityScalarDataPropertyUniversalRestrictionAxiomItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyUniversalRestrictionAxiom}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEntityScalarDataPropertyUniversalRestrictionAxiomAdapter() {
		if (entityScalarDataPropertyUniversalRestrictionAxiomItemProvider == null) {
			entityScalarDataPropertyUniversalRestrictionAxiomItemProvider = new EntityScalarDataPropertyUniversalRestrictionAxiomItemProvider(this);
		}

		return entityScalarDataPropertyUniversalRestrictionAxiomItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyParticularRestrictionAxiom} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EntityScalarDataPropertyParticularRestrictionAxiomItemProvider entityScalarDataPropertyParticularRestrictionAxiomItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyParticularRestrictionAxiom}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEntityScalarDataPropertyParticularRestrictionAxiomAdapter() {
		if (entityScalarDataPropertyParticularRestrictionAxiomItemProvider == null) {
			entityScalarDataPropertyParticularRestrictionAxiomItemProvider = new EntityScalarDataPropertyParticularRestrictionAxiomItemProvider(this);
		}

		return entityScalarDataPropertyParticularRestrictionAxiomItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataPropertyParticularRestrictionAxiom} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EntityStructuredDataPropertyParticularRestrictionAxiomItemProvider entityStructuredDataPropertyParticularRestrictionAxiomItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.model.terminologies.EntityStructuredDataPropertyParticularRestrictionAxiom}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEntityStructuredDataPropertyParticularRestrictionAxiomAdapter() {
		if (entityStructuredDataPropertyParticularRestrictionAxiomItemProvider == null) {
			entityStructuredDataPropertyParticularRestrictionAxiomItemProvider = new EntityStructuredDataPropertyParticularRestrictionAxiomItemProvider(this);
		}

		return entityStructuredDataPropertyParticularRestrictionAxiomItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyTuple} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RestrictionStructuredDataPropertyTupleItemProvider restrictionStructuredDataPropertyTupleItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyTuple}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRestrictionStructuredDataPropertyTupleAdapter() {
		if (restrictionStructuredDataPropertyTupleItemProvider == null) {
			restrictionStructuredDataPropertyTupleItemProvider = new RestrictionStructuredDataPropertyTupleItemProvider(this);
		}

		return restrictionStructuredDataPropertyTupleItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.model.terminologies.RestrictionScalarDataPropertyValue} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RestrictionScalarDataPropertyValueItemProvider restrictionScalarDataPropertyValueItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.model.terminologies.RestrictionScalarDataPropertyValue}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRestrictionScalarDataPropertyValueAdapter() {
		if (restrictionScalarDataPropertyValueItemProvider == null) {
			restrictionScalarDataPropertyValueItemProvider = new RestrictionScalarDataPropertyValueItemProvider(this);
		}

		return restrictionScalarDataPropertyValueItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.model.terminologies.BinaryScalarRestriction} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BinaryScalarRestrictionItemProvider binaryScalarRestrictionItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.model.terminologies.BinaryScalarRestriction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBinaryScalarRestrictionAdapter() {
		if (binaryScalarRestrictionItemProvider == null) {
			binaryScalarRestrictionItemProvider = new BinaryScalarRestrictionItemProvider(this);
		}

		return binaryScalarRestrictionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.model.terminologies.IRIScalarRestriction} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IRIScalarRestrictionItemProvider iriScalarRestrictionItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.model.terminologies.IRIScalarRestriction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createIRIScalarRestrictionAdapter() {
		if (iriScalarRestrictionItemProvider == null) {
			iriScalarRestrictionItemProvider = new IRIScalarRestrictionItemProvider(this);
		}

		return iriScalarRestrictionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.model.terminologies.NumericScalarRestriction} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NumericScalarRestrictionItemProvider numericScalarRestrictionItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.model.terminologies.NumericScalarRestriction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createNumericScalarRestrictionAdapter() {
		if (numericScalarRestrictionItemProvider == null) {
			numericScalarRestrictionItemProvider = new NumericScalarRestrictionItemProvider(this);
		}

		return numericScalarRestrictionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.model.terminologies.PlainLiteralScalarRestriction} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PlainLiteralScalarRestrictionItemProvider plainLiteralScalarRestrictionItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.model.terminologies.PlainLiteralScalarRestriction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPlainLiteralScalarRestrictionAdapter() {
		if (plainLiteralScalarRestrictionItemProvider == null) {
			plainLiteralScalarRestrictionItemProvider = new PlainLiteralScalarRestrictionItemProvider(this);
		}

		return plainLiteralScalarRestrictionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.model.terminologies.StringScalarRestriction} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StringScalarRestrictionItemProvider stringScalarRestrictionItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.model.terminologies.StringScalarRestriction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createStringScalarRestrictionAdapter() {
		if (stringScalarRestrictionItemProvider == null) {
			stringScalarRestrictionItemProvider = new StringScalarRestrictionItemProvider(this);
		}

		return stringScalarRestrictionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.model.terminologies.TimeScalarRestriction} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TimeScalarRestrictionItemProvider timeScalarRestrictionItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.model.terminologies.TimeScalarRestriction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTimeScalarRestrictionAdapter() {
		if (timeScalarRestrictionItemProvider == null) {
			timeScalarRestrictionItemProvider = new TimeScalarRestrictionItemProvider(this);
		}

		return timeScalarRestrictionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.model.terminologies.SynonymScalarRestriction} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SynonymScalarRestrictionItemProvider synonymScalarRestrictionItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.model.terminologies.SynonymScalarRestriction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSynonymScalarRestrictionAdapter() {
		if (synonymScalarRestrictionItemProvider == null) {
			synonymScalarRestrictionItemProvider = new SynonymScalarRestrictionItemProvider(this);
		}

		return synonymScalarRestrictionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfRestriction} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScalarOneOfRestrictionItemProvider scalarOneOfRestrictionItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfRestriction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createScalarOneOfRestrictionAdapter() {
		if (scalarOneOfRestrictionItemProvider == null) {
			scalarOneOfRestrictionItemProvider = new ScalarOneOfRestrictionItemProvider(this);
		}

		return scalarOneOfRestrictionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfLiteralAxiom} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScalarOneOfLiteralAxiomItemProvider scalarOneOfLiteralAxiomItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.model.terminologies.ScalarOneOfLiteralAxiom}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createScalarOneOfLiteralAxiomAdapter() {
		if (scalarOneOfLiteralAxiomItemProvider == null) {
			scalarOneOfLiteralAxiomItemProvider = new ScalarOneOfLiteralAxiomItemProvider(this);
		}

		return scalarOneOfLiteralAxiomItemProvider;
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
		if (terminologyExtensionAxiomItemProvider != null) terminologyExtensionAxiomItemProvider.dispose();
		if (aspectItemProvider != null) aspectItemProvider.dispose();
		if (conceptItemProvider != null) conceptItemProvider.dispose();
		if (forwardPropertyItemProvider != null) forwardPropertyItemProvider.dispose();
		if (inversePropertyItemProvider != null) inversePropertyItemProvider.dispose();
		if (reifiedRelationshipItemProvider != null) reifiedRelationshipItemProvider.dispose();
		if (reifiedRelationshipRestrictionItemProvider != null) reifiedRelationshipRestrictionItemProvider.dispose();
		if (unreifiedRelationshipItemProvider != null) unreifiedRelationshipItemProvider.dispose();
		if (scalarItemProvider != null) scalarItemProvider.dispose();
		if (entityStructuredDataPropertyItemProvider != null) entityStructuredDataPropertyItemProvider.dispose();
		if (entityScalarDataPropertyItemProvider != null) entityScalarDataPropertyItemProvider.dispose();
		if (structuredDataPropertyItemProvider != null) structuredDataPropertyItemProvider.dispose();
		if (scalarDataPropertyItemProvider != null) scalarDataPropertyItemProvider.dispose();
		if (structureItemProvider != null) structureItemProvider.dispose();
		if (chainRuleItemProvider != null) chainRuleItemProvider.dispose();
		if (ruleBodySegmentItemProvider != null) ruleBodySegmentItemProvider.dispose();
		if (segmentPredicateItemProvider != null) segmentPredicateItemProvider.dispose();
		if (entityExistentialRestrictionAxiomItemProvider != null) entityExistentialRestrictionAxiomItemProvider.dispose();
		if (entityUniversalRestrictionAxiomItemProvider != null) entityUniversalRestrictionAxiomItemProvider.dispose();
		if (aspectSpecializationAxiomItemProvider != null) aspectSpecializationAxiomItemProvider.dispose();
		if (conceptSpecializationAxiomItemProvider != null) conceptSpecializationAxiomItemProvider.dispose();
		if (reifiedRelationshipSpecializationAxiomItemProvider != null) reifiedRelationshipSpecializationAxiomItemProvider.dispose();
		if (subObjectPropertyOfAxiomItemProvider != null) subObjectPropertyOfAxiomItemProvider.dispose();
		if (subDataPropertyOfAxiomItemProvider != null) subDataPropertyOfAxiomItemProvider.dispose();
		if (entityScalarDataPropertyExistentialRestrictionAxiomItemProvider != null) entityScalarDataPropertyExistentialRestrictionAxiomItemProvider.dispose();
		if (entityScalarDataPropertyUniversalRestrictionAxiomItemProvider != null) entityScalarDataPropertyUniversalRestrictionAxiomItemProvider.dispose();
		if (entityScalarDataPropertyParticularRestrictionAxiomItemProvider != null) entityScalarDataPropertyParticularRestrictionAxiomItemProvider.dispose();
		if (entityStructuredDataPropertyParticularRestrictionAxiomItemProvider != null) entityStructuredDataPropertyParticularRestrictionAxiomItemProvider.dispose();
		if (restrictionStructuredDataPropertyTupleItemProvider != null) restrictionStructuredDataPropertyTupleItemProvider.dispose();
		if (restrictionScalarDataPropertyValueItemProvider != null) restrictionScalarDataPropertyValueItemProvider.dispose();
		if (binaryScalarRestrictionItemProvider != null) binaryScalarRestrictionItemProvider.dispose();
		if (iriScalarRestrictionItemProvider != null) iriScalarRestrictionItemProvider.dispose();
		if (numericScalarRestrictionItemProvider != null) numericScalarRestrictionItemProvider.dispose();
		if (plainLiteralScalarRestrictionItemProvider != null) plainLiteralScalarRestrictionItemProvider.dispose();
		if (stringScalarRestrictionItemProvider != null) stringScalarRestrictionItemProvider.dispose();
		if (timeScalarRestrictionItemProvider != null) timeScalarRestrictionItemProvider.dispose();
		if (synonymScalarRestrictionItemProvider != null) synonymScalarRestrictionItemProvider.dispose();
		if (scalarOneOfRestrictionItemProvider != null) scalarOneOfRestrictionItemProvider.dispose();
		if (scalarOneOfLiteralAxiomItemProvider != null) scalarOneOfLiteralAxiomItemProvider.dispose();
	}

}