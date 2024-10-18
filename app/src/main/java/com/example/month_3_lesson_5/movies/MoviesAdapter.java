package com.example.month_3_lesson_5.movies;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.month_3_lesson_5.OnItemClick;
import com.example.month_3_lesson_5.R;


import java.util.ArrayList;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesViewHolder> {
    private LayoutInflater inflater;
    private OnItemClick onClick;
    private ArrayList<Movie> moviesArr;


    public MoviesAdapter(LayoutInflater inflater, ArrayList<Movie> moviesArr,OnItemClick onClick) {
        this.inflater = inflater;
        this.moviesArr = moviesArr;
        this.onClick = onClick;

    }

    @NonNull
    @Override
    public MoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_macket,parent,false);
        return new MoviesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.OnBindMovie(moviesArr.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClick.OnItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return moviesArr.size();
    }
}