package com.example.quickcoding03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class QuickCoding03 extends AppCompatActivity {
    RelativeLayout relativeLayout;
    TextView deposit, withdraw, deposit_v, withdraw_v;
    Button show;
    int bankaccount_balance1=100;
    int bankaccount_balance2=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_coding03);

        relativeLayout = (RelativeLayout)findViewById(R.id.relativelayout);
        deposit = (TextView)findViewById(R.id.deposit);
        withdraw = (TextView)findViewById(R.id.withdraw);
        deposit_v = (TextView)findViewById(R.id.depositvalue);
        withdraw_v = (TextView)findViewById(R.id.withdrawvalue);
        show = (Button)findViewById(R.id.show);

        depositvalue de_v = new depositvalue();
        de_v.setDaemon(true);
        de_v.start();

        withdrawvalue wi_v = new withdrawvalue();
        wi_v.setDaemon(true);
        wi_v.start();

        show.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                deposit_v.setText(String.valueOf(bankaccount_balance1));
                withdraw_v.setText(String.valueOf(bankaccount_balance2));
            }
        });
    }

    class withdrawvalue extends Thread { // Withdraw Thread
        public void run() {
            while(true) {
                bankaccount_balance2 -=10;
                try{
                    Thread.sleep(8000);
                }catch(InterruptedException e){

                }
            }
        }
    }

    class depositvalue extends Thread{ // Deposit Thread
        public void run() {
            while(true) {
                bankaccount_balance1 +=10;
                try{
                    Thread.sleep(2000);
                }catch(InterruptedException e){

                }
            }
        }
    }
}
