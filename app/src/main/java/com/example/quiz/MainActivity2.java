package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity2 extends AppCompatActivity {

    Chronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        chronometer = findViewById(R.id.meter);

    }
    public void startMeter(View view){
        chronometer.start();
    }

    public void sendCounter(View view){
        String counter_data = chronometer.getText().toString();
        if(TextUtils.isEmpty(counter_data)){
            Intent intent = new Intent("com.example.quiz.SENDER_DATA");
            Intent.putExtra("senderMessage",counter_data);

            sendBroadcast(intent);
        }


    }
}