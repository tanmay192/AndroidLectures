package com.example.android_lectures;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class L6_FileDownloadOnBackgroundAsyncTask extends AppCompatActivity {
    ImageView imageView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l6_file_download_on_background_async_task);

        imageView = findViewById(R.id.downloaded_img);
        button = findViewById(R.id.download_btn);

        button.setOnClickListener(view -> new DownloadImage()
                .execute("https://pe-images.s3.amazonaws.com/basics/cc/image-size-resolution/resize-images-for-print/image-cropped-8x10.jpg"));

    }

    class DownloadImage extends AsyncTask<String, String, Bitmap> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            ProgressDialog dialog = new ProgressDialog(L6_FileDownloadOnBackgroundAsyncTask.this);
            dialog.setMessage("Your File is downloading. Please wait ...");
            dialog.setCancelable(false);
            dialog.show();

        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            Bitmap img = null;
            try {
                URL ImageUrl = new URL(strings[0]);
                HttpURLConnection connection = (HttpURLConnection) ImageUrl.openConnection();
                connection.setDoInput(true);
                connection.connect();

                InputStream in = connection.getInputStream();

                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                img = BitmapFactory.decodeStream(in, null, options);

            } catch (IOException e) {
                e.printStackTrace();
            }

            return img;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
//            super.onProgressUpdate(values);

        }
    }
}

