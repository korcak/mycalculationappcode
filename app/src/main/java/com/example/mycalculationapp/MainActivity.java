package com.example.mycalculationapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView resultText;
    private EditText inchesEditText;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inchesString = inchesEditText.getText().toString();
                if (inchesString.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please input a value", Toast.LENGTH_LONG).show();
                } else {
                    double result = convertToMeters(inchesString);
                    MainActivity.this.displayResult(result);
                }
            }
        });
    }

    private void findViews() {
        resultText = findViewById(R.id.text_view_result);
        inchesEditText = findViewById(R.id.edit_text_inches);
        calculateButton = findViewById(R.id.button_calculate);
    }

    private double convertToMeters(String inchesString) {
        int inches = Integer.parseInt(inchesString);
        return inches / 39.3700787;
    }

    private void displayResult(double result) {
        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String resultString = myDecimalFormatter.format(result);
        resultText.setText(resultString + " meters");
    }
}