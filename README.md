# CollinsonProject

Description
Building a vending machine using java and maven selenium testing framework

Built With
Selenium/Maven is a Java-based testing framework built on Selenium, Maven and JUnit. Its aim is to build a Vending machine and carry out end to end functional/ smoke test of its veracity.

Resources
•	Selenium-Java
•	JUnit
•	Git
•	JDK 1.8+
•	Maven 3.3.9+

Prerequisites
Configure maven for the windows - https://maven.apache.org/install.html 
To execute the script run the following command

Execute the code

To get started download the framework and create a project on your local machine as follows:

mvn -Dtest= CollinsonVendingMachineDesign test

      Or
      
simply include the maven dependency in your existing project pom.xml

Project Structure

Your pom.xml should look like this.

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 

http://maven.apache.org/xsd/maven-4.0.0.xsd">
 
 <modelVersion>4.0.0</modelVersion>
  <groupId>Vending</groupId>
  <artifactId>VendingMachineDesign</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  
  <dependencies>
  <!-- https://mvnrepository.com/artifact/junit/junit -->
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.13.1</version>
    <scope>test</scope>
</dependency>
    
  </dependencies>
    
</project>

Running the Vending machine tests

Vending Machine Features:
Feature turn on/off vending machine
Feature list products
Feature insert coins - valid coin - 
Feature get total money inserted
Feature select product - no money/not enough inserted - exact amount inserted - give change - product code doesn't exist - no stock left 

SPECIFICATION

The valid set of actions on the vending machine is:
•	INSERT MONEY – Penny, Five Pence, Ten Pence, Twenty Five Pence 
•	COIN RETURN – returns all inserted money
•	GET-A, GET-B, GET-C – selects item A (£0.60), B (£0.80), or C (£1.00)
•	TURN-ON, TURN-OFF – turns the machine on and off

The valid set of responses from the vending machine is:
•	Penny, Five Pence, Ten Pence, Twenty Five Pence – return coin
•	A, B, C – vend item A, B, or C
•	On / Off – turn on / off

The vending machine must track the following state:
•	Available items – each item has a count, a price, and a selector (A, B or C)
•	Available change – # of Penny, of Five Pence, of Ten Pence and Twenty Five Pence available
•	Currently inserted money
•	Whether the machine is on or off


