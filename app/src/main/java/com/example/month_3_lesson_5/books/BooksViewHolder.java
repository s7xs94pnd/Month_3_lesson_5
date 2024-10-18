package com.example.month_3_lesson_5.books;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.month_3_lesson_5.R;


public class BooksViewHolder extends RecyclerView.ViewHolder {
    private ImageView ivImg,ivFav;
    private TextView tvName,tvGanr,tvDesc,tvScore;
    public BooksViewHolder(@NonNull View itemView) {
        super(itemView);
        ivImg = itemView.findViewById(R.id.img);
        ivFav = itemView.findViewById(R.id.fav);
        tvName=itemView.findViewById(R.id.name);
        tvDesc=itemView.findViewById(R.id.desc);
        tvGanr=itemView.findViewById(R.id.ganr);
        tvScore=itemView.findViewById(R.id.score);
    }
    public void OnBindBook(Book book){
        ivImg.setImageResource(book.getImg());
        if (book.isFav()){
            ivFav.setImageResource(R.drawable.baseline_favorite_24);
        }
        tvName.setText(book.getName());
        tvGanr.setText(book.getGanr());
        tvDesc.setText(book.getDesc());
        tvScore.setText(String.valueOf(book.getScore()));
    }
}
