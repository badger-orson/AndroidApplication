package com.example.badge.androidapplication.Models;

import java.util.Date;

/**
 * Created by 1dani on 11/2/2017.
 */

public class ScheduledQuote {
    private Date time;
    private QuoteCategory category;
    private boolean muted;

    //Default Constructor
    public ScheduledQuote() {
        time = new Date();
        category = QuoteCategory.Life;
        muted = false;
    }
    //Getters & Setters
    public Date getTime() { return time; }
    public void setTime(Date time) { this.time = time; }

    public QuoteCategory getCategory() { return category; }
    public void setCategory(QuoteCategory category) { this.category = category;}

    public boolean isMuted() { return muted; }
    public void mute() { this.muted = true; }
    public void unMute() { this.muted = false; }
}
