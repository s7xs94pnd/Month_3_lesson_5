package com.example.month_3_lesson_5.books;

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
import com.example.month_3_lesson_5.movies.Movie;

import java.util.ArrayList;


public class BooksFragment extends Fragment implements OnItemClick {

    private ArrayList<Book> booksArr= new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_books, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    // TODO: 17/10/24
    laoadBooks();
    initRV();
    }

    private void initRV() {
        RecyclerView recyclerView = requireActivity().findViewById(R.id.rvBooks);
        BooksAdapter adapter = new BooksAdapter(this.getLayoutInflater(),booksArr,this);
        recyclerView.setAdapter(adapter);
    }

    private void laoadBooks() {
        booksArr.add(new Book("Оно", "Ужасающий клоун терроризирует город", "Ужасы", R.drawable.ono, 4.8, true));
        booksArr.add(new Book("Сияние", "Мужчина сходит с ума в отеле с привидениями", "Ужасы", R.drawable.siznie, 4.7, true));
        booksArr.add(new Book("Гарри Поттер", "Мальчик узнает, что он волшебник", "Фэнтези", R.drawable.harry, 4.9, true));
        booksArr.add(new Book("Властелин колец", "Хоббит отправляется в путешествие, чтобы уничтожить кольцо", "Фэнтези", R.drawable.kol, 5.0, true));
        booksArr.add(new Book("Убить пересмешника", "Адвокат защищает чернокожего мужчину в сегрегированном юге", "Драма", R.drawable.ubi, 4.5, true));
        booksArr.add(new Book("Гордость и предубеждение", "История любви в Англии XIX века", "Романтика", R.drawable.img, 4.6, true));
        booksArr.add(new Book("1984", "Дистопическое общество под постоянным наблюдением", "Антиутопия", R.drawable.img_1, 4.9, true));
        booksArr.add(new Book("Моби Дик", "Капитан охотится на огромного белого кита", "Приключения", R.drawable.img_2, 4.3, true));
        booksArr.add(new Book("Великий Гэтсби", "Тайный миллионер одержим женщиной", "Драма", R.drawable.img_3, 4.7, true));
        booksArr.add(new Book("Над пропастью во ржи", "Молодой человек путешествует по Нью-Йорку", "Драма", R.drawable.img_4, 4.4, true));
    }

    @Override
    public void OnItemClick(int position) {
        Book book = booksArr.get(position);
        Bundle bundle = new Bundle();
        bundle.putString("choice","book");
        bundle.putParcelable("book",book);
        DeteilFragment deteilFragment = new DeteilFragment();
        deteilFragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentMain,deteilFragment).commit();
    }
}