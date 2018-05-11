# Eclipse UI features for the Ontological Modeling Language

In principle, some plugins could have been substituted for a feature that includes 
them. However, to keep the size of the OML WB product to less than bintray's 250Mb 
limit, it is necessary in some cases to include a subset of the plugins from a feature.

Example:

| Feature | Subset of plugins included |
|---------|----------------------------|
| org.eclipse.acceleo.query | org.antlr.runtime |
| | org.eclipse.acceleo.annotations |
| | org.eclipse.acceleo.query |
| | org.eclipse.acceleo.query.ide.ui |

Another large footprint feature is org.eclipse.xtext.redist because it includes
the Xtext source code as well. It is unfortunate that there is not a distinction between
org.eclipse.xtext.redist and org.eclipse.xtext.redist.sources.
