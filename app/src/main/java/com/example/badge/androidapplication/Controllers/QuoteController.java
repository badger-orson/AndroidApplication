package com.example.badge.androidapplication.Controllers;

import android.util.Log;

import com.example.badge.androidapplication.Models.Quote;
import com.example.badge.androidapplication.Models.QuoteCategory;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;
import java.util.Random;

/**
 * Created by 1dani on 12/4/2017.
 */


public class QuoteController {

    private FireBase fireBase;
    DatabaseReference mDataBase;

    public QuoteController() {
       fireBase = new FireBase();
    }

    /**
     * Returns a random quote from any category
     * @return Quote
     */
    public Quote getRandomQuote(QuoteCategory id) throws Exception {
        List<Quote> quotes = null;
        Random random = new Random();

        try {

            //Decipher category
            switch (id) {
                case Funny:
                    quotes = fireBase.getFunnyQuotes();
                    break;
                case Inspiration:
                    quotes = fireBase.getInspirationalQuotes();
                    break;
                case Fitness:
                    quotes = fireBase.getFitnessQuotes();
                    break;
                case Life:
                    quotes = fireBase.getLifeQuotes();
                    break;
                case Wisdom:
                    quotes = fireBase.getWisdomQuotes();
                    break;
                case Love:
                    quotes = fireBase.getLoveQuotes();
                    break;
                default:
                    throw new Exception("Invalid Category");
            }

            //Check if list is empty
            if (quotes == null || quotes.size() == 0) {
                throw new Exception("No quotes available");
            }

            //Return quote at random index
            int index = random.nextInt(quotes.size());
            return quotes.get(index);

        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Returns a random category
     * @return QuoteCategory
     */
    private QuoteCategory getRandomCategory() throws Exception{
        //Create a new random number with a range of 0 - 5
        Random rand = new Random();
        int min = 0;
        int max = 5;

        int i = rand.nextInt((max - min) + 1);
        QuoteCategory quoteCategory = null;

        switch (i) {
            case 0:
                quoteCategory = quoteCategory.Wisdom;
                break;
            case 1:
                quoteCategory = quoteCategory.Love;
                break;
            case 2:
                quoteCategory = quoteCategory.Inspiration;
                break;
            case 3:
                quoteCategory = quoteCategory.Funny;
                break;
            case 4:
                quoteCategory = quoteCategory.Life;
                break;
            case 5:
                quoteCategory = quoteCategory.Fitness;
                break;
            default:
                throw new Exception("Invalid Category");
        }

        return quoteCategory;
    }

    private void getQuotes(QuoteCategory id) throws Exception{
        mDataBase = FirebaseDatabase.getInstance().getReference();
        final List<Quote> quotes;
        final Quote q;

        switch (id) {
            case Funny:
                quotes = fireBase.getFunnyQuotes();
                break;
            case Inspiration:
                quotes = fireBase.getInspirationalQuotes();
                break;
            case Fitness:
                quotes = fireBase.getFitnessQuotes();
                break;
            case Life:
                quotes = fireBase.getLifeQuotes();
                break;
            case Wisdom:
                quotes = fireBase.getWisdomQuotes();
                break;
            case Love:
                quotes = fireBase.getLoveQuotes();
                break;
            default:
                throw new Exception("Invalid Category");
        }



        mDataBase.child("Categories/" + id + "/Quotes/").addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int max = quotes.size();
                int min = 0;

                Random rand = new Random();

                final int i = rand.nextInt((max - min));
                try {
                    Quote q2 = quotes.get(i);
                    //quoteV.setText("\t\t\t\t\t" + q.getQuoteText() + "\n\n\t\t\t\t\t-" + q.getQuoteSource());
                    //q = q2;

                }catch (Exception e) {
                    Log.d("TAG", "onDataChange: " + e.toString());
                }

                // Do all of the logic here .... If you are setting some text then do it here.
                // So in the browse set a thing that will switch between the quote topics.
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}


