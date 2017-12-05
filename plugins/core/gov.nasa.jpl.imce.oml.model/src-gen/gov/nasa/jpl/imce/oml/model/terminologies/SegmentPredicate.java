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
 * </ul>
 *
 * @see gov.nasa.jpl.imce.oml.model.terminologies.TerminologiesPackage#getSegmentPredicate()
 * @model abstract="true"
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true"
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

} // SegmentPredicate
