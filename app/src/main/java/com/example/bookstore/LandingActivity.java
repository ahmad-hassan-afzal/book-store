package com.example.bookstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class LandingActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view_books);
        String[] booksTitles = {"Abyss","Crying Book","Arrivals","Crying Book 2","Hammer of Doom","King of Drugs","Memory","Mystic Emperors","Sing to it","You"};
        double[] booksPrices = {54.99, 34.99, 44.99, 24.99, 74.99, 34.99, 94.99, 44.99, 24.99, 74.99};
        int[] booksCovers = {
                R.drawable.abyss, R.drawable.crying_book, R.drawable.arrivals, R.drawable.crying_book_2,
                R.drawable.hammer_of_doom, R.drawable.king_of_drugs, R.drawable.memory,
                R.drawable.mystic_emperors, R.drawable.sing_to_it, R.drawable.you
        };

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new BooksAdapter(this, booksTitles, booksPrices, booksCovers));

    }
}