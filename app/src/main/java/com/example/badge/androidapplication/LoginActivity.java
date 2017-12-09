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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "Login Activity";

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private EditText email, password;
    private Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        submit = (Button) findViewById(R.id.submit);



        mAuth = FirebaseAuth.getInstance();




//        mAuthListener = new FirebaseAuth.AuthStateListener() {
//        @Override
//        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//            FirebaseUser user = firebaseAuth.getCurrentUser();
//            if (user != null) {
//                // User is signed in
//                Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
//                toastMessage("Successfully signed in with: " + user.getEmail());
//            } else {
//                // User is signed out
//                Log.d(TAG, "onAuthStateChanged:signed_out");
//                toastMessage("Successfully signed out.");
//            }
//        }
//        };

//        submit.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                String em = email.getText().toString();
//                String pass = password.getText().toString();
//                if (!em.equals("") && !pass.equals("")) {
//                    mAuth.signInWithEmailAndPassword(em,pass);
//                }
//                else {
//                    toastMessage("You forgot a field");
//                    mAuth.signOut();
//                }
//
//            }
//        });
    }


    private void signIn(String email, String password) {
        Log.d(TAG, "signIn:" + email);
        if (!validateForm()) {
            return;
        }

        String e = email.toString();
        String pass = password.toString();

        try {
            mAuth.signInWithEmailAndPassword(e, pass)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "signInWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();
                                Toast.makeText(LoginActivity.this, "Authentication Success.",
                                        Toast.LENGTH_SHORT).show();

                                nextView();
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "signInWithEmail:failure", task.getException());
                                Toast.makeText(LoginActivity.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                                updateUI(null);
                            }

                            // ...
                        }
                    });
        }catch (Exception error) {
            Log.d(TAG, "signIn: " + error.toString());
            System.out.println( error.toString());
        }
    }



    private boolean validateForm() {
        boolean valid = true;

        String ema = email.getText().toString().trim();
        if (TextUtils.isEmpty(ema)) {
            email.setError("Required.");
            valid = false;
        } else {
            email.setError(null);
        }

        String pas = password.getText().toString().trim();
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
            signIn(email.getText().toString(), password.getText().toString());
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser user) {



    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        mAuth.addAuthStateListener(mAuthListener);
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//        if (mAuthListener != null) {
//            mAuth.removeAuthStateListener(mAuthListener);
//        }
//    }


    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    public void nextView() {

        startActivity(new Intent(this, Browse.class));
    }
}
