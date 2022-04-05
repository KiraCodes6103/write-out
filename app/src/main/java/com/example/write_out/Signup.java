package com.example.write_out;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Signup extends AppCompatActivity {
     private EditText email2;
     private EditText password2;
    private FirebaseAuth auth;
    private EditText fullName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        email2 = findViewById(R.id.email2);
        password2 = findViewById(R.id.password2);
        fullName = findViewById(R.id.name2);
        Button signup = findViewById(R.id.signup);
        auth = FirebaseAuth.getInstance();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email1 = email2.getText().toString();
                String password1 = password2.getText().toString();
                String name= fullName.getText().toString();
                if (TextUtils.isEmpty(email1) || TextUtils.isEmpty(password1))
                {
                    Toast.makeText(Signup.this, "Error", Toast.LENGTH_SHORT).show();

                }
                else {
                    sign(email1,password1,name);
                }
            }
        });
    }
    private void sign(String email, String password, String name){
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(Signup.this, "successfully Signed-Up", Toast.LENGTH_SHORT).show();
                    FirebaseUser user = auth.getCurrentUser();
                    ReadUser writeUserDetails = new ReadUser(name);
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Registered Users");
                    reference.child(user.getUid()).setValue(writeUserDetails).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(Signup.this, "Successfully Signed in", Toast.LENGTH_SHORT).show();
                        }
                    });


                }
                else {
                    Toast.makeText(Signup.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void openActivity(View v) {
        Toast.makeText(this, "Opening Log-In Page", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}