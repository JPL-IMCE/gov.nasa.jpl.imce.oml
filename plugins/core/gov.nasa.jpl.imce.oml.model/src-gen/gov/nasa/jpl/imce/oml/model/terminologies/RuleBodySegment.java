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

import gov.nasa.jpl.imce.oml.model.common.Element;
import gov.nasa.jpl.imce.oml.model.common.Module;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule Body Segment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML RuleBodySegment corresponds to a predicate in the body of a SWRL rule.
 * The `position` of an OML RuleBodySegment is 1 for the firstBodySegment of an OML ChainRule.
 * If the `position` of the current OML RuleBodySegment is `p`,
 * then the `position` of the `nextSegment`, if defined, is `p+1`.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.RuleBodySegment#getPredicate <em>Predicate</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.RuleBodySegment#getNextSegment <em>Next Segment</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.RuleBodySegment#getPreviousSegment <em>Previous Segment</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.RuleBodySegment#getRule <em>Rule</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getRuleBodySegment()
 * @model
 * @generated
 */
public interface RuleBodySegment extends Element {
	/**
	 * Returns the value of the '<em><b>Predicate</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link gov.nasa.jpl.imce.oml.model.terminologies.SegmentPredicate#getBodySegment <em>Body Segment</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predicate</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predicate</em>' containment reference.
	 * @see #setPredicate(SegmentPredicate)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getRuleBodySegment_Predicate()
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.SegmentPredicate#getBodySegment
	 * @model opposite="bodySegment" containment="true" required="true"
	 * @generated
	 */
	SegmentPredicate getPredicate();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.RuleBodySegment#getPredicate <em>Predicate</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predicate</em>' containment reference.
	 * @see #getPredicate()
	 * @generated
	 */
	void setPredicate(SegmentPredicate value);

	/**
	 * Returns the value of the '<em><b>Next Segment</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link gov.nasa.jpl.imce.oml.model.terminologies.RuleBodySegment#getPreviousSegment <em>Previous Segment</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Next Segment</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Next Segment</em>' containment reference.
	 * @see #setNextSegment(RuleBodySegment)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getRuleBodySegment_NextSegment()
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.RuleBodySegment#getPreviousSegment
	 * @model opposite="previousSegment" containment="true"
	 * @generated
	 */
	RuleBodySegment getNextSegment();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.RuleBodySegment#getNextSegment <em>Next Segment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Next Segment</em>' containment reference.
	 * @see #getNextSegment()
	 * @generated
	 */
	void setNextSegment(RuleBodySegment value);

	/**
	 * Returns the value of the '<em><b>Previous Segment</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link gov.nasa.jpl.imce.oml.model.terminologies.RuleBodySegment#getNextSegment <em>Next Segment</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Previous Segment</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Previous Segment</em>' container reference.
	 * @see #setPreviousSegment(RuleBodySegment)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getRuleBodySegment_PreviousSegment()
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.RuleBodySegment#getNextSegment
	 * @model opposite="nextSegment" transient="false"
	 * @generated
	 */
	RuleBodySegment getPreviousSegment();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.RuleBodySegment#getPreviousSegment <em>Previous Segment</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Previous Segment</em>' container reference.
	 * @see #getPreviousSegment()
	 * @generated
	 */
	void setPreviousSegment(RuleBodySegment value);

	/**
	 * Returns the value of the '<em><b>Rule</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link gov.nasa.jpl.imce.oml.model.terminologies.ChainRule#getFirstSegment <em>First Segment</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rule</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule</em>' container reference.
	 * @see #setRule(ChainRule)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getRuleBodySegment_Rule()
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.ChainRule#getFirstSegment
	 * @model opposite="firstSegment" transient="false"
	 * @generated
	 */
	ChainRule getRule();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.RuleBodySegment#getRule <em>Rule</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rule</em>' container reference.
	 * @see #getRule()
	 * @generated
	 */
	void setRule(ChainRule value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Scala code='previousSegment match { \n\t\t\t\t\tcase scala.None =&gt; \n\t\t\t\t\t\t1\n\t\t\t\t\tcase scala.Some(prev) =&gt; \n\t\t\t\t\t\t1 + prev.position()\n\t\t\t\t}'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='int _xifexpression = (int) 0;\n&lt;%gov.nasa.jpl.imce.oml.model.terminologies.RuleBodySegment%&gt; _previousSegment = this.getPreviousSegment();\nboolean _tripleEquals = (null == _previousSegment);\nif (_tripleEquals)\n{\n\t_xifexpression = 1;\n}\nelse\n{\n\tint _position = this.getPreviousSegment().position();\n\t_xifexpression = (1 + _position);\n}\nreturn _xifexpression;'"
	 * @generated
	 */
	int position();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Scala code='rule match {\n\t\t\t\t\tcase scala.Some(r) =&gt;\n\t\t\t\t\t\tr\n\t\t\t\t\tcase scala.None =&gt;\n\t\t\t\t\t\tpreviousSegment match {\n\t\t\t\t\t\t\tcase scala.Some(prev) =&gt;\n\t\t\t\t\t\t\t\tprev.chainRule()\n\t\t\t\t\t\t\tcase scala.None =&gt;\n\t\t\t\t\t\t\t\tthrow new java.lang.IllegalArgumentException(\"chainRule() must be well-defined\")\n\t\t\t\t\t\t}\t\t\t\t}'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%gov.nasa.jpl.imce.oml.model.terminologies.ChainRule%&gt; _elvis = null;\n&lt;%gov.nasa.jpl.imce.oml.model.terminologies.ChainRule%&gt; _rule = this.getRule();\nif (_rule != null)\n{\n\t_elvis = _rule;\n} else\n{\n\t&lt;%gov.nasa.jpl.imce.oml.model.terminologies.RuleBodySegment%&gt; _previousSegment = this.getPreviousSegment();\n\t&lt;%gov.nasa.jpl.imce.oml.model.terminologies.ChainRule%&gt; _chainRule = null;\n\tif (_previousSegment!=null)\n\t{\n\t\t_chainRule=_previousSegment.chainRule();\n\t}\n\t_elvis = _chainRule;\n}\nreturn _elvis;'"
	 * @generated
	 */
	ChainRule chainRule();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="gov.nasa.jpl.imce.oml.model.common.UUID" unique="false" required="true"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Scala code='namespaceUUID(\"RuleBodySegment\",  \n\t\t\"chainRule\" -&gt; \n\t\t\trule.fold[scala.Predef.String]{ \n\t\t\t  previousSegment.fold[scala.Predef.String]{ throw new java.lang.IllegalArgumentException(\"rule or previousSegment must be non-empty\") }{ prev =&gt; \n\t\t\t\tprev.chainRule().uuid.toString\n\t\t\t  } \n\t\t\t}{ r =&gt; \n\t\t\t  r.uuid.toString },\n\t\t\"position\" -&gt; \n\t\t\tposition().toString \n\t`   )'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%java.lang.String%&gt; _xifexpression = null;\n&lt;%gov.nasa.jpl.imce.oml.model.terminologies.RuleBodySegment%&gt; _previousSegment = this.getPreviousSegment();\nboolean _tripleEquals = (null == _previousSegment);\nif (_tripleEquals)\n{\n\t&lt;%gov.nasa.jpl.imce.oml.model.terminologies.ChainRule%&gt; _chainRule = this.chainRule();\n\t&lt;%java.lang.String%&gt; _uuid = null;\n\tif (_chainRule!=null)\n\t{\n\t\t_uuid=_chainRule.uuid();\n\t}\n\t&lt;%java.lang.String%&gt; _string = null;\n\tif (_uuid!=null)\n\t{\n\t\t_string=_uuid.toString();\n\t}\n\t_xifexpression = _string;\n}\nelse\n{\n\t&lt;%java.lang.String%&gt; _uuid_1 = this.getPreviousSegment().uuid();\n\t&lt;%java.lang.String%&gt; _string_1 = null;\n\tif (_uuid_1!=null)\n\t{\n\t\t_string_1=_uuid_1.toString();\n\t}\n\t_xifexpression = _string_1;\n}\n&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _mappedTo = &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;of(\"chainRule\", _xifexpression);\n&lt;%java.lang.String%&gt; _string_2 = &lt;%java.lang.Integer%&gt;.valueOf(this.position()).toString();\n&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _mappedTo_1 = &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;of(\"position\", _string_2);\n&lt;%java.util.UUID%&gt; _derivedUUID = &lt;%gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions%&gt;.derivedUUID(\n\t\"RuleBodySegment\", _mappedTo, _mappedTo_1);\n&lt;%java.lang.String%&gt; _string_3 = null;\nif (_derivedUUID!=null)\n{\n\t_string_3=_derivedUUID.toString();\n}\nreturn _string_3;'"
	 * @generated
	 */
	String uuid();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Scala code='chainRule().moduleContext()'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%gov.nasa.jpl.imce.oml.model.terminologies.ChainRule%&gt; _rule = this.getRule();\n&lt;%gov.nasa.jpl.imce.oml.model.common.Module%&gt; _moduleContext = null;\nif (_rule!=null)\n{\n\t_moduleContext=_rule.moduleContext();\n}\nreturn _moduleContext;'"
	 * @generated
	 */
	Module moduleContext();

} // RuleBodySegment
