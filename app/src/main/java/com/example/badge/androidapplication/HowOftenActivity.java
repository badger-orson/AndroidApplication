package com.example.badge.androidapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class HowOftenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_often);
    }

    public void nextView(View view) {
        try {
            startActivity(new Intent(this, Browse.class));
        }
        catch (Exception e) {
            Log.d("Main Activity TRANSFER", e.toString());
        }
    }
}
