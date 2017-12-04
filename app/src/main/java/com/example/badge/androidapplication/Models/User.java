package com.example.badge.androidapplication.Models;

import java.util.List;

/**
 * This class is here to make a user exist in the real time.
 * When a new user is created this is the logic that allows this to happen.
 * Created by badge on 19-Nov-17.
 */

public class User {
    private String userName;
    private String emailAddress;
    private String phoneNumber;
    private List<NotificationFrequency> categories;
    private String frequency;




    public User() {
        this.userName = userName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.categories = categories;
        this.frequency = frequency;

    }

    //Non-Default Constructor
    public User(String userName, String emailAddress, String phoneNumber, List<NotificationFrequency> categories ) {
        this.userName = userName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.categories = categories;


    }


    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<NotificationFrequency> getCategories() {
        return categories;
    }

    public void setCategories(List<NotificationFrequency> categories) {
        categories = categories;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
}
