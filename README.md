# Hello World Maven Local Dependencies

## Overview

This is an example repository demonstrating how to run Maven projects with dependencies on other local Maven projects in the same repository.

This repository contains two Maven projects: `hello-world` and `hello-world-library`. The `hello-world` project has a dependency on the `hello-world-library` which does not exist in the central Maven repo. Use `run.sh` to compile and run the hello world program.

```bash
./run.sh
```

## Repository Structure

The `hello-world-library` declares the following artifact name for its Maven project: `com.example:hello-world-library:1.0-SNAPSHOT`.

```xml
<!-- hello-world-library/pom.xml -->

  ...
  <groupId>com.example</groupId>
  <artifactId>hello-world-library</artifactId>
  <version>1.0-SNAPSHOT</version>
  ...
```

The `hello-world` project, as declared in `hello-world/pom.xml`, depends on the `hello-world-library` which does not exist in the central Maven repo. Maven can only resolve this dependency when compiling the `hello-world` project after the `hello-world-library` has been installed into the local Maven repo.

```xml
<!-- hello-world/pom.xml -->
  ...
  <dependencies>

    <!-- Must install via local repository! See run.sh. -->
    <dependency>
      <groupId>com.example</groupId>
      <artifactId>hello-world-library</artifactId>
      <version>1.0-SNAPSHOT</version>
    </dependency>
    ...
  </dependencies>
  ...
```

## `run.sh`

The `run.sh` script executes three main steps:

1. Installs the `hello-world-library` project to the local Maven repository
2. Compiles the `hello-world` project
3. Runs the compiled `hello-world` project

### 1. Installs the `hello-world-library` project to the local Maven repository

In this step, the script runs `mvn clean install` in the `hello-world-library` directory. This does two things:

1. Packages the project and generates a JAR file
2. Installs the packaged JAR file into the local Maven repository

After running `install`, the JAR file will be available in the local Maven repository and can be referenced from any other Maven projects on this machine.

### 2. Compiles the `hello-world` project

In this step, the script runs `mvn clean compile` in the `hello-world` directory and newly compiles the project. This includes compiling the dependency on `hello-world-library` just added to the local repository in the previous step into the `hello-world` project.

### 3. Runs the compiled `hello-world` project

In this step, the script runs `mvn exec:java -Dexec.mainClass="com.example.HelloWorld"` which executes the `main` function in `HelloWorld.java` as a Java program.
