package com.example.badge.androidapplication.Controllers;

import com.example.badge.androidapplication.Models.Quote;
import com.example.badge.androidapplication.Models.QuoteCategory;

import java.util.List;
import java.util.Random;

/**
 * Created by 1dani on 12/4/2017.
 */


public class QuoteController {
    /**
     * Returns a random quote from any categories
     * @return Quote
     */
    public static Quote getRandomQuote(QuoteCategory id) throws Exception {
        List<Quote> quotes = null;
        FireBase fireBase = new FireBase();
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
                    quotes = fireBase.getExcerciseQuotes();
                    break;
                case Wisdom:
                    quotes = fireBase.getMotivationalQuotes();
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

}


