package com.example.admin.animalscrossing;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView txtDiem;
    CheckBox cb1,cb2,cb3;
    SeekBar sb1,sb2,sb3;
    ImageButton buttonPlay;
    int soDiem =100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();

        sb1.setEnabled(false);
        sb2.setEnabled(false);
        sb3.setEnabled(false);

        txtDiem.setText(soDiem+"");
        final CountDownTimer countDownTimer = new CountDownTimer(60000,300) {
            @Override
            public void onTick(long millisUntilFinished) {
                int number =5;
                Random rd = new Random();

                int so1 = rd.nextInt(number);
                int so2 = rd.nextInt(number);
                int so3 = rd.nextInt(number);

                if(sb1.getProgress()>= sb1.getMax()){
                    this.cancel();
                    buttonPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Gà đã thắng", Toast.LENGTH_SHORT).show();
                    //kiểm tra đặt cược
                    if (cb1.isChecked()) {
                        soDiem += 10;
                        Toast.makeText(MainActivity.this, "Bạn đoán chính xác +10 điểm", Toast.LENGTH_SHORT).show();
                    } else {
                        soDiem -=10;
                        Toast.makeText(MainActivity.this, "Bạn đoán sai -10 điểm", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(soDiem+ "");
                    choTuongTac();
                }
                if(sb2.getProgress()>= sb2.getMax()){
                    this.cancel();
                    buttonPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Lợn đã thắng", Toast.LENGTH_SHORT).show();
                    if (cb2.isChecked()) {
                        soDiem += 10;
                        Toast.makeText(MainActivity.this, "Bạn đoán chính xác +10 điểm", Toast.LENGTH_SHORT).show();
                    } else {
                        soDiem -=10;
                        Toast.makeText(MainActivity.this, "Bạn đoán sai -10 điểm", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(soDiem+ "");
                    choTuongTac();
                }
                if(sb3.getProgress()>= sb3.getMax()){
                    this.cancel();
                    buttonPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Rùa đã thắng", Toast.LENGTH_SHORT).show();
                    if (cb3.isChecked()) {
                        soDiem += 10;
                        Toast.makeText(MainActivity.this, "Bạn đoán chính xác +10 điểm", Toast.LENGTH_SHORT).show();
                    } else {
                        soDiem -=10;
                        Toast.makeText(MainActivity.this, "Bạn đoán sai -10 điểm", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(soDiem+ "");
                    choTuongTac();
                }

                sb1.setProgress(sb1.getProgress()+so1);
                sb2.setProgress(sb2.getProgress()+so2);
                sb3.setProgress(sb3.getProgress()+so3);
            }

            @Override
            public void onFinish() {

            }
        };

        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cb1.isChecked() || cb2.isChecked() || cb3.isChecked()) {
                    sb1.setProgress(0);
                    sb2.setProgress(0);
                    sb3.setProgress(0);

                    buttonPlay.setVisibility(View.INVISIBLE);
                    countDownTimer.start();

                    kChoTuongTac();
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng đặt cược trước khi chơi!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    cb2.setChecked(false);
                    cb3.setChecked(false);
                }
            }
        });
        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    cb1.setChecked(false);
                    cb3.setChecked(false);
                }
            }
        });
        cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    cb1.setChecked(false);
                    cb2.setChecked(false);
                }
            }
        });
    }

    private void choTuongTac(){
        cb1.setEnabled(true);
        cb2.setEnabled(true);
        cb3.setEnabled(true);
    }

    private void kChoTuongTac(){
        cb1.setEnabled(false);
        cb2.setEnabled(false);
        cb3.setEnabled(false);
    }

    private void anhXa(){
        txtDiem    = (TextView) findViewById(R.id.txtDiemSo);
        buttonPlay = (ImageButton) findViewById(R.id.imgButtonPlay);
        cb1        = (CheckBox) findViewById(R.id.cb1);
        cb2        = (CheckBox) findViewById(R.id.cb2);
        cb3        = (CheckBox) findViewById(R.id.cb3);
        sb1        = (SeekBar) findViewById(R.id.sb1);
        sb2       = (SeekBar) findViewById(R.id.sb2);
        sb3        = (SeekBar) findViewById(R.id.sb3);
    }
}
