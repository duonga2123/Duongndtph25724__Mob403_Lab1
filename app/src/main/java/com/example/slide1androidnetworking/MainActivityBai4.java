package com.example.slide1androidnetworking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivityBai4 extends AppCompatActivity implements View.OnClickListener {
    private EditText edtTime;
    private Button btnRun;
     TextView Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bai4);
        edtTime = (EditText) findViewById(R.id.edt);
        Result = findViewById(R.id.tvRs);
        btnRun = (Button) findViewById(R.id.btn);
        btnRun.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }
}
