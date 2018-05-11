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
package gov.nasa.jpl.imce.oml.model.bundles;

import gov.nasa.jpl.imce.oml.model.common.LogicalElement;

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
	 *        annotation="http://imce.jpl.nasa.gov/oml/Scala code='extent.lookupDisjunctions(this).flatMap{ d =&gt; scala.collection.immutable.Set.empty[resolver.api.LogicalElement] + d ++ d.allNestedElements() }'"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Collection kind='Set'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%org.eclipse.emf.common.util.BasicEList%&gt;&lt;&lt;%gov.nasa.jpl.imce.oml.model.common.LogicalElement%&gt;&gt; _xblockexpression = null;\n{\n\tfinal &lt;%org.eclipse.emf.common.util.BasicEList%&gt;&lt;&lt;%gov.nasa.jpl.imce.oml.model.common.LogicalElement%&gt;&gt; nes = new &lt;%org.eclipse.emf.common.util.BasicEList%&gt;&lt;&lt;%gov.nasa.jpl.imce.oml.model.common.LogicalElement%&gt;&gt;();\n\tnes.addAll(this.getDisjunctions());\n\tfinal &lt;%java.util.function.Consumer%&gt;&lt;&lt;%gov.nasa.jpl.imce.oml.model.bundles.DisjointUnionOfConceptsAxiom%&gt;&gt; _function = new &lt;%java.util.function.Consumer%&gt;&lt;&lt;%gov.nasa.jpl.imce.oml.model.bundles.DisjointUnionOfConceptsAxiom%&gt;&gt;()\n\t{\n\t\tpublic void accept(final &lt;%gov.nasa.jpl.imce.oml.model.bundles.DisjointUnionOfConceptsAxiom%&gt; d)\n\t\t{\n\t\t\tnes.addAll(d.allNestedElements());\n\t\t}\n\t};\n\tthis.getDisjunctions().forEach(_function);\n\t_xblockexpression = nes;\n}\nreturn _xblockexpression;'"
	 * @generated
	 */
	EList<LogicalElement> allNestedElements();

} // RootConceptTaxonomyAxiom
