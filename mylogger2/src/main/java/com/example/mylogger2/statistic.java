package com.example.mylogger2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by 1k9s9_000 on 2016-11-16.
 */
public class statistic extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statisticfile);

        final DataBase database = new DataBase(getApplicationContext(), "List_myevent.db", null, 1);
        final TextView result = (TextView)findViewById(R.id.result);

        result.setText(database.getResult());
    }
}

