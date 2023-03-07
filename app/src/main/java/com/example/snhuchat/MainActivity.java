package com.example.snhuchat;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText userMsgEdt;

    // creating a variable for array list and adapter class.
    private ArrayList<MessageModal> messageModalArrayList;
    private MessageRVAdapter messageRVAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // on below line we are initializing all our views.
        // creating variables for our
        // widgets in xml file.
        RecyclerView chatsRV = findViewById(R.id.idRVChats);
        ImageButton sendMsgIB = findViewById(R.id.idIBSend);
        userMsgEdt = findViewById(R.id.idEdtMessage);

        // below line is to initialize our request queue.
        // creating a variable for
        // our volley request queue.
        //mRequestQueue.getCache().clear();

        messageModalArrayList = new ArrayList<>();

        // adding on click listener for send message button.
        sendMsgIB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // checking if the message entered by user is empty or not.
                if (userMsgEdt.getText().toString().isEmpty()) {
                    // if the edit text is empty display a toast message.
                    Toast.makeText(MainActivity.this, "Please enter your message..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // calling a method to send message to our bot to get response.
                sendMessage(userMsgEdt.getText().toString());

                //setting text in our edit text as empty
                userMsgEdt.setText("");
            }
        });

        //initializing our adapter class and passing our array list to it.
        messageRVAdapter = new MessageRVAdapter(messageModalArrayList, this);

        //creating a variable for our linear layout manager.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);

        // layout manager to our recycler view.
        chatsRV.setLayoutManager(linearLayoutManager);

        // setting adapter to our recycler view.
        chatsRV.setAdapter(messageRVAdapter);
    }

    private void sendMessage(String userMsg) {
        // below line is to pass message to our
        // array list which is entered by the user.
        String USER_KEY = "user";
        messageModalArrayList.add(new MessageModal(userMsg, USER_KEY));
        //messageRVAdapter.notifyDataSetChanged();

        //String url = "Enter you API URL here" + userMsg;
        String response = "Good Morning! How are you";
        String BOT_KEY = "bot";
        if(userMsgEdt.getText().toString().contains("Hi ")){
            messageModalArrayList.add(new MessageModal("Hello", BOT_KEY));
        }
        else if(userMsgEdt.getText().toString().contains("Good morning")){
            messageModalArrayList.add(new MessageModal(response, BOT_KEY));
        }
        else{
        //messageModalArrayList.add(new MessageModal(response, BOT_KEY));
        messageModalArrayList.add(new MessageModal("Sorry no response found", BOT_KEY));
        }
        // notifying our adapter as data changed.
        messageRVAdapter.notifyDataSetChanged();
        // creating a variable for our request queue.
        //RequestQueue queue = Volley.newRequestQueue(MainActivity.this);

        // on below line we are making a json object request for a get request and passing our url .

        // at last adding json object
        // request to our queue.
    }
}