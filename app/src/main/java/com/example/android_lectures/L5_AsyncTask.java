package com.example.android_lectures;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

public class L5_AsyncTask extends AppCompatActivity {
    ProgressBar pb;
    ListView lv;
    String [] ar = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    ArrayList<String> al;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);

        pb = findViewById(R.id.progressBar3);
        lv = findViewById(R.id.asyncTaskListView);

        al = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, al);
        lv.setAdapter(adapter);
        new MyTask().execute();

    }

    class MyTask extends AsyncTask<Void, Integer, String>
    {
        int count;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pb.setMax(10);
            pb.setProgress(0);
            pb.setVisibility(View.VISIBLE);
            count = 0;

        }

        @Override
        protected String doInBackground(Void... voids) {
            for (int i = 0; i < 10; i++) {

                publishProgress(i);

                try {
                    al.add(ar[i]);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            return "Completed";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
//            super.onProgressUpdate(values);

            pb.setProgress(values[0]);



        }

        @Override
        protected void onPostExecute(String s) {
//            super.onPostExecute(s);

            Toast.makeText(L5_AsyncTask.this, s, Toast.LENGTH_SHORT).show();
            adapter.notifyDataSetChanged();
            pb.setVisibility(View.INVISIBLE);
        }
    }

}