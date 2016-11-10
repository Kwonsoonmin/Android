package com.example.quickcoding04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

public class QuickCoding04 extends AppCompatActivity {
    TextView text1,showstring, stringlist, shownumber, numberlist;
    Button enter, complete;
    EditText entertext;
    private int count1 = 0;
    private int count2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_coding04);

        text1 = (TextView)findViewById(R.id.text1);
        showstring = (TextView)findViewById(R.id.showstring);
        stringlist = (TextView)findViewById(R.id.stringlist);
        shownumber = (TextView)findViewById(R.id.shownumber);
        numberlist = (TextView)findViewById(R.id.numberlist);

        enter = (Button)findViewById(R.id.enter);
        complete = (Button)findViewById(R.id.complete);

        entertext = (EditText)findViewById(R.id.entertext);

        final LinkedList<String> string_list = new LinkedList<String>();
        final LinkedList<Integer> number_list = new LinkedList<Integer>();

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String some = entertext.getText().toString();

                if(isStringInt(some) == true){
                    int i = Integer.parseInt(some);
                    number_list.add(i);
                    count1++;
                }

                else{
                    string_list.add(some);
                    count2++;
                }
                Toast.makeText(QuickCoding04.this, "입력되었습니다.", Toast.LENGTH_SHORT).show();
                entertext.setText(null);
            }
        });


        complete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String printstring = "";
                String l = "";
                String printInt = "";

                for(int j = 0; j < count1; j++){
                    if(j == count1-1)
                        printstring += string_list.get(j);
                    else
                        printstring += string_list.get(j)+", ";
                }

                for(int j = 0; j < count2; j++){
                    if(j == count2-1){
                        l = toString().valueOf(number_list.get(j));
                        printInt += l;
                    }
                    else {
                        l = toString().valueOf(number_list.get(j));
                        printInt += l + ", ";
                    }
                }
                stringlist.setText(printstring);
                numberlist.setText(printInt);
                Toast.makeText(QuickCoding04.this, "Complete!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static boolean isStringInt(String s){
        try{
            Integer.parseInt(s);
            return true;
        }catch (NumberFormatException ne){
            return false;
        }
    }
}
