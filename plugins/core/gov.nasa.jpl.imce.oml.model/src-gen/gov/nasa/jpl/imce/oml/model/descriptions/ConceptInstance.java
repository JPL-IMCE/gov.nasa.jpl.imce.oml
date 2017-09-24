/**
 */
package gov.nasa.jpl.imce.oml.model.descriptions;

import gov.nasa.jpl.imce.oml.model.common.Element;

import gov.nasa.jpl.imce.oml.model.terminologies.Concept;
import gov.nasa.jpl.imce.oml.model.terminologies.ConceptualEntity;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concept Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML ConceptInstance is an OML ConceptualEntitySingletonInstance classified by an OML Concept.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.ConceptInstance#getDescriptionBox <em>Description Box</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.ConceptInstance#getSingletonConceptClassifier <em>Singleton Concept Classifier</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage#getConceptInstance()
 * @model
 * @generated
 */
public interface ConceptInstance extends ConceptualEntitySingletonInstance {
	/**
	 * Returns the value of the '<em><b>Description Box</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox#getConceptInstances <em>Concept Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description Box</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description Box</em>' container reference.
	 * @see #setDescriptionBox(DescriptionBox)
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage#getConceptInstance_DescriptionBox()
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox#getConceptInstances
	 * @model opposite="conceptInstances" required="true" transient="false"
	 * @generated
	 */
	DescriptionBox getDescriptionBox();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.descriptions.ConceptInstance#getDescriptionBox <em>Description Box</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description Box</em>' container reference.
	 * @see #getDescriptionBox()
	 * @generated
	 */
	void setDescriptionBox(DescriptionBox value);

	/**
	 * Returns the value of the '<em><b>Singleton Concept Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Singleton Concept Classifier</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Singleton Concept Classifier</em>' reference.
	 * @see #setSingletonConceptClassifier(Concept)
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage#getConceptInstance_SingletonConceptClassifier()
	 * @model required="true"
	 * @generated
	 */
	Concept getSingletonConceptClassifier();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.descriptions.ConceptInstance#getSingletonConceptClassifier <em>Singleton Concept Classifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Singleton Concept Classifier</em>' reference.
	 * @see #getSingletonConceptClassifier()
	 * @generated
	 */
	void setSingletonConceptClassifier(Concept value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getSingletonConceptClassifier();'"
	 * @generated
	 */
	ConceptualEntity conceptualEntitySingletonClassifier();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Scala code='extent.descriptionBoxOfConceptInstance.get(this)'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getDescriptionBox();'"
	 * @generated
	 */
	DescriptionBox descriptionBox();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Scala code='scala.collection.immutable.Set.empty[resolver.api.Element]'"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Collection kind='Set'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return &lt;%org.eclipse.emf.common.util.ECollections%&gt;.&lt;&lt;%gov.nasa.jpl.imce.oml.model.common.Element%&gt;&gt;emptyEList();'"
	 * @generated
	 */
	EList<Element> allNestedElements();

} // ConceptInstance
