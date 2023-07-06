# Spondon (Android App)

Spondon is an Android application designed to help users monitor and track their blood pressure and heart rate measurements. The app provides a convenient platform for users to store their systolic pressure, diastolic pressure, heart rate, along with a date and time stamp. Additionally, users can add comments to each measurement to provide further context or notes. Spondon utilizes a login and signup page to ensure user privacy and data security.

## Objectives
- Develop a user-friendly Android app for tracking blood pressure and heart rate data.
- Create a record page for adding, editing, and deleting measurements with date, time, pressure readings, heart rate, and comments.

## Features

- **Login and Signup**: Spondon offers a secure login and signup functionality, allowing users to create an account or access their existing account.

- **Measurement Recording**: The app enables users to input their systolic pressure, diastolic pressure, heart rate, along with the date and time of the measurement. To select the date and time, Spondon incorporates a datepicker and timepicker for user convenience.

- **Firebase Database Integration**: Spondon seamlessly integrates with Firebase database technology to store and retrieve user data. This ensures that measurements and associated information are securely saved in the cloud.

- **CardView Display**: The recorded data is presented in a user-friendly format using CardView. Each measurement is displayed as a separate card, making it easy to browse and review the recorded information.

- **Edit and Delete Functionality**: Spondon allows users to edit and delete their recorded measurements. By clicking on the respective options, users can modify the existing data or remove it from their records.

- **Data Persistence**: When editing a measurement, Spondon opens a new intent while retaining the previously entered data. This ensures that users can make changes without having to re-enter all the information.

- **Confirmation Toasts**: To provide feedback and confirmation to users, Spondon displays toast messages for every action taken. This helps users stay informed about the success of their operations, such as saving, editing, or deleting a measurement.

- **Detailed View**: Clicking on a card in the main activity opens a new intent that provides a detailed view of the selected measurement. This view allows users to explore additional information or review the recorded data in greater detail.

## Technologies used

- Android Studio
- Java
- Firebase realtime database
- Firebase authentication

## Project(App UI) Screenshots
![Screenshot](https://github.com/Ankon0048/Spondon/blob/main/login%20and%20signUp%20new.png)
![Screenshot](https://github.com/Ankon0048/Spondon/blob/main/card%20view%20new.png)
![Screenshot](https://github.com/Ankon0048/Spondon/blob/main/Add%20update%20new.png)
![Screenshot](https://github.com/Ankon0048/Spondon/blob/main/Time%20and%20Date%20new.png)

## Project Storyboard
![Storyboard](https://github.com/Ankon0048/Spondon/blob/main/storyboard.png)

## Project Demo Video

<div align="center">

  https://github.com/Ankon0048/Spondon/assets/121546552/c5292541-0e97-4cb3-88ac-4beb25dffbbc

</div>

## Conclusion

Spondon is an Android app that empowers users to monitor their blood pressure and heart rate. With its intuitive interface, Firebase integration, and features like CardView display and edit/delete functionality, Spondon offers a reliable solution for health tracking. Take control of your health with Spondon and stay informed about your vital signs.
