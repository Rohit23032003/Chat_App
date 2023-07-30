<h1>ChatApp - Real-time Chat Application</h1>
ChatApp is a real-time chat application built in Kotlin that allows multiple users to chat with each other. The app uses Firebase as the backend to store chat data and user information. Users can log in or sign up using email/password or Google authentication. The chat messages are displayed in a list on the chat fragment, similar to WhatsApp.
<br></br>
<b>Features</b>
<b></b>User Authentication: Users can log in or sign up using email/password or their Google account.<br></br>
<b></b>Real-time Chat: Messages are sent and received in real-time, enabling smooth and instant communication.<br></br>
<b></b>Chat List: The chat fragment displays a list of other users that the user can chat with.<br></br>
<b></b>Message Deletion: Users can delete their chat messages as needed.<br></br>
<h1>Screenshots</h1>
Insert screenshots of the app here, showcasing its main features.

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
