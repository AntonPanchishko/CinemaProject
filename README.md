### Philharmonic Project

A prototype of an online store for Philharmonia.
Realized basic functionality for users and admins written in Java.
Project was developed according to SOLID and REST principles with authorization and authentication.

### Structure

##### The project has an N-tier structure and consists of the layers:
* Database layer;
* DAO layer (JDBC API);
* Service layer(contains the business logic);
* Layer with controllers.

##### Entities diagram

<img src= "https://raw.githubusercontent.com/AntonPanchishko/img/main/spring-011.png" alt = "fitness_booking_uml" width = "700" />

##### Clients can perform the following actions:    

* register on the store's website;
* log in;
* Having access to the shopping cart
* Creating orders
* Viewing user's orders and its details
* Viewing user's details and it's updating

##### Admins in their turn can:

* Creating, updating and deleting products
* Creating, updating and deleting users
* Managing users' roles
* Deleting orders, having access to its details

##### Technologies Used:

* Java 8
* Maven 3.1.1
* Maven Checkstyle Plugin
* Javax Servlet API 3.1.0
* JSTL 1.2
* JSP
* Apache Tomcat
* MySQL RDBMS

##### Running the Project:

* Download and install the JDK.
* Download and install servlet container (for example Apache Tomcat).
* Download and install MySQL Server.

Find file 'db.properties' in package 'resources' and change the parameters that are valid for you:

  username: "username";
  password: "password";
  
Run the project.
