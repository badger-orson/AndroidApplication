package com.example.badge.androidapplication.Controllers;

import android.app.NotificationManager;
import android.content.Context;

import java.util.Calendar;
import java.util.Calendar.*;

/**
 * Created by 1dani on 12/6/2017.
 */

public class NotificationController {

    private NotificationManager manager;

    public NotificationController() {


    }

    public void test() {
        //manager = Context.getSystemService(Context.NOTIFICATION_SERVICE);
    }

    public Calendar setTime() {
        Calendar cal = new Calendar() {
            @Override
            protected void computeTime() {

            }

            @Override
            protected void computeFields() {

            }

            @Override
            public void add(int field, int amount) {

            }

            @Override
            public void roll(int field, boolean up) {

            }

            @Override
            public int getMinimum(int field) {
                return 0;
            }

            @Override
            public int getMaximum(int field) {
                return 0;
            }

            @Override
            public int getGreatestMinimum(int field) {
                return 0;
            }

            @Override
            public int getLeastMaximum(int field) {
                return 0;
            }
        };

        return cal;
    }
}
