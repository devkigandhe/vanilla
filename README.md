# Assignment

[Click here to read the assignment](./docs/assignment.md)

## vanilla

This is a base starter kit framework that you can use to build your tests for the above assignment.
However, if you are more comfortable with your own tool kit, feel free to use that as well!

## External dependencies

For this project to run, you would need to install below 3 dependencies on your machine:

- **[Java 11](https://openjdk.java.net/projects/jdk/11/)** (as the core programming language)
- **[Maven 3.8.5](https://maven.apache.org/download.cgi)** (for dependency management)
- **[Google Chrome latest version](https://www.google.com/chrome/?brand=CHBD&gclid=Cj0KCQjwr-SSBhC9ARIsANhzu15P0PA-n9Zp4NpxKaOHVGtBD1TZQH0HlQQE6hUfsOFAU1nf-Rzdlf4aAoTJEALw_wcB&gclsrc=aw.ds)** (browser to run your tests)

> If your JAVA_HOME is set to anything other than JDK 11, you would need to update the path. Else your project
> will not run. Also, do remember to set the correct JDK settings in your IDE.

## Getting Started

For easiest way to getting started, extract this project and open it from IntelliJ.
> Then Do a dry run on test in : test -> java -> TestSandbox class and see if your setup is correct.  

Tip: Do remember to update this readme file for anything else that you think needs updating here!

## Instructions to run the assignment code

This assignment is completed on the vanilla framework itself. It supports running the test on localhost(with chrome and chrome driver installed), Selenium Grid and docker.

Simplest way to run the code on a machine with chrome, maven and jdk 11 installed is to run command `mvn test` and see results in testresult.html

## Salient features of the code

* Execution is based on fluent wait to minimize the execution time.
* Code structure is based on page object model, which is easier to maintain.
* Page structure can be seen following inheritance (Base page contains header/menu which is present on all pages)
* Code also contains a Dockerfile which allows to build docker image on demand. Please see instructions to run the same.
* In non headless mode an additional feature of highlighting the element before performing the action is also implemented.
* In headless mode this feature is automatically turned off to speed up execution time. 
* Integration with extent reports for better visual reporting.

## Test Results

With the integration of extent reports, please do not look at `mvn test` result to interpret test case success or failure rather always refer to the file generated with the name testresult.html in the base folder.

## Instructions for running docker image

* This docker image is based on maven and jdk 11. Since it does not contain chrome it only runs on selenium grid
* Make sure choices.conf is properly modified before generating docker image.
* Please follow below chain of commands to run through docker

1. Modify choices.conf to host as selenium grid and headless as true
2. Modify host.docker.selenium.grid.conf to properly point to localhosts' ip address
3. docker build -t amazontestsuite:latest .
4. docker-compose up -d //this will bring up selenium grid 
5. touch testresult.html
6. docker volume create mvn_cache
7. docker run --rm -v mvn_cache:/root/.m2 -v $(pwd)/testresult.html:/app/testresult.html amazontestsuite:latest