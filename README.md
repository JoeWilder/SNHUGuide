# SNHUChat

### Description
SNHUChat is an Android application built in Java that is able to respond to general questions about Southern New Hampshire University.
Different functionality from this project includes getting directions to locations on campus, getting information about certain buildings,
and getting information about certain services provided by Southern New Hampshire University. The application was written in Java using Android Studio.
For the chatbot functionality, Google Cloud Platform is used to interface with DialogFlow.

### Setup
To run this project, you will first need to clone the code from this repository. Next, open the code in Android Studio or your IDE of choice.
To get the project working, you will need to connect to dialogflow. To do this, you will need to create a Google Cloud Platform service account for DialogFlow.
Make sure to give the service account the correct permissions and make sure the account has the DialogFlow API enabled. Once the service account is created,
generate a credentials key. Download this file and place it into the project app/res/raw directory. If the raw directory does not exist, create it. Finally,
make sure that the credentials file is called dialogflowcredentials.json. After a service account has been successfully configured and added to the project, the project
will be ready to be compiled and run.

### Use
To use the project, you can either run it in Android Studio using an Emulator, or you can build it in Android Studio by going to Build, then Build APK
