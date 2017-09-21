# Quick Introduction to the Ontological Modeling Language Workbench, OML WB.

## Based on Eclipse [Xtext](https://www.eclipse.org/Xtext/) & [Sirius](https://www.eclipse.org/sirius/)

OML is a Domain-Specific Language (DSL) for specifying domain-specific vocabularies of information as
pattern-based abstractions of a logical formalization of such a vocabulary in [OWL2-DL](https://www.w3.org/TR/owl2-syntax/)
extended with [SWRL rules](https://www.w3.org/Submission/SWRL/), a combination widely supported by existing
OWL2-based reasoning engines like [Pellet](https://github.com/stardog-union/pellet).

## Using the OML Workbench

### Creating an OML Project

In Eclipse:

- `File | New > Project ...`
- In the new project dialog, select: `Sirius > Modeling Project`
- From the project's context menu: `Configure > Convert to Xtext Project`

### Configure an OML Project

- Choose a folder in an Xtext+Sirius-configured project (could be the project folder or a nested folder)
- From the folder context menu: `New | File`
- In the new file dialog, type: `oml.catalog.xml`

The contents of this XML file should look like the following:

```
<?xml version='1.0'?>
<catalog xmlns="urn:oasis:names:tc:entity:xmlns:xml:catalog"
         prefer="public">
 
 	<!-- This is an example mapping any IRI starting with 'http://example.org/...' to a local file 'file:./examples/...' -->
	<rewriteURI rewritePrefix="file:./examples/" uriStartString="http://example.org/"/>
	
 	<!-- This is an example mapping any IRI starting with 'http://company.com/...' to a local file 'file:./company.com/...' -->
	<rewriteURI rewritePrefix="file:./company/" uriStartString="http://company.com/"/>
</catalog>
```

For details about OASIS catalogs, please see: https://www.oasis-open.org/committees/entity/spec-2001-08-06.html


### Authoring OML Modules

Any `*.oml` file in a properly configured project with an `oml.catalog.xml` catalog should enable a context menu action: `Open With > OML Editor`

If the `Open With > OML Editor` menu action is not available, please check the OML project configuration.


For example, assuming a catalog with the rewrite rules shown above, the following OML Module contents should be located in a local file: `file:./examples/foo.oml`:

```
open terminology <http://example.org/foo> {
}
```

The catalog is used for resolving each OML ModuleEdge axiom, which is a relationship from a source OML Module to a target OML Module such as the `extends`
relationship as illustrated in the example below:

```
open terminology <http://company.com/bar> {

  extends <http://example.org/foo>
  
}
```

Assuming the rewrite rules shown above, this file should be located at `file:./company/bar.oml` where `./` corresponds to the folder where `oml.catalog.xml` is located.

### Diagramming OML Modules

- Open the [Sirius](https://www.eclipse.org/sirius/) perspective
- Open the folder of a properly configured OML project
- From the context menu of this project: Viewpoint Selection
- In the Viewpoint selection dialog, select: OML Viewpoint
  Note: If the OML Viewpoint is not visible, check the following:
  - make sure the project is configured as Xtext and Modeling Project
  - make sure there is a folder with an `oml.catalog.xml` catalog 
  - make sure that below such a folder, there is at least one `*.oml` file that can be properly opened using the `OML Editor`
- In the Model Exploder view, each `*.oml` file can be collapsed or expanded to show its contents.
- Expand an `*.oml` file to reach an OML Module; i.e.: `TerminologyGraph`, `Bundle` or `DescriptionBox`.
- From the context menu, use `New Representation` to create an OML Viewpoint applicable for that particular kind of OML Module.

### Known Limitations

- Don't mix `*.xsd` and `*.oml` files in the same project!∂

  In Eclipse Neon, the Sirius 4.1.6 project builder triggers opening EMF-based resources in the Eclipse project.
  Opening `*.xsd` resources in turn leads to a mismatch between the transaction-less Sirius builder and the EMF/XSD transaction-enabled resource loader.
  See https://bugs.eclipse.org/bugs/show_bug.cgi?id=513407
  
