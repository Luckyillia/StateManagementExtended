package com.example.statemanagementextended;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.view.View;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.lifecycle.ViewModelProvider;
import android.text.TextWatcher;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private StateViewModel stateViewModel;
    private TextView counter;
    private Switch switch1;
    private CheckBox checkBox;
    private TextView textView;
    private EditText textEdit;
//    private static final String KEY_COUNT = "number";
//    private static final String KEY_THEME = "switch";
//    private static final String KEY_VISIBLE = "checkbox";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("stateCreate", "ON");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switch1 = findViewById(R.id.switch1);
        checkBox = findViewById(R.id.checkBox);
        Button button = findViewById(R.id.button);
        counter = findViewById(R.id.counter);
        textView = findViewById(R.id.textview);
        textEdit = findViewById(R.id.editText);

        stateViewModel = new ViewModelProvider(this).get(StateViewModel.class);
        updateView();
        textEdit.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int count, int after){
                    stateViewModel.setText(textEdit.getText().toString().trim());
                    Log.w("stateText", String.valueOf(stateViewModel.getText()));
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Toast.makeText(getApplicationContext(),"after text change",Toast.LENGTH_LONG).show();
            }
        });

        switch1.setOnCheckedChangeListener((textView, isChecked) -> {
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
            stateViewModel.setSwitch(isChecked);
            updateView();
            Log.w("stateSwitch", String.valueOf(stateViewModel.getSwitch()));
        });
        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked) {
                textView.setVisibility(View.VISIBLE);
            } else {
                textView.setVisibility(View.GONE);
            }
            stateViewModel.setCheckBox(isChecked);
            updateView();
            Log.e("stateCheckBox", String.valueOf(stateViewModel.getCheckBox()));
        });
        button.setOnClickListener(v -> {
            stateViewModel.incrementNumber();
            updateView();
            Log.i("stateButton", String.valueOf(stateViewModel.getNumber()));
        });
    }
//    @Override
//    protected void onSaveInstanceState(@NotNull Bundle outState){
//        super.onSaveInstanceState(outState);
//        outState.putInt(KEY_COUNT, stateViewModel.getNumber());
//        outState.putBoolean(KEY_VISIBLE, stateViewModel.getCheckBox());
//        outState.putBoolean(KEY_THEME, stateViewModel.getSwitch());
//    }
    private void updateView(){
        counter.setText("Licznik: " + stateViewModel.getNumber());
        checkBox.setChecked(stateViewModel.getCheckBox());
        if(stateViewModel.getCheckBox()) {
            textView.setVisibility(View.VISIBLE);
        } else {
            textView.setVisibility(View.GONE);
        }
        switch1.setChecked(stateViewModel.getSwitch());
        if (stateViewModel.getSwitch()) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
        textEdit.setText(stateViewModel.getText());
        textEdit.setSelection(textEdit.getText().length());
    }
}