# Writing OML Specifications using the Eclipse-based OML Workbench

## Requisites

- Install the OML Workbench in Eclipse Photon with Xtext 2.11

## OML Eclipse project

OML files are stored in an OML project, which is a plain Eclipse project with the following:

- The project must have the Xtext nature (i.e., `org.eclipse.xtext.ui.shared.xtextNature`).

- There must be an OASIS XML catalog file named 'oml.catalog.xml' somewhere in the project.

  The location of this 'oml.catalog.xml' file is used for specifying OASIS catalog rewrite rules 
  mapping absolute URLs to URLs relative to the location of the catalog.
  
  An example of an 'oml.catalog.xml' file is as follows:
  
  ```xml
  <?xml version='1.0'?>
  <catalog xmlns="urn:oasis:names:tc:entity:xmlns:xml:catalog"
	         prefer="public">
	         
	<rewriteURI rewritePrefix="file:./purl.org/" 				uriStartString="http://purl.org/"/>
	<rewriteURI rewritePrefix="file:./www.w3.org/" 				uriStartString="http://www.w3.org/"/>
	<rewriteURI rewritePrefix="file:./example.org/" 			uriStartString="http://example.org/"/>
  </catalog>
  ```

  Suppose that the 'oml.catalog.xml' file is in an Eclipse project named 'A'; whose Eclipse workspace location is '/A'.
  This example means that the following IRIs will be mapped to the following Eclipse workspace locations:
  
  | IRI in an OML file | Mapped Eclipse workspace location |
  |--------------------|-----------------------------------|
  | <http://example.org/vocabularies/structure> | /A/example.org/vocabularies/structure.oml |
  | <http://www.w3.org/2001/XMLSchema> | /A/www.w3.org/2001/XMLSchema.oml |
  | <http://purl.org/dc/elements/1.1> | /A/purl.org/dc/elements/1.1.oml |
  
  It is an error in OML to use IRIs that cannot be mapped through the catalog to local *.oml files.

