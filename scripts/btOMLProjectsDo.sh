#!/bin/bash


function vp() {
    version=$1
    echo "# Publish all package versions '$version'...";
    for p in ${projects[*]}; do

	echo "=> $p";
	jfrog bt vp jpl-imce/gov.nasa.jpl.imce.oml/$p/$version
    
    done
}

function vd() {
    version=$1
    echo "# Delete all package versions '$version'...";
    for p in ${projects[*]}; do

	echo "=> $p";
	jfrog bt vd --quiet=true jpl-imce/gov.nasa.jpl.imce.oml/$p/$version 
    
    done
}

function ps() {
for p in ${projects[*]}; do

    echo "#";
    echo "# => $p";
    echo "#";
    jfrog bt ps jpl-imce/gov.nasa.jpl.imce.oml/$p 
    
done
}

declare -a projects

projects[0]=gov.nasa.jpl.imce.oml.root
projects[1]=gov.nasa.jpl.imce.oml.plugins
projects[2]=gov.nasa.jpl.imce.oml.plugins.core
projects[3]=gov.nasa.jpl.imce.oml.uuid
projects[4]=gov.nasa.jpl.imce.oml.model
projects[5]=gov.nasa.jpl.imce.oml.model.edit
projects[6]=gov.nasa.jpl.imce.oml.dsl
projects[7]=gov.nasa.jpl.imce.oml.dsl.ide
projects[8]=gov.nasa.jpl.imce.oml.dsl.ui
projects[9]=gov.nasa.jpl.imce.oml.rcp
projects[10]=gov.nasa.jpl.imce.oml.features
projects[11]=gov.nasa.jpl.imce.oml.features.core
projects[12]=gov.nasa.jpl.imce.oml.core.feature
projects[13]=gov.nasa.jpl.imce.oml.tests
projects[14]=gov.nasa.jpl.imce.oml.tests.core
projects[15]=gov.nasa.jpl.imce.oml.dsl.tests
projects[16]=gov.nasa.jpl.imce.oml.releng
projects[17]=gov.nasa.jpl.imce.oml.target
projects[18]=gov.nasa.jpl.imce.oml.updatesite
projects[19]=gov.nasa.jpl.imce.oml.product

if test $# -eq 1 && test "$1" = "ps"; then
    echo "# Package Show...";
    ps;
elif test $# -eq 2 && test "$1" = "vd"; then
    vd $2;
elif test $# -eq 2 && test "$1" = "vp"; then
    vp $2;
else
    echo "#";
    echo "# Usages:";
    echo "#";
    echo "# Show all package versions";
    echo "$0 ps";
    echo "#";
    echo "# Delete a specific version of all packages, if available";
    echo "$0 vd <version>";
    echo "#";
    echo "# Publish a specific version of all packages, if available";
    echo "$0 vp <version>";
    echo "#";
fi

