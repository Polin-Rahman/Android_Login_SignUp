package com.example.user_login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText txtEmail, txtPassword,txtConfirmPassword;
    Button buttonRegister;
    ProgressBar progressBar;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtEmail =(EditText) findViewById(R.id.txt_email);
        txtPassword=(EditText) findViewById(R.id.txt_pssword);
        txtConfirmPassword =(EditText) findViewById(R.id.txt_confirm_password);
        buttonRegister =(Button) findViewById(R.id.btn_register);
        progressBar =(ProgressBar) findViewById(R.id.progress_Bar);

        firebaseAuth = FirebaseAuth.getInstance();

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = txtEmail.getText().toString().trim();
                String password = txtPassword.getText().toString().trim();
                String confirmPassword = txtConfirmPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(MainActivity.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(confirmPassword)){
                    Toast.makeText(MainActivity.this, "Please Enter Confirm Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(password.length()<2){
                    Toast.makeText(MainActivity.this, "Password is too short", Toast.LENGTH_SHORT).show();
                }

                progressBar.setVisibility(View.VISIBLE);

                if(password.equals(confirmPassword)){

                    //authentication perform
                    firebaseAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {


                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    progressBar.setVisibility(View.GONE);

                                    if (task.isSuccessful()) {
                                        startActivity(new Intent(getApplicationContext(),HomeActivity.class));

                                        Toast.makeText(MainActivity.this, "Registration Complete", Toast.LENGTH_SHORT).show();

                                    } else {

                                        Toast.makeText(MainActivity.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                       // startActivity(new Intent(getApplicationContext(),HomeActivity.class));

                                    }

                                    // ...
                                }
                            });










                }



            }

        });





    }
}
