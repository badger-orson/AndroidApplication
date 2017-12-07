package com.example.badge.androidapplication.Models;

/**
 * Created by badge on 01-Dec-17.
 */

public class NotificationFrequency {

    public QuoteCategory category;
    public int frequency;

    public NotificationFrequency() {
        this.category = category;
        this.frequency = frequency;
        //1=day 2=week 3=month
    }

    public NotificationFrequency(QuoteCategory category, int frequency) {
        this.category = category;
        this.frequency = frequency;
        //1=day 2=week 3=month
    }

    public QuoteCategory getCategory() {
        return category;
    }

    public void setCategory(QuoteCategory category) {
        this.category = category;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
}
