### Release process

```shell
export V=<major>.<minor>.<patch>.<build>
git branch $V
git checkout $V
mvn org.eclipse.tycho:tycho-versions-plugin:set-version -DnewVersion=$V -Dtycho.mode=maven -Dproperties=oml.version 
```

Edit [pom.xml](../pom.xml), replacing `/project/build/plugins/plugin[2]/configuration/target/artifact/version` with `$V`

```
git add -A
git commit -S -m"Release $V"
git push -u origin $V
```

Verify the build on https://travis-ci.org/JPL-IMCE/gov.nasa.jpl.imce.oml.tycho
(However, see: https://github.com/JPL-IMCE/gov.nasa.jpl.imce.oml.tycho/issues/13)

```shell
mvn clean verify
mvn deploy
```
  