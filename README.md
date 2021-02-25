### Philharmonic Project ###
A prototype of an online Philharmonic store with basic functionality for users and admins written in Java.
Project was developed according to SOLID principles with authorization and authentication.

###Structure

###### The project has an N-tier structure and consists of the layers:
* Database layer;
* DAO layer (JDBC API);
* Service layer(contains the business logic);
* Layer with controllers.

###### Clients can perform the following actions:

* register on the store's website;
* log in;
* look through events sold at the store;
* add tickets to their cart;
* delete tickets from the cart;
* place orders.

###### Admins in their turn can:

* view information about registered users;
* view all orders placed at the store;
* add new locations, events and sessions;
* modify exist sessions.

###### Technologies Used:
* Java 11
* Maven 3.1.1
* Maven Checkstyle Plugin
* Javax Servlet API 3.1.0
* JSTL 1.2
* JSP
* Apache Tomcat
* MySQL RDBMS

###### Running the Project
To run the project on your local machine, clone this project into your local folder and open the project in an IDE.
Configure Tomcat Server and set up the MySQL DS and MySQL Workbench on your machine.
Replicate the database from the project by copying the script from init_db.sql into the MySQL Workbench query editor window.
Insert your own MySQL username and login in dbProperties in the ConnectionUtil class.
Your MySQL server must be up and running when you launch the project.
When you launch the website for the first time, click on "Inject data" to add the user and admin data to the DB so that the store works properly.
To log in as a User on the website without registration, you can log in as imp with the password password1234.
To log in as an Admin on the website, you should log in as root with the password 1234.