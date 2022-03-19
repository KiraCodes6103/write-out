package com.example.write_out;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private EditText email1;
    private EditText password1;
    private FirebaseAuth auth1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email1 = findViewById(R.id.email);
        password1 = findViewById(R.id.password);
        Button login = findViewById(R.id.login);
        auth1 = FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = email1.getText().toString();
                String password = password1.getText().toString();
                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password))
                {
                    Toast.makeText(Login.this, "Error", Toast.LENGTH_SHORT).show();

                }
                else {
                    log(email,password);
                }
            }
        });
    }
    private void log(String emailx, String passwordx){
        auth1.signInWithEmailAndPassword(emailx,passwordx).addOnSuccessListener(Login.this, new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {

                    Toast.makeText(Login.this, "successfully Logged-In", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void openActivity(View v) {
        Toast.makeText(this, "Opening Sign-Up Page", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Signup.class);
        startActivity(intent);
    }
}