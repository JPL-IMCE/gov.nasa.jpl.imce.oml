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

import gov.nasa.jpl.imce.oml.model.common.ElementCrossReferenceTuple;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Segment Predicate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML SegmentPredicate wraps a reference to an OML Term used as a predicate for an OML ChainRule.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.SegmentPredicate#getBodySegment <em>Body Segment</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.SegmentPredicate#getPredicate <em>Predicate</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.SegmentPredicate#getReifiedRelationshipSource <em>Reified Relationship Source</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.SegmentPredicate#getReifiedRelationshipInverseSource <em>Reified Relationship Inverse Source</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.SegmentPredicate#getReifiedRelationshipTarget <em>Reified Relationship Target</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.SegmentPredicate#getReifiedRelationshipInverseTarget <em>Reified Relationship Inverse Target</em>}</li>
 *   <li>{@link gov.nasa.jpl.imce.oml.model.terminologies.SegmentPredicate#getUnreifiedRelationshipInverse <em>Unreified Relationship Inverse</em>}</li>
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getSegmentPredicate()
 * @model
 * @generated
 */
public interface SegmentPredicate extends ElementCrossReferenceTuple {
	/**
	 * Returns the value of the '<em><b>Body Segment</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link gov.nasa.jpl.imce.oml.model.terminologies.RuleBodySegment#getPredicate <em>Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body Segment</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body Segment</em>' container reference.
	 * @see #setBodySegment(RuleBodySegment)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getSegmentPredicate_BodySegment()
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.RuleBodySegment#getPredicate
	 * @model opposite="predicate" required="true" transient="false"
	 * @generated
	 */
	RuleBodySegment getBodySegment();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.SegmentPredicate#getBodySegment <em>Body Segment</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body Segment</em>' container reference.
	 * @see #getBodySegment()
	 * @generated
	 */
	void setBodySegment(RuleBodySegment value);

	/**
	 * Returns the value of the '<em><b>Predicate</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predicate</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predicate</em>' reference.
	 * @see #setPredicate(Predicate)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getSegmentPredicate_Predicate()
	 * @model
	 * @generated
	 */
	Predicate getPredicate();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.SegmentPredicate#getPredicate <em>Predicate</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predicate</em>' reference.
	 * @see #getPredicate()
	 * @generated
	 */
	void setPredicate(Predicate value);

	/**
	 * Returns the value of the '<em><b>Reified Relationship Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reified Relationship Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reified Relationship Source</em>' reference.
	 * @see #setReifiedRelationshipSource(ReifiedRelationship)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getSegmentPredicate_ReifiedRelationshipSource()
	 * @model
	 * @generated
	 */
	ReifiedRelationship getReifiedRelationshipSource();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.SegmentPredicate#getReifiedRelationshipSource <em>Reified Relationship Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reified Relationship Source</em>' reference.
	 * @see #getReifiedRelationshipSource()
	 * @generated
	 */
	void setReifiedRelationshipSource(ReifiedRelationship value);

	/**
	 * Returns the value of the '<em><b>Reified Relationship Inverse Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reified Relationship Inverse Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reified Relationship Inverse Source</em>' reference.
	 * @see #setReifiedRelationshipInverseSource(ReifiedRelationship)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getSegmentPredicate_ReifiedRelationshipInverseSource()
	 * @model
	 * @generated
	 */
	ReifiedRelationship getReifiedRelationshipInverseSource();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.SegmentPredicate#getReifiedRelationshipInverseSource <em>Reified Relationship Inverse Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reified Relationship Inverse Source</em>' reference.
	 * @see #getReifiedRelationshipInverseSource()
	 * @generated
	 */
	void setReifiedRelationshipInverseSource(ReifiedRelationship value);

	/**
	 * Returns the value of the '<em><b>Reified Relationship Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reified Relationship Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reified Relationship Target</em>' reference.
	 * @see #setReifiedRelationshipTarget(ReifiedRelationship)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getSegmentPredicate_ReifiedRelationshipTarget()
	 * @model
	 * @generated
	 */
	ReifiedRelationship getReifiedRelationshipTarget();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.SegmentPredicate#getReifiedRelationshipTarget <em>Reified Relationship Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reified Relationship Target</em>' reference.
	 * @see #getReifiedRelationshipTarget()
	 * @generated
	 */
	void setReifiedRelationshipTarget(ReifiedRelationship value);

	/**
	 * Returns the value of the '<em><b>Reified Relationship Inverse Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reified Relationship Inverse Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reified Relationship Inverse Target</em>' reference.
	 * @see #setReifiedRelationshipInverseTarget(ReifiedRelationship)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getSegmentPredicate_ReifiedRelationshipInverseTarget()
	 * @model
	 * @generated
	 */
	ReifiedRelationship getReifiedRelationshipInverseTarget();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.SegmentPredicate#getReifiedRelationshipInverseTarget <em>Reified Relationship Inverse Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reified Relationship Inverse Target</em>' reference.
	 * @see #getReifiedRelationshipInverseTarget()
	 * @generated
	 */
	void setReifiedRelationshipInverseTarget(ReifiedRelationship value);

	/**
	 * Returns the value of the '<em><b>Unreified Relationship Inverse</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unreified Relationship Inverse</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unreified Relationship Inverse</em>' reference.
	 * @see #setUnreifiedRelationshipInverse(UnreifiedRelationship)
	 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getSegmentPredicate_UnreifiedRelationshipInverse()
	 * @model
	 * @generated
	 */
	UnreifiedRelationship getUnreifiedRelationshipInverse();

	/**
	 * Sets the value of the '{@link gov.nasa.jpl.imce.oml.model.terminologies.SegmentPredicate#getUnreifiedRelationshipInverse <em>Unreified Relationship Inverse</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unreified Relationship Inverse</em>' reference.
	 * @see #getUnreifiedRelationshipInverse()
	 * @generated
	 */
	void setUnreifiedRelationshipInverse(UnreifiedRelationship value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Scala code='predicate.map(_.term()) orElse \n\treifiedRelationshipSource orElse \n\treifiedRelationshipInverseSource orElse\n\treifiedRelationshipTarget orElse\n\treifiedRelationshipInverseTarget orElse\n\tunreifiedRelationshipInverse'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%gov.nasa.jpl.imce.oml.model.terminologies.Term%&gt; _elvis = null;\n&lt;%gov.nasa.jpl.imce.oml.model.terminologies.Term%&gt; _elvis_1 = null;\n&lt;%gov.nasa.jpl.imce.oml.model.terminologies.Term%&gt; _elvis_2 = null;\n&lt;%gov.nasa.jpl.imce.oml.model.terminologies.Term%&gt; _elvis_3 = null;\n&lt;%gov.nasa.jpl.imce.oml.model.terminologies.Term%&gt; _elvis_4 = null;\n&lt;%gov.nasa.jpl.imce.oml.model.terminologies.Predicate%&gt; _predicate = this.getPredicate();\n&lt;%gov.nasa.jpl.imce.oml.model.terminologies.Term%&gt; _term = null;\nif (_predicate!=null)\n{\n\t_term=_predicate.term();\n}\nif (_term != null)\n{\n\t_elvis_4 = _term;\n} else\n{\n\t&lt;%gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship%&gt; _reifiedRelationshipSource = this.getReifiedRelationshipSource();\n\t_elvis_4 = _reifiedRelationshipSource;\n}\nif (_elvis_4 != null)\n{\n\t_elvis_3 = _elvis_4;\n} else\n{\n\t&lt;%gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship%&gt; _reifiedRelationshipInverseSource = this.getReifiedRelationshipInverseSource();\n\t_elvis_3 = _reifiedRelationshipInverseSource;\n}\nif (_elvis_3 != null)\n{\n\t_elvis_2 = _elvis_3;\n} else\n{\n\t&lt;%gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship%&gt; _reifiedRelationshipTarget = this.getReifiedRelationshipTarget();\n\t_elvis_2 = _reifiedRelationshipTarget;\n}\nif (_elvis_2 != null)\n{\n\t_elvis_1 = _elvis_2;\n} else\n{\n\t&lt;%gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship%&gt; _reifiedRelationshipInverseTarget = this.getReifiedRelationshipInverseTarget();\n\t_elvis_1 = _reifiedRelationshipInverseTarget;\n}\nif (_elvis_1 != null)\n{\n\t_elvis = _elvis_1;\n} else\n{\n\t&lt;%gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationship%&gt; _unreifiedRelationshipInverse = this.getUnreifiedRelationshipInverse();\n\t_elvis = _unreifiedRelationshipInverse;\n}\nreturn _elvis;'"
	 * @generated
	 */
	Term termPredicate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getBodySegment().moduleContext();'"
	 * @generated
	 */
	gov.nasa.jpl.imce.oml.model.common.Module moduleContext();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="gov.nasa.jpl.imce.oml.model.common.UUID" unique="false" required="true"
	 *        annotation="http://imce.jpl.nasa.gov/oml/Scala tables='\n\t  {\n\t    import scala.collection.immutable.Seq\n\t    import scala.Predef.String\n\n\t    taggedTypes.segmentPredicateUUID(\n          oug.namespaceUUID(\"SegmentPredicate\",  \n            Seq.empty[(String, String)] ++\n            Seq(\"bodySegment\" -&gt; bodySegmentUUID.toString) ++\n            predicateUUID.map { id =&gt; \"predicate\" -&gt; id.toString } ++\n            reifiedRelationshipSourceUUID.map { id =&gt; \"reifiedRelationshipSource\" -&gt; id.toString } ++\n            reifiedRelationshipInverseSourceUUID.map { id =&gt; \"reifiedRelationshipInverseSource\" -&gt; id.toString } ++\n            reifiedRelationshipTargetUUID.map { id =&gt; \"reifiedRelationshipTarget\" -&gt; id.toString } ++\n            reifiedRelationshipInverseTargetUUID.map { id =&gt; \"reifiedRelationshipInverseTarget\" -&gt; id.toString } ++\n            unreifiedRelationshipInverseUUID.map { id =&gt; \"unreifiedRelationshipInverse\" -&gt; id.toString } : _*).toString)\n\t   }'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%java.lang.String%&gt; _xblockexpression = null;\n{\n\tfinal &lt;%java.util.ArrayList%&gt;&lt;&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;&gt; factors = new &lt;%java.util.ArrayList%&gt;&lt;&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;&gt;();\n\t&lt;%gov.nasa.jpl.imce.oml.model.terminologies.RuleBodySegment%&gt; _bodySegment = this.getBodySegment();\n\t&lt;%java.lang.String%&gt; _uuid = null;\n\tif (_bodySegment!=null)\n\t{\n\t\t_uuid=_bodySegment.uuid();\n\t}\n\t&lt;%java.lang.String%&gt; _string = null;\n\tif (_uuid!=null)\n\t{\n\t\t_string=_uuid.toString();\n\t}\n\t&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _mappedTo = &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;of(\"bodySegment\", _string);\n\tfactors.add(_mappedTo);\n\t&lt;%gov.nasa.jpl.imce.oml.model.terminologies.Predicate%&gt; _predicate = this.getPredicate();\n\tboolean _tripleNotEquals = (null != _predicate);\n\tif (_tripleNotEquals)\n\t{\n\t\t&lt;%java.lang.String%&gt; _uuid_1 = this.getPredicate().uuid();\n\t\t&lt;%java.lang.String%&gt; _string_1 = null;\n\t\tif (_uuid_1!=null)\n\t\t{\n\t\t\t_string_1=_uuid_1.toString();\n\t\t}\n\t\t&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _mappedTo_1 = &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;of(\"predicate\", _string_1);\n\t\tfactors.add(_mappedTo_1);\n\t}\n\t&lt;%gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship%&gt; _reifiedRelationshipSource = this.getReifiedRelationshipSource();\n\tboolean _tripleNotEquals_1 = (null != _reifiedRelationshipSource);\n\tif (_tripleNotEquals_1)\n\t{\n\t\t&lt;%java.lang.String%&gt; _uuid_2 = this.getReifiedRelationshipSource().uuid();\n\t\t&lt;%java.lang.String%&gt; _string_2 = null;\n\t\tif (_uuid_2!=null)\n\t\t{\n\t\t\t_string_2=_uuid_2.toString();\n\t\t}\n\t\t&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _mappedTo_2 = &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;of(\"reifiedRelationshipSource\", _string_2);\n\t\tfactors.add(_mappedTo_2);\n\t}\n\t&lt;%gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship%&gt; _reifiedRelationshipInverseSource = this.getReifiedRelationshipInverseSource();\n\tboolean _tripleNotEquals_2 = (null != _reifiedRelationshipInverseSource);\n\tif (_tripleNotEquals_2)\n\t{\n\t\t&lt;%gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship%&gt; _reifiedRelationshipInverseSource_1 = this.getReifiedRelationshipInverseSource();\n\t\t&lt;%java.lang.String%&gt; _uuid_3 = null;\n\t\tif (_reifiedRelationshipInverseSource_1!=null)\n\t\t{\n\t\t\t_uuid_3=_reifiedRelationshipInverseSource_1.uuid();\n\t\t}\n\t\t&lt;%java.lang.String%&gt; _string_3 = null;\n\t\tif (_uuid_3!=null)\n\t\t{\n\t\t\t_string_3=_uuid_3.toString();\n\t\t}\n\t\t&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _mappedTo_3 = &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;of(\"reifiedRelationshipInverseSource\", _string_3);\n\t\tfactors.add(_mappedTo_3);\n\t}\n\t&lt;%gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship%&gt; _reifiedRelationshipTarget = this.getReifiedRelationshipTarget();\n\tboolean _tripleNotEquals_3 = (null != _reifiedRelationshipTarget);\n\tif (_tripleNotEquals_3)\n\t{\n\t\t&lt;%gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship%&gt; _reifiedRelationshipTarget_1 = this.getReifiedRelationshipTarget();\n\t\t&lt;%java.lang.String%&gt; _uuid_4 = null;\n\t\tif (_reifiedRelationshipTarget_1!=null)\n\t\t{\n\t\t\t_uuid_4=_reifiedRelationshipTarget_1.uuid();\n\t\t}\n\t\t&lt;%java.lang.String%&gt; _string_4 = null;\n\t\tif (_uuid_4!=null)\n\t\t{\n\t\t\t_string_4=_uuid_4.toString();\n\t\t}\n\t\t&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _mappedTo_4 = &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;of(\"reifiedRelationshipTarget\", _string_4);\n\t\tfactors.add(_mappedTo_4);\n\t}\n\t&lt;%gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship%&gt; _reifiedRelationshipInverseTarget = this.getReifiedRelationshipInverseTarget();\n\tboolean _tripleNotEquals_4 = (null != _reifiedRelationshipInverseTarget);\n\tif (_tripleNotEquals_4)\n\t{\n\t\t&lt;%gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship%&gt; _reifiedRelationshipInverseTarget_1 = this.getReifiedRelationshipInverseTarget();\n\t\t&lt;%java.lang.String%&gt; _uuid_5 = null;\n\t\tif (_reifiedRelationshipInverseTarget_1!=null)\n\t\t{\n\t\t\t_uuid_5=_reifiedRelationshipInverseTarget_1.uuid();\n\t\t}\n\t\t&lt;%java.lang.String%&gt; _string_5 = null;\n\t\tif (_uuid_5!=null)\n\t\t{\n\t\t\t_string_5=_uuid_5.toString();\n\t\t}\n\t\t&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _mappedTo_5 = &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;of(\"reifiedRelationshipInverseTarget\", _string_5);\n\t\tfactors.add(_mappedTo_5);\n\t}\n\t&lt;%gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationship%&gt; _unreifiedRelationshipInverse = this.getUnreifiedRelationshipInverse();\n\tboolean _tripleNotEquals_5 = (null != _unreifiedRelationshipInverse);\n\tif (_tripleNotEquals_5)\n\t{\n\t\t&lt;%gov.nasa.jpl.imce.oml.model.terminologies.UnreifiedRelationship%&gt; _unreifiedRelationshipInverse_1 = this.getUnreifiedRelationshipInverse();\n\t\t&lt;%java.lang.String%&gt; _uuid_6 = null;\n\t\tif (_unreifiedRelationshipInverse_1!=null)\n\t\t{\n\t\t\t_uuid_6=_unreifiedRelationshipInverse_1.uuid();\n\t\t}\n\t\t&lt;%java.lang.String%&gt; _string_6 = null;\n\t\tif (_uuid_6!=null)\n\t\t{\n\t\t\t_string_6=_uuid_6.toString();\n\t\t}\n\t\t&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _mappedTo_6 = &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;of(\"unreifiedRelationshipInverse\", _string_6);\n\t\tfactors.add(_mappedTo_6);\n\t}\n\t&lt;%java.util.UUID%&gt; _derivedUUID = &lt;%gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions%&gt;.derivedUUID(\"SegmentPredicate\", ((&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(factors, &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;.class)));\n\t&lt;%java.lang.String%&gt; _string_7 = null;\n\tif (_derivedUUID!=null)\n\t{\n\t\t_string_7=_derivedUUID.toString();\n\t}\n\t_xblockexpression = _string_7;\n}\nreturn _xblockexpression;'"
	 * @generated
	 */
	String uuid();

} // SegmentPredicate
