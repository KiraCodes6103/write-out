package com.example.write_out;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class writing extends AppCompatActivity {
    TextView textView;
    TextView textView2;
    EditText editText;
    Button button;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writing);
        textView = findViewById(R.id.editTextTextPersonName3);
        textView2 = findViewById(R.id.textView4);
        editText = findViewById(R.id.body);
        button = findViewById(R.id.button2);
        auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();

        Intent intent = getIntent();
        String Title = intent.getStringExtra("TITLE");
        String Category = intent.getStringExtra("CATEGORY");
        String Body = editText.getText().toString();
        textView.setText(Title);
        textView2.setText(Category);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(writing.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                HashMap<String ,Object> m=new HashMap<String, Object>();
                m.put("Category", textView2.getText().toString());
                m.put("Title", textView.getText().toString());
                m.put("Body", editText.getText().toString());
                FirebaseDatabase.getInstance().getReference("Articles").child(user.getUid()).push().setValue(m);
                FirebaseDatabase.getInstance().getReference().child("AllArticles").push().setValue(m);
            }
        });


    }
}