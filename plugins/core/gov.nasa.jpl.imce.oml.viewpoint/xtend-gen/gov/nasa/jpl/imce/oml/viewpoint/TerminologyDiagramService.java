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

import gov.nasa.jpl.imce.oml.model.graphs.TerminologyGraph;
import gov.nasa.jpl.imce.oml.model.terminologies.Entity;
import gov.nasa.jpl.imce.oml.model.terminologies.SpecializationAxiom;
import gov.nasa.jpl.imce.oml.model.terminologies.TerminologyBoxStatement;
import java.util.LinkedHashSet;
import java.util.Set;
import org.eclipse.emf.common.util.EList;

/**
 * Used to query for visual elements in the 'Terminology Diagram'
 * 
 * The 'Terminology Diagram' will show all {@link Entity}s and
 * {@link SpecializationAxiom}s for a given {@link TerminologyGraph}
 */
@SuppressWarnings("all")
public class TerminologyDiagramService {
  /**
   * Get all visual entities for the {@link TerminologyGraph}
   */
  public Set<Entity> getVisualEntities(final TerminologyGraph tg) {
    LinkedHashSet<Entity> _xblockexpression = null;
    {
      final LinkedHashSet<Entity> entities = new LinkedHashSet<Entity>();
      EList<TerminologyBoxStatement> _boxStatements = tg.getBoxStatements();
      for (final TerminologyBoxStatement statement : _boxStatements) {
        {
          if ((statement instanceof Entity)) {
            entities.add(((Entity) statement));
          }
          if ((statement instanceof SpecializationAxiom)) {
            final SpecializationAxiom temp = ((SpecializationAxiom) statement);
            Entity _child = temp.child();
            entities.add(_child);
            Entity _parent = temp.parent();
            entities.add(_parent);
          }
        }
      }
      _xblockexpression = entities;
    }
    return _xblockexpression;
  }
}
