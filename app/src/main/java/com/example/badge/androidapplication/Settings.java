package com.example.badge.androidapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

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
import java.util.Random;

import static com.example.badge.androidapplication.Models.QuoteCategory.Fitness;

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

        NotificationFrequency nf = new NotificationFrequency();

        QuoteCategory quoteCategory = QuoteCategory.Fitness;
        nf.frequency = 1;
        nf.category = quoteCategory;

        notificationFrequencies.add(nf);


        QuoteCategory quoteCategory2 = QuoteCategory.Funny;
        nf = new NotificationFrequency();
        nf.frequency = 3;
        nf.category = quoteCategory2;

        notificationFrequencies.add(nf);

        //Get the instance of the FireBase Current user
        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        //Add more categories
        fb.addUserCatagories(notificationFrequencies, currentFirebaseUser);

        //get the Current Data of the Firebase User with our Firebase Controller
        getUsers(currentFirebaseUser);
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
//        boolean checked = ((Settings) view).isChecked();
//
//        // Check which checkbox was clicked
//        switch(view.getId()) {
//            case R.id._d_fitness: //hello
//                if (checked){
//                    QuoteCategory category = null;
//                    category = category.Fitness;
//                    NotificationFrequency NF = new NotificationFrequency(category,1);
//
//
//                }
//            case R.id._w_fitness:
//                if (checked){
//                    // Put some meat on the sandwich
//                }
//                else
//                    break;
//            case R.id._m_fitness:
//                if (checked){
//                    // Put some meat on the sandwich
//                }
//                else
//                    break;
//            case R.id._d_funny:
//                if (checked){
//                    // Put some meat on the sandwich
//                }
//                else
//                    break;
//            case R.id._w_funny:
//                if (checked){
//                    // Put some meat on the sandwich
//                }
//                else
//                    break;
//            case R.id._m_funny:
//                if (checked){
//                    // Put some meat on the sandwich
//                }
//                else
//                    break;
//            case R.id._d_inspiration:
//                if (checked){
//                    // Put some meat on the sandwich
//                }
//                else
//                    break;
//            case R.id._w_inspiration:
//                if (checked){
//                    // Put some meat on the sandwich
//                }
//                else
//                    break;
//            case R.id._m_inspiration:
//                if (checked){
//                    // Put some meat on the sandwich
//                }
//                else
//                    break;
//            case R.id._d_life:
//                if (checked){
//                    // Put some meat on the sandwich
//                }
//                else
//                    break;
//            case R.id._w_life:
//                if (checked){
//                    // Put some meat on the sandwich
//                }
//                else
//                    break;
//            case R.id._m_life:
//                if (checked){
//                    // Put some meat on the sandwich
//                }
//                else
//                    break;
//            case R.id._d_love:
//                if (checked){
//                    // Put some meat on the sandwich
//                }
//                else
//                    break;
//            case R.id._w_love:
//                if (checked){
//                    // Put some meat on the sandwich
//                }
//                else
//                    break;
//            case R.id._m_love:
//                if (checked){
//                    // Put some meat on the sandwich
//                }
//                else
//                    break;
//            case R.id._d_wisdom:
//                if (checked){
//                    // Put some meat on the sandwich
//                }
//                else
//                    break;
//            case R.id._w_wisdom:
//                if (checked){
//                    // Put some meat on the sandwich
//                }
//                else
//                    break;
//            case R.id._m_wisdom:
//                if (checked){
//                    // Put some meat on the sandwich
//                }
//                else
//                    break;
        //}
    }

    public void nextView(View view) {
        try {
            startActivity(new Intent(this, Browse.class));
        } catch (Exception e) {
            Log.d("Main Activity TRANSFER", e.toString());
        }
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
