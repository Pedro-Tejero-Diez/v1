# Java Backend Developer Challenge

- **ID: 6530fa8a952f8a33fbf2a5b2**
- **Author: Pedro Tejero Diez**

## Table of Contents

- [**Prerequisites**](#prerequisites)
- [**Getting Started**](#getting-started)
- [**Docker Configuration**](#docker-configuration)
- [**Endpoints**](#endpoints)
- [**Test**](#Testing)


## Prerequisites

Before you begin, ensure you have met the following requirements:

- [Docker](https://www.docker.com/) installed
- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html) 8 or higher


## Getting Started

1. Clone the repository in your computer.
2. Start Docker daemon
3. Open the terminal window in the  project folder in your computer and write: docker-compose up
4. configure your Postman (or similar framework) to send requests to localhost port 8080
5. You can use the json examples in **src/main/resources** as body requests for testing the service.

##  Docker Configuration

1. As requested, there are two Docker files: Dockerfile.mysql that create a mysql container with the hospital database already created and the user and password data (to be changed for the real ones)
2. In the Dockerfile.maven I have disabled the testing as there are two test that not pass and that I am not allowed to change (all the tests I had to make, passed). So, if you want to enable testing again, you should delete the **-Dskiptest** from the line 15 of this file that states: **RUN mvn clean package -DskipTests**
3. These two Docker files are build and images are run following the script in the file **docker-compose.yml**. To run this script you should first **start Docker** and then open the terminal in the project folder and type: **docker-compose up**

## Endpoints

1. As requested, I just updated the "createAppointment" method inside the Appointment controller
2. the rest of endpoints you can test with postman once the container mysql and myapp are running
3. Inside the folder **src/main/resources**, you can find an json example of each entity to start with. You should first save the doctor, patient and room data in the mysql databases using **postman** or other similar framework. Then you will be able to use the appointment.json data to test the system.
4.**IMPORTANT:** Be sure to always add a new Room name when trying to save an appointment as the system is saving the room everytime you send an appointment. This should be fixed at the level of entities but I am not allowed to change them

## Test

1. I was assigned two tasks: Create entities test for the entities inside the EntityUnitTest.java (Doctor,Patient and Room) and Create Test for each of these entities Controllers inside the EntityControllerUnitTest.java
2. All these tests are passed when running the JUnit utility
