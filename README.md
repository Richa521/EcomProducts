# EcomProducts App

This Android app showcases various products retrieved from the endpoint [https://dummyjson.com/products](https://dummyjson.com/products). Users can view a list of products, click on any product to see its details on a separate screen, and utilize swipe-to-refresh functionality to fetch the latest products. The app also auto-refreshes products every 3 minutes, and there's a dedicated UI to show the last refresh time.

## Table of Contents

- [Video Demo](#video-demo)
- [Functional Requirements](#functional-requirements)
- [Technologies Used](#technologies-used)
- [3rd Party Dependencies](#3rd-party-dependencies)
- [Architecture](#architecture)
- [Installation](#installation)
- [Download Instructions](#download-instructions)

## Video Demo

Check out the [video demo](https://drive.google.com/file/d/1gAVqjoWTbulfI0XkPxsjzoBFjbcwHWfL/view?usp=sharing) to see the app in action.


## Functional Requirements

1. **List of Products:**
   - Displays each product as a list item, picking appropriate fields from the response.
   - Clicking on any product shows a separate screen with the full product details.

2. **Refresh Functionality:**
   - Implements swipe-to-refresh to fetch the latest products.
   - Auto-refreshes products every 3 minutes.
   - Dedicated UI to show the last refresh time.

## Technologies Used

- **Language:** Kotlin
- **Networking:** Retrofit
- **Image Loading:** Coil
- **UI:** Jetpack Compose

## 3rd Party Dependencies

- [Retrofit](https://square.github.io/retrofit/): For making network requests.
- [Coil](https://coil-kt.github.io/coil/): For loading and caching images.

## Architecture

The app follows the MVVM (Model-View-ViewModel) architecture pattern:

- **Model:** Represents the data and business logic, including the repository and data access objects.
- **View:** Displays the UI and interacts with the user.
- **ViewModel:** Acts as a bridge between the Model and the View, handling UI-related logic.

## Installation

To use this project, follow these steps:

1. **Clone the Repository:**
git clone https://github.com/Richa521/EcomProducts


2. **Open in Android Studio:**
- Open Android Studio.
- Choose "Open an existing Android Studio project" and select the cloned project.

3. **Build and Run:**
- Build and run the app on an Android emulator or physical device.

## Download Instructions

As the app is not available on the Google Play Store, you can download and install the APK using the following steps:

### 1. Download the APK:

- Click on the [APK link](https://drive.google.com/file/d/1PrxjEFHcYLqT4vYoLWK48CtemJs4Dhs2/view?usp=sharing) to access the APK file on Google Drive.
- Download the APK file to your device, whether it's your phone or your computer.

### 2. Install on Android Studio:

- Open Android Studio.
- In the top menu, click on "File" > "Open" and select the downloaded APK file.
- Android Studio will decompile and open the APK. You can inspect the contents, but note that running a release APK may not be straightforward.

### 3. Install on Android Device:

- On your Android device, go to Settings.
- Navigate to "Security" or "Biometrics and security" (depending on your device).
- Enable "Install unknown apps" or a similar option.
- Open the file manager on your phone and locate the downloaded APK file.
- Tap on the APK file to start the installation.
- Follow the on-screen instructions to complete the installation.

### 4. Run the App:

- If installed through Android Studio, you can explore the app's contents.
- If installed on your Android device, open the app to start exploring the latest news headlines.
