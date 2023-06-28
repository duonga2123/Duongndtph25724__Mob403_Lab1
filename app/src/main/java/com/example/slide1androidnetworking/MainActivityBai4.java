package com.example.slide1androidnetworking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivityBai4 extends AppCompatActivity implements View.OnClickListener {
     EditText edtTime;
     Button btnRun;
     TextView Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bai4);
        edtTime = findViewById(R.id.edt);
        Result = findViewById(R.id.tvRs);
        btnRun = findViewById(R.id.btn);
        btnRun.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Bai4 bai4 = new Bai4(this, Result, edtTime);
        String sleepTime = edtTime.getText().toString();
        bai4.execute(sleepTime);
    }
}
