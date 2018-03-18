package com.lesson4.android.rifyandaru_1202150088_modul4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ListNama(View view) {
        Intent list = new Intent(MainActivity.this, ListNama.class);
        startActivity(list);

    }

    public void PencariGambar(View view) {
        Intent gambar = new Intent(MainActivity.this, Gambar.class);
        startActivity(gambar);
    }
}
