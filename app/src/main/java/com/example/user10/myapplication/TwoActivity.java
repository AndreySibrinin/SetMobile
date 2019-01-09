package com.example.user10.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;


public class TwoActivity extends AppCompatActivity {

    private int token;
    private ArrayList<Card> cards = new ArrayList<Card>();


    private RecyclerView CardsList;
    private CardAdapter cardAdapter;


    private Button button;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
//        textView2 = (TextView) findViewById(R.id.textView2);
//        button = (Button) findViewById(R.id.button2);

        //  textView2 = (TextView) findViewById(R.id.textView2);
        Intent intent = getIntent();
        this.token = intent.getIntExtra("token", 0);


        ThreadList threadL = new ThreadList(token);
        threadL.start();
        try {
            threadL.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.cards = threadL.getAllcards();


        CardsList = findViewById(R.id.rv_numbers);
        LinearLayoutManager layoutManager = new GridLayoutManager(this, 3);
        CardsList.setLayoutManager(layoutManager);
        CardsList.setHasFixedSize(true);


        cardAdapter = new CardAdapter(cards, this);
        CardsList.setAdapter(cardAdapter);


    }

//    public void onclick2(View v) {
//        HashMap<Integer, Card> test = cardAdapter.getListE();
//    }

}
