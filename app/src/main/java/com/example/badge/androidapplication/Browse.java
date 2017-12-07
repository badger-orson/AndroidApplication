package com.example.badge.androidapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonWriter;
import android.util.Log;
import android.view.View;

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

    //Create storage for the quotes to use. On the next view.
    private List<Quote> funnyQuotes = new ArrayList<>();
    private List<Quote> inspirationQuotes = new ArrayList<>();
    private List<Quote> motivationQuotes = new ArrayList<>();
    private List<Quote> exerciseQuotes = new ArrayList<>();

    private FireBase fb = new FireBase();

    public static final String EXTRA_MESSAGE = "DisplayQuote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);

    }

    public void nextView(View view) {
        try {
            startActivity(new Intent(this, QuoteDisplay.class));
        }
        catch (Exception e) {
            Log.d("Main Activity TRANSFER", e.toString());
        }
    }

    public void settings(View view) {
        try {
            startActivity(new Intent(this, HowOftenActivity.class));
        }
        catch (Exception e) {
            Log.d("Main Activity TRANSFER", e.toString());
        }
    }

    public void displayQuote(View view) {
        try {
            Intent intent = new Intent(this, QuoteDisplay.class);
            Quote quote = QuoteController.getRandomQuote(QuoteCategory.Funny);
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