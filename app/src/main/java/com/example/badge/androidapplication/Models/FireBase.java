package com.example.badge.androidapplication.Models;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Locale;

/**
 * The Point of this class is to create a dynamic API
 * that we can use to add to our firebase and read our firebase.
 *  This makes it so we dont accidentally rewrite the DB
 * Created by badge on 11/8/2017.
 */

public class FireBase {

    //This is the current reference to the DB
    DatabaseReference mDataBase = FirebaseDatabase.getInstance().getReference();


    /**
     * This will add a new quote to the DB underneath the Categories/{category}/Quotes/{quote}
     * @param quote
     * @param category
     * @return
     */
    public void addNewQuote(Quote quote, String category){
        mDataBase = FirebaseDatabase.getInstance().getReference();
        mDataBase.child("Categories/" + category + "/Quotes/").setValue(quote);
    }

    public static String getCurrentDBInfo(){

        return "This is some quote by a useless thingymajig......";
    }


    /**
     * This will add a new user to the DB underneath the User/{uniqueID}
     * @param user
     * @return
     */
    public void addNewUser(User user){
        mDataBase = FirebaseDatabase.getInstance().getReference();
        mDataBase.child("Users/").setValue(user);
    }

}
