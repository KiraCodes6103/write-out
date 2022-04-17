package com.example.write_out;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.write_out.databinding.ActivityBottomNavBinding;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class BottomNav extends AppCompatActivity {
    FirebaseAuth mFirebase;
    ActivityBottomNavBinding binding;
    RecyclerView recview;
    MyAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




    binding = ActivityBottomNavBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());
    replacefragment(new OtherArticle());

    binding.bottomnavigation.setOnItemSelectedListener(item -> {
        switch (item.getItemId()){

            case R.id.My: replacefragment(new OtherArticle());
                break;
            case R.id.Other: replacefragment(new MyProfile());
                break;
            case R.id.Favourites:  replacefragment(new Favourite());
                break;
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
    public void logout(View view){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(BottomNav.this, Login.class));
        finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search,menu);
        MenuItem menuItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView)menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                processsearch(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                processsearch(s);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    private void processsearch(String s) {
        recview=(RecyclerView)findViewById(R.id.recview);
        FirebaseRecyclerOptions<model> options =
                new FirebaseRecyclerOptions.Builder<model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("AllArticles").orderByChild("Category").startAt(s).endAt(s+"\uf8ff"), model.class)
                        .build();
        adapter = new MyAdapter(options);
        adapter.startListening();
        recview.setAdapter(adapter);

    }


}