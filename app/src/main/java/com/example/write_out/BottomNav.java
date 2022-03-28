package com.example.write_out;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.write_out.databinding.ActivityBottomNavBinding;
import com.google.firebase.auth.FirebaseAuth;

public class BottomNav extends AppCompatActivity {
    FirebaseAuth mFirebase;
    ActivityBottomNavBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    binding = ActivityBottomNavBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());
    replacefragment(new MyProfile());

    binding.bottomnavigation.setOnItemSelectedListener(item -> {
        switch (item.getItemId()){

            case R.id.My: replacefragment(new MyProfile());
                break;
            case R.id.Other: replacefragment(new OtherArticle());
                break;
            case R.id.Favourites:  replacefragment(new Favourite());
                break;
            case R.id.Logout_Button: replacefragment(new LogOut_Fragment());
        }

        return  true;
    });
    }
    private void replacefragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.FrameContainer,fragment);
        fragmentTransaction.commit();

    }
    public void NewArticle(View view){
        Intent intent = new Intent(this, NewAricle.class);
        startActivity(intent);

    }


}