package com.example.badge.androidapplication.Controllers;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.SystemClock;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

import com.example.badge.androidapplication.Models.QuoteCategory;
import com.example.badge.androidapplication.QuoteDisplay;
import com.example.badge.androidapplication.R;



/**
 * Created by 1dani on 12/6/2017.
 */

public class NotificationController {

    private Context context;

    //Notification IDs
    public static final int INSPIRATION_ID = 001;
    public static final int FITNESS_ID = 002;
    public static final int FUNNY_ID = 003;
    public static final int WISDOM_ID = 004;
    public static final int LIFE_ID = 005;
    public static final int LOVE_ID = 006;

    public NotificationController(Context context) {
        this.context = context;
    }

    //Creates a Notification of a specified type
    public Notification getNotification(QuoteCategory type) throws Exception {

        //Verify category
        int id;
        try {
            id = convertCategoryToID(type);
        } catch (Exception e) {
            throw e;
        }

        //Build notification
        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        android.support.v4.app.NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.drawable.ic_notifications_black_24dp)
                        .setContentTitle("MoQuo")
                        .setContentText("Check out this cool quote!")
                        .setSound(alarmSound)
                        .setAutoCancel(true)
                        .setPriority(NotificationManager.IMPORTANCE_HIGH)
                        .setVibrate(new long[] {1000, 1000});

        //Create intent
        Intent intent = new Intent(context, QuoteDisplay.class);
        intent.putExtra("extra", convertCategoryToString(type));

        //Create pending intent
        PendingIntent resultPendingIntent =
                PendingIntent.getActivity(
                        context,
                        0,
                        intent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);

        Log.d("NotificationController", "Built a notification");
        return mBuilder.build();
    }

    //Schedules a notification
    public void scheduleNotification(Notification notification, int delay, QuoteCategory type) throws Exception {

        //Determine category
        int id;
        try {
            id = convertCategoryToID(type);
        } catch (Exception e) {
            throw e;
        }

        Intent notificationIntent = new Intent(context, NotificationPublisher.class);
        notificationIntent.putExtra(NotificationPublisher.NOTIFICATION_ID, id);
        notificationIntent.putExtra(NotificationPublisher.NOTIFICATION, notification);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        long futureInMillis = SystemClock.elapsedRealtime() + delay;
        AlarmManager alarmManager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, futureInMillis, pendingIntent);

        Log.d("NotificationController", "Scheduled a notification");
    }

    //Converts a string to a category ID number
    public static int convertCategoryToID(QuoteCategory id) throws Exception {
        switch(id) {
            case Inspiration:
                return INSPIRATION_ID;
            case Fitness:
                return FITNESS_ID;
            case Funny:
                return FUNNY_ID;
            case Wisdom:
                return WISDOM_ID;
            case Life:
                return LIFE_ID;
            case Love:
                return LOVE_ID;
            default:
                throw new Exception("INVALID ID STRING");
        }
    }

    //Converts QuoteCategory to string
    public static String convertCategoryToString(QuoteCategory id) throws Exception {
        switch(id) {
            case Inspiration:
                return "Inspiration";
            case Fitness:
                return "Fitness";
            case Funny:
                return "Funny";
            case Wisdom:
                return "Wisdom";
            case Life:
                return "Life";
            case Love:
                return "Love";
            default:
                throw new Exception("INVALID CATEGORY");
        }
    }

    //Cancels a reminder
    public void cancel(int id) {

        //Disable receiver
        ComponentName receiver = new ComponentName(context, NotificationPublisher.class);
        PackageManager pm = context.getPackageManager();
        pm.setComponentEnabledSetting(receiver,PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);

        Intent intent = new Intent(context, NotificationPublisher.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);

        alarmManager.cancel(pendingIntent);
        pendingIntent.cancel();
    }
}
