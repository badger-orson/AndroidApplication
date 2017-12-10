package com.example.badge.androidapplication.Models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is here to make a user exist in the real time.
 * When a new user is created this is the logic that allows this to happen.
 * Created by badge on 19-Nov-17.
 */

public class User {
    private String userName;
    private String emailAddress;
    private String phoneNumber;
    public Map<String, Object> categories;





    public User() {
        this.userName = null;
        this.emailAddress = null;
        this.phoneNumber = null;
        this.categories = new HashMap<>();

    }

    //Non-Default Constructor
    public User(String userName, String emailAddress, String phoneNumber, Map<String, Object> categories ) {
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

    public Map<String, Object> getCategories() {
        return categories;
    }

    public void setCategories(Map<String, Object> categories) {
        categories = categories;
    }

}
