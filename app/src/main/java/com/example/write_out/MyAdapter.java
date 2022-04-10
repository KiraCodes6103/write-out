package com.example.write_out;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;


public class MyAdapter extends FirebaseRecyclerAdapter<model,MyAdapter.myviewholder> {


    public MyAdapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull model model) {
        holder.topic.setText(model.getTitle());
        holder.category.setText(model.getCategory());
        holder.body.setText(model.getBody());
        holder.topic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.FrameContainer,new DescFragment(model.getTitle(),model.getCategory(),model.getBody())).addToBackStack(null).commit();

            }
        });

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowdesign,parent,false);
       return new myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder{
        TextView topic, category, body;

        public myviewholder(@NonNull View itemView) {
            super(itemView);

            topic = itemView.findViewById(R.id.topic);
            category = itemView.findViewById(R.id.category);
            body = itemView.findViewById(R.id.body);

        }
    }
}
