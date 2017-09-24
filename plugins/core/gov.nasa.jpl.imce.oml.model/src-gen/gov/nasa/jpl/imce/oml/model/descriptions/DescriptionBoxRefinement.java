/**
 */
package gov.nasa.jpl.imce.oml.model.descriptions;

import gov.nasa.jpl.imce.oml.model.common.Module;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Description Box Refinement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML DescriptionBoxRefinement is an OML DescriptionBoxRelationship
 * from an OML DescriptionBox to another OML DescriptionBox where
 * the former refines the descriptions of the latter.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxRefinement#getRefiningDescriptionBox <em>Refining Description Box</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxRefinement#getRefinedDescriptionBox <em>Refined Description Box</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage#getDescriptionBoxRefinement()
 * @model
 * @generated
 */
public interface DescriptionBoxRefinement extends DescriptionBoxRelationship {
	/**
	 * Returns the value of the '<em><b>Refining Description Box</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox#getDescriptionBoxRefinements <em>Description Box Refinements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refining Description Box</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refining Description Box</em>' container reference.
	 * @see #setRefiningDescriptionBox(DescriptionBox)
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage#getDescriptionBoxRefinement_RefiningDescriptionBox()
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox#getDescriptionBoxRefinements
	 * @model opposite="descriptionBoxRefinements" required="true" transient="false"
	 * @generated
	 */
	DescriptionBox getRefiningDescriptionBox();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxRefinement#getRefiningDescriptionBox <em>Refining Description Box</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Refining Description Box</em>' container reference.
	 * @see #getRefiningDescriptionBox()
	 * @generated
	 */
	void setRefiningDescriptionBox(DescriptionBox value);

	/**
	 * Returns the value of the '<em><b>Refined Description Box</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refined Description Box</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refined Description Box</em>' reference.
	 * @see #setRefinedDescriptionBox(DescriptionBox)
	 * @see gov.nasa.jpl.imce.oml.model.descriptions.DescriptionsPackage#getDescriptionBoxRefinement_RefinedDescriptionBox()
	 * @model required="true"
	 * @generated
	 */
	DescriptionBox getRefinedDescriptionBox();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBoxRefinement#getRefinedDescriptionBox <em>Refined Description Box</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Refined Description Box</em>' reference.
	 * @see #getRefinedDescriptionBox()
	 * @generated
	 */
	void setRefinedDescriptionBox(DescriptionBox value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Scala code='extent.descriptionBoxOfDescriptionBoxRefinement.get(this)'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getRefiningDescriptionBox();'"
	 * @generated
	 */
	DescriptionBox descriptionDomain();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getRefinedDescriptionBox();'"
	 * @generated
	 */
	Module targetModule();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="gov.nasa.jpl.imce.oml.model.common.UUID" unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox%&gt; _refiningDescriptionBox = this.getRefiningDescriptionBox();\n&lt;%java.lang.String%&gt; _uuid = null;\nif (_refiningDescriptionBox!=null)\n{\n\t_uuid=_refiningDescriptionBox.uuid();\n}\n&lt;%java.lang.String%&gt; _string = null;\nif (_uuid!=null)\n{\n\t_string=_uuid.toString();\n}\n&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _mappedTo = &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;of(\"refiningDescriptionBox\", _string);\n&lt;%gov.nasa.jpl.imce.oml.model.descriptions.DescriptionBox%&gt; _refinedDescriptionBox = this.getRefinedDescriptionBox();\n&lt;%java.lang.String%&gt; _uuid_1 = null;\nif (_refinedDescriptionBox!=null)\n{\n\t_uuid_1=_refinedDescriptionBox.uuid();\n}\n&lt;%java.lang.String%&gt; _string_1 = null;\nif (_uuid_1!=null)\n{\n\t_string_1=_uuid_1.toString();\n}\n&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _mappedTo_1 = &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;of(\"refinedDescriptionBox\", _string_1);\n&lt;%java.util.UUID%&gt; _derivedUUID = &lt;%gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions%&gt;.derivedUUID(\n\t\"DescriptionBoxRefinement\", _mappedTo, _mappedTo_1);\n&lt;%java.lang.String%&gt; _string_2 = null;\nif (_derivedUUID!=null)\n{\n\t_string_2=_derivedUUID.toString();\n}\nreturn _string_2;'"
	 * @generated
	 */
	String uuid();

} // DescriptionBoxRefinement
