package com.example.android_lectures;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class L1_CustomListView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);


        ListItems[] listItems = new ListItems[5];
        listItems[0] = new ListItems(R.drawable.ic_launcher_background, "Apple");
        listItems[1] = new ListItems(R.drawable.ic_launcher_background, "Banana");
        listItems[2] = new ListItems(R.drawable.ic_launcher_background, "Orange");
        listItems[3] = new ListItems(R.drawable.ic_launcher_background, "Pear");
        listItems[4] = new ListItems(R.drawable.ic_launcher_background, "Mango");


        ListView listView = findViewById(R.id.customListView1);
        CustomAdapter customAdapter = new CustomAdapter(L1_CustomListView.this, listItems);
        listView.setAdapter(customAdapter);


        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            Toast.makeText(L1_CustomListView.this, "you have clicked " + i + " position.", Toast.LENGTH_SHORT).show();
        });
    }
}