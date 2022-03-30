package com.example.write_out;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class writing extends AppCompatActivity {
    TextView textView;
    TextView textView2;
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writing);
        textView = findViewById(R.id.editTextTextPersonName3);
        textView2 = findViewById(R.id.textView4);
        editText = findViewById(R.id.body);
        button = findViewById(R.id.button2);

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
                FirebaseDatabase.getInstance().getReference().child("Author 1").push().setValue(m);
            }
        });


    }
}