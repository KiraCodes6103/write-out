package com.example.write_out;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DescFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    String Title, Category, Body;


    public DescFragment() {

    }

    public DescFragment(String Title, String Category, String Body) {
        this.Title = Title;
        this.Category = Category;
        this.Body = Body;
    }


    public static DescFragment newInstance(String param1, String param2) {
        DescFragment fragment = new DescFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_desc, container, false);

        TextView title = view.findViewById(R.id.TITLE);
        TextView category = view.findViewById(R.id.CATEGORY);
        TextView body = view.findViewById(R.id.BODY);

        title.setText(Title);
        category.setText(Category);
        body.setText(Body);
        return view;
    }
    public void onBackPressed(){

        AppCompatActivity activity = (AppCompatActivity)getContext();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.FrameContainer,new OtherArticle()).addToBackStack(null).commit();
    }
}