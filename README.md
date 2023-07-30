<h1>ChatApp - Real-time Chat Application</h1>
ChatApp is a real-time chat application built in Kotlin that allows multiple users to chat with each other. The app uses Firebase as the backend to store chat data and user information. Users can log in or sign up using email/password or Google authentication. The chat messages are displayed in a list on the chat fragment, similar to WhatsApp.
<br></br>
<b>Features</b>
<b></b>User Authentication: Users can log in or sign up using email/password or their Google account.<br></br>
<b></b>Real-time Chat: Messages are sent and received in real-time, enabling smooth and instant communication.<br></br>
<b></b>Chat List: The chat fragment displays a list of other users that the user can chat with.<br></br>
<b></b>Message Deletion: Users can delete their chat messages as needed.<br></br>
<h1>Screenshots</h1>
<b>SignUp Page</b>

<!-- Register Page -->
<p align="center"><h1>Register Page Screenshot</h1></p>

![register](https://github.com/Rohit23032003/Chat_App/assets/99860290/2900cdf8-b097-4e1d-b585-7c8b1712b0f2)


<!-- Login Page -->
<p align="center"><h1>Login Page</h1></p>

![login](https://github.com/Rohit23032003/Chat_App/assets/99860290/387d15df-3307-4993-a60f-895b8a65ea6d)


<!-- UserList Page -->
<p align="center"> <h1>User List Page</h1></p>

![userlist](https://github.com/Rohit23032003/Chat_App/assets/99860290/12df1925-2fbb-4c29-bd76-ffb9847dc8e6) 


<!-- Settings Drop Menu -->
<p align="center"><h1>Setting Drop Menue</h1></p>

![settings](https://github.com/Rohit23032003/Chat_App/assets/99860290/204c19ce-0e69-49fb-a6ae-01ef94041cf5)


<!-- Chat Page -->
<p align="center"><h1>Chat Page</h1></p>

![chat](https://github.com/Rohit23032003/Chat_App/assets/99860290/90c3ba48-3bdd-4117-9d8b-41ee9fa69f07)


<h1>Getting Started</h1>
Follow the steps below to set up the project and run the ChatApp on your local machine:

<b>Clone the Repository:</b> Clone this repository to your local machine using git clone.

<h1>Set up Firebase:</h1>

Create a new Firebase project on the Firebase console (https://console.firebase.google.com/).
Enable Firebase Authentication and set up email/password and Google sign-in methods.
Set up the Firebase Realtime Database and configure the rules to manage user access.

<b>Configure Firebase in the App:</b>

Open the project in Android Studio and locate the google-services.json file provided by Firebase.
Add the google-services.json file to the app directory of the project.
Run the App:

Build and run the app on an Android emulator or physical device using Android Studio.
Dependencies
<b>The ChatApp relies on the following major dependencies:</b>

<b>Firebase Authentication: </b>com.google.firebase:firebase-auth<br></br>
<b>Firebase Realtime Database:</b> com.google.firebase:firebase-database<br></br>
<b>Firebase UI for Authentication:</b> com.firebaseui:firebase-ui-auth<br></br>
<b>Kotlin Coroutines: </b>org.jetbrains.kotlinx:kotlinx-coroutines-android<br></br>
<b>Android Support Library:</b> androidx.appcompat:appcompat<br></br>
