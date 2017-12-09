package com.example.badge.androidapplication;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.JsonWriter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.badge.androidapplication.Controllers.FireBase;
import com.example.badge.androidapplication.Controllers.QuoteController;
import com.example.badge.androidapplication.Models.Quote;
import com.example.badge.androidapplication.Models.QuoteCategory;
import com.google.firebase.auth.FirebaseAuth;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Browse extends AppCompatActivity {

    public static String EXTRA_MESSAGE = "DisplayQuote";
    private static final String TAG = "BROWSE ACTIVITY!!!" ;

    public Button inspiration, fitness, wisdom, life, funny, love;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);

        //Declare my variables to be used. These are now assigned to the views buttons.
        inspiration = (Button) findViewById(R.id.inspiration);
        fitness = (Button) findViewById(R.id.fitness);
        wisdom = (Button) findViewById(R.id.wisdom);
        life = (Button) findViewById(R.id.life);
        funny = (Button) findViewById(R.id.funny);
        love = (Button) findViewById(R.id.love);


    }

    /**
     * Determine what button is being pressed after finding that information send it in an extra messsage.
     */
    public void determineButtonTopic(View v) {

            switch(v.getId()) {
                case R.id.inspiration:
                    Log.d(TAG, "determineButtonTopic: " + "Inspiration!!!!");
                    EXTRA_MESSAGE = "Inspiration";
                    displayQuote(EXTRA_MESSAGE);
                    break;
                case R.id.fitness:
                    EXTRA_MESSAGE = "Fitness";
                    displayQuote(EXTRA_MESSAGE);
                    break;
                case R.id.wisdom:
                    EXTRA_MESSAGE = "Wisdom";
                    displayQuote(EXTRA_MESSAGE);
                    break;
                case R.id.life:
                     EXTRA_MESSAGE = "Life";
                    displayQuote(EXTRA_MESSAGE);
                    break;
                case R.id.love:
                    EXTRA_MESSAGE = "Love";
                    displayQuote(EXTRA_MESSAGE);
                    break;
                case R.id.funny:
                    EXTRA_MESSAGE = "Funny";
                    displayQuote(EXTRA_MESSAGE);
                    break;
                default:
                    throw new RuntimeException("Unknown button ID");
            }
    }
    public void displayQuote(String extra) {
        try {
            Intent intent = new Intent(this, QuoteDisplay.class);

            intent.putExtra("extra", extra);
            startActivity(intent);
        }
        catch (Exception e) {
            Log.d("Main Activity TRANSFER", e.toString());
        }
    }


    public void settings(View view) {
        try {
            startActivity(new Intent(this, Settings.class));
        }
        catch (Exception e) {
            Log.d("Main Activity TRANSFER", e.toString());
        }
    }



//    public void displayQuote(View view) {
//        try {
//            Intent intent = new Intent(this, QuoteDisplay.class);
//            Quote quote = QuoteController.getRandomQuote(QuoteCategory.Funny);
//            Log.d("Quote toString()", "HERE\'S A QUOTE: " + quote.getQuoteText());
//
//            //Serialize Quote to JSON
//            Gson gson = new Gson();
//            String quoteJson = gson.toJson(quote, Quote.class);
//            intent.putExtra(EXTRA_MESSAGE, quoteJson);
//
//            startActivity(intent);
//        }
//        catch (Exception e) {
//            Log.d("Main Activity TRANSFER", e.toString());
//        }
//    }

    public void testNotif(View view) {
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        android.support.v4.app.NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.common_full_open_on_phone)
                        .setContentTitle("My notification")
                        .setContentText("Hello World!");

        Intent intent = new Intent(this, QuoteDisplay.class);

        PendingIntent resultPendingIntent =
                PendingIntent.getActivity(
                        this,
                        0,
                        intent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);

        manager.notify(001, mBuilder.build());
    }

//    public void Test(View view) {
//        try {
//            Intent intent = new Intent(this, QuoteDisplay.class);
//            Quote quote = new Quote();
//            quote.setQuoteText("Hello World");
//            quote.setQuoteSource("Someone new");
//            Log.d("Quote toString()", "HERE\'S A QUOTE: " + quote.getQuoteText());
//
//            //Serialize Quote to JSON
//            Gson gson = new Gson();
//            String quoteJson = gson.toJson(quote, Quote.class);
//            intent.putExtra(EXTRA_MESSAGE, quoteJson);
//
//            startActivity(intent);
//        }
//        catch (Exception e) {
//            Log.d("Main Activity TRANSFER", e.toString());
//        }
//    }

}





//Quote q = new Quote("Just Do IT!! Just Do it!!!", "NA", "NA");

//        //Get the current instance of a user.
//        mAuth = FirebaseAuth.getInstance();
//
//        fb.addFunnyQ(q);
//
//        FirebaseUser fbu = mAuth.getCurrentUser();
//
//        fb.getUser(fbu);
//        fq = fb.getFunnyQuotes();