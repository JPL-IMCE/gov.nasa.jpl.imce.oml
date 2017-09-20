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
    mvn org.eclipse.tycho:tycho-versions-plugin:set-version -DnewVersion=$V -Dtycho.mode=maven -Dproperties=oml.version;
    echo "# Review the changes and confirm before proceeding";
    git status;
    git diff;
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

