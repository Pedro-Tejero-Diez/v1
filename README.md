# Java Backend Developer Challenge

- **Author: Pedro Tejero Diez**

## Table of Contents

- [**Prerequisites**](#prerequisites)
- [**Getting Started**](#getting-started)
- [**Endpoints**](#endpoints)


## Prerequisites

Before you begin, ensure you have met the following requirements:

- Install [MongoDB](https://www.mongodb.com/docs/manual/installation/) and [mongo shell](https://www.mongodb.com/docs/mongodb-shell/) in your computer.
- Also [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html) 8 or higher is needed.


## Getting Started

1. Clone the repository in your computer or Download the executable compressed file from the project root directory: 
*v1-0.0.1-SNAPSHOT.jar*

2. Open your MongoDB Atlas or console and create a database with the name "*skins*"

3. Open a terminal window in your mongo shell directory, execute mongos.exe and create the following user: 

         db.createUser({
         user: "admin_challenge",
         pwd: "BYBcMJEEWw5egRUo",
         roles: [
         { role: "dbOwner", db: "skins" }
         ]
         });
   
4. Decompressed and run the *JAR* file (Open your console in the folder you have downloaded the jar file and type: *java -jar v1-0.0.1-SNAPSHOT.jar*) or run the main application from your IDE to initiate the web application service in your computer.

5. You can import the playerskin data example in **src/main/resources/json** for testing the service or *create new ones* using the web application by first going to the */skins/available* endpoint and buying player skins that will be added to the player skins database so that you will be able to test the other endpoints.


## Endpoints

1. The web application has the following endpoints:
    - */skins/available*: shows the list of skins with the posibility of buying them (button "buy")

    - */skins/myskins*: shows the  player bought skins and the posibilities of changing skin color (writing the new color name and pressing the "change color" button will make the change). And the posibility of deleting the skin from the playerskin database.

    - other endpoints you can access from the web application  or if you know the id of the playersking are: 
        
       - */skins/getone/{id}*: shows a specific player skin in a table where you can change the color or delete it.
       - */skins/color/{id}*:  in the previous endpoint, you can write the new color for your skin and press "change color" button to get to this endpoint
       - */skins/delete/{id}*: in the same way, if you press the "delete" button in the getone endpoint, the playerskin will be deleted from the players database

2. *To check any of this endpoints you have to introduce them in your navigator adding "localhost:8762" before the endpoint.*


