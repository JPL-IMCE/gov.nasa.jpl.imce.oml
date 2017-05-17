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

import gov.nasa.jpl.imce.oml.model.common.Element;

import gov.nasa.jpl.imce.oml.model.terminologies.Concept;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Specific Disjoint Concept Axiom</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML SpecificDisjointConceptAxiom specifies a leaf in a concept taxonomy tree.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.bundles.SpecificDisjointConceptAxiom#getDisjointLeaf <em>Disjoint Leaf</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.bundles.BundlesPackage#getSpecificDisjointConceptAxiom()
 * @model
 * @generated
 */
public interface SpecificDisjointConceptAxiom extends DisjointUnionOfConceptsAxiom, Element {
	/**
	 * Returns the value of the '<em><b>Disjoint Leaf</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A Concept that is a disjoint leaf in a taxonomy tree.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Disjoint Leaf</em>' reference.
	 * @see #setDisjointLeaf(Concept)
	 * @see gov.nasa.jpl.imce.oml.model.bundles.BundlesPackage#getSpecificDisjointConceptAxiom_DisjointLeaf()
	 * @model required="true"
	 * @generated
	 */
	Concept getDisjointLeaf();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.bundles.SpecificDisjointConceptAxiom#getDisjointLeaf <em>Disjoint Leaf</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Disjoint Leaf</em>' reference.
	 * @see #getDisjointLeaf()
	 * @generated
	 */
	void setDisjointLeaf(Concept value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="gov.nasa.jpl.imce.oml.model.common.UUID" unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%gov.nasa.jpl.imce.oml.model.bundles.ConceptTreeDisjunction%> _disjointTaxonomyParent = this.getDisjointTaxonomyParent();\n<%java.lang.String%> _uuid = null;\nif (_disjointTaxonomyParent!=null)\n{\n\t_uuid=_disjointTaxonomyParent.uuid();\n}\n<%java.lang.String%> _string = null;\nif (_uuid!=null)\n{\n\t_string=_uuid.toString();\n}\n<%org.eclipse.xtext.xbase.lib.Pair%><<%java.lang.String%>, <%java.lang.String%>> _mappedTo = <%org.eclipse.xtext.xbase.lib.Pair%>.<<%java.lang.String%>, <%java.lang.String%>>of(\"disjointTaxonomyParent\", _string);\n<%gov.nasa.jpl.imce.oml.model.terminologies.Concept%> _disjointLeaf = this.getDisjointLeaf();\n<%java.lang.String%> _uuid_1 = null;\nif (_disjointLeaf!=null)\n{\n\t_uuid_1=_disjointLeaf.uuid();\n}\n<%java.lang.String%> _string_1 = null;\nif (_uuid_1!=null)\n{\n\t_string_1=_uuid_1.toString();\n}\n<%org.eclipse.xtext.xbase.lib.Pair%><<%java.lang.String%>, <%java.lang.String%>> _mappedTo_1 = <%org.eclipse.xtext.xbase.lib.Pair%>.<<%java.lang.String%>, <%java.lang.String%>>of(\"disjointLeaf\", _string_1);\n<%java.util.UUID%> _derivedUUID = <%gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions%>.derivedUUID(\n\t\"SpecificDisjointConceptAxiom\", _mappedTo, _mappedTo_1);\n<%java.lang.String%> _string_2 = null;\nif (_derivedUUID!=null)\n{\n\t_string_2=_derivedUUID.toString();\n}\nreturn _string_2;'"
	 * @generated
	 */
	String uuid();

} // SpecificDisjointConceptAxiom
