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

import com.example.badge.androidapplication.Controllers.FireBase;
import com.example.badge.androidapplication.Controllers.QuoteController;
import com.example.badge.androidapplication.Models.Quote;
import com.example.badge.androidapplication.Models.QuoteCategory;
import com.google.firebase.auth.FirebaseAuth;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Browse extends AppCompatActivity {

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private QuoteController quoteCtrl;
    private QuoteCategory category;

    //Create storage for the quotes to use. On the next view.
    private List<Quote> funnyQuotes = new ArrayList<>();
    private List<Quote> inspirationQuotes = new ArrayList<>();
    private List<Quote> motivationQuotes = new ArrayList<>();
    private List<Quote> exerciseQuotes = new ArrayList<>();

    //private FireBase fb = new FireBase();

    public static final String EXTRA_MESSAGE = "DisplayQuote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);

        quoteCtrl = new QuoteController();
    }

    //Go to Settings page
    public void settings(View view) {
        try {
            startActivity(new Intent(this, Settings.class));
        }
        catch (Exception e) {
            Log.d("Main Activity TRANSFER", e.toString());
        }
    }

    //Displays a Quote
    public void displayQuote(View view) {
        int id = view.getId();

        switch(id) {
            case R.id.inspiration_button:
                category = QuoteCategory.Inspiration;
                break;
            case R.id.fitness_button:
                category = QuoteCategory.Fitness;
                break;
            case R.id.funny_button:
                category = QuoteCategory.Funny;
                break;
            case R.id.life_button:
                category = QuoteCategory.Life;
                break;
            case R.id.wisdom_button:
                category = QuoteCategory.Wisdom;
                break;
            case R.id.love_button:
                category = QuoteCategory.Love;
                break;
            default:
                return;
        }
        try {
            Intent intent = new Intent(this, QuoteDisplay.class);
            Quote quote = quoteCtrl.getRandomQuote(category);
            Log.d("Quote toString()", "HERE\'S A QUOTE: " + quote.getQuoteText());

            //Serialize Quote to JSON
            Gson gson = new Gson();
            String quoteJson = gson.toJson(quote, Quote.class);
            intent.putExtra(EXTRA_MESSAGE, quoteJson);

            startActivity(intent);
        }
        catch (Exception e) {
            Log.d("Main Activity TRANSFER", e.toString());
        }
    }

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