package com.example.write_out;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NewAricle extends AppCompatActivity {
    Spinner spinner;
    Button submit;
    EditText edittext;

    String[] category = {"--Choose a Category--","Sports", "Education", "Entertainment", "Current Affairs", "Politics"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_aricle);
        submit = findViewById(R.id.button);
        spinner = findViewById(R.id.spinner);
        edittext = findViewById(R.id.editTextTextPersonName);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(NewAricle.this, android.R.layout.simple_spinner_item, category);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (adapterView.getItemAtPosition(i).equals("--Choose a Category--")) {

                }
                else{
                    String selected = adapterView.getItemAtPosition(i).toString();
                    Toast.makeText(NewAricle.this, selected, Toast.LENGTH_SHORT).show();
                }
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String Title = edittext.getText().toString();
                        String Category = spinner.getItemAtPosition(i).toString();
                        Intent intent = new Intent(NewAricle.this, writing.class);
                        intent.putExtra("TITLE", Title);
                        intent.putExtra("CATEGORY", Category);
                        NewAricle.this.startActivity(intent);
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
}