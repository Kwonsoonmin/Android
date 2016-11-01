package com.example.quickcoding02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

class BinarySearch{
    int first = 1;
    int last = 500;
    int Now;
    String Now_num;

    // Use BinarySearch Algorithm -> divide 2 until Now_num == My Number
    public String dividing(int a, int b){
        int divide_2 = (a + b) / 2;

        this.Now_num = String.valueOf(divide_2);
        return Now_num;
    }

    // First Time - Give Middle Num On "Your Number is" And Give My Number On "My Number is"(Case: Clicked Send Button)
    public String sending(){
        int middle = (this.first+this.last)/2;
        this.Now_num = String.valueOf(middle);

        return this.Now_num;
    }

    // Case: Clicked Bigger Button
    public String Big(){
        this.first = Integer.parseInt(this.Now_num);
        this.Now_num = dividing(Integer.parseInt(Now_num), this.last);

        return this.Now_num;
    }

    // Case: Clicked Smaller Button
    public String Small(){
        this.last = Integer.parseInt(this.Now_num);
        this.Now_num = dividing(this.first, Integer.parseInt(Now_num));

        return this.Now_num;
    }
}

public class QuickCoding02 extends AppCompatActivity {

    TextView question, computer,send_num,count,c_num,show, mynum;
    EditText numbers;
    Button bigger, smaller, bingo,send;
    RelativeLayout relativelayout;

    private String c_s; // For setText()
    private int count_try  = 0; // Attempt of times.
    private String b_s,s_s,sd_s; // For setText()

    BinarySearch bs = new BinarySearch() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_coding02);

        // TextView
        question = (TextView) findViewById(R.id.question);
        computer = (TextView) findViewById(R.id.computer);
        send_num = (TextView) findViewById(R.id.send_num);
        count = (TextView) findViewById(R.id.count);
        c_num = (TextView) findViewById(R.id.c_num);
        show = (TextView) findViewById(R.id.ShowMyNum);
        mynum = (TextView) findViewById(R.id.MyNum);

        // EditText
        numbers = (EditText) findViewById(R.id.numbers);

        // Button
        bigger = (Button) findViewById(R.id.bigger);
        smaller = (Button) findViewById(R.id.smaller);
        bingo = (Button) findViewById(R.id.bingo);
        send = (Button) findViewById(R.id.send);

        // RelativeLayout
        relativelayout = (RelativeLayout) findViewById(R.id.relative);

        // Send Button's ClickListener
        send.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(QuickCoding02.this, "Send 버튼을 눌렀습니다.", Toast.LENGTH_SHORT).show();
                mynum.setText(numbers.getText().toString()); // Show My Number
                sd_s = bs.sending();
                send_num.setText(sd_s);
            }
        });

        // Bigger Button's ClickListener
        bigger.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(QuickCoding02.this, "Bigger 버튼을 눌렀습니다.", Toast.LENGTH_SHORT).show();
                count_try++;
                b_s = bs.Big();
                send_num.setText(b_s);
            }
        });

        // Smaller Button's ClickListener
        smaller.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(QuickCoding02.this, "Smaller 버튼을 눌렀습니다.", Toast.LENGTH_SHORT).show();
                count_try++;
                s_s = bs.Small();
                send_num.setText(s_s);
            }
        });

        // Bingo Button's ClickListener
        bingo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(QuickCoding02.this, "Bingo 버튼을 눌렀습니다.", Toast.LENGTH_SHORT).show();
                c_s = String.valueOf(count_try);
                c_num.setText(c_s);
            }
        });
    }
}

