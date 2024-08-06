# CRUD-Operation-using-JDBC
# JDBC CRUD Operations

This document provides a brief overview of performing CRUD (Create, Read, Update, Delete) operations using JDBC (Java Database Connectivity).

## Prerequisites

- Java Development Kit (JDK)
- MySQL or any relational database
- MySQL JDBC Driver (or relevant JDBC driver for other databases)

## Setup

1. **Include the JDBC Driver**:
   Add the JDBC driver to your project's dependencies. For MySQL, include the following in your `pom.xml` (for Maven projects) or download the JAR file and add it to your classpath.

   ```xml
   <dependency>
       <groupId>mysql</groupId>
       <artifactId>mysql-connector-java</artifactId>
       <version>8.0.30</version>
   </dependency>
