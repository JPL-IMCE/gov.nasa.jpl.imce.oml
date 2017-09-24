/**
 */
package gov.nasa.jpl.imce.oml.model.terminologies;

import gov.nasa.jpl.imce.oml.model.common.Element;
import gov.nasa.jpl.imce.oml.model.common.LiteralValue;
import gov.nasa.jpl.imce.oml.model.common.Module;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Restriction Scalar Data Property Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML RestrictionScalarDataPropertyValue specifies a literal string as the value of
 * an OML DataRelationshipToScalar in the scope of an OML RestrictionStructuredDataPropertyContext.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.RestrictionScalarDataPropertyValue#getStructuredDataPropertyContext <em>Structured Data Property Context</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.RestrictionScalarDataPropertyValue#getScalarDataProperty <em>Scalar Data Property</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.RestrictionScalarDataPropertyValue#getScalarPropertyValue <em>Scalar Property Value</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getRestrictionScalarDataPropertyValue()
 * @model
 * @generated
 */
public interface RestrictionScalarDataPropertyValue extends Element {
	/**
	 * Returns the value of the '<em><b>Structured Data Property Context</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyContext#getScalarDataPropertyRestrictions <em>Scalar Data Property Restrictions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Structured Data Property Context</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Structured Data Property Context</em>' container reference.
	 * @see #setStructuredDataPropertyContext(RestrictionStructuredDataPropertyContext)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getRestrictionScalarDataPropertyValue_StructuredDataPropertyContext()
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyContext#getScalarDataPropertyRestrictions
	 * @model opposite="scalarDataPropertyRestrictions" required="true" transient="false"
	 * @generated
	 */
	RestrictionStructuredDataPropertyContext getStructuredDataPropertyContext();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.RestrictionScalarDataPropertyValue#getStructuredDataPropertyContext <em>Structured Data Property Context</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Structured Data Property Context</em>' container reference.
	 * @see #getStructuredDataPropertyContext()
	 * @generated
	 */
	void setStructuredDataPropertyContext(RestrictionStructuredDataPropertyContext value);

	/**
	 * Returns the value of the '<em><b>Scalar Data Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scalar Data Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scalar Data Property</em>' reference.
	 * @see #setScalarDataProperty(DataRelationshipToScalar)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getRestrictionScalarDataPropertyValue_ScalarDataProperty()
	 * @model required="true"
	 * @generated
	 */
	DataRelationshipToScalar getScalarDataProperty();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.RestrictionScalarDataPropertyValue#getScalarDataProperty <em>Scalar Data Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scalar Data Property</em>' reference.
	 * @see #getScalarDataProperty()
	 * @generated
	 */
	void setScalarDataProperty(DataRelationshipToScalar value);

	/**
	 * Returns the value of the '<em><b>Scalar Property Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scalar Property Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scalar Property Value</em>' containment reference.
	 * @see #setScalarPropertyValue(LiteralValue)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getRestrictionScalarDataPropertyValue_ScalarPropertyValue()
	 * @model containment="true" required="true"
	 * @generated
	 */
	LiteralValue getScalarPropertyValue();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.RestrictionScalarDataPropertyValue#getScalarPropertyValue <em>Scalar Property Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scalar Property Value</em>' containment reference.
	 * @see #getScalarPropertyValue()
	 * @generated
	 */
	void setScalarPropertyValue(LiteralValue value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Scala code='extent.restrictionStructuredDataPropertyContextOfRestrictionScalarDataPropertyValue.get(this).flatMap(_.terminologyBox())'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyContext%&gt; _structuredDataPropertyContext = this.getStructuredDataPropertyContext();\n&lt;%gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox%&gt; _terminologyBox = null;\nif (_structuredDataPropertyContext!=null)\n{\n\t_terminologyBox=_structuredDataPropertyContext.terminologyBox();\n}\nreturn _terminologyBox;'"
	 * @generated
	 */
	TerminologyBox terminologyBox();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="gov.nasa.jpl.imce.oml.model.common.UUID" unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyContext%&gt; _structuredDataPropertyContext = this.getStructuredDataPropertyContext();\n&lt;%java.lang.String%&gt; _uuid = null;\nif (_structuredDataPropertyContext!=null)\n{\n\t_uuid=_structuredDataPropertyContext.uuid();\n}\n&lt;%java.lang.String%&gt; _string = null;\nif (_uuid!=null)\n{\n\t_string=_uuid.toString();\n}\n&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _mappedTo = &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;of(\"structuredDataPropertyContext\", _string);\n&lt;%gov.nasa.jpl.imce.oml.model.terminologies.DataRelationshipToScalar%&gt; _scalarDataProperty = this.getScalarDataProperty();\n&lt;%java.lang.String%&gt; _uuid_1 = null;\nif (_scalarDataProperty!=null)\n{\n\t_uuid_1=_scalarDataProperty.uuid();\n}\n&lt;%java.lang.String%&gt; _string_1 = null;\nif (_uuid_1!=null)\n{\n\t_string_1=_uuid_1.toString();\n}\n&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _mappedTo_1 = &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;of(\"scalarDataProperty\", _string_1);\n&lt;%java.util.UUID%&gt; _derivedUUID = &lt;%gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions%&gt;.derivedUUID(\n\t\"RestrictionScalarDataPropertyValue\", _mappedTo, _mappedTo_1);\n&lt;%java.lang.String%&gt; _string_2 = null;\nif (_derivedUUID!=null)\n{\n\t_string_2=_derivedUUID.toString();\n}\nreturn _string_2;'"
	 * @generated
	 */
	String uuid();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Scala code='extent.restrictionStructuredDataPropertyContextOfRestrictionScalarDataPropertyValue.get(this).flatMap(_.moduleContext)'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%gov.nasa.jpl.imce.oml.model.terminologies.RestrictionStructuredDataPropertyContext%&gt; _structuredDataPropertyContext = this.getStructuredDataPropertyContext();\n&lt;%gov.nasa.jpl.imce.oml.model.common.Module%&gt; _moduleContext = null;\nif (_structuredDataPropertyContext!=null)\n{\n\t_moduleContext=_structuredDataPropertyContext.moduleContext();\n}\nreturn _moduleContext;'"
	 * @generated
	 */
	Module moduleContext();

} // RestrictionScalarDataPropertyValue
