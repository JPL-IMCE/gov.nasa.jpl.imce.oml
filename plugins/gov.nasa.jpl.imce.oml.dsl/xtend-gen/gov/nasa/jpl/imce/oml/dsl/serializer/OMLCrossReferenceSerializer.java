package gov.nasa.jpl.imce.oml.dsl.serializer;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.linking.impl.LinkingHelper;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic;
import org.eclipse.xtext.serializer.tokens.CrossReferenceSerializer;

@SuppressWarnings("all")
public class OMLCrossReferenceSerializer extends CrossReferenceSerializer {
  @Inject
  private LinkingHelper linkingHelper;
  
  /**
   * Caution: check for null before calling: linkingHelper.getCrossRefNodeAsString(node, true)
   * - node !== null when target comes from creating a model via the Xtext DSL parser
   * - node === null when target comes from creating a model directly via the DSL metamodel factory API
   */
  @Override
  public String serializeCrossRef(final EObject semanticObject, final CrossReference crossref, final EObject target, final INode node, final ISerializationDiagnostic.Acceptor errors) {
    String _xblockexpression = null;
    {
      final String ruleName = this.linkingHelper.getRuleNameFrom(crossref);
      String _xifexpression = null;
      boolean _equals = Objects.equal("ExternalReference", ruleName);
      if (_equals) {
        String _switchResult = null;
        boolean _matched = false;
        if (target instanceof gov.nasa.jpl.imce.oml.model.common.Module) {
          _matched=true;
          String _iri = ((gov.nasa.jpl.imce.oml.model.common.Module)target).iri();
          String _plus = ("<" + _iri);
          _switchResult = (_plus + ">");
        }
        if (!_matched) {
          String _xifexpression_1 = null;
          if ((null == target)) {
            _xifexpression_1 = "<null>";
          } else {
            _xifexpression_1 = target.eClass().getName();
          }
          String _plus = ("OntologicalModelingLanguageCrossReferenceSerializer.serializeCrossRef(..., \'ExternalReference\', target, ...): target must be a Module, not: " + _xifexpression_1);
          throw new IllegalArgumentException(_plus);
        }
        _xifexpression = _switchResult;
      } else {
        String _xblockexpression_1 = null;
        {
          final String result = super.serializeCrossRef(semanticObject, crossref, target, node, errors);
          _xblockexpression_1 = result;
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
}
