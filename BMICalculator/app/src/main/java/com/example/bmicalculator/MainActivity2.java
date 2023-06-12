package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private TextView tv;
    private int value;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv = findViewById(R.id.textView);

        value = getIntent().getExtras().getInt("key");
       // String st=Integer.toString(s1);
        showAns();

       // Toast.makeText(this,st,Toast.LENGTH_SHORT).show();


    }

    public  void showAns(){
        String str = Integer.toString(value);
        if(value<=18.5){
            tv.setText("আপনার ওজন কম \n"+"Your Current BMI = "+str);

        }
        else if(value>18.5 && value<=25){
            tv.setText("আপনি সুস্থ আপনি নরমাল\n"+"Your Current BMI = "+str);
        }
        else if(value<=29 && value>25){
            tv.setText("আপনার ওজন বেশি\n"+"Your Current BMI = "+str);
        }
        else if(value>29 ){
            tv.setText("আপনার ওজন অতিরিক্ত বেশি\n"+"Your Current BMI = "+str);
        }
    }
}