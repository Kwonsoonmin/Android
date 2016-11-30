package com.example.eventhandler;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class EventHandler extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_handler);
    }

    public boolean onTouchEvent(MotionEvent me) {
        if(me.getAction() == MotionEvent.ACTION_DOWN) {
            Toast.makeText(EventHandler.this, " 화면를 터치했습니다.", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if(me.getAction() == MotionEvent.ACTION_UP) {
            Toast.makeText(EventHandler.this, "화면에서 손을 뗐습니다.", Toast.LENGTH_SHORT).show();
            return true;
        }
        else
            return false;
    }
}
