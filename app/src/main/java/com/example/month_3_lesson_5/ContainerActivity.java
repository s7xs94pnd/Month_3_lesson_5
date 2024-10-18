package com.example.month_3_lesson_5;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.month_3_lesson_5.books.BooksFragment;
import com.example.month_3_lesson_5.movies.MoviesFragment;


public class ContainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        String ch = getIntent().getStringExtra("ch");

        if (ch!=null &&ch.equals("book")){
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentMain,new BooksFragment()).commit();
            Log.d("ggggggggggggggggg", "goBooks ");
        }else if (ch!=null &&ch.equals("movies")){
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentMain,new MoviesFragment()).commit();
            Log.d("ggggggggggggggggg", "goMovies ");

        }

    }
}