package com.example.badge.androidapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;

import com.example.badge.androidapplication.Controllers.FireBase;
import com.example.badge.androidapplication.Models.NotificationFrequency;
import com.example.badge.androidapplication.Models.Quote;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Settings extends AppCompatActivity {


    private static final String TAG = "SETTINGS: ";

    private FireBase fb = new FireBase();
    private FirebaseAuth mAuth;
    private User appUser = new User();
    private FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();

    private DatabaseReference mDataBase = FirebaseDatabase.getInstance().getReference();
    private List<Map<String, Object>> notificationFrequencies = new ArrayList<>();
    Map<String, Object> hashmap = new HashMap<>();

//    CheckBox fit1,fit2,fit3, i1, i2, i3, fun1, fun2, fun3, wis1, wis2, wis3, life1, life2, life3, luv1, luv2, luv3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        mDataBase = FirebaseDatabase.getInstance().getReference();

        currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();



        mDataBase.child("Users/" + currentFirebaseUser.getUid()).child("Categories/").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                getUsers(currentFirebaseUser);

                }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d(TAG, "onCancelled: " + databaseError.toString());
            }
        });

    }


    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {

            case R.id._d_fitness: //hello
                if (checked) {
                    appUser.categories.put("Fitness", 1);
                    break;
                }
            case R.id._w_fitness:

                if (checked) {
                    appUser.categories.put("Fitness", 2);

                    break;
                }
            case R.id._m_fitness:
                if (checked) {
                    appUser.categories.put("Fitness", 3);

                    break;
                }
            case R.id._d_love:
                if (checked) {
                    appUser.categories.put("Love", 1);
                    break;
                }
            case R.id._w_love:
                if (checked) {
                    appUser.categories.put("Love", 2);
                    break;
                }
            case R.id._m_love:
                if (checked) {
                    appUser.categories.put("Love", 3);
                    break;
                }
            case R.id._d_funny:
                if (checked) {
                    appUser.categories.put("Funny", 1);
                    break;
                }
            case R.id._w_funny:
                if (checked) {
                    appUser.categories.put("Funny", 2);
                    break;
                }
            case R.id._m_funny:
                if (checked) {
                    appUser.categories.put("Funny", 3);
                    break;
                }
            case R.id._d_inspiration:
                if (checked) {
                    appUser.categories.put("Inspiration", 1);
                    break;
                }
            case R.id._w_inspiration:
                if (checked) {
                    appUser.categories.put("Inspiration", 2);
                    break;
                }
            case R.id._m_inspiration:
                if (checked) {
                    appUser.categories.put("Inspiration", 3);
                    break;
                }
            case R.id._d_wisdom:
                if (checked) {
                    appUser.categories.put("Wisdom", 1);
                    break;
                }
            case R.id._w_wisdom:
                if (checked) {
                    appUser.categories.put("Wisdom", 2);
                    break;
                }
            case R.id._m_wisdom:
                if (checked) {
                    appUser.categories.put("Wisdom", 3);
                    break;
                }
            case R.id._d_life:
                if (checked) {
                    appUser.categories.put("Life", 1);
                    break;
                }
            case R.id._w_life:
                if (checked) {
                    appUser.categories.put("Life", 2);
                    break;
                }
            case R.id._m_life:
                if (checked) {
                    appUser.categories.put("Life", 3);
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

        //hm.putAll(categories);
       // appUser.categories = hm;

        fb.updateUser(appUser, currentFirebaseUser);
        fb.updateUser(appUser, currentFirebaseUser);
    }







        //Add more categories
        //fb.addUserCatagories(notificationFrequencies, currentFirebaseUser);

        //get the Current Data of the Firebase User with our Firebase Controller

        //getUsers(currentFirebaseUser);
   // }

    private void setButtonState(Map.Entry<String, Object> selection) {

            CheckBox cb1;
            CheckBox cb2;
            CheckBox cb3;

            if (selection.getKey().toString().equals("Inspiration")) {
                cb1 = (CheckBox) findViewById(R.id._d_inspiration);
                cb2 = (CheckBox) findViewById(R.id._w_inspiration);
                cb3 = (CheckBox) findViewById(R.id._m_inspiration);
            } else if (selection.getKey().toString().equals("Fitness")){
                cb1 = (CheckBox) findViewById(R.id._d_fitness);
                cb2 = (CheckBox) findViewById(R.id._w_fitness);
                cb3 = (CheckBox) findViewById(R.id._m_fitness);
            }else if (selection.getKey().toString().equals("Funny")) {
                cb1 = (CheckBox) findViewById(R.id._d_funny);
                cb2 = (CheckBox) findViewById(R.id._w_funny);
                cb3 = (CheckBox) findViewById(R.id._m_funny);
            } else if (selection.getKey().toString().equals("Wisdom")) {
                cb1 = (CheckBox) findViewById(R.id._d_wisdom);
                cb2 = (CheckBox) findViewById(R.id._w_wisdom);
                cb3 = (CheckBox) findViewById(R.id._m_wisdom);
            } else if (selection.getKey().toString().equals("Life")) {
                cb1 = (CheckBox) findViewById(R.id._d_life);
                cb2 = (CheckBox) findViewById(R.id._w_life);
                cb3 = (CheckBox) findViewById(R.id._m_life);
            } else {
                cb1 = (CheckBox) findViewById(R.id._d_love);
                cb2 = (CheckBox) findViewById(R.id._w_love);
                cb3 = (CheckBox) findViewById(R.id._m_love);
            }


            long value = (Long) selection.getValue();
            int intValue = (int) value;
            if ( intValue == 1) {
                cb1.setChecked(true);
                cb2.setChecked(false);
                cb3.setChecked(false);

            }else if (  intValue == 2) {
                cb1.setChecked(false);
                cb2.setChecked(true);
                cb3.setChecked(false);
            }else if (intValue == 3) {
                cb1.setChecked(false);
                cb2.setChecked(false);
                cb3.setChecked(true);

            }
        }



    private void getUsers(final FirebaseUser firebaseUser) {
        mDataBase = FirebaseDatabase.getInstance().getReference();

        //appUser = fb.getUser(currentFirebaseUser);

        //appUser.categories;

        mDataBase.child("Users/" + firebaseUser.getUid()).addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                appUser = dataSnapshot.getValue(User.class);

                for (DataSnapshot category : dataSnapshot.child("categories").getChildren()) {
                    appUser.categories.put(category.getKey(), category.getValue());
                }


                for (Map.Entry<String, Object> selection : appUser.categories.entrySet()) {
                     setButtonState(selection);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
