package com.example.android_lectures;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    Context context;
    ListItems[] listItems;
    LayoutInflater inflater;

    public CustomAdapter(Context context, ListItems[] listItems) {
        this.context = context;
        this.listItems = listItems;
    }

    @Override
    public int getCount() {
        return listItems.length;
    }

    @Override
    public ListItems getItem(int i) {
        return listItems[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (view == null) {
            view = inflater.inflate(R.layout.custom_list_item, null);
            TextView textView = view.findViewById(R.id.customListText);
            ImageView imageView = view.findViewById(R.id.customListImg);

            textView.setText(listItems[i].getText());
            imageView.setImageResource(listItems[i].getImage());
        }


        return view;
    }
}
