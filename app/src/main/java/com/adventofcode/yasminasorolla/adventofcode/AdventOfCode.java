package com.adventofcode.yasminasorolla.adventofcode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.adventofcode.yasminasorolla.adventofcode.ex1.Exercise1;
import com.jakewharton.rxbinding.view.RxView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdventOfCode extends AppCompatActivity {

    @BindView(R.id.button_day1)
    View day1button;

    @BindView(R.id.input_text)
    EditText inputText;

    @BindView(R.id.resulting_value)
    TextView resText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advent_of_code);

        ButterKnife.bind(this);

        RxView.clicks(day1button)
                .subscribe(click -> button1Program(inputText.getText().toString()));
    }

    private void button1Program(String inputText) {
        String output = String.valueOf(Exercise1.calculateFloor(inputText));
        resText.setText(output);
    }
}
