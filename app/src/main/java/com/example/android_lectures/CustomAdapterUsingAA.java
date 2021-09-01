package com.example.android_lectures;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapterUsingAA extends ArrayAdapter<ListItems> {
    Context context;
    ArrayList<ListItems> myList;

    public CustomAdapterUsingAA(@NonNull Context context, ArrayList<ListItems> objects) {
        super(context, 0, objects);
        myList = new ArrayList<>();
        this.context = context;
        this.myList = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.custom_list_item2, null);

            TextView textView = convertView.findViewById(R.id.textView1);

            ImageView imageView = convertView.findViewById(R.id.imageView1);
            textView.setText(myList.get(position).getText());

            imageView.setImageResource(myList.get(position).getImage());

            Button btn = convertView.findViewById(R.id.btn1);

            btn.setTag(position);
            btn.setOnClickListener(view -> {
                int pos = (Integer) view.getTag();

                Toast.makeText(context, "position deleted" + pos, Toast.LENGTH_SHORT).show();
                myList.remove(pos);
                notifyDataSetChanged();
            });
        }

        return convertView;

    }
}
