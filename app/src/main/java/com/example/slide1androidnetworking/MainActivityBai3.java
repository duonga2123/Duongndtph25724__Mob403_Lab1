package com.example.slide1androidnetworking;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivityBai3 extends AppCompatActivity implements View.OnClickListener, Listener {

    private ImageView img;
    private Button btnLoad;
    ProgressDialog progressDialog;
    private static final String url = "https://upload.wikimedia.org/wikipedia/commons/2/20/FPT_Polytechnic.png";

    private TextView tvMess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bai3);
        img = findViewById(R.id.img);
        btnLoad = (Button) findViewById(R.id.btnLoad);
        tvMess = findViewById(R.id.message);
        btnLoad.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        new Bai3(this, this).execute(url);
    }

    @Override
    public void onImageLoaded(Bitmap bitmap) {
        img.setImageBitmap(bitmap);
        tvMess.setText("Image Downloaded");
    }

    @Override
    public void onError() {
        tvMess.setText("Error Download image");
    }




}