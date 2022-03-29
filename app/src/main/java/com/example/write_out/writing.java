package com.example.write_out;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class writing extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writing);
        textView = findViewById(R.id.textView4);

        Intent intent = getIntent();
        String Title = intent.getStringExtra("TITLE");
        String Category = intent.getStringExtra("CATEGORY");
        textView.setText("TITLE : "+ Title);

    }
}