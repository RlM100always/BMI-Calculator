package com.example.bmicalculator;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   private EditText height_feet,height_inch ,weight ;
   private Button press ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        height_feet = findViewById(R.id.editTextId);
        height_inch = findViewById(R.id.editTextId2);
        weight = findViewById(R.id.editTextId3);
        press = findViewById(R.id.button);


        press.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bmiCalc();
            }
        });
    }

    public void bmiCalc(){
        String s1 = height_feet.getText().toString();
        String s2 = height_inch.getText().toString();
        String s3 = weight.getText().toString();
        double h=0, h1=0,h2=0,w=0,finalAns = 0;

        try {
            h1 = Double.parseDouble(s1);
            h2 = Double.parseDouble(s2);
            w = Double.parseDouble(s3);
            h = (h1 * 0.3048) +( 0.0254 * h2);
            finalAns=w/(h*h);
            //Toast.makeText(getApplicationContext(), "valid Number "+h1+" "+h2+" "+w+" "+h, Toast.LENGTH_SHORT).show();

        } catch (NumberFormatException e) {
            Toast.makeText(getApplicationContext(), "Please fillup All the data ",Toast.LENGTH_SHORT).show();
        }

//        if(finalAns==0){
//            Toast.makeText(getApplicationContext(), "Please fillup All the data "+w, Toast.LENGTH_SHORT).show();
//        }

         if(finalAns>0 && finalAns <=17){
            Intent obj = new Intent(MainActivity.this,MainActivity2.class);
            obj.putExtra("key",(int)finalAns);
           // obj.putExtra("key","Your Current BMI "+finalAns);
            startActivity(obj);
            //Toast.makeText(MainActivity.this, "আপনার ওজন কম  "+"BMI = "+(int)finalAns, Toast.LENGTH_SHORT).show();
        }
        else if(finalAns>17 && finalAns<=25){
            Intent obj = new Intent(MainActivity.this,MainActivity2.class);
            obj.putExtra("key",(int)finalAns);
            startActivity(obj);
           // Toast.makeText(MainActivity.this, "আপনি সুস্থ আপনি নরমাল "+"BMI = "+(int)finalAns, Toast.LENGTH_SHORT).show();
        }
        else if(finalAns>25 && finalAns<40 ){
            Intent obj = new Intent(MainActivity.this,MainActivity2.class);
            obj.putExtra("key",(int)finalAns);
            startActivity(obj);
           // Toast.makeText(MainActivity.this, "আপনার ওজন বেশি "+"BMI = "+(int)finalAns, Toast.LENGTH_SHORT).show();
        }
        else if(finalAns>=40 ){
            Intent obj = new Intent(MainActivity.this,MainActivity2.class);
            obj.putExtra("key",(int)finalAns);
            startActivity(obj);
            // Toast.makeText(MainActivity.this, "আপনার ওজন বেশি "+"BMI = "+(int)finalAns, Toast.LENGTH_SHORT).show();
        }
    }
}