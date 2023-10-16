package com.example.calculatemybmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private RadioButton male;
    private RadioButton female;
    private EditText age;
    private EditText feet;
    private EditText inches;
    private EditText weight;
    private Button calculate;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        eventListener();
    }

    private void findViews() {
        male = findViewById(R.id.radio_button_male);
        female = findViewById(R.id.radio_button_female);
        age = findViewById(R.id.edit_text_age);
        feet = findViewById(R.id.edit_text_feet);
        inches = findViewById(R.id.edit_text_inches);
        weight = findViewById(R.id.edit_text_weight);
        calculate = findViewById(R.id.button_calculate);
        result = findViewById(R.id.text_view_result);
    }

    private void eventListener() {
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double bmi = calculateBMI();
                showResult(bmi);
            }
        });
    }

    private double calculateBMI() {
        int heightInInches = Integer.parseInt(feet.getText().toString()) * 12 + Integer.parseInt(inches.getText().toString());
        double heightInMeters = heightInInches * 0.0254;

        return Double.parseDouble(weight.getText().toString()) / (heightInMeters * heightInMeters);

    }

    private void showResult(double bmi) {
        DecimalFormat myFormatter = new DecimalFormat("0.00");
        String resultBmi = myFormatter.format(bmi);

        if (bmi < 18.5) {
            result.setText(resultBmi + " underweight");

        } else if (bmi > 25) {
            result.setText(resultBmi + " overweight");

        } else {
            result.setText(resultBmi + " healthy");
        }
    }
}