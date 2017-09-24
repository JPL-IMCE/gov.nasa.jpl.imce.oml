/**
 */
package gov.nasa.jpl.imce.oml.model.bundles;

import gov.nasa.jpl.imce.oml.model.common.Element;

import gov.nasa.jpl.imce.oml.model.terminologies.Concept;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root Concept Taxonomy Axiom</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML RootConceptTaxonomyAxiom asserts that, in the scope of a Bundle, a particular OML Concept
 * is the root of a taxonomy of concept specializations.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.bundles.RootConceptTaxonomyAxiom#getRoot <em>Root</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.bundles.BundlesPackage#getRootConceptTaxonomyAxiom()
 * @model
 * @generated
 */
public interface RootConceptTaxonomyAxiom extends TerminologyBundleStatement, ConceptTreeDisjunction {
	/**
	 * Returns the value of the '<em><b>Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Concept that is at the root of a taxonomy of disjunctions.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Root</em>' reference.
	 * @see #setRoot(Concept)
	 * @see gov.nasa.jpl.imce.oml.model.bundles.BundlesPackage#getRootConceptTaxonomyAxiom_Root()
	 * @model required="true"
	 * @generated
	 */
	Concept getRoot();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.bundles.RootConceptTaxonomyAxiom#getRoot <em>Root</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root</em>' reference.
	 * @see #getRoot()
	 * @generated
	 */
	void setRoot(Concept value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="gov.nasa.jpl.imce.oml.model.common.UUID" unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%gov.nasa.jpl.imce.oml.model.bundles.Bundle%&gt; _bundle = this.getBundle();\n&lt;%java.lang.String%&gt; _uuid = null;\nif (_bundle!=null)\n{\n\t_uuid=_bundle.uuid();\n}\n&lt;%java.lang.String%&gt; _string = null;\nif (_uuid!=null)\n{\n\t_string=_uuid.toString();\n}\n&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _mappedTo = &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;of(\"bundle\", _string);\n&lt;%gov.nasa.jpl.imce.oml.model.terminologies.Concept%&gt; _root = this.getRoot();\n&lt;%java.lang.String%&gt; _uuid_1 = null;\nif (_root!=null)\n{\n\t_uuid_1=_root.uuid();\n}\n&lt;%java.lang.String%&gt; _string_1 = null;\nif (_uuid_1!=null)\n{\n\t_string_1=_uuid_1.toString();\n}\n&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _mappedTo_1 = &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;of(\"root\", _string_1);\n&lt;%java.util.UUID%&gt; _derivedUUID = &lt;%gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions%&gt;.derivedUUID(\n\t\"RootConceptTaxonomyAxiom\", _mappedTo, _mappedTo_1);\n&lt;%java.lang.String%&gt; _string_2 = null;\nif (_derivedUUID!=null)\n{\n\t_string_2=_derivedUUID.toString();\n}\nreturn _string_2;'"
	 * @generated
	 */
	String uuid();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Scala code='extent.bundleOfTerminologyBundleStatement.get(this)'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getBundle();'"
	 * @generated
	 */
	Bundle bundleContainer();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Collection kind='Set'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.allNestedDisjunctions();'"
	 * @generated
	 */
	EList<Element> allNestedElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Scala code='extent.lookupDisjunctions(this).flatMap{ d =&gt; scala.collection.immutable.Set.empty[resolver.api.Element] + d ++ d.allNestedUnions() }'"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Collection kind='Set'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%org.eclipse.emf.common.util.BasicEList%&gt;&lt;&lt;%gov.nasa.jpl.imce.oml.model.common.Element%&gt;&gt; _xblockexpression = null;\n{\n\tfinal &lt;%org.eclipse.emf.common.util.BasicEList%&gt;&lt;&lt;%gov.nasa.jpl.imce.oml.model.common.Element%&gt;&gt; nres = new &lt;%org.eclipse.emf.common.util.BasicEList%&gt;&lt;&lt;%gov.nasa.jpl.imce.oml.model.common.Element%&gt;&gt;();\n\tnres.addAll(this.getDisjunctions());\n\tfinal &lt;%java.util.function.Consumer%&gt;&lt;&lt;%gov.nasa.jpl.imce.oml.model.bundles.DisjointUnionOfConceptsAxiom%&gt;&gt; _function = new &lt;%java.util.function.Consumer%&gt;&lt;&lt;%gov.nasa.jpl.imce.oml.model.bundles.DisjointUnionOfConceptsAxiom%&gt;&gt;()\n\t{\n\t\tpublic void accept(final &lt;%gov.nasa.jpl.imce.oml.model.bundles.DisjointUnionOfConceptsAxiom%&gt; it)\n\t\t{\n\t\t\tnres.addAll(it.allNestedUnions());\n\t\t}\n\t};\n\tthis.getDisjunctions().forEach(_function);\n\t_xblockexpression = nres;\n}\nreturn _xblockexpression;'"
	 * @generated
	 */
	EList<Element> allNestedDisjunctions();

} // RootConceptTaxonomyAxiom
