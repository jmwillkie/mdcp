#!/bin/sh
BASE=`dirname $0`
GENERATED=$BASE/../../generated;
SOURCE=$GENERATED/src;
JAVA_SOURCE=$SOURCE/java;

if [ -d $GENERATED ]; then
    echo $GENERATED directory already exists;
else
    echo creating directory $GENERATED;
    mkdir $GENERATED
fi

if [ -d $SOURCE ]; then
    echo $SOURCE directory already exists;
else
    echo creating directory $SOURCE;
    mkdir $SOURCE
fi

if [ -d $JAVA_SOURCE ]; then
    echo $JAVA_SOURCE directory already exists;
else
    echo creating directory $JAVA_SOURCE;
    mkdir $JAVA_SOURCE
fi

idlj -v -td $JAVA_SOURCE MDCF.idl
