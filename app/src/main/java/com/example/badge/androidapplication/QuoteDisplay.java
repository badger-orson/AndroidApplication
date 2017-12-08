package com.example.badge.androidapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.badge.androidapplication.Controllers.FireBase;
import com.example.badge.androidapplication.Models.Quote;
import com.example.badge.androidapplication.Models.QuoteCategory;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuoteDisplay extends AppCompatActivity {

    private static final String TAG = "Quote Display";

    public TextView quoteV, categoryDisplay;
    public String categoryNext;

    DatabaseReference mDataBase = FirebaseDatabase.getInstance().getReference();
    Quote q = new Quote();
    FireBase fb = new FireBase();

    List<Quote> ql = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote_display);


        quoteV = (TextView) findViewById(R.id.quote);
        categoryDisplay = (TextView) findViewById(R.id.category);



        Bundle bundle = getIntent().getExtras();
        String extra = bundle.getString("extra");

        categoryNext = extra;

        Log.d(TAG, "onCreate: " + extra);

        getQuotes(extra);

    }

    public void nextQuote(View v) {

        getQuotes(categoryNext);

    }

    private void getQuotes(final String category) {
        mDataBase = FirebaseDatabase.getInstance().getReference();
        try {
            //Determine what Category to pull into our ql or quoteList
            switch (category) {
                case "Wisdom":
                    ql = fb.getWisdomQuotes();
                    break;
                case "Love":
                    ql = fb.getLoveQuotes();
                    break;
                case "Inspiration":
                    ql = fb.getInspirationalQuotes();
                    break;
                case "Life":
                    ql = fb.getLifeQuotes();
                    break;
                case "Fitness":
                    ql = fb.getFitnessQuotes();
                    break;
                case "Funny":
                    ql = fb.getFunnyQuotes();
                    break;
                default:
                    try {
                        throw new Exception("Invalid Category");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }

            mDataBase.child("Categories/" + category + "/Quotes/").addValueEventListener(new ValueEventListener() {


                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    int max = ql.size();
                    int min = 0;

                    Random rand = new Random();

                    final int i = rand.nextInt((max - min));
                    try {
                        q = ql.get(i);
                        quoteV.setText(q.getQuoteText() + "\n\n\t\t\t\t\t-" + q.getQuoteSource());
                        categoryDisplay.setText(category);

                    } catch (Exception e) {
                        Log.d(TAG, "onDataChange: " + e.toString());
                    }

                    // Do all of the logic here .... If you are setting some text then do it here.
                    // So in the browse set a thing that will switch between the quote topics.
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        } catch (Exception e) {
            Log.d(TAG, "getQuotes: " + e.toString());
        }


    }
}
