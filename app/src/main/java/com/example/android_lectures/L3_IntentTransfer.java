package com.example.android_lectures;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class L3_IntentTransfer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l3_intent_transfer);

        TextView textView= findViewById(R.id.intentText);
        ImageView imageView = findViewById(R.id.intentImg);

        Intent intent = getIntent();
        int imgId = intent.getIntExtra("ImgId", 0);
        String text = intent.getStringExtra("Text");
        textView.setText(text);

        imageView.setImageResource(imgId);
    }
}