package com.example.android_lectures;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomGridAdapter extends BaseAdapter {
    Context context;
    ArrayList<ListItems> listItemsArrayList;

    public CustomGridAdapter(Context context, ArrayList<ListItems> listItemsArrayList) {
        this.context = context;
        this.listItemsArrayList = listItemsArrayList;
    }

    @Override
    public int getCount() {
        return listItemsArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return listItemsArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view == null) {
            view = inflater.inflate(R.layout.custom_grid_item, null);
            TextView textView = view.findViewById(R.id.customGridTextView);
            ImageView imageView = view.findViewById(R.id.customGridImg);

            textView.setText(listItemsArrayList.get(i).getText());
            imageView.setImageResource(listItemsArrayList.get(i).getImage());
        }
        return view;
    }
}
