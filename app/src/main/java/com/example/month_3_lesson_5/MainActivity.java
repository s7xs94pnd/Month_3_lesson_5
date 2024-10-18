package com.example.month_3_lesson_5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void choice(View view) {
        Intent intent =new Intent(this,ContainerActivity.class);
        if(view.getId()==findViewById(R.id.books).getId()){
            intent.putExtra("ch","book");
        }
        else {
            intent.putExtra("ch","movies");
        }
        startActivity(intent);
    }
}