package com.example.a1k9s9_000.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class mp_hw1 extends AppCompatActivity {
    Button Btn_1,Btn_2,Btn_3;
    TextView Change;
    RelativeLayout R_Layout;
    private String a = "Button_1!";
    private String b = "Button_2!";
    private String c = "Button_3!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp_hw1);

        Btn_1 = (Button) findViewById(R.id.Btn_1);
        Btn_2 = (Button) findViewById(R.id.Btn_2);
        Btn_3 = (Button) findViewById(R.id.Btn_3);
        Change = (TextView) findViewById(R.id.Change);

        Btn_1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(mp_hw1.this, "첫번째 버튼을 눌렀습니다.", Toast.LENGTH_SHORT).show();
                Change.setText(a);
            }
        });

        Btn_2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(mp_hw1.this, "두번째 버튼을 눌렀습니다.", Toast.LENGTH_SHORT).show();
                Change.setText(b);
            }
        });

        Btn_3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(mp_hw1.this, "세번째 버튼을 눌렀습니다.", Toast.LENGTH_SHORT).show();
                Change.setText(c);
            }
        });
    }
}
