package com.example.badge.androidapplication.Models;

/**
 * Created by badge on 01-Dec-17.
 */

public class NotificationFrequency {

    public QuoteCategory category;
    public int frequency;

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
