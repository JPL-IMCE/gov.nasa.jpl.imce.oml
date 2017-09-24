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
package gov.nasa.jpl.imce.oml.model.terminologies;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity Existential Restriction Axiom</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML EntityExistentialRestrictionAxiom maps
 * to an [OWL2 Object Property Existential Restriction].
 * <!-- end-model-doc -->
 *
 *
 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getEntityExistentialRestrictionAxiom()
 * @model
 * @generated
 */
public interface EntityExistentialRestrictionAxiom extends EntityRestrictionAxiom {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="gov.nasa.jpl.imce.oml.model.common.UUID" unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%java.lang.String%&gt; _uuid = this.getTbox().uuid();\n&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _mappedTo = &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;of(\"tbox\", _uuid);\n&lt;%gov.nasa.jpl.imce.oml.model.terminologies.EntityRelationship%&gt; _restrictedRelation = this.getRestrictedRelation();\n&lt;%java.lang.String%&gt; _uuid_1 = null;\nif (_restrictedRelation!=null)\n{\n\t_uuid_1=_restrictedRelation.uuid();\n}\n&lt;%java.lang.String%&gt; _string = null;\nif (_uuid_1!=null)\n{\n\t_string=_uuid_1.toString();\n}\n&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _mappedTo_1 = &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;of(\"restrictedRelation\", _string);\n&lt;%gov.nasa.jpl.imce.oml.model.terminologies.Entity%&gt; _restrictedDomain = this.getRestrictedDomain();\n&lt;%java.lang.String%&gt; _uuid_2 = null;\nif (_restrictedDomain!=null)\n{\n\t_uuid_2=_restrictedDomain.uuid();\n}\n&lt;%java.lang.String%&gt; _string_1 = null;\nif (_uuid_2!=null)\n{\n\t_string_1=_uuid_2.toString();\n}\n&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _mappedTo_2 = &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;of(\"restrictedDomain\", _string_1);\n&lt;%gov.nasa.jpl.imce.oml.model.terminologies.Entity%&gt; _restrictedRange = this.getRestrictedRange();\n&lt;%java.lang.String%&gt; _uuid_3 = null;\nif (_restrictedRange!=null)\n{\n\t_uuid_3=_restrictedRange.uuid();\n}\n&lt;%java.lang.String%&gt; _string_2 = null;\nif (_uuid_3!=null)\n{\n\t_string_2=_uuid_3.toString();\n}\n&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _mappedTo_3 = &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;of(\"restrictedRange\", _string_2);\n&lt;%java.util.UUID%&gt; _derivedUUID = &lt;%gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions%&gt;.derivedUUID(\n\t\"EntityExistentialRestrictionAxiom\", _mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3);\n&lt;%java.lang.String%&gt; _string_3 = null;\nif (_derivedUUID!=null)\n{\n\t_string_3=_derivedUUID.toString();\n}\nreturn _string_3;'"
	 * @generated
	 */
	String uuid();

} // EntityExistentialRestrictionAxiom
