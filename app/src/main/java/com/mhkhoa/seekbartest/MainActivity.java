package com.mhkhoa.seekbartest;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    SeekBar sb1,sb2;
    Button btn1;
    int current = 1;
    int current1 =1 ;
    CheckBox cb1,cb2;
    CountDownTimer timer,timer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sb1 = (SeekBar) findViewById(R.id.seekBar);
        sb2 = (SeekBar) findViewById(R.id.seekBar1);
        cb1 = (CheckBox) findViewById(R.id.checkbox1);
        cb2 = (CheckBox) findViewById(R.id.checkbox2);
        btn1 = (Button) findViewById(R.id.button);
        sb1.setMax(100); sb2.setMax(100);
        Random random = new Random();
        timer = new CountDownTimer(100000,100) {
            @Override
            public void onTick(long millisUntilFinished) {
                sb1.setProgress(current);
                Random random = new Random();
                current += random.nextInt(4);
                if(sb1.getProgress() == 100 ){
                    timer2.cancel();
                    timer.cancel();
                    if(cb1.isChecked() == true ){
                        Toast.makeText(MainActivity.this, "Chọn đúng r", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Sai cmnr", Toast.LENGTH_SHORT).show();
                    }
                }
;            }
            @Override
            public void onFinish() {

            }
        };
        timer2 = new CountDownTimer(100000,100) {
            @Override
            public void onTick(long millisUntilFinished) {
                sb2.setProgress(current1);
                Random random = new Random();
                current1 += random.nextInt(4);
                if(sb2.getProgress() == 100){
                    timer.cancel();
                    timer2.cancel();
                    if(cb2.isChecked() == true ){
                        Toast.makeText(MainActivity.this, "Chọn đúng r", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Sai cmnr", Toast.LENGTH_SHORT).show();
                    }
                }
            }
            @Override
            public void onFinish() {

            }
        };
        cb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.start();
                timer2.start();
            }
        });
        cb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.start();
                timer2.start();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sb1.setProgress(0);
                sb2.setProgress(0);
                current1 = 1;
                current = 1;
                if(cb1.isChecked() == true ){
                    cb1.toggle();
                }
                if(cb2.isChecked() == true){
                    cb2.toggle();
                }
            }
        });
    }


}
