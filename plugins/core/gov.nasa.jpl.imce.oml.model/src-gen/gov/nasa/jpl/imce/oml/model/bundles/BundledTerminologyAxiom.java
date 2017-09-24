/**
 */
package gov.nasa.jpl.imce.oml.model.bundles;

import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bundled Terminology Axiom</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML BundledTerminologyAxiom identifies an OML TerminologyBox that an OML Bundle aggregates.
 * An OML BundledTerminologyAxiom allows an OML Bundle to
 * make references (via OML TerminologyStatement(s)) to OML TerminologyThing(s)
 * within the transitive closure of a bundledTerminology.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.bundles.BundledTerminologyAxiom#getBundledTerminology <em>Bundled Terminology</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.bundles.BundlesPackage#getBundledTerminologyAxiom()
 * @model
 * @generated
 */
public interface BundledTerminologyAxiom extends TerminologyBundleAxiom {
	/**
	 * Returns the value of the '<em><b>Bundled Terminology</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bundled Terminology</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bundled Terminology</em>' reference.
	 * @see #setBundledTerminology(TerminologyBox)
	 * @see gov.nasa.jpl.imce.oml.model.bundles.BundlesPackage#getBundledTerminologyAxiom_BundledTerminology()
	 * @model required="true"
	 * @generated
	 */
	TerminologyBox getBundledTerminology();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.bundles.BundledTerminologyAxiom#getBundledTerminology <em>Bundled Terminology</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bundled Terminology</em>' reference.
	 * @see #getBundledTerminology()
	 * @generated
	 */
	void setBundledTerminology(TerminologyBox value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The bundle is the source
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getBundle();'"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Scala code='extent.bundleOfTerminologyBundleAxiom.get(this)'"
	 * @generated
	 */
	TerminologyBox source();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The bundledTerminology is the target
	 * <!-- end-model-doc -->
	 * @model unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getBundledTerminology();'"
	 * @generated
	 */
	TerminologyBox target();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="gov.nasa.jpl.imce.oml.model.common.UUID" unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox%&gt; _bundledTerminology = this.getBundledTerminology();\n&lt;%java.lang.String%&gt; _uuid = null;\nif (_bundledTerminology!=null)\n{\n\t_uuid=_bundledTerminology.uuid();\n}\n&lt;%java.lang.String%&gt; _string = null;\nif (_uuid!=null)\n{\n\t_string=_uuid.toString();\n}\n&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _mappedTo = &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;of(\"bundledTerminology\", _string);\n&lt;%gov.nasa.jpl.imce.oml.model.bundles.Bundle%&gt; _bundle = this.getBundle();\n&lt;%java.lang.String%&gt; _uuid_1 = null;\nif (_bundle!=null)\n{\n\t_uuid_1=_bundle.uuid();\n}\n&lt;%java.lang.String%&gt; _string_1 = null;\nif (_uuid_1!=null)\n{\n\t_string_1=_uuid_1.toString();\n}\n&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _mappedTo_1 = &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;of(\"bundle\", _string_1);\n&lt;%java.util.UUID%&gt; _derivedUUID = &lt;%gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions%&gt;.derivedUUID(\n\t\"BundledTerminologyAxiom\", _mappedTo, _mappedTo_1);\n&lt;%java.lang.String%&gt; _string_2 = null;\nif (_derivedUUID!=null)\n{\n\t_string_2=_derivedUUID.toString();\n}\nreturn _string_2;'"
	 * @generated
	 */
	String uuid();

} // BundledTerminologyAxiom
