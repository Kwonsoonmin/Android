package com.example.mobile_hw2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class mp_hw2 extends AppCompatActivity {
    Button Btn_1, Btn_2, Btn_3;
    RelativeLayout layout;
    TextView text;

    private String f = "First!";
    private String s = "Second!";
    private String t = "Third!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp_hw2);

        Btn_1 = (Button) findViewById(R.id.First_B);
        Btn_2 = (Button) findViewById(R.id.Second_B);
        Btn_3 = (Button) findViewById(R.id.Third_B);
        text = (TextView) findViewById(R.id.textview);

        Btn_1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(mp_hw2.this, "버튼을 눌렀습니다.", Toast.LENGTH_SHORT).show();
                text.setText(f);
            }
        });

        Btn_2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(mp_hw2.this, "버튼을 눌렀습니다.", Toast.LENGTH_SHORT).show();
                text.setText(s);
            }
        });

        Btn_3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(mp_hw2.this, "버튼을 눌렀습니다.", Toast.LENGTH_SHORT).show();
                text.setText(t);
            }
        });
    }
}

