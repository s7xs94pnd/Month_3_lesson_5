package com.example.month_3_lesson_5.books;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.month_3_lesson_5.OnItemClick;
import com.example.month_3_lesson_5.R;

import java.util.ArrayList;

public class BooksAdapter extends RecyclerView.Adapter<BooksViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<Book> booksArr;
    private OnItemClick onClick;

    public BooksAdapter(LayoutInflater inflater, ArrayList<Book> booksArr, OnItemClick onClick) {
        this.inflater = inflater;
        this.booksArr = booksArr;
        this.onClick = onClick;
    }

    @NonNull
    @Override
    public BooksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_macket,parent,false);
        return new BooksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BooksViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Book book = booksArr.get(position);
        holder.OnBindBook(book);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClick.OnItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return booksArr.size();
    }
}