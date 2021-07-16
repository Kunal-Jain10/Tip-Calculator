package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText amount;
    TextView tip_percentage;
    Button calculate, clear;
    SeekBar sb_percentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculate);

        amount = findViewById(R.id.amount);
        tip_percentage = findViewById(R.id.tip_percentage);
        calculate = findViewById(R.id.calculate_button);
        clear = findViewById(R.id.clear_button);
        sb_percentage = findViewById(R.id.sb_percentage);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amount.setText("");
                tip_percentage.setText("0%");
            }
        });

        sb_percentage.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int percent = progress;
                tip_percentage.setText(String.valueOf(percent)+"%");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent(MainActivity.this,ResultPage.class);
                String initial_amount = (amount.getText().toString().trim());
                String tip_percentage = String.valueOf(sb_percentage.getProgress());
                resultIntent.putExtra("amount",initial_amount);
                resultIntent.putExtra("tip_percent",tip_percentage);
                startActivity(resultIntent);
            }
        });

    }

}