package com.tinkercademy.yjsoon.dadjokes;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

//test
public class JokesListActivity extends ListActivity {

    public static String mJokeClickedQuestion;
    public static String mJokeClickedAnswer;
    private static Joke[] mJokes = {
            new Joke("Can crusher", "Why did the can crusher quit his job?", "Because it was so depressing"),
            new Joke("Nose", "What do you call someone with a nose but no body?", "Nobody knows"),
            new Joke("Muffler", "Last night I dreamt I was a muffler", " I woke up exhausted")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes_list);

        JokeAdapter adapter;
        adapter = new JokeAdapter(this, R.layout.list_item_joke, mJokes);
        setListAdapter(adapter);

    }

    private class JokeAdapter extends ArrayAdapter<Joke> {

        private int mResource;
        private Joke[] mJokes;

        public JokeAdapter(Context context, int resource, Joke[] jokes) {
            super(context, resource, jokes);
            mResource = resource;
            mJokes = jokes;
        }

        @Override
        public View getView(int position, View row, ViewGroup parent) {
            if (row == null) {
                row = getLayoutInflater().inflate(mResource, parent, false);
            }

            Joke currentJoke = mJokes[position];

            TextView textView = (TextView) row.findViewById(R.id.list_text);
            textView.setText(currentJoke.getTitle());


            ImageView imageView = (ImageView) row.findViewById(R.id.list_graphic);
            if (currentJoke.isSeen()) {
                imageView.setVisibility(View.GONE);
            }
            else {
                imageView.setVisibility(View.VISIBLE);
            }

            notifyDataSetChanged();

            return row;
        }

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        mJokeClickedQuestion = mJokes[position].getQuestion();
        mJokeClickedAnswer = mJokes[position].getAnswer();
        mJokes[position].setSeen(true);

        Intent intent = new Intent(JokesListActivity.this, JokeDetailActivity.class);
        JokesListActivity.this.finish();
        startActivity(intent);
    }

}