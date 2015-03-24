package com.tinkercademy.yjsoon.dadjokes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class JokeDetailActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_detail);

        final TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(JokesListActivity.mJokeClickedQuestion);
        final Button button = (Button) findViewById(R.id.button);
        button.setVisibility(View.GONE);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(JokesListActivity.mJokeClickedAnswer);

                button.setVisibility(View.VISIBLE);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(JokeDetailActivity.this, JokesListActivity.class);
                        JokeDetailActivity.this.finish();
                        startActivity(intent);
                    }
                });
            }
        });
    }

}
