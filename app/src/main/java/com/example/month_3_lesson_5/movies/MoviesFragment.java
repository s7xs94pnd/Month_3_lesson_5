package com.example.month_3_lesson_5.movies;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.month_3_lesson_5.DeteilFragment;
import com.example.month_3_lesson_5.OnItemClick;
import com.example.month_3_lesson_5.R;

import java.util.ArrayList;

public class MoviesFragment extends Fragment implements OnItemClick {

    private ArrayList<Movie> movieArr = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadMovies();
        initRV();
    }

    private void loadMovies() {
        movieArr.add(new Movie("Оно", "Ужасающий клоун терроризирует город", "Ужасы", R.drawable.ono, 4.8, true));
        movieArr.add(new Movie("Сияние", "Мужчина сходит с ума в отеле с привидениями", "Ужасы", R.drawable.siznie, 4.7, false));
        movieArr.add(new Movie("Гарри Поттер", "Мальчик узнает, что он волшебник", "Фэнтези", R.drawable.harry, 4.9, true));
        movieArr.add(new Movie("Властелин колец", "Хоббит отправляется в путешествие, чтобы уничтожить кольцо", "Фэнтези", R.drawable.kol, 5.0, false));
        movieArr.add(new Movie("Убить пересмешника", "Адвокат защищает чернокожего мужчину в сегрегированном юге", "Драма", R.drawable.ubi, 4.5, true));
        movieArr.add(new Movie("Гордость и предубеждение", "История любви в Англии XIX века", "Романтика", R.drawable.img, 4.6, true));
        movieArr.add(new Movie("1984", "Дистопическое общество под постоянным наблюдением", "Антиутопия", R.drawable.img_1, 4.9, false));
        movieArr.add(new Movie("Моби Дик", "Капитан охотится на огромного белого кита", "Приключения", R.drawable.img_2, 4.3, true));
        movieArr.add(new Movie("Великий Гэтсби", "Тайный миллионер одержим женщиной", "Драма", R.drawable.img_3, 4.7, false));
        movieArr.add(new Movie("Над пропастью во ржи", "Молодой человек путешествует по Нью-Йорку", "Драма", R.drawable.img_4, 4.4, false));
    }

    private void initRV() {
        RecyclerView recyclerView =  requireActivity().findViewById(R.id.rvMovies);
        MoviesAdapter adapter = new MoviesAdapter(this.getLayoutInflater(),movieArr,this);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void OnItemClick(int position) {
        Movie movie = movieArr.get(position);
        Bundle bundle = new Bundle();
        bundle.putString("choice","mov");
        bundle.putParcelable("mov",movie);
        DeteilFragment deteilFragment = new DeteilFragment();
        deteilFragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentMain,deteilFragment).commit();
    }
}