# Post Management - Spring Boot & Firebase

Welcome to the repository for the **Spring Boot & Firebase** project. This is a practice project designed to help you integrate **Firebase** with a **Spring Boot** backend, allowing you to perform various Firebase operations such as database management and more.

## Table of Contents
- [Project Description](#project-description)
- [Technologies Used](#technologies-used)
- [Installation](#installation)
- [Running the Application](#running-the-application)
- [Contributions](#contributions)
- [License](#license)

## Project Description
This project demonstrates how to integrate **Firebase Admin SDK** with a **Spring Boot** application. You will learn how to use **Firebase** as a backend service for handling authentication, database operations, and more. The project is designed for practice and to gain familiarity with Firebase in a Spring Boot environment.

## Technologies Used
- **Spring Boot**: A framework for building Java-based web applications.
- **Firebase Admin SDK**: A set of tools for interacting with Firebase services.
- **Java 17**: The programming language used for the application.
- **Lombok**: A Java library that helps reduce boilerplate code.

## Installation
1. Clone the repository:
   git clone https://github.com/yourusername/post-management.git

2. Navigate to the project directory:
   cd post-management

3. Install the project dependencies:
   mvn install

4. Download the Firebase service account key JSON file from the [Firebase Console](https://console.firebase.google.com/).

5. Add your Firebase service account credentials to the project directory. Create a file named `private-key-firestore.json` and insert the following structure:

```json
{
  "type": "service_account",
  "project_id": "your-project-id",
  "private_key_id": "your-private-key-id",
  "private_key": "-----BEGIN PRIVATE KEY-----\nyour-private-key-here\n-----END PRIVATE KEY-----\n",
  "client_email": "your-client-email@your-project-id.iam.gserviceaccount.com",
  "client_id": "your-client-id",
  "auth_uri": "https://accounts.google.com/o/oauth2/auth",
  "token_uri": "https://oauth2.googleapis.com/token",
  "auth_provider_x509_cert_url": "https://www.googleapis.com/oauth2/v1/certs",
  "client_x509_cert_url": "https://www.googleapis.com/robot/v1/metadata/x509/your-client-email%40your-project-id.iam.gserviceaccount.com",
  "universe_domain": "googleapis.com"
}
