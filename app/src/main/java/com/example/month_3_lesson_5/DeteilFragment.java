package com.example.month_3_lesson_5;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.month_3_lesson_5.books.Book;
import com.example.month_3_lesson_5.databinding.FragmentDeteilBinding;
import com.example.month_3_lesson_5.movies.Movie;


public class DeteilFragment extends Fragment {

    private FragmentDeteilBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentDeteilBinding.inflate(getLayoutInflater());
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments()!=null){
            if(getArguments().getString("choice").equals("book")){
                 Book book = getArguments().getParcelable("book");
                binding.desc.setText(book.getDesc());
                binding.name.setText(book.getName());
                binding.materialButton.setText("read");
                binding.score.setText(String.valueOf(book.getScore()));
                if (book.isFav()){
                    binding.fav.setImageResource(R.drawable.baseline_favorite_24);
                }
                binding.read.setVisibility(View.VISIBLE);
                binding.read.setText(book.getDesc());
                binding.desc.setVisibility(View.GONE);
            }


            if(getArguments().getString("choice").equals("mov")){
                 Movie movie = getArguments().getParcelable("mov");
                binding.desc.setText(movie.getDesc());
                binding.name.setText(movie.getName());
                binding.score.setText(String.valueOf(movie.getScore()));
                if (movie.isFav()){
                    binding.fav.setImageResource(R.drawable.baseline_favorite_24);
                }

            }
        }
    }
}