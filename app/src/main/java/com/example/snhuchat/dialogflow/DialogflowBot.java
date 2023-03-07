package com.example.snhuchat.dialogflow;

import android.content.Context;
import android.util.Log;

import com.example.snhuchat.R;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.dialogflow.v2.DetectIntentRequest;
import com.google.cloud.dialogflow.v2.QueryInput;
import com.google.cloud.dialogflow.v2.QueryResult;
import com.google.cloud.dialogflow.v2.SessionName;
import com.google.cloud.dialogflow.v2.SessionsClient;
import com.google.cloud.dialogflow.v2.SessionsSettings;
import com.google.cloud.dialogflow.v2.TextInput;
import com.google.common.collect.Lists;

import java.io.InputStream;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class DialogflowBot {
    private SessionsClient sessionsClient;
    private SessionName sessionName;
    private final String uuid = UUID.randomUUID().toString();
    private final String TAG = "dialogflowbot";


    public DialogflowBot(Context context) {
        initializeBot(context);
    }


    // create a new dialogflow session using the credentials file
    private void initializeBot(Context context) {
        try {
            InputStream stream = context.getResources().openRawResource(R.raw.dialogflowcredentials);
            GoogleCredentials credentials = GoogleCredentials.fromStream(stream)
                    .createScoped(Lists.newArrayList("https://www.googleapis.com/auth/cloud-platform"));
            String projectId = ((ServiceAccountCredentials) credentials).getProjectId();
            SessionsSettings.Builder settingsBuilder = SessionsSettings.newBuilder();
            SessionsSettings sessionsSettings = settingsBuilder.setCredentialsProvider(
                    FixedCredentialsProvider.create(credentials)).build();
            sessionsClient = SessionsClient.create(sessionsSettings);
            sessionName = SessionName.of(projectId, uuid);
            Log.d(TAG, "projectId: " + projectId);
        } catch(Exception e) {
            Log.d(TAG, "setUpBot: " + e.getMessage());
        }
    }


    // asynchronously send a query to dialogflow and return the agent's response, or null if
    // there was an issue getting a response
    public CompletableFuture<QueryResult> sendMessageToBot(String message) {
        QueryInput input = QueryInput.newBuilder()
                .setText(TextInput.newBuilder().setText(message).setLanguageCode("en-US"))
                .build();

        // return a CompletableFuture that will eventually contain the agent's response or
        return CompletableFuture.supplyAsync(() -> {
            try {
                DetectIntentRequest detectIntentRequest =
                        DetectIntentRequest.newBuilder()
                                .setSession(sessionName.toString())
                                .setQueryInput(input)
                                .build();
                // send the DetectIntentRequest to Dialogflow and return the response

                return sessionsClient.detectIntent(detectIntentRequest).getQueryResult();
            } catch (Exception e) {
                Log.d(TAG, "dialogflow error: " + e.getMessage());
                e.printStackTrace();
                return null;
            }
        });
    }


    // close the session to free up resources
    public void closeBot() {
        if (sessionsClient != null) {
            sessionsClient.shutdownNow();
        }
    }


    // reopen the session to make dialogflow calls
    public void reopenBot(Context context) {
        if (sessionsClient != null && !sessionsClient.isShutdown()) {
            sessionsClient.shutdownNow();
        }
        initializeBot(context);
    }
}
