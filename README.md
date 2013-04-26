# Open Source Vulnerability Assessment Service for AMOS project 2013

these instructions will help you to get the osvas-app running

## Prerequisites

* Basic Java knowledge, including an installed version of the JVM and Maven.
* Basic Git knowledge, including an installed version of Git.
* A Java web application. If you don't have one follow the first step to create an example. Otherwise skip that step.

## Run the Application

To generate the start scripts simply run:

    $ mvn package

And then simply run the script:

    $ sh target/bin/webapp

That's it. Your application should start up on port 8080. You can see the JSP at http://localhost:8080 and the servlet and http://localhost:8080/hello
