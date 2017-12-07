package com.example.badge.androidapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.badge.androidapplication.Controllers.FireBase;
import com.example.badge.androidapplication.Models.Quote;
import com.example.badge.androidapplication.Models.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

public class SignUp extends AppCompatActivity {

    private static final String TAG = "SignUp Activity";

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private EditText email, password, name,phone;
    private Button submit;
    List<Quote> quotes = new ArrayList<>();

    private FireBase fb = new FireBase();
    private User appUser = new User();



    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        try {
            appUser.setUserName(currentUser.toString());
        } catch (Exception e) {
            Log.d(TAG, "onStart: " + e.toString());
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        name = (EditText) findViewById(R.id.name);
        phone = (EditText) findViewById(R.id.phone);

        submit = (Button) findViewById(R.id.submit);



        mAuth = FirebaseAuth.getInstance();


    }


    private void signUp(String email, String password) {
        Log.d(TAG, "signUp:" + email);
        if (!validateForm()) {
            return;
        }

        final String e = email.toString();
        final String pass = password.toString();
        final String n = name.getText().toString();
        final String p = phone.getText().toString();



        // [START create_user_with_email]
        mAuth.createUserWithEmailAndPassword(e, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();

                            appUser.setPhoneNumber(p);
                            appUser.setEmailAddress(e);
                            appUser.setUserName(n);

                            //fb.addNewUser(appUser ,user); Uncomment for the code to work and signup for real.
                            nextView();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(SignUp.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // [START_EXCLUDE]

                        // [END_EXCLUDE]
                    }
                });
// [END create_user_with_email]
    }


    private boolean validateForm() {
        boolean valid = true;

        String ema = email.getText().toString();
        if (TextUtils.isEmpty(ema)) {
            email.setError("Required.");
            valid = false;
        } else {
            email.setError(null);
        }

        String pas = password.getText().toString();
        if (TextUtils.isEmpty(pas)) {
            password.setError("Required.");
            valid = false;
        } else {
            password.setError(null);
        }

        return valid;
    }


    public void onClick(View v) {
        int i = v.getId();

        if (i == R.id.submit) {
            signUp(email.getText().toString(), password.getText().toString());
        }
    }




    public void nextView() {
        try {
            startActivity(new Intent(this, Settings.class));
        }
        catch (Exception e) {
            Log.d("Main Activity TRANSFER", e.toString());
        }
    }
}
