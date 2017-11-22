package com.example.lgs.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText userInput;
    private TextView textView;
    private SeekBar textSizeSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnEnter = findViewById(R.id.btnEnter);
        Button btnClear = findViewById(R.id.btnClear);
//        btnDone = findViewById(R.id.button);
        userInput = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
//        tvNewPage = findViewById(R.id.tvNewPage);
        textSizeSlider = findViewById(R.id.seekBar);
//        newPageSwitch = findViewById(R.id.switch1);

        textView.setMovementMethod(new ScrollingMovementMethod());

        OnClickListener enterButtonListener = new OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = userInput.getText().toString();
                if (!result.equals("")) {
                    result += "\n";
                    textView.append(result);
                    userInput.setText("");
                }
            }
        };

        OnClickListener clearButtonListener = new OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = textView.getText().toString();
                if (!text.equals("")) {
                    textView.setText("");
                }
                textSizeSlider.setProgress(0);
            }
        };

        SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textView.setTextSize(textSizeSlider.getProgress() + 15);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        };

        btnEnter.setOnClickListener(enterButtonListener);
        btnClear.setOnClickListener(clearButtonListener);
//        btnDone.setOnClickListener(doneButtonListener);
        textSizeSlider.setOnSeekBarChangeListener(seekBarChangeListener);
    }
}

