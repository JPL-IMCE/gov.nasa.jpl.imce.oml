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
import gov.nasa.jpl.imce.oml.model.common.Module;

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
	 * @model unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%gov.nasa.jpl.imce.oml.model.terminologies.Term%&gt; _elvis = null;\n&lt;%gov.nasa.jpl.imce.oml.model.terminologies.Term%&gt; _elvis_1 = null;\n&lt;%gov.nasa.jpl.imce.oml.model.terminologies.Term%&gt; _elvis_2 = null;\n&lt;%gov.nasa.jpl.imce.oml.model.terminologies.Term%&gt; _elvis_3 = null;\n&lt;%gov.nasa.jpl.imce.oml.model.terminologies.Predicate%&gt; _predicate = this.getPredicate();\n&lt;%gov.nasa.jpl.imce.oml.model.terminologies.Term%&gt; _term = null;\nif (_predicate!=null)\n{\n\t_term=_predicate.term();\n}\nif (_term != null)\n{\n\t_elvis_3 = _term;\n} else\n{\n\t&lt;%gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship%&gt; _reifiedRelationshipSource = this.getReifiedRelationshipSource();\n\t_elvis_3 = _reifiedRelationshipSource;\n}\nif (_elvis_3 != null)\n{\n\t_elvis_2 = _elvis_3;\n} else\n{\n\t&lt;%gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship%&gt; _reifiedRelationshipInverseSource = this.getReifiedRelationshipInverseSource();\n\t_elvis_2 = _reifiedRelationshipInverseSource;\n}\nif (_elvis_2 != null)\n{\n\t_elvis_1 = _elvis_2;\n} else\n{\n\t&lt;%gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship%&gt; _reifiedRelationshipTarget = this.getReifiedRelationshipTarget();\n\t_elvis_1 = _reifiedRelationshipTarget;\n}\nif (_elvis_1 != null)\n{\n\t_elvis = _elvis_1;\n} else\n{\n\t&lt;%gov.nasa.jpl.imce.oml.model.terminologies.ReifiedRelationship%&gt; _reifiedRelationshipInverseTarget = this.getReifiedRelationshipInverseTarget();\n\t_elvis = _reifiedRelationshipInverseTarget;\n}\nreturn _elvis;'"
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
	Module moduleContext();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="gov.nasa.jpl.imce.oml.model.common.UUID" unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%gov.nasa.jpl.imce.oml.model.terminologies.Predicate%&gt; _predicate = this.getPredicate();\n&lt;%java.lang.String%&gt; _uuid = null;\nif (_predicate!=null)\n{\n\t_uuid=_predicate.uuid();\n}\n&lt;%java.lang.String%&gt; _string = null;\nif (_uuid!=null)\n{\n\t_string=_uuid.toString();\n}\n&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _mappedTo = &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;of(\"predicate\", _string);\n&lt;%gov.nasa.jpl.imce.oml.model.terminologies.RuleBodySegment%&gt; _bodySegment = this.getBodySegment();\n&lt;%java.lang.String%&gt; _uuid_1 = null;\nif (_bodySegment!=null)\n{\n\t_uuid_1=_bodySegment.uuid();\n}\n&lt;%java.lang.String%&gt; _string_1 = null;\nif (_uuid_1!=null)\n{\n\t_string_1=_uuid_1.toString();\n}\n&lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _mappedTo_1 = &lt;%org.eclipse.xtext.xbase.lib.Pair%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;of(\"bodySegment\", _string_1);\n&lt;%java.util.UUID%&gt; _derivedUUID = &lt;%gov.nasa.jpl.imce.oml.model.extensions.OMLExtensions%&gt;.derivedUUID(\n\t\"SegmentPredicate\", _mappedTo, _mappedTo_1);\n&lt;%java.lang.String%&gt; _string_2 = null;\nif (_derivedUUID!=null)\n{\n\t_string_2=_derivedUUID.toString();\n}\nreturn _string_2;'"
	 * @generated
	 */
	String uuid();

} // SegmentPredicate
