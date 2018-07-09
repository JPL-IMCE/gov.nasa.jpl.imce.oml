#!/bin/bash

read -p "# Enter version (suggested format <major>.<minor>.<patch/build>): " V
if test -z "$V"; then
  echo "# No version, stop";
else
  read -p "# OK to create a branch 'releases/$V' and set oml.version in POM files to '$V' (y/n) ? " ok1
  if test "y" = "$ok1"; then
    echo "# Creating branch releases/$V";
    git branch releases/$V;
    git checkout releases/$V;
    echo "# Setting versions to '$V' in POM files and META-INF/MANIFEST.MF...";
    mvn \
    	org.eclipse.tycho:tycho-versions-plugin:set-version \
    	-DnewVersion=$V \
    	-Dtycho.mode=maven \
    	-Dproperties=oml.version \
    	-Dartifacts=gov.nasa.jpl.imce.oml.configuration,gov.nasa.jpl.imce.oml.root;
    echo "# Review the changes and confirm before proceeding";
    git status;
    git diff --stat > /tmp/d1
    echo "# git diff --stat ..."
    echo "#--------------------"
    cat /tmp/d1
    echo "#--------------------"
    cat << EOF > /tmp/d2
 features/gov.nasa.jpl.imce.oml.feature/feature.xml                   | 2 +-
 features/gov.nasa.jpl.imce.oml.rcp.feature/feature.xml               | 2 +-
 features/pom.xml                                                     | 2 +-
 plugins/gov.nasa.jpl.imce.oml.dsl.ide/META-INF/MANIFEST.MF           | 2 +-
 plugins/gov.nasa.jpl.imce.oml.dsl.ui/META-INF/MANIFEST.MF            | 2 +-
 plugins/gov.nasa.jpl.imce.oml.dsl/META-INF/MANIFEST.MF               | 2 +-
 plugins/gov.nasa.jpl.imce.oml.model.edit/META-INF/MANIFEST.MF        | 2 +-
 plugins/gov.nasa.jpl.imce.oml.model/META-INF/MANIFEST.MF             | 2 +-
 plugins/gov.nasa.jpl.imce.oml.rcp/META-INF/MANIFEST.MF               | 2 +-
 plugins/gov.nasa.jpl.imce.oml.uuid/META-INF/MANIFEST.MF              | 2 +-
 plugins/gov.nasa.jpl.imce.oml.viewpoint/META-INF/MANIFEST.MF         | 2 +-
 plugins/gov.nasa.jpl.imce.oml.zip/META-INF/MANIFEST.MF               | 2 +-
 plugins/pom.xml                                                      | 2 +-
 pom.xml                                                              | 4 ++--
 releng/gov.nasa.jpl.imce.oml.configuration/pom.xml                   | 4 ++--
 releng/gov.nasa.jpl.imce.oml.product/oml.product                     | 2 +-
 releng/gov.nasa.jpl.imce.oml.product/pom.xml                         | 2 +-
 releng/gov.nasa.jpl.imce.oml.target/pom.xml                          | 2 +-
 releng/gov.nasa.jpl.imce.oml.updatesite/category.xml                 | 2 +-
 releng/gov.nasa.jpl.imce.oml.updatesite/pom.xml                      | 2 +-
 releng/pom.xml                                                       | 4 ++--
 tests/gov.nasa.jpl.imce.oml.dsl.tests/META-INF/MANIFEST.MF           | 2 +-
 tests/gov.nasa.jpl.imce.oml.serialization.tests/META-INF/MANIFEST.MF | 2 +-
 tests/pom.xml                                                        | 4 ++--
 24 files changed, 28 insertions(+), 28 deletions(-)
EOF
    echo "#--------------------"
    echo "# Comparing with expected differences... "
    echo "#--------------------"
    diff /tmp/d1 /tmp/d2
	OK=$?
    echo "#--------------------"
    if [ 0 -eq $OK ]; then
    	echo "# Actual differences match expectations!"
    else
    	echo "# Actual differences do not match expectations; please review!"
    fi
    read -p "# OK to commit, tag and push (y/n) ? " ok2;
    if test "y" = "$ok2"; then
       echo "# Commiting, tagging and pushing...";
       git add -A;
       git commit -S -m"Release $V";
       git tag -s -m"$V" $V;
       git push -u origin releases/$V $V;
       echo "# The releases/$V branch and tag $V have been pushed!";
    else
       echo "# Nothing committed/tagged/pushed!";
    fi;
  else
    echo "# Stop; nothing changed";
  fi;
fi

