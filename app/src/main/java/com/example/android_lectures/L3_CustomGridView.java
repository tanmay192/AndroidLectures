package com.example.android_lectures;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class L3_CustomGridView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l3_custom_grid_view);

        ArrayList<ListItems> myList = new ArrayList<>();
        myList.add(new ListItems(R.drawable.ic_launcher_background, "Apple"));
        myList.add(new ListItems(R.drawable.ic_launcher_background, "Banana"));
        myList.add(new ListItems(R.drawable.ic_launcher_background, "Pear"));
        myList.add(new ListItems(R.drawable.ic_launcher_background, "Orange"));

        CustomGridAdapter customGridAdapter = new CustomGridAdapter(L3_CustomGridView.this, myList);
        GridView gridView = findViewById(R.id.customGridView1);

        gridView.setAdapter(customGridAdapter);

        gridView.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent intent = new Intent(L3_CustomGridView.this, L3_IntentTransfer.class);
            TextView textView = view.findViewById(R.id.customGridTextView);
            ImageView imageView = view.findViewById(R.id.customGridImg);
            int id = getResources().getIdentifier("ic_launcher_background", "drawable", getPackageName());

            intent.putExtra("Text", textView.getText().toString());
            intent.putExtra("ImgId", id);
            startActivity(intent);
        });
    }
}