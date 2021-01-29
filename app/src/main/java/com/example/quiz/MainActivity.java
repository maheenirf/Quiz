package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.recieveCount);
        IntentFilter intentFilter = new IntentFilter("com.example.quiz.SENDER_DATA");
        registerReceiver(innerBroadcast, intentFilter);


    }
    private BroadcastReceiver innerBroadcast = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if ("com.example.quiz.SENDER_DATA".equals(intent.getAction())){
                String text = intent.getStringExtra("senderMessage");
                textView.setText("Counter Value from Sender"+ text);
            }

        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(innerBroadcast);
    }
}