package com.example.lab1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        TextView textView = findViewById(R.id.textView);
        RadioGroup colorRadioGroup = findViewById(R.id.radioGroup);
        RadioGroup priceRadioGroup = findViewById(R.id.radioGroup2);

        button.setOnClickListener(v -> {
            int colorInt = colorRadioGroup.getCheckedRadioButtonId();
            int priceInt = priceRadioGroup.getCheckedRadioButtonId();
            if (colorInt == -1 || priceInt == -1) {
                Toast.makeText(MainActivity.this,
                        "Вкажіть дані", Toast.LENGTH_SHORT).show();
            } else {
                RadioButton priceRadioButton = priceRadioGroup.findViewById(priceInt);
                RadioButton colorRadioButton = colorRadioGroup.findViewById(colorInt);
                String price = priceRadioButton.getText().toString();
                String color = colorRadioButton.getText().toString();
                textView.setText("Ваше замовлення: колір - " + color + ", діапазон цін - " + price);
            }
        });
    }
}