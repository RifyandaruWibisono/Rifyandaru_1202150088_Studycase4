package com.lesson4.android.rifyandaru_1202150088_modul4;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class Gambar extends AppCompatActivity {

    private ImageView imageView;
    private Button button;
    private EditText eText;
    private String Linkgambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gambar);
        imageView = (ImageView) findViewById(R.id.images);
        button = (Button) findViewById(R.id.buttton_gambar);
        eText = (EditText) findViewById(R.id.gambar);
        button = (Button) findViewById(R.id.buttton_gambar);

    }

    public void onClick(View view) {
        Linkgambar = eText.getText().toString();
        Asynctaskgambar imageDownloader = new Asynctaskgambar();
        imageDownloader.execute(Linkgambar);
    }

    public class Asynctaskgambar extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            return params[0];
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            Picasso.get().load(Linkgambar).into(imageView);
        }
    }
}