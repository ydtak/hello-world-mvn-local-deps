#! /usr/bin/bash

# Runs the hello world program.
# #############################

CURRENT_DIR="$(realpath $(dirname "$0"))"
MAIN_PATH="$CURRENT_DIR/hello-world"
LIBRARY_PATH="$CURRENT_DIR/hello-world-library"

# Package the library and install the packaged JAR into
# the local Maven repository.
cd "$LIBRARY_PATH"
mvn clean install

# Compile and run the main program which depends on the
# packaged library in the local Maven repository.
cd "$MAIN_PATH"
mvn clean compile
mvn exec:java -Dexec.mainClass="com.example.HelloWorld"