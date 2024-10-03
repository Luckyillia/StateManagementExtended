package com.example.statemanagementextended;


import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private TextView counter;
    private int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null){
            number = savedInstanceState.getInt()
        }

        button = findViewById(R.id.button);
        counter = findViewById(R.id.counter);

        button.setOnClickListener(v -> {
            number++;
            counter.setText(String.valueOf("Licznik: "+number));
        });
    }
    @Override
    protected void 
}