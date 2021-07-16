package com.example.tipcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class ResultPage extends AppCompatActivity {

    TextView total_amount_tv,tip_amount_tv,total_amount_val, tip_amount_val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        total_amount_tv = (TextView)findViewById(R.id.total_amount_textView);
        tip_amount_tv = (TextView)findViewById(R.id.tip_amount_textView);
        total_amount_val = (TextView)findViewById(R.id.total_amount_value);
        tip_amount_val = (TextView)findViewById(R.id.tip_amount_value);

        Intent resultIntent = getIntent();
        double amount = Double.parseDouble(resultIntent.getStringExtra("amount"));
        int tip_percentage = Integer.parseInt(resultIntent.getStringExtra("tip_percent"));
        double tip_amount = amount * (tip_percentage/100.0d);
        double total_amount = amount + tip_amount;
        total_amount_val.setText("Rs "+String.valueOf(total_amount));
        tip_amount_val.setText("Rs "+String.valueOf(tip_amount));
    }
}



