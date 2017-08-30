# OML Viewpoints

## Usage

- Open the Eclipse Modeling perspective
- For a project that contains *.oml files, use the project context menu: "Configure > Convert to Modeling Project"
- Afterwards, the context menu on a project with *.oml files should have additional menus: 
  - Viewpoint Selection
  - 
## Development

Note: the OML viewpoints are defined in [description/OML.odesign](description/OML.odesign)

The OML Viewpoints are graphical modeling workbenches developed using the [Sirius Eclipse Project](http://www.eclipse.org/sirius/doc/).  The views availble are as follows:

| View Name | Type |Desciription |
|----------|-------|-----------|
| Terminology Diagram | Diagram | Displays all of the *Entities* and *Axiom*s in a *TerminologyGraph* |
| Terminology Relationships | Table| Displays all of the *EntitiyRelationship*s and and its properties from this *TerminologyGraph* in a tablular format |
| Terminology Aspects | Table | Displays all of the *Aspects* and which *Entites* have said *Entities* as a *Specialization* |
| Terminology Properties | Table | Displays all of the *Data Properties* in this *Terminology Graph* |
| Terminology Concepts | Table | Displays all of the *Concepts* and which *Concepts* have said *Concept* as a *Specialization* in a tabular format |
| Sub Heiarchy | Tree | Displays all of the *Concepts* and *Aspects* in a tree format |
| Concept Usage Diagram | Diagram | Displays all of the *Concepts* that have the root *Concept* as its domain or range (directly or indirectly) |
| Aspect/Concept Class Diagram | Diagram | Displays all *Aspects/Concepts* that have the root *Aspect/Concept* as its domain or range (relationships) or its parent (*Specializations*)|
| Reified Relationship Diagram | Diagram | Displays a *ReifiedRelationship* and its doamin and range|

The views *Aspect/Concept Class Diagram* and *Sub Heiarchy* are incomplete

## Eclipse/Sirus

- The 'version' attribute in the 'descirption' tag must be 11.1.1.201610211630.  When saving, this may be automatically updated to a higher version and you will not be able to load the models in the runtime

- All queries for 'Terminology Diagram', 'Aspect/Concept Diagram' and 'ConceptUsageDiagram' are in service methods in the gov.nasa.jpl.imce.oml.viewpoint package.