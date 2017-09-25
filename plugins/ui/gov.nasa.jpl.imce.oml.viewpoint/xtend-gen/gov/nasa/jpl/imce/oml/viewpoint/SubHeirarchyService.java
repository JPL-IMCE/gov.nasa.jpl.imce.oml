/**
 * Copyright 2017 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * License Terms
 */
package gov.nasa.jpl.imce.oml.viewpoint;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import gov.nasa.jpl.imce.oml.model.terminologies.Aspect;
import gov.nasa.jpl.imce.oml.model.terminologies.AspectSpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.Concept;
import gov.nasa.jpl.imce.oml.model.terminologies.ConceptSpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.Entity;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBoxStatement;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class SubHeirarchyService {
  /**
   * Returns all of the {@link Concept}s which have the passed {@link Concept} c
   * as its superConcept for all {@link ConceptSpecializationAxiom}s in this
   * {@link TerminologyBox}
   * 
   * @param c The {@Concept} which is the superConcept
   * @return Set of {@link Concept}s that are subConcepts to the passed {@link Concept}
   */
  public Set<Concept> getSubConcepts(final Concept c) {
    final HashSet<Concept> concepts = new HashSet<Concept>();
    TerminologyBox _tbox = null;
    if (c!=null) {
      _tbox=c.getTbox();
    }
    EList<TerminologyBoxStatement> _boxStatements = null;
    if (_tbox!=null) {
      _boxStatements=_tbox.getBoxStatements();
    }
    final Function1<ConceptSpecializationAxiom, Boolean> _function = (ConceptSpecializationAxiom cs) -> {
      Concept _superConcept = cs.getSuperConcept();
      return Boolean.valueOf(Objects.equal(_superConcept, c));
    };
    final Consumer<ConceptSpecializationAxiom> _function_1 = (ConceptSpecializationAxiom cs) -> {
      concepts.add(cs.getSubConcept());
    };
    IterableExtensions.<ConceptSpecializationAxiom>filter(Iterables.<ConceptSpecializationAxiom>filter(_boxStatements, ConceptSpecializationAxiom.class), _function).forEach(_function_1);
    return concepts;
  }
  
  /**
   * Returns all of the {@link Entity}s which have the passed {@link Aspect} c
   * as its superAspect for all {@link AspectSpecializationAxiom}s in this
   * {@link TerminologyBox}
   * 
   * @param c The {@Concept} which is the superConcept
   * @return Set of {@link Entity}s that are subEntites to the passed {@link Aspect}
   */
  public Set<Entity> getSubEntities(final Aspect a) {
    final HashSet<Entity> entities = new HashSet<Entity>();
    TerminologyBox _tbox = null;
    if (a!=null) {
      _tbox=a.getTbox();
    }
    EList<TerminologyBoxStatement> _boxStatements = null;
    if (_tbox!=null) {
      _boxStatements=_tbox.getBoxStatements();
    }
    final Function1<AspectSpecializationAxiom, Boolean> _function = (AspectSpecializationAxiom cs) -> {
      Aspect _superAspect = cs.getSuperAspect();
      return Boolean.valueOf(Objects.equal(_superAspect, a));
    };
    final Consumer<AspectSpecializationAxiom> _function_1 = (AspectSpecializationAxiom s) -> {
      entities.add(s.getSubEntity());
    };
    IterableExtensions.<AspectSpecializationAxiom>filter(Iterables.<AspectSpecializationAxiom>filter(_boxStatements, AspectSpecializationAxiom.class), _function).forEach(_function_1);
    return entities;
  }
}
