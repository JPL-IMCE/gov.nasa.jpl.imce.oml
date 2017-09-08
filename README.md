# Ontological Modeling Language (OML) Platform & Core Features

[![Build Status](https://travis-ci.org/JPL-IMCE/gov.nasa.jpl.imce.oml.svg?branch=master)](https://travis-ci.org/JPL-IMCE/gov.nasa.jpl.imce.oml)

Eclipse-based OML Workbench:  [ ![Download](https://api.bintray.com/packages/jpl-imce/gov.nasa.jpl.imce.oml/gov.nasa.jpl.imce.oml.product/images/download.svg) ](https://bintray.com/jpl-imce/gov.nasa.jpl.imce.oml/gov.nasa.jpl.imce.oml.product/_latestVersion)

OML is a specification language designed to support rigorous ontological modeling in the context of model-based systems engineering.
This multi-project is organized according to Eclipse Tycho guidelines.

## OML Workbench

The [OML Workbench](releng/gov.nasa.jpl.imce.oml.product/README.md) is an Eclipse-based RCP application.

## OML Development Process notes

- Publish a new version:

	Execute `./scripts/publishProcess.sh`.
	
	This will prompt for a new version -- enter a string of the form `<major>.<minor>.<patch/build>`.
	This creates a version-specific release branch and tag.
	This also pushes the release branch and tag to origin, which should trigger the travis-ci job that will build the release and deploy it to bintray.
	
- Managing versions on bintray:

    OML is a collection of multiple packages, each with its own versioned artifacts; see: https://bintray.com/jpl-imce/gov.nasa.jpl.imce.oml
    To operate on all OML packages, see the utility: [scripts/btOMLProjectsDo.sh](scripts/btOMLProjectsDo.sh)
    
    Execute `./scripts/btOMLProjectsDo.sh` to get command-line usage information.
     
## GIT

Xtext compiles a grammar file, `*.xtext` into a corresponding binary in the `src-gen` folder as `*.xtextbin`.
If generated sources are in GIT:

- `git ls-files *.xtext | wc -l` should be equal to `git ls-files *.xtextbin | wc -l`
- `.gitignore` should no include a pattern matching `*.xtextbin`

## To set versions everywhere

Execute from the `gov.nasa.jpl.imce.oml.tycho` folder:

```shell
 mvn org.eclipse.tycho:tycho-versions-plugin:set-version -DnewVersion={VERSION} -Dtycho.mode=maven
```

where `{VERSION}` follows [semantic versioning](http://semver.org) (e.g., `Major.Minor.Patch` or `Major.Minor.Patch-SNAPSHOT`).

Note that this *should* update all versions in the following locations:

- `pom.xml//project/version`
- `pom.xml//project/parent/version`
- `META-INF/MANIFEST.MF//Bundle-Version`
- `feature.xml//feature/@version`
- `*.product//product/@version`
- `*.product//product/features/feature/@id`
- `category.xml//site/feature[@id=...]/@url`
- `category.xml//site/feature[@id=...]/@version`

Check carefully the log to make sure all versions have been properly updated.
Check with `git status` and/or `git diff` to confirm the changes.

## Deployment

TODO: Explore using maven profiles to decouple deployment info.

### Artifactory publishing

In `~/.m2/settings.xml` include, replacing `{ARTIFACTORY USERNAME}` and `{ARTIFACTORY APIKEY}` with appropriate credentials.

```
<?xml version="1.0" encoding="UTF-8"?>
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                      http://maven.apache.org/xsd/settings-1.0.0.xsd/"> 
  <servers>
    <server>
      <id>artifactory</id>
      <username>{ARTIFACTORY USERNAME}</username>
      <password>{ARTIFACTORY APIKEY}</password>
    </server>
  </servers>
</settings>
```

## Bintray publishing (currently disabled because some artifacts exceed the size limit on bintray)

In `~/.m2/settings.xml` include, replacing `{BINTRAY USERNAME}` and `{BINTRAY APIKEY}` with appropriate credentials.

```
<?xml version="1.0" encoding="UTF-8"?>
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                      http://maven.apache.org/xsd/settings-1.0.0.xsd/"> 
  <servers>
    <server>
      <id>bintray</id>
      <username>{BINTRAY USERNAME}</username>
      <password>{BINTRAY APIKEY}</password>
    </server>
  </servers>
</settings>
```

## Eclipse/Tycho Notes

### Eclipse Neon.3 Development Notes

#### Launching the OML Workbench from the Eclipse IDE

- Do not launch the [releng/gov.nasa.jpl.imce.oml.product/gov.nasa.jpl.imce.oml.rcp.product](releng/gov.nasa.jpl.imce.oml.product/gov.nasa.jpl.imce.oml.rcp.product)

	This will fail because of supposedly missing dependencies. 
	
- Use instead this [launcher](launchers/gov.nasa.jpl.imce.oml.rcp.product.launch)
	
	- 1) Open the [launcher](launchers/gov.nasa.jpl.imce.oml.rcp.product.launch)
	
	- 2) Under the "Plug-Ins" tab, click "Add Required" (this will modify the file to include platform-specific dependencies); Apply.

	- 3) Verify that all dependencies are satisfied
	
	- 4) Run or Debug
	
- Note: When shutting down the runtime OML Workbench, the following NPE may happen: https://bugs.eclipse.org/bugs/show_bug.cgi?id=522075

	These NPEs do not happen when shuttting down an installation of the OML Workbench; that is, these NPEs seem to be a behavior that is specific to launching the OML Workbench as a runtime Eclipse.

### Problems with uploading P2 update sites with bintray's "explode=1" option

See [releng/gov.nasa.jpl.imce.oml.updatesite/README.md](gov.nasa.jpl.imce.oml.updatesite)

### Problems with Tycho's verbose log output

Eclipse/Tycho produces too much output:

```
The log length has exceeded the limit of 4 MB (this usually means that the test suite is raising the same exception over and over).
The job has been terminated
```
(see https://travis-ci.org/JPL-IMCE/gov.nasa.jpl.imce.oml/builds/268822997#L3010)

By default, Eclipse/Tycho logs at INFO level; it is surprisingly very difficult to log at a different level, e.g, WARN:
https://stackoverflow.com/questions/4782089/how-to-change-maven-logging-level-to-display-only-warning-and-errors

For Travis-CI, the brute-force solution seems to be the simplest solution for now:
https://stackoverflow.com/a/15317762/1009693

The Eclipse/Tycho needs to be replaced with a build technology that is easier to configure; e.g. Gradle or SBT.

If this happens, get the "Raw log" from travis: https://api.travis-ci.org/jobs/<number>/log.txt?deansi=true

This will show all output lines, even if there are special characters to erase them.
For example, during deployment, there are lots of progress lines like this:

```
Progress (1): 29/659 kB
Progress (1): 31/659 kB
Progress (1): 33/659 kB
Progress (1): 35/659 kB
```

Filtering these lines is essential to avoid the 4Mb output limit.

### Troubleshooting P2 repository problems.

If the Java security permissions allow, use the Java WebStart Launcher.
Otherwise: 

- Clone the [P2 Browser](https://github.com/ifedorenko/p2-browser)
- Build it locally (`mvn clean package`)
- Launch from `com.ifedorenko.p2browser.rcp/target/products/com.ifedorenko.p2browser.rcp`

The P2 Browser is a simple UI; under the "Repositories" panel, click "Add..." and enter the URL of a P2 repo.
The left panel shows a tree explorer for the contents of repositories added.
