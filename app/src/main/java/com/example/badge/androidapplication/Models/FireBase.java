package com.example.badge.androidapplication.Models;

import android.app.AlertDialog;
import android.util.Log;
import android.widget.Toast;

import com.example.badge.androidapplication.SignUp;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/**
* The Point of this class is to create a dynamic API
* that we can use to add to our Firebase DB and read our Firebase DB.
* This makes it so we don't accidentally rewrite the DB
* Created by badge on 11/8/2017.
**/

public class FireBase {


    private static final String TAG = "FireBase.Java";

    //This is the current reference to the DB
    private DatabaseReference mDataBase = FirebaseDatabase.getInstance().getReference();

    //Initialize private variables
    private Random rand = new Random();
    private int i = rand.nextInt(999999999); //I wanted to see if I had to use push. Turns out no
    private User appUser = new User(); //This is where I will store a user.




                                       // Class Methods  //

    /**
    * This method will add a quote to the "Categories/Funny/Quotes/" storing it in the Firebase DB
    * that current section.
    * @param quote
    */
    public void addFunnyQ(Quote quote){
        mDataBase = FirebaseDatabase.getInstance().getReference();
        QuoteCategory category = QuoteCategory.Funny;
        mDataBase.child("Categories/" + category + "/Quotes/" + i).setValue(quote);
    }


    /**
    * This method will get all of the quotes in the "Categories/Funny/Quotes/" and return it in a
    * list.
    * @return List<Quote>
    **/
    public List<Quote> getFunnyQuotes() {
        mDataBase = FirebaseDatabase.getInstance().getReference();
        QuoteCategory category = QuoteCategory.Funny;
        final List<Quote> quotes = new ArrayList<>();
        mDataBase.child("Categories/" + category + "/Quotes/").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot quotesSnapshot : dataSnapshot.getChildren()) {
                    Quote quote = quotesSnapshot.getValue(Quote.class);
                    quotes.add(quote);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return quotes;
    }

    /**
    * This method will add a quote to the "Categories/Inspiration/Quotes/" storing in the Firebase DB
    * that current section as seen above.
    * @param quote
    **/
    public void addInspirationalQ(Quote quote){
        mDataBase = FirebaseDatabase.getInstance().getReference();
        QuoteCategory category = QuoteCategory.Inspiration;
        mDataBase.child("Categories/" + category + "/Quotes/" + i).setValue(quote);
    }

    /**
    * This method will get all of the quotes in the "Categories/Funny/Quotes/" and return it in a
    * list.
    * @return List<Quote>
    **/
    public List<Quote> getInspirationalQuotes() {
        mDataBase = FirebaseDatabase.getInstance().getReference();
        QuoteCategory category = QuoteCategory.Inspiration;
        final List<Quote> quotes = new ArrayList<>();
        mDataBase.child("Categories/" + category + "/Quotes/").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot quotesSnapshot : dataSnapshot.getChildren()) {
                    Quote quote = quotesSnapshot.getValue(Quote.class);
                    quotes.add(quote);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return quotes;
    }

    /**
    * This method will add a quote to the "Categories/Exercise/Quotes/" storing in the Firebase DB
    * that current section as seen above.
    * @param quote
    **/
    public void addExerciseQ(Quote quote){
        mDataBase = FirebaseDatabase.getInstance().getReference();
        QuoteCategory category = QuoteCategory.Exercise;
        mDataBase.child("Categories/" + category + "/Quotes/" + i).setValue(quote);
    }

    /**
    * This method will get all of the quotes in the "Categories/Exercise/Quotes/" and return it in a
    * @return List<Quote>
    **/
    public List<Quote> getExcerciseQuotes() {
        mDataBase = FirebaseDatabase.getInstance().getReference();
        QuoteCategory category = QuoteCategory.Exercise;
        final List<Quote> quotes = new ArrayList<>();
        mDataBase.child("Categories/" + category + "/Quotes/").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot quotesSnapshot : dataSnapshot.getChildren()) {
                    Quote quote = quotesSnapshot.getValue(Quote.class);
                    quotes.add(quote);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return quotes;
    }

    /**
    * This method will add a quote to the "Categories/Motivation/Quotes/" storing in the Firebase DB
    * that current section as seen above.
    * @param quote
    **/
    public void addMotivationalQ(Quote quote){
        mDataBase = FirebaseDatabase.getInstance().getReference();
        QuoteCategory category = QuoteCategory.Motivation;
        mDataBase.child("Categories/" + category + "/Quotes/" + i ).setValue(quote);
    }

    /**
    * This method will get all of the quotes in the "Categories/Motivation/Quotes/" and return it in a
    * @return List<Quote>
    **/
    public List<Quote> getMotivationalQuotes() {
        mDataBase = FirebaseDatabase.getInstance().getReference();
        QuoteCategory category = QuoteCategory.Motivation;
        final List<Quote> quotes = new ArrayList<>();
        mDataBase.child("Categories/" + category + "/Quotes/").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot quotesSnapshot : dataSnapshot.getChildren()) {
                    Quote quote = quotesSnapshot.getValue(Quote.class);
                    quotes.add(quote);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return quotes;
    }

    /**
    * This will add a new user to the DB underneath the User/{uniqueID}This is very handy, because
    * it will link the user and their account together allowing them to store all data for the
    * user in a simple location to pull. It store them here "Users/{user.uid}"
    * @param user
    * */
    public void addNewUser(User user, FirebaseUser firebaseUser){
        mDataBase = FirebaseDatabase.getInstance().getReference();
        //String key = user.userName.toString() + "/";
        try {
            mDataBase.child("Users/").child(firebaseUser.getUid()).setValue(user);
        }
        catch (Exception e){
            Log.d(TAG, "addNewUser: ");

        }
    }

    /**
     * This will return the current state of the user in the Firebase DB. This happens asynchronous
     * when it gets the information it will return it to the caller. This method works because it
     * calls the "Users/{user.uid}" It then pulls the info and puts it into a user object.
     * @param user
     * @return User
     */
    public User getUser(FirebaseUser user) {
        mDataBase = FirebaseDatabase.getInstance().getReference();

        mDataBase.child("Users/" + user.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                appUser = dataSnapshot.getValue(User.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d(TAG, "onCancelled: Get User: There was a problem in the request.  ");
            }
        });

        return appUser;
    }

}
