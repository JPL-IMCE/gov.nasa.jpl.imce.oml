/**
 */
package gov.nasa.jpl.imce.oml.model.bundles;

import gov.nasa.jpl.imce.oml.model.common.Element;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Anonymous Concept Union Axiom</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML AnonymousConceptUnionAxiom specifies an anonymous logical union of DisjointUnionOfEntityAxioms in a concept taxonomy tree.
 * Although it is semantically anonymous, it is syntactically identified with name whose
 * only purpose is for generating the axiom's namespace UUID.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.bundles.AnonymousConceptUnionAxiom#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.bundles.BundlesPackage#getAnonymousConceptUnionAxiom()
 * @model annotation="http://imce.jpl.nasa.gov/oml/NamespaceUUID namespace='disjointTaxonomyParent' factors='name'"
 * @generated
 */
public interface AnonymousConceptUnionAxiom extends DisjointUnionOfConceptsAxiom, ConceptTreeDisjunction {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see gov.nasa.jpl.imce.oml.model.bundles.BundlesPackage#getAnonymousConceptUnionAxiom_Name()
	 * @model unique="false" dataType="gov.nasa.jpl.imce.oml.model.common.LocalName" required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.bundles.AnonymousConceptUnionAxiom#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="gov.nasa.jpl.imce.oml.model.common.UUID" unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%gov.nasa.jpl.imce.oml.model.bundles.ConceptTreeDisjunction%&gt; _disjointTaxonomyParent = this.getDisjointTaxonomyParent();\n&lt;%java.lang.String%&gt; _uuid = null;\nif (_disjointTaxonomyParent!=null)\n{\n\t_uuid=_disjointTaxonomyParent.uuid();\n}\n&lt;%java.lang.String%&gt; _string = null;\nif (_uuid!=null)\n{\n\t_string=_uuid.toString();\n}\n&lt;%java.lang.String%&gt; _name = this.getName();\n&lt;%java.lang.String%&gt; _string_1 = null;\nif (_name!=null)\n{\n\t_string_1=_name.toString();\n}\n&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _mappedTo = &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;of(\"name\", _string_1);\n&lt;%java.util.UUID%&gt; _namespaceUUID = &lt;%gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions%&gt;.namespaceUUID(_string, _mappedTo);\n&lt;%java.lang.String%&gt; _string_2 = null;\nif (_namespaceUUID!=null)\n{\n\t_string_2=_namespaceUUID.toString();\n}\nreturn _string_2;'"
	 * @generated
	 */
	String uuid();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Scala code='conceptTreeDisjunctionParent().flatMap(_.bundleContainer())'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%gov.nasa.jpl.imce.oml.model.bundles.ConceptTreeDisjunction%&gt; _disjointTaxonomyParent = this.getDisjointTaxonomyParent();\n&lt;%gov.nasa.jpl.imce.oml.model.bundles.Bundle%&gt; _bundleContainer = null;\nif (_disjointTaxonomyParent!=null)\n{\n\t_bundleContainer=_disjointTaxonomyParent.bundleContainer();\n}\nreturn _bundleContainer;'"
	 * @generated
	 */
	Bundle bundleContainer();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Scala code='scala.collection.immutable.Set.empty[resolver.api.Element]'"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Collection kind='Set'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%org.eclipse.emf.common.util.BasicEList%&gt;&lt;&lt;%gov.nasa.jpl.imce.oml.model.common.Element%&gt;&gt; _xblockexpression = null;\n{\n\tfinal &lt;%org.eclipse.emf.common.util.BasicEList%&gt;&lt;&lt;%gov.nasa.jpl.imce.oml.model.common.Element%&gt;&gt; nres = new &lt;%org.eclipse.emf.common.util.BasicEList%&gt;&lt;&lt;%gov.nasa.jpl.imce.oml.model.common.Element%&gt;&gt;();\n\t_xblockexpression = nres;\n}\nreturn _xblockexpression;'"
	 * @generated
	 */
	EList<Element> allNestedDisjunctions();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Scala code='scala.collection.immutable.Set.empty[resolver.api.Element]'"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Collection kind='Set'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%org.eclipse.emf.common.util.BasicEList%&gt;&lt;&lt;%gov.nasa.jpl.imce.oml.model.common.Element%&gt;&gt; _xblockexpression = null;\n{\n\tfinal &lt;%org.eclipse.emf.common.util.BasicEList%&gt;&lt;&lt;%gov.nasa.jpl.imce.oml.model.common.Element%&gt;&gt; nres = new &lt;%org.eclipse.emf.common.util.BasicEList%&gt;&lt;&lt;%gov.nasa.jpl.imce.oml.model.common.Element%&gt;&gt;();\n\t_xblockexpression = nres;\n}\nreturn _xblockexpression;'"
	 * @generated
	 */
	EList<Element> allNestedUnions();

} // AnonymousConceptUnionAxiom
