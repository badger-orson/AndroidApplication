package com.example.badge.androidapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.badge.androidapplication.Models.Quote;
import com.google.gson.Gson;

public class QuoteDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote_display);

        //Get quote from intent
        Intent intent = getIntent();
        Gson gson = new Gson();
        Quote quote = gson.fromJson(intent.getStringExtra(Browse.EXTRA_MESSAGE), Quote.class);

        //Display quote data in activity
        TextView body = (TextView) findViewById(R.id.textView2);
        body.setText(quote.getQuoteText());

        TextView source = (TextView) findViewById(R.id.textView16);
        source.setText(quote.getQuoteSource());
    }
}
