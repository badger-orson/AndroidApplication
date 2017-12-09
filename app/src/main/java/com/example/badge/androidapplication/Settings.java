package com.example.badge.androidapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;

import com.example.badge.androidapplication.Controllers.FireBase;
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
    private DatabaseReference mDataBase = FirebaseDatabase.getInstance().getReference();
    private List<NotificationFrequency> notificationFrequencies = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);


        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        appUser = fb.getUser(currentFirebaseUser);
        getUsers(currentFirebaseUser);

    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
         NotificationFrequency nf = new NotificationFrequency();


        // Check which checkbox was clicked
        switch(view.getId()) {

            //notificationFrequencies.clear();

            case R.id._d_fitness: //hello
                QuoteCategory category = QuoteCategory.Fitness;
                nf = new NotificationFrequency(category, 1);
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
    }




    private void getUsers(final FirebaseUser firebaseUser) {
        mDataBase = FirebaseDatabase.getInstance().getReference();

        mDataBase.child("Users/" + firebaseUser.getUid()).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                appUser = fb.getUser(firebaseUser);
                // Do all of the logic here .... If you are setting some text then do it here.
                // So in the browse set a thing that will switch between the quote topics.
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
