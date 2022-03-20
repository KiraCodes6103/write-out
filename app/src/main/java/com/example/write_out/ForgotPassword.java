package com.example.write_out;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {

    private EditText emailEdit;
    private Button reset;
    private ProgressBar progressBar;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        emailEdit = findViewById(R.id.email3);
        reset = findViewById(R.id.Reset);
        progressBar = findViewById(R.id.progressBar);
        auth = FirebaseAuth.getInstance();

        reset.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                resetPassword();
            }
        });
    }
    private void resetPassword() {
        String email = emailEdit.getText().toString().trim();

        if(email.isEmpty()){
            emailEdit.setError("email is required");
            emailEdit.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailEdit.setError("Please provide a valid Email");
            emailEdit.requestFocus();
            return;

        }
        progressBar.setVisibility(View.VISIBLE);

        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(ForgotPassword.this, "Check Email To Reset Your Password", Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.INVISIBLE);
                }
                else{
                    Toast.makeText(ForgotPassword.this, "Something Went Wrong!", Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.INVISIBLE);
                }
            }
        });

    }
}