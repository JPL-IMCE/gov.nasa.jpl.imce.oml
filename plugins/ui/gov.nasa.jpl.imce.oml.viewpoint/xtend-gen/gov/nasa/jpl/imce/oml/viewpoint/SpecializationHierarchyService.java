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
import gov.nasa.jpl.imce.oml.model.graphs.TerminologyGraph;
import gov.nasa.jpl.imce.oml.model.terminologies.Aspect;
import gov.nasa.jpl.imce.oml.model.terminologies.Entity;
import gov.nasa.jpl.imce.oml.model.terminologies.SpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBox;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.tree.DTree;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class SpecializationHierarchyService {
  /**
   * Returns all of the {@link Entity}s which have the passed {@link Aspect} c
   * as its superAspect for all {@link SpecializationAxiom}s in this
   * {@link TerminologyBox}
   * 
   * @param c The {@link Entity} which is the superConcept
   * @return Set of {@link Entity}s that are children to the passed {@link Entity}
   */
  public Set<Entity> getSubEntities(final Entity e, final DTree tree) {
    final HashSet<Entity> entities = new HashSet<Entity>();
    EObject _target = tree.getTarget();
    final TerminologyGraph tb = ((TerminologyGraph) _target);
    final Function1<SpecializationAxiom, Boolean> _function = (SpecializationAxiom s) -> {
      Entity _parent = s.parent();
      return Boolean.valueOf(Objects.equal(_parent, e));
    };
    final Consumer<SpecializationAxiom> _function_1 = (SpecializationAxiom s) -> {
      entities.add(s.child());
    };
    IterableExtensions.<SpecializationAxiom>filter(Iterables.<SpecializationAxiom>filter(tb.getBoxStatements(), SpecializationAxiom.class), _function).forEach(_function_1);
    return entities;
  }
  
  public Set<Entity> getVisualTreeItems(final EObject eObj) {
    final HashSet<Entity> entities = new HashSet<Entity>();
    final TerminologyBox tb = ((TerminologyBox) eObj);
    final Consumer<SpecializationAxiom> _function = (SpecializationAxiom s) -> {
      entities.add(s.parent());
    };
    Iterables.<SpecializationAxiom>filter(tb.getBoxStatements(), SpecializationAxiom.class).forEach(_function);
    return entities;
  }
}
