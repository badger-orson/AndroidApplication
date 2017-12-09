package com.example.badge.androidapplication;

import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.app.Notification;

import com.example.badge.androidapplication.Controllers.FireBase;
import com.example.badge.androidapplication.Controllers.NotificationController;
import com.example.badge.androidapplication.Controllers.NotificationPublisher;
import com.example.badge.androidapplication.Models.NotificationFrequency;
import com.example.badge.androidapplication.Models.QuoteCategory;
import com.example.badge.androidapplication.Models.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Settings extends AppCompatActivity {


    private static final String TAG = "SETTINGS: ";

    private FireBase fb = new FireBase();
    private FirebaseAuth mAuth;
    private User appUser = new User();
    private FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();

    private DatabaseReference mDataBase = FirebaseDatabase.getInstance().getReference();
    private List<NotificationFrequency> notificationFrequencies = new ArrayList<>();
    private NotificationController notifCtrl = new NotificationController(this);
    List <NotificationFrequency> categories = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
//THIS WAS ME MAKING SURE I KNEW HOW TO SET THEM CHECKED, IT WORKS
//        boolean isChecked = true;
//        CheckBox fit1 = (CheckBox)findViewById(R.id._d_fitness);
//        fit1.setChecked(isChecked);
//
//        CheckBox fit2 = (CheckBox)findViewById(R.id._m_fitness);
//        fit2.setChecked(isChecked);

        notificationFrequencies = fb.getUserCatagories(currentFirebaseUser);



        //ORSON RIGHT HERE, IT'S NEVER GETTING TO MY LOGIC?
//            List<NotificationFrequency> selectionList = fb.getUserCatagories(currentFirebaseUser);
//            for (NotificationFrequency selection : selectionList) {
//                if (selection.category == QuoteCategory.Fitness) {
//                    //Daily Fitness
//                    if (selection.frequency == 1) {
//                        boolean isChecked = true;
//                        CheckBox fit1 = (CheckBox)findViewById(R.id._d_fitness);
//                        fit1.setChecked(isChecked);
//                    }
//                    //Weekly Fitness
//                    if (selection.frequency == 2) {
//                        boolean isChecked = true;
//                        CheckBox fit2 = (CheckBox)findViewById(R.id._w_fitness);
//                        fit2.setChecked(isChecked);
//                    }
//                    //Monthly Fitness
//                    if (selection.frequency == 3) {
//                        boolean isChecked = true;
//                        CheckBox fit3 = (CheckBox)findViewById(R.id._m_fitness);
//                        fit3.setChecked(isChecked);
//                    }
//                }
//                if (selection.category == QuoteCategory.Funny) {
//                    //Daily Funny
//                    if (selection.frequency == 1) {
//                        boolean isChecked = true;
//                        CheckBox cb1 = (CheckBox)findViewById(R.id._d_funny);
//                        cb1.setChecked(isChecked);
//                    }
//                    //Weekly Funny
//                    if (selection.frequency == 2) {
//                        boolean isChecked = true;
//                        CheckBox cb1 = (CheckBox)findViewById(R.id._w_funny);
//                        cb1.setChecked(isChecked);
//                    }
//                    //Monthly Funny
//                    if (selection.frequency == 3) {
//                        boolean isChecked = true;
//                        CheckBox cb1 = (CheckBox)findViewById(R.id._m_funny);
//                        cb1.setChecked(isChecked);
//                    }
//                }
//                if (selection.category == QuoteCategory.Inspiration) {
//                    //Daily inspiration
//                    if (selection.frequency == 1) {
//                        boolean isChecked = true;
//                        CheckBox cb1 = (CheckBox)findViewById(R.id._d_inspiration);
//                        cb1.setChecked(isChecked);
//                    }
//                    //Weekly inspiration
//                    if (selection.frequency == 2) {
//                        boolean isChecked = true;
//                        CheckBox cb1 = (CheckBox)findViewById(R.id._w_inspiration);
//                        cb1.setChecked(isChecked);
//                    }
//                    //Monthly inspiration
//                    if (selection.frequency == 3) {
//                        boolean isChecked = true;
//                        CheckBox cb1 = (CheckBox)findViewById(R.id._m_inspiration);
//                        cb1.setChecked(isChecked);
//                    }
//                }
//                if (selection.category == QuoteCategory.Love) {
//                    //Daily Love
//                    if (selection.frequency == 1) {
//                        boolean isChecked = true;
//                        CheckBox cb1 = (CheckBox)findViewById(R.id._d_love);
//                        cb1.setChecked(isChecked);
//                    }
//                    //Weekly Love
//                    if (selection.frequency == 2) {
//                        boolean isChecked = true;
//                        CheckBox cb1 = (CheckBox)findViewById(R.id._w_love);
//                        cb1.setChecked(isChecked);
//                    }
//                    //Monthly Love
//                    if (selection.frequency == 3) {
//                        boolean isChecked = true;
//                        CheckBox cb1 = (CheckBox)findViewById(R.id._m_love);
//                        cb1.setChecked(isChecked);
//                    }
//                }
//                if (selection.category == QuoteCategory.Life) {
//                    //Daily Life
//                    if (selection.frequency == 1) {
//                        boolean isChecked = true;
//                        CheckBox cb1 = (CheckBox)findViewById(R.id._d_life);
//                        cb1.setChecked(isChecked);
//                    }
//                    //Weekly Life
//                    if (selection.frequency == 2) {
//                        boolean isChecked = true;
//                        CheckBox cb1 = (CheckBox)findViewById(R.id._w_life);
//                        cb1.setChecked(isChecked);
//                    }
//                    //Monthly Life
//                    if (selection.frequency == 3) {
//                        boolean isChecked = true;
//                        CheckBox cb1 = (CheckBox)findViewById(R.id._m_life);
//                        cb1.setChecked(isChecked);
//                    }
//                }
//                if (selection.category == QuoteCategory.Wisdom) {
//                    //Daily Wisdom
//                    if (selection.frequency == 1) {
//                        boolean isChecked = true;
//                        CheckBox cb1 = (CheckBox)findViewById(R.id._d_wisdom);
//                        cb1.setChecked(isChecked);
//                    }
//                    //Weekly Wisdom
//                    if (selection.frequency == 2) {
//                        boolean isChecked = true;
//                        CheckBox cb1 = (CheckBox)findViewById(R.id._w_wisdom);
//                        cb1.setChecked(isChecked);
//                    }
//                    //Monthly Wisdom
//                    if (selection.frequency == 3) {
//                        boolean isChecked = true;
//                        CheckBox cb1 = (CheckBox)findViewById(R.id._m_wisdom);
//                        cb1.setChecked(isChecked);
//                    }
//                }
//
//            }
        //fb.getUser(currentFirebaseUser);
        getUsers(currentFirebaseUser);

        //Schedule Notifications
        try {
            //setAll();
            test();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
         NotificationFrequency nf;
        nf = new NotificationFrequency();


        // Check which checkbox was clicked
        switch(view.getId()) {

            //notificationFrequencies.clear();

            case R.id._d_fitness: //hello
                QuoteCategory category = QuoteCategory.Fitness;
                nf = new NotificationFrequency(category,1);
                if (checked){
                    notificationFrequencies.add(nf);
                    break;
                }
                else {
                    notificationFrequencies.remove(nf);
                    break;
                }
            case R.id._w_fitness:
                category = QuoteCategory.Fitness;
                nf = new NotificationFrequency(category,2);
                if (checked){
                    notificationFrequencies.add(nf);
                    break;
                }
                else {
                    notificationFrequencies.remove(nf);
                    break;
                }
            case R.id._m_fitness:
                category = QuoteCategory.Fitness;
                nf = new NotificationFrequency(category,3);
                if (checked){
                    notificationFrequencies.add(nf);
                    break;
                }
                else {
                    notificationFrequencies.remove(nf);
                    break;
                }
            case R.id._d_funny:
                category = QuoteCategory.Funny;
                nf = new NotificationFrequency(category,1);
                if (checked){
                    notificationFrequencies.add(nf);
                    break;
                }
                else {
                    notificationFrequencies.remove(nf);
                    break;
                }
            case R.id._w_funny:
                category = QuoteCategory.Funny;
                nf = new NotificationFrequency(category,2);
                if (checked){
                    notificationFrequencies.add(nf);
                    break;
                }
                else {
                    notificationFrequencies.remove(nf);
                    break;
                }
            case R.id._m_funny:
                category = QuoteCategory.Funny;
                nf = new NotificationFrequency(category,3);
                if (checked){
                    notificationFrequencies.add(nf);
                    break;
                }
                else {
                    notificationFrequencies.remove(nf);
                    break;
                }
            case R.id._d_inspiration:
                category = QuoteCategory.Inspiration;
                nf = new NotificationFrequency(category,1);
                if (checked){
                    notificationFrequencies.add(nf);
                    break;
                }
                else {
                    notificationFrequencies.remove(nf);
                    break;
                }

            case R.id._w_inspiration:
                category = QuoteCategory.Inspiration;
                nf = new NotificationFrequency(category,2);
                if (checked){
                    notificationFrequencies.add(nf);
                    break;
                }
                else {
                    notificationFrequencies.remove(nf);
                    break;
                }
            case R.id._m_inspiration:
                category = QuoteCategory.Inspiration;
                nf = new NotificationFrequency(category,3);
                if (checked){
                    notificationFrequencies.add(nf);
                    break;
                }
                else {
                    notificationFrequencies.remove(nf);
                    break;
                }
            case R.id._d_life:
                category = QuoteCategory.Life;
                nf = new NotificationFrequency(category,1);
                if (checked){
                    notificationFrequencies.add(nf);
                    break;
                }
                else {
                    notificationFrequencies.remove(nf);
                    break;
                }
            case R.id._w_life:
                category = QuoteCategory.Life;
                nf = new NotificationFrequency(category,2);
                if (checked){
                    notificationFrequencies.add(nf);
                    break;
                }
                else {
                    notificationFrequencies.remove(nf);
                    break;
                }
            case R.id._m_life:
                category = QuoteCategory.Life;
                nf = new NotificationFrequency(category,3);
                if (checked){
                    notificationFrequencies.add(nf);
                    break;
                }
                else {
                    notificationFrequencies.remove(nf);
                    break;
                }
            case R.id._d_love:
                category = QuoteCategory.Love;
                nf = new NotificationFrequency(category,1);
                if (checked){
                    notificationFrequencies.add(nf);
                    break;
                }
                else {
                    notificationFrequencies.remove(nf);
                    break;
                }
            case R.id._w_love:
                category = QuoteCategory.Love;
                nf = new NotificationFrequency(category,2);
                if (checked){
                    notificationFrequencies.add(nf);
                    break;
                }
                else {
                    notificationFrequencies.remove(nf);
                    break;
                }
            case R.id._m_love:
                category = QuoteCategory.Love;
                nf = new NotificationFrequency(category,3);
                if (checked){
                    notificationFrequencies.add(nf);
                    break;
                }
                else {
                    notificationFrequencies.remove(nf);
                    break;
                }
            case R.id._d_wisdom:
                category = QuoteCategory.Wisdom;
                nf = new NotificationFrequency(category,1);
                if (checked){
                    notificationFrequencies.add(nf);
                    break;
                }
                else {
                    notificationFrequencies.remove(nf);
                    break;
                }
            case R.id._w_wisdom:
                category = QuoteCategory.Wisdom;
                nf = new NotificationFrequency(category,2);
                if (checked){
                    notificationFrequencies.add(nf);
                    break;
                }
                else {
                    notificationFrequencies.remove(nf);
                    break;
                }
            case R.id._m_wisdom:
                category = QuoteCategory.Wisdom;
                nf = new NotificationFrequency(category,3);
                if (checked){
                    notificationFrequencies.add(nf);
                    break;
                }
                else {
                    notificationFrequencies.remove(nf);
                    break;
                }

        }

    }

    public void nextView(View view) {
        try {
            startActivity(new Intent(this, Browse.class));
        } catch (Exception e) {
            Log.d("Main Activity TRANSFER", e.toString());
        }
        //Get the instance of the FireBase Current user
        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        //Add more categories
        fb.addUserCatagories(notificationFrequencies, currentFirebaseUser);

        //get the Current Data of the Firebase User with our Firebase Controller
        getUsers(currentFirebaseUser);

        //Schedule Notifications
        try {
            //setAll();
            test();
        } catch (Exception e) {
            Log.d("Settings.java", "Failed to set notifications");
            e.printStackTrace();
        }
    }




    private void getUsers(final FirebaseUser firebaseUser) {
        mDataBase = FirebaseDatabase.getInstance().getReference();

        currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();


        categories = notificationFrequencies;

        mDataBase.child("Users/" + firebaseUser.getUid()).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                for (NotificationFrequency selection : categories) {
                    if (selection.category == QuoteCategory.Fitness) {
                        //Daily Fitness
                        if (selection.frequency == 1) {
                            boolean isChecked = true;
                            CheckBox fit1 = (CheckBox)findViewById(R.id._d_fitness);
                            fit1.setChecked(isChecked);
                        }

                        //Weekly Fitness
                        if (selection.frequency == 2) {
                            boolean isChecked = true;
                            CheckBox fit2 = (CheckBox)findViewById(R.id._w_fitness);
                            fit2.setChecked(isChecked);
                        }
                        //Monthly Fitness
                        if (selection.frequency == 3) {
                            boolean isChecked = true;
                            CheckBox fit3 = (CheckBox)findViewById(R.id._m_fitness);
                            fit3.setChecked(isChecked);
                        }
                    }
                    if (selection.category == QuoteCategory.Funny) {
                        //Daily Funny
                        if (selection.frequency == 1) {
                            boolean isChecked = true;
                            CheckBox cb1 = (CheckBox)findViewById(R.id._d_funny);
                            cb1.setChecked(isChecked);
                        }
                        //Weekly Funny
                        if (selection.frequency == 2) {
                            boolean isChecked = true;
                            CheckBox cb1 = (CheckBox)findViewById(R.id._w_funny);
                            cb1.setChecked(isChecked);
                        }
                        //Monthly Funny
                        if (selection.frequency == 3) {
                            boolean isChecked = true;
                            CheckBox cb1 = (CheckBox)findViewById(R.id._m_funny);
                            cb1.setChecked(isChecked);
                        }
                    }
                    if (selection.category == QuoteCategory.Inspiration) {
                        //Daily inspiration
                        if (selection.frequency == 1) {
                            boolean isChecked = true;
                            CheckBox cb1 = (CheckBox)findViewById(R.id._d_inspiration);
                            cb1.setChecked(isChecked);
                        }
                        //Weekly inspiration
                        if (selection.frequency == 2) {
                            boolean isChecked = true;
                            CheckBox cb1 = (CheckBox)findViewById(R.id._w_inspiration);
                            cb1.setChecked(isChecked);
                        }
                        //Monthly inspiration
                        if (selection.frequency == 3) {
                            boolean isChecked = true;
                            CheckBox cb1 = (CheckBox)findViewById(R.id._m_inspiration);
                            cb1.setChecked(isChecked);
                        }
                    }
                    if (selection.category == QuoteCategory.Love) {
                        //Daily Love
                        if (selection.frequency == 1) {
                            boolean isChecked = true;
                            CheckBox cb1 = (CheckBox)findViewById(R.id._d_love);
                            cb1.setChecked(isChecked);
                        }
                        //Weekly Love
                        if (selection.frequency == 2) {
                            boolean isChecked = true;
                            CheckBox cb1 = (CheckBox)findViewById(R.id._w_love);
                            cb1.setChecked(isChecked);
                        }
                        //Monthly Love
                        if (selection.frequency == 3) {
                            boolean isChecked = true;
                            CheckBox cb1 = (CheckBox)findViewById(R.id._m_love);
                            cb1.setChecked(isChecked);
                        }
                    }
                    if (selection.category == QuoteCategory.Life) {
                        //Daily Life
                        if (selection.frequency == 1) {
                            boolean isChecked = true;
                            CheckBox cb1 = (CheckBox)findViewById(R.id._d_life);
                            cb1.setChecked(isChecked);
                        }
                        //Weekly Life
                        if (selection.frequency == 2) {
                            boolean isChecked = true;
                            CheckBox cb1 = (CheckBox)findViewById(R.id._w_life);
                            cb1.setChecked(isChecked);
                        }
                        //Monthly Life
                        if (selection.frequency == 3) {
                            boolean isChecked = true;
                            CheckBox cb1 = (CheckBox)findViewById(R.id._m_life);
                            cb1.setChecked(isChecked);
                        }
                    }
                    if (selection.category == QuoteCategory.Wisdom) {
                        //Daily Wisdom
                        if (selection.frequency == 1) {
                            boolean isChecked = true;
                            CheckBox cb1 = (CheckBox)findViewById(R.id._d_wisdom);
                            cb1.setChecked(isChecked);
                        }
                        //Weekly Wisdom
                        if (selection.frequency == 2) {
                            boolean isChecked = true;
                            CheckBox cb1 = (CheckBox)findViewById(R.id._w_wisdom);
                            cb1.setChecked(isChecked);
                        }
                        //Monthly Wisdom
                        if (selection.frequency == 3) {
                            boolean isChecked = true;
                            CheckBox cb1 = (CheckBox)findViewById(R.id._m_wisdom);
                            cb1.setChecked(isChecked);
                        }
                    }

                }






//                final CheckBox checkBox = (CheckBox) findViewById(R.id._d_fitness);
//                if (!checkBox.isChecked()) {
//                    checkBox.setChecked(true);
//
//                    List<NotificationFrequency> selectionList = fb.getUserCatagories(firebaseUser);
//                    for (NotificationFrequency selection : selectionList) {
//                        if (selection.category == QuoteCategory.Fitness) {
//                            //Daily Fitness
//                            if (selection.frequency == 1) {
//                                boolean isChecked = true;
//                                CheckBox cb1 = (CheckBox)findViewById(R.id._d_fitness);
//                                cb1.setChecked(isChecked);
//                            }
//                            //Weekly Fitness
//                            if (selection.frequency == 2) {
//                                boolean isChecked = true;
//                                CheckBox cb1 = (CheckBox)findViewById(R.id._w_fitness);
//                                cb1.setChecked(isChecked);
//                            }
//                        }
//
//                    }
//                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    //Schedules an individual notifications
    public void setNotification(QuoteCategory type, int delay) throws Exception {

        try {
            Notification notif = notifCtrl.getNotification(type);
            notifCtrl.scheduleNotification(notif, delay, type);
        } catch (Exception e) {
            throw e;
        }
    }

    //Cancels all previously scheduled notifications
    public void cancelAll() {

    }

    //Updates all notifications
    public void setAll() throws Exception {
        cancelAll();

        try {
            for (NotificationFrequency nf : notificationFrequencies) {
                QuoteCategory category = nf.getCategory();
                int frequency = nf.getFrequency();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void test() {
        try {
            setNotification(QuoteCategory.Fitness, 2000);
            //setNotification(QuoteCategory.Funny, 2000);
            //setNotification(QuoteCategory.Love, 3000);
            //notifCtrl.cancel(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
