package com.example.snhuchat;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.snhuchat.databinding.ActivityMainBinding;
import com.example.snhuchat.dialogflow.DialogflowBot;
import com.google.android.material.snackbar.Snackbar;
import com.google.cloud.dialogflow.v2.QueryResult;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private final String TAG = "mainactivity";

    DialogflowBot bot;

    CampusMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);


        map = new CampusMap(getApplicationContext());

        Log.d(TAG, "Shortest path from student center to dining hall: "
                + map.shortestPath("studentcenter","dininghall"));

        LanguageDirections translator = new LanguageDirections(map.shortestPath("studentcenter","dininghall"));
        Log.d("MyTag", translator.getPath());

        bot = new DialogflowBot(this);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Log.d(TAG, "button click!");
                CompletableFuture<QueryResult> responseFuture = bot
                        .sendMessageToBot("Where is the wellness center?");
                responseFuture.thenAccept(response ->
                        processResponse(response)
                );
            }
        });
    }

    public String processResponse(QueryResult result) {
        String intent = String.valueOf(result.getIntent());
        String returnMessage = result.getFulfillmentText();

        switch(intent)
        {
            case("Default Welcome Intent"):
                break;
            case("Get Directions"):
                List<String> items = Arrays. asList(returnMessage.split("\\s*,\\s*"));

                String startNode = items.get(0);
                String endNode = items.get(1);

                List<String> path = map.shortestPath(startNode, endNode);

                for(String s : path)
                {
                    Log.d(TAG, s);
                }
                //Calls the natural language conversion function

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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

}