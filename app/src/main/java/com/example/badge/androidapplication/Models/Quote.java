package com.example.badge.androidapplication.Models;

/**
 * Created by Daniel Wu on 11/2/2017.
 */

public class Quote {
    private String quoteText;
    private String quoteSource;
    private String imageURL;

    //Default Constructors
    public Quote() {
        quoteText = "no text";
        quoteSource = "unknown";
        imageURL = null;
    }
    //Non-Default Constructor
    public Quote(String quoteText) {
        this.quoteText = quoteText;

    }

    public Quote(String quoteText, String quoteSource, String imageURL) {
        this.quoteText = quoteText;
        this.quoteSource = quoteSource;
        this.imageURL = imageURL;
    }

    public String getQuoteText() { return quoteText; }
    public void setQuoteText(String quoteText) { this.quoteText = quoteText; }

    public String getQuoteSource() { return quoteSource; }
    public void setQuoteSource(String quoteSource) { this.quoteSource = quoteSource; }

    public String getImageURL() { return imageURL; }
    public void setImageURL(String imageURL) { this.imageURL = imageURL; }
}
