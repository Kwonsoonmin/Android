package com.example.quickcoding01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

class MyValues {
    public String getResult(String a, String b, String c, String d ,String e, String f, String g, String h){
        String s = a+" "+b+" "+c+" "+d+" "+e+" "+f+" "+g+" "+h+" ";

        return s;
    }
}

class MyMinimum extends MyValues{
    public String getResult(int[] arr){
        int min = arr[0];

        for(int i = 0; i < arr.length; i++){
            if(min > arr[i])
                min = arr[i];
        }

        String r = String.valueOf(min);

        return r;
    }
}

class MyAverage extends MyValues{
    public String getResult(int[] arr){
        int sum = 0;

        for(int i = 0; i< arr.length; i++){
            sum += arr[i];
        }

        int average = (sum / arr.length);

        String a = String.valueOf(average);

        return a;
    }
}

public class QuickCoding01 extends AppCompatActivity {
    TextView array, result, change, numbers;
    Button min, avg, show;
    RelativeLayout layout;

    private int[] array1 = new int[8];
    private String a,b,c,d,e,f,g,h;
    private String r1;
    private String r2;
    private String r3;
    MyValues mv = new MyValues();
    MyMinimum mm = new MyMinimum();
    MyAverage ma = new MyAverage();

    public void random() {
        int k;
        for (int i = 0; i < 8; i++) {
            k = (int) (Math.random() * 100 + 1);
            array1[i] = k;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_coding01);

        array = (TextView) findViewById(R.id.array);
        result = (TextView) findViewById(R.id.result);
        change = (TextView) findViewById(R.id.update);
        numbers = (TextView) findViewById(R.id.numbers);

        min = (Button) findViewById(R.id.minimum);
        avg = (Button) findViewById(R.id.average);
        show = (Button) findViewById(R.id.show);

        layout = (RelativeLayout) findViewById(R.id.lay);

        random();

        a = String.valueOf(array1[0]);
        b = String.valueOf(array1[1]);
        c = String.valueOf(array1[2]);
        d = String.valueOf(array1[3]);
        e = String.valueOf(array1[4]);
        f = String.valueOf(array1[5]);
        g = String.valueOf(array1[6]);
        h = String.valueOf(array1[7]);

        r1 = mv.getResult(a,b,c,d,e,f,g,h);
        r2 = mm.getResult(array1);
        r3 = ma.getResult(array1);

        min.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(QuickCoding01.this, "버튼을 눌렀습니다.", Toast.LENGTH_SHORT).show();
                change.setText(r2);
            }
        });

        avg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(QuickCoding01.this, "버튼을 눌렀습니다.", Toast.LENGTH_SHORT).show();
                change.setText(r3);
            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(QuickCoding01.this, "버튼을 눌렀습니다.", Toast.LENGTH_SHORT).show();
                numbers.setText(r1);
            }
        });
    }
}
