package com.example.badge.androidapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((Settings) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id._d_fitness:
                if (checked){
                    // Put some meat on the sandwich
                }
            else
                break;
            case R.id._w_fitness:
                if (checked){
                    // Put some meat on the sandwich
                }
                else
                    break;
            case R.id._m_fitness:
                if (checked){
                    // Put some meat on the sandwich
                }
                else
                    break;
            case R.id._d_funny:
                if (checked){
                    // Put some meat on the sandwich
                }
                else
                    break;
            case R.id._w_funny:
                if (checked){
                    // Put some meat on the sandwich
                }
                else
                    break;
            case R.id._m_funny:
                if (checked){
                    // Put some meat on the sandwich
                }
                else
                    break;
            case R.id._d_inspiration:
                if (checked){
                    // Put some meat on the sandwich
                }
                else
                    break;
            case R.id._w_inspiration:
                if (checked){
                    // Put some meat on the sandwich
                }
                else
                    break;
            case R.id._m_inspiration:
                if (checked){
                    // Put some meat on the sandwich
                }
                else
                    break;
            case R.id._d_life:
                if (checked){
                    // Put some meat on the sandwich
                }
                else
                    break;
            case R.id._w_life:
                if (checked){
                    // Put some meat on the sandwich
                }
                else
                    break;
            case R.id._m_life:
                if (checked){
                    // Put some meat on the sandwich
                }
                else
                    break;
            case R.id._d_love:
                if (checked){
                    // Put some meat on the sandwich
                }
                else
                    break;
            case R.id._w_love:
                if (checked){
                    // Put some meat on the sandwich
                }
                else
                    break;
            case R.id._m_love:
                if (checked){
                    // Put some meat on the sandwich
                }
                else
                    break;
            case R.id._d_wisdom:
                if (checked){
                    // Put some meat on the sandwich
                }
                else
                    break;
            case R.id._w_wisdom:
                if (checked){
                    // Put some meat on the sandwich
                }
                else
                    break;
            case R.id._m_wisdom:
                if (checked){
                    // Put some meat on the sandwich
                }
                else
                    break;
        }
    }

    public void nextView(View view) {
        try {
            startActivity(new Intent(this, Browse.class));
        }
        catch (Exception e) {
            Log.d("Main Activity TRANSFER", e.toString());
        }
    }
}
