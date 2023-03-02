package com.example.snhuchat;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.snhuchat.databinding.ActivityMainBinding;
import com.example.snhuchat.dialogflow.DialogflowBot;
import com.google.android.material.snackbar.Snackbar;
import com.google.cloud.dialogflow.v2.QueryResult;

//import com.android.volley.Request;
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.JsonObjectRequest;
//import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MainActivity extends AppCompatActivity {

    private EditText userMsgEdt;

    DialogflowBot bot;

    CampusMap map;

    LanguageDirections translator;

    // creating a variable for array list and adapter class.
    private ArrayList<MessageModal> messageModalArrayList;
    private MessageRVAdapter messageRVAdapter;
    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private final String TAG = "mainactivity";


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
        //RequestQueue mRequestQueue = Volley.newRequestQueue(MainActivity.this);
        //mRequestQueue.getCache().clear();

        messageModalArrayList = new ArrayList<>();

        // adding on click listener for send message button.
        sendMsgIB.setOnClickListener(new View.OnClickListener() {
        map = new CampusMap(getApplicationContext());

        bot = new DialogflowBot(this);

        binding.fab.setOnClickListener(new View.OnClickListener() {
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
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                CompletableFuture<QueryResult> responseFuture = bot
                        .sendMessageToBot("What is the wellnesss center");
                responseFuture.thenAccept(response ->
                        Log.d(TAG, processResponse(response))
                );
            }
        });
    }

    public String processResponse(QueryResult result) {
        String intent = String.valueOf(result.getIntent().getDisplayName());
        String returnMessage = result.getFulfillmentText();

        switch(intent)
        {
            case("Default Welcome Intent"):
                break;
            case("Get Directions"):
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

        return returnMessage;
    }


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

        // url for our brain
        // make sure to add mshape for uid.
        // make sure to add your url.


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