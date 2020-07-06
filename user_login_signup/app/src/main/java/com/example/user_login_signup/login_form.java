package com.example.user_login_signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class login_form extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);
    }

    /*click and start new activity
        using this method
      initialized button with id in xml file
    */

    public void btn_SignupForm(View view) {
        startActivity(new Intent(getApplicationContext(),signUp_form.class));
    }


}
