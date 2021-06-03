package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class EResult extends AppCompatActivity {
    private TextView tv1,tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eresult);
        tv1 = (TextView) findViewById(R.id.tex);

        String score=getIntent().getStringExtra("SCore");
        tv1.setText(score);
//        int lk=Integer.parseInt(score);
//        if (lk<=2){
//            tv2.setText("a");
//        }else {
//            tv2.setText("b");
//        }


        Integer lkk=Integer.parseInt(tv1.getText().toString());
        if(lkk<6){
            tv2.setText("your are fail");
        }
        else {
            tv2.setText("your are pass");
        }





    }
}