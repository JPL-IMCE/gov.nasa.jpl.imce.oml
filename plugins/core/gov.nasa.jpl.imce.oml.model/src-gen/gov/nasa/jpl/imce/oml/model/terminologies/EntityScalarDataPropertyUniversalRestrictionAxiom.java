/**
 */
package gov.nasa.jpl.imce.oml.model.terminologies;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity Scalar Data Property Universal Restriction Axiom</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML EntityScalarDataPropertyUniversalRestrictionAxiom maps to an
 * OWL2 DataAllValuesFrom (the range must be explicitly defined as a Scalar datatype)
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyUniversalRestrictionAxiom#getScalarRestriction <em>Scalar Restriction</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getEntityScalarDataPropertyUniversalRestrictionAxiom()
 * @model
 * @generated
 */
public interface EntityScalarDataPropertyUniversalRestrictionAxiom extends EntityScalarDataPropertyRestrictionAxiom {
	/**
	 * Returns the value of the '<em><b>Scalar Restriction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scalar Restriction</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scalar Restriction</em>' reference.
	 * @see #setScalarRestriction(DataRange)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getEntityScalarDataPropertyUniversalRestrictionAxiom_ScalarRestriction()
	 * @model required="true"
	 * @generated
	 */
	DataRange getScalarRestriction();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataPropertyUniversalRestrictionAxiom#getScalarRestriction <em>Scalar Restriction</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scalar Restriction</em>' reference.
	 * @see #getScalarRestriction()
	 * @generated
	 */
	void setScalarRestriction(DataRange value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="gov.nasa.jpl.imce.oml.model.common.UUID" unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox%&gt; _tbox = this.getTbox();\n&lt;%java.lang.String%&gt; _uuid = null;\nif (_tbox!=null)\n{\n\t_uuid=_tbox.uuid();\n}\n&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _mappedTo = &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;of(\"tbox\", _uuid);\n&lt;%gov.nasa.jpl.imce.oml.model.terminologies.Entity%&gt; _restrictedEntity = this.getRestrictedEntity();\n&lt;%java.lang.String%&gt; _uuid_1 = null;\nif (_restrictedEntity!=null)\n{\n\t_uuid_1=_restrictedEntity.uuid();\n}\n&lt;%java.lang.String%&gt; _string = null;\nif (_uuid_1!=null)\n{\n\t_string=_uuid_1.toString();\n}\n&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _mappedTo_1 = &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;of(\"restrictedEntity\", _string);\n&lt;%gov.nasa.jpl.imce.oml.model.terminologies.EntityScalarDataProperty%&gt; _scalarProperty = this.getScalarProperty();\n&lt;%java.lang.String%&gt; _uuid_2 = null;\nif (_scalarProperty!=null)\n{\n\t_uuid_2=_scalarProperty.uuid();\n}\n&lt;%java.lang.String%&gt; _string_1 = null;\nif (_uuid_2!=null)\n{\n\t_string_1=_uuid_2.toString();\n}\n&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _mappedTo_2 = &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;of(\"scalarProperty\", _string_1);\n&lt;%gov.nasa.jpl.imce.oml.model.terminologies.DataRange%&gt; _scalarRestriction = this.getScalarRestriction();\n&lt;%java.lang.String%&gt; _uuid_3 = null;\nif (_scalarRestriction!=null)\n{\n\t_uuid_3=_scalarRestriction.uuid();\n}\n&lt;%java.lang.String%&gt; _string_2 = null;\nif (_uuid_3!=null)\n{\n\t_string_2=_uuid_3.toString();\n}\n&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _mappedTo_3 = &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;of(\"scalarRestriction\", _string_2);\n&lt;%java.util.UUID%&gt; _derivedUUID = &lt;%gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions%&gt;.derivedUUID(\n\t\"EntityScalarDataPropertyUniversalRestrictionAxiom\", _mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3);\n&lt;%java.lang.String%&gt; _string_3 = null;\nif (_derivedUUID!=null)\n{\n\t_string_3=_derivedUUID.toString();\n}\nreturn _string_3;'"
	 * @generated
	 */
	String uuid();

} // EntityScalarDataPropertyUniversalRestrictionAxiom
