package com.example.write_out;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class like extends AppCompatActivity {
    ImageView imageView;
    TextView textView1;
    TextView textView2;
    TextView textView3;

    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singlerowdesign);
        imageView = findViewById(R.id.like);
        textView1 = findViewById(R.id.topic);
        textView2 = findViewById(R.id.category);
        textView3 = findViewById(R.id.body);
        auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();
        
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(like.this, "Liked", Toast.LENGTH_SHORT).show();
            }
        });
//        HashMap<String ,Object> m=new HashMap<String, Object>();
//        m.put("Category", textView2.getText().toString());
//        m.put("Title", textView1.getText().toString());
//        m.put("Body", textView3.getText().toString());
//        FirebaseDatabase.getInstance().getReference().child(user.getUid()).push().setValue(m);

    }
}
