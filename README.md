# 🩺 AR Medical Educational Application

An **Augmented Reality (AR) Educational Application** developed to provide an interactive and immersive learning experience through **3D models and real-time visualization**.

**Demo Video Link:** https://drive.google.com/file/d/1r5J8tzhg4xoTdt5fCcqvIokV55mCB4Br/view?usp=drive_link

The application is designed to make medical learning more engaging by allowing users to explore educational content and visualize concepts in an interactive environment.

## 📌 Project Overview

Traditional learning methods can make it difficult to understand complex medical concepts. This project uses **Augmented Reality** to enhance the learning experience by combining educational content with interactive visual elements.

The application provides different medical learning categories and dynamically loads available lessons from Firebase. Users can select a topic and access the corresponding learning content.

## ✨ Features

* 🥽 Augmented Reality-based learning
* 🧊 Interactive 3D model visualization
* 📚 Medical educational content
* 🔥 Firebase database integration
* 🔐 User authentication
* 👤 User profile management
* 📱 Android mobile application
* 🌙 Light and dark mode
* 🧭 Navigation drawer for easy application navigation
* 📖 Category-based learning modules

## 🛠️ Technologies Used

* **Java**
* **Android Studio**
* **Android SDK**
* **Firebase Authentication**
* **Firebase Realtime Database**
* **XML**
* **3D / AR Technologies**
* **Material Design Components**

## 🏗️ Application Architecture

```text
User
 │
 ▼
Android Application
 │
 ├── User Authentication
 │
 ├── Learning Dashboard
 │
 ├── Medical Categories
 │
 ├── AR / 3D Visualization
 │
 └── User Profile
 │
 ▼
Firebase
 ├── Authentication
 └── Realtime Database
```

The application uses Firebase Realtime Database to retrieve lesson information dynamically. The Android code checks lesson values from Firebase and displays the corresponding learning categories when they are available.

## 📚 Learning Modules

The application includes medical learning modules such as:

* ❤️ Heart
* 🧠 Brain
* 🫁 Lungs
* 🦴 Spinal System
* 🫘 Kidneys
* 🚻 Urinary System

The selected category is passed to the corresponding learning activity for further interaction.

## 🔐 User Management

The application supports user authentication using **Firebase Authentication**.

User profile information such as name, email, contact details, and birth date is retrieved from Firebase and used within the application.

The application also provides a logout functionality that signs the user out through Firebase Authentication.

## 🌙 Dark Mode

The application provides a light/dark mode switch. The selected mode is stored using Android `SharedPreferences`, allowing the application to retain the user's preference.

## 📱 Application Navigation

A navigation drawer is implemented to provide access to different sections of the application, including:

* Home
* Profile
* Settings
* Learning Content
* Cart
* Logout

The application uses Android's `DrawerLayout`, `NavigationView`, and `ActionBarDrawerToggle` for navigation.

## 🎯 Project Objectives

* To provide an interactive approach to medical education
* To improve understanding of complex medical concepts through visualization
* To integrate AR and 3D models into mobile learning
* To provide structured medical learning modules
* To create an engaging and user-friendly educational application

## 👩‍💻 My Role

**Role: AR Development, 3D Model Integration, UI Design & Application Testing**

Responsibilities included:

* Developing AR-based learning functionality
* Integrating 3D models and visual learning elements
* Designing and improving the Android user interface
* Implementing application navigation
* Integrating Firebase services
* Testing application functionality and user interaction

## 🚀 Future Enhancements

* Add more medical 3D models
* Expand the number of learning modules
* Add interactive labels and animations to 3D models
* Include quizzes and assessments
* Add progress tracking for learners
* Improve AR interactions
* Deploy the application for wider educational use

## 👥 Project Type

**Academic / Team Project**

### Project Title

**Augmented Reality Educational Application**

## ⚠️ Disclaimer

This application is intended for **educational purposes** and should not be considered a substitute for professional medical advice, diagnosis, or treatment.
