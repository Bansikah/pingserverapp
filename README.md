# Ping Server App
This repository contains the code for the ping server application.

## Status
![Build & Deploy Frontend](https://github.com/Bansikah/pingserverapp/actions/workflows/build-frontend.yml/badge.svg) ![Build & Deploy Backend](https://github.com/Bansikah/pingserverapp/actions/workflows/build-backend.yaml/badge.svg) ![Releases](https://github.com/Bansikah/pingserverapp/actions/workflows/release.yml/badge.svg)

## Prerequisites

Before getting started, make sure you have the following tools installed:

- [nvm (Node Version Manager)](https://github.com/nvm-sh/nvm): To manage Node.js versions.
- [Node.js](https://nodejs.org/): Javascript runtime environment.
- - [npm](https://www.npmjs.com/): Package manager for Node.js.
- - [sdkman](https://sdkman.io/): Software Development Kit Manager.
- [Java](https://www.java.com/): Programming Language and runtime environment.
- [Maven](https://maven.apache.org/): Build automation and dependency management tool.
- [Angular](https://github.com/angular/angular-cli): Install Angular cli.
- [Traefik](https://doc.traefik.io/traefik/)

## Installation

Follow the steps below to set up the local environment:

1. Install nvm:
   - Visit the nvm Github repository: (https://github.com/nvm-sh/nvm)
   - Follow the installation instructions for your operating system.

2. Install Node.js and npm using nvm:
   ```bash
   nvm install node
   ```

3. Install sdkman:
   - Visit the sdkman website: https://sdkman.io/
   - Follow the installation instructions for your operating system.

4. Install Java and Maven using sdkman:
   ```bash
   sdk install java
   sdk install maven
   ```

# Getting Started

To run the e2e-banking-app project locally, follow these steps:

1. Clone the repository:
   ```bash
   git clone https://github.com/Bansikah/pingserverapp.git 
   ```

2. Change to the project directory:
   ```bash
   cd pingserverapp
   ```

3. Install project dependencies and Start application:
   
   a. For : serverappfrontend
      - Change to the project directory:
        ```bash
        cd serverappfrontend
        ```
     - Install the Angular CLI globally:
        ```
        npm install -g @angular/cli
        ```
      - Install dependencies:
        ```bash
        npm install
        ```
      - Build the project:
        ```bash
        npm run build or ng build
        ```
      - Start application:
        ```bash
        npm start or ng serve
        ```
     - Acess application on:
       ```
       http://localhost:4200/
       ```

   b. For serverappbackend:
      - Change to the project directory:
        ```bash
        cd serverappbackend
        ```
      - Install dependencies:
        ```bash
        mvn install
        ```
      - Build the project:
        ```bash
        mvn clean package
        ```
      - Start application:
        ```bash
        java -jar target/serverappbackend-0.0.1-SNAPSHOT.jar
        ```
     - Acess application on:
       ```
       http://localhost:8081/
       ```
