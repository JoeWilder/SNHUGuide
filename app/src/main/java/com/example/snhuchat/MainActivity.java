package com.example.snhuchat;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.snhuchat.dialogflow.DialogflowBot;
import com.google.cloud.dialogflow.v2.QueryResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "mainactivity";
    private EditText userMsgEdt;

    DialogflowBot bot;

    private CampusMap map;

    private LanguageDirections translator;
    private ArrayList<MessageModal> messageModalArrayList;
    private MessageRVAdapter messageRVAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        bot = new DialogflowBot(this);

        map = new CampusMap(getApplicationContext());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView chatsRV = findViewById(R.id.idRVChats);
        ImageButton sendMsgIB = findViewById(R.id.idIBSend);
        userMsgEdt = findViewById(R.id.idEdtMessage);

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
        messageRVAdapter.notifyDataSetChanged();

        String BOT_KEY = "bot";

        CompletableFuture<QueryResult> responseFuture = bot
                .sendMessageToBot(userMsg);
        responseFuture.thenAccept(response ->
               processResponse(response, BOT_KEY)
        );

        responseFuture.join();
    }

    public void processResponse(QueryResult result, String BOT_KEY) {
        String intent = String.valueOf(result.getIntent().getDisplayName());
        String returnMessage = result.getFulfillmentText();

        switch(intent)
        {
            case("Default Welcome Intent"):
                break;
            case("Get Directions"):
                // If response is a follow up response don't return directions
                if (result.getParameters().getFieldsMap().entrySet().isEmpty())
                {
                    break;
                }

                String fieldValue = result.getParameters().getFieldsMap().entrySet().iterator().next().getValue().getStringValue();

                if (fieldValue.equals(""))
                {
                    break;
                }

                List<String> items = Arrays. asList(returnMessage.split("\\s*,\\s*"));

                String startNode = items.get(0).toLowerCase();
                String endNode = items.get(1).toLowerCase();

                List<String> path = map.shortestPath(startNode, endNode);

                translator = new LanguageDirections(path);

                returnMessage = translator.getPath();

                break;
            case("Get Location"):
                break;
            case("Tutoring Generic"):
            case("Tutoring Specific Class"):
                break;
            case("Wellness"):
            case("Wellness Contact"):
            case("Wellness COVID"):
            case("Wellness Medical Records"):
                break;
            default:
                break;
        }

        messageModalArrayList.add(new MessageModal(returnMessage, BOT_KEY));
        messageRVAdapter.notifyDataSetChanged();

    }
}