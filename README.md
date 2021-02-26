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

<h3><a href="https://prnt.sc/107ows9">A simple UML diagram describing relationships between entities</a><h3>

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
To run the project on your local machine. 
Clone this project into your local folder 
Open the project in an IDE.
Configure Tomcat Server. 
Set up the MySQL DS. 
Set up MySQL Workbench on your machine.
Insert your own MySQL username and login in dbProperties in the ConnectionUtil class.
Your MySQL server must be up and running when you launch the project.
