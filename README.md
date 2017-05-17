# Tycho organization for OML

## Updating version numbers:

```shell
 mvn org.eclipse.tycho:tycho-versions-plugin:set-version -DnewVersion=0.7.0 -Dtycho.mode=maven
```

Note that this *should* update all versions in the following locations:

- `pom.xml//project/version`
- `pom.xml//project/parent/version`
- `META-INF/MANIFEST.MF//Bundle-Version`
- `feature.xml//feature/@version`
- `*.product//product/@version`
- `*.product//product/features/feature/@id`
- `category.xml//site/feature[@id=...]/@url`
- `category.xml//site/feature[@id=...]/@version`

Beware of exceptions!

- [releng/gov.nasa.jpl.imce.oml.configuration/pom.xml](releng/gov.nasa.jpl.imce.oml.configuration/pom.xml)
- Some `META-INF/MANIFEST.MF//Bundle-Version` may not be updated.
- Some `feature.xml//feature/@version` may not be updated.

## Artifactory publishing

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

