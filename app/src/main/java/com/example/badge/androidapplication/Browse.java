package com.example.badge.androidapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Browse extends AppCompatActivity {

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
}
