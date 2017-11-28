package com.example.badge.androidapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.badge.androidapplication.Models.FireBase;
import com.example.badge.androidapplication.Models.Quote;
import com.example.badge.androidapplication.Models.QuoteCategory;
import com.example.badge.androidapplication.Models.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button signup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signup = (Button) findViewById(R.id.submit);

        System.out.println("Hello I like to bake Donuts");

        FireBase fb = new FireBase();

        List<QuoteCategory> qcList = new ArrayList<>();


        Quote q = new Quote("Hello", "NA", "NA");
        QuoteCategory qc = QuoteCategory.Funny;


        qcList.add(qc = QuoteCategory.Inspiration);

        fb.addNewQuote(q, qc);

        //User user  = new User("badgero1234@icloud.com", "badgero1234@icloud.com", "2089700157", qcList, "weekly" );

        //fb.addNewUser(user);


//        signup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this, LoginActivity.class));
//            }
//        });
    }


        public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
           }
    }

