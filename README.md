# It's a trap, we are vulnerable

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

The project contain all the logic to have a real scenario about an application which have acceptable coverage of testing on Sonar.


## Table of contents

The following are the most important topics in this file:
- [Requirements](#Requirements)
- [Check requirements](#check-requirements)
- [Structure](#Structure)
- [Technologies](#pipeline-steps)
- [Run the CI](#run-the-ci)
- [Considerations](#Considerations)
- [FAQ](#faw)
- [Further readings](#further-readings)


# Requirements

To use these tools you need to have in your machine the following things:
- [Java](https://www.oracle.com/ar/java/technologies/javase-jdk11-downloads.html)
- [Maven](https://maven.apache.org/)
- [Git](https://git-scm.com/)
- [Docker](https://www.docker.com/)

If you don't have some of these tools in your machine installed, please follow the instructions in the official documentation of each tool.

## Check requirements

If you have installed on your machine some of these tools previously or you installed all the tools now, please check if everything works fine.
- Check which version of Java you have using the following command:
   ````
   % java -version
   openjdk version "11.0.8" 2020-07-14
   OpenJDK Runtime Environment (build 11.0.8+10)
   OpenJDK 64-Bit Server VM (build 11.0.8+10, mixed mode, sharing)
   ````
- Check whether your Maven version is 3.0.0 or up. You can see which version of Maven you have using the following command:
   ````
   % mvn --version
   Apache Maven 3.0.0
   Maven home: /usr/share/maven
   ````
- Check whether the version of Docker in your machine is 18.09.0 or higher. You can check the version of Docker using the following command:

   ````
   % docker --version
   Docker version 18.09.0, build 369ce74a3c
   ````

# Structure

The CI use [Jenkins](https://www.jenkins.io/) which is one of the most used tools. To reduce the complexity in the configuration the tool is preconfigured with the microservice. The only thing that you need to do is build and run the dockerfiles and open a browser.


# Technologies

The microservices use some frameworks/libraries:
- **[spring-boot](https://spring.io/projects/spring-boot)** is a common framework to develop a Java application easily because most of the things have a simple configuration.
- **[springdoc-openapi](https://springdoc.org/)** is an implementation of the standard of Open API 3 to document the different endpoints of the microservices. Also, give you the chance to test each endpoint with some data of example.
- **[orika](https://orika-mapper.github.io/orika-docs/)** is a library that helps to map the values from one object to another.
- **[snakeyaml](https://bitbucket.org/asomov/snakeyaml/src/master/)** is a library to use YML files as resources in the different microservices.


# Run the CI

To run the CI, please follow these steps:
1. Clone the repository using this command **git clone git@github.com:andres-sacco/we-are-vulnerable.git**
2. Open a terminal in the root directory and run **docker-compose build** this command builds some images that exist in the repository. After doing that, run **docker-compose up** to run all the tools.
3. If everything works fine, open a web browser in the URL which appears in the documentation section.
- [Jenkins](http://localhost:18080/)


# Considerations

There are some considerations in the use of these tools:

1. Some tools of this CI could have some problems with the limit of virtual memory. When you run the dockerfiles, check if some errors appear in the console related to "Max virtual memory areas vm.max_map_count [65530] is too low, increase to at least..". The solution for this kind of problem in Linux/Mac OS run the following command in the console:
   **sysctl -w vm.max_map_count=262144** 
   
2. This repository contains all the configurations to run the pipeline and check the quality of the code without the need to change something.
3. Jenkins does not have any password so you can write the URL in the browser and you will see the general view of the tool. In the case of SonarQube, the password is **asa123**
4. The definition of the steps in each pipeline exists on the directory of the **API**. If you want to change the location of the repository where Jenkins obtains the information of the pipeline, open each file in the folder **jenkins/jobs** and change the URL of the repository.

## FAQ

**Which version of the JDK can I use on this project?**

There is no restriction about which version, in particular, you need to consider that exist different alternatives to the JDK:
* **OracleJDK**: This version was free until Java 11, after this version you can use it for development/test environments, but you need to pay a license to use it on production. This version of the JDK offers to you the most recent patches of bugs and new features because Oracle is the owner of the language.


* **OpenJDK**: When Oracle bought Sun Microsystems created this as an open-source alternative that all the developers can use in any environment without restrictions. The main problem with this version is the patches of the bugs take time to appear in a case that is not critical.


Take into consideration that there are other alternatives but according to [Snyk 2021 Report](https://res.cloudinary.com/snyk/image/upload/v1623860216/reports/jvm-ecosystem-report-2021.pdf), most of the developers use OpenJDK.


**Which tools can I use for development?**

Many free tools support development. Here are two you may like:
- [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/) – IntelliJ is the most widely used IDE for  development.


- [Eclipse](https://www.eclipse.org/downloads/) – Eclipse is another IDE option for Kotlin development. Most plugins are free and have a vast community of developers who frequently update them.

Take into consideration that there are other IDE but according to [Snyk 2021 Report](https://res.cloudinary.com/snyk/image/upload/v1623860216/reports/jvm-ecosystem-report-2021.pdf), most of the JVM developers use Eclipse and Intellij, but the use of Visual Studio code is growing in the last year.



# Further readings

It is not the idea of this repository bring all the information about the pros/cons or more information about the tools that appear here, for that reason the following links could help you to clarify any doubt that you have:

- [Jenkins configuration](https://www.vogella.com/tutorials/Jenkins/article.html)
