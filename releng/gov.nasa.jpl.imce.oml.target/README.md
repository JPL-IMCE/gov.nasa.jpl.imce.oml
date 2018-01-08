# Eclipse target definition for OML.

Caution: Editing an Eclipse target definition requires a lot of patience because the process is very tedious.

## Open the [target definition](gov.nasa.jpl.imce.oml.target.target) using the Eclipse XML editor (NOT the Target definition!)

## Verify using `mvn clean verify` that the target definition resolves and loads properly.

## To change versions of features/plugins, open the Eclipse Oomph Repository Explorer view

On the top field, select the URL of an Eclipse P2 site, e.g., http://download.eclipse.org/releases/oxygen/

(Eclipse does not allow browsing such sites with a plain browser; unfortunately, Eclipse does not suggest using Oomph's Repository Explorer!)

On the second line, there are two fields: a filter (left) and a selector (right).
For the right selector, choose: `org.eclipse.equinox.p2.iu`.

To find available versions, select an Installable Unit (IU); the available versions show at the bottom.
Note that copying an IU produces a chunk of XML instead of the IU name, e.g.:

```
<?xml version="1.0" encoding="UTF-8"?>
<p2:Requirement
    xmi:version="2.0"
    xmlns:xmi="http://www.omg.org/XMI"
    xmlns:p2="http://www.eclipse.org/oomph/p2/1.0"
    name="org.eclipse.jdt.junit4.runtime"/>
```

Note that copying a version produces a chunk of XML instead of the version string, e.g.:

```
<?xml version="1.0" encoding="UTF-8"?>
<p2:Requirement
    xmi:version="2.0"
    xmlns:xmi="http://www.omg.org/XMI"
    xmlns:p2="http://www.eclipse.org/oomph/p2/1.0"
    name="org.eclipse.jdt.junit4.runtime"
    versionRange="[1.1.650.v20170920-1015,1.1.650.v20170920-1015]"/>
```

## It may be necessary to update versions of features/plugins referenced in OML features/plugins

To do this, open [target definition](gov.nasa.jpl.imce.oml.target.target) using Eclipse' target editor and click "Reload target platform".
This will help Eclipse verify that the referenced features/plugins are available.
