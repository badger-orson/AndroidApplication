package com.example.badge.androidapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.badge.androidapplication.Controllers.FireBase;
import com.example.badge.androidapplication.Models.Quote;
import com.example.badge.androidapplication.Models.QuoteCategory;
import com.example.badge.androidapplication.Models.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MAIN ACTIVITY:" ;
    Button signin, signup;
    List<Quote> ql = new ArrayList<>();
    TextView quoteV;

    DatabaseReference mDataBase = FirebaseDatabase.getInstance().getReference();
    Quote q = new Quote();
    FireBase fb = new FireBase();


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signin = (Button)   findViewById(R.id.signin);
        signup = (Button)   findViewById(R.id.signup);
        quoteV = (TextView) findViewById(R.id.quote);


        System.out.println("Hello I like to bake Donuts");



        getQuotes();



//       // Inspiration
//        q.setQuoteText("The best and most beautiful things in the world cannot be seen or even touched - they must be felt with the heart.");
//        q.setQuoteText("Helen Keller");
//        ql.add(q);
//        q.setQuoteText("The best preparation for tomorrow is doing your best today.");
//        q.setQuoteSource("H. Jackson Brown, Jr.");
//        ql.add(q);
//        q.setQuoteText("Put your heart, mind, and soul into even your smallest acts. This is the secret of success.");
//        q.setQuoteSource("Swami Sivananda");
//        ql.add(q);
//        q.setQuoteText( "I can’t change the direction of the wind, but I can adjust my sails to always reach my destination.");
//        q.setQuoteSource("Jimmy Dean");
//        ql.add(q);
//        q.setQuoteText("Start by doing what’s necessary; then do what’s possible; and suddenly you are doing the impossible.");
//        q.setQuoteSource("Francis of Assisi");
//        ql.add(q);
//        q.setQuoteText("We must let go of the life we have planned, so as to accept the one that is waiting for us.");
//        q.setQuoteSource("Joseph Campbell");
//        ql.add(q);
//        q.setQuoteText("Try to be a rainbow in someone’s cloud.");
//        q.setQuoteSource("Maya Angelou");
//        ql.add(q);
//        q.setQuoteText("Happiness is not something you postpone for the future; it is something you design for the present.");
//        q.setQuoteSource("Jim Rohn");
//        ql.add(q);
//        q.setQuoteText("It is during our darkest moments that we must focus to see the light.");
//        q.setQuoteSource("Aristotle");
//        ql.add(q);
//        q.setQuoteText("Nothing is impossible, the word itself says ‘I’m possible’!");
//        q.setQuoteSource("Audrey Hepburn");
//        ql.add(q);
//        q.setQuoteText("Change your thoughts and you change the world.");
//        q.setQuoteSource("Norman Vincent Peale");
//        ql.add(q);
//        q.setQuoteText("Your work is going to fill a large part of your life, and the only way to be truly satisfied is to do what you believe is great work. And the only way to do great work is to love what you do. If you haven’t found it yet, keep looking. Don’t settle. As with all matters of the heart, you’ll know when you find it.");
//        q.setQuoteSource("Steve Jobs");
//        ql.add(q);
//        q.setQuoteText("Today I choose life. Every morning when I wake up I can choose joy, happiness, negativity, pain... To feel the freedom that comes from being able to continue to make mistakes and choices - today I choose to feel life, not to deny my humanity but embrace it.");
//        q.setQuoteSource("Kevyn Aucoin");
//        ql.add(q);
//        q.setQuoteText("Believe you can and you’re halfway there.");
//        q.setQuoteSource("Theodore Roosevelt");
//        ql.add(q);
//        q.setQuoteText("My mission in life is not merely to survive, but to thrive; and to do so with some passion, some compassion, some humor, and some style.");
//        q.setQuoteSource("Maya Angelou");
//        ql.add(q);


        //for (Quote a: ql){
        //    fb.addInspirationalQ(a);
        //}




        //User user  = new User("badgero1234@icloud.com", "badgero1234@icloud.com", "2089700157", qcList, "weekly" );

        //fb.addNewUser(user);


//        signup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this, LoginActivity.class));
//            }
//        });
    }



    public void getQuotes() {
        mDataBase = FirebaseDatabase.getInstance().getReference();
        QuoteCategory category = QuoteCategory.Inspiration;
        ql = fb.getInspirationalQuotes();
        mDataBase.child("Categories/" + category + "/Quotes/").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                q = ql.get(0);
                quoteV.setText(q.getQuoteText());
                // Do all of the logic here .... If you are setting some text then do it here.
                // So in the browse set a thing that will switch between the quote topics.
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }




        public void login(View view) {
            try {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
            catch (Exception e) {
                Log.d("Main Activity TRANSFER", e.toString());
            }
        }

        public void signUp(View view) {
            try {
                startActivity(new Intent(MainActivity.this, SignUp.class));
            }
            catch (Exception e) {
                Log.d("Main Activity TRANSFER", e.toString());
            }
        }
    }

