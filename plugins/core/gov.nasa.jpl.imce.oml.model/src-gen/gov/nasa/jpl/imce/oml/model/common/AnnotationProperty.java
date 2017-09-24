/**
 */
package gov.nasa.jpl.imce.oml.model.common;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Annotation Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML AnnotationProperty maps to a functional restriction of an [OWL2 AnnotationProperty].
 * Like OWL2, an OML AnnotationProperty is a non-logical property for associating some information
 * to an OML Element; unlike OWL2, an OML AnnotationProperty is functional in the sense
 * that an OML Element can have at most one OML AnnotationPropertyValue for a given OML AnnotationProperty.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.common.AnnotationProperty#getExtent <em>Extent</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.common.AnnotationProperty#getUuid <em>Uuid</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.common.AnnotationProperty#getIri <em>Iri</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.common.AnnotationProperty#getAbbrevIRI <em>Abbrev IRI</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.common.CommonPackage#getAnnotationProperty()
 * @model annotation="http://imce.jpl.nasa.gov/oml/NamespaceUUID namespace='iri' factors=''"
 * @generated
 */
public interface AnnotationProperty extends EObject {
	/**
	 * Returns the value of the '<em><b>Extent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link gov.nasa.jpl.imce.oml.model.common.Extent#getAnnotationProperties <em>Annotation Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extent</em>' container reference.
	 * @see #setExtent(Extent)
	 * @see gov.nasa.jpl.imce.oml.model.common.CommonPackage#getAnnotationProperty_Extent()
	 * @see gov.nasa.jpl.imce.oml.model.common.Extent#getAnnotationProperties
	 * @model opposite="annotationProperties" required="true" transient="false"
	 * @generated
	 */
	Extent getExtent();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.common.AnnotationProperty#getExtent <em>Extent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extent</em>' container reference.
	 * @see #getExtent()
	 * @generated
	 */
	void setExtent(Extent value);

	/**
	 * Returns the value of the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uuid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uuid</em>' attribute.
	 * @see gov.nasa.jpl.imce.oml.model.common.CommonPackage#getAnnotationProperty_Uuid()
	 * @model unique="false" dataType="gov.nasa.jpl.imce.oml.model.common.UUID" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Scala code='com.fasterxml.uuid.Generators.nameBasedGenerator(com.fasterxml.uuid.impl.NameBasedGenerator.NAMESPACE_URL).generate(iri)'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='&lt;%java.util.UUID%&gt; _namespaceUUID = &lt;%gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions%&gt;.namespaceUUID(this.getIri());\n&lt;%java.lang.String%&gt; _string = null;\nif (_namespaceUUID!=null)\n{\n\t_string=_namespaceUUID.toString();\n}\nreturn _string;'"
	 * @generated
	 */
	String getUuid();

	/**
	 * Returns the value of the '<em><b>Iri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iri</em>' attribute.
	 * @see #setIri(String)
	 * @see gov.nasa.jpl.imce.oml.model.common.CommonPackage#getAnnotationProperty_Iri()
	 * @model unique="false" dataType="gov.nasa.jpl.imce.oml.model.common.IRI" required="true"
	 * @generated
	 */
	String getIri();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.common.AnnotationProperty#getIri <em>Iri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Iri</em>' attribute.
	 * @see #getIri()
	 * @generated
	 */
	void setIri(String value);

	/**
	 * Returns the value of the '<em><b>Abbrev IRI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abbrev IRI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abbrev IRI</em>' attribute.
	 * @see #setAbbrevIRI(String)
	 * @see gov.nasa.jpl.imce.oml.model.common.CommonPackage#getAnnotationProperty_AbbrevIRI()
	 * @model unique="false" id="true" dataType="gov.nasa.jpl.imce.oml.model.common.AbbrevIRI" required="true"
	 * @generated
	 */
	String getAbbrevIRI();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.common.AnnotationProperty#getAbbrevIRI <em>Abbrev IRI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abbrev IRI</em>' attribute.
	 * @see #getAbbrevIRI()
	 * @generated
	 */
	void setAbbrevIRI(String value);

} // AnnotationProperty
