package com.tinkercademy.yjsoon.dadjokes;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

//test
public class JokesListActivity extends ListActivity {

    private Joke[] mJokes = {
        new Joke("Can crusher", "Why did the can crusher quit his job?", "Because it was so depressing"),
        new Joke("Nose", "What do you call someone with a nose but no body?", "Nobody knows"),
        new Joke("Muffler", "Last night I dreamt I was a muffler", " I woke up exhausted")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes_list);

        ArrayAdapter<Joke> adapter;

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mJokes);
        setListAdapter(adapter);

    }

}
