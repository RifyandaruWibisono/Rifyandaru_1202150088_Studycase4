package com.lesson4.android.rifyandaru_1202150088_modul4;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

public class ListNama extends AppCompatActivity {
    private String[] nama = {"Daru","Narto","Parto","Sule","Andre","Nunung","Aziz Gagap","Sasuke","Panji","Si","Petualangang","Ada", "Di", "Global TV"};
    ListView listView;
    private ProgressBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_nama);
        listView = (ListView) findViewById(R.id.list_view);
        bar =(ProgressBar) findViewById(R.id.progressbar);
        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,new ArrayList<String>()));

    }

    class AsyntaskNama extends AsyncTask<Void, String , Void> {

        ProgressDialog dialog;
        ArrayAdapter<String> adapter;
        int count=1;
        boolean running;

        @Override
        protected void onPreExecute() {
            running = true;
            adapter=(ArrayAdapter<String>)listView.getAdapter();
            dialog = new ProgressDialog(ListNama.this);
            dialog.setTitle("Loading Data");
            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dialog.setProgress(0);
            dialog.setCancelable(false);
            dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialog.dismiss();
                    AsyntaskNama.this.cancel(true);
                }
            });
//            count = 0;
            dialog.show();

        }

        @Override
        protected Void doInBackground(Void... params) {
            for (String Nama : nama){

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(Nama);
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            adapter.add((values[0]));
            Integer status = (int) ((count / (float) nama.length) * 100);
            bar.setProgress(status);
            dialog.setProgress(count);
            dialog.setMessage((values[0]));
            dialog.setMessage(String.valueOf(status + "%"));
            count++;

        }



        @Override
        protected void onPostExecute(Void result) {
            dialog.dismiss();
            bar.setVisibility(View.GONE);
        }
    }


    public void start(View view) {
        new AsyntaskNama().execute();
    }
}
