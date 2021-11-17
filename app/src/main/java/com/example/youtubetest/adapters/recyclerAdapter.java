package com.example.youtubetest.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youtubetest.Music;
import com.example.youtubetest.R;

import java.util.ArrayList;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.MyViewHolder> {
    private ArrayList<Music> musicList;

    public recyclerAdapter(ArrayList<Music> musicList){
        this.musicList = musicList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView videoD;

        public MyViewHolder(final View view){
            super(view);
            videoD = itemView.findViewById(R.id.videoD);
        }
    }

    @NonNull
    @Override
    public recyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerAdapter.MyViewHolder holder, int position) {
        String name = musicList.get(position).getUsername();
        holder.videoD.setText(name);
    }

    @Override
    public int getItemCount() {
        return musicList.size();
    }
}
