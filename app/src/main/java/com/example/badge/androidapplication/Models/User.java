package com.example.badge.androidapplication.Models;

import java.util.List;

/**
 * This is a class that creates the info for a new user.
 *
 * Created by badge on 19-Nov-17.
 */

public class User {
    String userName;
    String emailAddress;
    String phoneNumber;
    List<String> categories;
    String frequency;

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

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        categories = categories;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }



    //Non-default constructor

    /**
     * This is a non default construtor to create a new user. passing in the necessary values.
     * @param userName
     * @param emailAddress
     * @param phoneNumber
     * @param categories
     * @param frequency
     */
    public void createNewUser(String userName, String emailAddress, String phoneNumber, List<String> categories, String frequency) {

        this.userName = userName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.categories = categories;
        this.frequency = frequency;

    }

}
