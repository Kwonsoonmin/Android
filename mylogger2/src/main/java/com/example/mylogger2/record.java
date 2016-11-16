package com.example.mylogger2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by 1k9s9_000 on 2016-11-16.
 */
public class record extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recording);

        Intent intent = getIntent();
        final DataBase database = new DataBase(getApplicationContext(), "List_myevent.db",null,1);

        final TextView place = (TextView)findViewById(R.id.place);
        final TextView event = (TextView)findViewById(R.id.event);
        final EditText place_r = (EditText)findViewById(R.id.record_pla);
        final EditText event_r = (EditText)findViewById(R.id.record_eve);

        TextView lati = (TextView)findViewById(R.id.latitude);
        TextView lati_r = (TextView)findViewById(R.id.latitude_r);
        TextView longi = (TextView)findViewById(R.id.longitude);
        TextView longi_r = (TextView)findViewById(R.id.longitude_r);

        Button save = (Button)findViewById(R.id.send);

        final String lat_i_g = intent.getStringExtra("lat");
        final String longi_i_g = intent.getStringExtra("long");

        lati_r.setText(lat_i_g);
        longi_r.setText(longi_i_g);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(record.this, "Success Save!", Toast.LENGTH_SHORT).show();

                String p = place_r.getText().toString();
                String e = event_r.getText().toString();
                database.insert(p,e,lat_i_g,longi_i_g);
            }
        });

    }
}
