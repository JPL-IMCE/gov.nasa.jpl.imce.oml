#!/bin/bash

read -p "# Enter snapshot version (suggested format <major>.<minor>.<patch/build>.qualifier): " V
if test -z "$V"; then
  echo "# No version, stop";
else
  read -p "# OK to set oml.version in POM files to '$V' (y/n) ? " ok1
  if test "y" = "$ok1"; then
    echo "# Setting versions to '$V' in POM files and META-INF/MANIFEST.MF...";
    mvn org.eclipse.tycho:tycho-versions-plugin:set-version -DnewVersion=$V -Dtycho.mode=maven -Dproperties=oml.version;
    echo "# Review the changes and confirm before proceeding";
    git status;
    git diff;
    read -p "# OK to commit and push (y/n) ? " ok2;
    if test "y" = "$ok2"; then
       echo "# Commiting and pushing...";
       git add -A;
       git commit -S -m"Snapshot version $V";
       git push -u origin;
       echo "# The snapshot version $V has been pushed!";
    else
       echo "# Nothing committed/pushed!";
    fi;
  else
    echo "# Stop; nothing changed";
  fi;
fi

