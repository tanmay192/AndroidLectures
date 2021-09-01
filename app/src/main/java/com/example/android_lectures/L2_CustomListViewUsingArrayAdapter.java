package com.example.android_lectures;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class L2_CustomListViewUsingArrayAdapter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l2_custom_list_view_using_array_adapter);

        ArrayList<ListItems> myList = new ArrayList<>();
        myList.add(new ListItems(R.drawable.ic_launcher_background, "Apple"));
        myList.add(new ListItems(R.drawable.ic_launcher_background, "Banana"));
        myList.add(new ListItems(R.drawable.ic_launcher_background, "Pear"));
        myList.add(new ListItems(R.drawable.ic_launcher_background, "Orange"));

        CustomAdapterUsingAA ca = new CustomAdapterUsingAA(L2_CustomListViewUsingArrayAdapter.this, myList);

        ListView lv = findViewById(R.id.customListView2);

        lv.setAdapter(ca);

    }
}